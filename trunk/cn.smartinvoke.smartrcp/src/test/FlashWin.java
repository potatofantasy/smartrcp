package test;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class FlashWin extends Shell {

	/**
	 * Launch the application
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			FlashWin shell = new FlashWin(display, SWT.SHELL_TRIM);
			shell.open();
			shell.layout();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the shell
	 * @param display
	 * @param style
	 */
	public FlashWin(Display display, int style) {
		super(display, style);
		createContents();
	}

	/**
	 * Create contents of the window
	 */
	protected void createContents() {
		setText("SWT Application");
		setSize(500, 375);
		
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
