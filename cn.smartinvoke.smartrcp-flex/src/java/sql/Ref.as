package java.sql
{
 import cn.smartinvoke.RemoteObject;

[Bindable]
[RemoteClass(alias="java.sql.Ref")]
 public class Ref extends RemoteObject {
  public function Ref(){
	 super();
  }

   public function getBaseTypeName():String{
	 var retObj:Object=this.call("getBaseTypeName",arguments);
	 return retObj as String;

   }
   public function setObject(value:Object):void{
	 var retObj:Object=this.call("setObject",arguments);

   }
   public function getObject(map:Object):Object{
	 var retObj:Object=this.call("getObject",arguments);
	 return retObj;
   }
   public function getObject1():Object{
	 var retObj:Object=this.call("getObject",arguments);
	 return retObj;
   }
 }

}
