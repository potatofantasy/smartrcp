
/*******************************************************************************
*******************************************************************************/ 
package cn.smartinvoke
{
	import cn.smartinvoke.exception.InvokeException;
	import cn.smartinvoke.executor.Executor;
	import cn.smartinvoke.util.ClsNameUtil;
	import cn.smartinvoke.util.ProtocolBuilder;
	
	import flash.external.*;
	import flash.system.*;
	import flash.utils.*;
	
	import mx.core.ClassFactory;
	
	public class RemoteObject
	{
		//
		//private var _appId:String=null;
		public function get appId():String{
			return Executor.applicationId;
		}
		public function set appId(id:String):void{
			
		}
		public var remoteId:String=null;
		public function RemoteObject(param:Array=null){  
			//this.createRemoteObject(param);
			//	this.create(clsName,param);
			
		}
		public static function createRemoteObject(clsName:String,objId:String):Object{
          var clss:Class=getDefinitionByName(clsName) as Class;
		  var tagetObj:Object=new ClassFactory(clss).newInstance();
		  tagetObj["remoteId"]=objId;
		  return tagetObj;
        } 
        public function call(methodName:String,pars:Array):Object{
          if(pars==null){
          	pars=new Array();
          }
          var avk:Array=[this.remoteId,methodName,pars];
          var avkPack:String=ProtocolBuilder.getProtocolStr(avk);
          var retPack:String=RemoteObject.externalInterfaceCall('call',avkPack) as String;
          
          var retObj:Object=ProtocolBuilder.getObject(retPack);
          if(retObj==null){
          	return null;
          }
          if(retObj is InvokeException){
          	 throw (retObj as InvokeException);
          }else{
             return retObj;
          }
        }
        public function create(tagetCls:String,pars:Array=null):void{
          var avk:Array=[tagetCls,pars];
		  var avkPack:String=ProtocolBuilder.getProtocolStr(avk);
		  var retPack:String=RemoteObject.externalInterfaceCall("create",avkPack)as String;
		  
		  var retObj:Object=ProtocolBuilder.getObject(retPack);
		  if(retObj==null){
          	throw new Error("can not create "+tagetCls+" object on java plantform");
          }
          if(retObj is InvokeException){
          	 throw (retObj as InvokeException);
          }else{
             this.remoteId=retObj as String;
          }
        }
        public function createRemoteObject(pars:Array=null):void{
          var clsName:String=null;
          
          // clsName=ClsNameUtil.getMiddValClsName(getQualifiedClassName(tagetObj));
          var type:XML=describeType(this);
          clsName=type.@alias;
          if(clsName==null || clsName==""){
          	clsName=type.@name;
          }
          clsName=ClsNameUtil.getMiddValClsName(clsName);
		  this.create(clsName,pars);
        }
        
        public function gc():void{
          	/* if(!RemoteObject.isSingleton){ */
          	    fscommand("cmd_dispose",this.remoteId);
          	/* } */
        }
	    public static function externalInterfaceCall(methodName:String,pack:String):Object{
	    	var ret:Object=ExternalInterface.call(methodName,pack);
	    	return ret;
	    }
	}
}