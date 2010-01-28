package cn.smartinvoke.rcp
{
	import org.eclipse.swt.SWT;
	
	[Bindable]
	[RemoteClass(alias="cn.smartinvoke.rcp.CWindowConfigurer")]
	public class CWindowConfigurer
	{
		public var shellStyle:int=SWT.NONE;
    public var shellWidth:int=800;
    public var shellHeight:int=600;
    public var shellTitle:String;
    public var showMenuBar:Boolean=true;
    public var showPerspectiveBar:Boolean=true;
    public var showCoolBar:Boolean=true;
    public var showStatusLine:Boolean=true;
		public function CWindowConfigurer()
		{
		}

	}
}