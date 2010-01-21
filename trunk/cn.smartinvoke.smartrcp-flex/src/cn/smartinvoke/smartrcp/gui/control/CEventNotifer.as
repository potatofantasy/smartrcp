package cn.smartinvoke.smartrcp.gui.control
{
	import cn.smartinvoke.IServerObject;
	import cn.smartinvoke.pool.ObjectPool;

	public class CEventNotifer implements IServerObject
	{
		public function CEventNotifer()
		{
			
		}
		
		/**
		 *java调用此方法唤醒指定事件
		 */
        public function fireEvent(tagetId:String,funId:String,evt:Object):void{
        	if(tagetId!=null && funId!=null){
        		var pool:ObjectPool =ObjectPool.INSTANCE;
        		var uidStr:String=tagetId+funId;
        		var listenerArr:Array=pool.getObject(uidStr) as Array;
        		
        		var taget:Object=listenerArr[0];
        		var fun:Object=listenerArr[1];
        		if(taget!=null){
        			if(fun!=null && (fun is Function)){
        				var listener:Function=fun as Function;
        				listener.apply(taget,[evt]);
        			}
        		}
        	}
        }
        public function fireAction(tagetId:String,funId:String,isCheck:Object):void{
        	if(tagetId!=null && funId!=null){
        		var pool:ObjectPool =ObjectPool.INSTANCE;
        		var uidStr:String=tagetId+funId;
        		var listenerArr:Array=pool.getObject(uidStr) as Array;
        		
        		var taget:Object=listenerArr[0];
        		var fun:Object=listenerArr[1];
        		if(taget!=null){
        			if(fun!=null && (fun is Function)){
        				var listener:Function=fun as Function;
        				listener.apply(taget,[isCheck]);
        			}
        		}
        	}
        }
	}
}