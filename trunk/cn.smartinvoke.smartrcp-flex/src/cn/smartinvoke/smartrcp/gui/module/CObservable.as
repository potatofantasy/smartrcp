package cn.smartinvoke.smartrcp.gui.module
{
	import cn.smartinvoke.RemoteObject;
	import cn.smartinvoke.smartrcp.util.HelpMethod;
    [Bindable]
	[RemoteClass(alias="cn.smartinvoke.smartrcp.gui.module.CObservable")]
	public class CObservable extends RemoteObject
	{
		public function CObservable(param:Array=null)
		{
			super(param);
		}
		//----------------------监听器
        public function addListener(listener:Function,thisObject:Object):void{
			if(listener==null){
				return;
			}
			var bean:CEventBean=HelpMethod.createEventBean(listener,thisObject);
			if(bean!=null){
			 this.call("addListener",[bean]);
			}
	   }
	   public function removeListener(
		   listener:Function,thisObject:Object):void{
		   var bean:CEventBean=HelpMethod.removeListener(listener,thisObject);
		   if(bean!=null){
		   	  this.call('removeListener',[bean]);
		   }
	   }
	}
}