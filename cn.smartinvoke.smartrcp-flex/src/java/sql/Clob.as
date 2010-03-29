package java.sql
{
 import cn.smartinvoke.RemoteObject;
 import java.sql.Clob;
 import java.io.Writer;
 import java.io.InputStream;
 import java.io.Reader;
 import java.io.Reader;
 import java.io.OutputStream;

[Bindable]
[RemoteClass(alias="java.sql.Clob")]
 public class Clob extends RemoteObject {
  public function Clob(){
	 super();
  }

   public function position(searchstr:String,start:Number):Number{
	 var retObj:Object=this.call("position",arguments);
	 return Number(retObj);

   }
   public function position1(searchstr:Clob,start:Number):Number{
	 var retObj:Object=this.call("position",arguments);
	 return Number(retObj);

   }
   public function free():void{
	 var retObj:Object=this.call("free",arguments);

   }
  /*  public function setCharacterStream(pos:Number):Writer{
	 var retObj:Object=this.call("setCharacterStream",arguments);
	 return retObj as Writer;

   } */
   public function truncate(len:Number):void{
	 var retObj:Object=this.call("truncate",arguments);

   }
   public function getSubString(pos:Number,length:int):String{
	 var retObj:Object=this.call("getSubString",arguments);
	 return retObj as String;

   }
   public function setString(pos:Number,str:String):int{
	 var retObj:Object=this.call("setString",arguments);
	 return Number(retObj);

   }
   public function setString1(pos:Number,str:String,offset:int,len:int):int{
	 var retObj:Object=this.call("setString",arguments);
	 return Number(retObj);

   }
   public function getAsciiStream():InputStream{
	 var retObj:Object=this.call("getAsciiStream",arguments);
	 return retObj as InputStream;

   }
   public function length():Number{
	 var retObj:Object=this.call("length",arguments);
	 return Number(retObj);

   }
   public function getCharacterStream():Reader{
	 var retObj:Object=this.call("getCharacterStream",arguments);
	 return retObj as Reader;

   }
   public function getCharacterStream1(pos:Number,length:Number):Reader{
	 var retObj:Object=this.call("getCharacterStream",arguments);
	 return retObj as Reader;

   }
   public function setAsciiStream(pos:Number):OutputStream{
	 var retObj:Object=this.call("setAsciiStream",arguments);
	 return retObj as OutputStream;

   }
 }

}
