package cn.smartinvoke.smartrcp.app.pack;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import cn.smartinvoke.rcp.ErrorMessages;
import cn.smartinvoke.util.ConfigerLoader;

/**
 * 应用程序打包类
 * @author pengzhen
 */
public class PackageTool {

	public PackageTool() {
	   	
	}
	/**
	 * 压缩程序
	 * @param appInfo  应用程序信息类
	 * @param savePath 文件保存目录
	 */
	public void compress(CAppInfo appInfo,String saveFolder){
		if(appInfo!=null && saveFolder!=null){
		  DataOutputStream out=null;
		  try{
			String fileName=appInfo.name+"_"+appInfo.version+".rcp";
		    out=new DataOutputStream(new FileOutputStream(saveFolder+File.separator+fileName));
		    appInfo.init();
		    out.writeUTF(appInfo.name);
		    out.writeUTF(appInfo.version); 
		    out.writeUTF(appInfo.provider);
		    out.writeUTF(appInfo.updateUrl);//更新地址
		    out.writeUTF(appInfo.describe);
		    //压缩logo.png
		    if(appInfo.logoPath==null){//没有logo文件
		    	out.writeBoolean(false);
		    }else{
		    	out.writeBoolean(true);
		    	saveFileData(appInfo.logoPath,out);
		    }
		    //压缩main.swf路径
		    out.writeUTF(appInfo.mainSwfPath);
		    //压缩splash.swf路径
		    out.writeUTF(appInfo.splashSwfPath);
		    //压缩模块文件
		    this.saveListFiles(appInfo,appInfo.modules, out);
		    //压缩图标文件集合
		    List<String> icons=appInfo.icons;
		    
		    this.saveListFiles(appInfo,icons, out);
		    //压缩扩展库信息
		    List<String> libPaths=appInfo.getLibs();
		    //写入扩展库的个数
		    out.writeInt(libPaths.size());
		    for(int i=0;i<libPaths.size();i++){
		       	String libPath=libPaths.get(i);
		       	//写入文件名称
		       	out.writeUTF(i+"_"+new File(libPath).getName());
		       	//写入文件内容
		       	saveFileData(libPath,out);
		    }
		    //启动界面大小
		    out.writeInt(appInfo.splashWidth);out.writeInt(appInfo.splashHeight);
		  }catch(Exception e){
			  throw new RuntimeException(ErrorMessages.Compress_Error+e.getMessage());
		  }finally{
			  if(out!=null){
				  try{out.flush();}catch(Exception e){};
				  try{out.close();}catch(Exception e){};
			  }
		  }
		}
	}
	private void saveListFiles(CAppInfo appInfo,List<String> list,DataOutputStream out)throws Exception{
		if(list==null){
			list=new LinkedList<String>();
		}
		out.writeInt(list.size());
	    for(int i=0;i<list.size();i++){
	    	String path=list.get(i);
	    	out.writeUTF(path);//写入文件名称
	    	this.saveFileData(appInfo.basePath+path, out);//写入文件内容
	    }
	}
	private void saveFileData(String filePath,DataOutputStream out)throws Exception{
		File file=new File(filePath);
		FileInputStream in=new FileInputStream(filePath);
		byte[] bts=new byte[(int)file.length()];
		int readedNum=0;
		int fileSize=(int)file.length();
		
		while(true){
			int curReaded=in.read(bts, readedNum,fileSize-readedNum);
			if(curReaded==0){
				break;
			}else{
				readedNum+=curReaded;
			}
		}
		out.writeInt(bts.length);
		out.write(bts,0,bts.length);
		out.flush();
	}
	/**
	 * 从打包文件中读取基本信息
	 * @param appFilePath
	 * @return
	 */
	public static CAppInfo readBasicInfo(String appFilePath){
		CAppInfo appInfo=new CAppInfo();
		DataInputStream in=null;
		try{
		  in=new DataInputStream(new FileInputStream(appFilePath));
		  appInfo.name=in.readUTF();
		  appInfo.version=in.readUTF();
		  //读取提供者，更新地址
		  appInfo.provider=in.readUTF();
		  appInfo.updateUrl=in.readUTF();
		  //读取程序描述信息
		  appInfo.describe=in.readUTF();
		  //赋值绝对路径
		  appInfo.packLocation=appFilePath;
		}catch(Exception e){
		  throw new RuntimeException(ErrorMessages.Uncompress_Error+e.getMessage());
		}finally{
		  if(in!=null){
			  try{in.close();}catch(Exception e){};
		  }
		}
		return appInfo;
	}
	/**
	 * 获取appFilePath位置处的程序文件，并将该文件解压缩
	 * @param appFilePath 本地文件路径
	 * @param targetPath 释放的目标路径
	 */
	public CAppInfo uncompress(String appFilePath,String targetPath){
		DataInputStream in=null;
		CAppInfo appInfo=null;
		try{
		  in=new DataInputStream(new FileInputStream(appFilePath));
		  appInfo=new CAppInfo();
		  appInfo.name=in.readUTF();
		  appInfo.version=in.readUTF();
		  //读取提供者，更新地址
		  appInfo.provider=in.readUTF();
		  appInfo.updateUrl=in.readUTF();
		  //读取程序描述信息
		  appInfo.describe=in.readUTF();
		  
		  //创建程序目录
		  String appFolderStr=targetPath+File.separator+appInfo.name+"_"+appInfo.version;
		  File appFolder=new File(appFolderStr);
		  appFolder.mkdirs();
		  appInfo.basePath=appFolderStr;
		  //解压logo.png
		  if(in.readBoolean()){//如果有logo文件
		   String logoStr=appFolderStr+File.separator+"logo.png";
		   this.writeFileData(logoStr, in);
		  }
		  //解压main.swf文件
		  String mainStr=in.readUTF();//main.swf完整路径
		  appInfo.mainSwfPath=mainStr;
		  //this.writeFileData(mainStr, in);
		  //解压plash.swf文件
		  String splashStr=in.readUTF();//splash.swf完整路径
		  appInfo.splashSwfPath=splashStr;
		  //this.writeFileData(splashStr, in);
		  //解压模块文件与图标文件
		  this.writeFileList(appFolderStr,in);
		  //解压扩展库信息
		  String libSavePath=appFolderStr+File.separator+"/lib";
		  new File(libSavePath).mkdirs();//扩展库存储目录
		  int libNum=in.readInt();
		  for(int i=0;i<libNum;i++){
			  String libName=in.readUTF();
			  this.writeFileData(libSavePath+"/"+libName, in);
		  }
		  //解压配置文件
		  this.writeConfigFile(appFolderStr,appInfo,in);
		  //存储配置信息到property.prop文件
		  writePropertyFile(appFolderStr,appInfo);
		}catch(Exception e){
			throw new RuntimeException(ErrorMessages.Uncompress_Error+e.getMessage());
		}finally{
			if(in!=null){
				try{in.close();}catch(Exception e){};
			}
		}
		return appInfo;
	}
	private void writeFileList(String appFolderStr,DataInputStream in)throws Exception{
	    //uncompress模块文件
		int moudleNum=in.readInt();
		for(int i=0;i<moudleNum;i++){
			String subPathStr=in.readUTF();
			writeFileData(appFolderStr+subPathStr,in);
		}
		//uncompress图标文件
		moudleNum=in.readInt();
		for(int i=0;i<moudleNum;i++){
			String subPathStr=in.readUTF();
			writeFileData(appFolderStr+subPathStr,in);
		}
	}
	/**
	 * 解压config.ini配置文件
	 * @param appFolderStr
	 * @param in
	 * @throws Exception
	 */
	private void writeConfigFile(String appFolderStr,CAppInfo appInfo,DataInputStream in)throws Exception{
		int width=in.readInt();int height=in.readInt();
		appInfo.splashWidth=width;appInfo.splashHeight=height;
		
		String configFilePath=appFolderStr+File.separator+Key_Config_File;
		FileWriter fileWriter=new FileWriter(configFilePath);
		fileWriter.write(ConfigerLoader.key_splash+"="+appInfo.splashSwfPath+"\r\n");
		fileWriter.write(ConfigerLoader.key_splash_size+"="+width+"*"+height+"\r\n");
		fileWriter.write(ConfigerLoader.key_runtime+"="+appInfo.mainSwfPath+"\r\n");
		fileWriter.flush();
		fileWriter.close();
	}
	public static final String Key_Modules_Folder="modules";
	public static final String Key_Icons_Folder="icons";
	
	public static final String Key_Config_File="config.ini";
	public static final String Key_Property_File="property.prop";
	/**
	 * 将程序的属性信息写入到熟悉文件中
	 * @param appFolderStr
	 * @param appInfo
	 */
	private void writePropertyFile(String appFolderStr,CAppInfo appInfo)throws Exception{
		String path=appFolderStr+File.separator+Key_Property_File;
		File propFile=new File(path);
		propFile.createNewFile();
		DataOutputStream out=null;
		try{
		 out=new DataOutputStream(new FileOutputStream(propFile));
		 out.writeUTF(appInfo.name);
		 out.writeUTF(appInfo.version); 
		 out.writeUTF(appInfo.provider);
		 out.writeUTF(appInfo.updateUrl);//更新地址
		 out.writeUTF(appInfo.describe);
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			if(out!=null){
				out.flush();
				out.close();
			}
		}
	}
	private void writeFileData(String toPath,DataInputStream in)throws Exception{
		int len=in.readInt();
		FileOutputStream fileOut=null;
		try{
		  File toFile=new File(toPath);
		  toFile.getParentFile().mkdirs();
		  fileOut=new FileOutputStream(toPath);
		  //读取数据
		  byte[] bts=new byte[len];
		  int readedNum=0;
		  while(true){
			int curReaded=in.read(bts, readedNum,len-readedNum);
			readedNum+=curReaded;
			if(readedNum>=len){
					break;
			}
		  }
		  //写入数据到文件
		  fileOut.write(bts);
		}finally{
		  if(fileOut!=null){
			  fileOut.flush();
			  fileOut.close();
		  }
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		unCompress();
		//compress();
	}
	static void unCompress(){
		new PackageTool().uncompress("C:/DBExplorer_2010-03-18.rcp", "C:/rcp");
	}
	static void compress(){
		CAppInfo appInfo=new CAppInfo();
	   	appInfo.basePath="D:/temp/dbExplorer";
	   	appInfo.name="DBExplorer";
	   	appInfo.version="2010-03-18";
	   	appInfo.provider="smartDB";
	   	appInfo.describe="data base explorer";
	   	//appInfo.logoPath="C:/smartrcp.png";
	   	appInfo.mainSwfPath="D:/temp/dbExplorer/modules/main.swf";
	   	appInfo.splashSwfPath="D:/temp/dbExplorer/modules/DBSplash.swf";
	   	appInfo.splashWidth=300;appInfo.splashHeight=300;
	   	
	   	appInfo.addLib("D:/temp/com.mysql.jdbc.Driver_1.0.0.201003301725.jar");
	   	
	   	new PackageTool().compress(appInfo, "C:");
	}

}
