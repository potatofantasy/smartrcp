package cn.smartinvoke.rcp
{
	import org.eclipse.swt.SWT;
	
	[Bindable]
	[RemoteClass(alias="cn.smartinvoke.rcp.CWindowConfigurer")]
	public class CWindowConfigurer
	{
		public var shellStyle:int=SWT.SHELL_TRIM;
    public var shellWidth:int=800;
    public var shellHeight:int=600;
    public var shellTitle:String;
    public var shellImage:String;
    public var maximized:Boolean=false;//窗口是否最大化
    public var showMenuBar:Boolean=true;
    public var showPerspectiveBar:Boolean=true;
    public var showCoolBar:Boolean=true;
    public var showStatusLine:Boolean=true;
		public function CWindowConfigurer()
		{
		}

	}
}