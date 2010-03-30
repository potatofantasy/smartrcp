package smartrcp.platform;

import org.eclipse.jface.action.ContributionItem;
import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.StatusLineLayoutData;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

import cn.smartinvoke.smartrcp.core.SmartRCPBuilder;

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
		SmartRCPBuilder.Instance.createActions(this,window);
	}
	protected void fillMenuBar(IMenuManager menuBar) {
		SmartRCPBuilder.Instance.fillMenuBar(menuBar);
	}
	protected void fillCoolBar(ICoolBarManager coolBar) {	
		SmartRCPBuilder.Instance.fillCoolBar(coolBar);
	}
	protected void fillStatusLine(IStatusLineManager statusLine) {
		SmartRCPBuilder.Instance.initStatusLine(statusLine);
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