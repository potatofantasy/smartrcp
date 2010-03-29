package java.sql
{
 import cn.smartinvoke.RemoteObject;
 
 import java.io.InputStream;
 import java.io.Reader;
 import java.math.BigDecimal;
 import java.net.URL;
 import java.util.Calendar;


[Bindable]
[RemoteClass(alias="java.sql.PreparedStatement")]
 public class PreparedStatement extends RemoteObject {
  public function PreparedStatement(){
	 super();
  }

   public  function setFloat(parameterIndex:int,x:Number):void{
	 var retObj:Object=this.call("setFloat",arguments);

   }
  /*  public  function setBytes(parameterIndex:int,x[]:int):void{
	 var retObj:Object=this.call("setBytes",arguments);

   } */
   public  function getMetaData():ResultSetMetaData{
	 var retObj:Object=this.call("getMetaData",arguments);
	 return retObj as ResultSetMetaData;

   }
   public  function setString(parameterIndex:int,x:String):void{
	 var retObj:Object=this.call("setString",arguments);

   }
   public  function setBlob(parameterIndex:int,x:Blob):void{
	 var retObj:Object=this.call("setBlob",arguments);

   }
   public  function setBlob1(parameterIndex:int,inputStream:InputStream,length:Number):void{
	 var retObj:Object=this.call("setBlob",arguments);

   }
   public function setBlob2(parameterIndex:int,inputStream:InputStream):void{
	 var retObj:Object=this.call("setBlob",arguments);

   }
   public  function setNClob(parameterIndex:int,value:NClob):void{
	 var retObj:Object=this.call("setNClob",arguments);

   }
   public  function setNClob1(parameterIndex:int,reader:Reader,length:Number):void{
	 var retObj:Object=this.call("setNClob",arguments);

   }
   public function setNClob2(parameterIndex:int,reader:Reader):void{
	 var retObj:Object=this.call("setNClob",arguments);

   }
   public  function setNCharacterStream(parameterIndex:int,value:Reader,length:Number):void{
	 var retObj:Object=this.call("setNCharacterStream",arguments);

   }
   public function setNCharacterStream1(parameterIndex:int,value:Reader):void{
	 var retObj:Object=this.call("setNCharacterStream",arguments);

   }
   public  function setBoolean(parameterIndex:int,x:Boolean):void{
	 var retObj:Object=this.call("setBoolean",arguments);

   }
   public  function setBinaryStream(parameterIndex:int,x:InputStream,length:int):void{
	 var retObj:Object=this.call("setBinaryStream",arguments);

   }
   public  function setBinaryStream1(parameterIndex:int,x:InputStream,length:Number):void{
	 var retObj:Object=this.call("setBinaryStream",arguments);

   }
   public function setBinaryStream2(parameterIndex:int,x:InputStream):void{
	 var retObj:Object=this.call("setBinaryStream",arguments);

   }
   public  function setDouble(parameterIndex:int,x:Number):void{
	 var retObj:Object=this.call("setDouble",arguments);

   }
   public  function setShort(parameterIndex:int,x:int):void{
	 var retObj:Object=this.call("setShort",arguments);

   }
   public  function setObject(parameterIndex:int,x:Object,targetSqlType:int):void{
	 var retObj:Object=this.call("setObject",arguments);

   }
   public function setObject1(parameterIndex:int,x:Object):void{
	 var retObj:Object=this.call("setObject",arguments);

   }
   public  function setObject2(parameterIndex:int,x:Object,targetSqlType:int,scaleOrLength:int):void{
	 var retObj:Object=this.call("setObject",arguments);

   }
   public  function setBigDecimal(parameterIndex:int,x:BigDecimal):void{
	 var retObj:Object=this.call("setBigDecimal",arguments);

   }
   public  function setInt(parameterIndex:int,x:int):void{
	 var retObj:Object=this.call("setInt",arguments);

   }
   public  function clearParameters():void{
	 var retObj:Object=this.call("clearParameters",arguments);

   }
   public  function setURL(parameterIndex:int,x:URL):void{
	 var retObj:Object=this.call("setURL",arguments);

   }
   public  function setLong(parameterIndex:int,x:Number):void{
	 var retObj:Object=this.call("setLong",arguments);

   }
   public  function setArray(parameterIndex:int,x:Array):void{
	 var retObj:Object=this.call("setArray",arguments);

   }
   public  function setTime(parameterIndex:int,x:Time):void{
	 var retObj:Object=this.call("setTime",arguments);

   }
   public  function setTime1(parameterIndex:int,x:Time,cal:Calendar):void{
	 var retObj:Object=this.call("setTime",arguments);

   }
   public  function execute():Boolean{
	 var retObj:Object=this.call("execute",arguments);
	 return retObj as Boolean;

   }
   public  function setRef(parameterIndex:int,x:Ref):void{
	 var retObj:Object=this.call("setRef",arguments);

   }
   public  function setTimestamp(parameterIndex:int,x:Timestamp):void{
	 var retObj:Object=this.call("setTimestamp",arguments);

   }
   public  function setTimestamp1(parameterIndex:int,x:Timestamp,cal:Calendar):void{
	 var retObj:Object=this.call("setTimestamp",arguments);

   }
   public  function executeQuery():ResultSet{
	 var retObj:Object=this.call("executeQuery",arguments);
	 return retObj as ResultSet;

   }
   public  function setUnicodeStream(parameterIndex:int,x:InputStream,length:int):void{
	 var retObj:Object=this.call("setUnicodeStream",arguments);

   }
   public  function addBatch():void{
	 var retObj:Object=this.call("addBatch",arguments);

   }
   public  function executeUpdate():int{
	 var retObj:Object=this.call("executeUpdate",arguments);
	 return Number(retObj);

   }
   public  function getParameterMetaData():ParameterMetaData{
	 var retObj:Object=this.call("getParameterMetaData",arguments);
	 return retObj as ParameterMetaData;

   }
   public  function setDate(parameterIndex:int,x:RemoteObject):void{
	 var retObj:Object=this.call("setDate",arguments);

   }
   public  function setDate1(parameterIndex:int,x:RemoteObject,cal:Calendar):void{
	 var retObj:Object=this.call("setDate",arguments);

   }
   public  function setCharacterStream(parameterIndex:int,reader:Reader,length:int):void{
	 var retObj:Object=this.call("setCharacterStream",arguments);

   }
   public  function setCharacterStream1(parameterIndex:int,reader:Reader,length:Number):void{
	 var retObj:Object=this.call("setCharacterStream",arguments);

   }
   public function setCharacterStream2(parameterIndex:int,reader:Reader):void{
	 var retObj:Object=this.call("setCharacterStream",arguments);

   }
   public  function setNull(parameterIndex:int,sqlType:int):void{
	 var retObj:Object=this.call("setNull",arguments);

   }
   public  function setNull1(parameterIndex:int,sqlType:int,typeName:String):void{
	 var retObj:Object=this.call("setNull",arguments);

   }
   public  function setNString(parameterIndex:int,value:String):void{
	 var retObj:Object=this.call("setNString",arguments);

   }
   public  function setByte(parameterIndex:int,x:int):void{
	 var retObj:Object=this.call("setByte",arguments);

   }
   public  function setRowId(parameterIndex:int,x:RowId):void{
	 var retObj:Object=this.call("setRowId",arguments);

   }
   public  function setAsciiStream(parameterIndex:int,x:InputStream,length:int):void{
	 var retObj:Object=this.call("setAsciiStream",arguments);

   }
   public  function setAsciiStream1(parameterIndex:int,x:InputStream,length:Number):void{
	 var retObj:Object=this.call("setAsciiStream",arguments);

   }
   public function setAsciiStream2(parameterIndex:int,x:InputStream):void{
	 var retObj:Object=this.call("setAsciiStream",arguments);

   }
   public  function setSQLXML(parameterIndex:int,xmlObject:SQLXML):void{
	 var retObj:Object=this.call("setSQLXML",arguments);

   }
   public  function setClob(parameterIndex:int,x:Clob):void{
	 var retObj:Object=this.call("setClob",arguments);

   }
   public  function setClob1(parameterIndex:int,reader:Reader,length:Number):void{
	 var retObj:Object=this.call("setClob",arguments);

   }
   public function setClob2(parameterIndex:int,reader:Reader):void{
	 var retObj:Object=this.call("setClob",arguments);

   }
 }

}
