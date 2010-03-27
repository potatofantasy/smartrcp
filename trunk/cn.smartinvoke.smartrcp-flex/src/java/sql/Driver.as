package java.sql
{
 import cn.smartinvoke.RemoteObject;
 import java.util.Properties;
 import java.util.Properties;

[Bindable]
[RemoteClass(alias="java.sql.Driver")]
 public class Driver extends RemoteObject {
  public function Driver(){
	 super();
  }

   public function getMajorVersion():int{
	 var retObj:Object=this.call("getMajorVersion",arguments);
	 return Number(retObj);

   }
   public function connect(url:String,info:Properties):Connection{
	 var retObj:Object=this.call("connect",arguments);
	 return retObj as Connection;

   }
   public function acceptsURL(url:String):Boolean{
	 var retObj:Object=this.call("acceptsURL",arguments);
	 return retObj as Boolean;

   }
   public function jdbcCompliant():Boolean{
	 var retObj:Object=this.call("jdbcCompliant",arguments);
	 return retObj as Boolean;

   }
   public function getPropertyInfo(url:String,info:Properties):Array{
	 var retObj:Object=this.call("getPropertyInfo",arguments);
	 return retObj as Array;

   }
   public function getMinorVersion():int{
	 var retObj:Object=this.call("getMinorVersion",arguments);
	 return Number(retObj);

   }
 }

}
