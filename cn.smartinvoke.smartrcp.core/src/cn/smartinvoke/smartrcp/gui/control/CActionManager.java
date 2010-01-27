package cn.smartinvoke.smartrcp.gui.control;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.action.IAction;

import cn.smartinvoke.smartrcp.gui.module.CEventBean;


public class CActionManager {
	/**
	 *
	 */
	private Map<String, CActionEntity> actionMap = new HashMap<String, CActionEntity>();

	public CActionManager() {
          
	}

	public IAction getAction(String id) {
		if (id == null) {
			return null;
		} else {
			CActionEntity actionEntity = actionMap.get(id);
			if (actionEntity != null) {
				return actionEntity.action;
			} else {
				return null;
			}
		}
	}
	public CActionEntity getActionEntity(String id) {
		if (id == null) {
			return null;
		} else {
			CActionEntity actionEntity = actionMap.get(id);
			return actionEntity;
		}
	}
	public void addAction(IAction action) {
		if (action != null) {
			String id = action.getId();
			if (id != null) {
				CActionEntity actionEntity = new CActionEntity(action);
				this.actionMap.put(action.getId(), actionEntity);
			}
		}
	}

	public void addListener(String actionId,CEventBean eventBean) {
		if(actionId==null || eventBean==null){
			return;
		}
		CActionEntity entity = this.actionMap.get(actionId);
		if (entity != null) {
		   if(!entity.isAlreadyAdd(eventBean)){//Ã»ÓÐÌí¼Ó
			 entity.listeners.add(eventBean);
		   }
		} else {
			throw new RuntimeException("the action thant the id is " + actionId
					+ " is not exit!");
		}
	}
	public void removeListener(String actionId,CEventBean bean) {
		if(bean==null || actionId==null){
			return;
		}
		CActionEntity entity = this.actionMap.get(actionId);
		if (entity != null) {
			entity.listeners.remove(bean);
		}
	}
	public void setEnable(String id,boolean enable){
	 if(id!=null){
		IAction action=this.getAction(id);
		if(action!=null){
			action.setEnabled(enable);
		}
	 }
	}
	public void removeAction(String id) {
		if (id != null) {
			this.actionMap.remove(id);
		}
	}
}

class CActionEntity {
	public IAction action;
	public List<CEventBean> listeners = new LinkedList<CEventBean>();
    
	public CActionEntity(IAction action) {
		super();
		this.action = action;
	}
	public boolean isAlreadyAdd(CEventBean eventBean) {
		boolean ret = false;
		if (eventBean != null) {
			ret=this.listeners.contains(eventBean);
		}
		return ret;
	}
}