package cn.smartinvoke.smartrcp.gui.module
{
	[Bindable]
	[RemoteClass(alias="cn.smartinvoke.smartrcp.gui.module.ViewPartMenus")]
	public class ViewPartMenus
	{
		public var toolBarActions:Array=null;
        public var  menuBarActions:Array=null;
        public var  contextMenuActions:Array=null;
		public function ViewPartMenus()
		{
		}
        
	}
}