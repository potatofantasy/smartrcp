package cn.smartinvoke.smartrcp.gui;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

import cn.smartinvoke.IServerObject;
import cn.smartinvoke.gui.ObjectPool;
import cn.smartinvoke.smartrcp.gui.control.GlobalServiceId;

public class CMessageDialog implements IServerObject {
	private MessageDialog messageDialog;
	public CMessageDialog(String dialogTitle,
            String dialogMessage, int dialogImageType,
            Object[] dialogButtonLabels, int defaultIndex) {
		Shell mainShell=(Shell)ObjectPool.INSTANCE.getObject(GlobalServiceId.Swt_Main_Win);
		String[] labels=null;
		if(dialogButtonLabels!=null){
			labels=new String[dialogButtonLabels.length];
			for(int n=0;n<labels.length;n++){
				labels[n]=dialogButtonLabels[n].toString();
			}
		}
		messageDialog=
			new MessageDialog(mainShell,dialogTitle,null,dialogMessage,dialogImageType,labels,defaultIndex);
		
	}
	public int open(){
		return this.messageDialog.open();
	}
	public boolean close(){
		return this.messageDialog.close();
	}
	public void dispose() {
		
	}

}
