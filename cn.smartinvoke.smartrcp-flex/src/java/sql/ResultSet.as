package java.sql
{
 import cn.smartinvoke.RemoteObject;
 
 import java.io.InputStream;
 import java.io.Reader;
 import java.math.BigDecimal;
 import java.net.URL;
 import java.util.Calendar;


[Bindable]
[RemoteClass(alias="smartrcp.db.CResultSet")]
 public class ResultSet extends Wrapper {
  public function ResultSet(){
	 super();
  }

   public function updateBoolean(columnIndex:int,x:Boolean):void{
	 var retObj:Object=this.call("updateBoolean",arguments);

   }
   public function updateBoolean1(columnLabel:String,x:Boolean):void{
	 var retObj:Object=this.call("updateBoolean",arguments);

   }
   public function getSQLXML(columnIndex:int):SQLXML{
	 var retObj:Object=this.call("getSQLXML",arguments);
	 return retObj as SQLXML;

   }
   public function getSQLXML1(columnLabel:String):SQLXML{
	 var retObj:Object=this.call("getSQLXML",arguments);
	 return retObj as SQLXML;

   }
   public function last():Boolean{
	 var retObj:Object=this.call("last",arguments);
	 return retObj as Boolean;

   }
   public function updateNClob(columnIndex:int,nClob:NClob):void{
	 var retObj:Object=this.call("updateNClob",arguments);

   }
   public function updateNClob1(columnLabel:String,nClob:NClob):void{
	 var retObj:Object=this.call("updateNClob",arguments);

   }
   public function updateNClob2(columnIndex:int,reader:Reader,length:Number):void{
	 var retObj:Object=this.call("updateNClob",arguments);

   }
   public function updateNClob3(columnLabel:String,reader:Reader,length:Number):void{
	 var retObj:Object=this.call("updateNClob",arguments);

   }
   public function updateNClob4(columnIndex:int,reader:Reader):void{
	 var retObj:Object=this.call("updateNClob",arguments);

   }
   public function updateNClob5(columnLabel:String,reader:Reader):void{
	 var retObj:Object=this.call("updateNClob",arguments);

   }
   public function moveToInsertRow():void{
	 var retObj:Object=this.call("moveToInsertRow",arguments);

   }
   public function getCursorName():String{
	 var retObj:Object=this.call("getCursorName",arguments);
	 return retObj as String;

   }
   public function getBoolean(columnIndex:int):Boolean{
	 var retObj:Object=this.call("getBoolean",arguments);
	 return retObj as Boolean;

   }
   public function getBoolean1(columnLabel:String):Boolean{
	 var retObj:Object=this.call("getBoolean",arguments);
	 return retObj as Boolean;

   }
   public function wasNull():Boolean{
	 var retObj:Object=this.call("wasNull",arguments);
	 return retObj as Boolean;

   }
   public function updateBigDecimal(columnIndex:int,x:BigDecimal):void{
	 var retObj:Object=this.call("updateBigDecimal",arguments);

   }
   public function updateBigDecimal1(columnLabel:String,x:BigDecimal):void{
	 var retObj:Object=this.call("updateBigDecimal",arguments);

   }
   public function getClob(columnIndex:int):Clob{
	 var retObj:Object=this.call("getClob",arguments);
	 return retObj as Clob;

   }
   public function getClob1(columnLabel:String):Clob{
	 var retObj:Object=this.call("getClob",arguments);
	 return retObj as Clob;

   }
   public function getStatement():Statement{
	 var retObj:Object=this.call("getStatement",arguments);
	 return retObj as Statement;

   }
   public function close():void{
	 this.asyncCall("close",arguments);
   }
   public function cancelRowUpdates():void{
	 var retObj:Object=this.call("cancelRowUpdates",arguments);

   }
   public function updateDouble(columnIndex:int,x:Number):void{
	 var retObj:Object=this.call("updateDouble",arguments);

   }
   public function updateDouble1(columnLabel:String,x:Number):void{
	 var retObj:Object=this.call("updateDouble",arguments);

   }
   public function updateInt(columnIndex:int,x:int):void{
	 var retObj:Object=this.call("updateInt",arguments);

   }
   public function updateInt1(columnLabel:String,x:int):void{
	 var retObj:Object=this.call("updateInt",arguments);

   }
   public function getNCharacterStream(columnIndex:int):Reader{
	 var retObj:Object=this.call("getNCharacterStream",arguments);
	 return retObj as Reader;

   }
   public function getNCharacterStream1(columnLabel:String):Reader{
	 var retObj:Object=this.call("getNCharacterStream",arguments);
	 return retObj as Reader;

   }
   public function afterLast():void{
	 var retObj:Object=this.call("afterLast",arguments);

   }
   public function getAsciiStream(columnIndex:int):InputStream{
	 var retObj:Object=this.call("getAsciiStream",arguments);
	 return retObj as InputStream;

   }
   public function getAsciiStream1(columnLabel:String):InputStream{
	 var retObj:Object=this.call("getAsciiStream",arguments);
	 return retObj as InputStream;

   }
   public function updateNCharacterStream(columnIndex:int,x:Reader,length:Number):void{
	 var retObj:Object=this.call("updateNCharacterStream",arguments);

   }
   public function updateNCharacterStream1(columnLabel:String,reader:Reader,length:Number):void{
	 var retObj:Object=this.call("updateNCharacterStream",arguments);

   }
   public function updateNCharacterStream2(columnIndex:int,x:Reader):void{
	 var retObj:Object=this.call("updateNCharacterStream",arguments);

   }
   public function updateNCharacterStream3(columnLabel:String,reader:Reader):void{
	 var retObj:Object=this.call("updateNCharacterStream",arguments);

   }
   public function isClosed():Boolean{
	 var retObj:Object=this.call("isClosed",arguments);
	 return retObj as Boolean;

   }
   public function updateRow():void{
	 var retObj:Object=this.call("updateRow",arguments);

   }
   public function rowUpdated():Boolean{
	 var retObj:Object=this.call("rowUpdated",arguments);
	 return retObj as Boolean;

   }
   public function getObject(columnIndex:int):Object{
	 var retObj:Object=this.call("getObject",arguments);
	 return retObj;
   }
   public function getObject1(columnLabel:String):Object{
	 var retObj:Object=this.call("getObject",arguments);
	 return retObj;
   }
   public function getObject2(columnIndex:int,map:Object):Object{
	 var retObj:Object=this.call("getObject",arguments);
	 return retObj;
   }
   public function getObject3(columnLabel:String,map:Object):Object{
	 var retObj:Object=this.call("getObject",arguments);
	 return retObj;
   }
   public function getRow():int{
	 var retObj:Object=this.call("getRow",arguments);
	 return Number(retObj);

   }
   public function setFetchDirection(direction:int):void{
	 var retObj:Object=this.call("setFetchDirection",arguments);

   }
   public function moveToCurrentRow():void{
	 var retObj:Object=this.call("moveToCurrentRow",arguments);

   }
   public function getBigDecimal(columnIndex:int,scale:int):BigDecimal{
	 var retObj:Object=this.call("getBigDecimal",arguments);
	 return retObj as BigDecimal;

   }
   public function getBigDecimal1(columnLabel:String,scale:int):BigDecimal{
	 var retObj:Object=this.call("getBigDecimal",arguments);
	 return retObj as BigDecimal;

   }
   public function getBigDecimal2(columnIndex:int):BigDecimal{
	 var retObj:Object=this.call("getBigDecimal",arguments);
	 return retObj as BigDecimal;

   }
   public function getBigDecimal3(columnLabel:String):BigDecimal{
	 var retObj:Object=this.call("getBigDecimal",arguments);
	 return retObj as BigDecimal;

   }
   public function getBytes(columnIndex:int):Array{
	 var retObj:Object=this.call("getBytes",arguments);
	 return retObj as Array;

   }
   public function getBytes1(columnLabel:String):Array{
	 var retObj:Object=this.call("getBytes",arguments);
	 return retObj as Array;

   }
   public function isLast():Boolean{
	 var retObj:Object=this.call("isLast",arguments);
	 return retObj as Boolean;

   }
   public function updateAsciiStream(columnIndex:int,x:InputStream,length:int):void{
	 var retObj:Object=this.call("updateAsciiStream",arguments);

   }
   public function updateAsciiStream1(columnLabel:String,x:InputStream,length:int):void{
	 var retObj:Object=this.call("updateAsciiStream",arguments);

   }
   public function updateAsciiStream2(columnIndex:int,x:InputStream,length:Number):void{
	 var retObj:Object=this.call("updateAsciiStream",arguments);

   }
   public function updateAsciiStream3(columnLabel:String,x:InputStream,length:Number):void{
	 var retObj:Object=this.call("updateAsciiStream",arguments);

   }
   public function updateAsciiStream4(columnIndex:int,x:InputStream):void{
	 var retObj:Object=this.call("updateAsciiStream",arguments);

   }
   public function updateAsciiStream5(columnLabel:String,x:InputStream):void{
	 var retObj:Object=this.call("updateAsciiStream",arguments);

   }
   public function getShort(columnIndex:int):int{
	 var retObj:Object=this.call("getShort",arguments);
	 return Number(retObj);

   }
   public function getShort1(columnLabel:String):int{
	 var retObj:Object=this.call("getShort",arguments);
	 return Number(retObj);

   }
   public function updateTimestamp(columnIndex:int,x:Timestamp):void{
	 var retObj:Object=this.call("updateTimestamp",arguments);

   }
   public function updateTimestamp1(columnLabel:String,x:Timestamp):void{
	 var retObj:Object=this.call("updateTimestamp",arguments);

   }
   public function updateByte(columnIndex:int,x:int):void{
	 var retObj:Object=this.call("updateByte",arguments);

   }
   public function updateByte1(columnLabel:String,x:int):void{
	 var retObj:Object=this.call("updateByte",arguments);

   }
   public function updateTime(columnIndex:int,x:Time):void{
	 var retObj:Object=this.call("updateTime",arguments);

   }
   public function updateTime1(columnLabel:String,x:Time):void{
	 var retObj:Object=this.call("updateTime",arguments);

   }
   public function getHoldability():int{
	 var retObj:Object=this.call("getHoldability",arguments);
	 return Number(retObj);

   }
   /* public function updateBytes(columnIndex:int,x[]:int):void{
	 var retObj:Object=this.call("updateBytes",arguments);

   }
   public function updateBytes1(columnLabel:String,x[]:int):void{
	 var retObj:Object=this.call("updateBytes",arguments);

   } */
   public function findColumn(columnLabel:String):int{
	 var retObj:Object=this.call("findColumn",arguments);
	 return Number(retObj);

   }
   public function beforeFirst():void{
	 var retObj:Object=this.call("beforeFirst",arguments);

   }
   public function relative(rows:int):Boolean{
	 var retObj:Object=this.call("relative",arguments);
	 return retObj as Boolean;

   }
   public function updateRef(columnIndex:int,x:Ref):void{
	 var retObj:Object=this.call("updateRef",arguments);

   }
   public function updateRef1(columnLabel:String,x:Ref):void{
	 var retObj:Object=this.call("updateRef",arguments);

   }
   public function getArray(columnIndex:int):Array{
	 var retObj:Object=this.call("getArray",arguments);
	 return retObj as Array;

   }
   public function getArray1(columnLabel:String):Array{
	 var retObj:Object=this.call("getArray",arguments);
	 return retObj as Array;

   }
   public function refreshRow():void{
	 var retObj:Object=this.call("refreshRow",arguments);

   }
   public function getDate(columnIndex:int):RemoteObject{
	 var retObj:Object=this.call("getDate",arguments);
	 return retObj as RemoteObject;

   }
   public function getDate1(columnLabel:String):RemoteObject{
	 var retObj:Object=this.call("getDate",arguments);
	 return retObj as RemoteObject;

   }
   public function getDate2(columnIndex:int,cal:Calendar):RemoteObject{
	 var retObj:Object=this.call("getDate",arguments);
	 return retObj as RemoteObject;

   }
   public function getDate3(columnLabel:String,cal:Calendar):RemoteObject{
	 var retObj:Object=this.call("getDate",arguments);
	 return retObj as RemoteObject;

   }
   public function getFetchSize():int{
	 var retObj:Object=this.call("getFetchSize",arguments);
	 return Number(retObj);

   }
   public function updateSQLXML(columnIndex:int,xmlObject:SQLXML):void{
	 var retObj:Object=this.call("updateSQLXML",arguments);

   }
   public function updateSQLXML1(columnLabel:String,xmlObject:SQLXML):void{
	 var retObj:Object=this.call("updateSQLXML",arguments);

   }
   public function isAfterLast():Boolean{
	 var retObj:Object=this.call("isAfterLast",arguments);
	 return retObj as Boolean;

   }
   public function getBlob(columnIndex:int):Blob{
	 var retObj:Object=this.call("getBlob",arguments);
	 return retObj as Blob;

   }
   public function getBlob1(columnLabel:String):Blob{
	 var retObj:Object=this.call("getBlob",arguments);
	 return retObj as Blob;

   }
   public function getNString(columnIndex:int):String{
	 var retObj:Object=this.call("getNString",arguments);
	 return retObj as String;

   }
   public function getNString1(columnLabel:String):String{
	 var retObj:Object=this.call("getNString",arguments);
	 return retObj as String;

   }
   public function getURL(columnIndex:int):URL{
	 var retObj:Object=this.call("getURL",arguments);
	 return retObj as URL;

   }
   public function getURL1(columnLabel:String):URL{
	 var retObj:Object=this.call("getURL",arguments);
	 return retObj as URL;

   }
   public function updateRowId(columnIndex:int,x:RowId):void{
	 var retObj:Object=this.call("updateRowId",arguments);

   }
   public function updateRowId1(columnLabel:String,x:RowId):void{
	 var retObj:Object=this.call("updateRowId",arguments);

   }
   public function getString(columnIndex:int):String{
	 var retObj:Object=this.call("getString",arguments);
	 return retObj as String;

   }
   public function getString1(columnLabel:String):String{
	 var retObj:Object=this.call("getString",arguments);
	 return retObj as String;

   }
   public function getFloat(columnIndex:int):Number{
	 var retObj:Object=this.call("getFloat",arguments);
	 return Number(retObj);

   }
   public function getFloat1(columnLabel:String):Number{
	 var retObj:Object=this.call("getFloat",arguments);
	 return Number(retObj);

   }
   public function updateBinaryStream(columnIndex:int,x:InputStream,length:int):void{
	 var retObj:Object=this.call("updateBinaryStream",arguments);

   }
   public function updateBinaryStream1(columnLabel:String,x:InputStream,length:int):void{
	 var retObj:Object=this.call("updateBinaryStream",arguments);

   }
   public function updateBinaryStream2(columnIndex:int,x:InputStream,length:Number):void{
	 var retObj:Object=this.call("updateBinaryStream",arguments);

   }
   public function updateBinaryStream3(columnLabel:String,x:InputStream,length:Number):void{
	 var retObj:Object=this.call("updateBinaryStream",arguments);

   }
   public function updateBinaryStream4(columnIndex:int,x:InputStream):void{
	 var retObj:Object=this.call("updateBinaryStream",arguments);

   }
   public function updateBinaryStream5(columnLabel:String,x:InputStream):void{
	 var retObj:Object=this.call("updateBinaryStream",arguments);

   }
   public function getDouble(columnIndex:int):Number{
	 var retObj:Object=this.call("getDouble",arguments);
	 return Number(retObj);

   }
   public function getDouble1(columnLabel:String):Number{
	 var retObj:Object=this.call("getDouble",arguments);
	 return Number(retObj);

   }
   public function getMetaData():ResultSetMetaData{
	 var retObj:Object=this.call("getMetaData",arguments);
	 return retObj as ResultSetMetaData;

   }
   public function next():Boolean{
	 var retObj:Object=this.call("next",arguments);
	 return retObj as Boolean;

   }
   public function clearWarnings():void{
	 var retObj:Object=this.call("clearWarnings",arguments);

   }
   public function getLong(columnIndex:int):Number{
	 var retObj:Object=this.call("getLong",arguments);
	 return Number(retObj);

   }
   public function getLong1(columnLabel:String):Number{
	 var retObj:Object=this.call("getLong",arguments);
	 return Number(retObj);

   }
   public function updateLong(columnIndex:int,x:Number):void{
	 var retObj:Object=this.call("updateLong",arguments);

   }
   public function updateLong1(columnLabel:String,x:Number):void{
	 var retObj:Object=this.call("updateLong",arguments);

   }
   public function updateArray(columnIndex:int,x:Array):void{
	 var retObj:Object=this.call("updateArray",arguments);

   }
   public function updateArray1(columnLabel:String,x:Array):void{
	 var retObj:Object=this.call("updateArray",arguments);

   }
   public function insertRow():void{
	 var retObj:Object=this.call("insertRow",arguments);

   }
   public function absolute(row:int):Boolean{
	 var retObj:Object=this.call("absolute",arguments);
	 return retObj as Boolean;

   }
   public function getFetchDirection():int{
	 var retObj:Object=this.call("getFetchDirection",arguments);
	 return Number(retObj);

   }
   public function rowInserted():Boolean{
	 var retObj:Object=this.call("rowInserted",arguments);
	 return retObj as Boolean;

   }
   public function rowDeleted():Boolean{
	 var retObj:Object=this.call("rowDeleted",arguments);
	 return retObj as Boolean;

   }
   public function getTimestamp(columnIndex:int):Timestamp{
	 var retObj:Object=this.call("getTimestamp",arguments);
	 return retObj as Timestamp;

   }
   public function getTimestamp1(columnLabel:String):Timestamp{
	 var retObj:Object=this.call("getTimestamp",arguments);
	 return retObj as Timestamp;

   }
   public function getTimestamp2(columnIndex:int,cal:Calendar):Timestamp{
	 var retObj:Object=this.call("getTimestamp",arguments);
	 return retObj as Timestamp;

   }
   public function getTimestamp3(columnLabel:String,cal:Calendar):Timestamp{
	 var retObj:Object=this.call("getTimestamp",arguments);
	 return retObj as Timestamp;

   }
   public function getType():int{
	 var retObj:Object=this.call("getType",arguments);
	 return Number(retObj);

   }
   public function getRowId(columnIndex:int):RowId{
	 var retObj:Object=this.call("getRowId",arguments);
	 return retObj as RowId;

   }
   public function getRowId1(columnLabel:String):RowId{
	 var retObj:Object=this.call("getRowId",arguments);
	 return retObj as RowId;

   }
  /*  public function getWarnings():SQLWarning{
	 var retObj:Object=this.call("getWarnings",arguments);
	 return retObj as SQLWarning;

   } */
   public function updateNString(columnIndex:int,nString:String):void{
	 var retObj:Object=this.call("updateNString",arguments);

   }
   public function updateNString1(columnLabel:String,nString:String):void{
	 var retObj:Object=this.call("updateNString",arguments);

   }
   public function getRef(columnIndex:int):Ref{
	 var retObj:Object=this.call("getRef",arguments);
	 return retObj as Ref;

   }
   public function getRef1(columnLabel:String):Ref{
	 var retObj:Object=this.call("getRef",arguments);
	 return retObj as Ref;

   }
   public function updateObject(columnIndex:int,x:Object,scaleOrLength:int):void{
	 var retObj:Object=this.call("updateObject",arguments);

   }
   public function updateObject1(columnIndex:int,x:Object):void{
	 var retObj:Object=this.call("updateObject",arguments);

   }
   public function updateObject2(columnLabel:String,x:Object,scaleOrLength:int):void{
	 var retObj:Object=this.call("updateObject",arguments);

   }
   public function updateObject3(columnLabel:String,x:Object):void{
	 var retObj:Object=this.call("updateObject",arguments);

   }
   public function getNClob(columnIndex:int):NClob{
	 var retObj:Object=this.call("getNClob",arguments);
	 return retObj as NClob;

   }
   public function getNClob1(columnLabel:String):NClob{
	 var retObj:Object=this.call("getNClob",arguments);
	 return retObj as NClob;

   }
   public function updateCharacterStream(columnIndex:int,x:Reader,length:int):void{
	 var retObj:Object=this.call("updateCharacterStream",arguments);

   }
   public function updateCharacterStream1(columnLabel:String,reader:Reader,length:int):void{
	 var retObj:Object=this.call("updateCharacterStream",arguments);

   }
   public function updateCharacterStream2(columnIndex:int,x:Reader,length:Number):void{
	 var retObj:Object=this.call("updateCharacterStream",arguments);

   }
   public function updateCharacterStream3(columnLabel:String,reader:Reader,length:Number):void{
	 var retObj:Object=this.call("updateCharacterStream",arguments);

   }
   public function updateCharacterStream4(columnIndex:int,x:Reader):void{
	 var retObj:Object=this.call("updateCharacterStream",arguments);

   }
   public function updateCharacterStream5(columnLabel:String,reader:Reader):void{
	 var retObj:Object=this.call("updateCharacterStream",arguments);

   }
   public function isBeforeFirst():Boolean{
	 var retObj:Object=this.call("isBeforeFirst",arguments);
	 return retObj as Boolean;

   }
   public function previous():Boolean{
	 var retObj:Object=this.call("previous",arguments);
	 return retObj as Boolean;

   }
   public function getUnicodeStream(columnIndex:int):InputStream{
	 var retObj:Object=this.call("getUnicodeStream",arguments);
	 return retObj as InputStream;

   }
   public function getUnicodeStream1(columnLabel:String):InputStream{
	 var retObj:Object=this.call("getUnicodeStream",arguments);
	 return retObj as InputStream;

   }
   public function getInt(columnIndex:int):int{
	 var retObj:Object=this.call("getInt",arguments);
	 return Number(retObj);

   }
   public function getInt1(columnLabel:String):int{
	 var retObj:Object=this.call("getInt",arguments);
	 return Number(retObj);

   }
   public function updateShort(columnIndex:int,x:int):void{
	 var retObj:Object=this.call("updateShort",arguments);

   }
   public function updateShort1(columnLabel:String,x:int):void{
	 var retObj:Object=this.call("updateShort",arguments);

   }
   public function getByte(columnIndex:int):int{
	 var retObj:Object=this.call("getByte",arguments);
	 return Number(retObj);

   }
   public function getByte1(columnLabel:String):int{
	 var retObj:Object=this.call("getByte",arguments);
	 return Number(retObj);

   }
   public function getConcurrency():int{
	 var retObj:Object=this.call("getConcurrency",arguments);
	 return Number(retObj);

   }
   public function getCharacterStream(columnIndex:int):Reader{
	 var retObj:Object=this.call("getCharacterStream",arguments);
	 return retObj as Reader;

   }
   public function getCharacterStream1(columnLabel:String):Reader{
	 var retObj:Object=this.call("getCharacterStream",arguments);
	 return retObj as Reader;

   }
   public function setFetchSize(rows:int):void{
	 var retObj:Object=this.call("setFetchSize",arguments);

   }
   public function updateBlob(columnIndex:int,x:Blob):void{
	 var retObj:Object=this.call("updateBlob",arguments);

   }
   public function updateBlob1(columnLabel:String,x:Blob):void{
	 var retObj:Object=this.call("updateBlob",arguments);

   }
   public function updateBlob2(columnIndex:int,inputStream:InputStream,length:Number):void{
	 var retObj:Object=this.call("updateBlob",arguments);

   }
   public function updateBlob3(columnLabel:String,inputStream:InputStream,length:Number):void{
	 var retObj:Object=this.call("updateBlob",arguments);

   }
   public function updateBlob4(columnIndex:int,inputStream:InputStream):void{
	 var retObj:Object=this.call("updateBlob",arguments);

   }
   public function updateBlob5(columnLabel:String,inputStream:InputStream):void{
	 var retObj:Object=this.call("updateBlob",arguments);

   }
   public function deleteRow():void{
	 var retObj:Object=this.call("deleteRow",arguments);

   }
   public function isFirst():Boolean{
	 var retObj:Object=this.call("isFirst",arguments);
	 return retObj as Boolean;

   }
   public function updateDate(columnIndex:int,x:RemoteObject):void{
	 var retObj:Object=this.call("updateDate",arguments);

   }
   public function updateDate1(columnLabel:String,x:RemoteObject):void{
	 var retObj:Object=this.call("updateDate",arguments);

   }
   public function updateClob(columnIndex:int,x:Clob):void{
	 var retObj:Object=this.call("updateClob",arguments);

   }
   public function updateClob1(columnLabel:String,x:Clob):void{
	 var retObj:Object=this.call("updateClob",arguments);

   }
   public function updateClob2(columnIndex:int,reader:Reader,length:Number):void{
	 var retObj:Object=this.call("updateClob",arguments);

   }
   public function updateClob3(columnLabel:String,reader:Reader,length:Number):void{
	 var retObj:Object=this.call("updateClob",arguments);

   }
   public function updateClob4(columnIndex:int,reader:Reader):void{
	 var retObj:Object=this.call("updateClob",arguments);

   }
   public function updateClob5(columnLabel:String,reader:Reader):void{
	 var retObj:Object=this.call("updateClob",arguments);

   }
   public function getTime(columnIndex:int):Time{
	 var retObj:Object=this.call("getTime",arguments);
	 return retObj as Time;

   }
   public function getTime1(columnLabel:String):Time{
	 var retObj:Object=this.call("getTime",arguments);
	 return retObj as Time;

   }
   public function getTime2(columnIndex:int,cal:Calendar):Time{
	 var retObj:Object=this.call("getTime",arguments);
	 return retObj as Time;

   }
   public function getTime3(columnLabel:String,cal:Calendar):Time{
	 var retObj:Object=this.call("getTime",arguments);
	 return retObj as Time;

   }
   public function updateString(columnIndex:int,x:String):void{
	 var retObj:Object=this.call("updateString",arguments);

   }
   public function updateString1(columnLabel:String,x:String):void{
	 var retObj:Object=this.call("updateString",arguments);

   }
   public function first():Boolean{
	 var retObj:Object=this.call("first",arguments);
	 return retObj as Boolean;

   }
   public function updateFloat(columnIndex:int,x:Number):void{
	 var retObj:Object=this.call("updateFloat",arguments);

   }
   public function updateFloat1(columnLabel:String,x:Number):void{
	 var retObj:Object=this.call("updateFloat",arguments);

   }
   public function updateNull(columnIndex:int):void{
	 var retObj:Object=this.call("updateNull",arguments);

   }
   public function updateNull1(columnLabel:String):void{
	 var retObj:Object=this.call("updateNull",arguments);

   }
   public function getBinaryStream(columnIndex:int):InputStream{
	 var retObj:Object=this.call("getBinaryStream",arguments);
	 return retObj as InputStream;

   }
   public function getBinaryStream1(columnLabel:String):InputStream{
	 var retObj:Object=this.call("getBinaryStream",arguments);
	 return retObj as InputStream;

   }
 }

}
