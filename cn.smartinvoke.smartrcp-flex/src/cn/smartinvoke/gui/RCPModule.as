package cn.smartinvoke.gui
{
	import cn.smartinvoke.RemoteObject;
	import cn.smartinvoke.pool.ObjectPool;
	import cn.smartinvoke.rcp.CAction;
	import cn.smartinvoke.rcp.CToolBar;
	import cn.smartinvoke.smartrcp.gui.FlashViewer;
	
	import mx.events.FlexEvent;
	import mx.modules.Module;
    /**
    *所有rcp模块都必须继承的父类
    */
	public class RCPModule extends Module
	{
		public var flashViewer:FlashViewer=null;//容器对象的引用
		public var flashContainer:FlashContainer=null;
		public var contextMenuManager:CContextMenuManager=null;
		public static var Instance:RCPModule=null;
		public function RCPModule()
		{
			super();
			RCPModule.Instance=this;
			var pool:ObjectPool=ObjectPool.INSTANCE;
			pool.removeObject("app");
			pool.addObject(this,"app");
		}
		private function init(evt:FlexEvent):void{
			//引用与当前模块相对应的java对象FlashViewer
			
		}
		//-------------viewPart工具栏和下拉菜单
		protected function addAction(action:CAction):void{
			
		}
		protected function fillToolBar(toolBar:CToolBar):void{
			
		}
		protected function addDropDownMenu(actionId:String,path:String):void{
			
		}
		//-------------------
		
		public function promptTitleAndMessage():Array{
		   return ["是否保存","视图数据已经修改，是否保存"];
	    }

	    public function doSave(monitor:RemoteObject):void{
	       
	    }
	    public function doSaveAs():void {
		   
	    }

	    public function isDirty():Boolean {
		  return false;
	    }

 	    public function isSaveAsAllowed():Boolean {
		   return false;
	    }

	    public function isSaveOnCloseNeeded():Boolean {
	    	return false;
	    }
	}
}