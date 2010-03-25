package cn.smartinvoke.smartrcp.gui.module;

import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Widget;

public class CShellEvent {
	public static final int Event_Activated=0;
	public static final int Event_Closed=1;
	public static final int Event_Deactivated=2;
	public static final int Event_Deiconified=3;
	public static final int Event_Iconified=4;
	
	
	public Display display;
	public Widget widget;
	public int time;
	public Object data;
	public CShellEvent() {
	   	
	}
	public CShellEvent(ShellEvent e) {
		super();
		this.display =e.display;
		this.widget = e.widget;
		this.time = e.time;
		this.data =e. data;
	}
	
}
