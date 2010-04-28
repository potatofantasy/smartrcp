
package cn.smartinvoke.smartrcp.gui;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Shell;

import cn.smartinvoke.IServerObject;
import cn.smartinvoke.gui.FlashViewer;
import cn.smartinvoke.smartrcp.gui.module.CEventBean;
import cn.smartinvoke.smartrcp.gui.module.FlashShellListener;
import cn.smartinvoke.smartrcp.util.UIHelpMethod;
import cn.smartinvoke.util.ImageManager;
import cn.smartinvoke.util.Log;

public class FlashShell implements IServerObject{
	private Shell shell = null;
	private FlashViewer flashViewer;
	private boolean isDebug=false;
	public FlashShell(boolean isDebug) {
	   this.isDebug=isDebug;
       this.shell=new Shell();
       this.init();
	}
	public FlashShell(boolean isDebug,int style) {
		   this.isDebug=isDebug;
	       this.shell=new Shell(style);
	       this.init();
    }
	public FlashShell() {
	       this.shell=new Shell();
	       this.init();
	}
	public FlashShell(int style) {
	    this.shell=new Shell(style);
	    this.init();
	}
	public FlashShell(Shell shell) {
	  // if(shell!=null){
	    this.shell=shell;
	    this.init();
	   //}
	}
	public FlashShell(Shell shell,int style) {
	    this.shell=new Shell(shell,style);
	    this.init();
	}
	public void createFlashContainer(String appPath){
	   if(appPath!=null){
		this.createFlashContainer(appPath, null);
	   }
	}
	public FlashViewer getFlashViewer(){
		return this.flashViewer;
	}
	/**
	 * 创建flash容器
	 * @param isModule
	 * @param swfPath
	 */
	public void createFlashContainer(String appPath,String modulePath){
		//--------创建FlashContainer
		if(appPath!=null){
		 this.shell.setLayout(new FillLayout());
		 int appId=FlashViewer.getViewNum();
		 if(modulePath!=null){
		   String[] paths = new String[] {appPath,UIHelpMethod.getFullPath(modulePath) };
		   flashViewer=new FlashViewer(appId+"",this.shell,paths);
		 }else{
		   String fullPath=null;
		   //如果是debug程序传入的参数
//		   if(new File(appPath).exists()){
//			   fullPath=appPath;
//		   }else{
//			   fullPath=CPerspective.getRuntimeSwfFolder() + "/" + appPath;
//		   }
		   flashViewer=new FlashViewer(appId+"",this.shell,appPath); 
		 }
		 flashViewer.setParent(this);
		 //将当前打开的窗口的信息添加进模块对应表中	
		// SplashWindow.getPerspective().
		// page.addViewPartInfo(flashViewer.getModulePath(), flashViewer.getAppId());
		 
		 flashViewer.debugModule=this.isDebug;//是否为debug模式
		}else{
			throw new RuntimeException("swfPath can not be null");
		}
	}
    
	public void open() {
		flashViewer.loadFlash();
		this.shell.open();
		
	}

	private void init(){
		for(int i=0;i<listeners.length;i++){
			listeners[i]=new LinkedList<CEventBean>();
		}
		
        this.shell.addDisposeListener(new DisposeListener() {
		    
			public void widgetDisposed(DisposeEvent e) {
			   if(flashViewer!=null){
				 
				 //从PageLayout的appId模块对应表中删除该part的信息
					//SplashWindow.getPerspective().
					//page.removeViewPartInfo(flashViewer.getModulePath(), flashViewer.getAppId());
				 flashViewer.dispose();
			   }
			}
		});
        FlashShellListener flashShellListener=new FlashShellListener(this);
        
		this.shell.addShellListener(flashShellListener);
		
		
	}
	//---------------------事件监听器
	
	public List<CEventBean>[] listeners=new List[5];
	public void addShellListener(int type,CEventBean listener) {
		try{
		   if(listener!=null){
			   List<CEventBean> typeListeners=this.listeners[type];
			   if(!typeListeners.contains(listener)){
				   typeListeners.add(listener);
			   }
		   }
		}catch(Throwable e){};
	}
	public void removeShellListener(int type,CEventBean listener) {
		try{
			   if(listener!=null){
				   List<CEventBean> typeListeners=this.listeners[type];
				   if(typeListeners.contains(listener)){
					  typeListeners.remove(listener);
				   }
			   }
			}catch(Throwable e){};
	}
	//----------------------------
	public void dispose() {
		 if(this.flashViewer!=null){
		  this.flashViewer.dispose();
		 }
		 this.shell.dispose();
		//Log.println("in flashShell dispose");
		//this.flashViewer.dispose();
		//this.shell.dispose();
	}
	public boolean getEnabled() {
		return this.shell.getEnabled();
	}
	public void setVisible(boolean visible) {
		this.shell.setVisible(visible);
	}

	public void setMinimumSize(int width, int height) {
		this.shell.setMinimumSize(width, height);
	}

	public boolean isEnabled() {
		return this.shell.isEnabled();
	}

	public void close() {
	   this.clearListeners();//清空所有监听器
	   try{
		if(flashViewer!=null){
		 //调用对应flex程序回收资源
		 flashViewer.flexAppExist();
		 flashViewer.dispose();
		}
		this.shell.setMinimized(true);//将窗口设到最小化回收内存
		this.shell.close();
		this.shell.dispose();
		//ObjectPool.INSTANCE.removeObject(this.flashViewer.getAppId(), objId);
	   }catch(Throwable e){
		   //e.printStackTrace();
	   }
	}
	/**
	 * 清空所有监听器
	 */
	private void clearListeners(){
		for(int n=0;n<this.listeners.length;n++){
			this.listeners[n].clear();
		}
	}
	public Object getLocation() {
		Point point = this.shell.getLocation();
		return point;
	}
	public boolean isVisible() {
		return this.shell.isVisible();
	}
	public void forceActive() {
		this.shell.forceActive();
	}
	public Object getBounds() {
		Rectangle rectangle = this.shell.getBounds();
		return rectangle;
	}
	public void setBounds(int x, int y, int width, int height) {
		this.shell.setBounds(x, y, width, height);
	}
	public void setEnabled(boolean enabled) {
		this.shell.setEnabled(enabled);
	}
	public void setActive() {
		this.shell.setActive();
	}
	public Object getMinimumSize() {
		return this.shell.getMinimumSize();
	}
	public Object getSize() {
		return this.shell.getSize();
	}
	public void setSize(int w, int h) {
		this.shell.setSize(new Point(w, h));
	}

	public void setText(String text) {
		this.shell.setText(text);
	}

	public void setImage(String img) {
         ImageDescriptor descriptor=ImageManager.getImageDescriptor(img);
         if(descriptor!=null){
        	 this.shell.setImage(descriptor.createImage());
         }
	}

	public String getText() {
		return this.shell.getText();
	}

	public void setToolTipText(String text) {
		this.shell.setToolTipText(text);
	}

	public String getToolTipText() {
		return this.shell.getToolTipText();
	}

	public Shell getShell() {
		return this.shell;
	}
    public String getType(){
    	return "FlashShell";
    }
    protected void finalize() throws Throwable {
    	super.finalize();
    	Log.println("flashShell finalize...");
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//DisposeListener
		// Shell shell=null;
		// shell.setActive();
		// shell.setBounds(x, y, width, height);
		// shell.setCapture(capture);
		// shell.setFocus();
		// shell.setImage(image);
		// shell.setEnabled(enabled)
		// shell.setLocation(x, y);
		// shell.setMaximized(maximized);
		// shell.setMinimized(minimized);
		// shell.setMinimumSize(width, height);
		// shell.setSize(width, height);
		// shell.setText(string);
		// shell.setToolTipText(string);
		// shell.setVisible(visible);
		//		
		// shell.getBounds();
		// shell.getEnabled();
		// shell.getLocation();
		// shell.getMaximized();
		// shell.getMinimized();
		// shell.getMinimumSize();
		// shell.getMonitor();
		// shell.getText();
		// shell.getToolTipText();
		int[] arr=new int[]{
				99,46,65,35,31,24,96,75,33};
		int sum=0;
		for(int n=0;n<arr.length;n++){
			sum+=arr[n];
		}
		System.out.println(sum);
	}

}
