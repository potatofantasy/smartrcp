package cn.smartinvoke.smartrcp.core;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.events.ShellListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import cn.smartinvoke.IServerObject;
import cn.smartinvoke.smartrcp.gui.module.CEventBean;
import cn.smartinvoke.util.ImageManager;

public class FlashShell implements IServerObject{
	private Shell shell = null;
	public FlashShell(){
		for(int i=0;i<listeners.length;i++){
			listeners[i]=new LinkedList<CEventBean>();
		}
		// TODO Ìí¼Ó´°¿Ú¼àÌýÆ÷
		this.shell.addShellListener(new ShellListener() {

			public void shellActivated(ShellEvent e) {
				
			}

			public void shellClosed(ShellEvent e) {
				
			}

			public void shellDeactivated(ShellEvent e) {
				
			}

			public void shellDeiconified(ShellEvent e) {
				
			}

			public void shellIconified(ShellEvent e) {
				
			}
            private boolean fireEvent(CEventBean eventBean){
            	
            	return false;
            }
		});
	}
	public FlashShell(Display display) {
       this.shell=new Shell(display);
	}
	public FlashShell(Display display,int style) {
	    this.shell=new Shell(display,style);
	}
	public FlashShell(Shell shell) {
	    this.shell=new Shell(shell);
	}
	public FlashShell(Shell shell,int style) {
	    this.shell=new Shell(shell,style);
	}
	//---------------------ÊÂ¼þ¼àÌýÆ÷
	private List<CEventBean>[] listeners=new List[5];
	public void addShellListener(final CEventBean listener) {
		
	}
	public void removeShellListener(CEventBean listener) {
          
	}
	//----------------------------
	public void dispose() {
		this.shell.dispose();
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
		this.shell.close();
	}

	public Object getLocation() {

		Point point = this.shell.getLocation();
		return point;
	}

	public void open() {
		this.shell.open();
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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
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
	}

}
