package cn.smartinvoke.rcp
{
	 [Bindable]
	[RemoteClass(alias="cn.smartinvoke.rcp.CStandaloneLayout")]
	public class CStandaloneLayout implements ICFolderLayout
	{
	   [Inspectable(type="Number")]
	   public var relationship:int=CPageLayout.LEFT;
	   [Inspectable(type="Number")]
	   public var ratio:Number=CPageLayout.RATIO_MIN;
	   /* [Inspectable(type="Boolean")]
	   public var closeable:Boolean= true;
	   [Inspectable(type="Boolean")]
	   public var moveable:Boolean = true; */
	   [Inspectable(type="Boolean")]
	   public var showTitle:Boolean = true;
	   
	   public var refLayout:CFolderLayout= null;
	  /**
	   * 该layout中显示的模块
	   */
	   public  var module:CLayoutBasicInfo=null;
	}
}