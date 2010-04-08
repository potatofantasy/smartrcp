package cn.smartinvoke.rcp
{
	import mx.collections.ArrayCollection;
	
	[Bindable]
	[RemoteClass(alias="cn.smartinvoke.rcp.CFolderLayout")]
	public class CFolderLayout implements ICFolderLayout
	{
	   [Inspectable(type="Number")] 
	   public var relationship:int=CPageLayout.LEFT;
	   [Inspectable(type="Number")]
	   public var ratio:Number=CPageLayout.RATIO_MIN;
	   
	   public var placeholderViewPartId:String;
	   public var refLayout:CFolderLayout= null;
	  /**
	   * 该layout中显示的模块集合
	   */
	   public  var modules:ArrayCollection=null;
	}
}