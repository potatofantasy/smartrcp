package cn.smartinvoke.smartrcp.gui.module;

import cn.smartinvoke.gui.FlashViewer;

public class CPartEvent {
	//partActivated  partBroughtToTop partClosed  partDeactivated partOpened
	public static final int Part_Activated=0;
	public static final int Part_BroughtToTop=1;
	public static final int Part_Closed=2;
	public static final int Part_Deactivated=3;
	public static final int Part_Opened=4;
	
    public int type=Part_Closed;
    public FlashViewer taget=null;
	public CPartEvent() {
		
	}

}
