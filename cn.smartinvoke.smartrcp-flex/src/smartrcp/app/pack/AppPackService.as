package smartrcp.app.pack
{
	import cn.smartinvoke.RemoteObject;
	
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;
    
	public class AppPackService extends RemoteObject
	{
		public function AppPackService()
		{
			//创建java的cn.smartinvoke.smartrcp.app.pack.AppPackService实例
			this.create('cn.smartinvoke.smartrcp.app.pack.AppPackService');
		}
		
		public function downloadAppFromLocal(filePath:String):void{
			this.call('downloadAppFromLocal',arguments);
		}
		public function downloadAppFromUrl(url:String):void{
			this.call('downloadAppFromUrl',arguments);
		}
		public function getApps():ArrayCollection{
			return this.call('getApps',arguments) as ArrayCollection;
		}
		public function installApp(packPath:String):void{
			
			this.call('installApp',arguments);
		}
		public function deleteAppPack(path:String):void{
			this.call('deleteAppPack',arguments);
		}
	}
}