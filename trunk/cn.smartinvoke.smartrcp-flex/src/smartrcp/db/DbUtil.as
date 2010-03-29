package smartrcp.db
{
	import cn.smartinvoke.RemoteObject;
	import cn.smartinvoke.rcp.GlobalServiceId;
	import cn.smartinvoke.smartrcp.gui.module.CEventBean;
	import cn.smartinvoke.smartrcp.util.HelpMethod;

	public class DbUtil extends RemoteObject
	{
		public static const Instance:DbUtil=new DbUtil();
		public function DbUtil()
		{
			this.remoteId=GlobalServiceId.DB_Util;
		}
		public function loadDriver(driverName:String):void{
			this.call('loadDriver',arguments);
		}
		public function getConnection(url:String,user:String,pwd:String,listener:Function,thisObject:Object):void{
			var bean:CEventBean=HelpMethod.createEventBean(listener,thisObject);
			this.asyncCall("getConnection",[url,user,pwd,bean]);
		}
	}
}