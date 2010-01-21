package cn.smartinvoke.smartrcp.gui.module
{
	[Bindable]
	[RemoteClass(alias="cn.smartinvoke.smartrcp.gui.module.CEventBean")]
	public class CEventBean
	{
		public var appId:String;
		public var tagetId:String;
		public var funId:String;
		public function CEventBean()
		{
		}

	}
}