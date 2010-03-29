package cn.smartinvoke.smartrcp.app.download.http;

import java.io.*;
import java.net.*;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

import cn.smartinvoke.smartrcp.app.pack.CAppInfo;
import cn.smartinvoke.smartrcp.app.pack.PackageTool;

import smartrcp.platform.Application;

public class SiteFileFetch extends Job {
	SiteInfoBean siteInfoBean = null; // 文件信息Bean
	long[] nStartPos; // 开始位置
	long[] nEndPos; // 结束位置
	FileSplitterFetch[] fileSplitterFetch; // 子线程对象
	long nFileLength; // 文件长度
	private float mbSize=0;
	boolean bFirst = true; // 是否第一次取文件
	boolean bStop = false; // 停止标志
	File tmpFile; // 文件下载的临时信息
	DataOutputStream output; // 输出到文件的输出流
    private IProgressMonitor monitor;
    //下载完成后的监听器
    public ICompleteListener completeListener;
    
	public SiteFileFetch(String taskName,SiteInfoBean bean,ICompleteListener completeListener){
		super(taskName);
		this.completeListener=completeListener;
		siteInfoBean = bean;
		tmpFile = new File(bean.getSFilePath() + File.separator
				+ bean.getSFileName() + ".info");
		if (tmpFile.exists()){
			bFirst = false;
			try{
				read_nPos();
			}catch(Exception e){
				tmpFile.delete();//删除配置文件
				this.finishDownload("下载配置文件读取出错", true);
			}
		} else {
			nStartPos = new long[bean.getNSplitter()];
			nEndPos = new long[bean.getNSplitter()];
		}
	}
	
	protected IStatus run(IProgressMonitor monitor) {
		this.monitor=monitor;
		// 获得文件长度
		// 分割文件
		// 实例FileSplitterFetch
		// 启动FileSplitterFetch线程
		// 等待子线程返回
		try {
			if (bFirst) {
				nFileLength = getFileSize();
				if (nFileLength == -1) {
					this.finishDownload("无法获得文件"+siteInfoBean.getSSiteURL()+"长度",true);
				} else if (nFileLength == -2){
					this.finishDownload("无法下载文件"+siteInfoBean.getSSiteURL(),true);
				} else {
					this.mbSize=(float)nFileLength/1048576f;//文件兆大小
					//开始任务显示
					monitor.beginTask(siteInfoBean.getSFileName(),(int)nFileLength);
					
					for (int i = 0; i < nStartPos.length; i++) {
						nStartPos[i] = (long) (i * (nFileLength / nStartPos.length));
					}
					for (int i = 0; i < nEndPos.length - 1; i++) {
						nEndPos[i] = nStartPos[i + 1];
					}
					nEndPos[nEndPos.length - 1] = nFileLength;
				}
			}else{
				this.mbSize=(float)nFileLength/1048576f;//文件兆大小
				//开始任务显示
				monitor.beginTask(siteInfoBean.getSFileName(),(int)nFileLength);
				//显示已完成进度
				monitor.worked((int)(this.nFileLength-restBts));
			}
			// 启动子线程
			fileSplitterFetch = new FileSplitterFetch[nStartPos.length];
			for (int i = 0; i < nStartPos.length; i++) {
				fileSplitterFetch[i] = new FileSplitterFetch(this,siteInfoBean
						.getSSiteURL(), siteInfoBean.getSFilePath()
						+ File.separator + siteInfoBean.getSFileName(),
						nStartPos[i], nEndPos[i], i);
				//Utility.log("Thread " + i + " , nStartPos = " + nStartPos[i]
				//		+ ", nEndPos = " + nEndPos[i]);
				fileSplitterFetch[i].start();
			}
			boolean breakWhile = false;
			while (!bStop) {
				write_nPos();
				//如果用户取消了下载
				if (monitor.isCanceled()){
					this.siteStop();
					return Status.CANCEL_STATUS;
				}
				Utility.sleep(500);
				breakWhile = true;
				for (int i = 0; i < nStartPos.length; i++) {
					if (!fileSplitterFetch[i].bDownOver) {
						breakWhile = false;
						break;
					}
				}
				if (breakWhile)
					break;
			}
			if(!isErrorShutDown){//不是错误退出
			  finishDownload("文件"+siteInfoBean.getSSiteURL()+"下载结束",false);
			  //唤醒监听器
			  if(completeListener!=null){ 
			   String savePath=siteInfoBean.getSFilePath()+File.separator+siteInfoBean.getSFileName();
			   CAppInfo appInfo=PackageTool.readBasicInfo(savePath);
			   completeListener.complete(appInfo);
			  }
			  tmpFile.delete();//删除配置文件
			}
			
		} catch (Exception e) {
			errorShutDown(e);
		}
		return Status.OK_STATUS;
	}
	//添加已完成进度
	public synchronized void addWorked(int num){
		this.monitor.worked(num);
	}
	
	/**
	 * 告诉用户下载任务执行完毕
	 * @param info
	 */
    private void finishDownload(String info,boolean isError){
    	monitor.done();
    	if(isError){
    		Application.openError(info);
    	}else{
    	    Application.openInfo(info);
    	}
    }
    private boolean isErrorShutDown=false;
    public void errorShutDown(Throwable e){
    	Throwable casue=e;
    	isErrorShutDown=true;
		while(true){
			Throwable temp=e.getCause();
			if(temp==null){
				break;
			}else{
				casue=temp;
			}
		}
		this.siteStop();
		finishDownload("程序下载过程中出错，原因如下：\n"+casue.getMessage(),true);
    }
	// 获得文件长度
	public long getFileSize() {
		int nFileLength = -1;
		try {
			URL url = new URL(siteInfoBean.getSSiteURL());
			HttpURLConnection httpConnection = (HttpURLConnection) url
					.openConnection();
			httpConnection.setRequestProperty("User-Agent", "NetFox");
			int responseCode = httpConnection.getResponseCode();
			if (responseCode >= 400) {
				processErrorCode(responseCode);
				return -2; // -2 represent access is error
			}
			String sHeader;
			for (int i = 1;; i++) {
				// DataInputStream in = new
				// DataInputStream(httpConnection.getInputStream ());
				// Utility.log(in.readLine());
				sHeader = httpConnection.getHeaderFieldKey(i);
				if (sHeader != null) {
					if (sHeader.equals("Content-Length")) {
						nFileLength = Integer.parseInt(httpConnection
								.getHeaderField(sHeader));
						break;
					}
				} else
					break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Utility.log(nFileLength);
		return nFileLength;
	}
    private int restBts=0;
	// 保存下载信息（文件指针位置）
	private void write_nPos() throws Exception{
			output = new DataOutputStream(new FileOutputStream(tmpFile));
			output.writeInt((int)this.nFileLength);//存储文件长度
			output.writeInt(nStartPos.length);
			restBts=0;//未下载的比特数
			for (int i = 0; i < nStartPos.length; i++){
				output.writeLong(fileSplitterFetch[i].nStartPos);
				output.writeLong(fileSplitterFetch[i].nEndPos);
				restBts+=fileSplitterFetch[i].nEndPos-fileSplitterFetch[i].nStartPos;
			}
			
			float alreadyDownload=((float)(this.nFileLength-restBts))/1048576f;
			monitor.subTask(this.siteInfoBean.getSSiteURL()+"  "+alreadyDownload+"/" +this.mbSize);
			
			output.close();
            
	}

	// 读取保存的下载信息（文件指针位置）
	private void read_nPos()throws Exception{
		
			DataInputStream input = new DataInputStream(new FileInputStream(
					tmpFile));
			this.nFileLength=input.readInt();
			
			
			int nCount = input.readInt();
			nStartPos = new long[nCount];
			nEndPos = new long[nCount];
			restBts=0;//未下载的比特数
			for (int i = 0; i < nStartPos.length; i++) {
				nStartPos[i] = input.readLong();
				nEndPos[i] = input.readLong();	
				restBts+=nEndPos[i]-nStartPos[i];
			}
			
			input.close();
	}

	private void processErrorCode(int nErrorCode) {
		System.err.println("Error Code : " + nErrorCode);
	}
	// 停止文件下载
	public void siteStop() {
		bStop = true;
		if(fileSplitterFetch!=null){
		 for (int i = 0; i < fileSplitterFetch.length; i++){
			if(fileSplitterFetch[i]!=null){
				fileSplitterFetch[i].splitterStop();
			}
		 }
		}
	}
	public static void main(String[] args) {
		try{
            
			 System.out.println(1024*1024);
			}
			catch(Exception e){e.printStackTrace ();}

	}
}
