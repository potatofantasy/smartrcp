package smartrcp.platform;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPreferenceConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

import cn.smartinvoke.smartrcp.core.SmartRCPBuilder;

public class ApplicationWorkbenchWindowAdvisor extends WorkbenchWindowAdvisor {

	public ApplicationWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
		super(configurer);
	}

	public ActionBarAdvisor createActionBarAdvisor(
			IActionBarConfigurer configurer) {
		return new ApplicationActionBarAdvisor(configurer);
	}
    public void postWindowOpen() {
    	final Shell shell=this.getWindowConfigurer().getWindow().getShell();
    	SmartRCPBuilder.Instance.postWindowOpen(shell);
    }
	public void preWindowOpen() {
		IWorkbenchWindowConfigurer configurer = getWindowConfigurer();
		
		configurer.setTitle("RCP Application");
		PlatformUI.getPreferenceStore().setDefault(
		         IWorkbenchPreferenceConstants.ENABLE_ANIMATIONS, true);
		     PlatformUI.getPreferenceStore().setDefault(
		         IWorkbenchPreferenceConstants.SHOW_TRADITIONAL_STYLE_TABS,
		         true);
		     PlatformUI.getPreferenceStore().setDefault(
		         IWorkbenchPreferenceConstants.DOCK_PERSPECTIVE_BAR,
		         IWorkbenchPreferenceConstants.TOP_RIGHT);
		     
		SmartRCPBuilder.Instance.preWindowOpen(this.getWindowConfigurer());
		configurer.setShowPerspectiveBar(true);
		configurer.setShowProgressIndicator(true);
		configurer.setShowStatusLine(true);
	}
}
