package cn.smartinvoke.rcp
{
	[Bindable]
	[RemoteClass(alias="cn.smartinvoke.rcp.CLayout")]
	public class CLayout  extends CLayoutBasicInfo implements ILayout
	{
		public  var relationship:int=CPageLayout.LEFT;
		public var ratio:Number=CPageLayout.RATIO_MIN;
		
		public var closeable:Boolean=true;
		public var moveable:Boolean=true;
		
		//private var refLayoutObj:ILayout=null;
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