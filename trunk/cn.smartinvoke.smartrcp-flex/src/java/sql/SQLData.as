package java.sql
{
 import cn.smartinvoke.RemoteObject;

[Bindable]
[RemoteClass(alias="java.sql.SQLData")]
 public class SQLData extends RemoteObject {
  public function SQLData(){
	 super();
  }

   public function writeSQL(stream:SQLOutput):void{
	 var retObj:Object=this.call("writeSQL",arguments);

   }
   public function getSQLTypeName():String{
	 var retObj:Object=this.call("getSQLTypeName",arguments);
	 return retObj as String;

   }
   public function readSQL(stream:SQLInput,typeName:String):void{
	 var retObj:Object=this.call("readSQL",arguments);

   }
 }

}
