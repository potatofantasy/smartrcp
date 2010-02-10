package cn.smartinvoke.smartrcp.gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;
import cn.smartinvoke.gui.FlashContainer;
import cn.smartinvoke.gui.Msg;
import cn.smartinvoke.gui.ObjectPool;
import cn.smartinvoke.gui.OleHookInterceptor;
import cn.smartinvoke.gui.Win32Constant;
import cn.smartinvoke.rcp.CPerspective;
import cn.smartinvoke.smartrcp.gui.control.GlobalServiceId;

public class SplashWindow {
	public static SplashWindow INSTANCE=new SplashWindow();
    private Shell shell;
    public FlashContainer container;
    private Display display;
    Thread thread;
	public SplashWindow(){
	   	 //FileDialog
	}
    public boolean open(){
    	 display=Display.getCurrent();
    	 
   	     shell = new Shell(display,SWT.NO_TRIM | SWT.TOOL);// SWT.NO_TRIM | SWT.TOO
		 shell.setLayout(new FillLayout());
		 
	     int[] size=CPerspective.getSplashSize();
		 shell.setSize(size[0],size[1]);
		 
		 Composite composite=new Composite(shell,SWT.NONE);
		 composite.setLayout(new FillLayout());
		 container=new FlashContainer(composite,"splash");
		 
		 container.addHookInterceptor(new OleHookInterceptor(){

			public boolean intercept(Msg message, int code, int param,
					int param2) {
				if (message.getMessage() == Win32Constant.WM_RBUTTONDOWN) {
					Point cursor = container.getParent().toControl(
							Display.getCurrent().getCursorLocation());
					if (container.getBounds().contains(cursor) && container.isVisible()) {
						return true;
					}
				}
				return false;
			}
			 
		 });
		 
		 container.loadMovie(0, CPerspective.getSplashSwfPath());
		 
		 Monitor primary = shell.getMonitor();
	       Rectangle bounds = primary.getBounds ();
	       Rectangle rect = shell.getBounds ();
	       int x = bounds.x + (bounds.width - rect.width) / 2;
	       int y = bounds.y + (bounds.height - rect.height) / 2;
	       if (x < 0)
	           x = 0;
	       if (y < 0)
	           y = 0;
	     shell.setLocation (x, y); 
	     
		 shell.open();
		 
		 while (!shell.isDisposed()) {
		      if (!display.readAndDispatch()) {
		        display.sleep();
		      }
		 }
		 return true;
   }
   private static CPerspective perspective=null;
   public static CPerspective getPerspective(){
	   return perspective;
   }
   public void setPerspective(CPerspective perspective){
	   SplashWindow.perspective=perspective;
   }
   public void close(){
	  //从池中删除对splash窗口的引用 
	  ObjectPool.INSTANCE.removeObject(GlobalServiceId.Splash_Win);
	  container.loadMovie(0, "");
      if(shell!=null){
    	container.dispose();
    	shell.close();
      }
   }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}

}
