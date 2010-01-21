package cn.smartinvoke.rcp
{
	[Bindable]
	[RemoteClass(alias="cn.smartinvoke.rcp.CMenuBar")]
	public class CMenuBar
	{
		public var label:String=null;
		public var actionIds:Array=null;
		public function CMenuBar()
		{
		}
        
	}
}