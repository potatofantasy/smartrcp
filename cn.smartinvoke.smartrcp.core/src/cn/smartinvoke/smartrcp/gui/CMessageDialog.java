package cn.smartinvoke.smartrcp.gui;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import cn.smartinvoke.IServerObject;
import cn.smartinvoke.smartrcp.gui.module.CEventBean;

public class CMessageDialog  implements IServerObject {
	private MessageDialog messageDialog;
	public CMessageDialog(Shell mainShell,String dialogTitle,
            String dialogMessage, int dialogImageType,
            Object[] dialogButtonLabels, int defaultIndex) {
		mainShell=Display.getCurrent().getActiveShell();
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
	public void open(CEventBean bean){
	  if(bean!=null){
		 int ret=this.messageDialog.open();
		 bean.fireOnetimeEvent(ret);
	  }
	}
	public boolean close(){
		return this.messageDialog.close();
	}
	public void dispose() {
		
	}

}
