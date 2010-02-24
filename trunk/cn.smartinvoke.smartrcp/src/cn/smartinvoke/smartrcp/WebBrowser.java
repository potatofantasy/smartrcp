package cn.smartinvoke.smartrcp;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

public class WebBrowser extends ViewPart {

	public static final String ID = "cn.smartinvoke.smartrcp.WebBrowser"; //$NON-NLS-1$
    private Browser browser;
	/**
	 * Create contents of the view part
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new FillLayout());
		browser=new Browser(container,SWT.NONE);
		//browser.setText(this.getViewSite().getSecondaryId());
		browser.setUrl("http://code.google.com/p/smartrcp/");
		//
		createActions();
		initializeToolBar();
		initializeMenu();
	}
	public void openUrl(String url){
		this.browser.setUrl(url);
	}
	public void setHtml(String html){
		try{
		 html=new String(html.getBytes("gbk"),"utf-8");
		 this.browser.setText(html);
		 
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void setViewTitle(String title){
		this.setPartName(title);
	}
	/**
	 * Create the actions
	 */
	private void createActions() {
		// Create the actions
	}
	/**
	 * Initialize the toolbar
	 */
	private void initializeToolBar() {
		IToolBarManager toolbarManager = getViewSite().getActionBars()
				.getToolBarManager();
	}

	/**
	 * Initialize the menu
	 */
	private void initializeMenu() {
		IMenuManager menuManager = getViewSite().getActionBars()
				.getMenuManager();
	}

	@Override
	public void setFocus() {
		// Set the focus
	}
    public static void main(String[] args) {
    	
	}
}
