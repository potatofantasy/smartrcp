package org.smartrcp.io;

import java.io.File;
import java.util.Date;

import cn.smartinvoke.IServerObject;
/**
 * 目录类，负责对目录进行操作
 * @author pengzhen
 *
 */
public class CDirectory implements IServerObject {
	/**
	 * 创建path所指定的文件夹
	 * @param path
	 */
    public static void create(String path){
    	new File(path).mkdirs();
    }
    /**
     * 判断path是否是目录
     * @param path
     * @return
     */
    public static boolean isDirectory(String path){
    	return new File(path).isDirectory();
    }
    /**
     * 返回该目录下的所有文件与文件夹大小的总和
     * @param path
     * @return
     */
    public static long getSize(String path){
    	return 0;
    }
    /**
     * 返回path目录下的所有文件的完整路径
     * @param path
     * @return
     */
    public static String[] getSubFiles(String path){
    	return null;
    }
    /**
     * 返回path目录下的所有文件夹的完整路径
     * @param path
     * @return
     */
    public static String[] getSubFolders(String path){
    	return null;
    }
    /**
     * 如果path为空目录，就删除该目录
     * @param path
     */
    public static void delete(String path){
    	new File(path).delete();
    }
    /**
     * 删除该目录下的所有文件与文件夹
     * @param path
     */
    public static void deleteAll(String path){
    	
    }
    /**
     * 将fromPath目录下的文件与文件夹都拷贝到toPath目录下
     * @param fromPath
     * @param toPath
     */
    public static void copyTo(String fromPath,String toPath){
    	
    }
    /**
     * 判断一目录是否存在
     * @param path
     * @return
     */
    public static boolean exists(String path){
    	return new File(path).exists();
    }
    /**
     * 获得目录的创建时间，
     * @param path
     * @return 返回文件夹创建日期
     */
    public static Date getCreationTime(String path){
    	return null;
    }
    
    public void dispose() {
 	   
	}
	public static void main(String[] args) {
		
	}

}
