package cn.smartinvoke.rcp
{
	[Bindable]
	[RemoteClass(alias="cn.smartinvoke.rcp.CMenuRelation")]
	public class CMenuRelation
	{
		public var managerId:String=null;
		public var label:String=null;
		public var actions:Array=null;
		public function CMenuRelation()
		{
		}
        
	}
}