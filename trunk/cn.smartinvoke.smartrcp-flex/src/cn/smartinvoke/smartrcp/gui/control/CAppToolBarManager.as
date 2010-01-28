
/**
*******************************************************************************/ 
package cn.smartinvoke.smartrcp.gui
{
 import cn.smartinvoke.RemoteObject;
 import cn.smartinvoke.rcp.GlobalServiceId;
 public class CAppToolBarManager extends RemoteObject {
  public function CAppToolBarManager(){
	 super();
	 this.remoteId=GlobalServiceId.App_ToolBar_Manager;
  }
   public function addToolBar(toolBar:CToolBar):void{
	 var retObj:Object=this.call("addToolBar",arguments);

   }
   public function showToolItem(actionId:String):void{
	 var retObj:Object=this.call("showToolItem",arguments);

   }
   public function hideToolItem(actionId:String):void{
	 var retObj:Object=this.call("hideToolItem",arguments);

   }
 }

}
