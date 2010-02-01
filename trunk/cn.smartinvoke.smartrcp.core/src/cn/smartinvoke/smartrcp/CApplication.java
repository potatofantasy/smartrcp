package cn.smartinvoke.smartrcp;

import java.io.File;

import org.eclipse.core.runtime.adaptor.EclipseStarter;
import org.eclipse.ui.PlatformUI;
import org.osgi.service.application.ApplicationDescriptor;

import cn.smartinvoke.IServerObject;
import cn.smartinvoke.rcp.CPerspective;

/**
 * 全局服务类，本类负责管理当前应用程序信息，和提供程序退出等一些实用方法
 * @author pengzhen
 *
 */
public class CApplication implements IServerObject {

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
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	   	File f=null;
	   	f.list();
	   	
	}
	public void dispose() {
	   
	}
}
