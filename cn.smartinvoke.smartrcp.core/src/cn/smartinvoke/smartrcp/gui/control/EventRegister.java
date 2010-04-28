package cn.smartinvoke.smartrcp.gui.control;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarInputStream;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;

import cn.smartinvoke.IServerObject;
import cn.smartinvoke.smartrcp.gui.module.CEventBean;
import cn.smartinvoke.util.Log;

/**
 * 事件注册器
 * @author pengzhen
 * 
 */
public class EventRegister implements IServerObject{
	//控件池
    private Map<Object,ListenerEntity> widgetmap=new HashMap<Object, ListenerEntity>();
    //display全局监听器
    public final ListenerEntity globalListenerEntity=new ListenerEntity();
	public EventRegister() {
		
	}
	public ListenerEntity getListenerEntity(Object widget){
		if(widget==null){
			return null;
		}else{
		    return widgetmap.get(widget);
		}
	}
	/**
	 * 给指定控件添加一指定类型的监听器
	 * @param widget
	 * @param eventType
	 * @param listenerId
	 */
    public void addListener(Object widget,int eventType,CEventBean bean){
    	if(widget!=null){//是全局Display的监听
    	   Display curDisplay=Display.getCurrent();
    	   if(curDisplay!=null){
    		   if((widget.equals(curDisplay)) && bean!=null && eventType!=0 ){
    			   List listenerList=globalListenerEntity.listeners[eventType];
    			   if(!listenerList.contains(bean)){//避免同一监听器调用两次
    	    			listenerList.add(bean);
    	    	   }
    			   return;
    		   }
    	   }
    	}
    	if(widget!=null && bean!=null && eventType!=0){
    		ListenerEntity entity=widgetmap.get(widget);
    		if(entity==null){
    			entity=new ListenerEntity();
    			widgetmap.put(widget, entity);
    		}
    		List listenerList=entity.listeners[eventType];
    		if(!listenerList.contains(bean)){//避免同一监听器调用两次
    			listenerList.add(bean);
    		}
    	}
    	Log.print("globalListenerEntity="+globalListenerEntity+"  ");
    	Log.print("widgetmap="+widgetmap+"  ");
    }
    /**
	 * 从指定控件上删除一指定的监听器
	 * @param widget
	 * @param eventType
	 * @param listenerId
	 */
    public void removeListener(Object widget,int eventType,CEventBean bean){
    	
    	if(widget!=null && bean!=null && eventType!=0){
    		ListenerEntity entity=null;
    		Display curDisplay=Display.getCurrent();
     	    if(curDisplay!=null){
     		   if(widget.equals(curDisplay)){
     			 entity=globalListenerEntity;
     		   }
     	    }
     	    if(entity==null){
     	      entity=widgetmap.get(widget);
     	    }
    		if(entity!=null){
    			entity.listeners[eventType].remove(bean);
    		}
    	}
        
    	Log.print("globalListenerEntity="+globalListenerEntity+"  ");
    	Log.print("widgetmap="+widgetmap+"  ");
    }
    /**
     * 删除指定appId下的所有监听器对象
     * @param appId
     */
    public void removeListeners(String appId){
    	if(appId==null){
    		return;
    	}
    	this.removeFromListenerEntity(this.globalListenerEntity, appId);
    	Iterator<Object> keys=this.widgetmap.keySet().iterator();
    	while(keys.hasNext()){
    		Object key=keys.next();
    		this.removeFromListenerEntity(this.widgetmap.get(key), appId);
    	}
    }
    private void removeFromListenerEntity(ListenerEntity entity,String appId){
    	if(entity!=null){
    		
    		List[] evtLis=entity.listeners;
    		for(int i=0;i<evtLis.length;i++){
    			List listeners=evtLis[i];
    			if(listeners!=null){
    			   for(int l=0;l<listeners.size();l++){
    				   Object beanObj=listeners.get(l); 
    				   if(beanObj!=null && (beanObj instanceof CEventBean)){
    					   CEventBean bean=(CEventBean)beanObj;
    					   String id=bean.getAppId();
    					   if(id==null || id.equals(appId)){
    						   listeners.remove(l);
    						   l--;
    					   }
    				   }
    			   }
    			   //int size=listeners.size();
    			 //  Log.println("app "+appId+" evt size="+size+" type="+i);
    			}
    		}
    		
    	}
    }
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		JarFile jarFile=
			new JarFile("C:/Documents and Settings/pengzhen/桌面/整理/二进制/SmartInvoke2009-12-2.0.jar");
		String cls="cn.smartinvoke.javaflex.gui.Msg";
		JarEntry entity=jarFile.getJarEntry("cn/smartinvoke/javaflex/gui/Msg.class");
		System.out.println(entity);
		InputStream in=jarFile.getInputStream(entity);
		byte[] bts=new byte[in.available()];
		in.read(bts, 0, bts.length);
		System.out.println(bts);
//		Enumeration<JarEntry> entities=jarFile.entries();
//		while(entities.hasMoreElements()){
//			 entity=entities.nextElement();
//			System.out.println(entity.getName());
//		}
	}
	public void dispose() {
		
	}

}
/**
 * 每个控件的事件信息，数据结构。表示每个控件的所有监听器信息
 * @author pengzhen
 *
 */
class ListenerEntity{
	/**
	 * 41代表事件类型的个数，一个数代表一个事件类型由EventTypes定义
	 */
	//TODO　为了效率用map
	public List[] listeners=new List[42];//42保证数组下标不越界
	public ListenerEntity(){
		for(int i=0;i<listeners.length;i++){
			//TODO 默认初始化10个
			listeners[i]=new LinkedList();
		}
	}
}