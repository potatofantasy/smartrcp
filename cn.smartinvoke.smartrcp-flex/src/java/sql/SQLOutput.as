package java.sql
{
 import cn.smartinvoke.RemoteObject;
 import java.sql.Date;
 import java.io.InputStream;
 import java.io.Reader;
 import java.math.BigDecimal;
 import java.sql.Time;
 import java.io.InputStream;
 import java.sql.Timestamp;
 import java.net.URL;

[Bindable]
[RemoteClass(alias="java.sql.SQLOutput")]
 public class SQLOutput extends RemoteObject {
  public function SQLOutput(){
	 super();
  }

   public function writeDate(x:Date):void{
	 var retObj:Object=this.call("writeDate",arguments);

   }
   public function writeBinaryStream(x:InputStream):void{
	 var retObj:Object=this.call("writeBinaryStream",arguments);

   }
   public function writeCharacterStream(x:Reader):void{
	 var retObj:Object=this.call("writeCharacterStream",arguments);

   }
   public function writeFloat(x:Number):void{
	 var retObj:Object=this.call("writeFloat",arguments);

   }
   public function writeDouble(x:Number):void{
	 var retObj:Object=this.call("writeDouble",arguments);

   }
   public function writeLong(x:Number):void{
	 var retObj:Object=this.call("writeLong",arguments);

   }
   public function writeBigDecimal(x:BigDecimal):void{
	 var retObj:Object=this.call("writeBigDecimal",arguments);

   }
   public function writeRowId(x:RowId):void{
	 var retObj:Object=this.call("writeRowId",arguments);

   }
   public function writeObject(x:SQLData):void{
	 var retObj:Object=this.call("writeObject",arguments);

   }
   public function writeTime(x:Time):void{
	 var retObj:Object=this.call("writeTime",arguments);

   }
   public function writeShort(x:int):void{
	 var retObj:Object=this.call("writeShort",arguments);

   }
   public function writeAsciiStream(x:InputStream):void{
	 var retObj:Object=this.call("writeAsciiStream",arguments);

   }
   public function writeNString(x:String):void{
	 var retObj:Object=this.call("writeNString",arguments);

   }
   public function writeByte(x:int):void{
	 var retObj:Object=this.call("writeByte",arguments);

   }
   public function writeSQLXML(x:SQLXML):void{
	 var retObj:Object=this.call("writeSQLXML",arguments);

   }
   public function writeArray(x:Array):void{
	 var retObj:Object=this.call("writeArray",arguments);

   }
   public function writeNClob(x:NClob):void{
	 var retObj:Object=this.call("writeNClob",arguments);

   }
   public function writeClob(x:Clob):void{
	 var retObj:Object=this.call("writeClob",arguments);

   }
   public function writeBlob(x:Blob):void{
	 var retObj:Object=this.call("writeBlob",arguments);

   }
   public function writeStruct(x:Struct):void{
	 var retObj:Object=this.call("writeStruct",arguments);

   }
   public function writeTimestamp(x:Timestamp):void{
	 var retObj:Object=this.call("writeTimestamp",arguments);

   }
   public function writeBytes(x:Array):void{
	 var retObj:Object=this.call("writeBytes",arguments);

   }
   public function writeInt(x:int):void{
	 var retObj:Object=this.call("writeInt",arguments);

   }
   public function writeString(x:String):void{
	 var retObj:Object=this.call("writeString",arguments);

   }
   public function writeBoolean(x:Boolean):void{
	 var retObj:Object=this.call("writeBoolean",arguments);

   }
   public function writeRef(x:Ref):void{
	 var retObj:Object=this.call("writeRef",arguments);

   }
   public function writeURL(x:URL):void{
	 var retObj:Object=this.call("writeURL",arguments);

   }
 }

}
