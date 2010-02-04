package cn.smartinvoke.smartrcp.gui.control
{
	import cn.smartinvoke.RemoteObject;
	import cn.smartinvoke.rcp.CLayoutBasicInfo;
	import cn.smartinvoke.rcp.GlobalServiceId;
	import cn.smartinvoke.smartrcp.gui.FlashViewer;
	
	import mx.collections.ArrayCollection;
	[Bindable]
	[RemoteClass(alias="cn.smartinvoke.smartrcp.gui.control.ViewManager")]
	public class ViewManager extends RemoteObject
	{
	    public static const VIEW_ACTIVATE:int=1;	
	    public static const VIEW_VISIBLE:int=2;
	    public static const VIEW_CREATE:int=3;
	    
	    public static const STATE_MAXIMIZED:int=1;
	    public static const STATE_MINIMIZED:int=0;
	    public static const STATE_RESTORED:int=2;
	    public static var Instance:ViewManager=new ViewManager();
		public function ViewManager()
		{
			this.remoteId=GlobalServiceId.View_Manager;
		}
        public function openViewPart( basicInfo:CLayoutBasicInfo,isMultiple:Boolean,state:int):FlashViewer{
        	return this.call("openViewPart",arguments) as FlashViewer;
        }
        
        public function closeViewPart(appId:String):void{
	        this.call("closeViewPart",arguments);
        }
        public function showViewPart(appId:String,state:int=1):void{
	        this.call("showViewPart",[appId,state]);
        }
        public function setState(appId:String,state:int):void{
	        this.call("setState",arguments);
        }
        /**
        *获得当前获得焦点的viewPart
        */
        public function getActiveViewPart():FlashViewer{
        	return this.call("getActiveViewPart",arguments) as FlashViewer;
        }
        
        public function findAppIds(modulePath:String):ArrayCollection{
	      var retObj:Object=this.call("findAppIds",arguments);
	      return retObj as ArrayCollection;
        }
        public function findFlashViewers(modulePath:String):ArrayCollection{
	      var retObj:Object=this.call("findFlashViewers",arguments);
	      return retObj as ArrayCollection;
        }
        public function findFlashViewer(appId:String):FlashViewer{
	      var retObj:Object=this.call("findFlashViewer",arguments);
	      return retObj as FlashViewer;
        }
        public function closeViewParts(modulePath:String):void{
	      this.call("closeViewParts",arguments);
        }
        public function resetViews():void{
        	this.call("resetViews",arguments);
        }
	}
}