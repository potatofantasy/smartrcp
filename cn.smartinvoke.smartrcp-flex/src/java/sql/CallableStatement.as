package java.sql
{
 import cn.smartinvoke.RemoteObject;
 import java.sql.PreparedStatement;
 import java.io.InputStream;
 import java.io.InputStream;
 import java.io.InputStream;
 import java.io.Reader;
 import java.io.Reader;
 import java.math.BigDecimal;
 import java.net.URL;
 import java.math.BigDecimal;
 import java.math.BigDecimal;
 import java.math.BigDecimal;
 import java.sql.Timestamp;
 import java.sql.Timestamp;
 import java.util.Calendar;
 import java.sql.Date;
 import java.util.Calendar;
 import java.sql.Date;
 import java.sql.Date;
 import java.util.Calendar;
 import java.sql.Date;
 import java.io.Reader;
 import java.io.Reader;
 import java.io.Reader;
 import java.net.URL;
 import java.net.URL;
 import java.io.InputStream;
 import java.io.InputStream;
 import java.io.InputStream;
 import java.io.InputStream;
 import java.io.InputStream;
 import java.io.Reader;
 import java.io.Reader;
 import java.io.Reader;
 import java.io.Reader;
 import java.sql.Timestamp;
 import java.util.Calendar;
 import java.sql.Timestamp;
 import java.sql.Timestamp;
 import java.util.Calendar;
 import java.sql.Timestamp;
 import java.sql.Time;
 import java.sql.Time;
 import java.util.Calendar;
 import java.io.Reader;
 import java.io.Reader;
 import java.sql.Date;
 import java.sql.Date;
 import java.util.Calendar;
 import java.sql.Time;
 import java.util.Calendar;
 import java.sql.Time;
 import java.sql.Time;
 import java.util.Calendar;
 import java.sql.Time;
 import java.io.Reader;
 import java.io.Reader;

[Bindable]
[RemoteClass(alias="java.sql.CallableStatement")]
 public class CallableStatement extends PreparedStatement {
  public function CallableStatement(){
	 super();
  }

   public function setFloat(parameterName:String,x:Number):void{
	 var retObj:Object=this.call("setFloat",arguments);

   }
   public function getSQLXML(parameterIndex:int):SQLXML{
	 var retObj:Object=this.call("getSQLXML",arguments);
	 return retObj as SQLXML;

   }
   public function getSQLXML1(parameterName:String):SQLXML{
	 var retObj:Object=this.call("getSQLXML",arguments);
	 return retObj as SQLXML;

   }
   public function getBoolean(parameterIndex:int):Boolean{
	 var retObj:Object=this.call("getBoolean",arguments);
	 return retObj as Boolean;

   }
   public function getBoolean1(parameterName:String):Boolean{
	 var retObj:Object=this.call("getBoolean",arguments);
	 return retObj as Boolean;

   }
   public function wasNull():Boolean{
	 var retObj:Object=this.call("wasNull",arguments);
	 return retObj as Boolean;

   }
   public function setBoolean(parameterName:String,x:Boolean):void{
	 var retObj:Object=this.call("setBoolean",arguments);

   }
   public function setBinaryStream(parameterName:String,x:InputStream,length:int):void{
	 var retObj:Object=this.call("setBinaryStream",arguments);

   }
   public function setBinaryStream1(parameterName:String,x:InputStream,length:Number):void{
	 var retObj:Object=this.call("setBinaryStream",arguments);

   }
   public function setBinaryStream2(parameterName:String,x:InputStream):void{
	 var retObj:Object=this.call("setBinaryStream",arguments);

   }
   public function getClob(parameterIndex:int):Clob{
	 var retObj:Object=this.call("getClob",arguments);
	 return retObj as Clob;

   }
   public function getClob1(parameterName:String):Clob{
	 var retObj:Object=this.call("getClob",arguments);
	 return retObj as Clob;

   }
   public function setDouble(parameterName:String,x:Number):void{
	 var retObj:Object=this.call("setDouble",arguments);

   }
   public function getNCharacterStream(parameterIndex:int):Reader{
	 var retObj:Object=this.call("getNCharacterStream",arguments);
	 return retObj as Reader;

   }
   public function getNCharacterStream1(parameterName:String):Reader{
	 var retObj:Object=this.call("getNCharacterStream",arguments);
	 return retObj as Reader;

   }
   public function setBigDecimal(parameterName:String,x:BigDecimal):void{
	 var retObj:Object=this.call("setBigDecimal",arguments);

   }
   public function setURL(parameterName:String,val:URL):void{
	 var retObj:Object=this.call("setURL",arguments);

   }
   public function setLong(parameterName:String,x:Number):void{
	 var retObj:Object=this.call("setLong",arguments);

   }
   public function getObject(parameterIndex:int):Object{
	 var retObj:Object=this.call("getObject",arguments);
	 return retObj;
   }
   public function getObject1(parameterIndex:int,map:Object):Object{
	 var retObj:Object=this.call("getObject",arguments);
	 return retObj;
   }
   public function getObject2(parameterName:String):Object{
	 var retObj:Object=this.call("getObject",arguments);
	 return retObj;
   }
   public function getObject3(parameterName:String,map:Object):Object{
	 var retObj:Object=this.call("getObject",arguments);
	 return retObj;
   }
   public function getBigDecimal(parameterIndex:int,scale:int):BigDecimal{
	 var retObj:Object=this.call("getBigDecimal",arguments);
	 return retObj as BigDecimal;

   }
   public function getBigDecimal1(parameterIndex:int):BigDecimal{
	 var retObj:Object=this.call("getBigDecimal",arguments);
	 return retObj as BigDecimal;

   }
   public function getBigDecimal2(parameterName:String):BigDecimal{
	 var retObj:Object=this.call("getBigDecimal",arguments);
	 return retObj as BigDecimal;

   }
   public function getBytes(parameterIndex:int):Array{
	 var retObj:Object=this.call("getBytes",arguments);
	 return retObj as Array;

   }
   public function getBytes1(parameterName:String):Array{
	 var retObj:Object=this.call("getBytes",arguments);
	 return retObj as Array;

   }
   public function getShort(parameterIndex:int):int{
	 var retObj:Object=this.call("getShort",arguments);
	 return Number(retObj);

   }
   public function getShort1(parameterName:String):int{
	 var retObj:Object=this.call("getShort",arguments);
	 return Number(retObj);

   }
   public function setTimestamp(parameterName:String,x:Timestamp):void{
	 var retObj:Object=this.call("setTimestamp",arguments);

   }
   public function setTimestamp1(parameterName:String,x:Timestamp,cal:Calendar):void{
	 var retObj:Object=this.call("setTimestamp",arguments);

   }
   public function getArray(parameterIndex:int):Array{
	 var retObj:Object=this.call("getArray",arguments);
	 return retObj as Array;

   }
   public function getArray1(parameterName:String):Array{
	 var retObj:Object=this.call("getArray",arguments);
	 return retObj as Array;

   }
   public function getDate(parameterIndex:int):Date{
	 var retObj:Object=this.call("getDate",arguments);
	 return retObj as Date;

   }
   public function getDate1(parameterIndex:int,cal:Calendar):Date{
	 var retObj:Object=this.call("getDate",arguments);
	 return retObj as Date;

   }
   public function getDate2(parameterName:String):Date{
	 var retObj:Object=this.call("getDate",arguments);
	 return retObj as Date;

   }
   public function getDate3(parameterName:String,cal:Calendar):Date{
	 var retObj:Object=this.call("getDate",arguments);
	 return retObj as Date;

   }
   public function setCharacterStream(parameterName:String,reader:Reader,length:int):void{
	 var retObj:Object=this.call("setCharacterStream",arguments);

   }
   public function setCharacterStream1(parameterName:String,reader:Reader,length:Number):void{
	 var retObj:Object=this.call("setCharacterStream",arguments);

   }
   public function setCharacterStream2(parameterName:String,reader:Reader):void{
	 var retObj:Object=this.call("setCharacterStream",arguments);

   }
   public function setByte(parameterName:String,x:int):void{
	 var retObj:Object=this.call("setByte",arguments);

   }
   public function getBlob(parameterIndex:int):Blob{
	 var retObj:Object=this.call("getBlob",arguments);
	 return retObj as Blob;

   }
   public function getBlob1(parameterName:String):Blob{
	 var retObj:Object=this.call("getBlob",arguments);
	 return retObj as Blob;

   }
   public function setRowId(parameterName:String,x:RowId):void{
	 var retObj:Object=this.call("setRowId",arguments);

   }
   public function getNString(parameterIndex:int):String{
	 var retObj:Object=this.call("getNString",arguments);
	 return retObj as String;

   }
   public function getNString1(parameterName:String):String{
	 var retObj:Object=this.call("getNString",arguments);
	 return retObj as String;

   }
   public function getURL(parameterIndex:int):URL{
	 var retObj:Object=this.call("getURL",arguments);
	 return retObj as URL;

   }
   public function getURL1(parameterName:String):URL{
	 var retObj:Object=this.call("getURL",arguments);
	 return retObj as URL;

   }
   public function setAsciiStream(parameterName:String,x:InputStream,length:int):void{
	 var retObj:Object=this.call("setAsciiStream",arguments);

   }
   public function setAsciiStream1(parameterName:String,x:InputStream,length:Number):void{
	 var retObj:Object=this.call("setAsciiStream",arguments);

   }
   public function setAsciiStream2(parameterName:String,x:InputStream):void{
	 var retObj:Object=this.call("setAsciiStream",arguments);

   }
   public function getString(parameterIndex:int):String{
	 var retObj:Object=this.call("getString",arguments);
	 return retObj as String;

   }
   public function getString1(parameterName:String):String{
	 var retObj:Object=this.call("getString",arguments);
	 return retObj as String;

   }
   public function getFloat(parameterIndex:int):Number{
	 var retObj:Object=this.call("getFloat",arguments);
	 return Number(retObj);

   }
   public function getFloat1(parameterName:String):Number{
	 var retObj:Object=this.call("getFloat",arguments);
	 return Number(retObj);

   }
   public function getDouble(parameterIndex:int):Number{
	 var retObj:Object=this.call("getDouble",arguments);
	 return Number(retObj);

   }
   public function getDouble1(parameterName:String):Number{
	 var retObj:Object=this.call("getDouble",arguments);
	 return Number(retObj);

   }
   public function setBytes(parameterName:String,x[]:int):void{
	 var retObj:Object=this.call("setBytes",arguments);

   }
   public function setString(parameterName:String,x:String):void{
	 var retObj:Object=this.call("setString",arguments);

   }
   public function setBlob(parameterName:String,inputStream:InputStream,length:Number):void{
	 var retObj:Object=this.call("setBlob",arguments);

   }
   public function setBlob1(parameterName:String,x:Blob):void{
	 var retObj:Object=this.call("setBlob",arguments);

   }
   public function setBlob2(parameterName:String,inputStream:InputStream):void{
	 var retObj:Object=this.call("setBlob",arguments);

   }
   public function setNCharacterStream(parameterName:String,value:Reader,length:Number):void{
	 var retObj:Object=this.call("setNCharacterStream",arguments);

   }
   public function setNCharacterStream1(parameterName:String,value:Reader):void{
	 var retObj:Object=this.call("setNCharacterStream",arguments);

   }
   public function setNClob(parameterName:String,value:NClob):void{
	 var retObj:Object=this.call("setNClob",arguments);

   }
   public function setNClob1(parameterName:String,reader:Reader,length:Number):void{
	 var retObj:Object=this.call("setNClob",arguments);

   }
   public function setNClob2(parameterName:String,reader:Reader):void{
	 var retObj:Object=this.call("setNClob",arguments);

   }
   public function registerOutParameter(parameterIndex:int,sqlType:int):void{
	 var retObj:Object=this.call("registerOutParameter",arguments);

   }
   public function registerOutParameter1(parameterIndex:int,sqlType:int,scale:int):void{
	 var retObj:Object=this.call("registerOutParameter",arguments);

   }
   public function registerOutParameter2(parameterIndex:int,sqlType:int,typeName:String):void{
	 var retObj:Object=this.call("registerOutParameter",arguments);

   }
   public function registerOutParameter3(parameterName:String,sqlType:int):void{
	 var retObj:Object=this.call("registerOutParameter",arguments);

   }
   public function registerOutParameter4(parameterName:String,sqlType:int,scale:int):void{
	 var retObj:Object=this.call("registerOutParameter",arguments);

   }
   public function registerOutParameter5(parameterName:String,sqlType:int,typeName:String):void{
	 var retObj:Object=this.call("registerOutParameter",arguments);

   }
   public function getLong(parameterIndex:int):Number{
	 var retObj:Object=this.call("getLong",arguments);
	 return Number(retObj);

   }
   public function getLong1(parameterName:String):Number{
	 var retObj:Object=this.call("getLong",arguments);
	 return Number(retObj);

   }
   public function getTimestamp(parameterIndex:int):Timestamp{
	 var retObj:Object=this.call("getTimestamp",arguments);
	 return retObj as Timestamp;

   }
   public function getTimestamp1(parameterIndex:int,cal:Calendar):Timestamp{
	 var retObj:Object=this.call("getTimestamp",arguments);
	 return retObj as Timestamp;

   }
   public function getTimestamp2(parameterName:String):Timestamp{
	 var retObj:Object=this.call("getTimestamp",arguments);
	 return retObj as Timestamp;

   }
   public function getTimestamp3(parameterName:String,cal:Calendar):Timestamp{
	 var retObj:Object=this.call("getTimestamp",arguments);
	 return retObj as Timestamp;

   }
   public function setShort(parameterName:String,x:int):void{
	 var retObj:Object=this.call("setShort",arguments);

   }
   public function getRowId(parameterIndex:int):RowId{
	 var retObj:Object=this.call("getRowId",arguments);
	 return retObj as RowId;

   }
   public function getRowId1(parameterName:String):RowId{
	 var retObj:Object=this.call("getRowId",arguments);
	 return retObj as RowId;

   }
   public function setObject(parameterName:String,x:Object,targetSqlType:int,scale:int):void{
	 var retObj:Object=this.call("setObject",arguments);

   }
   public function setObject1(parameterName:String,x:Object,targetSqlType:int):void{
	 var retObj:Object=this.call("setObject",arguments);

   }
   public function setObject2(parameterName:String,x:Object):void{
	 var retObj:Object=this.call("setObject",arguments);

   }
   public function setInt(parameterName:String,x:int):void{
	 var retObj:Object=this.call("setInt",arguments);

   }
   public function getRef(parameterIndex:int):Ref{
	 var retObj:Object=this.call("getRef",arguments);
	 return retObj as Ref;

   }
   public function getRef1(parameterName:String):Ref{
	 var retObj:Object=this.call("getRef",arguments);
	 return retObj as Ref;

   }
   public function getNClob(parameterIndex:int):NClob{
	 var retObj:Object=this.call("getNClob",arguments);
	 return retObj as NClob;

   }
   public function getNClob1(parameterName:String):NClob{
	 var retObj:Object=this.call("getNClob",arguments);
	 return retObj as NClob;

   }
   public function setTime(parameterName:String,x:Time):void{
	 var retObj:Object=this.call("setTime",arguments);

   }
   public function setTime1(parameterName:String,x:Time,cal:Calendar):void{
	 var retObj:Object=this.call("setTime",arguments);

   }
   public function getInt(parameterIndex:int):int{
	 var retObj:Object=this.call("getInt",arguments);
	 return Number(retObj);

   }
   public function getInt1(parameterName:String):int{
	 var retObj:Object=this.call("getInt",arguments);
	 return Number(retObj);

   }
   public function getByte(parameterIndex:int):int{
	 var retObj:Object=this.call("getByte",arguments);
	 return Number(retObj);

   }
   public function getByte1(parameterName:String):int{
	 var retObj:Object=this.call("getByte",arguments);
	 return Number(retObj);

   }
   public function getCharacterStream(parameterIndex:int):Reader{
	 var retObj:Object=this.call("getCharacterStream",arguments);
	 return retObj as Reader;

   }
   public function getCharacterStream1(parameterName:String):Reader{
	 var retObj:Object=this.call("getCharacterStream",arguments);
	 return retObj as Reader;

   }
   public function setDate(parameterName:String,x:Date):void{
	 var retObj:Object=this.call("setDate",arguments);

   }
   public function setDate1(parameterName:String,x:Date,cal:Calendar):void{
	 var retObj:Object=this.call("setDate",arguments);

   }
   public function getTime(parameterIndex:int):Time{
	 var retObj:Object=this.call("getTime",arguments);
	 return retObj as Time;

   }
   public function getTime1(parameterIndex:int,cal:Calendar):Time{
	 var retObj:Object=this.call("getTime",arguments);
	 return retObj as Time;

   }
   public function getTime2(parameterName:String):Time{
	 var retObj:Object=this.call("getTime",arguments);
	 return retObj as Time;

   }
   public function getTime3(parameterName:String,cal:Calendar):Time{
	 var retObj:Object=this.call("getTime",arguments);
	 return retObj as Time;

   }
   public function setNull(parameterName:String,sqlType:int):void{
	 var retObj:Object=this.call("setNull",arguments);

   }
   public function setNull1(parameterName:String,sqlType:int,typeName:String):void{
	 var retObj:Object=this.call("setNull",arguments);

   }
   public function setNString(parameterName:String,value:String):void{
	 var retObj:Object=this.call("setNString",arguments);

   }
   public function setClob(parameterName:String,reader:Reader,length:Number):void{
	 var retObj:Object=this.call("setClob",arguments);

   }
   public function setClob1(parameterName:String,x:Clob):void{
	 var retObj:Object=this.call("setClob",arguments);

   }
   public function setClob2(parameterName:String,reader:Reader):void{
	 var retObj:Object=this.call("setClob",arguments);

   }
   public function setSQLXML(parameterName:String,xmlObject:SQLXML):void{
	 var retObj:Object=this.call("setSQLXML",arguments);

   }
 }

}
