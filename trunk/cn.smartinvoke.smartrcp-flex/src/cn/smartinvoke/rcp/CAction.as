package cn.smartinvoke.rcp
{
	import cn.smartinvoke.RemoteObject;
	import cn.smartinvoke.pool.ObjectPool;
    [Bindable]
	[RemoteClass(alias="cn.smartinvoke.smartrcp.gui.control.CAction")]
	public class CAction
	{
		public static const AS_CHECK_BOX :int= 0x02;
		public static const AS_RADIO_BUTTON:int=0x08;
		
		//private var runFun:Function=null;
		//private var _runFunId:String;
		
		public var actionId:String=null;
		
		public var text:String=null;
		public var toolTip:String;
		
		public var imageUrl:String;
		public var hoverImageUrl:String;
		public var DisableImageUrl:String;
		
		public var type:int=-1;
		private var _typeStr:String;
		public var checked:Boolean=false;
		
		public function CAction()
		{
		  
		}
		[Inspectable (enumeration="AS_CHECK_BOX,AS_RADIO_BUTTON")]
		public function set typeStr(typeStr:String):void{
			this._typeStr=typeStr;
			if(this._typeStr!=null){
			 this.type=CAction[typeStr] as int;
			}
		}
	}
}