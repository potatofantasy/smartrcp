package java.sql
{
 import cn.smartinvoke.RemoteObject;
 import java.io.InputStream;
 import java.net.URL;
 import java.math.BigDecimal;
 import java.sql.Timestamp;
 import java.io.InputStream;
 import java.sql.Time;
 import java.io.Reader;
 import java.sql.Date;

[Bindable]
[RemoteClass(alias="java.sql.SQLInput")]
 public class SQLInput extends RemoteObject {
  public function SQLInput(){
	 super();
  }

   public function readInt():int{
	 var retObj:Object=this.call("readInt",arguments);
	 return Number(retObj);

   }
   public function readBinaryStream():InputStream{
	 var retObj:Object=this.call("readBinaryStream",arguments);
	 return retObj as InputStream;

   }
   public function readClob():Clob{
	 var retObj:Object=this.call("readClob",arguments);
	 return retObj as Clob;

   }
   public function wasNull():Boolean{
	 var retObj:Object=this.call("wasNull",arguments);
	 return retObj as Boolean;

   }
   public function readURL():URL{
	 var retObj:Object=this.call("readURL",arguments);
	 return retObj as URL;

   }
   public function readBigDecimal():BigDecimal{
	 var retObj:Object=this.call("readBigDecimal",arguments);
	 return retObj as BigDecimal;

   }
   public function readNClob():NClob{
	 var retObj:Object=this.call("readNClob",arguments);
	 return retObj as NClob;

   }
   public function readBlob():Blob{
	 var retObj:Object=this.call("readBlob",arguments);
	 return retObj as Blob;

   }
   public function readBoolean():Boolean{
	 var retObj:Object=this.call("readBoolean",arguments);
	 return retObj as Boolean;

   }
   public function readArray():Array{
	 var retObj:Object=this.call("readArray",arguments);
	 return retObj as Array;

   }
   public function readBytes():Array{
	 var retObj:Object=this.call("readBytes",arguments);
	 return retObj as Array;

   }
   public function readTimestamp():Timestamp{
	 var retObj:Object=this.call("readTimestamp",arguments);
	 return retObj as Timestamp;

   }
   public function readByte():int{
	 var retObj:Object=this.call("readByte",arguments);
	 return Number(retObj);

   }
   public function readLong():Number{
	 var retObj:Object=this.call("readLong",arguments);
	 return Number(retObj);

   }
   public function readAsciiStream():InputStream{
	 var retObj:Object=this.call("readAsciiStream",arguments);
	 return retObj as InputStream;

   }
   public function readTime():Time{
	 var retObj:Object=this.call("readTime",arguments);
	 return retObj as Time;

   }
   public function readCharacterStream():Reader{
	 var retObj:Object=this.call("readCharacterStream",arguments);
	 return retObj as Reader;

   }
   public function readString():String{
	 var retObj:Object=this.call("readString",arguments);
	 return retObj as String;

   }
   public function readObject():Object{
	 var retObj:Object=this.call("readObject",arguments);
	 return retObj;
   }
   public function readShort():int{
	 var retObj:Object=this.call("readShort",arguments);
	 return Number(retObj);

   }
   public function readSQLXML():SQLXML{
	 var retObj:Object=this.call("readSQLXML",arguments);
	 return retObj as SQLXML;

   }
   public function readDate():Date{
	 var retObj:Object=this.call("readDate",arguments);
	 return retObj as Date;

   }
   public function readDouble():Number{
	 var retObj:Object=this.call("readDouble",arguments);
	 return Number(retObj);

   }
   public function readRef():Ref{
	 var retObj:Object=this.call("readRef",arguments);
	 return retObj as Ref;

   }
   public function readNString():String{
	 var retObj:Object=this.call("readNString",arguments);
	 return retObj as String;

   }
   public function readRowId():RowId{
	 var retObj:Object=this.call("readRowId",arguments);
	 return retObj as RowId;

   }
   public function readFloat():Number{
	 var retObj:Object=this.call("readFloat",arguments);
	 return Number(retObj);

   }
 }

}
