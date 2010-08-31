package cn.smartinvoke.smartrcp.gui.browser;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.ProgressEvent;
import org.eclipse.swt.browser.ProgressListener;
import org.eclipse.swt.browser.TitleEvent;
import org.eclipse.swt.browser.TitleListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

import cn.smartinvoke.IServerObject;
import cn.smartinvoke.rcp.CLayoutBasicInfo;
import cn.smartinvoke.smartrcp.core.SmartRCPViewPart;
import cn.smartinvoke.smartrcp.gui.module.CEventBean;
import cn.smartinvoke.util.ImageManager;
import cn.smartinvoke.util.Log;

public class WebBrowser extends SmartRCPViewPart implements IServerObject {
	public static final String ID = "cn.smartinvoke.smartrcp.WebBrowser"; 
	 public Browser browser;
		private List<CEventBean> listeners=new LinkedList<CEventBean>();
	    @Override
		public void createPartControl(Composite parent) {
			super.createPartControl(parent);
			Composite container = new Composite(parent, SWT.NONE);
			container.setLayout(new FillLayout());
			browser=new Browser(container,SWT.NONE);
			
			CLayoutBasicInfo basicInfo=this.getLayoutInfo();
			
			if(basicInfo!=null){
				String url=basicInfo.modulePath;
				if(url.charAt(0)=='*'){
					String temp=url.substring(1).toLowerCase();
					if(temp.startsWith("http://") || temp.startsWith("www.")){
					   browser.setUrl(url.substring(1));
					}
				}
				this.setViewTitle(basicInfo.title);
				// 设置图标
				if (basicInfo.image != null) {
					ImageDescriptor imageDescriptor = ImageManager
							.getImageDescriptor(basicInfo.image);
					if (imageDescriptor != null) {
						this.setTitleImage(imageDescriptor.createImage());
					}
				}
				
			}
			
			//添加事件
			browser.addTitleListener(new TitleListener() {
				//@Override
				public void changed(TitleEvent event){
					 WebBrowser.this.setViewTitle(event.title);
				}
			});
            browser.addProgressListener(new ProgressListener() {
				
				//@Override
				public void completed(ProgressEvent event){
					boolean ret=browser.execute("document.getElementsByTagName('body')[0].style.overflow='auto'");
					for(int i=0;i<listeners.size();i++){
						CEventBean eventBean=listeners.get(i);
						try{
						 eventBean.fireOnetimeEvent(null);
						}catch(Exception e){
							e.printStackTrace();
						}
					}
				}
				
				//@Override
				public void changed(ProgressEvent event) {
				       
				}
			});
			createActions();
			initializeToolBar();
			initializeMenu();
		}
	    /**
	     * 添加flex监听器，当页面加载完毕后调用该监听器集合
	     * @param eventBean
	     */
	    public void addCompleteListener(CEventBean eventBean){
	      	if(eventBean!=null){
	      		listeners.add(eventBean);
	      	}
	    }
	    /**
	     * 在当前页面上执行传入的js脚本
	     * @param code
	     * @return
	     */
	    public boolean execute(String code){
	    	return this.browser.execute(code);
	    }
		
		public void openUrl(String url){
			this.browser.setUrl(url);
		}
		public void setHtml(String html){
			this.browser.setText(html);
		}
		public void dispose(){
			super.dispose();
		}
		public void setViewTitle(String title){
			this.setPartName(title);
		}
		/**
		 * Create the actions
		 */
		private void createActions() {
			
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
			
		}
		

}
