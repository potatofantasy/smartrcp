package cn.smartinvoke.gui
{
	import cn.smartinvoke.pool.ObjectPool;
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
		public var contextMenuManager:CContextMenuManager=null
		public function RCPModule()
		{
			super();
			var pool:ObjectPool=ObjectPool.INSTANCE;
			pool.removeObject("app");
			pool.addObject(this,"app");
		}
		private function init(evt:FlexEvent):void{
			//引用与当前模块相对应的java对象FlashViewer
			
		}
	}
}