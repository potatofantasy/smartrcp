package cn.smartinvoke.rcp
{
	import cn.smartinvoke.RemoteObject;
	import cn.smartinvoke.pool.ObjectPool;
    [Bindable]
	[RemoteClass(alias="cn.smartinvoke.smartrcp.gui.control.CAction")]
	public class CAction
	{
	
    public static const AS_UNSPECIFIED:int = 0x00;

    /**
     * Action style constant (value <code>1</code>) indicating action is 
     * a simple push button.
     */
    public static const AS_PUSH_BUTTON:int = 0x01;

    /**
     * Action style constant (value <code>2</code>) indicating action is 
     * a check box (or a toggle button).
     */
    public static const AS_CHECK_BOX :int= 0x02;

    /**
     * Action style constant (value <code>4</code>) indicating action is 
     * a drop down menu.
     */
    public static const AS_DROP_DOWN_MENU:int = 0x04;

    /**
     * Action style constant (value <code>8</code>) indicating action is 
     * a radio button.
     * 
     * @since 2.1
     */
    public static const AS_RADIO_BUTTON:int = 0x08;
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
		public var enable:Boolean=true;
		public function CAction(actionId:String=null,text:String=null,imageUrl:String=null,toolTip:String=null){
			this.actionId=actionId;
		    this.text=text;
		    this.imageUrl=imageUrl;
		    this.toolTip=toolTip;
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