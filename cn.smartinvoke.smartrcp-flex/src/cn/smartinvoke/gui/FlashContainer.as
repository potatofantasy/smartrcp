package cn.smartinvoke.gui
{
	import cn.smartinvoke.rcp.GlobalServiceId;
	
	import org.eclipse.swt.Obserable;
[Bindable]
	[RemoteClass(alias="cn.smartinvoke.gui.FlashContainer")]
	public class FlashContainer  extends  Obserable
	{
		public function FlashContainer()
		{
			super();		
			this.remoteId=GlobalServiceId.FlashViewer_Control;
		}
	    
	}
}