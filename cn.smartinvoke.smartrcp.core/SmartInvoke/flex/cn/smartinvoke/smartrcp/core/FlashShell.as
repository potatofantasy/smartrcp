
/*******************************************************************************
* Copyright (c) 2009 SmartInvoke.
* 此代理类由CodeTransform工具自动生成
* 您可以通过 
*  网站:http://smartinvoke.cn/ 
*  邮件:pzxiaoxiao130130@gmail.com
*  QQ：90636900*  联系到作者^_^ 
*******************************************************************************/ 
package cn.smartinvoke.smartrcp.core
{
 import cn.smartinvoke.RemoteObject;
 import org.eclipse.swt.graphics.Point;
 import org.eclipse.swt.graphics.Point;
 import org.eclipse.swt.graphics.Point;
 import cn.smartinvoke.smartrcp.gui.module.CEventBean;
 import cn.smartinvoke.IServerObject;
 import org.eclipse.swt.graphics.Point;
 import cn.smartinvoke.smartrcp.gui.module.CEventBean;
 import cn.smartinvoke.IServerObject;
 import org.eclipse.swt.graphics.Point;
 import org.eclipse.swt.widgets.Shell;
 import org.eclipse.swt.widgets.Shell;
 import org.eclipse.swt.graphics.Point;
 import cn.smartinvoke.IServerObject;
 import org.eclipse.swt.graphics.Point;
 import org.eclipse.swt.graphics.Point;
 import org.eclipse.swt.graphics.Point;
 import org.eclipse.swt.graphics.Point;
 import org.eclipse.swt.graphics.Point;
 import org.eclipse.swt.graphics.Point;
 import org.eclipse.swt.widgets.Shell;
 import cn.smartinvoke.IServerObject;
 public class FlashShell extends RemoteObject {
  public function FlashShell(){
	 super();
	  //调用服务方构造FlashShell类型服务对象
	 	this.createRemoteObject();
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
   public function setMinimumSize(width:Point,height:Point):void{
	 var retObj:Object=this.call("setMinimumSize",arguments);

   }
   public function close():void{
	 var retObj:Object=this.call("close",arguments);

   }
   public function addShellListener(type:Point,listener:CEventBean):void{
	 var retObj:Object=this.call("addShellListener",arguments);

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
   public function removeShellListener(type:Point,listener:CEventBean):void{
	 var retObj:Object=this.call("removeShellListener",arguments);

   }
   public function getMinimumSize():IServerObject{
	 var retObj:Object=this.call("getMinimumSize",arguments);
	 return retObj as IServerObject;

   }
  public static function create_FlashShell():FlashShell{
	   var remoteObj:FlashShell=new FlashShell();
	   remoteObj.createRemoteObject(null,arguments);
	   return remoteObj;
  }

  public static function create_FlashShell1(style:Point):FlashShell{
	   var remoteObj:FlashShell=new FlashShell();
	   remoteObj.createRemoteObject(null,arguments);
	   return remoteObj;
  }

  public static function create_FlashShell2(shell:Shell):FlashShell{
	   var remoteObj:FlashShell=new FlashShell();
	   remoteObj.createRemoteObject(null,arguments);
	   return remoteObj;
  }

  public static function create_FlashShell3(shell:Shell,style:Point):FlashShell{
	   var remoteObj:FlashShell=new FlashShell();
	   remoteObj.createRemoteObject(null,arguments);
	   return remoteObj;
  }

   public function getSize():IServerObject{
	 var retObj:Object=this.call("getSize",arguments);
	 return retObj as IServerObject;

   }
   public function setSize(w:Point,h:Point):void{
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
   public function setBounds(x:Point,y:Point,width:Point,height:Point):void{
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
   public function createFlashContainer(isModule:Boolean,swfPath:String):void{
	 var retObj:Object=this.call("createFlashContainer",arguments);

   }
   public function getToolTipText():String{
	 var retObj:Object=this.call("getToolTipText",arguments);
	 return retObj as String;

   }
 }

}
