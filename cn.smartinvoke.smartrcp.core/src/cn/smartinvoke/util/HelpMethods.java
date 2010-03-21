
/*******************************************************************************
* Copyright (c) 2009 SmartInvoke.
* 你可以复制或修改此代码，但是必须在源代码和二进制包中添加申明以表示引用或修改了smartinvoke的代码
* 请珍惜作者的劳动成果* 您可以通过 
*  网站:http://smartinvoke.cn/ 
*  邮件:pzxiaoxiao130130@gmail.com
*  QQ：90636900*  联系到作者^_^ 
*******************************************************************************/ 
package cn.smartinvoke.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

public class HelpMethods {
	private static String installFolder=null;
	public static String getPluginFolder(){
	   if(installFolder==null){
		String ret=null;
		try {
			ret = Path.getPathFromClass(ConfigerLoader.class);
			int sp=ret.lastIndexOf(File.separatorChar);
			if(sp!=-1){
			 ret=ret.substring(0,sp);
			 ret=ret.replace(File.separatorChar, '/');
			}
			installFolder=ret;
		} catch (IOException e) {
			e.printStackTrace();
		}
	   }
		return installFolder;
	}
	public static String getStringFromFile(String filePath) {
		StringBuffer ret = new StringBuffer();
		File file = new File(filePath);
		FileReader fr = null;
		try {
			fr = new FileReader(filePath);
			BufferedReader br=new BufferedReader(fr);
			char[] bs=new char[(int)file.length()];
			int redCount=br.read(bs);
			ret.append(bs, 0, redCount);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(fr!=null){
				try{fr.close();}catch(Exception e ){};
			}
		}
		return ret.toString();
	}
	public static void showError(Shell shell,String info){
		   if(shell!=null){
			   MessageBox message = new MessageBox(shell);
				message.setText("信息");
				message.setMessage(info);
				message.open();
		   }
	}
	/**
	 * 将字符串设置为len长度，如果不够用空白补足，超出则删除
	 * 
	 * @param str
	 * @param len
	 * @return
	 */
	public static String addRightSpace(String str, int len) {
		int orgLen = str.length();
		int spaceCount = len - orgLen;
		if (spaceCount > 0) {
			for (int i = 0; i < spaceCount; i++) {
              str+=" ";
			}
		} else {
			 str = str.substring(0, len);
		}
		return str;
	}
	public static Constructor getConstructor(Class cls, Object[] params) {
		Constructor ret = null;
		if (params == null) {
			params = new Object[0];
		}
		List<Constructor> res = new LinkedList<Constructor>();
		Constructor[] cons = cls.getConstructors();
		for (Constructor con : cons) {
			Class[] paramTypes = con.getParameterTypes();
			if (params.length == paramTypes.length) {// 参数个数相同
				StringBuilder inputParamTypeBuf = new StringBuilder(), methodParamTypeBuf = new StringBuilder();
				// 构造并比较参数类型符串是否相同
				int len = params.length;
				for (int i = 0; i < len; i++) {
					Object inputParamObj = params[i];
					if (inputParamObj != null) {
						  Class inputParamCls=inputParamObj.getClass();
						  boolean inputPrim=false;
						  if(inputParamObj instanceof Number){
							  inputPrim=true;
						  }else if(inputParamObj instanceof Boolean){
							  inputPrim=true;
						  }
						  boolean paramPrim=false;
						  if(isSubClass(paramTypes[i],Number.class)){
							  paramPrim=true;
						  }
						  if(isSubClass(paramTypes[i],Boolean.class)){
							  paramPrim=true;
						  }
						  boolean isPrimitiveType=inputPrim&&(paramPrim ||paramTypes[i].isPrimitive());
						  if(!isPrimitiveType){//不是基本类型
							 char chi='*',chm='&';
							 if(isSubClass(inputParamCls,paramTypes[i])){//输入类型是方法类型的子类则匹配
								 chm=chi;
							 }
							 inputParamTypeBuf.append(chi).append(' ');
							 methodParamTypeBuf.append(chm).append(' ');
						  }else{//比较基本类型
							String typeStr = getPrimitiveTypeStr(inputParamCls);
							inputParamTypeBuf.append(typeStr).append(' ');
							typeStr =getPrimitiveTypeStr(paramTypes[i]);
							methodParamTypeBuf.append(typeStr).append(' ');
						  }
					}
				}
				if (inputParamTypeBuf.toString().equals(
						methodParamTypeBuf.toString())) {
					res.add(con);
				}
			}
		}
		if (res.size() == 0) {
			int len = params.length;
			StringBuilder inputParamTypeBuf = new StringBuilder();
			for (int i = 0; i < len; i++) {
				Object inputParamObj = params[i];
				if (inputParamObj != null) {
					inputParamTypeBuf.append(inputParamObj.getClass().getName()).append(
							' ');
				} else {
					inputParamTypeBuf.append("null ");
				}
			}
			throw new RuntimeException("在类" + cls.getName() + " 中找不到构造函数(" + inputParamTypeBuf + ")");
		} else if (res.size() > 1) {
			throw new RuntimeException("在类" + cls.getName() + " 中找不到构造函数存在歧义（不止有一个构造函数符合调用签名）");
		} else {
			ret = res.get(0);
		}
		//System.out.println(ret.toGenericString());
		return ret;
	}

	/**
	 * 
	 * @param cls
	 *            寻找方法所在的类型对象
	 * @param name
	 *            方法的名称
	 * @param params
	 *            方法的调用参数，如果为空就调用没参数的方法
	 * @return
	 */
	public static Method getMethod(Class cls, String name, Object[] params) {
		Method ret = null;
		if (params == null) {
			params = new Object[0];
		}
		Method[] methods = cls.getMethods();
		List<Method> res = new LinkedList<Method>();
		for (Method method : methods) {
			if (method.getName().equals(name)) {// 方法名称相同
				Class[] paramTypes = method.getParameterTypes();
				if (params.length == paramTypes.length) {// 参数个数相同
					StringBuilder inputParamTypeBuf = new StringBuilder(), methodParamTypeBuf = new StringBuilder();
					// 构造并比较参数类型符串是否相同
					int len = params.length;
					for (int i = 0; i < len; i++) {
						Object inputParamObj = params[i];
						if (inputParamObj != null) {
						  Class inputParamCls=inputParamObj.getClass();
						  boolean inputPrim=false;
						  if(inputParamObj instanceof Number){
							  inputPrim=true;
						  }else if(inputParamObj instanceof Boolean){
							  inputPrim=true;
						  }
						  boolean paramPrim=false;
						  if(isSubClass(paramTypes[i],Number.class)){
							  paramPrim=true;
						  }
						  if(isSubClass(paramTypes[i],Boolean.class)){
							  paramPrim=true;
						  }
						  boolean isPrimitiveType=inputPrim&&(paramPrim ||paramTypes[i].isPrimitive());
						  if(!isPrimitiveType){//不是基本类型
							 char chi='*',chm='&';
							 if(isSubClass(inputParamCls,paramTypes[i])){
								 chm=chi;
							 }
							 inputParamTypeBuf.append(chi).append(' ');
							 methodParamTypeBuf.append(chm).append(' ');
						  }else{//比较基本类型
							String typeStr =getPrimitiveTypeStr(inputParamCls);
							inputParamTypeBuf.append(typeStr).append(' ');
							typeStr =getPrimitiveTypeStr(paramTypes[i]);
							methodParamTypeBuf.append(typeStr).append(' ');
						  }
						}
					}
					if (inputParamTypeBuf.toString().equals(
							methodParamTypeBuf.toString())) {
						res.add(method);
					}
				}
			}
		}
		if (res.size() == 0) {
			int len = params.length;
			StringBuilder inputParamTypeBuf = new StringBuilder();
			for (int i = 0; i < len; i++) {
				Object inputParamObj = params[i];
				if (inputParamObj != null) {
					inputParamTypeBuf.append(inputParamObj.getClass().getName()).append(
							' ');
				} else {
					inputParamTypeBuf.append("null ");
				}
			}
			throw new RuntimeException("在类" + cls.getName() + " 找不到方法 " + name
					+ "(" + inputParamTypeBuf + ")");
		} else if (res.size() > 1) {
			throw new RuntimeException("对类" + cls.getName() + " 上的名称为" + name
					+ "的方法调用存在歧义（不止有一个方法符合调用签名）");
		} else {
			ret = res.get(0);
		}
		//System.out.println(ret.toGenericString());
		return ret;
	}
	public static boolean isSubClass(Class subClass,Class supClass){
		boolean ret=false;
		if(subClass!=null && supClass!=null){
		   String supClsName=supClass.getName();
		   String objClsName="java.lang.Object";
		   if(subClass.getName().equals(supClsName)){//类名称是一致的
			   return true;
		   }
		   if(supClsName.equals(objClsName)){//如果超类是Object肯定符合
			   return true;
		   }
		   Class tempSup=subClass;
		   while(true){
			   tempSup=tempSup.getSuperclass();
			   if(tempSup==null){
				   break;
			   }
			   String tempName=tempSup.getName();
			   if(tempName.equals(supClsName)){//匹配
					  return true;
			   }else if(tempName.equals(objClsName)){//找到最顶层
				   break;
			   }
		   }
		   //检查接口
		   List<Class> supInterfList=new LinkedList<Class>();
		   addInterfClsToList(subClass,supInterfList);
		   for(Class supInterf:supInterfList){
			   if(supInterf.getName().equals(supClsName)){
				   return true;
			   }
		   }
		}
		return ret;
	}
	/**
	 * 将当前类继承的所有接口添加到List
	 * @param curCls
	 * @param list
	 */
	private static void addInterfClsToList(Class curCls, List<Class> list){
		Class[] interfs=curCls.getInterfaces();
		if(interfs==null){
			return;
		}
		for(Class interf:interfs){
		 list.add(interf);
		 addInterfClsToList(interf,list);//添加接口的父接口
		}
	}
	  public static String getPrimitiveTypeStr(Class cls){
			 String val=cls.getName();
			 if(cls.isPrimitive()){
				 String name=cls.getName();
				 if(name.equals("boolean")){
					 val="java.lang.Boolean";
				 }else if(name.equals("byte")){
					 val="java.lang.Byte";
				 }if(name.equals("short")){
					 val="java.lang.Short";
				 }if(name.equals("int")){
					 val="java.lang.Integer";
				 }if(name.equals("long")){
					 val="java.lang.Long";
				 }if(name.equals("float")){
					 val="java.lang.Float";
				 }if(name.equals("double")){
					 val="java.lang.Double";
				 }
			 }
			 return val;
		  }
	public static void main(String[] args) {
		
	}
}
