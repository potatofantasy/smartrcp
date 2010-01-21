package cn.smartinvoke.smartrcp.core;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;

import cn.smartinvoke.IServiceObjectCreator;
import cn.smartinvoke.TypeMapper;
import cn.smartinvoke.gui.ObjectPool;
import cn.smartinvoke.rcp.CMenuBar;
import cn.smartinvoke.rcp.CPerspective;
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

public class SmartRCPBuilder {
    private static SplashWindow splash_win=SplashWindow.INSTANCE;
	private SmartRCPBuilder() {
		
	}
	/**
	 * 初始化SmartRCP获得初始化信息
	 */
    public static void init(IServiceObjectCreator objectCreator){
    	// TODO 程序的初始化
		// 注册全局服务
		ObjectPool objectPool = ObjectPool.INSTANCE;
		objectPool.objectCreator=objectCreator;
		objectPool.putObject(new CActionManager(),
				GlobalServiceId.CAction_Manager);
		objectPool.putObject(new FlashViewInvoker(),
				GlobalServiceId.FlashView_Invoker);
		// 添加事件注册器服务
		EventRegister eventRegister = new EventRegister();
		objectPool.putObject(eventRegister, GlobalServiceId.Event_Register);
		// 将splash窗口设置为服务对象供flex调用
		ObjectPool.INSTANCE.putObject(splash_win, GlobalServiceId.Splash_Win);
		// 设置服务类
		try {
			ConfigerLoader.init();
			String servicePacks = ConfigerLoader
					.getProperty(ConfigerLoader.key_export_package);
			TypeMapper.addServiceConfig(servicePacks);
			
			// 设置配置信息
			CPerspective.init();
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
    private static CActionManager actionManager = null;
    /**
     *创建action
     */
    public static void createActions(){
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
							actionManager.addAction(new CActionImpl(
									(CAction) actionObj));
						}
					}
				}
			}
		}
    }
    /**
     * 创建菜单
     * @param menuBar
     */
    public static void createMenuBar(IMenuManager menuBar){
    	CPerspective cPerspective = SplashWindow.getPerspective();
		if (cPerspective != null &&actionManager!=null) {
			Object[] menuBarObjs=cPerspective.menuBars;
			if(menuBarObjs!=null){
				for(int i=0;i<menuBarObjs.length;i++){
				   Object obj=menuBarObjs[i];
				   if(obj instanceof CMenuBar){
					   CMenuBar cMenuBar=(CMenuBar)obj;
					   MenuManager menuManager=new MenuManager(cMenuBar.label);
					   Object[] idArr=cMenuBar.actionIds;
					   if(idArr!=null){
					    for(int a=0;a<idArr.length;a++){
					     String id=idArr[a].toString();
					     if(id.equals(JFaceConstant.Menu_Separator_Str)){
					    	 menuManager.add(new Separator());
					     }else{
					      IAction action=actionManager.getAction(id);
					      if(action!=null){
					        menuManager.add(action);
					      }
					     }
					    }
					    menuBar.add(menuManager);
					   }
				   }
				}
			}
		}
    }
    public static void preWindowOpen( IWorkbenchWindowConfigurer configurer){
    	//TODO 将Display对象注册为全局服务对象，并且添加事件处理程序
    	//System.out.println();
    	Display curDisp=Display.getCurrent();
    	ObjectPool.INSTANCE.putObject(curDisp, GlobalServiceId.Swt_Display);
    	EventFilter.exeFilter(curDisp);
    	//设置视图管理器
    	ObjectPool.INSTANCE.putObject(new ViewManager(),GlobalServiceId.View_Manager);
        if(configurer!=null){
        configurer.setInitialSize(new Point(800, 600));
        configurer.setShowMenuBar(true);
        configurer.setShowCoolBar(false);
        configurer.setShowFastViewBars(false);
        //configurer.setShowPerspectiveBar(true);
        configurer.setShowStatusLine(false);
        }
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}

}
