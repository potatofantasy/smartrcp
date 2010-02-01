package cn.smartinvoke.smartrcp;

import cn.smartinvoke.IServiceObjectCreator;

public class MyServiceObjectCreator implements IServiceObjectCreator {

	public MyServiceObjectCreator() {
		
	}

	public Class getClass(String clsName)throws ClassNotFoundException {
		System.out.println("c");
		try{
		Class cls=Class.forName(clsName);
		return cls;
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			throw e;
		}
	}

}
