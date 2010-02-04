package cn.smartinvoke.rcp
{
	[Bindable]
	[RemoteClass(alias="cn.smartinvoke.rcp.CLayoutBasicInfo")]
	public class CLayoutBasicInfo
	{
		//当前layout的viewId所对应的swf是否是模块swf
		[Inspectable(type="Boolean")]
		public var isModuleSwf:Boolean=true;
		
		public var viewId:String=null;
		
		public var title:String=null;
		public var image:String=null;
		
		public function CLayoutBasicInfo()
		{
			
		}

	}
}