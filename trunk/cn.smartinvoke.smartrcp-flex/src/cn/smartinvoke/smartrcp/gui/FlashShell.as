
/*******************************************************************************
*******************************************************************************/ 
package cn.smartinvoke.smartrcp.gui
{
 import cn.smartinvoke.IServerObject;
 import cn.smartinvoke.RemoteObject;
 import cn.smartinvoke.smartrcp.CApplication;
 import cn.smartinvoke.smartrcp.gui.module.CEventBean;
 import cn.smartinvoke.smartrcp.util.HelpMethod;
 
 import org.eclipse.swt.widgets.Shell;
 [Bindable]
 [RemoteClass(alias="cn.smartinvoke.smartrcp.gui.FlashShell")]
 public class FlashShell extends RemoteObject {
 public function FlashShell(style:int=0,parent:Shell=null){
	 super();                         
	 var param:Array=[];
	 if(style!=0){ 
	 	if(parent==null){
	 		param=[style];
	 	}else{
	 		param=[parent,style];
	 	}
	 }else{
	 	if(parent!=null){
	 		param=[parent];
	 	}
	 }
	 this.createRemoteObject(param);
  }
  public function createFlashContainer(swfPath:String,isModule:Boolean=true):void{
  	 var par:Array=null;
  	 if(isModule){
  	 	par=[CApplication.Instance.getRuntimeSwfPath(),swfPath];
  	 }else{
  	 	par=[swfPath];
  	 }
	 var retObj:Object=this.call("createFlashContainer",par);
  }
  public function getEnabled():Boolean{
	 var retObj:Object=this.call("getEnabled",arguments);
	 return retObj as Boolean;
  }
  public function setToolTipText(text:String):void{
	 var retObj:Object=this.call("setToolTipText",arguments);
  }
  public function setText(text:String):void{
	 var retObj:Object=this.call("setText",arguments);
  }
  public function setMinimumSize(width:int,height:int):void{
	 var retObj:Object=this.call("setMinimumSize",arguments);
  }
   public function close():void{
	 var retObj:Object=this.call("close",[this.remoteId]);
   }
   public function addListener(type:int,listener:Function,thisObject:Object):void{
   	if(listener==null || thisObject==null){
	   return;
	}
	var bean:CEventBean=HelpMethod.createEventBean(listener,thisObject);
	if(bean!=null){
	  this.call("addShellListener",[type,bean]);
	}
   }
   public function removeListener(type:int,listener:Function,thisObject:Object):void{
   	 if(listener!=null && thisObject!=null){
   	 	 var bean:CEventBean=HelpMethod.removeListener(listener,thisObject);
   	 	 if(bean!=null){
   	 	 	this.call("removeShellListener",[type,bean]);
   	 	 }
   	 }
   }
   public function open():void{
	 var retObj:Object=this.call("open",arguments);

   }
   public function getText():String{
	 var retObj:Object=this.call("getText",arguments);
	 return retObj as String;

   }
   public function isVisible():Boolean{
	 var retObj:Object=this.call("isVisible",arguments);
	 return retObj as Boolean;

   }
   public function getBounds():IServerObject{
	 var retObj:Object=this.call("getBounds",arguments);
	 return retObj as IServerObject;

   }
   public function setEnabled(enabled:Boolean):void{
	 var retObj:Object=this.call("setEnabled",arguments);

   }
   public function setActive():void{
	 var retObj:Object=this.call("setActive",arguments);

   }
  
   public function getMinimumSize():IServerObject{
	 var retObj:Object=this.call("getMinimumSize",arguments);
	 return retObj as IServerObject;

   }
   public function getSize():IServerObject{
	 var retObj:Object=this.call("getSize",arguments);
	 return retObj as IServerObject;

   }
   public function setSize(w:int,h:int):void{
	 var retObj:Object=this.call("setSize",arguments);

   }
   public function setImage(img:String):void{
	 var retObj:Object=this.call("setImage",arguments);

   }
   public function dispose():void{
	 var retObj:Object=this.call("dispose",arguments);

   }
   public function setVisible(visible:Boolean):void{
	 var retObj:Object=this.call("setVisible",arguments);

   }
   public function setBounds(x:int,y:int,width:int,height:int):void{
	 var retObj:Object=this.call("setBounds",arguments);

   }
   public function getShell():Shell{
	 var retObj:Object=this.call("getShell",arguments);
	 return retObj as Shell;

   }
   public function isEnabled():Boolean{
	 var retObj:Object=this.call("isEnabled",arguments);
	 return retObj as Boolean;

   }
   public function getLocation():IServerObject{
	 var retObj:Object=this.call("getLocation",arguments);
	 return retObj as IServerObject;

   }
   public function forceActive():void{
	 var retObj:Object=this.call("forceActive",arguments);

   }
   
   public function getToolTipText():String{
	 var retObj:Object=this.call("getToolTipText",arguments);
	 return retObj as String;

   }
 }

}
