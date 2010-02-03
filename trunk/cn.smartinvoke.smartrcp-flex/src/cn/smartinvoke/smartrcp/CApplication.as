package cn.smartinvoke.smartrcp
{
	import cn.smartinvoke.RemoteObject;
	import cn.smartinvoke.rcp.GlobalServiceId;

	public class CApplication extends RemoteObject
	{
		public static var Instance:CApplication=new CApplication();
		public function CApplication()
		{
			this.remoteId=GlobalServiceId.Cur_Application;
		} 
		public function getBaseFolder():String{
			return this.call("getBaseFolder",arguments) as String;
		}
		public function setDebugPath(path:String):void{
			this.call("setDebugPath",arguments);
		}
		public function getRuntimeSwfPath():String{
			return this.call("getRuntimeSwfPath",arguments)as String;
		}
		public function exit():void{
			this.call("exit",arguments);
		}
	}
}