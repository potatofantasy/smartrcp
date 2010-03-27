package java.sql
{
 import cn.smartinvoke.RemoteObject;

[Bindable]
[RemoteClass(alias="java.sql.Time")]
 public class Time extends java.util.Date {
  public function Time(){
	 super();
  }

   public function setDate(i:int):void{
	 var retObj:Object=this.call("setDate",arguments);

   }
   public function setTime(time:Number):void{
	 var retObj:Object=this.call("setTime",arguments);

   }
   public function getDate():int{
	 var retObj:Object=this.call("getDate",arguments);
	 return Number(retObj);

   }
  public static function create_Time(hour:int,minute:int,second:int):Time{
	   var remoteObj:Time=new Time();
	   remoteObj.createRemoteObject(null,arguments);
	   return remoteObj;
  }

  public static function create_Time1(time:Number):Time{
	   var remoteObj:Time=new Time();
	   remoteObj.createRemoteObject(null,arguments);
	   return remoteObj;
  }

   public function setYear(i:int):void{
	 var retObj:Object=this.call("setYear",arguments);

   }
   public function getMonth():int{
	 var retObj:Object=this.call("getMonth",arguments);
	 return Number(retObj);

   }
   public function getDay():int{
	 var retObj:Object=this.call("getDay",arguments);
	 return Number(retObj);

   }
   public function toString():String{
	 var retObj:Object=this.call("toString",arguments);
	 return retObj as String;

   }
   public function setMonth(i:int):void{
	 var retObj:Object=this.call("setMonth",arguments);

   }
   public function getYear():int{
	 var retObj:Object=this.call("getYear",arguments);
	 return Number(retObj);

   }
 }

}
