package test;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Decorations;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;

import cn.smartinvoke.smartrcp.Activator;

public class ContextMenuTest extends Shell {

	/**
	 * Launch the application
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			
			ContextMenuTest shell = new ContextMenuTest(display, SWT.SHELL_TRIM);
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
	public ContextMenuTest(Display display, int style) {
		super(display, style);
		createContents();
		addMouseListener(new MouseAdapter() {
			public void mouseDown(final MouseEvent e) {
				if(e.button==3){
				  Point point=ContextMenuTest.this.toDisplay(e.x, e.y);
				     menu.setLocation(point.x, point.y);
					menu.setVisible(true);
					
				}
				if(e.button==2){
					  Point point=ContextMenuTest.this.toDisplay(e.x, e.y);
						menu.setLocation(point.x, point.y);
						menu.setVisible(true);
						getAction();
				}
			}
		});
	}
Menu menu;
MenuManager manager;
MenuManager subMenu;
IAction subAction;
	/**
	 * Create contents of the window
	 */
	protected void createContents() {
		setText("SWT Application");
		setSize(500, 375);
		//
		 manager=new MenuManager();
		Action action=new Action("hello"){
			public void run(){
				
			}
		};
		action.setId("id1");
		manager.add(action);
		
		
		
		subMenu=new MenuManager("sub","sub1");
		 
		subAction=new Action("sub1"){
			
		};
		subAction.setId("sub1");
		subMenu.add(subAction);
		manager.add(subMenu);
		
		menu=manager.createContextMenu(this);

		final Button button = new Button(this, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e){
				subAction.setText(System.currentTimeMillis()+"");
				subAction.setImageDescriptor(Activator.getImageDescriptor("/icons/sample2.gif"));
				//subMenu.update();
			}
		});
		button.setText("button");
		button.setBounds(120, 105, 48, 22);
	}
    private void add(){
    	Action action=new Action("hello2"){
			public void run(){
				
			}
		};
		manager.add(action);
		manager.update();
    }
    private void delete(){
    	manager.remove("id1");
    	manager.update();
    	this.setMenuBar(menu);
    	
    }
    private void getAction(){
    	
    	
    }
	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
