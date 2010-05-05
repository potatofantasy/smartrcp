package smartrcp.platform.dev;

import java.io.PrintStream;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

import cn.smartinvoke.smartrcp.gui.SplashWindow;
import cn.smartinvoke.smartrcp.util.JFaceHelpMethod;
import cn.smartinvoke.util.ConfigerLoader;

public class ApplicationWorkbenchWindowAdvisor extends WorkbenchWindowAdvisor {
	 
	public ApplicationWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
		super(configurer);
	}
	public ActionBarAdvisor createActionBarAdvisor(
			IActionBarConfigurer configurer) {
		return new ApplicationActionBarAdvisor(configurer);
	}
    public void postWindowOpen(){
    	try{
    	final Shell shell=this.getWindowConfigurer().getWindow().getShell();
    	Builder.Instance.postWindowOpen(shell);
    	
    	//启动控制台
//      	String isDebug = ConfigerLoader.getAppArg(DebugManager.Args);
//		if (isDebug != null && isDebug.equals("true")) {
//			new ConsoleServer();
//		}
		
    }catch(Throwable e){
        JFaceHelpMethod.showError(e);
      }
    } 
	public void preWindowOpen(){
	 try{
		IWorkbenchWindowConfigurer configurer = getWindowConfigurer();	
		Builder.Instance.preWindowOpen(this.getWindowConfigurer());
		//开发版本不能隐藏工具条，因为工具条上有debug功能按钮
		String isDebug = ConfigerLoader.getAppArg(DebugManager.Args);
		if (isDebug != null && isDebug.equals("true")) {
		  //configurer.setShowCoolBar(true);
		}
	}catch(Throwable e){
        JFaceHelpMethod.showError(e);
      }
	}
	public boolean preWindowShellClose(){
		boolean preventClose=SplashWindow.getPerspective().windowConfigurer.preventClose;
		return !preventClose;
	}
	public static void main(String[] args) {
		
	}
}
