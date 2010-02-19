package cn.smartinvoke.smartrcp.gui.control
{
	import cn.smartinvoke.RemoteObject;
	import cn.smartinvoke.executor.Executor;
	import cn.smartinvoke.pool.ObjectPool;
	import cn.smartinvoke.rcp.CAction;
	import cn.smartinvoke.smartrcp.gui.module.CEventBean;
	import cn.smartinvoke.smartrcp.util.Log;
	
	import mx.core.Application;
	import mx.utils.UIDUtil;

	public class ActionBarBase extends RemoteObject
	{
		public function ActionBarBase(param:Array=null)
		{
			super(param);
		}
		public function addAction(cAction:CAction):void{
			if(cAction.actionId==null){
				Log.println("the actionId property must not be null");
				return;
			}
			this.call('addAction',arguments);
		}
		public function fireAction(actionId:String):void{
		   if(actionId!=null){
			this.call("fireAction",arguments);
		   }
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
		public function removeAction(actionId:String):void{
			this.call('removeAction',arguments);
		}
		public function updateEnable(actionId:String,enable:Boolean):void{
			//Alert.show("actionManager updateEnable id="+actionId+" enable="+enable);
			 if(actionId!=null){
			 	this.call("setEnable",arguments);
			 }
		}
		public function updateToolTip(actionId:String,text:String):void{
			if(actionId!=null){
	          this.call("updateToolTip",arguments);
	        }
        }
		public function updateText(actionId:String,text:String):void{
			if(actionId!=null){
	           this.call("updateText",arguments);
	        }
        }
        public function updateChecked(actionId:String,isChecked:Boolean):void{
        	if(actionId!=null){
	           this.call("updateChecked",arguments);
	        }
        }

	}
}