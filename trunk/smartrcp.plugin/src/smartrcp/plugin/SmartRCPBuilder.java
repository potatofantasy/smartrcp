package smartrcp.plugin;

import java.io.File;
import java.io.PrintWriter;

import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IPerspectiveListener;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.application.IWorkbenchConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

import cn.smartinvoke.IServiceObjectCreator;
import cn.smartinvoke.TypeMapper;
import cn.smartinvoke.gui.FlashViewer;
import cn.smartinvoke.gui.ObjectPool;
import cn.smartinvoke.rcp.CPageLayout;
import cn.smartinvoke.rcp.CPerspective;
import cn.smartinvoke.rcp.CWindowConfigurer;
import cn.smartinvoke.smartrcp.CApplication;
import cn.smartinvoke.smartrcp.DebugServer;
import cn.smartinvoke.smartrcp.gui.FlashViewPart;
import cn.smartinvoke.smartrcp.gui.SplashWindow;
import cn.smartinvoke.smartrcp.gui.control.EventFilter;
import cn.smartinvoke.smartrcp.gui.control.EventRegister;
import cn.smartinvoke.smartrcp.gui.control.FlashViewInvoker;
import cn.smartinvoke.smartrcp.gui.control.GlobalServiceId;
import cn.smartinvoke.util.ConfigerLoader;
import cn.smartinvoke.util.ImageManager;
import cn.smartinvoke.util.Log;

public class SmartRCPBuilder {
	private static SplashWindow splash_win = SplashWindow.INSTANCE;
	private SmartRCPBuilder() {
        
	}
	/**
	 * 初始化SmartRCP获得初始化信息
	 */
	public static void init(final BundleContext context){//IServiceObjectCreator objectCreator) {
	    
		//----------------------
		//加载配置信息
		try{
			ConfigerLoader.init();//加载配置文件
			CPerspective.init();//加载swf配置路径
			startBundles(context);//启动扩展库
		}catch(Exception e){
			throw new RuntimeException();
		};
	    
		// TODO 程序的初始化
		ObjectPool objectPool = ObjectPool.INSTANCE;
		//设置类加载机制
		objectPool.objectCreator = new IServiceObjectCreator(){

			public Class getClass(String clsName) throws ClassNotFoundException {
				Log.println("创建服务类"+clsName+"的对象");
				Class cls=null;
				Bundle[] bundles=context.getBundles();
				if(bundles!=null){
					for(int n=0;n<bundles.length;n++){
						Bundle bundle=bundles[n];
						try{
						  cls=bundle.loadClass(clsName);
						  break;
						}catch(ClassNotFoundException e){
						  
						}
					}
				}
				if(cls==null){
					throw new ClassNotFoundException(clsName);
				}
				return cls;
			}
 		};
 	    // ----------- 注册全局服务
		objectPool.putObject(new CApplication(), GlobalServiceId.Cur_Application);
		objectPool.putObject(new FlashViewInvoker(),GlobalServiceId.FlashView_Invoker);
		// 添加事件注册器服务
		EventRegister eventRegister = new EventRegister();
		objectPool.putObject(eventRegister, GlobalServiceId.Event_Register);
		
	}
	public static void startBundles(BundleContext context){
		 
		 String libPath=CPerspective.getRuntimeSwfFolder()+"/lib";
		 String logFile=CPerspective.getRuntimeSwfFolder()+"/log.txt";
		 PrintWriter logWriter=null;
		 File folder=new File(libPath);
		 if(!folder.exists()){
			 folder.mkdirs();
		 }
		 //加载插件
		 File[] bundleFiles=folder.listFiles();
		 if(bundleFiles!=null){
			 for(int i=0;i<bundleFiles.length;i++){
				 String path="file:"+bundleFiles[i].getAbsolutePath();
				 Log.println("load bundle:"+path);
				 try{
				  Bundle bundle=context.installBundle(path);
				  bundle.start();
				 }catch(Exception e){
				   //记录错误日志
				   if(logWriter==null){
					   File log=new File(logFile);
					   if(!log.exists()){
						  try{ log.createNewFile();}catch(Exception e1){};
					   }
					   try{logWriter=new PrintWriter(log);}catch(Exception e1){};
				   }
				   e.printStackTrace(logWriter); 
				 }
			 }
		 }
		 //关闭错误日志文件
		 if(logWriter!=null){
			 logWriter.flush();
			 logWriter.close();
		 }
	}
	/**
	 * 打开Splash窗口获得初始化信息，初始化窗体
	 */
	public static void initWindows(){
		// ------------加载配置信息
		// 将splash窗口设置为服务对象供flex调用
		ObjectPool.INSTANCE.putObject(splash_win, GlobalServiceId.Splash_Win);
		try {
			
			String servicePacks = ConfigerLoader
					.getProperty(ConfigerLoader.key_export_package);
			TypeMapper.addServiceConfig(servicePacks);
			
			// -----------开启splash窗口，加载flex的splash信息
			try {
				splash_win.open();
			} catch (Throwable e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
			;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}
	/**
	 * 初始化工作台配置
	 * @param configurer
	 */
	public static void initWorkbench(IWorkbenchConfigurer configurer){
		if(SplashWindow.getPerspective().saveAndRestore){
		  configurer.setSaveAndRestore(true);
		}else{
		  configurer.setSaveAndRestore(false);
		}
	}
	private static String key_workbench_state="smartrcp_key_workbench_state";
	private static String key_config_path="smartrcp_key_config_path";
	/**
	 * 保存工作台设置信息
	 * @param memento
	 */
	public static void saveWorkbenchState(IMemento memento){
		/*IViewReference[] refs=window.getActivePage().getViewReferences();
		StringBuilder viewPartInfo=new StringBuilder();
		if(refs!=null){
		 for(int n=0;n<refs.length;n++){
			 IViewReference ref=refs[n];
			 IWorkbenchPart part=ref.getPart(true);
			 if(part  instanceof ViewPart){
				 ViewPart viewPart=(ViewPart)part;
				 List<FlashViewer> flashViewers=FlashViewer.getViewers();
				 for(int i=0;i<flashViewers.size();i++){
					 FlashViewer flashViewer=flashViewers.get(i);
					 if(flashViewer.getParent().equals(viewPart)){
						 viewPartInfo.append(flashViewer.getAppId()).append("=")
						 .append(flashViewer.getModulePath()).append("\n");
						 break;
					 }
				 }
			 }
		 }
		}
		
		memento.putString(key_workbench_state, viewPartInfo.toString());
		//存储start.ini文件
		memento.putString(key_config_path, ConfigerLoader.configPath);*/
	}
	/**
	 * 恢复工作台设置信息
	 * @param memento
	 */
	public static void restoreWorkbenchState(IMemento memento){
		//加载start.ini文件
		ConfigerLoader.configPath=memento.getString(key_config_path);
		String val=memento.getString(key_workbench_state);
		if(val!=null){
			CPageLayout pageLayout=CPageLayout.Instance;
			String[] items=val.split("\n");
			if(items!=null){
				for(int n=0;n<items.length;n++){
					String item=items[n];
					int spl=item.indexOf("=");
					String appId=item.substring(0,spl);
					String modulePath=item.substring(spl+1);
					pageLayout.addViewPartInfo(modulePath, appId);
				}
			}
		}
	}
    /**
     * 初始化图像管理器
     * @param imageRegistry
     */
	public static void initImageRegistry(ImageRegistry imageRegistry) {
		// ---------加载图像注册信息
		ImageManager.init(imageRegistry);
	}

   
	public static void preWindowOpen(IWorkbenchWindowConfigurer configurer) {
		// TODO 将Display对象注册为全局服务对象，并且添加事件处理程序
		// System.out.println();
		Display curDisp = Display.getCurrent();
		ObjectPool.INSTANCE.putObject(curDisp, GlobalServiceId.Swt_Display);
		EventFilter.exeFilter(curDisp);
		
		if (configurer != null) {
			CPerspective cPerspective = SplashWindow.getPerspective();
			if (cPerspective != null) {
				CWindowConfigurer cWinConfig = cPerspective.windowConfigurer;
				configurer.setShellStyle(cWinConfig.shellStyle);
				configurer.setInitialSize(new Point(cWinConfig.shellWidth,
						cWinConfig.shellHeight));
				
				configurer.setShowPerspectiveBar(cWinConfig.showPerspectiveBar);
				configurer.setShowMenuBar(cWinConfig.showMenuBar);
				configurer.setShowCoolBar(cWinConfig.showCoolBar);
				configurer.setShowStatusLine(cWinConfig.showStatusLine);
			}
		}
		//添加透视图监听器
		configurer.getWindow().addPerspectiveListener(new IPerspectiveListener(){

			public void perspectiveActivated(IWorkbenchPage page,
					IPerspectiveDescriptor perspective) {
				IViewReference[] refs=page.getViewReferences();
			    
				page.addPartListener(new IPartListener2(){

					public void partActivated(IWorkbenchPartReference partRef) {
						
					}

					public void partBroughtToTop(IWorkbenchPartReference partRef) {
						
					}

					public void partClosed(IWorkbenchPartReference partRef) {
						
					}

					public void partDeactivated(IWorkbenchPartReference partRef) {
						
					}

					public void partHidden(IWorkbenchPartReference partRef) {
						
					}

					public void partInputChanged(IWorkbenchPartReference partRef) {
						
					}

					public void partOpened(IWorkbenchPartReference partRef) {
						IWorkbenchPart workbenchPart=partRef.getPart(true);
						//只对IViewPart进行管理
						if(!(workbenchPart instanceof IViewPart)){
						  return;
						}
						//非FlashViewPart视图，需要手动创建FlashViewer对象
					    if(!(workbenchPart instanceof FlashViewPart)){
							
						}else{
							 IViewPart viewPart=(IViewPart)workbenchPart;
							 //将当前打开的viewPart的信息添加进模块对应表中	
							 FlashViewer flashViewer=FlashViewer.getViewerByParent(viewPart);//视图对应的FlashViewer对象
							 if(flashViewer!=null){
								 CPageLayout.Instance.addViewPartInfo(flashViewer.getModulePath(), flashViewer.getAppId());
							 }
					    }
					}

					public void partVisible(IWorkbenchPartReference partRef) {
						
					}
					
				});
				
				
			}

			public void perspectiveChanged(IWorkbenchPage page,
					IPerspectiveDescriptor perspective, String changeId) {
				
			}
           
        });
	}
    public static Shell Main_Shell=null;
	/**public static void postWindowOpen(Shell shell) {
		if(shell!=null){
		  Main_Shell=shell;
		}else{
		  shell=Main_Shell;
		}
		
		ObjectPool.INSTANCE.putObject(shell, GlobalServiceId.Swt_Main_Win);
		CPerspective cPerspective = SplashWindow.getPerspective();
		if (cPerspective != null) {
			CWindowConfigurer cWinConfig = cPerspective.windowConfigurer;
			shell.setText(cWinConfig.shellTitle);
			ImageDescriptor imageDescriptor=
				ImageManager.getImageDescriptor(cWinConfig.shellImage);
			if(imageDescriptor!=null){
				shell.setImage(imageDescriptor.createImage());
			}
			
		}
		// 全局服务 对象设置视图管理器
		ViewManager viewManager=new ViewManager();
		viewManager.initIWorkbenchPageListener(window.getActivePage());
		ObjectPool.INSTANCE.putObject(viewManager,
				GlobalServiceId.View_Manager);
		
		//Log.println("in postWindowOpen");
		//加载所有的flash
		List<FlashViewer> flashViewers=FlashViewer.getViewers();
		for(int n=0;n<flashViewers.size();n++){
			FlashViewer flashViewer=flashViewers.get(n);
			flashViewer.loadFlash();
		}
		openDebugServer();
		
	}*/
	
	/**
	 * 打开debug服务，接收flexBuilder的请求，如果已经打开就直接返回
	 */
	private static boolean isStart=false;
    private static void openDebugServer(){
      if(!isStart){
       String debugStr=ConfigerLoader.getProperty(ConfigerLoader.key_debug);
       if(debugStr!=null){
    	  debugStr=debugStr.trim();
    	  if(debugStr.equals("true")){
    			  DebugServer.start();
    	  }
       }
       isStart=true;
      }
    }
    
    public static void dispose(){
    	
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
          
	}

}
