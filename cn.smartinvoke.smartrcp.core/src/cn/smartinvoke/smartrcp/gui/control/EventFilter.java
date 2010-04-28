package cn.smartinvoke.smartrcp.gui.control;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

import cn.smartinvoke.ObjectPool;
import cn.smartinvoke.smartrcp.gui.control.GlobalServiceId;
import cn.smartinvoke.smartrcp.gui.module.CEventBean;

/**
 * 事件过滤器
 * @author pengzhen
 *
 */
public class EventFilter {
    public static Point cur_point=null;
	private EventFilter(){
	  
	}
	private static EventRegister Event_Register;
    public static void exeFilter(Display display){
      	if(display!=null){
      		//init
      		Event_Register=(EventRegister)ObjectPool.INSTANCE.getObject(GlobalServiceId.Event_Register);
      		//-----
      		display.addFilter(SWT.MouseDown,new Listener(){

				public void handleEvent(Event event) {
					cur_point=new Point(event.x,event.y);
				}
      			
      		});
      		//添加所有的事件监听器
      		for(int i=0;i<42;i++){
      	      display.addFilter(i, new Listener(){
				public void handleEvent(Event event){
					dealEvent(event);
				}
      	      });
      		}
      	}
    }
    public static void dealEvent(Event evt){
    	//fire flex全局监听器
    	//Shell mainWin=(Shell)ObjectPool.INSTANCE.getObject(GlobalServiceId.Swt_Main_Win);
    	//if(evt.widget==mainWin){
    	 fireListeners(Event_Register.globalListenerEntity, evt);
    	//}
    	//fire 对应控件的监听器
    	ListenerEntity entity=Event_Register.getListenerEntity(evt.widget);
    	fireListeners(entity,evt);
    }
    private static void fireListeners(ListenerEntity entity,Event evt){
    	if(entity!=null && evt!=null){
            List listeners=entity.listeners[evt.type];
            if (listeners!=null){
          	  for(int i=0;i<listeners.size();i++){
          		  //调用flex的事件接收器，并传递对应事件
          		  CEventBean eventBean=(CEventBean)listeners.get(i);
          		  eventBean.fireEvent(evt);
//          		  List<FlashViewer> flashViewers=FlashViewer.getViewers();
//          		  for(int v=0;v<flashViewers.size();v++){
//          			FlashContainer flashContainer=flashViewers.get(v).getFlashContainer();
//          		    RemoteObject remoteObject=new RemoteObject(flashContainer,false);
//          	        remoteObject.setRemoteId(GlobalServiceId.Flex_CEvent_Notifer);
//          	        remoteObject.asyncCall("fireEvent",new Object[]{(String)listeners.get(i),evt});
//          		  }
          	  }
  		  }
      	}
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Event evt=new Event();
		
	}
    
}
