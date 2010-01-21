package cn.smartinvoke.smartrcp;

import cn.smartinvoke.IServiceObjectCreator;

public class MyServiceObjectCreator implements IServiceObjectCreator {

	public MyServiceObjectCreator() {
		
	}

	public Class getClass(String clsName)throws ClassNotFoundException {
		Class cls=Class.forName(clsName);
		return cls;
	}

}
