package cn.smartinvoke.smartrcp.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

import cn.smartinvoke.IServerObject;
import cn.smartinvoke.smartrcp.CApplication;

/**
 * 界面的帮助方法类
 * @author pengzhen
 *
 */
public class UIHelpMethod implements IServerObject {
    /**
     * 将二进制数组data，存储到path文件中
     * @param data
     * @param path
     */
	public static void saveImage(byte[] data,String path){
		OutputStream out=null;
		try {
			 out=new FileOutputStream(path);
			 out.write(data);
			 out.flush();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			if(out!=null){
				try{out.close();}catch (Exception e) {};
			}
		}
	}
	/**
	 * 输入相对路径返回绝对路径
	 * @param subPath
	 * @return
	 */
	public static String getFullPath(String subPath){
		String ret=null;
		if(subPath!=null){
			//Java模块位置，模块路径用*号开头
			if(subPath.charAt(0)=='*'){
				return subPath;
			}else
			// 绝对路径
			if (subPath.toLowerCase().startsWith("http://")) {
				ret = subPath;
			} else
			// 绝对路径
			if (subPath.indexOf(':')!=-1) {
				ret = subPath;
			} else {
				// 相对路径
				String baseFolder = CApplication.Instance.getBaseFolder();
				if (subPath.charAt(0) == '/') {
					ret = baseFolder + subPath;
				} else {
					ret = baseFolder + '/' + subPath;
				}
			}
		}
		return ret.replace('\\', '/');
	}
	public static String getFullPathForJFace(String subPath){
		String fullPath=getFullPath(subPath);
		String temp=fullPath.toLowerCase();
		if(!temp.startsWith("http://")){
			return "file:/"+fullPath.replace('\\', '/');
		}else{
			return fullPath.replace('\\', '/');
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			URL url=new URL("file://");
		} catch (MalformedURLException e){
			e.printStackTrace();
		}
	}
	public void dispose() {
		
	}

}
