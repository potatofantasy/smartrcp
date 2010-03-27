package java.sql
{
 import cn.smartinvoke.RemoteObject;

[Bindable]
[RemoteClass(alias="java.sql.DriverPropertyInfo")]
 public class DriverPropertyInfo extends RemoteObject {
  public function DriverPropertyInfo(){
	 super();
  }

  public static function create_DriverPropertyInfo(name:String,value:String):DriverPropertyInfo{
	   var remoteObj:DriverPropertyInfo=new DriverPropertyInfo();
	   remoteObj.createRemoteObject(null,arguments);
	   return remoteObj;
  }

 }

}
