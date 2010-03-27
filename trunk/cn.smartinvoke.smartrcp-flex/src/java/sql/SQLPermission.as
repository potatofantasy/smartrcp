package java.sql
{
 import cn.smartinvoke.RemoteObject;
 import java.security.BasicPermission;

[Bindable]
[RemoteClass(alias="java.sql.SQLPermission")]
 public class SQLPermission extends BasicPermission {
  public function SQLPermission(){
	 super();
  }

  public static function create_SQLPermission(name:String):SQLPermission{
	   var remoteObj:SQLPermission=new SQLPermission();
	   remoteObj.createRemoteObject(null,arguments);
	   return remoteObj;
  }

  public static function create_SQLPermission1(name:String,actions:String):SQLPermission{
	   var remoteObj:SQLPermission=new SQLPermission();
	   remoteObj.createRemoteObject(null,arguments);
	   return remoteObj;
  }

 }

}
