package java.sql
{
 import cn.smartinvoke.RemoteObject;
 import java.sql.SQLWarning;

[Bindable]
[RemoteClass(alias="java.sql.DataTruncation")]
 public class DataTruncation extends SQLWarning {
  public function DataTruncation(){
	 super();
  }

  public static function create_DataTruncation(index:int,parameter:Boolean,read:Boolean,dataSize:int,transferSize:int):DataTruncation{
	   var remoteObj:DataTruncation=new DataTruncation();
	   remoteObj.createRemoteObject(null,arguments);
	   return remoteObj;
  }

  public static function create_DataTruncation1(index:int,parameter:Boolean,read:Boolean,dataSize:int,transferSize:int,cause:Throwable):DataTruncation{
	   var remoteObj:DataTruncation=new DataTruncation();
	   remoteObj.createRemoteObject(null,arguments);
	   return remoteObj;
  }

   public function getParameter():Boolean{
	 var retObj:Object=this.call("getParameter",arguments);
	 return retObj as Boolean;

   }
   public function getIndex():int{
	 var retObj:Object=this.call("getIndex",arguments);
	 return Number(retObj);

   }
   public function getDataSize():int{
	 var retObj:Object=this.call("getDataSize",arguments);
	 return Number(retObj);

   }
   public function getRead():Boolean{
	 var retObj:Object=this.call("getRead",arguments);
	 return retObj as Boolean;

   }
   public function getTransferSize():int{
	 var retObj:Object=this.call("getTransferSize",arguments);
	 return Number(retObj);

   }
 }

}
