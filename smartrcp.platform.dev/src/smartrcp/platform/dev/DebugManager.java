package smartrcp.platform.dev;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;

import cn.smartinvoke.IServerObject;
import cn.smartinvoke.smartrcp.DebugServer;
import cn.smartinvoke.util.HelpMethods;

/**
 * 负责debug事物
 * @author pengzhen
 *
 */
public class DebugManager implements IServerObject{
	public static final String Args="-isDebug ";
    public static int runningCheckPort=17385;
	public DebugManager() {
		
	}
	
	public void debugAsShell(boolean set){
		//if(set){
			DebugServer.isDebugAsShell=set;
		//}
	}
	
	
	/**
	 * 检查当前程序是否正在运行，smartrcp的开发版只提供一个运行实例
	 * 
	 * @return
	 */
    public static boolean isRunning(){
    	boolean ret=false;
    	try {
    		new ServerSocket(runningCheckPort);
    		checkDebugInvoke();
		} catch (IOException e) {
			ret=true;
		}
    	return ret;
    }
    /**
     * 启动一线程专门监听debug程序的调用
     */
    private static void checkDebugInvoke(){
       Thread thread=new Thread(){
    	   public void run(){
    		   
    	   }
       };
       thread.setName("smartrcp_debug");
       thread.setDaemon(true);
       
    }
    /**
     * 获取debug目录文件完整路径
     * @return
     */
    public static String getDebugFilePath(){
    	return HelpMethods.getPluginFolder()+File.separator+"isRunning.ini";
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
