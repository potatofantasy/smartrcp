package cn.smartinvoke.gui
{
	import cn.smartinvoke.RemoteObject;
	import cn.smartinvoke.executor.Executor;
	import cn.smartinvoke.rcp.CPerspective;
	import cn.smartinvoke.rcp.GlobalServiceId;
	
	import flash.utils.*;
	
	import mx.core.Application;
	import mx.events.FlexEvent;
	public class SplashApp extends Application
	{
		/**
		 *是否自动关闭
		 */
		protected var isAutomatic=true;
		protected var waitTime:Number=2000;//等待时间
		public function SplashApp()
		{
			super();
			this.addEventListener(FlexEvent.CREATION_COMPLETE,this.init);
		}
		private function  init(evt:FlexEvent):void{
			//初始化smartinvoke
   			Executor.init();
   			setTimeout(this.close,waitTime);
		}
		protected function close():void{
			if(this.getAutomatic()){
			   this.closeWin();
			}
		}
		protected function closeWin():void{
			try{
				var win:RemoteObject=new RemoteObject();
				win.remoteId=GlobalServiceId.Splash_Win;
				win.call("setPerspective",[this.getPerspective()]);
				win.call("close",null);
				}catch(e:Error){
					
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