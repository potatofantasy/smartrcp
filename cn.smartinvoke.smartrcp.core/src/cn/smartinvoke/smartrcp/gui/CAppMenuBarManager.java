package cn.smartinvoke.smartrcp.gui;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;

import cn.smartinvoke.smartrcp.gui.control.CActionImpl;
import cn.smartinvoke.smartrcp.gui.control.CActionManager;

public class CAppMenuBarManager {
	private IMenuManager root = null;
	private CActionManager actionManager;

	public CAppMenuBarManager(IMenuManager root, CActionManager actionManager) {
		this.root = root;
		this.actionManager = actionManager;
	}
	public void addMenu(String id,String label){
		if(id!=null && label!=null){
		  MenuManager menuManager = new MenuManager(label,id);
		  this.root.add(menuManager);
		}
	}
	public void addMenuItem(String actionId, String path) {
		if (actionId == null) {
			return;
		}
		if (path == null) {
			path = "";
		}
		path = path.trim();

		IMenuManager menuManager = null;
		if (path.length() == 0) {
			menuManager = root;
		} else {
			menuManager = this.root.findMenuUsingPath(path);
		}
		if (menuManager != null) {
			CActionImpl actionImpl = this.actionManager.getAction(actionId);
			if (actionImpl != null) {
				actionImpl.path = path;
				menuManager.add(actionImpl);
				menuManager.update();
				this.root.updateAll(true);
			}
		}
	}

	public void removeMenuItem(String actionId, String path) {
		if (actionId == null) {
			return;
		}
		if (path == null) {
			path = "";
		}
		path = path.trim();
		IMenuManager menuManager = null;
		if (path.length() == 0) {
			menuManager = root;
		} else {
			menuManager = this.root.findMenuUsingPath(path);
		}
		if (menuManager != null) {
			CActionImpl actionImpl = actionManager.getAction(actionId);
			if (actionImpl != null) {
				menuManager.remove(actionId);
				menuManager.update();
				this.root.updateAll(true);
				// actionManager.removeAction(actionId);
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
