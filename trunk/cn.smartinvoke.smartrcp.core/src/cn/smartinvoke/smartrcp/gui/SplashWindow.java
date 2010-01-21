package cn.smartinvoke.smartrcp.gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;
import cn.smartinvoke.gui.FlashContainer;
import cn.smartinvoke.gui.ObjectPool;
import cn.smartinvoke.rcp.CPerspective;
import cn.smartinvoke.smartrcp.gui.control.GlobalServiceId;

public class SplashWindow {
	public static SplashWindow INSTANCE=new SplashWindow();
    private Shell shell;
    public FlashContainer container;
    private Display display;
    Thread thread;
	private SplashWindow(){
	   	 
	}
    public void open(){
    	 display=new Display();
    	 
   	     shell = new Shell(display,SWT.NO_TRIM | SWT.TOOL);// SWT.NO_TRIM | SWT.TOO
		 shell.setLayout(new FillLayout());
		 
	     int[] size=CPerspective.getSplashSize();
		 shell.setSize(size[0],size[1]);
		 
		 Composite composite=new Composite(shell,SWT.NONE);
		 composite.setLayout(new FillLayout());
		 container=new FlashContainer(composite);
//		 container.addListener(new ILoadCompleteListener(){
//			public void run() {
//				RemoteObject fAppObj=new RemoteObject(container);
//				fAppObj.setRemoteId("app");
//				Object ret=fAppObj.call("getPerspective", null);
//				if(ret!=null){
//					if(ret instanceof CPerspective){
//					 cPerspective=(CPerspective)ret;
//					}
//				}
//				fAppWin.close();
//			}
//		 });
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
