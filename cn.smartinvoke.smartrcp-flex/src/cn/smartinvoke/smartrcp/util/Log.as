package cn.smartinvoke.smartrcp.util
{
	import mx.controls.Alert;
	
	public class Log
	{
		public function Log()
		{
		}
       public static function println(obj:Object):void{
       	  var str:String=obj+"";
       	  Alert.show(str);
       	  
       }
	}
}