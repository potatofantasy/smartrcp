package java.sql
{
 import cn.smartinvoke.RemoteObject;
 import java.io.Writer;
 import java.io.Reader;
 import java.io.OutputStream;
 import java.io.InputStream;

[Bindable]
[RemoteClass(alias="java.sql.SQLXML")]
 public class SQLXML extends RemoteObject {
  public function SQLXML(){
	 super();
  }

   public function free():void{
	 var retObj:Object=this.call("free",arguments);

   }
  /*  public function setCharacterStream():Writer{
	 var retObj:Object=this.call("setCharacterStream",arguments);
	 return retObj as Writer;

   }
   public function setResult(resultClass:Class):T{
	 var retObj:Object=this.call("setResult",arguments);
	 return retObj as T;

   } */
   public function setString(value:String):void{
	 var retObj:Object=this.call("setString",arguments);

   }
   public function getCharacterStream():Reader{
	 var retObj:Object=this.call("getCharacterStream",arguments);
	 return retObj as Reader;

   }
   public function getString():String{
	 var retObj:Object=this.call("getString",arguments);
	 return retObj as String;

   }
  /*  public function getSource(sourceClass:Class):T{
	 var retObj:Object=this.call("getSource",arguments);
	 return retObj as T;

   } */
   public function setBinaryStream():OutputStream{
	 var retObj:Object=this.call("setBinaryStream",arguments);
	 return retObj as OutputStream;

   }
   public function getBinaryStream():InputStream{
	 var retObj:Object=this.call("getBinaryStream",arguments);
	 return retObj as InputStream;

   }
 }

}
