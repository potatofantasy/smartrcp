package smartrcp.platform.views;

import java.io.File;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import cn.smartinvoke.gui.FlashContainer;
import cn.smartinvoke.gui.FlashViewer;
import cn.smartinvoke.rcp.CPerspective;

public class PlatAppMana extends ViewPart {
	public static final String ID="smartrcp.platform.views.PlatAppMana";
	 private FlashViewer flashViewer;
	 public static String Main_Swf_Path="E:/flexWork/cn.smartinvoke.smartrcp-flex/bin-debug/PlatformManager.swf";
	
	public void createPartControl(Composite parent){
		String viewId=Main_Swf_Path;
		int appId=FlashViewer.getViewNum();
		if(new File(viewId).exists()){
			flashViewer = new FlashViewer(appId+"", parent,viewId);
		}else{
		    flashViewer = new FlashViewer(appId+"", parent,
				CPerspective.getRuntimeSwfFolder() + "/" + viewId);
		}
		flashViewer.setParent(this);
		flashViewer.loadFlash();
	}
    public void dispose(){
    	if(flashViewer!=null){
    		flashViewer.dispose();
    	}
    }
	public void setFocus() {
		
	}

}
