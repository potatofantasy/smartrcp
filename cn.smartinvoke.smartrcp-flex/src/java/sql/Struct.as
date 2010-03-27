package java.sql
{
 import cn.smartinvoke.RemoteObject;

[Bindable]
[RemoteClass(alias="java.sql.Struct")]
 public class Struct extends RemoteObject {
  public function Struct(){
	 super();
  }

   public function getSQLTypeName():String{
	 var retObj:Object=this.call("getSQLTypeName",arguments);
	 return retObj as String;

   }
   public function getAttributes():Array{
	 var retObj:Object=this.call("getAttributes",arguments);
	 return retObj as Array;

   }
   public function getAttributes1(map:Object):Array{
	 var retObj:Object=this.call("getAttributes",arguments);
	 return retObj as Array;

   }
 }

}
