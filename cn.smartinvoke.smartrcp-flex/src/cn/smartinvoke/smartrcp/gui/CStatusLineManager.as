package cn.smartinvoke.smartrcp.gui
{
	import cn.smartinvoke.RemoteObject;
	import cn.smartinvoke.rcp.CStandaloneLayout;
	import cn.smartinvoke.rcp.GlobalServiceId;

	public class CStatusLineManager extends RemoteObject
	{
		public static var Instance:CStatusLineManager=new CStatusLineManager();
		public function CStatusLineManager()
		{
			this.remoteId=GlobalServiceId.App_StatusLine_Manager;
		}
		public function setErrorMsg(msg:String):void{
	      this.call("setErrorMsg",arguments);
        }
        
        public function setMsgImg(url:String):void{
	      this.call("setMsgImg",arguments);
        }
        public function setErrorImg(url:String):void{
	       this.call("setErrorImg",arguments);
        }
        public function setMsg(msg:String):void{
	       this.call("setMsg",arguments);
        }
	}
}