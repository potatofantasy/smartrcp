package cn.smartinvoke.smartrcp;

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
    	//初始化smartRCP并传入类加载器，这样cn.smartinvoke.smartrcp.core才能动态创建服务类
		SmartRCPBuilder.init(new MyServiceObjectCreator());
		
    	//---------加载图像注册信息
    	SmartRCPBuilder.initImageRegistry(Activator.plugin.getImageRegistry());
        return new ApplicationWorkbenchWindowAdvisor(configurer);
    }

	public String getInitialWindowPerspectiveId() {
		
		return "cn.smartinvoke.smartrcp.core.perspective";// cn.smartinvoke.smartrcp.core.Perspective.ID;
	} 
	
}
