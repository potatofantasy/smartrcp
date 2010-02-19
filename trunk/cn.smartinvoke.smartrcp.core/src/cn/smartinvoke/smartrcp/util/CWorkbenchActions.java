package cn.smartinvoke.smartrcp.util;

import java.lang.reflect.Field;

import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;

public class CWorkbenchActions {
    private static Class actionFactoryCls=ActionFactory.class;
    /**
     * 获得eclipse预定义action，如果没有则返回null
     * @param window
     * @param id
     * @return
     */
    public static IWorkbenchAction getWorkbenchAction(IWorkbenchWindow window,String id){
    	IWorkbenchAction ret=null;
    	if(id!=null){
    		try{
    	      Field field=actionFactoryCls.getField(id);
    	      if(field!=null){
    	    	 Object obj= field.get(null);
    	    	 if(obj!=null && obj instanceof ActionFactory){
    	    		 ActionFactory actionFactory=(ActionFactory)obj;
    	    		 ret=actionFactory.create(window);
    	    	 }
    	      }
    		}catch (Exception e) {
				
			}
    	}
    	return ret;
    }
	public CWorkbenchActions() {
		
	}
	
}
