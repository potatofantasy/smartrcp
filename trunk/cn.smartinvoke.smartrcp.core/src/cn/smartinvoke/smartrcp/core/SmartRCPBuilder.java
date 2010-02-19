package cn.smartinvoke.smartrcp.core;

import java.util.List;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuManager;
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
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IPerspectiveListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;

import cn.smartinvoke.IServiceObjectCreator;
import cn.smartinvoke.ProtocolBuilder;
import cn.smartinvoke.TypeMapper;
import cn.smartinvoke.gui.FlashViewer;
import cn.smartinvoke.gui.ObjectPool;
import cn.smartinvoke.rcp.CMenuRelation;
import cn.smartinvoke.rcp.CPerspective;
import cn.smartinvoke.rcp.CWindowConfigurer;
import cn.smartinvoke.smartrcp.CApplication;
import cn.smartinvoke.smartrcp.DebugServer;
import cn.smartinvoke.smartrcp.gui.CAppMenuBarManager;
import cn.smartinvoke.smartrcp.gui.CAppToolBarManager;
import cn.smartinvoke.smartrcp.gui.FlashViewPart;
import cn.smartinvoke.smartrcp.gui.SplashWindow;
import cn.smartinvoke.smartrcp.gui.control.CAction;
import cn.smartinvoke.smartrcp.gui.control.CActionImpl;
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
						
					  if(!(workbenchPart instanceof FlashViewPart)){
						String id=FlashViewer.getViewNum()+"";
						Log.println("opened view="+workbenchPart);
						ViewManager.fillViewerList(id,partRef.getId(),workbenchPart);
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
