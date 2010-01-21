
/*******************************************************************************
* Copyright (c) 2009 SmartInvoke.
* 你可以复制或修改此代码，但是必须在源代码和二进制包中添加申明以表示引用或修改了smartinvoke的代码
* 请珍惜作者的劳动成果* 您可以通过 
*  网站:http://smartinvoke.cn/ 
*  邮件:pzxiaoxiao130130@gmail.com
*  QQ：90636900*  联系到作者^_^ 
*******************************************************************************/ 
package cn.smartinvoke.exception;
/**
 * 对象调用异常
 * @author pengzhen
 *
 */
public class InvokeException extends RuntimeException {
	/**
	 *  A．调用对象不存在即调用对象为空异常，此时异常类型为 InvokObjectNull
        B. 调用对象上不存在相应的方法，此时的异常类型为 InvokMethodNull 
        C. 在调用方法上可能会抛出异常，此时的异常类型为 InvokMethodException
	 */
	public static final int TYPE_INVOK_OBJ_CREATE_FAULT=-1;
    public static final int TYPE_INVOK_OBJECT_NULL=0;
    public static final int TYPE_INVOK_METHOD_NULL=1;
    public static final int TYPE_INVOK_METHOD_EXCEPTION=2;
    private int type=TYPE_INVOK_OBJECT_NULL;
    private String msg;
	public InvokeException(int type,String msg) {
		this(msg);
		this.type=type;
		
	}
	public InvokeException(String message) {
		super(message);	
	}
	public InvokeException() {
		//super(message);	
	   
	}
	public void setMessage(String msg){
		System.out.println(msg +" in invokeException");
		this.msg=msg;
	}
	public InvokeException(Throwable cause) {
		super(cause);
	}
	public InvokeException(String message, Throwable cause) {
		super(message, cause);
	}
    public int getType(){
    	return this.type;
    }
    public String toXml(){
        StringBuffer buf=new StringBuffer("<e t=\"InvokException\" type=\""+this.type+"\">");
        buf.append(this.getMessage());
        buf.append("</e>");
    	return buf.toString();
    }
}
