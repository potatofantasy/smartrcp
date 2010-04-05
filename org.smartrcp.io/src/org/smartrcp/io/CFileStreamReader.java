package org.smartrcp.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import cn.smartinvoke.IServerObject;
import cn.smartinvoke.smartrcp.gui.module.CEventBean;
import cn.smartinvoke.smartrcp.gui.module.CObservable;
/**
 * 文件二进制读取流，该类提供对二进制大文件的读取方法，
 * 
 * 该类提供的方法全为异步方法，所以适合对大文件的读取
 * 
 * 该类继承CObservable类，以使该类具有添加监听器的能力
 * @author pengzhen
 */
public class CFileStreamReader extends CObservable implements IServerObject {
	
    /**
     * 文件读取流
     */
    private InputStream in=null;
    /**
     * 需要读取的文件
     */
    private File readFile;
    /**
     * 一次读取文件的缓冲区的大小
     */
    private int bufferSize=1024;
    /**
     * @param path
     * @throws FileNotFoundException 
     */
	public CFileStreamReader(String path) throws FileNotFoundException{
		    this.readFile=new File(path);
			in=new FileInputStream(this.readFile);
	}
	/**
	 * 与java.io.InputStream.skip方法相同
	 * @param n
	 * @return
	 * @throws IOException
	 */
	public long skip(long n) throws IOException{
		return this.in.skip(n);
	}
	/**
	 * 与java.io.InputStream.available方法相同
	 * @return
	 * @throws IOException
	 */
	public int available() throws IOException {
		return this.in.available();
	}
	/**
	 * 与java.io.FileInputStream.mark方法相同
	 * @param readlimit
	 */
	public  void mark(int readlimit){
		this.in.mark(readlimit);
	}
	/**
	 * 与java.io.FileInputStream.reset方法相同
	 */
	public  void reset() throws IOException{
		this.in.reset();
	}
	/**
	 * 与java.io.FileInputStream.markSupported方法相同
	 */
	public boolean markSupported(){
		return this.in.markSupported();
	}
	//=========================================
	/**
	 * 返回要读取文件的大小
	 * @return
	 */
	public long getSize(){
		return this.readFile.length();
	}
	
	public int getBufferSize() {
		return bufferSize;
	}
	public void setBufferSize(int bufferSize) {
		this.bufferSize = bufferSize;
	}
	/**
	 * 以异步方式，以二进制流的方式读取文件内容
	 * 
	 * 该方法会调用异步线程读取文件内容，所以导致当前UI线程的阻塞
	 * @param bufferSize 一次读取字节的多少
	 */
	public void readBytes(int bufferSize){
	   this.setBufferSize(bufferSize);
	   //TODO 启动一新线程读取文件内容，开个线程池效果会更好些
	   Thread thread=new Thread(){
		   public void run(){
			   while(true){
				   byte[] buf=new byte[getBufferSize()];
				   try{
					 //读取
					 int readNum=in.read(buf);
					 if(readNum==-1){//到达文件末尾
						 break;
					 }else{
						 //唤醒flex监听器
						 CBytesBean bytesBean=new CBytesBean(readNum, buf);
						 fireEvent(bytesBean);
					 }
				   }catch(IOException e){
					   //读取出错抛出异常到flex
					    fireEvent(new RuntimeException(e));
				   }
			   }
		   }
	   };
	   thread.setDaemon(true);
	   thread.start();
	}
	
	
	public void dispose() {
		 this.close();
	}
	/**
	 * 关闭流资源
	 */
	public void close(){
		//关闭资源
	     if(in!=null){
	    	 try{in.close();}catch(Exception e){e.printStackTrace();}
	     }
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}

}
