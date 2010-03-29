package java.sql
{
 import cn.smartinvoke.RemoteObject;

[Bindable]
[RemoteClass(alias="java.sql.Date")]
 public class Date extends RemoteObject {
  public function Date(){
	 super();
	 
  } 

   public function setTime(date:Number):void{
	 var retObj:Object=this.call("setTime",arguments);

   }
   public function getSeconds():int{
	 var retObj:Object=this.call("getSeconds",arguments);
	 return Number(retObj);

   }
   public function setHours(i:int):void{
	 var retObj:Object=this.call("setHours",arguments);

   }
 /*  public static function create_Date(year:int,month:int,day:int):Date{
	   var remoteObj:Date=new Date();
	   remoteObj.createRemoteObject(null,arguments);
	   return remoteObj;
  }

  public static function create_Date1(date:Number):Date{
	   var remoteObj:Date=new Date();
	   remoteObj.createRemoteObject(null,arguments);
	   return remoteObj;
  } */

   public function getHours():int{
	 var retObj:Object=this.call("getHours",arguments);
	 return Number(retObj);

   }
   public function setSeconds(i:int):void{
	 var retObj:Object=this.call("setSeconds",arguments);

   }
   public function toString():String{
	 var retObj:Object=this.call("toString",arguments);
	 return retObj as String;

   }
   public function setMinutes(i:int):void{
	 var retObj:Object=this.call("setMinutes",arguments);

   }
   public function getMinutes():int{
	 var retObj:Object=this.call("getMinutes",arguments);
	 return Number(retObj);

   }
 }

}
