package cn.smartinvoke.smartrcp.util
{
	import cn.smartinvoke.RemoteObject;
	
	import flash.utils.*;
    [Bindable]
	[RemoteClass(alias="cn.smartinvoke.smartrcp.util.UIHelpMethod")]
	public class UIHelpMethod extends RemoteObject
	{
		public function UIHelpMethod(param:Array=null)
		{
			super(param);
			this.createRemoteObject();
		}
		/**
		 *将二进制数组bytes，存储到path文件中
		 */
		public function saveImage(bytes:ByteArray,path:String):void{
			this.asyncCall('saveImage',arguments);
		}
	}
}