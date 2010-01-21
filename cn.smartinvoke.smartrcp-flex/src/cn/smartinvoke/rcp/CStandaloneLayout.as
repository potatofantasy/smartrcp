package cn.smartinvoke.rcp
{
	 [Bindable]
	[RemoteClass(alias="cn.smartinvoke.rcp.CStandaloneLayout")]
	public class CStandaloneLayout extends CLayout
	{
		public var showTitle:Boolean=true;
		
		public function CStandaloneLayout(viewId:String,relationship:int,ratio:Number,refLayout:ICFolderLayout,
		showTitle:Boolean=true,closeable:Boolean=true,moveable:Boolean=true)
		{
			super(viewId,relationship,ratio,refLayout,closeable,moveable);
			this.showTitle=showTitle;
		}
	}
}