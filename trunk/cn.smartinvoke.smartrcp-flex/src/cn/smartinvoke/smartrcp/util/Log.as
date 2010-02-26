package cn.smartinvoke.smartrcp.util
{
	import cn.smartinvoke.RemoteObject;
	
	import mx.controls.Alert;
	
	[Bindable]
	[RemoteClass(alias="cn.smartinvoke.util.Log")]
	public class Log extends RemoteObject
	{
		public static var Instance:Log=new Log();
		public function Log()
		{
			this.create('cn.smartinvoke.util.Log');
		} 
		public function println(obj:Object):void{
			this.asyncCall("trace",[obj+""]);
		}
       public static function println(obj:Object):void{
       	  var str:String=obj+"";
       	  Alert.show(str);
       	  
       }
	}
}