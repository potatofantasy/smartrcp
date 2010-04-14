package cn.smartinvoke.smartrcp.app.pack;

import cn.smartinvoke.smartrcp.gui.module.CEventBean;


/**
 * 应用程序打包类
 * @author pengzhen
 */
public class PackageTool {

	public PackageTool() {
	   	
	}
	/**
	 * 将baseDir目录下的smartrcp程序文件压缩到savePath路径
	 * 该方法会启动一新线程专门负责文件打包操作
	 * @param baseDir  
	 * @param savePath 保存位置
	 * @param comment 该程序的注释
	 * @throws Exception 
	 */
    public void packFiles(final String baseDir,final String savePath,final String comment,final CEventBean bean){
       Thread thread=new Thread(){
    	   public void run(){
    		try {
				ZipToFile.zipFile(baseDir, savePath,comment);
				bean.fireOnetimeEvent(true);
			} catch (Exception e) {
				Throwable casue=e;
				while(true){
					Throwable temp=e.getCause();
					if(temp==null){
						break;
					}else{
						casue=temp;
					}
				}
				bean.fireOnetimeEvent(casue.getMessage());
			}
    	   }
       };
       thread.setDaemon(true);
       thread.start();
    }
    /**
     * 将程序zip文件appFile解压到saveDir，实现对程序的安装
     * 同时创建一快捷方式
     * @param appFile
     */
    public CAppInfo install(String appFile,String saveDir){
    	CAppInfo ret=new CAppInfo();
    	
    	return ret;
    }
	public static final String Key_Modules_Folder="modules";
	public static final String Key_Icons_Folder="icons";
	
	public static final String Key_Config_File="config.properties";
	public static final String Key_Property_File="property.prop";
	
}
