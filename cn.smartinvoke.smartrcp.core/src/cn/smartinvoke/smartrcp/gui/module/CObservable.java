package cn.smartinvoke.smartrcp.gui.module;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.swt.widgets.Menu;

import cn.smartinvoke.IServerObject;
import cn.smartinvoke.util.Log;
/**
 * 可监听的
 * @author pengzhen
 *
 */
public abstract class CObservable implements IServerObject{
	protected List<CEventBean> listeners = new LinkedList<CEventBean>();
	//记录所有的CObservable实例，当有FlashViwer关闭时，轮询此集合回收对应的监听器对象
	private static List<CObservable> observers=new LinkedList<CObservable>();
	public CObservable() {
		observers.add(this);
	}
    public void addListener(CEventBean eventBean){
      if(eventBean!=null){
    	this.listeners.add(eventBean);
      }
    }
    public void removeListener(CEventBean eventBean){
    	if(eventBean!=null){
    	 this.listeners.remove(eventBean);
    	}
    }
    protected void fireEvent(Object param){
    	for(int l=0;l<this.listeners.size();l++){
    		this.listeners.get(l).fireEvent(param);
    	}
    }
    public void delListeners(String appId){
    	if(appId!=null){
    		for(int n=0;n<listeners.size();n++){
    			CEventBean eventBean=listeners.get(n);
    			if(eventBean.getAppId().equals(appId)){
    				listeners.remove(n);
    				n--;
    			}
    		}
    	}
    }
    public void dispose() {
    	observers.remove(this);
	}
    
    public static void deleteListeners(String appId){
       Log.println("delete CObservable listeners app="+appId);
       if(appId!=null){
    	   for(int n=0;n<observers.size();n++){
    		   observers.get(n).delListeners(appId);
    	   }
       }
    }
	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		FileReader reader=new FileReader("C:/BufferedReader.java");
		BufferedReader br=new BufferedReader(reader);
		MenuManager manager=null;
		Menu menu=null;
		
		CEventBean bean=null;
		
	}
}
