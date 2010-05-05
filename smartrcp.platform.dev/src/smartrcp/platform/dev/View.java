package smartrcp.platform.dev;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

public class View extends ViewPart {
	public static final String ID = "smartrcp.platform.dev.view";

	public void createPartControl(Composite parent) {
		
	}
	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		//PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
	}
}