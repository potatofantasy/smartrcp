package cn.smartinvoke.smartrcp.gui.module
{
	[Bindable]
	[RemoteClass(alias="cn.smartinvoke.smartrcp.gui.module.CActionEvent")]
	public class CActionEvent extends CEvent
	{
		public var checked:Boolean=false;
		public var actionId:String;
		public var path:String;
		public function CActionEvent()
		{
			super();
		}
	}
}