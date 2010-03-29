package smartrcp.app.pack
{
	import cn.smartinvoke.RemoteObject;
	import cn.smartinvoke.smartrcp.gui.module.CEventBean;
	import cn.smartinvoke.smartrcp.util.HelpMethod;
	
	import mx.collections.ArrayCollection;
    
	public class AppPackService extends RemoteObject
	{
		public function AppPackService()
		{
			//创建java的cn.smartinvoke.smartrcp.app.pack.AppPackService实例
			this.create('cn.smartinvoke.smartrcp.app.pack.AppPackService');
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
		public function downloadAppFromLocal(filePath:String):void{
			this.call('downloadAppFromLocal',arguments);
		}
		public function downloadAppFromUrl(url:String):void{
			this.call('downloadAppFromUrl',arguments);
		}
		public function getApps():ArrayCollection{
			return this.call('getApps',arguments) as ArrayCollection;
		}
		public function deleteAppPack(path:String):void{
			this.call('deleteAppPack',arguments);
		}
	}
}