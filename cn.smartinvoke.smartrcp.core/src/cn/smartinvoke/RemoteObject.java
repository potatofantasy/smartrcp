package cn.smartinvoke;

import java.lang.reflect.Method;

import cn.smartinvoke.exception.InvokeException;
import cn.smartinvoke.exception.Messages;
public class RemoteObject {

	private FlashContainer flashContainer;
	private static String FLASH_CREATE_BEG = "<invoke name=\"create\" returntype=\"xml\"><arguments>";
	private static String FLASH_CALL_BEG = "<invoke name=\"call\" returntype=\"xml\"><arguments>";
	private static String FLASH_DISPOSE_BEG = "<invoke name=\"dispose\" returntype=\"xml\"><arguments>";
	private static String FLASH_SET_PROP_BEG = "<invoke name=\"setProperty\" returntype=\"xml\"><arguments>";
	private static String FLASH_GET_PROP_BEG = "<invoke name=\"getProperty\" returntype=\"xml\"><arguments>";
	private static String FLASH_CALL_END = "</arguments></invoke>";

	private String remoteId = null;
	//是否开启自动内存回收
    private boolean isAutoDispose=true;
	public RemoteObject(FlashContainer flashContainer) {
		this.flashContainer = flashContainer;
	}
	public RemoteObject(FlashContainer flashContainer,boolean isAutoDispose) {
		this(flashContainer);
		this.isAutoDispose=isAutoDispose;
	}
	/**
	 * 创建代理对象的静态方法，该方法用在服务端返回已经创建的服务对象的id的情况
	 * 
	 * @param objId
	 * @return
	 */
	public static Object createRemoteObject(FlashContainer container,
			String clsName, String objId) {
		Object ret = null;
		try {
			Class createCls = Class.forName(clsName);
			Object object = createCls.getConstructor(
					new Class[] { container.getClass() }).newInstance(
					new Object[] { container });
			ret = object;
			// 设置remoteId属性
			Method method = createCls.getMethod("setRemoteId",
					new Class[] { String.class });
			method.invoke(object, new Object[] { objId });
		} catch (Exception e) {// 对象创建异常
			throw new InvokeException(
					InvokeException.TYPE_INVOK_OBJ_CREATE_FAULT,
					Messages.INSTANCE.getMsg(
							Messages.Ivk_INVOK_OBJ_CREATE_FAULT,
							new String[] { clsName }));
		}
		return ret;
	}

	/**
	 * 返回所代理对象在服务端对象池中的id
	 * 
	 * @return
	 */
	public String getRemoteId() {
		return this.remoteId;
	}

	public void setRemoteId(String remoteId) {
		this.remoteId = remoteId;
	}
	public void createRemoteObject() {
		this.nativeCreateObject(this.getClass().getName(),null);
	}
    protected void nativeCreateObject(String clsName,Object[] pars){
    	
    	StringBuilder sb = new StringBuilder();
		sb.append(FLASH_CREATE_BEG).append("<string>");
		     sb.append(clsName);
		sb.append("</string>");
		sb.append(FLASH_CALL_END);
		
		String retPack = null;
		retPack=this.flashContainer.asyncCallFunction(sb.toString());
		
		Object ret=lllIIlllllllIIlI.getObject(retPack,this.flashContainer.getAppId());
		if(ret!=null){
		 String objId=(String)ret;
		 this.setRemoteId(objId);
		}
		
    }
    
	/**
	 * 调用所代理对象的制定方法，并传入制定参数
	 * 
	 * @param methodName
	 * @param pars
	 * @return 调用的返回
	 * 
	 * <call objId="123" method="getName"> <l n="0">123</l> <str n="1">adsfasdf</str>
	 * </call>
	 */
	public Object call(String methodName, Object[] pars) {
		return this.nativeCall(methodName, pars, true); 
	}

	public Object asyncCall(String methodName, Object[] pars) {
       return this.nativeCall(methodName, pars, false); 
	}
	/**
     * 设置属性
     * @param name
     * @param value
     */
    protected void setProperty(String name,Object value){
    	StringBuilder pack = new StringBuilder();
		pack.append(FLASH_SET_PROP_BEG).append("<string>");
		
		Object[] params=new Object[]{this.getRemoteId(),name,value};
		pack.append(lllIIlllllllIIlI.getProtocolStr(params,this.flashContainer.getAppId()));
		pack.append("</string>");
		pack.append(FLASH_CALL_END);
		String retPack=null;
		
		retPack=this.flashContainer.asyncCallFunction(pack.toString());
		//检查是否发生异常
		lllIIlllllllIIlI.getObject(retPack,this.flashContainer.getAppId());
    }
    /**
     * 获取指定属性值，如果返回void则为空
     * @param name 属性名称
     * @return
     */
    protected Object getProperty(String name){
		StringBuilder pack = new StringBuilder();
		pack.append(FLASH_GET_PROP_BEG);
		
		pack.append("<string>");
		Object[] params=new Object[]{this.getRemoteId(),name};
		pack.append(lllIIlllllllIIlI.getProtocolStr(params,this.flashContainer.getAppId()));
		
		pack.append("</string>");
		
		pack.append(FLASH_CALL_END);
		String retPack=this.flashContainer.asyncCallFunction(pack.toString());
		Object retObj=lllIIlllllllIIlI.getObject(retPack,this.flashContainer.getAppId());
		return retObj;
    }
    protected Object nativeCall(String methodName,Object[] pars,boolean isAsync){
		StringBuilder pack = new StringBuilder();
		pack.append(FLASH_CALL_BEG).append("<string>");
		Object[] params=new Object[]{this.getRemoteId(),methodName,pars,isAsync};
		pack.append(lllIIlllllllIIlI.getProtocolStr(params,this.flashContainer.getAppId()));
		pack.append("</string>");
		
		pack.append(FLASH_CALL_END);
		String retPack=null;
		
		retPack=this.flashContainer.asyncCallFunction(pack.toString());
		return lllIIlllllllIIlI.getObject(retPack,this.flashContainer.getAppId());
    }
	/**
	 * 对象被销毁时调用的方法，当对象池中对象失去引用时，此方法会被调用以回收内存
	 */
	protected void finalize() {
	  if(this.isAutoDispose){
		this.dispose();
	  }
	}
	public void dispose(){
		StringBuilder pack = new StringBuilder(FLASH_DISPOSE_BEG);
		pack.append("<string>");
		pack.append(this.getRemoteId());
		System.out.println("RemoteObject disposeId="+this.getRemoteId());
		pack.append("</string>");
		pack.append(FLASH_CALL_END);
		this.flashContainer.asyncCallFunction(pack.toString());
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("ab");
		sb.insert(0, "111");
		System.out.println(sb);
		String str1 = "ab";
		String str2 = "ab";
		System.out.println(str1 == str2);
	}

}
