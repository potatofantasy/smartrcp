package smartrcp.platform.views;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.BrowserFunction;
import org.eclipse.swt.browser.LocationEvent;
import org.eclipse.swt.browser.LocationListener;
import org.eclipse.swt.browser.OpenWindowListener;
import org.eclipse.swt.browser.ProgressEvent;
import org.eclipse.swt.browser.ProgressListener;
import org.eclipse.swt.browser.StatusTextEvent;
import org.eclipse.swt.browser.StatusTextListener;
import org.eclipse.swt.browser.TitleEvent;
import org.eclipse.swt.browser.TitleListener;
import org.eclipse.swt.browser.WindowEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;

import cn.smartinvoke.smartrcp.app.download.http.SiteFileFetch;
import cn.smartinvoke.smartrcp.app.download.http.SiteInfoBean;
import cn.smartinvoke.smartrcp.app.pack.AppPackService;

import smartrcp.platform.ApplicationWorkbenchAdvisor;

/**
 * 软件下载视图
 * @author pengzhen
 *
 */
public class AppBrowserView extends ViewPart {
	public static final String ID="smartrcp.platform.views.AppBrowserView";
	/**
	 * 已使用的id与Url映射表
	 */
	private static Map<Integer,String> usedIdUrlMap=new HashMap<Integer,String>();
	/** 返回一随机的并且唯一的appId
	 * 
	 * @return
	 */
	public static synchronized int getViewNum(String url) {
		Integer num=-1;
		if(url==null){
			throw new RuntimeException("url can not be null in this method");
		}
		//循环访问Id随机生成器，直到获得一个未使用的Id为止
		while(true){
			num=getRandomNum();
			if(usedIdUrlMap.get(num)==null){
				break;
			}
		}
		
		usedIdUrlMap.put(num, url);
		return num;
	}
    private static int getRandomNum(){
    	double val=Math.random()*Integer.MAX_VALUE;
    	return (int)val;
    }
    /**
     * 当前浏览的路径
     */
	private String curUrl="http://www.javaeye.com";
	private Browser browser;
	private BrowserInitial browserInitial;
	public AppBrowserView() {
	  	
	}
	@Override
	public void createPartControl(Composite parent) {
		    
		    curUrl =usedIdUrlMap.get(getSecondId());
		    
	     	Composite container=new Composite(parent, SWT.NONE);
	     	container.setLayout(new FillLayout());
	     	this.browser=new Browser(container,SWT.NONE);
	        //添加监听器
	     	browserInitial=new BrowserInitial(this);
	     	
	     	if(this.curUrl!=null){
	     		this.browser.setUrl(curUrl);
	     		this.setCurUrl(curUrl);
	     	}
	     	
	}
	public String getCurUrl() {
		return curUrl;
	}
	public void setCurUrl(String curUrl) {
		this.curUrl = curUrl;
		
	}
	
	private Integer getSecondId(){
		String secondId=this.getViewSite().getSecondaryId();
		return Integer.valueOf(secondId);
	}
	
	public Browser getBrowser() {
		return browser;
	}
    public void setPartTitle(String title){
    	super.setPartName(title);
    }
    public String getPartTitle(){
    	return super.getPartName();
    }
	@Override
	public void setFocus() {
	   	
	}
	private static String KEY_URL="key_url";
	public void init(IViewSite site, IMemento memento) throws PartInitException {
		super.init(site, memento);
		if(memento!=null){
		 curUrl=memento.getString(KEY_URL);
		}
	}
	public void saveState(IMemento memento) {  
	   if(this.curUrl!=null){
		   memento.putString(KEY_URL, curUrl);
	   }
	}

}
class BrowserInitial{
	private AppBrowserView appBrowserView;
	private Browser browser;
	public BrowserInitial(AppBrowserView appBrowserView){
		this.appBrowserView=appBrowserView;
		this.browser=appBrowserView.getBrowser();
		addListeners();
	}
	private void addListeners(){
    	this.browser.addTitleListener(new TitleListener() {
			@Override
			public void changed(TitleEvent event){
				appBrowserView.setPartTitle(event.title);
			}
		});
    	
    	browser.addOpenWindowListener(new OpenWindowListener() {
    	      public void open(WindowEvent event) {
    	    	String secondaryId=AppBrowserView.getViewNum("about:blank")+"";
    	    	try{
    	    	 IWorkbenchPage page=ApplicationWorkbenchAdvisor.workbench.getActiveWorkbenchWindow().getActivePage();
    	         IWorkbenchPart part=page.showView(AppBrowserView.ID, secondaryId,IWorkbenchPage.VIEW_ACTIVATE);
    	         AppBrowserView browserViewPart=(AppBrowserView)part;
    	         event.browser =browserViewPart.getBrowser();
    	    	}catch(Exception e){
    	    		e.printStackTrace();
    	    	}
    	      }
    	});
    	browser.addProgressListener(new ProgressListener() {
    	      public void changed(ProgressEvent event) {
    	        //System.out.println("total:"+event.total+" cur:"+event.current);
    	        if((event.total==event.current)&&(event.total==0)){
    	        	addFunctions();
    	        }
    	      }
    	      public void completed(ProgressEvent event) {
    	        //System.out.println("completed...");
    	      }
    	    });
    }
	private BrowserFunction downloadFun;
	private void addFunctions(){
		if(downloadFun!=null){
			downloadFun.dispose();
		}
		this.downloadFun=new DownloadFun(this.browser,"rcpAppDownload");
	}
}
class DownloadFun extends BrowserFunction{

	public DownloadFun(Browser browser, String name) {
		super(browser, name);
	}
	public Object function(Object[] args){
		if (args != null && args.length > 0) {
			final String downloadUrl=args[0].toString();
			//解析下载文件名称
			new AppPackService().downloadAppFromUrl(downloadUrl);
			
		}
		return null;
	}
}
