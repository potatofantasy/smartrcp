package cn.smartinvoke.smartrcp.gui
{
	import cn.smartinvoke.RemoteObject;
	import cn.smartinvoke.rcp.GlobalServiceId;

	public class MainShell extends RemoteObject
	{
		public static var Instance:MainShell=new MainShell();
		public function MainShell()
		{
			super();
			this.remoteId=GlobalServiceId.Swt_Main_Win;
		}
		
	}
}