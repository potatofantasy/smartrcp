package cn.smartinvoke.smartrcp.gui;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.Separator;

import cn.smartinvoke.smartrcp.gui.control.CAction;
import cn.smartinvoke.smartrcp.gui.module.CActionEntity;
import cn.smartinvoke.smartrcp.gui.module.CEventBean;
import cn.smartinvoke.smartrcp.util.JFaceConstant;

public abstract class ActionBarBase {
	protected Map<String, CActionEntity> actionMap = new HashMap<String, CActionEntity>();
	public ActionBarBase() {
		
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
    public void fireAction(String id){
    	if(id!=null){
    		IAction action=this.getAction(id);
    		if(action!=null){
    			action.run();
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
	public void setEnable(String actionId, boolean enable) {
		if (actionId != null) {
			IAction action = this.getAction(actionId);
			if (action != null) {
				action.setEnabled(enable);
			}
		}
	}
	
	public void addListener(String actionId, CEventBean eventBean) {
		if (actionId == null || eventBean == null) {
			return;
		}
		CActionEntity entity = this.actionMap.get(actionId);
		if (entity != null) {
			if (!entity.isAlreadyAdd(eventBean)) {// 没有添加
				entity.listeners.add(eventBean);
			}
		} else {
			throw new RuntimeException("the action thant the id is " + actionId
					+ " is not exit!");
		}
	}

	public void removeListener(String actionId, CEventBean bean) {
		if (bean == null || actionId == null) {
			return;
		}
		CActionEntity entity = this.actionMap.get(actionId);
		if (entity != null) {
			entity.listeners.remove(bean);
		}
	}
	// --------------
	public void updateText(String actionId, String text) {
		if (actionId != null) {
			IAction action = this.getAction(actionId);
			if (action != null) {
				action.setText(text);
			}
		}
	}

	public void updateToolTip(String actionId, String text) {
		if (actionId != null) {
			IAction action = this.getAction(actionId);
			if (action != null) {
				action.setToolTipText(text);
			}
		}
	}

	public void updateChecked(String actionId, boolean isChecked) {
		if (actionId != null) {
			IAction action = this.getAction(actionId);
			if (action != null) {
				action.setChecked(isChecked);
			}
		}
	}
	/**
	 * 释放指定appId下的所有监听器资源
	 * 
	 * @param appId
	 */
	public void desposeResource(String appId) {
		if (appId != null) {
			Iterator<String> actionIds = this.actionMap.keySet().iterator();
			while (actionIds.hasNext()) {
				String key = actionIds.next();
				CActionEntity actionEntity = this.actionMap.get(key);
				List<CEventBean> listeners = actionEntity.listeners;
				for (int n = 0; n < listeners.size(); n++) {
					CEventBean eventBean = listeners.get(n);
					String curId = eventBean.getAppId();
					if (curId != null && curId.equals(appId)) {
						listeners.remove(eventBean);
						n--;//保证不要漏掉一个eventBean
					}
				}
			}
		}
	}
	public abstract void addAction(CAction cAction);
	public abstract void removeAction(String actionId) ;
}
