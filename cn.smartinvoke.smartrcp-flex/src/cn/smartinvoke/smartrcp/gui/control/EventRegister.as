package cn.smartinvoke.smartrcp.gui.control
{
	import cn.smartinvoke.RemoteObject;
	import cn.smartinvoke.executor.Executor;
	import cn.smartinvoke.pool.ObjectPool;
	import cn.smartinvoke.rcp.GlobalServiceId;
	import cn.smartinvoke.smartrcp.gui.module.CEventBean;
	
	import mx.core.Application;
	import mx.utils.UIDUtil;
    [Bindable]
	[RemoteClass(alias="cn.smartinvoke.smartrcp.gui.control.EventRegister")]
	public class EventRegister extends RemoteObject
	{
		public static var Instance:EventRegister=new EventRegister();
		public function EventRegister(){
			this.remoteId=GlobalServiceId.Event_Register;
		}
		public function addListener(widget:Object,eventType:int,listener:Function,thisObject:Object=null):void{
			if(widget==null || listener==null){
				return;
			}
			//-------构造事件信息的UID
			var thisObjId:String="app";
			if(thisObject!=null){
				thisObjId=UIDUtil.getUID(thisObject);
			}else{
				thisObject=Application.application;
			}
			var listenerId:String=UIDUtil.getUID(listener);
			var eventUid:String=thisObjId+listenerId;
			//
			ObjectPool.INSTANCE.addObject([thisObject,listener],eventUid);
			
			var bean:CEventBean=new CEventBean();
			bean.appId=Executor.applicationId;
			bean.funId=listenerId;
			bean.tagetId=thisObjId;
			this.call("addListener",[widget,eventType,bean]);
		}
		public function removeListener(widget:Object,eventType:int,listener:Function,thisObject:Object=null):void{
			if(widget==null || listener==null){
				return;
			}
			//删除池引用
		   	var listenerId:String=UIDUtil.getUID(listener);
			var thisObjId:String="app";
			if(thisObject!=null){
			    thisObjId=UIDUtil.getUID(thisObject);
			}
			var eventUid:String=thisObjId+listenerId;
			ObjectPool.INSTANCE.removeObject(eventUid);
			 
			//调用java删除对应数据结构
			var bean:CEventBean=new CEventBean();
			bean.appId=Executor.applicationId;
			bean.funId=listenerId;
			bean.tagetId=thisObjId;
			this.call("removeListener",[widget,eventType,bean]);
		}
	}
}