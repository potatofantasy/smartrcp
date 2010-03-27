package java.sql
{
 import cn.smartinvoke.RemoteObject;
 import java.sql.Wrapper;

[Bindable]
[RemoteClass(alias="java.sql.ResultSetMetaData")]
 public class ResultSetMetaData extends Wrapper {
  public function ResultSetMetaData(){
	 super();
  }

   public function getColumnDisplaySize(column:int):int{
	 var retObj:Object=this.call("getColumnDisplaySize",arguments);
	 return Number(retObj);

   }
   public function isCurrency(column:int):Boolean{
	 var retObj:Object=this.call("isCurrency",arguments);
	 return retObj as Boolean;

   }
   public function isWritable(column:int):Boolean{
	 var retObj:Object=this.call("isWritable",arguments);
	 return retObj as Boolean;

   }
   public function getColumnClassName(column:int):String{
	 var retObj:Object=this.call("getColumnClassName",arguments);
	 return retObj as String;

   }
   public function getTableName(column:int):String{
	 var retObj:Object=this.call("getTableName",arguments);
	 return retObj as String;

   }
   public function isDefinitelyWritable(column:int):Boolean{
	 var retObj:Object=this.call("isDefinitelyWritable",arguments);
	 return retObj as Boolean;

   }
   public function isSigned(column:int):Boolean{
	 var retObj:Object=this.call("isSigned",arguments);
	 return retObj as Boolean;

   }
   public function getSchemaName(column:int):String{
	 var retObj:Object=this.call("getSchemaName",arguments);
	 return retObj as String;

   }
   public function isAutoIncrement(column:int):Boolean{
	 var retObj:Object=this.call("isAutoIncrement",arguments);
	 return retObj as Boolean;

   }
   public function getColumnTypeName(column:int):String{
	 var retObj:Object=this.call("getColumnTypeName",arguments);
	 return retObj as String;

   }
   public function getColumnType(column:int):int{
	 var retObj:Object=this.call("getColumnType",arguments);
	 return Number(retObj);

   }
   public function isSearchable(column:int):Boolean{
	 var retObj:Object=this.call("isSearchable",arguments);
	 return retObj as Boolean;

   }
   public function getColumnCount():int{
	 var retObj:Object=this.call("getColumnCount",arguments);
	 return Number(retObj);

   }
   public function getColumnLabel(column:int):String{
	 var retObj:Object=this.call("getColumnLabel",arguments);
	 return retObj as String;

   }
   public function getPrecision(column:int):int{
	 var retObj:Object=this.call("getPrecision",arguments);
	 return Number(retObj);

   }
   public function getCatalogName(column:int):String{
	 var retObj:Object=this.call("getCatalogName",arguments);
	 return retObj as String;

   }
   public function getColumnName(column:int):String{
	 var retObj:Object=this.call("getColumnName",arguments);
	 return retObj as String;

   }
   public function getScale(column:int):int{
	 var retObj:Object=this.call("getScale",arguments);
	 return Number(retObj);

   }
   public function isReadOnly(column:int):Boolean{
	 var retObj:Object=this.call("isReadOnly",arguments);
	 return retObj as Boolean;

   }
   public function isNullable(column:int):int{
	 var retObj:Object=this.call("isNullable",arguments);
	 return Number(retObj);

   }
   public function isCaseSensitive(column:int):Boolean{
	 var retObj:Object=this.call("isCaseSensitive",arguments);
	 return retObj as Boolean;

   }
 }

}
