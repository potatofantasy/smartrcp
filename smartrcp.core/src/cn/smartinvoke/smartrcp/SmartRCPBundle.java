package cn.smartinvoke.smartrcp;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.service.packageadmin.PackageAdmin;

import cn.smartinvoke.smartrcp.app.pack.CAppInfo;
import cn.smartinvoke.smartrcp.core.SmartRCPBuilder;
import cn.smartinvoke.smartrcp.util.BundleHelpMethod;
import cn.smartinvoke.util.Log;

/**
 * 维护一个运行的smatrcp应用程序的信息，
 * 比如：当前程序所加载的库，程序信息
 * @author pengzhen
 *
 */
public class SmartRCPBundle{
	//该smartrcp程序所加载的所有bundles jar
    private List<Bundle> bundles=new  LinkedList<Bundle>();
    /**
     * 应用程序信息类，维护了应用程序的安装路径swf文件路径等配置信息
     */
    private CAppInfo appInfo;
	public SmartRCPBundle(CAppInfo appInfo){
	  this.appInfo=appInfo;
	}
	public CAppInfo getAppInfo() {
		return appInfo;
	}
	/**
	 *加载当前程序到内存
	 */
    public void load()throws BundleException{
       File libFolder=new File(this.appInfo.basePath+File.separator+"lib");
       this.bundles=BundleHelpMethod.installBundles(libFolder);
    }
    /**
     *从内存中拆卸当前程序
     * @throws BundleException 
     */
    public void unLoad() throws BundleException{
    	//以启动leve的反方向拆卸bundle
    	for(int i=bundles.size()-1;i>=0;i--){
    		Bundle bundle=bundles.get(i);
    		Log.println("unLoad bundle jar:"+bundle);
    		bundle.uninstall();
    	}
    }
    /**
     * 现在并加载url上的osgi bundle jar
     * @param url
     */
    public void loadBundle(String url){
    	
    }
    public static void main(String[] args) {
    	
	}
}
