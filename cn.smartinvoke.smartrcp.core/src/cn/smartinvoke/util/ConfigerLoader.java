package cn.smartinvoke.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import org.eclipse.core.runtime.Platform;

import cn.smartinvoke.smartrcp.CApplication;
import cn.smartinvoke.smartrcp.app.CAppService;
import cn.smartinvoke.smartrcp.util.JFaceHelpMethod;

/**
 * 加载配置信息
 * @author pengzhen
 */
public class ConfigerLoader {
	//程序名称
	public static final String key_app_name="app_name";
	//程序版本
	public static final String key_app_version="app_version";
	//更新地址
	public static final String key_update_url="update_url";
	//启动界面swf地址
    public static final String key_splash="splash";
    //启动界面大小 width*height格式
    public static final String key_splash_size="splash-size";
    //运行程序swf路径
    public static final String key_runtime="runtime";
    
    
    public static final String key_debug_port="debug-port";
    public static final String key_debug="debug";
    public static final String key_export_package="Export-Package";
	private ConfigerLoader(){
		
	}
	//private static Properties properties=null;
	public static String configPath=null;
	public static int[] splashSize=new int[]{300,300};
	private static boolean isInit=false;
	/**
	 * 该方法方法体只被加载一次
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void init() throws FileNotFoundException, IOException{
	  if(!isInit){
//		  try{
//		    JFaceHelpMethod.showInfo(HelpMethods.getPluginFolder());
//		  }catch(Exception e){
//			  JFaceHelpMethod.showInfo(e.getMessage());
//		  }
		isInit=true;
		startupSwf=getStartInfo();//从start.ini文件中获取启动程序目录
		if(startupSwf==null){
			startupSwf=getAppArg();//从控制台获得启动程序的路径
		}
		if(startupSwf!=null){
			int spl=-1;
			//获得窗口大小
			splashSize=getShellSize(startupSwf);
			if((spl=startupSwf.lastIndexOf('?'))!=-1){
				startupSwf=startupSwf.substring(0,spl);
			}
		}else{//如果没有则启动标准程序
	    	if(!checkSwfExist()){
	    		//标准启动程序
		    	startupSwf=CApplication.Instance.getInstallLocation()+"default.swf";
		    	//JFaceHelpMethod.showInfo("splash:"+startupSwf);
		    	if(!new File(startupSwf).exists()){
		    	  JFaceHelpMethod.showError("启动SWF文件"+startupSwf+"不存在，程序将退出");
		    	  Runtime.getRuntime().exit(0);
		    	}
	    	}
	    }
	  }
//	  
	}
	/**
	 * 检查
	 * @return
	 */
	private static boolean checkSwfExist(){
		if(startupSwf==null){
			return false;
		}
		String tempPath=startupSwf.toLowerCase();
		if(tempPath.startsWith("http://")){
			try {
				URL url=new URL(startupSwf);
				url.openConnection().getInputStream();
				return true;
			} catch (Exception e) {
				return false;
			}
		}else{
			return new File(startupSwf).exists();
		}
	}
	/**
	 * 从swf路径中获得启动界面大小
	 * @param swfPath
	 * @return
	 */
	 private static int[] getShellSize(String swfPath){
		    int[] ret=new int[]{300,300};
		    int spl=swfPath.lastIndexOf('?');
		    if(spl!=-1){
		    	String sizeStr=swfPath.substring(spl+1).trim();
		    	spl=sizeStr.indexOf('*');
		    	if(spl!=-1){
		    		try{
		    	      ret[0]=Integer.valueOf(sizeStr.substring(0,spl));
		    	      ret[1]=Integer.valueOf(sizeStr.substring(spl+1));
		    		}catch(Exception e){
		    		   
		    		}
		    	}
		    }
		    return ret;
	   }
	/**
	 * 当前启动swf完整路径
	 */
	private static String startupSwf;
	
	public static String getSplashSwf() {
		return startupSwf;
	}
	/**
	 * 从安装目录的start.ini文件中读取启动程序目录，如果该文件不存在，或数据错误，smartrcp则
	 * 调用getAppArg方法尝试从控制台获得启动程序目录，如果控制台没有则启动标准程序
	 */
	private static String getStartInfo()throws FileNotFoundException, IOException{
		String appPath=null;
		String path=HelpMethods.getPluginFolder()+File.separator+"start.ini";
	    if(new File(path).exists()){
		 BufferedReader reader=new BufferedReader(new FileReader(path));
		 appPath=reader.readLine();
		 reader.close();
	    }
		return appPath;
	}
	/**
	 * 获取控制台smartrcp目录参数值，如果没有则返回null
	 * 应用参数如下：-app smartrcp应用程序的绝对路径
	 * 
	 * 如果没有smartrcp应用参数，则启动默认smartrcp服务平台程序，该平台负责对
	 * smartrcp程序的安装，引导用户正确安装smartrcp程序
	 * @return
	 */
	private static String getAppArg(){
		return getAppArg("-app ");
	}
	/**
	 * 获取指定的命令行参数
	 * @param key
	 * @return
	 */
	public static String getAppArg(String key){
		String ret=null;
		String[] arr=Platform.getCommandLineArgs();
		if(arr!=null){
			String cmdName=key;
    		for(int i=0;i<arr.length;i++){
    			String arg=arr[i].trim();
    			if(arg.equals(cmdName.trim())){
    				ret=arr[i+1].trim();
    			}else
    			if(arg.startsWith(cmdName)){
    				ret=arg.substring(cmdName.length()+1).trim();
    				break;
    			}
    		}
    	}
		return ret;
	}
	/*public static String getProperty(String key){
		if(key.equals(key_debug)){
		  return isDebug+"";
		}else{
		  return properties.getProperty(key);
		}
	}*/
	/**
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		ConfigerLoader.init();
	}

}
