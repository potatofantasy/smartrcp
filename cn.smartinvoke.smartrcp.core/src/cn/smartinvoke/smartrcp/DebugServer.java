package cn.smartinvoke.smartrcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPage;

import cn.smartinvoke.ObjectPool;
import cn.smartinvoke.rcp.CLayoutBasicInfo;
import cn.smartinvoke.smartrcp.core.SmartRCPBuilder;
import cn.smartinvoke.smartrcp.gui.FlashShell;
import cn.smartinvoke.smartrcp.gui.FlashViewPart;
import cn.smartinvoke.smartrcp.gui.control.GlobalServiceId;
import cn.smartinvoke.smartrcp.gui.control.ViewManager;
import cn.smartinvoke.smartrcp.util.JFaceHelpMethod;
import cn.smartinvoke.util.ConfigerLoader;

/**
 * 负责创建debug服务
 * 
 * @author pengzhen
 * 
 */
public class DebugServer {
    static CApplication cur_application=null;
    static int debugPort=17385;
	private DebugServer() {
       
	}
	static ServerSocket serverSocket =null;
	public static void start() {
		cur_application=(CApplication)ObjectPool.INSTANCE.getObject(GlobalServiceId.Cur_Application);
		
		try{
		  serverSocket=new ServerSocket(debugPort);
		  //第一次运行
		  Thread thread = new Thread() {
				public void run() {
					Display display=(Display)
			        ObjectPool.INSTANCE.getObject(GlobalServiceId.Swt_Display);
					
					try {
						while (true) {
							BufferedReader reader=null;
						  try{
							Socket socket = serverSocket.accept();
							//JFaceHelpMethod.showError("server accept socket");
							reader = new BufferedReader(
									new InputStreamReader(socket.getInputStream()));
							//获取地址
							String url = reader.readLine();
							//JFaceHelpMethod.showError("接收到的url="+url);
							if(!url.equals("non")){
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
							}
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
						 
					}
				}
			};
			thread.setDaemon(true);
			thread.start();
		}catch(Exception e){////smartrcp平台已经启动则通过套接字将debug路径发送给运行的smartrcp
		  sendDebugFile();
		  Runtime.getRuntime().exit(0);
		}
		
		
	}
	/**
	 *已经有smartrcp开发平台在运行，那么只需要将需要debug的swf路径通过
	 *套接字发送给它就可以了
	 */
	private static void sendDebugFile(){
	   Socket socket=null;
	  try{
		  String path=ConfigerLoader.getAppArg("-debugPath ");
		  if(path==null){
				 path="non";
		  }
		 //JFaceHelpMethod.showError("debug path:"+path);
		 socket=new Socket("127.0.0.1",debugPort);
		 BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		 
		 writer.write(path);
		 writer.write("\n");
		 writer.flush();
		 writer.close();
		 //JFaceHelpMethod.showError("send over");
	  }catch(Exception e){
		JFaceHelpMethod.showError(e.getMessage());
	  }finally{
		  if(socket!=null){
			  try{socket.close();}catch(Exception e){}
		  }
	  }
	}
	/**
	 * 为true表示打开debug窗口，false表示打开ViewPart
	 */
	public static boolean isDebugAsShell=true;
	
    static void openDebugShell(String swfPath){
    	FlashShell flashShell=new FlashShell(true,SWT.ON_TOP |SWT.SHELL_TRIM);
    	flashShell.setText(swfPath);
    	flashShell.setSize(550, 550);
    	
    	flashShell.createFlashContainer(swfPath);
    	
    	flashShell.open();
    	flashShell.getShell().setMinimized(false);
    }
    static void openViewPart(String swfPath){
    	CLayoutBasicInfo layoutInfo=new CLayoutBasicInfo();
    	layoutInfo.autoLoad=true;
    	layoutInfo.isDebugLayout=true;
    	layoutInfo.title=swfPath;
    	layoutInfo.modulePath=swfPath;
    	layoutInfo.viePartId=FlashViewPart.ID;
    	//安装独立swf方式打开，因为loadModule方法由该swf自己调用
    	layoutInfo.isModuleSwf=false;
    	
    	SmartRCPBuilder.Main_Shell.setMinimized(false);
    	
    	ViewManager.Instance.openViewPart(layoutInfo, true,IWorkbenchPage.VIEW_ACTIVATE);
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
