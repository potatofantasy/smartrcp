package cn.smartinvoke.smartrcp.gui.module
{
	import cn.smartinvoke.RemoteObject;
	import cn.smartinvoke.gui.RCPApplication;
	import cn.smartinvoke.smartrcp.util.HelpMethod;
	
	import org.eclipse.swt.widgets.Shell;
    [Bindable]
	[RemoteClass(alias="cn.smartinvoke.smartrcp.gui.module.CommonDialogs")]
	public class CommonDialogs extends RemoteObject
	{
		public static var Instance:CommonDialogs=new CommonDialogs();
		public function CommonDialogs()
		{
			super();
			this.createRemoteObject();
		}
		/**
		 *打开颜色对话框
		 */
		public function openColorDialog(listener:Function,thisObject:Object,style:int=0):void{
		  var bean:CEventBean=HelpMethod.createEventBean(listener,thisObject);
		  var shell:Shell=RCPApplication.Instance.flashViewer.getShell();
		  if(bean!=null){
		  	 this.asyncCall("openColorDialog",[shell,bean,style]);
		  }
		}
		/**
		 *打开目录选择对话框
		 */
		public function openDirectoryDialog(listener:Function,thisObject:Object,
		                     title:String=null,msg:String=null,filterPath:String=null,style:int=0):void{
		  var bean:CEventBean=HelpMethod.createEventBean(listener,thisObject);
		  var shell:Shell=RCPApplication.Instance.flashViewer.getShell();
		  if(bean!=null){
		  	 this.asyncCall("openDirectoryDialog",[shell,bean,title,msg,filterPath,style]);
		  }                    	
		}
		/**
		 *打开文件选择对话框
		 */
		public function openFileSelDialog(listener:Function,thisObject:Object,
		             isMulti:Boolean=false,filterExtensions:Array=null):void{
		                  	
	    }
	}
}