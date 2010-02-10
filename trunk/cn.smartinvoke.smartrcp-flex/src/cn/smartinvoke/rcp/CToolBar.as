package cn.smartinvoke.rcp
{
	import cn.smartinvoke.smartrcp.util.JFaceConstant;
	
	import mx.collections.ArrayCollection;
	
	[Bindable]
	[RemoteClass(alias="cn.smartinvoke.rcp.CToolBar")]
	public class CToolBar
	{
		public static const Image_Text_Horizontal:int=0;
		public static const Image_Text_Vertical:int=1;
		public static const Image:int=2;
		public var type:int=CToolBar.Image_Text_Horizontal;
		public var toolBarId:String;
		private var _actionIds:ArrayCollection=new ArrayCollection();
		public function CToolBar()
		{
			
		}
		public function set actionIds(arr:ArrayCollection):void{
			//Alert.show("in set actionIds="+arr+"");
			//var addArr:ArrayCollection=new ArrayCollection([JFaceConstant.Menu_Separator_Str]);
			if(arr!=null){
			   var first:String=arr.getItemAt(0) as String;
			   if(first==null || first!=JFaceConstant.Menu_Separator_Str){
			   	  arr.addItemAt(JFaceConstant.Menu_Separator_Str,0);
			   }
			}else{
				arr=new ArrayCollection([JFaceConstant.Menu_Separator_Str]);
			}
			this._actionIds=arr;
		}//
		public function get actionIds():ArrayCollection{
			return this._actionIds;
		}
		public  function toString():String{
			var str:String="";
			for(var i:int=0;i<this._actionIds.length;i++){
				str+=this._actionIds[i]+",";
			}
			return str;
		}
	}
}