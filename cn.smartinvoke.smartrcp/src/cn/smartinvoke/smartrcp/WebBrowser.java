package cn.smartinvoke.smartrcp;

import java.io.BufferedWriter;
import java.io.FileInputStream;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

import cn.smartinvoke.rcp.CPerspective;
import cn.smartinvoke.smartrcp.core.SmartRCPViewPart;

public class WebBrowser extends SmartRCPViewPart {

	public static final String ID = "cn.smartinvoke.smartrcp.WebBrowser"; //$NON-NLS-1$
    private Browser browser;
	/**
	 * Create contents of the view part
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);
		
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new FillLayout());
		browser=new Browser(container,SWT.NONE);
		super.setPartName("ä¯ÀÀÆ÷");
		createActions();
		initializeToolBar();
		initializeMenu();
	}
	public void dispose(){
		super.dispose();
	}
	public void openUrl(String url){
		super.setPartName("ä¯ÀÀÆ÷");
		this.browser.setUrl(url);
	}
	public void setHtml(String html){
		this.browser.setText(html);
	}
	private String dispUrl=null;
	public void showSourceCode(String modulePath){
		FileInputStream in=null;
		java.io.FileOutputStream writerStream =null;
		try{
		 String savePath=CPerspective.getRuntimeSwfFolder()+"/syn.xml";
		 if(dispUrl!=null && savePath.equals(dispUrl)){//ÒÑ¾­ÏÔÊ¾
			 return;
		 }
		 String name=modulePath.substring(modulePath.lastIndexOf('/')+1);
		 super.setPartName(name+"Ô´´úÂë");
		 String codePath=modulePath;
		 in=new FileInputStream(codePath);
		 byte[] bts=new byte[in.available()];
		 in.read(bts);
		 String code=new String(bts,"utf-8");
		 writerStream = new java.io.FileOutputStream(savePath);   
		 BufferedWriter writer = new BufferedWriter(new java.io.OutputStreamWriter(writerStream, "UTF-8"));
		 writer.write(code);
		 writer.flush();
		 writer.close();
		 this.browser.setUrl(savePath);
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}finally{
			if(in!=null){
				try{in.close();}catch (Exception e) {}
			}
			if(writerStream!=null){
				try{writerStream.close();}catch (Exception e) {}
			}
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
	static String sourceCodeHeader=
				"<html><head><title></title>"+
	"  <script type=text/javascript src=syntax/shCore.js></script>"+
	"  <script type=text/javascript src=syntax/shBrushJava.js></script>"+
	"  <script type=text/javascript src=syntax/shBrushCSharp.js></script>"+
	"  <script type=text/javascript src=syntax/shBrushXml.js></script>"+
	"  <link rel=stylesheet type=text/css href=syntax/SyntaxHighlighter.css>"+
	"  <script type=text/javascript>"+
	"  window.onload = function () {"+
	"dp.SyntaxHighlighter.ClipboardSwf = 'syntax/clipboard.swf';"+
	"dp.SyntaxHighlighter.HighlightAll('code');"+
	"} "+
	"</script></head>"+
	"<body style=padding-top: 0px;padding-left: 0px;margin-top: 0px;>"+
	"<textarea name=code class=xml>";
    public static void main(String[] args) {
    	
	}
}
