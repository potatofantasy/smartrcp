package cn.smartinvoke.smartrcp.core;

import java.io.File;
import java.io.FileWriter;
import java.net.MalformedURLException;
import java.util.List;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.*;
import org.eclipse.ui.application.*;
import org.eclipse.ui.part.ViewPart;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;

import com.sun.corba.se.spi.orbutil.threadpool.Work;

import cn.smartinvoke.IServiceObjectCreator;
import cn.smartinvoke.ObjectPool;
import cn.smartinvoke.TypeFactory;
import cn.smartinvoke.TypeMapper;
import cn.smartinvoke.gui.FlashViewer;
import cn.smartinvoke.rcp.CMenuRelation;
import cn.smartinvoke.rcp.CPageLayout;
import cn.smartinvoke.rcp.CPerspective;
import cn.smartinvoke.rcp.CWindowConfigurer;
import cn.smartinvoke.rcp.ErrorMessages;
import cn.smartinvoke.smartrcp.CApplication;
import cn.smartinvoke.smartrcp.SmartRCPBundle;
import cn.smartinvoke.smartrcp.app.CAppService;
import cn.smartinvoke.smartrcp.app.pack.CAppInfo;
import cn.smartinvoke.smartrcp.app.pack.PackageTool;
import cn.smartinvoke.smartrcp.gui.*;
import cn.smartinvoke.smartrcp.gui.control.*;
import cn.smartinvoke.smartrcp.util.BundleHelpMethod;
import cn.smartinvoke.smartrcp.util.JFaceConstant;
import cn.smartinvoke.util.ConfigerLoader;
import cn.smartinvoke.util.HelpMethods;
import cn.smartinvoke.util.ImageManager;
import cn.smartinvoke.util.Log;

public class SmartRCPBuilder {
	private static SplashWindow splash_win = SplashWindow.INSTANCE;
   // private static SmartRCPWindowAdvisor window_Advisor=new SmartRCPWindowAdvisor();
	public static SmartRCPBuilder Instance=new SmartRCPBuilder();
	public SmartRCPBuilder(){
       
	}
	private static BundleContext context=null;
	public static BundleContext getCurContext(){
		return context;
	}
	/**
	 * 初始化SmartRCP获得初始化信息
	 */
	public  void init(final BundleContext context){//IServiceObjectCreator objectCreator) {
		//----------------------
		SmartRCPBuilder.context=context;
		//----------------------
		//加载配置信息
		try{
			ConfigerLoader.init();
			
	        //添加服务类
	        TypeMapper.addServicePack("org.eclipse.swt.widgets");
	        TypeMapper.addServicePack("org.eclipse.swt");
	        TypeMapper.addServicePack("java.io");
	        
			startBundles(context);//启动标准库
		}catch(Exception e){
			throw new RuntimeException();
		};
		ObjectPool objectPool = ObjectPool.INSTANCE;
		
		//注册对象池
	   	TypeFactory.Object_Pool=ObjectPool.INSTANCE;
		//设置类加载机制
		objectPool.objectCreator = new IServiceObjectCreator(){
			
			public Class getClass(String clsName) throws ClassNotFoundException {
				//Log.println("创建服务类"+clsName+"的对象");
				Class cls=null;
				try{
				 
				 cls=Class.forName(clsName);
				 return cls;
				}catch(Exception e){};
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
 		TypeFactory.objectCreator=objectPool.objectCreator;
 		TypeFactory.Type_Mapper=TypeMapper.Instance;
 		
 		 // ----------- 注册全局服务
 		//objectPool.putObject(new DbUtil(), GlobalServiceId.DB_Util);//数据库帮助方法
		objectPool.putObject(CApplication.Instance, GlobalServiceId.Cur_Application);
		objectPool.putObject(new FlashViewInvoker(),GlobalServiceId.FlashView_Invoker);
		// 添加事件注册器服务
		EventRegister eventRegister = new EventRegister();
		objectPool.putObject(eventRegister, GlobalServiceId.Event_Register);
		
		ViewManager viewManager=ViewManager.Instance;
		ObjectPool.INSTANCE.putObject(viewManager,
				GlobalServiceId.View_Manager);
	}
	protected  void startBundles(BundleContext context){
		 //加载标准库
		 String libPath=HelpMethods.getPluginFolder()+"/lib";
		 startBundles(libPath);
		 libPath=HelpMethods.getPluginFolder()+"/ext";
		 //加载扩展库
		 startBundles(libPath);
	}
	
	private void startBundles(String libPath){
		Log.println("加载"+libPath+"中的库");
		 //PrintWriter logWriter=null;
		 File folder=new File(libPath);
		 if(!folder.exists()){
			 folder.mkdirs();
		 }
		 //加载标准库插件
		 try{
		   CApplication.setStandardBundles(BundleHelpMethod.installBundles(folder));
		 }catch(BundleException e){
			 throw new RuntimeException(e);
		 }
	}
	/**
	 * 打开Splash窗口获得初始化信息，初始化窗体
	 */
	public  void initWindows(){
		// ------------加载配置信息
		// 将splash窗口设置为服务对象供flex调用
		ObjectPool.INSTANCE.putObject(splash_win, GlobalServiceId.Splash_Win);
		//加载当前smartrcp bundle
		//TODO 当前的smartrcp bundle应该
		/*try {
//			CAppInfo appInfo=CAppService.getAppInfo(ConfigerLoader.appPath);
//			SmartRCPBundle rcpBundle=new SmartRCPBundle(appInfo);
//			rcpBundle.load();
//			CApplication.setCurApp(rcpBundle);
			//加载图片资源
			//ImageManager.loadImages(ConfigerLoader.appPath);
		}catch(BundleException e1){
			MessageDialog.openError(splash_win.shell, "", ErrorMessages.Bundle_Load_Error+e1.getMessage());
		}catch(MalformedURLException e){
			MessageDialog.openError(splash_win.shell, "", ErrorMessages.Image_Load_Error+e.getMessage());
			e.printStackTrace();
		}*/
		try {
			// -----------开启splash窗口，加载flex的splash信息
			try {
				splash_win.open();
			}catch(Throwable e){
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
	public  void initWorkbench(IWorkbenchConfigurer configurer){
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
	public  void saveWorkbenchState(IMemento memento){
		IViewReference[] refs=window.getActivePage().getViewReferences();
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
		memento.putString(key_config_path, ConfigerLoader.configPath);
	}
	/**
	 * 恢复工作台设置信息
	 * @param memento
	 */
	public  void restoreWorkbenchState(IMemento memento){
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
	public  void initImageRegistry(ImageRegistry imageRegistry) {
		// ---------加载图像注册信息
        Display curDisp=Display.getCurrent();
		ObjectPool.INSTANCE.putObject(curDisp, GlobalServiceId.Swt_Display);
		ImageManager.init(imageRegistry);
	}

	public  CActionManager actionManager = null;
	private  ActionBarAdvisor actionBarAdvisor;
    public  IWorkbenchWindow window;
	/**
	 * 创建action
	 */
	public  void createActions(ActionBarAdvisor actionBarAdvisor,IWorkbenchWindow window){
		if(actionBarAdvisor!=null){
			this.actionBarAdvisor=actionBarAdvisor;
		}else{
			actionBarAdvisor=this.actionBarAdvisor;
		}
		if(window!=null){
		  this.window=window;
		}else{
		  window=this.window;
		}
		
		ObjectPool.INSTANCE.putObject(new CActionManager(actionBarAdvisor,window),
				GlobalServiceId.CAction_Manager);
		
		CPerspective cPerspective = SplashWindow.getPerspective();
		if (cPerspective != null) {
			Object[] actionArr = cPerspective.actions;
			if (actionArr != null) {
				ObjectPool objectPool = ObjectPool.INSTANCE;

				Object obj = objectPool
						.getObject(GlobalServiceId.CAction_Manager);
				if (obj != null) {
					actionManager = (CActionManager) obj;
					int len = actionArr.length;
					for (int i = 0; i < len; i++) {
						Object actionObj = actionArr[i];
						if (actionObj instanceof CAction) {
							actionManager.addAction((CAction) actionObj);
						}
					}
				}
			}
		}
	}
    private  IMenuManager MENU_BAR;
	/**
	 * 创建菜单
	 * 
	 * @param menuBar
	 */
	public  void fillMenuBar(IMenuManager menuBar) {
		if(menuBar!=null){//第一次启动
		  this.MENU_BAR=menuBar;
		}else{//第二次启动
		  menuBar=this.MENU_BAR;
		}
		
		CPerspective cPerspective = SplashWindow.getPerspective();
		if (cPerspective != null && actionManager != null) {
			
			Object[] menuBarObjs = cPerspective.menuBars;
			if (menuBarObjs != null) {
				for (int i = 0; i < menuBarObjs.length; i++) {
					Object obj = menuBarObjs[i];
					if (obj instanceof CMenuRelation) {
						CMenuRelation relation=(CMenuRelation)obj;
						if(relation.managerId==null){
							relation.managerId=relation.label;
						}
						String path=relation.managerId;
						fillMenuBar(menuBar,relation,relation.managerId,path);
					}
				}
			}
			//设置全局服务对象
			ObjectPool.INSTANCE.putObject(new CAppMenuBarManager(menuBar,actionManager), GlobalServiceId.App_MenuBar_Manager);
		}
	}

	private  void fillMenuBar(IMenuManager menuBar, CMenuRelation cMenuBar,String managerId,String pathStr) {
		if (cMenuBar == null) {
			return;
		}
		MenuManager menuManager = new MenuManager(cMenuBar.label,managerId);
		Object[] actions = cMenuBar.actions;
		if (actions != null) {
			for (int a = 0; a < actions.length; a++) {
				Object action = actions[a];
				if (action instanceof CMenuRelation) {
					CMenuRelation relation=(CMenuRelation) action;
					if(relation.managerId==null){
						   relation.managerId=relation.label;
					}
					String path=pathStr+"/"+relation.managerId;
					fillMenuBar(menuManager,relation,relation.managerId,path);
				} else if (action instanceof String) {
					String id = (String) action;
					if (id.equals(JFaceConstant.Menu_Separator_Str)) {
						menuManager.add(new Separator());
					} else {
						IAction actionImp = actionManager.getAction(id);
						if (actionImp != null) {
							//将此action在menu中的path作为description字段
							actionImp.setDescription(pathStr);
							menuManager.add(actionImp);
						}
					}
				}
			}// end for
			menuBar.add(menuManager);
		}
	}
	private  ICoolBarManager COOL_BAR=null;
    /**
     * 初始化工具栏
     * @param coolBar
     */
	public  CAppToolBarManager fillCoolBar(ICoolBarManager coolBar) {
		if(coolBar!=null){
			COOL_BAR=coolBar;
		}else{
			coolBar=COOL_BAR;
		}
		CAppToolBarManager toolBarManager=null;
		CPerspective cPerspective = SplashWindow.getPerspective();
		if (cPerspective != null && actionManager != null) {
			toolBarManager = new CAppToolBarManager(coolBar);
			// 添加到全局服务...
			ObjectPool.INSTANCE.putObject(toolBarManager,
					GlobalServiceId.App_ToolBar_Manager);
			toolBarManager.fillToolBar(cPerspective.toolBar);
		}
        return toolBarManager;
	}
	/**
	 * 初始化状态栏管理器
	 * @param statusLineManager
	 */
    public  void initStatusLine(IStatusLineManager statusLineManager){
    	CStatusLineManager lineManager=new CStatusLineManager(statusLineManager);
    	ObjectPool.INSTANCE.putObject(lineManager,GlobalServiceId.App_StatusLine_Manager);
    	
    }
    private IWorkbenchWindowConfigurer winConfigurer;
	public  void preWindowOpen(IWorkbenchWindowConfigurer configurer) {
		// TODO 将Display对象注册为全局服务对象，并且添加事件处理程序
		// System.out.println();
		this.winConfigurer=configurer;
		
		Display curDisp = Display.getCurrent();
		EventFilter.exeFilter(curDisp);
		
		if (configurer != null) {
			CPerspective cPerspective = SplashWindow.getPerspective();
			if (cPerspective != null){
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
		
	}
    public static Shell Main_Shell=null;
	public  void postWindowOpen(Shell shell) {
		if(shell!=null){
		  Main_Shell=shell;
		}else{
		  shell=Main_Shell;
		}
		//添加透视图监听器
		winConfigurer.getWindow().addPerspectiveListener(new IPerspectiveListener(){

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
								 flashViewer.loadFlash();
								 CPageLayout page= CPageLayout.Instance;
								 page.addViewPartInfo(flashViewer.getModulePath(), flashViewer.getAppId());
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
			if(cWinConfig.maximized){
				shell.setMaximized(true);
			}
		}
		// 全局服务 对象设置视图管理器
		ViewManager viewManager=ViewManager.Instance;
		IWorkbenchWindow window=this.window;
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
		
	}
    public  void dispose(){
    	//关闭所有视图
    	CPageLayout.Instance.close();
    	//清空全局缓存信息
    	CApplication application=(CApplication)
    	   ObjectPool.INSTANCE.getObject(GlobalServiceId.Cur_Application);
    	application.dispose();
    	
    	//清空actionManager
    	CActionManager actionManager=
    		(CActionManager)ObjectPool.INSTANCE.getObject(GlobalServiceId.CAction_Manager);
    	actionManager.dispose();
    	//清空菜单
    	CAppMenuBarManager menuBarManager=
    		(CAppMenuBarManager)ObjectPool.INSTANCE.getObject(GlobalServiceId.App_MenuBar_Manager);
    	menuBarManager.dispose();
    	//清空工具栏
    	CAppToolBarManager  toolBarManager=
    		(CAppToolBarManager)ObjectPool.INSTANCE.getObject(GlobalServiceId.App_ToolBar_Manager);
    	toolBarManager.dispose();
    	
    }
    /**
     * 程序布局系统
     * @param installFolder 程序的安装目录
     */
    public  void reStart(String installFolder){
    	
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
         
	}

}
