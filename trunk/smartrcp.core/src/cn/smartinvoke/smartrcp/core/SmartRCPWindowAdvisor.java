package cn.smartinvoke.smartrcp.core;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;

import cn.smartinvoke.util.ImageManager;

public class SmartRCPWindowAdvisor {
    public Control toolbar,page,statusline;
    
    private Canvas  appSetting=null;
    private IWorkbenchWindowConfigurer configurer;
	public SmartRCPWindowAdvisor() {
		
	}
	/**
	 * 创建窗体
	 * @param shell
	 * @param configurer
	 */
	public void createWindowContents(Shell shell,IWorkbenchWindowConfigurer configurer) {
		 // IWorkbenchWindowConfigurer configurer = getWindowConfigurer();
		  this.configurer=configurer;
		  Menu menu = configurer.createMenuBar();
		  shell.setMenuBar(menu);
		  FormLayout layout = new FormLayout();
		  layout.marginWidth = 0;
		  layout.marginHeight = 0;
		  shell.setLayout(layout);
		  
		  toolbar = configurer.createCoolBarControl(shell);
		  page = configurer.createPageComposite(shell);
		  statusline = configurer.createStatusLineControl(shell);
		  
		  this.appSetting=new Canvas(shell,SWT.NONE);
		  
		  layoutNormal();
	}
	/**
	 * 设置是否显示工具栏
	 * @param visible
	 */
	public void setShowToolbar(boolean visible) {
		  if (visible) {
		    if (toolbar.isVisible())
		      return;
		    FormData data = (FormData) page.getLayoutData();
		    data.top = new FormAttachment(toolbar, 0);
		    page.setLayoutData(data);
		    toolbar.setVisible(true);
		  } else {
		    if (!toolbar.isVisible())
		      return;
		    FormData data = (FormData) page.getLayoutData();
		    data.top = new FormAttachment(0, 0);
		    page.setLayoutData(data);
		    toolbar.setVisible(false);
		  }
		  configurer.getWindow().getShell().layout(true);
	}
	private void layoutNormal() {
		  FormData data = new FormData();
//		  //应用程序管理按钮
//		  //TODO 应用程序管理按钮
//		  data.width=24;data.height=24;
//		  data.left=new FormAttachment(0, 0);
//		  data.top=new FormAttachment(0, 0);
//		  
//		  this.appSetting.setLayoutData(data);
//		  final Image image=
//			  ImageManager.getImageDescriptor("/icons/gear_ok.png").createImage();
//		  this.appSetting.addPaintListener(new PaintListener(){
//
//			public void paintControl(PaintEvent e) {
//				e.gc.drawImage(image, 0, 0);
//			}
//			  
//		  });
//		  
		  
		  //------------
		  data = new FormData();
		  data.top = new FormAttachment(0, 0);
		  data.left = new FormAttachment(0, 0);
		  data.right = new FormAttachment(100, 0);
		  toolbar.setLayoutData(data);
		  // Status line
		  data = new FormData();
		  data.bottom = new FormAttachment(100, 0);
		  data.left = new FormAttachment(0, 0);
		  data.right = new FormAttachment(100, 0);
		  statusline.setLayoutData(data);
		  // page contents
		  data = new FormData();
		  data.top = new FormAttachment(toolbar);
		  data.left = new FormAttachment(0, 0);
		  data.right = new FormAttachment(100, 0);
		  data.bottom = new FormAttachment(statusline);
		  page.setLayoutData(data);
		  configurer.getWindow().getShell().layout(true);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}

}
