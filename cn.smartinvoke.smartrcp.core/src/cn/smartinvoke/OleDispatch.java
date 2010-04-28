package cn.smartinvoke;

import org.eclipse.swt.browser.CloseWindowListener;
import org.eclipse.swt.browser.WindowEvent;
import org.eclipse.swt.widgets.Composite;

 class OleDispatch implements CloseWindowListener {
	public void close(WindowEvent event) {
		((Composite)event.getSource()).getShell().close();
	}
}
