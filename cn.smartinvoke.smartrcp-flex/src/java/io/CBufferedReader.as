package java.io
{
	import cn.smartinvoke.RemoteObject;
	
	[Bindable]
	[RemoteClass(alias="java.io.BufferedReader")]
	public class CBufferedReader extends RemoteObject
	{
		
		public function CBufferedReader(path:String)
		{
			this.createRemoteObject(arguments);
		}
        public function readLine():String{
        	return this.call('readLine',arguments) as String;
        }
	}
}