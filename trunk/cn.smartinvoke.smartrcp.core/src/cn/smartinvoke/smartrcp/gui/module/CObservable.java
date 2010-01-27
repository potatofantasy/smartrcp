package cn.smartinvoke.smartrcp.gui.module;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.swt.widgets.Menu;

import cn.smartinvoke.IServerObject;
/**
 * ¿É¼àÌýµÄ
 * @author pengzhen
 *
 */
public class CObservable implements IServerObject{
	protected List<CEventBean> listeners = new LinkedList<CEventBean>();
	public CObservable() {
		
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
	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		FileReader reader=new FileReader("C:/BufferedReader.java");
		BufferedReader br=new BufferedReader(reader);
		MenuManager manager=null;
		Menu menu=null;
		
	}
}
