package java.sql
{
 import cn.smartinvoke.RemoteObject;
 import java.sql.Wrapper;

[Bindable]
[RemoteClass(alias="java.sql.ParameterMetaData")]
 public class ParameterMetaData extends Wrapper {
  public function ParameterMetaData(){
	 super();
  }

   public function getPrecision(param:int):int{
	 var retObj:Object=this.call("getPrecision",arguments);
	 return Number(retObj);

   }
   public function getParameterMode(param:int):int{
	 var retObj:Object=this.call("getParameterMode",arguments);
	 return Number(retObj);

   }
   public function getScale(param:int):int{
	 var retObj:Object=this.call("getScale",arguments);
	 return Number(retObj);

   }
   public function getParameterCount():int{
	 var retObj:Object=this.call("getParameterCount",arguments);
	 return Number(retObj);

   }
   public function isNullable(param:int):int{
	 var retObj:Object=this.call("isNullable",arguments);
	 return Number(retObj);

   }
   public function getParameterClassName(param:int):String{
	 var retObj:Object=this.call("getParameterClassName",arguments);
	 return retObj as String;

   }
   public function isSigned(param:int):Boolean{
	 var retObj:Object=this.call("isSigned",arguments);
	 return retObj as Boolean;

   }
   public function getParameterTypeName(param:int):String{
	 var retObj:Object=this.call("getParameterTypeName",arguments);
	 return retObj as String;

   }
   public function getParameterType(param:int):int{
	 var retObj:Object=this.call("getParameterType",arguments);
	 return Number(retObj);

   }
 }

}
