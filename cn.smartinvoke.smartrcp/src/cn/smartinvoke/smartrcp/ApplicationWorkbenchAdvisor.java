package cn.smartinvoke.smartrcp;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IWorkbenchPreferenceConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.application.IWorkbenchConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchAdvisor;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

import cn.smartinvoke.smartrcp.core.SmartRCPBuilder;

/**
 * This workbench advisor creates the window advisor, and specifies
 * the perspective id for the initial window.
 */
public class ApplicationWorkbenchAdvisor extends WorkbenchAdvisor {
	
	//private static final String PERSPECTIVE_ID = "cn.smartinvoke.smartrcp.coreperspective";

    public WorkbenchWindowAdvisor createWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
    	
        return new ApplicationWorkbenchWindowAdvisor(configurer);
    }
    public IStatus restoreState(IMemento memento) {
    	System.out.println("恢复 Workbench state");
		return Status.OK_STATUS;
	}
    public IStatus saveState(IMemento memento) {
    	System.out.println("保存 Workbench state");
		return Status.OK_STATUS;
	}
    public void initialize(IWorkbenchConfigurer configurer) {
    	 super.initialize(configurer);

    	 PlatformUI.getPreferenceStore().setValue(IWorkbenchPreferenceConstants.
    	                       SHOW_TRADITIONAL_STYLE_TABS, true);
    	    
    	//初始化smartRCP并传入类加载器，这样cn.smartinvoke.smartrcp.core才能动态创建服务类
 		SmartRCPBuilder.init(new MyServiceObjectCreator());
     	//---------加载图像注册信息
     	SmartRCPBuilder.initImageRegistry(Activator.plugin.getImageRegistry());
        SmartRCPBuilder.initWorkbench(configurer);
        
    }
	public String getInitialWindowPerspectiveId() {
		
		return "cn.smartinvoke.smartrcp.core.perspective";// cn.smartinvoke.smartrcp.core.Perspective.ID;
	} 
	
}
