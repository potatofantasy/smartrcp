package cn.smartinvoke.smartrcp.gui.control;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;

import cn.smartinvoke.IServerObject;
import cn.smartinvoke.smartrcp.gui.module.CObservable;
/**
 * 为flex提供本地菜单支持
 * @author pengzhen
 *
 */
public class CNativeMenuBuilder  extends CObservable implements IServerObject{
	private Menu menu=null;
	private MenuManager manager=null;
	private List<CNativeActionImpl> actions=new LinkedList<CNativeActionImpl>();
	private Control parent;
	public CNativeMenuBuilder(Control parent) {
		this.manager=new MenuManager();
		this.parent=parent;
	}
	public void init(Object[] cActions){
		if(cActions!=null){
			for(int n=0;n<cActions.length;n++){
			   Object obj=cActions[n];
			   if(obj instanceof CAction){
				   CAction cAction=(CAction)obj;
				   this.addActionNotUpdate(cAction);
			   }
			}
			//
			this.manager.update();
			//创建右键菜单
			this.menu=this.manager.createContextMenu(parent);
		}
	}
	
	public void addAction(CAction cAction){
		 this.addActionNotUpdate(cAction);
		 this.manager.update();
	}
	private void addActionNotUpdate(CAction cAction){
		 if(cAction==null){
			  return;
		  }
		  CNativeActionImpl actionImpl=null;
		  int declType=cAction.getType();
		  if(declType==IAction.AS_CHECK_BOX){
				actionImpl=new CNativeActionImpl(cAction.getText(),IAction.AS_CHECK_BOX,cAction.isChecked());
		  }else if(declType==IAction.AS_RADIO_BUTTON){
				actionImpl=new CNativeActionImpl(cAction.getText(),IAction.AS_RADIO_BUTTON,cAction.isChecked());
		  }else{
				actionImpl=new CNativeActionImpl(cAction.getText());
		  }
		  actionImpl.init(cAction,this.listeners);
		  this.manager.add(actionImpl);
		  this.actions.add(actionImpl);
	}
    public void insertAfter(String actionId,CAction cAction){
		
	}
	public void insertBefore(String actionId,CAction cAction){
	  	
	}
	
	public void delete(String actionId){
	   	if(actionId!=null){
	   		this.manager.remove(actionId);
	   		CNativeActionImpl actionImpl=this.getActionFromId(actionId);
	   		if (actionImpl!=null) {
				this.actions.remove(actionImpl);
			}
	   		this.manager.update();
	   	}
	}
	public void setEnable(String actionId,boolean enable){
		CNativeActionImpl actionImpl=this.getActionFromId(actionId);
   		if (actionImpl!=null) {
   			actionImpl.setEnabled(enable);
		}
	}
	public void fireActionClick(String actionId){
		
	}
	public void show(int x,int y){
		
		if(this.menu!=null){
		   if(this.menu.getVisible()==false){
			   System.out.println("show at:x="+x+" y="+y);
		     Point point=this.parent.toDisplay(x, y);
			 this.menu.setLocation(point.x, point.y);
			 this.menu.setVisible(true);
		   }
		}
	}
	public void hide(){
		if(this.menu!=null){
			this.menu.setVisible(false);
		}
	}
	private CNativeActionImpl getActionFromId(String actionId){
		CNativeActionImpl ret=null;
		for(int i=0;i<this.actions.size();i++){
			CNativeActionImpl temp=this.actions.get(i);
			String id=temp.getId();
			if(id!=null && id.equals(actionId)){
				ret=temp;
				break;
			}
		}
		return ret;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    List<CNativeActionImpl> list=null;
	    
	}
}
