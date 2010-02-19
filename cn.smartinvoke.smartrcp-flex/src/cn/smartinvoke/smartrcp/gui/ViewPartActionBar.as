package cn.smartinvoke.smartrcp.gui
{
	import cn.smartinvoke.rcp.CToolBar;
	import cn.smartinvoke.smartrcp.gui.control.ActionBarBase;
[Bindable]
	[RemoteClass(alias="cn.smartinvoke.smartrcp.gui.ViewPartActionBar")]
	public class ViewPartActionBar extends ActionBarBase
	{
		public function ViewPartActionBar()
		{
			
		}
		
		public function addDropDownMenu(actionId:String,path:String):void{
	       this.call("addDropDownMenu",arguments);
        }
        public function clearToolBar():void{
        	this.call("clearToolBar",arguments);
        }
   public function removeDropDownMenu(actionId:String,path:String):void{
	this.call("removeDropDownMenu",arguments);
   }
   public function fillToolBar(toolBar:CToolBar):void{
	 this.call("fillToolBar",arguments);
   }
    public function clearDropDownMenus():void{
    	this.call("clearDropDownMenus",arguments);
    }
	}
}