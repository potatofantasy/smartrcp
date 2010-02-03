package cn.smartinvoke.smartrcp.gui.module
{
	import org.eclipse.swt.widgets.Display;
	import org.eclipse.swt.widgets.Shell;
	[Bindable]
	[RemoteClass(alias="cn.smartinvoke.smartrcp.gui.module.CShellEvent")]
	public class CShellEvent
	{
		public static const Event_Activated:int=0;
	public static const Event_Closed:int=1;
	public static const Event_Deactivated:int=2;
	public static const Event_Deiconified:int=3;
	public static const Event_Iconified:int=4;
	
	
	public var display:Display;
	public var widget:Shell;
	public var time:int;
	public var data:Object;
		public function CShellEvent()
		{
		}

	}
}