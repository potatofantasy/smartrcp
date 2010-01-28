package cn.smartinvoke.gui
{
	import cn.smartinvoke.smartrcp.gui.control.CNativeMenuBuilder;
	import cn.smartinvoke.smartrcp.gui.module.CEvent;
	
	import mx.controls.Alert;
	import mx.controls.Menu;
	import mx.utils.UIDUtil;
	
	import org.eclipse.swt.CEventType;
	
	/**
	 *右键管理器，此类维护一张右键菜单对象表，当从display监听到鼠标右键事件触发后，
	 *将与事件发生控件相关联的右键菜单对象显示出来
	 */
	public class CContextMenuManager
	{
		//public static var Instance:CContextManager=new CContextManager();
		private var rcpApp:RCPApplication;
		public function CContextMenuManager(rcpApp:RCPApplication)
		{
			this.rcpApp=rcpApp;
			this.rcpApp.flashContainer.addListener(CEventType.MouseDown,this.onRightClick,this);
			//Alert.show("CContextMenuManager: "+Executor.applicationId);
		}
		private var lastShowMenu:Object=null;//上次打开的菜单
		public function hideAlreadyOpenMenu():void{
			if(lastShowMenu!=null){//关闭已经打开的菜单
				lastShowMenu.hide();
			}
		}
		private function onRightClick(evt:CEvent):void{
			hideAlreadyOpenMenu();
			
		    var taget:Object=this.rcpApp.mouseOverTaget;
		    
		    if(taget!=null){
		    	var menuObj:Object=this.menuMap[UIDUtil.getUID(taget)];
		    	//Alert.show("taget="+taget+" menu="+menuObj);
		    	if(menuObj is CNativeMenuBuilder){
		    	 var nativeMenu:CNativeMenuBuilder=menuObj as CNativeMenuBuilder;
		    	 nativeMenu.show(evt.x,evt.y);
		    	}else{
		    	 var menu:Menu=menuObj as Menu;
		    	 if(menu!=null){
		    		menu.show(evt.x,evt.y);	
		    	 }
		    	 this.lastShowMenu=menuObj;
		    	}
		    	
		    }
		}
        private var menuMap:Object=new Object();
        public function addMenu(tagetObj:Object,contextMenu:Menu):void{
        	if(tagetObj!=null && contextMenu!=null){
        		menuMap[UIDUtil.getUID(tagetObj)]=contextMenu;
        	}
        }
        public function addNativeMenu(tagetObj:Object,nativeMenuManager:CNativeMenuBuilder):void{
        	if(tagetObj!=null && nativeMenuManager!=null){
        		menuMap[UIDUtil.getUID(tagetObj)]=nativeMenuManager;
        	}
        }
        public function removeMenu(tagetObj:Object):void{
        	if(tagetObj!=null){
        		var uid:String=UIDUtil.getUID(tagetObj);
        		var obj:Object=menuMap[uid];
        		if(obj!=null){
        		 if(obj is CNativeMenuBuilder){
        			var nativeMenu:CNativeMenuBuilder=obj as CNativeMenuBuilder;
        			nativeMenu.gc();
        		 }
        		 delete menuMap[uid];
        		}
        	}
        }
	}
}