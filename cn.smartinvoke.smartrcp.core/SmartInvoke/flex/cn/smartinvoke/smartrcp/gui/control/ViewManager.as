
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
 import cn.smartinvoke.smartrcp.gui.module.CObservable;
 import cn.smartinvoke.gui.FlashViewer;
 import java.util.LinkedList;
 import java.util.LinkedList;
 import cn.smartinvoke.gui.FlashViewer;
 import cn.smartinvoke.rcp.CLayoutBasicInfo;
 import cn.smartinvoke.gui.FlashViewer;
 import org.eclipse.ui.IWorkbenchPage;
 public class ViewManager extends CObservable {
  public function ViewManager(){
	 super();
	  //调用服务方构造ViewManager类型服务对象
	 	this.createRemoteObject();
  }

   public function findFlashViewer(appId:String):FlashViewer{
	 var retObj:Object=this.call("findFlashViewer",arguments);
	 return retObj as FlashViewer;

   }
   public function dispose():void{
	 var retObj:Object=this.call("dispose",arguments);

   }
   public function resetViews():void{
	 var retObj:Object=this.call("resetViews",arguments);

   }
   public function bringToTop(appId:String):void{
	 var retObj:Object=this.call("bringToTop",arguments);

   }
  public static function create_ViewManager():ViewManager{
	   var remoteObj:ViewManager=new ViewManager();
	   remoteObj.createRemoteObject(null,arguments);
	   return remoteObj;
  }

   public function closeViewParts(modulePath:String):void{
	 var retObj:Object=this.call("closeViewParts",arguments);

   }
   public function findFlashViewers(modulePath:String):LinkedList{
	 var retObj:Object=this.call("findFlashViewers",arguments);
	 return retObj as LinkedList;

   }
   public function findAppIds(modulePath:String):LinkedList{
	 var retObj:Object=this.call("findAppIds",arguments);
	 return retObj as LinkedList;

   }
   public function isPartVisible(appId:String):Boolean{
	 var retObj:Object=this.call("isPartVisible",arguments);
	 return retObj as Boolean;

   }
   public function close():void{
	 var retObj:Object=this.call("close",arguments);

   }
   public function activate(appId:String):void{
	 var retObj:Object=this.call("activate",arguments);

   }
   public function getActiveViewPart():FlashViewer{
	 var retObj:Object=this.call("getActiveViewPart",arguments);
	 return retObj as FlashViewer;

   }
   public function closeViewPart(appId:String):void{
	 var retObj:Object=this.call("closeViewPart",arguments);

   }
   public function showViewPart(appId:String,state:int):void{
	 var retObj:Object=this.call("showViewPart",arguments);

   }
   public function openViewPart(basicInfo:CLayoutBasicInfo,isMultiple:Boolean,state:int):FlashViewer{
	 var retObj:Object=this.call("openViewPart",arguments);
	 return retObj as FlashViewer;

   }
   public function setState(viewPartId:String,state:int):void{
	 var retObj:Object=this.call("setState",arguments);

   }
   public function hideView(appId:String):void{
	 var retObj:Object=this.call("hideView",arguments);

   }
   public function initIWorkbenchPageListener(page:IWorkbenchPage):void{
	 var retObj:Object=this.call("initIWorkbenchPageListener",arguments);

   }
 }

}
