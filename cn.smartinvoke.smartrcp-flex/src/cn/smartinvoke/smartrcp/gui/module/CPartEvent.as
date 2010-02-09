package cn.smartinvoke.smartrcp.gui.module
{
	import cn.smartinvoke.smartrcp.gui.FlashViewer;
	
	[Bindable]
	[RemoteClass(alias="cn.smartinvoke.smartrcp.gui.module.CPartEvent")]
	public class CPartEvent
	{
	public static const Part_Activated:int=0;
	public static const Part_BroughtToTop:int =1;
	public static const Part_Closed:int=2;
	public static const Part_Deactivated:int=3;
	public static const Part_Opened:int=4;
	
    public var type:int=Part_Closed;
    public var taget:FlashViewer=null;
    
	public function CPartEvent(){
			
	}

	}
}