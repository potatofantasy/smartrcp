
package cn.smartinvoke.executor
{
	
	import cn.smartinvoke.exception.InvokeException;
	import cn.smartinvoke.exception.Messages;
	import cn.smartinvoke.pool.ObjectPool;
	import cn.smartinvoke.util.ProtocolBuilder;
	
	import flash.external.*;
	import flash.net.*;
	import flash.system.*;
	import flash.utils.*;
	
	import mx.core.Application;
	import mx.utils.UIDUtil;
	
	//import test.Debug;
	public class Executor
	{
		
		public static var SHOW_ERROR_ALERT:Boolean=true;	
		public static var applicationId:String=null;//应用程序ID
		public static var onLoadComplete:Function=null;
		public static function init():void{
			applicationId=UIDUtil.getUID(Application.application);
			ExternalInterface.addCallback("create",create);
			ExternalInterface.addCallback("call",call);
			ExternalInterface.addCallback("dispose",dispose);
			ExternalInterface.addCallback("setId",setId);
			ExternalInterface.addCallback("setProperty",setProperty);
			ExternalInterface.addCallback("getProperty",getProperty);
			fscommand("cmd_finish","1");
		}
		public static function setId(id:String):String{
			//Alert.show("app id="+id);
			applicationId=id;
			if(onLoadComplete!=null){
				onLoadComplete.apply(Application.application,null);
			}
			return "void";
		}
        public static function create(command:String):String{
         var retObj:Object=null;
         try{
           //var arr:Array=ProtocolBuilder.getObject(command) as Array;
           var clsName:String=command;
           retObj=ObjectPool.INSTANCE.createObject(clsName);
           
          }catch(e:Error){
          	retObj=new InvokeException(e.getStackTrace());
          }
          return ProtocolBuilder.getProtocolStr(retObj);
        }
        /**
        ,objId:String,methodName:String,isGetRet:String
        */
        public static function call(command:String):String{
         try{
           var arr:Array=ProtocolBuilder.getObject(command) as Array;
           var objId:String=arr[0] as String;
           var methodName:String=arr[1] as String;
           var avkParams:Array=arr[2]  as Array;
           var isGetRet:Boolean=arr[3] as Boolean;
           
           var retObj:Object=null;
           
           var avkObj:Object=ObjectPool.INSTANCE.getObject(objId);
           if(avkObj==null){//
          	 retObj=new InvokeException(Messages.IVK_OBJECT_NOT_FOUND);       
           }else{
             var avkFun:Function=null;
           	 if(avkObj is Function){//调用对象是一个方法对象
           	   avkFun=avkObj as Function;
           	   avkObj=Application.application;
           	 }else{
               avkFun=avkObj[methodName];
             }
             if(avkFun==null){//
          	   retObj=new InvokeException(Messages.IVK_METHOD_NOT_FOUND);         	
             }else{
               retObj=avkFun.apply(avkObj,avkParams);
               if(!isGetRet){
               	 return ProtocolBuilder.getProtocolStr(null);
               }
             }
           }
         }catch(e:Error){
            retObj=new InvokeException(e.message);
         }
          
         return ProtocolBuilder.getProtocolStr(retObj);
        }
        /**
        *
        */
        public static function setProperty(command:String):String{
         try{ 
           var arr:Array=ProtocolBuilder.getObject(command) as Array;
           var objId:String=arr[0] as String;
           var propName:String=arr[1] as String;
           var propVal:String=arr[2] as String;
           
           var retObj:Object=null;
           
           var avkObj:Object=ObjectPool.INSTANCE.getObject(objId);//���ö���
           if(avkObj==null){//
          	 retObj=new InvokeException(Messages.IVK_OBJECT_NOT_FOUND);  
           }else{
           	 avkObj[propName]=propVal;
           }
           
         }catch(e:Error){
          	retObj=new InvokeException(e.message);
         }
         return ProtocolBuilder.getProtocolStr(retObj);
        }
        /**
        *
        */
        public static function getProperty(command:String):String{
         try{ 
           var arr:Array=ProtocolBuilder.getObject(command) as Array;
           var objId:String=arr[0] as String;
           var propName:String=arr[1] as String;
           
           var retObj:Object=null;
           
           var avkObj:Object=ObjectPool.INSTANCE.getObject(objId);//
           if(avkObj==null){//
          	 retObj=new InvokeException(Messages.IVK_OBJECT_NOT_FOUND);  
           }else{
           	 retObj=avkObj[propName];
           }
         }catch(e:Error){
          	retObj=new InvokeException(e.message);
         }
         return ProtocolBuilder.getProtocolStr(retObj);
        }
        public static function dispose(objId:String):String{
         //Alert.show("executor despose "+objId);
    	 ObjectPool.INSTANCE.removeObject(objId);
    	 return "null";
        }
	}
}