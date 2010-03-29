package java.sql
{
 import cn.smartinvoke.RemoteObject;

[Bindable]
[RemoteClass(alias="java.sql.Wrapper")]
 public class Wrapper extends RemoteObject {
  public function Wrapper(){
	 super();
  }

  /*  public function unwrap(iface:Class):T{
	 var retObj:Object=this.call("unwrap",arguments);
	 return retObj as T;

   }
   public function isWrapperFor(iface:Class):Boolean{
	 var retObj:Object=this.call("isWrapperFor",arguments);
	 return retObj as Boolean;

   } */
 }

}
