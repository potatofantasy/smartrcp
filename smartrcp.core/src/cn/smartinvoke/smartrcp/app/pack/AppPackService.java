package cn.smartinvoke.smartrcp.app.pack;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.IJobChangeListener;
import org.eclipse.core.runtime.jobs.Job;

import cn.smartinvoke.IServerObject;
import cn.smartinvoke.smartrcp.app.CAppService;
import cn.smartinvoke.smartrcp.app.download.http.ICompleteListener;
import cn.smartinvoke.smartrcp.app.download.http.SiteFileFetch;
import cn.smartinvoke.smartrcp.app.download.http.SiteInfoBean;
import cn.smartinvoke.smartrcp.gui.module.CEventBean;
import cn.smartinvoke.smartrcp.util.JFaceHelpMethod;
import cn.smartinvoke.util.HelpMethods;
/**
 * 应用程序管理类
 * @author pengzhen
 *
 */
public class AppPackService implements IServerObject{

	public AppPackService(){
		
	}
	
	/**
	 * 从http服务器下载程序，存储于本地
	 * @param url
	 */
    public void downloadAppFromUrl(String downloadUrl){
    	//解析下载文件名称
    	if(downloadUrl!=null){
		  String saveName="temp.rcp";
		  int spl=downloadUrl.lastIndexOf('/');
		  if(spl!=-1){
			saveName=downloadUrl.substring(spl+1);
			if(saveName.endsWith(".rcp")){
			 SiteInfoBean bean=new SiteInfoBean(downloadUrl,getSaveFolder(),saveName,1);
			 SiteFileFetch job =new SiteFileFetch("下载", bean,new ICompleteListener() {
					public void complete(CAppInfo appInfo) {
						fireEvents(appInfo);
					}
				 });
			 job.setUser(true);
			 
			 job.schedule();
			}
		  }
    	}
    }
    /**
     * 将本地程序文件存储到应用程序目录下
     * @param file
     */
    public void downloadAppFromLocal(String filePath){
    	if(filePath!=null){
    		File file=new File(filePath);
    		if(file.exists()){
    		   String savePath=getSaveFolder()+"/"+file.getName();
    		   File saveFile=new File(savePath);
    		   //转移文件已经存在，是否覆盖
    		   if(!JFaceHelpMethod.checkOverWrite(savePath)){
       			return;
       		   }
    		   
    		   FileInputStream source=null;FileOutputStream out=null;
    		   try{
    		    source=new FileInputStream(file);
    		    out=new FileOutputStream(saveFile);
    		    int readNum=0;
    		    byte[] buf=new byte[1024];
    		    while((readNum=source.read(buf,0,buf.length))>0){
    		    	out.write(buf, 0, readNum);
    		    }
    		    out.flush();
    		    out.close();
    		    
    		   }catch(Exception e){
    			   String str="无法将"+file.getAbsolutePath()+"拷贝到"+getSaveFolder()+"目录";
    			   JFaceHelpMethod.showError(str);
    		   }finally{
    			   if(source!=null){
    				   try{source.close();}catch(Exception e){};
    			   }
    			   if(out!=null){
    				   try{out.flush();}catch(Exception e){};
    				   try{out.close();}catch(Exception e){};
    			   }
    		   }
    		}else{
    			JFaceHelpMethod.showInfo("文件"+filePath+"不存在");
    		}
    	}
    }
    private static List<CAppInfo> appPacks=null;
    /**
     * 返回所有程序包的信息
     * @return
     */
    public List<CAppInfo> getApps(){
    	
    	return appPacks;
    }
    
    /**
     * 删除指定路径下的打包程序
     * @param path
     */
    public void deleteAppPack(String path){
    	if(path!=null){
    		new File(path).delete();
    	}
    }
    private static List<CEventBean> eventBeans=new LinkedList<CEventBean>();
    /**
     * 
     * @param eventBean
     */
    public void addListener(CEventBean eventBean){
      if(eventBean!=null){
    	eventBeans.add(eventBean);
      }
    }
    /**
     * 唤醒flex监听器
     * @param appInfo
     */
    private void fireEvents(CAppInfo appInfo){
      if(appInfo!=null){
    	if(!appPacks.contains(appInfo)){
    	 appPacks.add(appInfo);
    	 List<CEventBean> listeners=eventBeans;
    	 for(int i=0;i<listeners.size();i++){
    		listeners.get(i).fireEvent(appInfo);
    	 }
    	}
      }
    }
    /**
     * 程序包的存储目录
     * @return
     */
    public static String getSaveFolder(){
    	String path=HelpMethods.getPluginFolder()+"/smartrcpPacks";
    	File folder=new File(path);
    	if(!folder.exists()){
    		folder.mkdirs();
    	}
    	return path;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}

	@Override
	public void dispose() {
		
	}

}
