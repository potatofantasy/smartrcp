package test;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Decorations;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;

public class MenuBarTest extends Shell {

	/**
	 * Launch the application
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			MenuBarTest shell = new MenuBarTest(display, SWT.SHELL_TRIM);
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
	public MenuBarTest(Display display, int style) {
		super(display, style);
		createContents();
	}
    private Menu menu;
    private MenuManager menuManager;
    MenuManager fileMenuBar;
	/**
	 * Create contents of the window
	 */
	protected void createContents() {
		setText("SWT Application");
		setSize(500, 375);
		menuManager=new MenuManager();
		
		
		
		fileMenuBar=new MenuManager("文件","file");
		fileMenuBar.add(new Action("open"){	
		});
		
		menuManager.add(fileMenuBar);
		addMenuBar();
		final Button button = new Button(this, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				fileMenuBar.add(new Action("save"){	
		        });
			}
		});
		button.setText("添加");
		button.setBounds(155, 101, 48, 22);

		final Button button_1 = new Button(this, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
			   IContributionItem item=menuManager.findUsingPath("file");
			   menuManager.remove(item);
			   menuManager.update();
			}
		});
		button_1.setText("隐藏");
		button_1.setBounds(70, 159, 48, 22);

		final Button button_2 = new Button(this, SWT.NONE);
		button_2.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				fileMenuBar.setVisible(true);
			}
		});
		button_2.setText("显示");
		button_2.setBounds(181, 159, 48, 22);
		
		//
	}
    private void addMenuBar( ){
      if(this.menu!=null){
    	  this.menu.dispose();
      }
	  this.menu=menuManager.createMenuBar((Decorations)this);
	  this.setMenuBar(menu);
    }
	@Override
	protected void checkSubclass() {
		
	}

}
