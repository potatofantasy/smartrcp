package cn.smartinvoke.rcp
{
	[Bindable]
	[RemoteClass(alias="cn.smartinvoke.rcp.CLayout")]
	public class CLayout  extends CLayoutBasicInfo implements ILayout
	{
		[Inspectable(type="Number")]
		public  var relationship:int=CPageLayout.LEFT;
		[Inspectable(type="Number")]
		public var ratio:Number=CPageLayout.RATIO_MIN;
		[Inspectable(type="Boolean")]
		public var closeable:Boolean=true;
		[Inspectable(type="Boolean")]
		public var moveable:Boolean=true;
		
		[Inspectable(type="Object")]
		public var refLayout:ICFolderLayout=null;
		public function CLayout(viewId:String,relationship:int,ratio:Number,refLayout:ICFolderLayout,
		closeable:Boolean=true,moveable:Boolean=true)
		{
			this.viewId=viewId;this.relationship=relationship;
			this.ratio=ratio;
			this.refLayout=refLayout;
			this.closeable=closeable;
			this.moveable=moveable;
		}
        
        /* public function get refLayout():String{
        	var ret:String=null;
        	if(refLayoutObj!=null){
        		ret=(refLayoutObj as Object).toString();
        	}
        	return ret;
        } */
	}
}