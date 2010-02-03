package cn.smartinvoke.smartrcp.util
{
	import cn.smartinvoke.executor.Executor;
	import cn.smartinvoke.pool.ObjectPool;
	import cn.smartinvoke.smartrcp.gui.module.CEventBean;
	
	import mx.core.Application;
	import mx.utils.UIDUtil;
	
	public class HelpMethod
	{
		public function HelpMethod()
		{
		}
        public static function createEventBean(listener:Function,thisObject:Object=null):CEventBean{
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
			
			return bean;
        }
        public static function removeListener(listener:Function,thisObject:Object=null):CEventBean{
        	if(listener!=null){
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
		   	 return bean;
		   }
		   return null;
        }
	}
}