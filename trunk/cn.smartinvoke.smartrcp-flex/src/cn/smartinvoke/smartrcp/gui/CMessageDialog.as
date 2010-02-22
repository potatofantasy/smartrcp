package cn.smartinvoke.smartrcp.gui
{
	import cn.smartinvoke.RemoteObject;
	import cn.smartinvoke.gui.RCPApplication;
	import cn.smartinvoke.smartrcp.gui.module.CEventBean;
	import cn.smartinvoke.smartrcp.util.HelpMethod;
	
	import org.eclipse.swt.widgets.Shell;
	[Bindable]
	[RemoteClass(alias="cn.smartinvoke.smartrcp.gui.CMessageDialog")]
	public class CMessageDialog extends RemoteObject
 {
		 /**
     * Constant for a dialog with no image (value 0).
     */
    public  static const NONE:int = 0;

    /**
     * Constant for a dialog with an error image (value 1).
     */
    public  static const  ERROR:int = 1;

    /**
     * Constant for a dialog with an info image (value 2).
     */
    public  static const INFORMATION:int = 2;

    /**
     * Constant for a dialog with a question image (value 3).
     */
    public  static const  QUESTION:int = 3;
    
    /**
     * Constant for a dialog with a warning image (value 4).
     */
    public  static const  WARNING:int = 4;
    
	public function CMessageDialog( dialogTitle:String,dialogMessage:String, dialogImageType:int,
            dialogButtonLabels:Array, defaultIndex:int){
            var mainShell:Shell=RCPApplication.Instance.flashViewer.getShell();
		this.createRemoteObject([mainShell,dialogTitle,dialogMessage,dialogImageType,
		    dialogButtonLabels,defaultIndex]);
		    
	}
	public function open(listener:Function,thisObject:Object):void{
		var bean:CEventBean=HelpMethod.createEventBean(listener,thisObject);
		if(bean!=null){
			this.asyncCall('open',[bean]);	
		}
	}
	public function close():Boolean{
		return this.call('close',arguments) as Boolean;
	}
 }
}