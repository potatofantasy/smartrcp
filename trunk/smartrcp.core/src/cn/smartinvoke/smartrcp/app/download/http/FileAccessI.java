package cn.smartinvoke.smartrcp.app.download.http;

import java.io.*;

public class FileAccessI implements Serializable {
	RandomAccessFile oSavedFile;
	long nPos;
	private static int alreadyDownloadNum=0;
    private synchronized static void addDownloadBts(int len){
    	alreadyDownloadNum+=len;
    }
	public FileAccessI() throws IOException {
		this("", 0);
	}

	public FileAccessI(String sName, long nPos) throws IOException {
		oSavedFile = new RandomAccessFile(sName, "rw");
		this.nPos = nPos;
		oSavedFile.seek(nPos);
	}

	public synchronized int write(byte[] b, int nStart, int nLen)throws IOException {
		int n = -1;
		oSavedFile.write(b, nStart, nLen);
		n = nLen;
		FileAccessI.addDownloadBts(nLen);
		return n;
	}
	public void close(){
		if(this.oSavedFile!=null){
			try{this.oSavedFile.close();}catch(Exception e){};
		}
	}
}
