package cn.smartinvoke.smartrcp;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

import cn.smartinvoke.smartrcp.core.SmartRCPBuilder;
/**
 * An action bar advisor is responsible for creating, adding, and disposing of
 * the actions added to a workbench window. Each window will be populated with
 * new actions.
 */
public class ApplicationActionBarAdvisor extends ActionBarAdvisor {

	// Actions - important to allocate these only in makeActions, and then use
	// them
	// in the fill methods. This ensures that the actions aren't recreated
	// when fillActionBars is called with FILL_PROXY.
	private IWorkbenchAction exitAction;
	private IWorkbenchAction aboutAction;
	private IWorkbenchAction newWindowAction;
	private OpenViewAction openViewAction;
	private Action messagePopupAction;
    
	public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
		super(configurer);
	}
	protected void makeActions(final IWorkbenchWindow window) {
		// Creates the actions and registers them.
		// Registering is needed to ensure that key bindings work.
		// The corresponding commands keybindings are defined in the plugin.xml
		// file.
		// Registering also provides automatic disposal of the actions when
		// the window is closed.

		/*
		 * exitAction = ActionFactory.QUIT.create(window); register(exitAction);
		 * 
		 * aboutAction = ActionFactory.ABOUT.create(window);
		 * register(aboutAction);
		 * 
		 * newWindowAction = ActionFactory.OPEN_NEW_WINDOW.create(window);
		 * register(newWindowAction);
		 * 
		 * openViewAction = new OpenViewAction(window, "Open Another Message
		 * View", View.ID); register(openViewAction);
		 * 
		 * messagePopupAction = new MessagePopupAction("Open Message", window);
		 * register(messagePopupAction);
		 */
		/**
		 *将flex传递过来的CAction数组，初始化为对应的jface Action对象，并将该对象
     * 存储到CActionManager中，key为action的id，值为该action
		 */
		SmartRCPBuilder.createActions();
	}

	protected void fillMenuBar(IMenuManager menuBar) {
		/*
		  MenuManager fileMenu = new MenuManager("&File",
		  IWorkbenchActionConstants.M_FILE); 
		  MenuManager helpMenu = new
		  MenuManager("&Help", IWorkbenchActionConstants.M_HELP);
		  
		 menuBar.add(fileMenu); // Add a group marker indicating where action
		 //set menus will appear. menuBar.add(new
		 * GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
		 * menuBar.add(helpMenu);
		 *  // File fileMenu.add(newWindowAction); fileMenu.add(new
		 * Separator()); fileMenu.add(messagePopupAction);
		 * fileMenu.add(openViewAction); fileMenu.add(new Separator());
		 * fileMenu.add(exitAction);
		 *  // Help helpMenu.add(aboutAction);
		 */
		
		SmartRCPBuilder.createMenuBar(menuBar);
	}

	protected void fillCoolBar(ICoolBarManager coolBar) {
		/**IToolBarManager toolbar = new ToolBarManager(SWT.FLAT | SWT.RIGHT);
        coolBar.add(new ToolBarContributionItem(toolbar, "main"));
        
		CPerspective cPerspective = Activator.cPerspective;
		if (cPerspective != null && this.actionManager!=null) {
		    Object[] idArr=cPerspective.toolBarIds;
		    if(idArr!=null){
			    for(int a=0;a<idArr.length;a++){
			     String id=idArr[a].toString();
			     if(id.equals(JFaceConstant.Menu_Separator_Str)){
			    	 coolBar.add(new Separator());
			     }else{
			      IAction action=this.actionManager.getAction(id);
			      if(action!=null){
			    	  toolbar.add(action);
			      }
			     }
			    }
			 }
		}*/
	}
}
