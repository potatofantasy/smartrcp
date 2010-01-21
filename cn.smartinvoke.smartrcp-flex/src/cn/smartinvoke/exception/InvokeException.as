package cn.smartinvoke.exception
{
	import mx.controls.Alert;
	
	[Bindable]
	[RemoteClass(alias="cn.smartinvoke.exception.InvokeException")]
	public class InvokeException extends Error
	{
		//public var message:String;
		public function InvokeException(message:String=null)
		{
			this.message=message;
			//Alert.show(message);
		}
        
	}
}