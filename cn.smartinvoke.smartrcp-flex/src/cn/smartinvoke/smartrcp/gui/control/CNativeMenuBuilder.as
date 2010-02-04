
/*******************************************************************************
* Copyright (c) 2009 SmartInvoke.
* 此代理类由CodeTransform工具自动生成
* 您可以通过 
*  网站:http://smartinvoke.cn/ 
*  邮件:pzxiaoxiao130130@gmail.com
*  QQ：90636900*  联系到作者^_^ 
*******************************************************************************/ 
package cn.smartinvoke.smartrcp.gui.control
{
 import cn.smartinvoke.RemoteObject;
 import cn.smartinvoke.rcp.CAction;
 import cn.smartinvoke.rcp.CMenuRelation;
 import cn.smartinvoke.smartrcp.gui.module.CEventBean;
 import cn.smartinvoke.smartrcp.util.HelpMethod;
 public class CNativeMenuBuilder extends RemoteObject {
  public function CNativeMenuBuilder(parent:RemoteObject){
	 super();
	 this.createRemoteObject(arguments);
  }
   
   public function initAction(cActions:Array):void{
	 var retObj:Object=this.call("initAction",arguments);
   }
   public function addAction(cAction:CAction):void{
	 var retObj:Object=this.call("addAction",arguments);
   }
   public function initMenu(menuRelation:CMenuRelation):void{
	 var retObj:Object=this.call("initMenu",arguments);
   }
   public function fireActionClick(actionId:String):void{
	 var retObj:Object=this.call("fireActionClick",arguments);
   }
   public function show(x:int,y:int):void{
	 var retObj:Object=this.call("show",arguments);
   }
   public function hide():void{
	 var retObj:Object=this.call("hide",arguments);
   }
   public function setEnable(actionId:String,enable:Boolean):void{
	 var retObj:Object=this.call("setEnable",arguments);
   }
   //-------------------------
   public function addMenuItem(actionId:String,path:String):void{
	 var retObj:Object=this.call("addMenuItem",arguments);

   }
   public function removeMenuItem(actionId:String,path:String):void{
	 var retObj:Object=this.call("removeMenuItem",arguments);

   }
    //------------------------------------
    public function addListener(listener:Function,thisObject:Object):void{
			if(listener==null){
				return;
			}
			var bean:CEventBean=HelpMethod.createEventBean(listener,thisObject);
			if(bean!=null){
			 this.call("addListener",[bean]);
			}
	}
	public function removeListener(
		   listener:Function,thisObject:Object):void{
		   var bean:CEventBean=HelpMethod.removeListener(listener,thisObject);
		   if(bean!=null){
		   	  this.call('removeListener',[bean]);
		   }
	}
 }

}
