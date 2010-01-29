package cn.smartinvoke.rcp
{
	[Bindable]
	[RemoteClass(alias="cn.smartinvoke.rcp.CLayout")]
	public class CLayout implements ILayout
	{
		public  var relationship:int=CPageLayout.LEFT;
		public var ratio:Number=CPageLayout.RATIO_MIN;
		
		public var closeable:Boolean=true;
		public var moveable:Boolean=true;
		//当前layout的viewId所对应的swf是否是模块swf
		public var isModuleSwf:Boolean=true;
		
		public var viewId:String=null;
		
		public var title:String=null;
		public var image:String=null;
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