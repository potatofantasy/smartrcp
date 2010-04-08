package cn.smartinvoke.rcp
{
	[Bindable]
	[RemoteClass(alias="cn.smartinvoke.rcp.CLayoutBasicInfo")]
	public class CLayoutBasicInfo
	{
		/**
		 *存载flash的viewPart
		 */
		public static const Flash_View_Part:String="cn.smartinvoke.smartrcp.gui.FlashViewPart";
		/**
		 *浏览器的viewPart
		 */
		public static const WebBrowser_View_Part:String="cn.smartinvoke.smartrcp.WebBrowser";
		/**
		 *swt界面单元的viewPart
		 */
		public static const SWTUnit_View_Part:String="cn.smartinvoke.smartrcp.core.SWTUnitViewPart";
		//当前layout的viewId所对应的swf是否是模块swf
	[Inspectable(type="Boolean")]
	public var isModuleSwf:Boolean=true;
	//是否在FlashViewer打开的时候自动加载swf
	[Inspectable(type="Boolean")]
	public var autoLoad:Boolean=false;
	//RCP的viewPart定义ID
	public var viePartId:String=null;
	//需要加载的模块的Id
	public var modulePath:String=null;
    [Inspectable(type="Boolean")]
	public var closeable:Boolean = true;
	[Inspectable(type="Boolean")]
	public var moveable:Boolean = true;
	
	public var title:String;
	public var image:String=null;
		
		public function CLayoutBasicInfo()
		{
			
		}

	}
}