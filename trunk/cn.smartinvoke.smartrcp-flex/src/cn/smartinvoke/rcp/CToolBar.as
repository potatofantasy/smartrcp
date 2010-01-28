package cn.smartinvoke.rcp
{
	[Bindable]
	[RemoteClass(alias="cn.smartinvoke.rcp.CToolBar")]
	public class CToolBar
	{
		public var type:int=0;
		public var toolBarId:String;
		public var actionIds:Array;
		public function CToolBar()
		{
		}
	}
}