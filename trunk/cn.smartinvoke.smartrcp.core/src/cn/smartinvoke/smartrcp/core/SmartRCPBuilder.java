package cn.smartinvoke.smartrcp.core;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IPerspectiveListener;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IWorkbenchConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.part.ViewPart;

import cn.smartinvoke.IServiceObjectCreator;
import cn.smartinvoke.TypeMapper;
import cn.smartinvoke.gui.FlashViewer;
import cn.smartinvoke.gui.ObjectPool;
import cn.smartinvoke.rcp.CLayoutBasicInfo;
import cn.smartinvoke.rcp.CMenuRelation;
import cn.smartinvoke.rcp.CPageLayout;
import cn.smartinvoke.rcp.CPerspective;
import cn.smartinvoke.rcp.CWindowConfigurer;
import cn.smartinvoke.smartrcp.CApplication;
import cn.smartinvoke.smartrcp.DebugServer;
import cn.smartinvoke.smartrcp.gui.CAppMenuBarManager;
import cn.smartinvoke.smartrcp.gui.CAppToolBarManager;
import cn.smartinvoke.smartrcp.gui.CStatusLineManager;
import cn.smartinvoke.smartrcp.gui.FlashViewPart;
import cn.smartinvoke.smartrcp.gui.SplashWindow;
import cn.smartinvoke.smartrcp.gui.control.CAction;
import cn.smartinvoke.smartrcp.gui.control.CActionManager;
import cn.smartinvoke.smartrcp.gui.control.EventFilter;
import cn.smartinvoke.smartrcp.gui.control.EventRegister;
import cn.smartinvoke.smartrcp.gui.control.FlashViewInvoker;
import cn.smartinvoke.smartrcp.gui.control.GlobalServiceId;
import cn.smartinvoke.smartrcp.gui.control.ViewManager;
import cn.smartinvoke.smartrcp.util.JFaceConstant;
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
	public static void init(IServiceObjectCreator objectCreator) {
		// TODO 程序的初始化
		
		// ----------- 注册全局服务
		ObjectPool objectPool = ObjectPool.INSTANCE;
		objectPool.objectCreator = objectCreator;
		
		objectPool.putObject(new CApplication(), GlobalServiceId.Cur_Application);
		
		objectPool.putObject(new FlashViewInvoker(),
				GlobalServiceId.FlashView_Invoker);
		// 添加事件注册器服务
		EventRegister eventRegister = new EventRegister();
		objectPool.putObject(eventRegister, GlobalServiceId.Event_Register);
		// 将splash窗口设置为服务对象供flex调用
		ObjectPool.INSTANCE.putObject(splash_win, GlobalServiceId.Splash_Win);
		// ------------加载配置信息
		try {
			ConfigerLoader.init();
			String servicePacks = ConfigerLoader
					.getProperty(ConfigerLoader.key_export_package);
			TypeMapper.addServiceConfig(servicePacks);

			// 设置配置信息
			CPerspective.init();
			// -----------开启splash窗口，加载flex的splash信息
			try {
				splash_win.open();
			} catch (Throwable e) {
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
	/**
	 * 保存工作台设置信息
	 * @param memento
	 */
	public static void saveWorkbenchState(IMemento memento){
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
	}
	/**
	 * 恢复工作台设置信息
	 * @param memento
	 */
	public static void restoreWorkbenchState(IMemento memento){
		String val=memento.getString(key_workbench_state);
		if(val!=null){
			CPageLayout pageLayout=SplashWindow.getPerspective().page;
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

	public static CActionManager actionManager = null;
    public static IWorkbenchWindow window;
	/**
	 * 创建action
	 */
	public static void createActions(ActionBarAdvisor actionBarAdvisor,IWorkbenchWindow window) {
		SmartRCPBuilder.window=window;
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

	/**
	 * 创建菜单
	 * 
	 * @param menuBar
	 */
	public static void fillMenuBar(IMenuManager menuBar) {
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

	private static void fillMenuBar(IMenuManager menuBar, CMenuRelation cMenuBar,String managerId,String pathStr) {
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
    /**
     * 初始化工具栏
     * @param coolBar
     */
	public static void fillCoolBar(ICoolBarManager coolBar) {
		CPerspective cPerspective = SplashWindow.getPerspective();
		if (cPerspective != null && actionManager != null) {
			CAppToolBarManager toolBarManager = new CAppToolBarManager(coolBar);
			// 添加到全局服务...
			ObjectPool.INSTANCE.putObject(toolBarManager,
					GlobalServiceId.App_ToolBar_Manager);
			toolBarManager.fillToolBar(cPerspective.toolBar);
		}

	}
	/**
	 * 初始化状态栏管理器
	 * @param statusLineManager
	 */
    public static void initStatusLine(IStatusLineManager statusLineManager){
    	CStatusLineManager lineManager=new CStatusLineManager(statusLineManager);
    	ObjectPool.INSTANCE.putObject(lineManager,GlobalServiceId.App_StatusLine_Manager);
    	
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
							//IViewPart viewPart=(IViewPart)workbenchPart;
							String id=FlashViewer.getViewNum()+"";
							ViewManager.fillViewerList(id,partRef.getId(),workbenchPart);
						}else{
							 IViewPart viewPart=(IViewPart)workbenchPart;
							 //将当前打开的viewPart的信息添加进模块对应表中	
							 FlashViewer flashViewer=FlashViewer.getViewerByParent(viewPart);//视图对应的FlashViewer对象
							 if(flashViewer!=null){
								 SplashWindow.getPerspective().
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
	}
    public static Shell Main_Shell=null;
	public static void postWindowOpen(Shell shell) {
		Main_Shell=shell;
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
		IWorkbenchWindow window=SmartRCPBuilder.window;
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
	}
	/**
	 * 打开debug服务，接收flexBuilder的请求
	 */
    private static void openDebugServer(){
      String[] args=org.eclipse.equinox.internal.app.CommandLineArgs.getAllArgs();	
      if(args!=null){
    	  for(int i=0;i<args.length;i++){
    		  String arg=args[i];
    		  if(arg.equals("-dbm")){
    			  DebugServer.start();
    		  }
    	  }
      }
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
          //ProtocolBuilder
	}

}
