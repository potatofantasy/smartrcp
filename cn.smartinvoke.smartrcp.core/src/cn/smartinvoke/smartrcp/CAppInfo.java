package cn.smartinvoke.smartrcp;

import java.util.LinkedList;
import java.util.List;

/**
 * smartrcp应用程序信息类
 * @author pengzhen
 *
 */
public class CAppInfo {
	//应用程序名称必须符合文件（夹）名规范
    public String name;
    //版本号
    public double version;
    //应用程序说明
    public String describe;
    /**swf地址
    */
    public String mainSwfPath;//主swf地址
    public String splashSwfPath;//splash启动见面地址
    public List<String> modules=null;//swf模块文件路径集合
    /**
    * 
    */
	public CAppInfo(){
	    
	}
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}

}
