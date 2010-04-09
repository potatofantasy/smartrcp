package cn.smartinvoke.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import cn.smartinvoke.smartrcp.app.CAppService;
import cn.smartinvoke.smartrcp.app.pack.PackageTool;

/**
 * 加载配置信息
 * @author pengzhen
 *
 */
public class ConfigerLoader {
    public static final String key_splash="splash";
    public static final String key_splash_size="splash-size";
    public static final String key_runtime="runtime";
    public static final String key_debug_port="debug-port";
    public static final String key_debug="debug";
    public static final String key_export_package="Export-Package";
	private ConfigerLoader() {
	   
	}
	private static Properties properties=null;
	public static String configPath=null;
	public static void init() throws FileNotFoundException, IOException{
		appPath=getAppArg();//获得启动程序的路径
	    if(appPath==null || 
	       (!new File(appPath).exists())){//如果没有则启动标准程序
	    	appPath=CAppService.getInstallFolder()+"/smartrcp";
	    }
	    
		properties=new Properties();
		configPath=appPath+File.separator+PackageTool.Key_Config_File;
		if(!new File(configPath).exists()){//启动配置文件不存在
		   Log.printError(configPath+" is not exist the program exit!");
		}
		Log.println("start.ini location="+configPath);
		properties.load(new FileInputStream(configPath));
	  
	}
	/**
	 * 当前启动的应用程序安装目录
	 */
	public static String appPath;
	private static boolean isDebug=false;
	//启动文件完整路径
	public static String startFilePath="F:/myWork/cn.smartinvoke.smartrcp.core/start.ini";
//	/**
//	 * 获得启动信息
//	 */
//	private static void getStartInfo()throws FileNotFoundException, IOException{
//		
//		String path=HelpMethods.getPluginFolder()+File.separator+"start.ini";
//		BufferedReader reader=new BufferedReader(new FileReader(path));
//		appPath=reader.readLine();
//		String debugStr=reader.readLine();
//		if(debugStr!=null){
//			try{
//				isDebug=Boolean.valueOf(debugStr);
//			}catch(Exception e){};
//		}
//		reader.close();
//	}
	/**
	 * 获取控制台smartrcp目录参数值，如果没有则返回null
	 * 应用参数如下：-app smartrcp应用程序的绝对路径
	 * 
	 * 如果没有smartrcp应用参数，则启动默认smartrcp服务平台程序，该平台负责对
	 * smartrcp程序的安装，引导用户正确安装smartrcp程序
	 * @return
	 */
	private static String getAppArg(){
		String ret=null;
		String[] arr=org.eclipse.equinox.internal.app.CommandLineArgs.getAllArgs();
		if(arr!=null){
			String cmdName="-app ";
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
	public static String getProperty(String key){
		if(key.equals(key_debug)){
		  return isDebug+"";
		}else{
		  return properties.getProperty(key);
		}
	}
	/**
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		ConfigerLoader.init();
		
		System.out.println(ConfigerLoader.getProperty(ConfigerLoader.key_splash));
		System.out.println(ConfigerLoader.getProperty(ConfigerLoader.key_splash_size));
		System.out.println(ConfigerLoader.getProperty(ConfigerLoader.key_export_package));
	}

}
