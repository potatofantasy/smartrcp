package cn.smartinvoke.smartrcp.app.pack;

import java.io.DataOutputStream;
import java.io.File;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import org.eclipse.jface.resource.ImageDescriptor;

/**
 * 
 * smartrcp应用程序信息类
 * 应用程序的目录结构如下：
 * modules下为模块文件
 * icons为图标文件
 * main.swf为主程序swf
 * splash.swf为启动界面文件
 * @author pengzhen
 * 
 */
public class CAppInfo {
	//应用程序的父文件夹路径
	public String basePath;
	//应用程序名称必须符合文件（夹）名规范
    public String name;
    //版本号
    public String version;
    //提供者
    public String provider;
    //logo.png文件路径，只能是png格式
    public String logoPath;
    //应用程序说明
    public String describe;
    //更新地址
    public String updateUrl="http://smartinvoke.cn/update";
    /**swf地址
    */
    public String mainSwfPath;//主swf地址
    public String splashSwfPath;//splash启动见面地址
    
    
    
    public List<String> modules=new LinkedList<String>();//swf模块文件路径集合
    /**
    * 图标文件路径
    */
    public List<String> icons=new LinkedList<String>();
    /**
     *扩展库jar路径
     */
    private List<String> libs=new LinkedList<String>();
    /**
     * 启动界面大小
     */
    public int splashWidth=424;
    public int splashHeight=225;
    //程序打包文件的绝对路径
    public String packLocation=null;
	public CAppInfo(){
	    
	}
	/**
	 * 解析basePath目录下的程序文件初始化该字段
	 */
    public void init(){
    	this.mainSwfPath=this.mainSwfPath.substring(this.basePath.length());
    	this.splashSwfPath=this.splashSwfPath.substring(this.basePath.length());
    	
    	//初始化模块路径
    	File folder = new File(this.basePath+File.separator+PackageTool.Key_Modules_Folder);
    	this.initFileList(folder, this.modules);
		//初始化图标路径
    	folder=new File(this.basePath+File.separator+PackageTool.Key_Icons_Folder);
    	this.initFileList(folder, this.icons);
        
    }
    private void initFileList(File folder,List<String> list){
    	//List<String> ret = new LinkedList<String>();
		if (folder != null) {
			int basePathLen=this.basePath.length();
			Stack<File> stack = new Stack<File>();
			stack.push(folder);
			while (!stack.isEmpty()) {
				File temp = stack.pop();
				File[] subFiles = temp.listFiles();
				if (subFiles != null) {
					for (int i = 0; i < subFiles.length; i++) {
						File file = subFiles[i];
						if (!file.isDirectory()) {
							//if(file.getName().endsWith(".swf")){
							 list.add(file.getAbsolutePath().substring(basePathLen));
							//}
						} else {
							stack.push(file);
						}
					}
				}
			}
		}
    }
    public List<String> addLib(String path){
    	if(path!=null){
    		if(new File(path).exists()){
    			if(!this.libs.contains(path)){
    				this.libs.add(path);
    			}
    		}
    	}
    	return this.libs;
    }
    public List<String> getLibs(){
    	return this.libs;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}

}
