package smartrcp.platform.dev;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

import cn.smartinvoke.smartrcp.DebugServer;
import cn.smartinvoke.smartrcp.gui.CAppToolBarManager;
import cn.smartinvoke.smartrcp.util.JFaceHelpMethod;
import cn.smartinvoke.util.ConfigerLoader;

/**
 * An action bar advisor is responsible for creating, adding, and disposing of
 * the actions added to a workbench window. Each window will be populated with
 * new actions.
 */
public class ApplicationActionBarAdvisor extends ActionBarAdvisor {

	// Actions - important to allocate these only in makeActions, and then use
	// them
	// in the fill methods. This ensures that the actions aren't recreated
	// when fillActionBars is called with FILL_PROXY.
	
	public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
		super(configurer);
	}
	protected void makeActions(final IWorkbenchWindow window) {
		Builder.Instance.createActions(this,window);
	}
	protected void fillMenuBar(IMenuManager menuBar) {
		Builder.Instance.fillMenuBar(menuBar);
	}
	protected void fillCoolBar(ICoolBarManager coolBar) {
	 try{
		CAppToolBarManager appToolBarManager=Builder.Instance.fillCoolBar(coolBar);
		String isDebug = ConfigerLoader.getAppArg(DebugManager.Args);
		if (isDebug != null && isDebug.equals("true")) {
			
		}
		}catch(Throwable e){
	          JFaceHelpMethod.showError(e);
	        }
		
	}
	protected void fillStatusLine(IStatusLineManager statusLine) {
		Builder.Instance.initStatusLine(statusLine);
	}
}
/*protected void fillStatusLine(IStatusLineManager statusLine) {
	  statusLine.add();
}
class PlatformContribution extends ContributionItem{
	private CLabel label;
	private Image image;private String text;
	
	public PlatformContribution(Image image, String text) {
		super();
		this.image = image;
		this.text = text;
	}

	public void fill(Composite parent) {
		  Label separator = new Label(parent, SWT.SEPARATOR);
		  label = new CLabel(parent, SWT.SHADOW_NONE);

		  GC gc = new GC(parent);
		  gc.setFont(parent.getFont());
		  FontMetrics fm = gc.getFontMetrics();
		  Point extent = gc.textExtent(text);
		  if (widthHint > 0)
		    widthHint = fm.getAverageCharWidth() * widthHint;
		  else
		    widthHint = extent.x;
		  heightHint = fm.getHeight();
		  gc.dispose();

		  StatusLineLayoutData statusLineLayoutData = new StatusLineLayoutData();
		  statusLineLayoutData.widthHint = widthHint;
		  statusLineLayoutData.heightHint = heightHint;
		  label.setLayoutData(statusLineLayoutData);
		  label.setText(text);
		  label.setImage(image);
		}
};*/