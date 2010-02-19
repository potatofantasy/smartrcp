package test;

import java.lang.reflect.Method;

public class RefTest {
    public static String getStaticInfo(){
    	return "static Info";
    }
	public RefTest() {
		
	}
    protected String getInfo(){
    	return "hello";
    }
	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		RefTest refTest=new RefTest();
		Method method=RefTest.class.getDeclaredMethod("getInfo", null);
		method.setAccessible(true);
		System.out.println(method.invoke(refTest, null));
		
	}

}
