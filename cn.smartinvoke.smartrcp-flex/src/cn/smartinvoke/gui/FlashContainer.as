package cn.smartinvoke.gui
{
	import cn.smartinvoke.rcp.GlobalServiceId;
	
	import org.eclipse.swt.Obserable;

	public class FlashContainer  extends Obserable
	{
		public function FlashContainer(param:Array=null)
		{
			super(param);
			this.remoteId=GlobalServiceId.FlashViewer_Control;
		}
	    
	}
}