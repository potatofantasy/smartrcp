package cn.smartinvoke.smartrcp.gui.control
{
    import cn.smartinvoke.RemoteObject;
    import cn.smartinvoke.rcp.GlobalServiceId;
	
  public class CAppMenuBarManager extends RemoteObject {
  	public static var Instance:CAppMenuBarManager=new CAppMenuBarManager();
  public function CAppMenuBarManager(){
	 super();
	 this.remoteId=GlobalServiceId.App_MenuBar_Manager;
  }
  public function addMenuItem(actionId:String,path:String):void{
	 var retObj:Object=this.call("addMenuItem",arguments);
  }
  public function removeMenuItem(actionId:String,path:String):void{
	 var retObj:Object=this.call("removeMenuItem",arguments);
  }
}

}