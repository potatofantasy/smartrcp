package cn.smartinvoke.rcp;

import java.io.File;

import cn.smartinvoke.util.ConfigerLoader;
import cn.smartinvoke.util.HelpMethods;

public class CPerspective {
	/**
	 *splash=main.swf
      splash-size=300*300
      runtime=runtime.swf
	 */
	private static String splashSwfPath=null,runtimeSwf;
	private static int[] splashSize;
	//private static String installFolder;
	public static void init()throws Exception{
		ConfigerLoader.init();
		
		String installFolder=HelpMethods.getPluginFolder();//安装目录
		//
		String splashSwfPath=ConfigerLoader.getProperty(ConfigerLoader.key_splash);
		if(splashSwfPath==null){
			throw new Exception(ConfigerLoader.key_splash+"is not exist in "+ConfigerLoader.configPath);
		}
		if(splashSwfPath.charAt(0)=='/'){//相对路径
			CPerspective.splashSwfPath=installFolder+splashSwfPath;
		}else{
			CPerspective.splashSwfPath=splashSwfPath;
		}
		if(!new File(CPerspective.splashSwfPath).exists()){//splash文件不存在
			throw new Exception("the splash swf file "+splashSwfPath+" is not exist");
		}
		//
		String runtimeSwf=ConfigerLoader.getProperty(ConfigerLoader.key_runtime);
		if(runtimeSwf==null){
			throw new Exception(ConfigerLoader.key_runtime+"is not exist in "+ConfigerLoader.configPath);
		}
		if(runtimeSwf.charAt(0)=='/'){
			CPerspective.runtimeSwf=installFolder+runtimeSwf;
		}else{
		    CPerspective.runtimeSwf=runtimeSwf;
		}
		if(!new File(CPerspective.runtimeSwf).exists()){//runtime文件不存在
			throw new Exception("the runtime swf file "+runtimeSwf+" is not exist");
		}
		
		int def_w=400,def_h=300;
		int[] splashSize=new int[]{def_w,def_h};
		String sizeStr=ConfigerLoader.getProperty(ConfigerLoader.key_splash_size);
		if(sizeStr==null || sizeStr.trim().length()==0){
			splashSize[0]=def_w;splashSize[1]=def_h;
		}else{
			int sp=sizeStr.indexOf('*');
			if(sp==-1){
				throw new Exception("the splash-size's value must be the format like 300*300");
			}else{
				try{
				 int w=Integer.valueOf(sizeStr.substring(0,sp));
				 int h=Integer.valueOf(sizeStr.substring(sp+1));
				 splashSize[0]=w;splashSize[1]=h;
				}catch(Throwable e){throw new Exception("the splash-size's value must be the format like 300*300");};
			}
		}
		CPerspective.splashSize=splashSize;
		
	}
	public static String getRuntimeSWFPath(){
		return CPerspective.runtimeSwf;
	}
	public static String getSplashSwfPath(){
		return splashSwfPath;
	}
	public static int[] getSplashSize(){
		return CPerspective.splashSize;
	}
	public static String  getRuntimeSwfFolder(){
		int sp=runtimeSwf.lastIndexOf('/');
		return runtimeSwf.substring(0,sp);
	}
    //public static CPageLayout pageLayout=null;
	public CPerspective() {
		super();
	}
	/**
	 * 是否保存工作台状态
	 */
	public boolean saveAndRestore=false;
	public Object[] actions=null;
	public Object[] menuBars;
	public CToolBar toolBar;
	public  CWindowConfigurer windowConfigurer;
	public CPageLayout page;
}
