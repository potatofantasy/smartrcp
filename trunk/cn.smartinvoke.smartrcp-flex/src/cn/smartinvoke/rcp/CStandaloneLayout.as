package cn.smartinvoke.rcp
{
	 [Bindable]
	[RemoteClass(alias="cn.smartinvoke.rcp.CStandaloneLayout")]
	public class CStandaloneLayout extends CLayout
	{
		[Inspectable(type="Boolean")]
		public var showTitle:Boolean=true;
		
		public function CStandaloneLayout(viewId:String=null,refLayout:ICFolderLayout=null,relationship:int=1,ratio:Number=.5,
		showTitle:Boolean=false,closeable:Boolean=true,moveable:Boolean=true)
		{
			super(viewId,relationship,ratio,refLayout,closeable,moveable);
			this.showTitle=showTitle;
		}
	}
}