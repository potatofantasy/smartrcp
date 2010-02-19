package cn.smartinvoke.smartrcp.gui.control;

import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;

public class CWorkbenchAction extends CActionImpl implements IWorkbenchAction {

	public CWorkbenchAction() {
		
	}

	public CWorkbenchAction(String text, int style, boolean checked) {
		super(text, style, checked);
	}

	public CWorkbenchAction(String text) {
		super(text);
	}

	public CWorkbenchAction(String text, int type) {
		super(text, type);
	}
	public void dispose() {
	    	
	}
}
