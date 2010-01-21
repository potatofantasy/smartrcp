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
	[RemoteClass(alias="cn.smartinvoke.smartrcp.gui.control.CActionManager")]
	public class CActionManager extends RemoteObject
	{
		public function CActionManager(param:Array=null)
		{
			super(param);
			this.remoteId=GlobalServiceId.CAction_Manager;
		}
		public function addListener(actionId:String,listener:Function,thisObject:Object=null):void{
			if(actionId==null || listener==null){
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
			//传递事件信息给java
			var bean:CEventBean=new CEventBean();
			bean.appId=Executor.applicationId;
			bean.funId=listenerId;
			bean.tagetId=thisObjId;
			this.call("addListener",[actionId,bean]);
		}
		public function removeListener(actionId:String,
		   listener:Function,thisObject:Object=null):void{
		   if(actionId!=null && listener!=null){
		   	 //删除池引用
		   	 var listenerId:String=UIDUtil.getUID(listener);
			 var thisObjId:String="app";
			 if(thisObject!=null){
			    thisObjId=UIDUtil.getUID(thisObject);
			 }
			 var eventUid:String=thisObjId+listenerId;
			 ObjectPool.INSTANCE.removeObject(eventUid);
			 //传递事件信息给java
			 var bean:CEventBean=new CEventBean();
			 bean.appId=Executor.applicationId;
			 bean.funId=listenerId;
			 bean.tagetId=thisObjId;
		   	 this.call('removeListener',[actionId,bean]);
		   }
		}
		public function setEnable(id:String,enable:Boolean):void{
			 if(id!=null){
			 	this.call("setEnable",arguments);
			 }
		}
	}
}