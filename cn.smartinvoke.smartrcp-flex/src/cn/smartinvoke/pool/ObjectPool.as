
/*******************************************************************************
* Copyright (c) 2009 SmartInvoke.
* ����Ը��ƻ��޸Ĵ˴��룬���Ǳ�����Դ����Ͷ����ư�����������Ա�ʾ���û��޸���smartinvoke�Ĵ���
* ����ϧ���ߵ��Ͷ��ɹ�* �����ͨ�� 
*  ��վ:http://smartinvoke.cn/ 
*  �ʼ�:pzxiaoxiao130130@gmail.com
*  QQ��90636900*  jϵ������^_^ 
*******************************************************************************/ 
package cn.smartinvoke.pool
{
	import flash.utils.*;
	
	import mx.core.Application;
	import mx.core.ClassFactory;
	import mx.utils.UIDUtil;
	
	public class ObjectPool
	{
		public static var INSTANCE:ObjectPool=new ObjectPool();
		
		private var objMap:Object=new Object();
		public function ObjectPool()
		{ 
			this.addObject(Application.application,"app");			
		}
		/**
		 *
		 */
		public function addObject(obj:Object,key:String=null):String{
			if(obj==null){
				return null;
			}
			if(key==null){
			  key=UIDUtil.getUID(obj);
			}
			if(this.objMap[key]==null){
		      this.objMap[key]=obj;
		    }
        	return key;
		}
        public function createObject(clsName:String):String{
        	var key:String=null;
        	try{
        	 var clss:Class=getDefinitionByName(clsName) as Class;
		     var avkObj:Object=new ClassFactory(clss).newInstance();
		     key=UIDUtil.getUID(avkObj);
		     this.objMap[key]=avkObj;
        	}catch(e:Error){
        	  throw new Error("class "+clsName+" not found");
        	}
        	return key;
        }
        public function removeObject(objId:String):void{
           if(this.objMap[objId]!=null){
           	//Debug.INSTANCE.println("objectPool: remove "+objId);
        	delete objMap[objId];
           }
        }
        public function getObject(objId:String):Object{
        	if(objId==null){
        		return null;
        	}
        	return this.objMap[objId];
        }
	}
}