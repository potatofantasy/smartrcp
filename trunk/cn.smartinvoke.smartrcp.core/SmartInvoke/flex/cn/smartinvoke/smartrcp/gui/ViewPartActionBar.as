
/*******************************************************************************
* Copyright (c) 2009 SmartInvoke.
* 此代理类由CodeTransform工具自动生成
* 您可以通过 
*  网站:http://smartinvoke.cn/ 
*  邮件:pzxiaoxiao130130@gmail.com
*  QQ：90636900*  联系到作者^_^ 
*******************************************************************************/ 
package cn.smartinvoke.smartrcp.gui
{
 import cn.smartinvoke.RemoteObject;
 import cn.smartinvoke.smartrcp.gui.ActionBarBase;
 import cn.smartinvoke.rcp.CToolBar;
 import cn.smartinvoke.smartrcp.gui.control.CAction;
 import org.eclipse.ui.IActionBars;
 public class ViewPartActionBar extends ActionBarBase {
  public function ViewPartActionBar(){
	 super();
	  //调用服务方构造ViewPartActionBar类型服务对象
	 	this.createRemoteObject();
  }

   public function addDropDownMenu(actionId:String,path:String):void{
	 var retObj:Object=this.call("addDropDownMenu",arguments);

   }
   public function dispose():void{
	 var retObj:Object=this.call("dispose",arguments);

   }
   public function removeDropDownMenu(actionId:String,path:String):void{
	 var retObj:Object=this.call("removeDropDownMenu",arguments);

   }
   public function fillToolBar(toolBar:CToolBar):void{
	 var retObj:Object=this.call("fillToolBar",arguments);

   }
   public function addAction(cAction:CAction):void{
	 var retObj:Object=this.call("addAction",arguments);

   }
   public function removeAction(actionId:String):void{
	 var retObj:Object=this.call("removeAction",arguments);

   }
  public static function create_ViewPartActionBar(actionBars:IActionBars):ViewPartActionBar{
	   var remoteObj:ViewPartActionBar=new ViewPartActionBar();
	   remoteObj.createRemoteObject(null,arguments);
	   return remoteObj;
  }

 }

}
