package cn.smartinvoke.smartrcp;

import cn.smartinvoke.IServiceObjectCreator;
import cn.smartinvoke.util.Log;

public class MyServiceObjectCreator implements IServiceObjectCreator {

	public MyServiceObjectCreator() {
		
	}

	public Class getClass(String clsName)throws ClassNotFoundException {
		Log.println("创建服务类"+clsName+"的对象");
		try{
		Class cls=Class.forName(clsName);
		return cls;
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			throw e;
		}
	}

}
