package cn.smartinvoke.smartrcp.gui.control;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.action.IAction;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.application.ActionBarAdvisor;

import cn.smartinvoke.IServerObject;
import cn.smartinvoke.smartrcp.gui.ActionBarBase;
import cn.smartinvoke.smartrcp.util.CWorkbenchActions;
import cn.smartinvoke.util.ImageManager;

public class CActionManager extends ActionBarBase implements IServerObject {
	/**
	 * 
	 */
	//private Map<String, CActionEntity> actionMap = new HashMap<String, CActionEntity>();
	private ActionBarAdvisor actionBarAdvisor;
    private IWorkbenchWindow window;
	public CActionManager(ActionBarAdvisor actionBarAdvisor,IWorkbenchWindow window) {
		this.actionBarAdvisor = actionBarAdvisor;
		this.window=window;
	}
	public void addAction(CAction cAction) {
		// CAction cAction = (CAction) actionObj;
		if (cAction == null) {
			return;
		}
		// 检查是否是预定义的workbench action
		IWorkbenchAction workbenchAction = CWorkbenchActions
				.getWorkbenchAction(window, cAction.getActionId());
		if (workbenchAction != null){
            workbenchAction.setText(cAction.getText());
            // Associate the action with a pre-defined command, to allow key bindings.
            workbenchAction.setActionDefinitionId(cAction.getActionId());
            workbenchAction.setToolTipText(cAction.getToolTip());
            
            try{
            	String imgUrl=cAction.getImageUrl();
            	if(imgUrl!=null){
            		workbenchAction.setImageDescriptor(ImageManager.getImageDescriptor(imgUrl));
            	}
        		String hoverImg=cAction.getHoverImageUrl();
        		if(hoverImg!=null){
        			workbenchAction.setHoverImageDescriptor(ImageManager.getImageDescriptor(hoverImg));
            	}
        		String disableImg=cAction.getDisableImageUrl();
        		if(disableImg!=null){
        			workbenchAction.setDisabledImageDescriptor(ImageManager.getImageDescriptor(disableImg));
            	}
            }catch(Exception e){};
           this.addAction(workbenchAction);
           this.fillActionBarAdvisor(workbenchAction);
		} else {
			// 自定义action
			CActionImpl actionImpl = null;
			int declType = cAction.getType();
			if (declType == IAction.AS_CHECK_BOX) {
				actionImpl = new CActionImpl(cAction.getText(),
						IAction.AS_CHECK_BOX, cAction.isChecked());
			} else if (declType == IAction.AS_RADIO_BUTTON) {
				actionImpl = new CActionImpl(cAction.getText(),
						IAction.AS_RADIO_BUTTON, cAction.isChecked());
			} else if (declType == -1) {
				actionImpl = new CActionImpl(cAction.getText());
			} else {
				actionImpl = new CActionImpl(cAction.getText(), declType);
			}

			actionImpl.init(cAction);
			this.addAction(actionImpl);
			this.fillActionBarAdvisor(actionImpl);
		}
	}

	

	/**
	 * 强行调用ActionBarAdvisor的register方法，注册action 此方法的目的是为了注册快捷键
	 * 
	 * @param action
	 */
	private void fillActionBarAdvisor(IAction action) {
		if (action != null) {
			Class cls =ActionBarAdvisor.class;

			try {
				//Method[] methods=cls.getDeclaredMethods();
				Method method = cls.getDeclaredMethod("register", IAction.class);
				method.setAccessible(true);
				if (method != null) {
					method.invoke(this.actionBarAdvisor, action);
				}
			} catch (Exception e) {
                e.printStackTrace();
			}

		}
	}
	public void removeAction(String actionId) {
		if (actionId != null) {
			//删除当前manager中的引用
			this.actionMap.remove(actionId);
			//删除actionBarAdvistor中该action的引用
			this.delActionBarAction(actionId);
		}
	}
	/**
	 * 从actionBarAdvisor中强行删除指定id的action
	 * @param action
	 */
    private void delActionBarAction(String actionId){
    	if(actionId!=null){
    	  Class cls =ActionBarAdvisor.class;
    	  try{
    		Field field=cls.getDeclaredField("actions");
   	        field.setAccessible(true);
   	        Object ret=field.get(this.actionBarAdvisor);
   	        if(ret instanceof Map){
   	    	  Map  actionMap=((Map)ret);
   	    	  actionMap.remove(actionId);
   	        }
    	  }catch (Exception e) {
		    e.printStackTrace();  
    	  }
    	}
    }
	public void dispose() {
        this.actionMap.clear();
        this.actionBarAdvisor.dispose();
	}
	public static void main(String[] args) {
		List<String> lst=new LinkedList<String>();
		lst.add("1");lst.add("2");lst.add("3");
	}
}

