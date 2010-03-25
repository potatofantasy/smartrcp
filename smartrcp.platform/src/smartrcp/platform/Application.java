package smartrcp.platform;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

/**
 * This class controls all aspects of the application's execution
 */
public class Application implements IApplication {
   public static Display display=null;
	/* (non-Javadoc)
	 * @see org.eclipse.equinox.app.IApplication#start(org.eclipse.equinox.app.IApplicationContext)
	 */
	public Object start(IApplicationContext context) {
		Display display = PlatformUI.createDisplay();
		Application.display=display;
		try {
			int returnCode = PlatformUI.createAndRunWorkbench(display, new ApplicationWorkbenchAdvisor());
			if (returnCode == PlatformUI.RETURN_RESTART) {
				return IApplication.EXIT_RESTART;
			}
			return IApplication.EXIT_OK;
		} finally {
			display.dispose();
		}
	}
    
	/* (non-Javadoc)
	 * @see org.eclipse.equinox.app.IApplication#stop()
	 */
	public void stop() {
		final IWorkbench workbench = PlatformUI.getWorkbench();
		if (workbench == null)
			return;
		final Display display = workbench.getDisplay();
		display.syncExec(new Runnable() {
			public void run() {
				if (!display.isDisposed())
					workbench.close();
			}
		});
	}
	
	public static void openError(final String info){
		if(Display.getCurrent()==null){
			Application.display.asyncExec(new Runnable() {
				
				@Override
				public void run() {
					Shell shell=Application.display.getActiveShell();
					MessageDialog.openError(shell, "¥ÌŒÛ", info);
				}
			});
		}
	}
	public static void openInfo(final String info){
		if(Display.getCurrent()==null){
			Application.display.asyncExec(new Runnable() {
				
				@Override
				public void run() {
					Shell shell=Application.display.getActiveShell();
					MessageDialog.openInformation(shell, "–≈œ¢", info);
				}
			});
		}
	}
}
