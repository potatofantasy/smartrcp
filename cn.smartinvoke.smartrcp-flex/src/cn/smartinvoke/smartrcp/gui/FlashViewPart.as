package cn.smartinvoke.smartrcp.gui
{
	import cn.smartinvoke.RemoteObject;
    [Bindable]
	[RemoteClass(alias="cn.smartinvoke.smartrcp.gui.FlashViewPart")]
	public class FlashViewPart extends RemoteObject
	{
		public function FlashViewPart(param:Array=null)
		{
			super(param);
		}
		public function getPartActionBar():ViewPartActionBar{
			return this.call("getPartActionBar",arguments) as ViewPartActionBar;
		}
	}
}