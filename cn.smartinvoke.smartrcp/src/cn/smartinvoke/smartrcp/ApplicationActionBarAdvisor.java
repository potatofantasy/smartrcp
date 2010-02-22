package cn.smartinvoke.smartrcp;

import java.lang.reflect.Field;
import java.util.Map;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ContributionItem;
import org.eclipse.jface.action.ControlContribution;
import org.eclipse.jface.action.CoolBarManager;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.action.ToolBarContributionItem;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
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
		SmartRCPBuilder.createActions(this,window);
		//this.register(action)
	}

	protected void fillMenuBar(IMenuManager menuBar) {
		SmartRCPBuilder.fillMenuBar(menuBar);
	}
	protected void fillCoolBar(ICoolBarManager coolBar) {
		
		SmartRCPBuilder.fillCoolBar(coolBar);
	}
	protected void fillStatusLine(IStatusLineManager statusLine) {
		  //ToolBarManager barManager=null;
		  
//		  statusLine.add(new GroupMarker(StatusLineManager.BEGIN_GROUP));
		  //statusLine.add(new MyStatusLineControl());
		 // statusLine.update(true);
//		  statusLine.add(new Separator());
//		  statusLine.appendToGroup(StatusLineManager.BEGIN_GROUP,new MyStatusLineControl());
		SmartRCPBuilder.initStatusLine(statusLine);
	}
	public static void main(String[] args) throws Exception{
		
	    
	}
}
class MyStatusLineControl extends ContributionItem{
  
	public void fill(Composite parent) {
		CoolBar coolBar=new CoolBar(parent,SWT.FLAT);
		CoolBarManager coolBarManager=new CoolBarManager(coolBar);
		ToolBarManager toolBarManager=new ToolBarManager();
		
		toolBarManager.add(new Action("action1",Activator.getImageDescriptor("/icons/sample2.gif")){
			
		});
		toolBarManager.add(new Action("action2",Activator.getImageDescriptor("/icons/sample3.gif")){
			
		});
        coolBarManager.add(toolBarManager);
        
        coolBar.setParent(parent);
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
