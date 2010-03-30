
/*******************************************************************************
* Copyright (c) 2009 SmartInvoke.
* 你可以复制或修改此代码，但是必须在源代码和二进制包中添加申明以表示引用或修改了smartinvoke的代码
* 请珍惜作者的劳动成果* 您可以通过 
*  网站:http://smartinvoke.cn/ 
*  邮件:pzxiaoxiao130130@gmail.com
*  QQ：90636900*  联系到作者^_^ 
*******************************************************************************/ 
package cn.smartinvoke.exception;

public class Messages {
	public static final Messages INSTANCE=new Messages();
	
    public static final String Ivk_INVOK_OBJ_CREATE_FAULT="类型{0}创建失败，可能是对应类型不存在或默认构造函数不可见或未定义";
    public static final String IVK_OBJECT_NOT_FOUND="编号为{0}的对象为空";
    public static final String IVK_METHOD_NOT_FOUND="在类型{0}中的{1}方法不可见，没有定义或参数类型不匹配";
    public static final String IVK_METHOD_EXCEPTION="调用类型{0}中的{1}方法时抛出异常：{2}";
    public static final String ERROR_PACKAGE="报文错误";
	private Messages() {
	 	
	}
	public String getMsg(String key,String[] param){
		return getRealInfo(key, param);
	}
	/**
     * 将——你是{0}吗？我是{1}哟，哈哈{2} 这样的字符串，以values数组里对应的值取代对应的占位符，组合成新
     * 的字符串返回
     * @param msg
     * @param values
     * @return
     */
    private static String getRealInfo(String msg,String[] values){
    	StringBuffer ret=new StringBuffer(msg);
    	String arrayIndex="";
    	int msgIndex=0;
    	char startChar='{',endChar='}';
    	while(ret.length()>msgIndex){
    		int replStart=0,replEnd=0;
    		int index=0;
    		char ch=ret.charAt(msgIndex++);
    		if(ch==startChar){
    		   replStart=msgIndex-1;
    		   while((ch=ret.charAt(msgIndex++))!=endChar){
    			arrayIndex+=ch;
    		   }
    		   replEnd=msgIndex;
    		   try{
    			  index=Integer.valueOf(arrayIndex);
    			  if(index<values.length){
    			   ret.replace(replStart, replEnd, values[index]);
    			   arrayIndex="";
    			  }
    			  msgIndex+=values[index].length()-(replEnd-replStart);
    		   }catch(Throwable e){
    			   e.printStackTrace();
    		   }
    		}
    		
    	}
    	return ret.toString();
    }
}
