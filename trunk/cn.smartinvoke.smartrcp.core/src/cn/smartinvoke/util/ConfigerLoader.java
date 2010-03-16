package cn.smartinvoke.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

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
	private static FileInputStream fileInputStream;
	public static void init() throws FileNotFoundException, IOException{
	  init(HelpMethods.getPluginFolder()+"/start.ini");
	}
	public static void init(String path)throws FileNotFoundException, IOException{
		if(properties!=null){
			properties.clear();	
		}
		if(fileInputStream!=null){
			try{fileInputStream.close();}catch(Exception e){};
		}
		properties=new Properties();
		configPath=path;
		fileInputStream=new FileInputStream(configPath);
		properties.load(fileInputStream);
	}
	/**
	 * 从配置文件加载start.ini文件路径
	 */
	private static String getConfigPath(){
		String ret=null;
		File pathSaveFile=new File(HelpMethods.getPluginFolder()+"/loadApp.ini");
		if(pathSaveFile.exists()){
			BufferedReader reader=null;
			try {
				reader=new BufferedReader(new FileReader(pathSaveFile));
				ret=reader.readLine();
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}finally{
				if(reader!=null){
					try{reader.close();}catch(Exception e){};
				}
			}
		}else{
			ret=HelpMethods.getPluginFolder()+"/start.ini";
		}
		return ret;
	}
	public static String getProperty(String key){
		return properties.getProperty(key);
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
