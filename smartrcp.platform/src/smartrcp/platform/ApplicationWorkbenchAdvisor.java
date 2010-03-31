package smartrcp.platform;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferenceConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.application.IWorkbenchConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchAdvisor;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

import cn.smartinvoke.smartrcp.core.Perspective;
import cn.smartinvoke.smartrcp.core.SmartRCPBuilder;

public class ApplicationWorkbenchAdvisor extends WorkbenchAdvisor {

	private static final String PERSPECTIVE_ID = "smartrcp.platform.perspective";
    public static IWorkbench workbench;
	public WorkbenchWindowAdvisor createWorkbenchWindowAdvisor(
			IWorkbenchWindowConfigurer configurer) {
		workbench=this.getWorkbenchConfigurer().getWorkbench();
		return new ApplicationWorkbenchWindowAdvisor(configurer);
	}
	public IStatus restoreState(IMemento memento) {
    	SmartRCPBuilder.Instance.restoreWorkbenchState(memento);
    	return org.eclipse.core.runtime.Status.OK_STATUS;
		//return Status.OK;
	}
    public IStatus saveState(IMemento memento) {
    	SmartRCPBuilder.Instance.saveWorkbenchState(memento);
    	return org.eclipse.core.runtime.Status.OK_STATUS;
	}
    public void initialize(IWorkbenchConfigurer configurer) {
    	super.initialize(configurer);
    	//---------加载图像注册信息
      	SmartRCPBuilder.Instance.initImageRegistry(Activator.getDefault().getImageRegistry());
    	//初始化窗口
  		SmartRCPBuilder.Instance.initWindows();
        SmartRCPBuilder.Instance.initWorkbench(configurer); 
    }
	public String getInitialWindowPerspectiveId() {
		return Perspective.ID;
	}

}
