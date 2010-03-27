package java.sql
{
 import cn.smartinvoke.RemoteObject;
 import java.sql.Savepoint;

[Bindable]
[RemoteClass(alias="java.sql.Savepoint")]
 public class Savepoint extends RemoteObject {
  public function Savepoint(){
	 super();
  }

   public function getSavepointName():String{
	 var retObj:Object=this.call("getSavepointName",arguments);
	 return retObj as String;

   }
   public function getSavepointId():Savepoint{
	 var retObj:Object=this.call("getSavepointId",arguments);
	 return retObj as Savepoint;

   }
 }

}
