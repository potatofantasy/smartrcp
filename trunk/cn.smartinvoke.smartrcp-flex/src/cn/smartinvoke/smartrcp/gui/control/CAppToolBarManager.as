
/**
*******************************************************************************/ 
package cn.smartinvoke.smartrcp.gui.control
{
 import cn.smartinvoke.RemoteObject;
 import cn.smartinvoke.rcp.CToolBar;
 import cn.smartinvoke.rcp.GlobalServiceId;
 public class CAppToolBarManager extends RemoteObject {
 	public static var Instance:CAppToolBarManager=new CAppToolBarManager();
  public function CAppToolBarManager(){ 
	 super();
	 this.remoteId=GlobalServiceId.App_ToolBar_Manager;
  }
  /**
  *更新工具栏
  */
  public function fillToolBar(toolBar:CToolBar):void{
  	this.call("fillToolBar",arguments);
  }
  public function getCurToolBar():CToolBar{
  	return this.call("getCurToolBar",arguments) as CToolBar;
  }
  public function removeItem(actionId:String):void{
	  this.call("removeItem",arguments);
  }
  public function removeAll():void{
	  this.call("removeAll",arguments);
  }
  public function insertBefore(beforeId:String,actionId:String):void{
	  this.call("insertBefore",arguments);
  }
  public function insertAfter(afterId:String,actionId:String):void{
	 this.call("insertAfter",arguments);
  }
  public function insertItem(actionId:String):void{
	 this.call("insertItem",arguments);
  }

 }

}
