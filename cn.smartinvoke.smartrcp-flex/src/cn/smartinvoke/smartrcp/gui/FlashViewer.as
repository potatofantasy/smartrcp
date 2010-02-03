package cn.smartinvoke.smartrcp.gui
{
	import cn.smartinvoke.RemoteObject;
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
		public function setTitle(title:String):void{
			this.call("setTitle",arguments);
		}
		public function getTitle():String{
			return this.call("getTitle",arguments) as String;
		}
		public function invokeFlex(methodName:String,params:Array):Object{
			return this.call("invokeFlex",[methodName,params]);
		}
		public function setDebugModule(url:String):void{
			this.call("setDebugModule",arguments);
		}
	}
}