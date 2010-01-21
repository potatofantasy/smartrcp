package views
{
	import org.pengzhen.smartrcp.ui.CViewDescribe;

	public class ContentViewDescribe extends CViewDescribe
	{
		public function ContentViewDescribe(clsName:String, icon:String)
		{
			super(clsName, icon);
			this.id="org.pengzhen.smartrcp.ui.view.ContentView";
			this.name="content";
			this.closeable=false;
			this.moveable=true;
		}
		
	}
}