package cn.smartinvoke.smartrcp
{
	import cn.smartinvoke.RemoteObject;
	import cn.smartinvoke.gui.RCPApplication;
	import cn.smartinvoke.rcp.GlobalServiceId;
	import cn.smartinvoke.smartrcp.gui.FlashShell;
	import cn.smartinvoke.smartrcp.gui.FlashViewPart;
	
	import org.eclipse.swt.widgets.Shell;

	public class CApplication extends RemoteObject
	{
		/**
		 */
		 //--------------------类资源
		 var shell:FlashShell;
   		 var viewPart:FlashViewPart;
   		
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
		//--颜色对话框
		
		
		//-----------------常用对话框
		public function openError(title:String,message:String):void{
			var shell:Shell=RCPApplication.Instance.flashViewer.getShell();
			 this.asyncCall("openError",[shell,title,message]);
		}
		public function openInformation(title:String,message:String):void{
			var shell:Shell=RCPApplication.Instance.flashViewer.getShell();
			 this.asyncCall("openInformation",[shell,title,message]);
		}
		public function openWarning(title:String,message:String):void{
			var shell:Shell=RCPApplication.Instance.flashViewer.getShell();
			 this.asyncCall("openWarning",[shell,title,message]);
		}
		
	}
}