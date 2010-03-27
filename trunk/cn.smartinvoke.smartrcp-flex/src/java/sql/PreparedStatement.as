package java.sql
{
 import cn.smartinvoke.RemoteObject;
 import java.sql.PreparedStatement;
 import java.io.InputStream;
 import java.io.InputStream;
 import java.io.Reader;
 import java.io.Reader;
 import java.io.Reader;
 import java.io.Reader;
 import java.io.InputStream;
 import java.io.InputStream;
 import java.io.InputStream;
 import java.math.BigDecimal;
 import java.net.URL;
 import java.sql.Time;
 import java.sql.Time;
 import java.util.Calendar;
 import java.sql.Timestamp;
 import java.sql.Timestamp;
 import java.util.Calendar;
 import java.io.InputStream;
 import java.sql.Date;
 import java.sql.Date;
 import java.util.Calendar;
 import java.io.Reader;
 import java.io.Reader;
 import java.io.Reader;
 import java.io.InputStream;
 import java.io.InputStream;
 import java.io.InputStream;
 import java.io.Reader;
 import java.io.Reader;

[Bindable]
[RemoteClass(alias="java.sql.PreparedStatement")]
 public class PreparedStatement extends Statement {
  public function PreparedStatement(){
	 super();
  }

   public  override function setFloat(parameterIndex:int,x:Number):void{
	 var retObj:Object=this.call("setFloat",arguments);

   }
   public  override function setBytes(parameterIndex:int,x[]:int):void{
	 var retObj:Object=this.call("setBytes",arguments);

   }
   public  override function getMetaData():ResultSetMetaData{
	 var retObj:Object=this.call("getMetaData",arguments);
	 return retObj as ResultSetMetaData;

   }
   public  override function setString(parameterIndex:int,x:String):void{
	 var retObj:Object=this.call("setString",arguments);

   }
   public  override function setBlob(parameterIndex:int,x:Blob):void{
	 var retObj:Object=this.call("setBlob",arguments);

   }
   public  override function setBlob1(parameterIndex:int,inputStream:InputStream,length:Number):void{
	 var retObj:Object=this.call("setBlob",arguments);

   }
   public function setBlob2(parameterIndex:int,inputStream:InputStream):void{
	 var retObj:Object=this.call("setBlob",arguments);

   }
   public  override function setNClob(parameterIndex:int,value:NClob):void{
	 var retObj:Object=this.call("setNClob",arguments);

   }
   public  override function setNClob1(parameterIndex:int,reader:Reader,length:Number):void{
	 var retObj:Object=this.call("setNClob",arguments);

   }
   public function setNClob2(parameterIndex:int,reader:Reader):void{
	 var retObj:Object=this.call("setNClob",arguments);

   }
   public  override function setNCharacterStream(parameterIndex:int,value:Reader,length:Number):void{
	 var retObj:Object=this.call("setNCharacterStream",arguments);

   }
   public function setNCharacterStream1(parameterIndex:int,value:Reader):void{
	 var retObj:Object=this.call("setNCharacterStream",arguments);

   }
   public  override function setBoolean(parameterIndex:int,x:Boolean):void{
	 var retObj:Object=this.call("setBoolean",arguments);

   }
   public  override function setBinaryStream(parameterIndex:int,x:InputStream,length:int):void{
	 var retObj:Object=this.call("setBinaryStream",arguments);

   }
   public  override function setBinaryStream1(parameterIndex:int,x:InputStream,length:Number):void{
	 var retObj:Object=this.call("setBinaryStream",arguments);

   }
   public function setBinaryStream2(parameterIndex:int,x:InputStream):void{
	 var retObj:Object=this.call("setBinaryStream",arguments);

   }
   public  override function setDouble(parameterIndex:int,x:Number):void{
	 var retObj:Object=this.call("setDouble",arguments);

   }
   public  override function setShort(parameterIndex:int,x:int):void{
	 var retObj:Object=this.call("setShort",arguments);

   }
   public  override function setObject(parameterIndex:int,x:Object,targetSqlType:int):void{
	 var retObj:Object=this.call("setObject",arguments);

   }
   public function setObject1(parameterIndex:int,x:Object):void{
	 var retObj:Object=this.call("setObject",arguments);

   }
   public  override function setObject2(parameterIndex:int,x:Object,targetSqlType:int,scaleOrLength:int):void{
	 var retObj:Object=this.call("setObject",arguments);

   }
   public  override function setBigDecimal(parameterIndex:int,x:BigDecimal):void{
	 var retObj:Object=this.call("setBigDecimal",arguments);

   }
   public  override function setInt(parameterIndex:int,x:int):void{
	 var retObj:Object=this.call("setInt",arguments);

   }
   public  override function clearParameters():void{
	 var retObj:Object=this.call("clearParameters",arguments);

   }
   public  override function setURL(parameterIndex:int,x:URL):void{
	 var retObj:Object=this.call("setURL",arguments);

   }
   public  override function setLong(parameterIndex:int,x:Number):void{
	 var retObj:Object=this.call("setLong",arguments);

   }
   public  override function setArray(parameterIndex:int,x:Array):void{
	 var retObj:Object=this.call("setArray",arguments);

   }
   public  override function setTime(parameterIndex:int,x:Time):void{
	 var retObj:Object=this.call("setTime",arguments);

   }
   public  override function setTime1(parameterIndex:int,x:Time,cal:Calendar):void{
	 var retObj:Object=this.call("setTime",arguments);

   }
   public  override function execute():Boolean{
	 var retObj:Object=this.call("execute",arguments);
	 return retObj as Boolean;

   }
   public  override function setRef(parameterIndex:int,x:Ref):void{
	 var retObj:Object=this.call("setRef",arguments);

   }
   public  override function setTimestamp(parameterIndex:int,x:Timestamp):void{
	 var retObj:Object=this.call("setTimestamp",arguments);

   }
   public  override function setTimestamp1(parameterIndex:int,x:Timestamp,cal:Calendar):void{
	 var retObj:Object=this.call("setTimestamp",arguments);

   }
   public  override function executeQuery():ResultSet{
	 var retObj:Object=this.call("executeQuery",arguments);
	 return retObj as ResultSet;

   }
   public  override function setUnicodeStream(parameterIndex:int,x:InputStream,length:int):void{
	 var retObj:Object=this.call("setUnicodeStream",arguments);

   }
   public  override function addBatch():void{
	 var retObj:Object=this.call("addBatch",arguments);

   }
   public  override function executeUpdate():int{
	 var retObj:Object=this.call("executeUpdate",arguments);
	 return Number(retObj);

   }
   public  override function getParameterMetaData():ParameterMetaData{
	 var retObj:Object=this.call("getParameterMetaData",arguments);
	 return retObj as ParameterMetaData;

   }
   public  override function setDate(parameterIndex:int,x:Date):void{
	 var retObj:Object=this.call("setDate",arguments);

   }
   public  override function setDate1(parameterIndex:int,x:Date,cal:Calendar):void{
	 var retObj:Object=this.call("setDate",arguments);

   }
   public  override function setCharacterStream(parameterIndex:int,reader:Reader,length:int):void{
	 var retObj:Object=this.call("setCharacterStream",arguments);

   }
   public  override function setCharacterStream1(parameterIndex:int,reader:Reader,length:Number):void{
	 var retObj:Object=this.call("setCharacterStream",arguments);

   }
   public function setCharacterStream2(parameterIndex:int,reader:Reader):void{
	 var retObj:Object=this.call("setCharacterStream",arguments);

   }
   public  override function setNull(parameterIndex:int,sqlType:int):void{
	 var retObj:Object=this.call("setNull",arguments);

   }
   public  override function setNull1(parameterIndex:int,sqlType:int,typeName:String):void{
	 var retObj:Object=this.call("setNull",arguments);

   }
   public  override function setNString(parameterIndex:int,value:String):void{
	 var retObj:Object=this.call("setNString",arguments);

   }
   public  override function setByte(parameterIndex:int,x:int):void{
	 var retObj:Object=this.call("setByte",arguments);

   }
   public  override function setRowId(parameterIndex:int,x:RowId):void{
	 var retObj:Object=this.call("setRowId",arguments);

   }
   public  override function setAsciiStream(parameterIndex:int,x:InputStream,length:int):void{
	 var retObj:Object=this.call("setAsciiStream",arguments);

   }
   public  override function setAsciiStream1(parameterIndex:int,x:InputStream,length:Number):void{
	 var retObj:Object=this.call("setAsciiStream",arguments);

   }
   public function setAsciiStream2(parameterIndex:int,x:InputStream):void{
	 var retObj:Object=this.call("setAsciiStream",arguments);

   }
   public  override function setSQLXML(parameterIndex:int,xmlObject:SQLXML):void{
	 var retObj:Object=this.call("setSQLXML",arguments);

   }
   public  override function setClob(parameterIndex:int,x:Clob):void{
	 var retObj:Object=this.call("setClob",arguments);

   }
   public  override function setClob1(parameterIndex:int,reader:Reader,length:Number):void{
	 var retObj:Object=this.call("setClob",arguments);

   }
   public function setClob2(parameterIndex:int,reader:Reader):void{
	 var retObj:Object=this.call("setClob",arguments);

   }
 }

}
