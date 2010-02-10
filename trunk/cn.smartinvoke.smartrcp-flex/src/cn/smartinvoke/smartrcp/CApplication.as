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
		public function restart():void{
			this.call("restart",arguments);
		}
		//--------------全局数据区
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
		//-----------------常用对话框
		public function openConfirm(title:String,message:String):Boolean{
			return this.call("openConfirm",[this.appId,title,message]) as Boolean;
		}
		public function openQuestion(title:String,message:String):Boolean{
			return this.call("openQuestion",arguments) as Boolean;
		}
		public function openError(title:String,message:String):void{
			 this.call("openError",arguments);
		}
		public function openInformation(title:String,message:String):void{
			 this.call("openInformation",arguments);
		}
		public function openWarning(title:String,message:String):void{
			 this.call("openWarning",arguments);
		}
		
	}
}