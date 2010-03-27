package java.sql
{
 import cn.smartinvoke.RemoteObject;

[Bindable]
[RemoteClass(alias="java.sql.Array")]
 public class Array extends RemoteObject {
  public function Array(){
	 super();
  }

   public function free():void{
	 var retObj:Object=this.call("free",arguments);

   }
   public function getBaseTypeName():String{
	 var retObj:Object=this.call("getBaseTypeName",arguments);
	 return retObj as String;

   }
   public function getBaseType():int{
	 var retObj:Object=this.call("getBaseType",arguments);
	 return Number(retObj);

   }
   public function getResultSet():ResultSet{
	 var retObj:Object=this.call("getResultSet",arguments);
	 return retObj as ResultSet;

   }
   public function getResultSet1(map:Object):ResultSet{
	 var retObj:Object=this.call("getResultSet",arguments);
	 return retObj as ResultSet;

   }
   public function getResultSet2(index:Number,count:int):ResultSet{
	 var retObj:Object=this.call("getResultSet",arguments);
	 return retObj as ResultSet;

   }
   public function getResultSet3(index:Number,count:int,map:Object):ResultSet{
	 var retObj:Object=this.call("getResultSet",arguments);
	 return retObj as ResultSet;

   }
   public function getArray():Object{
	 var retObj:Object=this.call("getArray",arguments);
	 return retObj;
   }
   public function getArray1(map:Object):Object{
	 var retObj:Object=this.call("getArray",arguments);
	 return retObj;
   }
   public function getArray2(index:Number,count:int):Object{
	 var retObj:Object=this.call("getArray",arguments);
	 return retObj;
   }
   public function getArray3(index:Number,count:int,map:Object):Object{
	 var retObj:Object=this.call("getArray",arguments);
	 return retObj;
   }
 }

}
