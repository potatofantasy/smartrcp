package java.sql
{
 import cn.smartinvoke.RemoteObject;

[Bindable]
[RemoteClass(alias="java.sql.RowId")]
 public class RowId extends RemoteObject {
  public function RowId(){
	 super();
  }

   public function getBytes():Array{
	 var retObj:Object=this.call("getBytes",arguments);
	 return retObj as Array;

   }
   public function equals(obj:Object):Boolean{
	 var retObj:Object=this.call("equals",arguments);
	 return retObj as Boolean;

   }
   public function hashCode():int{
	 var retObj:Object=this.call("hashCode",arguments);
	 return Number(retObj);

   }
   public function toString():String{
	 var retObj:Object=this.call("toString",arguments);
	 return retObj as String;

   }
 }

}
