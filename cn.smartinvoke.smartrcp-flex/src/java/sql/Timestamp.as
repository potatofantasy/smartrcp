package java.sql
{
 import cn.smartinvoke.RemoteObject;

[Bindable]
[RemoteClass(alias="java.sql.Timestamp")]
 public class Timestamp extends RemoteObject {
  public function Timestamp(){
	 super();
  }

   public function after(ts:Timestamp):Boolean{
	 var retObj:Object=this.call("after",arguments);
	 return retObj as Boolean;

   }
   public function setTime(time:Number):void{
	 var retObj:Object=this.call("setTime",arguments);

   }
   public function getTime():Number{
	 var retObj:Object=this.call("getTime",arguments);
	 return Number(retObj);

   }
   public function equals(ts:Timestamp):Boolean{
	 var retObj:Object=this.call("equals",arguments);
	 return retObj as Boolean;

   }
   public function equals1(ts:Object):Boolean{
	 var retObj:Object=this.call("equals",arguments);
	 return retObj as Boolean;

   }
   public function before(ts:Timestamp):Boolean{
	 var retObj:Object=this.call("before",arguments);
	 return retObj as Boolean;

   }
   public function setNanos(n:int):void{
	 var retObj:Object=this.call("setNanos",arguments);

   }
   public function getNanos():int{
	 var retObj:Object=this.call("getNanos",arguments);
	 return Number(retObj);

   }
   public function compareTo(ts:Timestamp):int{
	 var retObj:Object=this.call("compareTo",arguments);
	 return Number(retObj);

   }
   public function compareTo1(o:RemoteObject):int{
	 var retObj:Object=this.call("compareTo",arguments);
	 return Number(retObj);

   }
   public function toString():String{
	 var retObj:Object=this.call("toString",arguments);
	 return retObj as String;

   }
  /* public static function create_Timestamp(year:int,month:int,date:int,hour:int,minute:int,second:int,nano:int):Timestamp{
	   var remoteObj:Timestamp=new Timestamp();
	   remoteObj.createRemoteObject(null,arguments);
	   return remoteObj;
  }

  public static function create_Timestamp1(time:Number):Timestamp{
	   var remoteObj:Timestamp=new Timestamp();
	   remoteObj.createRemoteObject(null,arguments);
	   return remoteObj;
  } */

 }

}
