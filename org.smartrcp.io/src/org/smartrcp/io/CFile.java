package org.smartrcp.io;

import java.io.File;

import cn.smartinvoke.IServerObject;
/**
 * 文件类，负责除文件读写外的所有操作
 * @author pengzhen
 *
 */
public class CFile extends File implements IServerObject{
    
	public CFile(String pathname) {
		super(pathname);
	}
	public CFile getParentFile() {
		return new CFile(super.getParentFile().getAbsolutePath());
	}
	/**
	 * 将content字符串写到path文件中，如果该文件已经存在则重写，不存在则创建
	 * 如果写入出错会抛出运行时异常RuntimeException
	 * 
	 * 该方法为同步方法，适合于写入少量数据，如果写入大量数据请使用CFileWriter类
	 * @param path 文件完整路径
	 * @param content 文件内容
	 * @param encode  字符编码，可以为gbk,utf-8等
	 */
	public static void writeText(String path,String content,String encode){
		
	}
	/**
	 * 以encode编码方式读取path文件中的内容，并以字符串方式返回
	 * 如果读取出错会抛出运行时异常RuntimeException
	 * 
	 * 该方法为同步方法，适合于读取少量数据，如果读取大量数据请使用CFileReader类
	 * 
	 * @param path
	 * @param encode
	 * @return
	 */
	public static String readText(String path,String encode){
	  return null;	
	}
	/**
	 * 该方法与readText类似，只是返回类型为文件所有行组成的数组
	 * 如果读取出错会抛出运行时异常RuntimeException
	 * 
	 * 该方法为同步方法，适合于读取少量数据，如果读取大量数据请使用CFileReader类
	 * @param path
	 * @param encode
	 * @return
	 */
	public static String[] readAllLines(String path,String encode){
		return null;
	}
	/**
	 * 将字节数组bts写入path所在的文件，如果该文件已经存在则重写，不存在则创建
	 * 如果写入出错会抛出运行时异常RuntimeException
	 * 
	 * 该方法为同步方法，适合于写入少量数据，如果写入大量数据请使用CFileStreamWriter类
	 * 
	 * @param path
	 * @param bts
	 */
	public static void writeByte(String path,byte[] bts){
		
	}
	/**
	 * 将path所在文件的内容读取到字节数组中，并返回
	 * 如果读取出错会抛出运行时异常RuntimeException
	 * 
	 * 该方法为同步方法，适合于写入少量数据，如果写入大量数据请使用CFileStreamReader类
	 * @param path
	 * @return
	 */
	public static byte[] readAllBytes(String path){
		return null;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}
	public void dispose() {
		
	}

}
