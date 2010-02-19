package cn.smartinvoke.smartrcp.gui.control
{
	import cn.smartinvoke.rcp.GlobalServiceId;
    [Bindable]
	[RemoteClass(alias="cn.smartinvoke.smartrcp.gui.control.CActionManager")]
	public class CActionManager extends ActionBarBase
	{
		public static var Instance:CActionManager=new CActionManager();
		public function CActionManager(param:Array=null)
		{
			super(param);
			this.remoteId=GlobalServiceId.CAction_Manager;
		}
		
	}
}