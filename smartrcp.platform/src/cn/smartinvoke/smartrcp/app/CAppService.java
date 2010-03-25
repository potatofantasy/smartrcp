package cn.smartinvoke.smartrcp.app;

import java.io.File;

import cn.smartinvoke.IServerObject;
import cn.smartinvoke.util.HelpMethods;
/**
 * 已安装应用程序的管理
 * @author pengzhen
 *
 */
public class CAppService implements IServerObject {

	public CAppService(){
	  	
	}
	/**
     * 所有程序的安装目录
     * @return
     */
    public static String getInstallFolder(){
    	String path=HelpMethods.getPluginFolder()+"/smartrcpApps";
    	File folder=new File(path);
    	if(!folder.exists()){
    		folder.mkdirs();
    	}
    	return path;
    }
	@Override
	public void dispose() {
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}

}
