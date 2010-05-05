package smartrcp.platform.dev;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.application.IWorkbenchConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchAdvisor;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

import cn.smartinvoke.ObjectPool;
import cn.smartinvoke.smartrcp.DebugServer;
import cn.smartinvoke.smartrcp.core.Perspective;
import cn.smartinvoke.smartrcp.gui.control.GlobalServiceId;
import cn.smartinvoke.smartrcp.util.JFaceHelpMethod;
import cn.smartinvoke.util.ConfigerLoader;

public class ApplicationWorkbenchAdvisor extends WorkbenchAdvisor {
    public static IWorkbench workbench;
	public WorkbenchWindowAdvisor createWorkbenchWindowAdvisor(
			IWorkbenchWindowConfigurer configurer) {
		workbench=this.getWorkbenchConfigurer().getWorkbench();
		return new ApplicationWorkbenchWindowAdvisor(configurer);
	}
	public IStatus restoreState(IMemento memento) {
    	Builder.Instance.restoreWorkbenchState(memento);
    	return org.eclipse.core.runtime.Status.OK_STATUS;
		//return Status.OK;
	}
    public IStatus saveState(IMemento memento) {
    	Builder.Instance.saveWorkbenchState(memento);
    	return org.eclipse.core.runtime.Status.OK_STATUS;
	}
    
    private ExtClassLoader extClassLoader;//自定义类加载器
    public void initialize(IWorkbenchConfigurer configurer) {
     try{
    	super.initialize(configurer);
    	//---------加载图像注册信息
      	Builder.Instance.initImageRegistry(Activator.getDefault().getImageRegistry());
      	//启动debug服务
		DebugServer.start();
    	//初始化窗口
  		Builder.Instance.initWindows();
        Builder.Instance.initWorkbench(configurer);
        //添加控制台服务
        ObjectPool.INSTANCE.putObject(ConsoleServer.Instance, GlobalServiceId.Console_Service);
      }catch(Throwable e){
        JFaceHelpMethod.showError(e);
        Runtime.getRuntime().exit(0);
      }
    }
	public String getInitialWindowPerspectiveId() {
		return Perspective.ID;
	}
}
