package cn.smartinvoke.smartrcp.gui.control;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;

import cn.smartinvoke.IServerObject;
import cn.smartinvoke.rcp.CMenuRelation;
import cn.smartinvoke.smartrcp.gui.module.CEventBean;
import cn.smartinvoke.smartrcp.gui.module.CObservable;
import cn.smartinvoke.smartrcp.util.JFaceConstant;
import cn.smartinvoke.util.Log;
/**
 * 为flex提供本地菜单支持
 * @author pengzhen
 *
 */
public class CNativeMenuBuilder  extends CObservable implements IServerObject{
	private Menu rootMenu=null;
	private MenuManager root=null;
	private List<CNativeActionImpl> actions=new LinkedList<CNativeActionImpl>();
	private Control parent;
	public CNativeMenuBuilder(Control parent) {
		this.root=new MenuManager();
		this.parent=parent;
	}
	public void initAction(Object[] cActions){
		if(cActions!=null){
			for(int n=0;n<cActions.length;n++){
			   Object obj=cActions[n];
			   if(obj ==null){
				   continue;
			   }
			   if(obj instanceof CAction){
				   CAction cAction=(CAction)obj;
				   this.addActionNotUpdate(cAction);
			   }
			}
		}
	}
	public void addAction(CAction cAction){
		 this.addActionNotUpdate(cAction);
	}
	//--------------------
	public void initMenu(CMenuRelation menuRelation){
		if(menuRelation!=null){
			Object[] actions = menuRelation.actions;
			if (actions != null) {
				for (int a = 0; a < actions.length; a++) {
					Object action = actions[a];
					if (action instanceof CMenuRelation) {
						CMenuRelation relation=(CMenuRelation) action;
						if(relation.managerId==null){
						   relation.managerId=relation.label;
						}
						String pathStr=relation.managerId;
						fillMenu(this.root, relation,relation.managerId,pathStr);
					} else if (action instanceof String) {
						String id = (String) action;
						if (id.equals(JFaceConstant.Menu_Separator_Str)) {
							this.root.add(new Separator());
						} else {
							IAction iAction = this.getActionFromId(id);
							if (iAction != null) {
								Log.println("add action="+iAction);
								root.add(iAction);
							}
						}
					}
				}// end for
			}
		  this.rootMenu=this.root.createContextMenu(parent);
		}
		
	}
private  void fillMenu(IMenuManager menuBar, CMenuRelation menuRelation,String managerId,String pathStr) {
		if (menuRelation == null) {
			return;
		}
		
		IMenuManager menuManager =null;
		Object[] actions = menuRelation.actions;
		if (actions != null) {
			menuManager=this.root.findMenuUsingPath(pathStr);
			if(menuManager==null){
			  Log.println(" create menu path="+pathStr);
			  menuManager=new MenuManager(menuRelation.label,managerId);
			}
			for (int a = 0; a < actions.length; a++) {
				Object action = actions[a];
				if (action instanceof CMenuRelation) {
					CMenuRelation relation=(CMenuRelation) action;
					if(relation.managerId==null){
					   relation.managerId=relation.label;
					}
					String path=pathStr+"/"+relation.managerId;
					fillMenu(menuManager, relation,relation.managerId,path);
				} else if (action instanceof String) {
					String id = (String) action;
					if (id.equals(JFaceConstant.Menu_Separator_Str)) {
						menuManager.add(new Separator());
					} else {
						CNativeActionImpl nativeAction = this.getActionFromId(id);
						if (nativeAction != null) {
							Log.println("add action="+nativeAction);
							nativeAction.path=pathStr;
							menuManager.add(nativeAction);
						}
					}
				}
			}// end for
			menuBar.add(menuManager);
		}
	}
	public void addMenuItem(String actionId,String path){
	   if(actionId==null){
		   return;
	   }
	   if(path==null){
		   path="";
	   }
	   path=path.trim();
	   
	   IMenuManager menuManager=null;
       if(path.length()==0){
		   menuManager=root;
	   }else{
		   menuManager=this.root.findMenuUsingPath(path);
	   }
	   if(menuManager!=null){
		  CNativeActionImpl actionImpl=this.getActionFromId(actionId);
	   	  if (actionImpl!=null) {
	   		actionImpl.path=path;
	   		menuManager.add(actionImpl);
			menuManager.update();
	   	  }
	   }
	}
    public void removeMenuItem(String actionId,String path){
       if(actionId==null){
 		   return;
 	   }
 	   if(path==null){
 		   path="";
 	   }
 	   path=path.trim();
 	   IMenuManager menuManager=null;
       if(path.length()==0){
		   menuManager=root;
	   }else{
		   menuManager=this.root.findMenuUsingPath(path);
	   }
	   if(menuManager!=null){
		  CNativeActionImpl actionImpl=this.getActionFromId(actionId);
	   	  if (actionImpl!=null) {
	   		menuManager.remove(actionId);
			menuManager.update();
			this.delete(actionId);
	   	  }
	   }
	}
    //----------------
	private CNativeActionImpl addActionNotUpdate(CAction cAction){
		 if(cAction==null){
			  return null;
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
		  this.actions.add(actionImpl);
		  return actionImpl;
	}
	public void delete(String actionId){
	   	if(actionId!=null){
	   		CNativeActionImpl actionImpl=this.getActionFromId(actionId);
	   		if (actionImpl!=null) {
				this.actions.remove(actionImpl);
			}
	   	}
	}
	public void setEnable(String actionId,boolean enable){
		CNativeActionImpl actionImpl=this.getActionFromId(actionId);
   		if (actionImpl!=null) {
   			actionImpl.setEnabled(enable);
		}
	}
	public void fireActionClick(String actionId){
		CNativeActionImpl actionImpl=this.getActionFromId(actionId);
   		if (actionImpl!=null) {
   			actionImpl.run();
   		}
	}
	public void show(int x,int y){
		if(this.rootMenu!=null){
			Log.println("show at="+x+" "+y);
		   //if(this.rootMenu.getVisible()==false){
		     Point point=this.parent.toDisplay(x, y);
			 this.rootMenu.setLocation(point.x, point.y);
			 this.rootMenu.setVisible(true);
		   //}
		}
	}
	public void hide(){
		if(this.rootMenu!=null){
			this.rootMenu.setVisible(false);
		}
	}
	public void updateActionText(String actionId,String text){
		if(actionId==null || text==null){
			return;
		}
		CNativeActionImpl action=this.getActionFromId(actionId);
		if(action!=null){
			action.setText(text);
		}
	}
	public void updateActionToolTip(String actionId,String text){
		if(actionId==null || text==null){
			return;
		}
		CNativeActionImpl action=this.getActionFromId(actionId);
		if(action!=null){
			action.setToolTipText(text);
		}
	}
	public void updateActionChecked(String actionId,boolean isChecked){
		if(actionId==null){
			return;
		}
		CNativeActionImpl action=this.getActionFromId(actionId);
		if(action!=null){
			action.setChecked(isChecked);
		}
	}
	public void updateActionEnable(String actionId,boolean isEnable){
		if(actionId==null){
			return;
		}
		CNativeActionImpl action=this.getActionFromId(actionId);
		if(action!=null){
			action.setEnabled(isEnable);
		}
	}
	//------------------
	private CNativeActionImpl getActionFromId(String actionId){
		CNativeActionImpl ret=null;
		if(actionId!=null){
		 for(int i=0;i<this.actions.size();i++){
			CNativeActionImpl temp=this.actions.get(i);
			String id=temp.getId();
			if(id!=null && id.equals(actionId)){
				ret=temp;
				break;
			}
		 }
		}
		return ret;
	}
	public void dispose(){
		try{
		if(this.root!=null){
			this.root.removeAll();
			this.root.dispose();
		}
		if(this.rootMenu!=null){
			this.rootMenu.dispose();
		}
		//
		for(int n=0;n<this.listeners.size();n++){
			CEventBean bean=this.listeners.get(n);
			bean.dispose();
		}
		}catch(Throwable e){};
		
		//调用父类的dispose注销掉自己
		super.dispose();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    
	}
}
