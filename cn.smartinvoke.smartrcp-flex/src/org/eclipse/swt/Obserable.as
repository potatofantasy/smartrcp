package org.eclipse.swt
{
	import cn.smartinvoke.RemoteObject;
	import cn.smartinvoke.smartrcp.gui.control.EventRegister;

	public class Obserable extends RemoteObject
	{
		public function Obserable(param:Array=null)
		{
			super(param);
		}
		public function addListener(type:int,listener:Function,taget:Object=null):void{
  	        EventRegister.Instance.addListener(this,type,listener,taget);
        }
        public function removeListener(type:int,listener:Function,taget:Object=null):void{
  	        EventRegister.Instance.removeListener(this,type,listener,taget);
        }
	}
}