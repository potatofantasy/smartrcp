package smartrcp.app.pack
{
	import cn.smartinvoke.RemoteObject;
	import cn.smartinvoke.smartrcp.gui.module.CEventBean;
	import cn.smartinvoke.smartrcp.util.HelpMethod;
	
	import mx.collections.ArrayCollection;

	public class CAppService extends RemoteObject
	{
		public function CAppService()
		{
			super();
			this.create('cn.smartinvoke.smartrcp.app.CAppService');
		}
		/**
		 *添加监听器
		 */
		public function addListener(listener:Function,taget:Object):void{
			var bean:CEventBean=HelpMethod.createEventBean(listener,taget);
			if(bean!=null){
				this.call('addListener',[bean]);
			}
		}
		public function getInstallApps():ArrayCollection{
			return this.call('getInstallApps',arguments) as ArrayCollection;
		}
		public function installApp(packPath:String):void{
			this.call('installApp',arguments);
		}
		public function runApp(installFolder:String):void{
			this.asyncCall('runApp',arguments);
		}
		public function deleteApp(installFolder:String):void{
			this.asyncCall('deleteApp',arguments);
		}
		public function updateApp(installFolder:String):void{
			this.asyncCall('updateApp',arguments);
		}
		public function getInstallFolder():String{
		  return	this.call('getInstallFolder',arguments) as String;
		}
	}
}