package smartrcp.platform.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import cn.smartinvoke.gui.FlashContainer;

public class PlatAppMana extends ViewPart {
	public static final String ID="smartrcp.platform.views.PlatAppMana";
	 private FlashContainer container;
	 public static String Main_Swf_Path="E:/flexWork/cn.smartinvoke.smartrcp-flex/bin-debug/PlatformManager.swf";
	@Override
	public void createPartControl(Composite arg){
		Composite parent=new Composite(arg,SWT.NONE);
		parent.setLayout(new FillLayout());
		
		this.container=new FlashContainer(parent,"PlatAppMana");
		
		this.container.loadMovie(0,Main_Swf_Path);
	}

	@Override
	public void setFocus() {
		
	}

}
