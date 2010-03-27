package cn.smartinvoke.gui
{
	import cn.smartinvoke.RemoteObject;
	import cn.smartinvoke.executor.Executor;
	import cn.smartinvoke.rcp.CPerspective;
	import cn.smartinvoke.rcp.GlobalServiceId;
	
	import flash.utils.*;
	
	import mx.controls.Alert;
	import mx.core.Application;
	import mx.events.FlexEvent;
	public class SplashApp extends Application
	{
		/**
		 *是否自动关闭
		 */
		protected var isAutomatic:Boolean=true;
		public static var waitTime:Number=2000;//等待时间
		public function SplashApp()
		{ 
			super();
			this.addEventListener(FlexEvent.CREATION_COMPLETE,this.init);
		}
		private function  init(evt:FlexEvent):void{
			//初始化smartinvoke
   			Executor.init();
   			//Alert.show("finish");
   			setTimeout(this.close,SplashApp.waitTime);
		}
		protected function close():void{
			//Alert.show(" in close "+this.getAutomatic());
			if(this.getAutomatic()){
			   this.closeWin();
			}
		}
		protected function closeWin():void{
			try{
				var win:RemoteObject=new RemoteObject();
				win.remoteId=GlobalServiceId.Splash_Win;
				win.asyncCall("setPerspective",[this.getPerspective()]);
				//win.call("close",null);
				}catch(e:Error){
					Alert.show(e.message);
				}
		}
		public function getAutomatic():Boolean{
			return this.isAutomatic;
		}
		public function getPerspective():CPerspective{
			return null;
		}
	}
}