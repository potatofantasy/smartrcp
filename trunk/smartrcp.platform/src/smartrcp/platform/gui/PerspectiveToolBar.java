package smartrcp.platform.gui;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CBanner;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.ToolBar;

import smartrcp.platform.Activator;

public class PerspectiveToolBar {
	private Composite parent;
	public PerspectiveToolBar(CBanner cBanner) {
		
	   	this.parent=new Composite(cBanner, SWT.NONE);
	   	this.parent.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_BLUE));
	   	cBanner.setRight(parent);
	   	
	   	this.init();
	}
	private ToolBar toolBar;
    private void init(){
    	toolBar = new ToolBar(parent, SWT.FLAT | SWT.RIGHT);
    	toolBar.setSize(100,30);
    	ToolBarManager barManager=new ToolBarManager(toolBar);
    	barManager.add(new PlatformAction());
    	barManager.add(new SmartRCPAction());
    	barManager.update(true);
        toolBar.pack();
    }
    public Control getControl(){
    	return parent;
    }
}
class PlatformAction extends Action{
	public PlatformAction(){
		super("管理程序",IAction.AS_RADIO_BUTTON);
		this.setImageDescriptor(Activator.getImageDescriptor("/icons/platformAction.gif"));
	}
	public void run(){
	   	
	}
}
class SmartRCPAction extends Action{
	public SmartRCPAction(){
		super("返回程序",IAction.AS_RADIO_BUTTON);
		this.setImageDescriptor(Activator.getImageDescriptor("/icons/smartrcpAction.gif"));
	}
	public void run(){
	   	
	}
}