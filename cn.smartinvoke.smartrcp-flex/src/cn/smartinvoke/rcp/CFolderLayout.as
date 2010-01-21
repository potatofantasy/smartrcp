package cn.smartinvoke.rcp
{
	[Bindable]
	[RemoteClass(alias="cn.smartinvoke.rcp.CFolderLayout")]
	public class CFolderLayout extends CLayout implements ICFolderLayout
	{
		
		public function CFolderLayout(viewId:String,relationship:int,ratio:Number,refLayout:ICFolderLayout,
		closeable:Boolean=true,moveable:Boolean=true)
		{
			super(viewId,relationship,ratio,refLayout,closeable,moveable);
		}

	}
}