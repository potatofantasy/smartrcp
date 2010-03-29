package tests;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.internal.win32.OS;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

import cn.smartinvoke.RemoteObject;
import cn.smartinvoke.TypeMapper;
import cn.smartinvoke.gui.FlashContainer;
import cn.smartinvoke.gui.ILoadCompleteListener;
import cn.smartinvoke.gui.Msg;
import cn.smartinvoke.gui.OleHookInterceptor;
import cn.smartinvoke.gui.Win32Constant;
public class DemoFirst extends Shell {

	/**
	 * Launch the application
	 * @param args
	 */
	static Display Display;
	public static void main(String args[]) {
		try {
			
			Display display = Display.getDefault();
			Display=display;
			DemoFirst shell = new DemoFirst(display, SWT.SHELL_TRIM);
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
	public DemoFirst(Display display, int style) {
		super(display, style);
		createContents();
		setLayout(new FillLayout());
	}
	FlashContainer flashContainer;
	/**
	 * Create contents of the window
	 */
	protected void createContents() {
		setText("smartinvoke测试程序");
		//将flash控件添加到窗体
		String appId="first";
		this.flashContainer=new FlashContainer(this,appId);
		//添加消息钩子
		this.flashContainer.addHookInterceptor(new OleHookInterceptor(){
			/**如果此方法返回false表示不过滤此消息。返回true表示消息被过滤掉了，那么
			 *flashPlayer就接收不到相应的消息事件，也就实现了屏蔽系统右键菜单与自定义
			 *键盘事件的目的
			 */
			public boolean intercept(Msg message, int code, int wParam,
					int lParam) {
				int msg=message.getMessage();
				
				if (msg== Win32Constant.WM_RBUTTONDOWN) {//系统右键消息
					
					Point cursor = flashContainer.getParent().toControl(
							Display.getCurrent().getCursorLocation());
					//如果当前鼠标在flashPlayer窗口中
					if (flashContainer.getBounds().contains(cursor) && flashContainer.isVisible()) {
						//显示一消息对话框
						MessageBox messageBox = new MessageBox(flashContainer
								.getShell());
						messageBox.setMessage("您单机了右键");
						messageBox.open();
						return true;//返回true就屏蔽了flashPlayer的系统右键
					}
					
				}
				if(msg==Win32Constant.WM_KEYDOWN){//键盘按键按下事件
					if(message.getWParam()==Win32Constant.VK_RETURN){
						System.out.println("按下回车");
					}
				}
				//以下的代码可以捕获到键盘组合键
				if((OS.GetKeyState(Win32Constant.VK_CONTROL)<0)&&(OS.GetKeyState(Win32Constant.VK_DELETE)<0)&&(message.getWParam()   ==   'Z')){
					System.out.println("control DELETE and Z...........");
				}
				return false;
			}
		});
		
		/**
		 *当flash加载完毕后，FlashContainer会调用ILoadCompleteListener
		 *的run方法，你可以在这里做一些初始化
		 */
		flashContainer.addListener(new ILoadCompleteListener(){
			public void run() {
				
				runBackagoundTask();
			}	
		});
		TypeMapper.addServiceConfig("test");
		
		//加载smartinvoke.mxml编译生成的smartinvoke.swf
		//String path="E:/flexWork/SmartRCPDemo/bin-debug/NativeFileLoader.swf";
		//flashContainer.loadMovie(0,path);
		String path="E:/flexWork/cn.smartinvoke.smartrcp-flex/bin-debug/PlatformManager.swf";
		flashContainer.loadMovie(0, path);
		setSize(500, 375);
		
		//
	}
    private void runBackagoundTask(){
    	//启动多个后台执行线程
    	for(int i=0;i<1;i++){
		   Thread task=new Thread("thread"+i){
			   public void run(){
				   //模拟后台任务
				  try {
					Thread.sleep(1000);//等待10秒
					
					RemoteObject flexShell=new RemoteObject(flashContainer);
					flexShell.setRemoteId("app");
					for(int i=0;i<1000;i++){
					 flexShell.asyncCall("setInfo",new Object[]{ i+""});
					}
					flashContainer.dispose();
					
					final DemoFirst curShell=DemoFirst.this;
					//DemoFirst.this.close();
					//DemoFirst.this.dispose();
					
					Display.asyncExec(new Runnable(){

						public void run() {
							curShell.close();
							curShell.dispose();
							
							DemoFirst shell = new DemoFirst(Display, SWT.SHELL_TRIM);
							shell.open();
							shell.layout();
							
							while (!shell.isDisposed()) {
								if (!Display.readAndDispatch())
									Display.sleep();
							}
						}
						
					});
					
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			   }
		   };
		   
		   task.setDaemon(true);//将后台线程设置为守护线程，保证主线程退出时此线程也会退出
		   task.start();
    	}
    }
	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
    
}
