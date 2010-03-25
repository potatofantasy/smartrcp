package smartrcp.platform.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import cn.smartinvoke.gui.FlashContainer;

public class PlatformViewPart extends ViewPart {
	public static final String ID="smartrcp.platform.views.PlatformViewPart";
	public static String Main_Swf_Path="E:/flexWork/cn.smartinvoke.smartrcp-flex/bin-debug/PlatformManager.swf";
    private static String[][] modules=new String[][]
    {
    	    new String[]{"E:/flexWork/cn.smartinvoke.smartrcp-flex/bin-debug/platform/AppManager.swf","软件管理"},
    	    new String[]{"E:/flexWork/cn.smartinvoke.smartrcp-flex/bin-debug/platform/AppSearch.swf","更多软件"}
    };
    private static int num=0;
    private static String[] getModulePath(){
    	return modules[(num++)%modules.length];
    }
    
    private FlashContainer container;
	public PlatformViewPart() {
		
	}

	@Override
	public void createPartControl(Composite arg0) {
		
		Composite parent=new Composite(arg0,SWT.NONE);
		parent.setLayout(new FillLayout());
		String[] moduleInfo=getModulePath();
		this.container=new FlashContainer(parent,moduleInfo[0]);
		super.setPartName(moduleInfo[1]);
		
		this.container.loadMovie(0, new String[]{Main_Swf_Path,moduleInfo[0]});
	}

	@Override
	public void setFocus() {
		
	}

}
