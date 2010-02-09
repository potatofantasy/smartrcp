package cn.smartinvoke.smartrcp.gui
{
	import cn.smartinvoke.RemoteObject;
	import cn.smartinvoke.rcp.CAction;
	import cn.smartinvoke.rcp.GlobalServiceId;
    [Bindable]
	[RemoteClass(alias="cn.smartinvoke.gui.FlashViewer")]
	public class FlashViewer extends RemoteObject
	{
		
		public function FlashViewer()
		{
			super();
			this.remoteId=GlobalServiceId.FlashViewer;
		}
		public function getFlexAppId():String{
			return this.call("getFlexAppId",arguments) as String;
		}
		public function setTitle(title:String):void{
			this.call("setTitle",arguments);
		}
		public function getTitle():String{
			return this.call("getTitle",arguments) as String;
		}
		public function addAction(action:CAction):void{
			this.call("addAction",arguments);
		}
		public function invoke(methodName:String,params:Array=null):Object{
			return this.call("invoke",[methodName,params]);
		}
		//debug调用此方法
		public function setDebugModule(url:String):void{
			this.call("setDebugModule",arguments);
		}
		public override function gc():void{
			
		}
		public function setData(key:String,data:Object):void{
			if(key!=null){
			 this.call("setData",arguments);
			}
		}
		public function getData(key:String):Object{
			if(key!=null){
				return this.call("getData",arguments);
			}else{
				return null;
			}
		}
		public function removeData(key:String):void{
			if(key!=null){
			 this.call("removeData",arguments);
			}
		}
	}
}