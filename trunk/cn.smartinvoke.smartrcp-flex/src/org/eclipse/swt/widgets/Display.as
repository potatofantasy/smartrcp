package org.eclipse.swt.widgets
{
	import cn.smartinvoke.rcp.GlobalServiceId;
	
	import org.eclipse.swt.Obserable;
    [Bindable]
	[RemoteClass(alias="org.eclipse.swt.widgets.Display")]
	public class Display extends Obserable
	{
		private static var _display:Display;
		public static function getCurrent():Display{
			if(_display==null){
				_display=new Display();
			}
			return _display;
		}
		public function Display(param:Array=null)
		{
			super(param);
			this.remoteId=GlobalServiceId.Swt_Display;
		}

	}
}