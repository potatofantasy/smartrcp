
/*******************************************************************************
* Copyright (c) 2009 SmartInvoke.
* 此代理类由CodeTransform工具自动生成
* 您可以通过 
*  网站:http://smartinvoke.cn/ 
*  邮件:pzxiaoxiao130130@gmail.com
*  QQ：90636900*  联系到作者^_^ 
*******************************************************************************/ 
package org.eclipse.swt.widgets
{
	import cn.smartinvoke.RemoteObject;
	
 [Bindable]
	[RemoteClass(alias="org.eclipse.swt.widgets.Shell")]
public class Shell extends RemoteObject {
  public function Shell(disp:Display=null){
	 super();
	 this.createRemoteObject([disp]);
  }
  public function close():void{
	 var retObj:Object=this.call("close",arguments);

   }
   public function getLocation():Object{
	 var retObj:Object=this.call("getLocation",arguments);
	 return retObj as Object;

   }
   public function setSize(w:int,h:int):void{
   	this.call("setSize",arguments);
   }
   public function setText(text:String):void{
   	this.call("setText",arguments);
   }
   public function open():void{
	 var retObj:Object=this.call("open",arguments);
     
   }

}
}
