package cn.smartinvoke.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * º”‘ÿ≈‰÷√–≈œ¢
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
