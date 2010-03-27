package java.sql
{
 import cn.smartinvoke.RemoteObject;
 import java.sql.Blob;
 import java.io.OutputStream;
 import java.io.InputStream;
 import java.io.InputStream;

[Bindable]
[RemoteClass(alias="java.sql.Blob")]
 public class Blob extends RemoteObject {
  public function Blob(){
	 super();
  }

   public function position(pattern[]:int,start:Number):Number{
	 var retObj:Object=this.call("position",arguments);
	 return Number(retObj);

   }
   public function position1(pattern:Blob,start:Number):Number{
	 var retObj:Object=this.call("position",arguments);
	 return Number(retObj);

   }
   public function getBytes(pos:Number,length:int):Array{
	 var retObj:Object=this.call("getBytes",arguments);
	 return retObj as Array;

   }
   public function free():void{
	 var retObj:Object=this.call("free",arguments);

   }
   public function setBytes(pos:Number,bytes:Array):int{
	 var retObj:Object=this.call("setBytes",arguments);
	 return Number(retObj);

   }
   public function setBytes1(pos:Number,bytes:Array,offset:int,len:int):int{
	 var retObj:Object=this.call("setBytes",arguments);
	 return Number(retObj);

   }
   public function truncate(len:Number):void{
	 var retObj:Object=this.call("truncate",arguments);

   }
   public function length():Number{
	 var retObj:Object=this.call("length",arguments);
	 return Number(retObj);

   }
   public function setBinaryStream(pos:Number):OutputStream{
	 var retObj:Object=this.call("setBinaryStream",arguments);
	 return retObj as OutputStream;

   }
   public function getBinaryStream():InputStream{
	 var retObj:Object=this.call("getBinaryStream",arguments);
	 return retObj as InputStream;

   }
   public function getBinaryStream1(pos:Number,length:Number):InputStream{
	 var retObj:Object=this.call("getBinaryStream",arguments);
	 return retObj as InputStream;

   }
 }

}
