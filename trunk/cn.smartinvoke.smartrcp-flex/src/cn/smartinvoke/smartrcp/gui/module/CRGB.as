package cn.smartinvoke.smartrcp.gui.module
{
	[Bindable]
	[RemoteClass(alias="cn.smartinvoke.smartrcp.gui.module.CRGB")]
	public class CRGB
	{
		/**
	 * the red component of the RGB
	 */
	public var red:int;
	
	/**
	 * the green component of the RGB
	 */
	public var green:int;
	
	/**
	 * the blue component of the RGB
	 */
	public var blue:int;
		public function CRGB()
		{
		}
        
	}
}