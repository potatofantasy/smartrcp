package cn.smartinvoke.rcp
{
	/**
	 *透视图
	 */
	 
	 [Bindable]
	[RemoteClass(alias="cn.smartinvoke.rcp.CPerspective")]
	public class CPerspective
	{
		/*private static var _instance:CPerspective=null;
		public static function get instance():CPerspective{
			if(_instance==null){
			  _instance=new CPerspective();
			}
			return _instance;
		}
		
		private var _pageLayout:CPageLayout=new CPageLayout();
		public function get editorArea():CPageLayout{
			return _pageLayout;
		}*/
		
		public var actions:Array=null;
		public var menuBars:Array=null;
		public var toolBarIds:Array=null;
		
		public var page:CPageLayout=null;
		
		public function CPerspective()
		{
		}
        
	}
}