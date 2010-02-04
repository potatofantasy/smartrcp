package cn.smartinvoke.rcp
{
	[Bindable]
	[RemoteClass(alias="cn.smartinvoke.rcp.CFolderLayout")]
	public class CFolderLayout extends CLayout implements ICFolderLayout
	{
		public var placeholderViewId:String=null;
		public function CFolderLayout(viewId:String=null,refLayout:ICFolderLayout=null,relationship:int=1,ratio:Number=.5,
		closeable:Boolean=true,moveable:Boolean=true)
		{
			super(viewId,relationship,ratio,refLayout,closeable,moveable);
		}

	}
}