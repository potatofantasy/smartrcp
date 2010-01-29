package cn.smartinvoke.smartrcp;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ControlContribution;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.ToolBarContributionItem;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
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
		SmartRCPBuilder.fillMenuBar(menuBar);
	}
	protected void fillCoolBar(ICoolBarManager coolBar) {
		
		SmartRCPBuilder.fillCoolBar(coolBar);
	}
}
class MyDropDownMenu extends ControlContribution{
	public MyDropDownMenu(String id) {
		super(id);
	}
	@Override
	protected Control createControl(Composite parent) {
		
		return null;
	}
	
}
