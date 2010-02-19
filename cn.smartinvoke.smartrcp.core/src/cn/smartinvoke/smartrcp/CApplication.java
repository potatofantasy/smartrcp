package cn.smartinvoke.smartrcp;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import cn.smartinvoke.IServerObject;
import cn.smartinvoke.gui.FlashContainer;
import cn.smartinvoke.gui.FlashViewer;
import cn.smartinvoke.gui.ObjectPool;
import cn.smartinvoke.rcp.CPerspective;
import cn.smartinvoke.smartrcp.gui.SplashWindow;
import cn.smartinvoke.smartrcp.gui.control.GlobalServiceId;

/**
 * 全局服务类，本类负责管理当前应用程序信息，和提供程序退出等一些实用方法
 * @author pengzhen
 *
 */
public class CApplication implements IServerObject {
    private Map<String,Object> dataMap=new HashMap<String, Object>();
	public CApplication() {
	   	
	}
	/**
	 * 获得程序的安装路径
	 * @return
	 */
	public String getBaseFolder(){
		return CPerspective.getRuntimeSwfFolder();
	}
	/**
	 * 退出程序
	 */
	public void exit(){
		PlatformUI.getWorkbench().close();
	}
	public void restart(){
		PlatformUI.getWorkbench().restart();
	}
	public String getRuntimeSwfPath(){
		return CPerspective.getRuntimeSWFPath();
	}
	private String debugPath;
	public void setDebugPath(String path){
		this.debugPath=path;
	}
	public String getDebugPath(){
		return this.debugPath;
	}
	public void setData(String key,Object data){
	   if(key!=null){
		 this.dataMap.put(key, data);
	   }
	}
	public void removeData(String key){
		if(key!=null){
			this.dataMap.remove(key);
		}
	}
	public Object getData(String key){
		//Object ret=null;
		if(key!=null){
			return this.dataMap.get(key);
		}else{
			return null;
		}
		//return ret;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	   	File f=null;
	   	f.list();
	   	
	}
	public void dispose() {
	   
	}
	//---------------------常用对话框
	public  boolean openConfirm(Shell mainShell,String title, String message) {
		//FlashViewer flashViewer=FlashViewer.getViewerByAppId(appId);
		//flashViewer.isBreak=true;
		
		//Shell mainShell=(Shell)ObjectPool.INSTANCE.getObject(GlobalServiceId.Swt_Main_Win);
		boolean ret= MessageDialog.openConfirm(mainShell, title, message);
		return ret;
	}
	public  void openError(Shell mainShell,String title, String message) {
		//Shell mainShell=(Shell)ObjectPool.INSTANCE.getObject(GlobalServiceId.Swt_Main_Win);
		MessageDialog.openError(mainShell, title, message);
	}
	public  void openInformation(Shell mainShell,String title, String message) {
		//Shell mainShell=(Shell)ObjectPool.INSTANCE.getObject(GlobalServiceId.Swt_Main_Win);
		MessageDialog.openInformation(mainShell, title, message);
	}
	public  boolean openQuestion(Shell mainShell,String title, String message) {
		//Shell mainShell=(Shell)ObjectPool.INSTANCE.getObject(GlobalServiceId.Swt_Main_Win);
		return MessageDialog.openQuestion(mainShell, title, message);
	}
	public  void openWarning(Shell mainShell,String title, String message) {
		//Shell mainShell=(Shell)ObjectPool.INSTANCE.getObject(GlobalServiceId.Swt_Main_Win);
		MessageDialog.openWarning(mainShell, title, message);
	}
}
