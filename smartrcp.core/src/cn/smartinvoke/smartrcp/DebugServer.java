package cn.smartinvoke.smartrcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.internal.WorkbenchPage;

import cn.smartinvoke.gui.ObjectPool;
import cn.smartinvoke.rcp.CLayoutBasicInfo;
import cn.smartinvoke.smartrcp.core.SmartRCPBuilder;
import cn.smartinvoke.smartrcp.gui.FlashShell;
import cn.smartinvoke.smartrcp.gui.control.GlobalServiceId;
import cn.smartinvoke.smartrcp.gui.control.ViewManager;
import cn.smartinvoke.util.ConfigerLoader;

/**
 * 负责创建debug服务
 * 
 * @author pengzhen
 * 
 */
public class DebugServer {
    static CApplication cur_application=null;
	private DebugServer() {
       
	}
	public static void start() {
		cur_application=(CApplication)ObjectPool.INSTANCE.getObject(GlobalServiceId.Cur_Application);
		Thread thread = new Thread() {
			public void run() {
				Display display=(Display)
		        ObjectPool.INSTANCE.getObject(GlobalServiceId.Swt_Display);
				// 获得端口
				int port = 1738;
//				String portStr = ConfigerLoader
//						.getProperty(ConfigerLoader.key_debug_port);
//				if (portStr != null) {
//					try {
//						port = Integer.valueOf(portStr);
//					} catch (Throwable e) {
//					}
//					;
//				}
				try {
					ServerSocket serverSocket = new ServerSocket(port);
					while (true) {
						BufferedReader reader=null;
					  try{
						Socket socket = serverSocket.accept();
						reader = new BufferedReader(
								new InputStreamReader(socket.getInputStream()));
						//获取地址
						String url = reader.readLine();
                        final String swfUrl=url.substring(0, url.length()-4)+"swf";
                        //打开debug窗口
                        display.asyncExec(new Runnable(){
    						public void run() {
    							if(isDebugAsShell){
    							  openDebugShell(swfUrl);
    							}else{
    							  openViewPart(swfUrl);
    							}
    						}
    					});
                        //-----------
					  }catch(Throwable e){
						  e.printStackTrace();
					  }finally{
						  if(reader!=null){
							  reader.close();
						  }
					  }
					}
				} catch (IOException e) {
					final int p=port;
					display.asyncExec(new Runnable(){
						public void run() {
							MessageDialog.openError(SmartRCPBuilder.Main_Shell, "错误",
									"端口" + p + "被占用或不合法");
						}
					});
					
				}
			}
		};
		thread.setDaemon(true);
		thread.start();
	}
	/**
	 * 为true表示打开debug窗口，false表示打开ViewPart
	 */
	public static boolean isDebugAsShell=true;
	
    static void openDebugShell(String swfPath){
    	FlashShell flashShell=new FlashShell(true);
    	flashShell.setText(swfPath);
    	flashShell.setSize(550, 550);
    	
    	flashShell.createFlashContainer(swfPath);
    	
    	flashShell.open();
    }
    static void openViewPart(String swfPath){
    	CLayoutBasicInfo layoutInfo=new CLayoutBasicInfo();
    	layoutInfo.autoLoad=true;
    	layoutInfo.title=swfPath;
    	//安装独立swf方式打开，因为loadModule方法由该swf自己调用
    	layoutInfo.isModuleSwf=false;
    	
    	ViewManager.Instance.openViewPart(layoutInfo, true,IWorkbenchPage.VIEW_ACTIVATE);
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
