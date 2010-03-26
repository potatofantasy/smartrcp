package smartrcp.plugin;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.IWorkbenchWindowPulldownDelegate2;

public class ActionAppSelector extends Action implements
IMenuCreator, IWorkbenchWindowPulldownDelegate2{

	private Menu fMenu;
	private Menu dropDownMenu;
 	 
	public void dispose() {
		
	}

	public Menu getMenu(Control parent) {
		if (dropDownMenu != null){
			return dropDownMenu;
		}
		dropDownMenu = new Menu(parent);
		MenuItem newMCITrxItem = new MenuItem(dropDownMenu, 0);
		newMCITrxItem.setText("下拉菜单示例");
		
		return dropDownMenu;
	}

	public Menu getMenu(Menu parent) {
		if (fMenu != null){
			return fMenu;
		}
		fMenu = new Menu(parent);
		MenuItem newMCITrxItem = new MenuItem(fMenu, 0);
		newMCITrxItem.setText("菜单栏菜单示例");
		
		return fMenu;
	}

	public void init(IWorkbenchWindow window) {
		
	}

 
	public void run(IAction action) {
	 
	}
	
	
	public void selectionChanged(IAction action, ISelection selection) {
		
	}

}
