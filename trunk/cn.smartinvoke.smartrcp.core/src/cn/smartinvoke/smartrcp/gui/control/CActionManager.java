package cn.smartinvoke.smartrcp.gui.control;

import java.util.HashMap;
import java.util.Iterator;
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

	public CActionImpl getAction(String id) {
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
	public void addAction(CActionImpl action) {
		if (action != null) {
			String id = action.getId();
			if (id != null) {
				CActionEntity actionEntity = new CActionEntity(action);
				this.actionMap.put(action.getId(), actionEntity);
			}
		}
	}
	public void addAction(CAction cAction) {
		//CAction cAction = (CAction) actionObj;
		if(cAction==null){
			return;
		}
		CActionImpl actionImpl = null;
		int declType = cAction.getType();
		if (declType == IAction.AS_CHECK_BOX) {
			actionImpl = new CActionImpl(cAction.getText(),
					IAction.AS_CHECK_BOX, cAction
							.isChecked());
		} else if (declType == IAction.AS_RADIO_BUTTON) {
			actionImpl = new CActionImpl(cAction.getText(),
					IAction.AS_RADIO_BUTTON, cAction
							.isChecked());
		} else if(declType==-1){
			actionImpl = new CActionImpl(cAction.getText());
		}else{
			actionImpl = new CActionImpl(cAction.getText(),declType);
		}
		actionImpl.init(cAction);
		this.addAction(actionImpl);
	}
	public void addListener(String actionId,CEventBean eventBean) {
		if(actionId==null || eventBean==null){
			return;
		}
		CActionEntity entity = this.actionMap.get(actionId);
		if (entity != null) {
		   if(!entity.isAlreadyAdd(eventBean)){//没有添加
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
	public void setEnable(String actionId,boolean enable){
	 if(actionId!=null){
		IAction action=this.getAction(actionId);
		if(action!=null){
			action.setEnabled(enable);
		}
	 }
	}
	//--------------
	public void updateText(String actionId,String text){
		if(actionId!=null){
			IAction action=this.getAction(actionId);
			if(action!=null){
				action.setText(text);
			}
		}
	}
	public void updateToolTip(String actionId,String text){
		if(actionId!=null){
			IAction action=this.getAction(actionId);
			if(action!=null){
				action.setToolTipText(text);
			}
		}
	}
	public void updateChecked(String actionId,boolean isChecked){
		if(actionId!=null){
			IAction action=this.getAction(actionId);
			if(action!=null){
				action.setChecked(isChecked);
			}
		}
	}
	public void removeAction(String actionId) {
		if (actionId != null) {
			this.actionMap.remove(actionId);
		}
	}
	/**
	 * 释放指定appId下的所有监听器资源
	 * @param appId
	 */
	public void desposeResource(String appId){
		if(appId!=null){
			Iterator<String> actionIds=this.actionMap.keySet().iterator();
			while(actionIds.hasNext()){
				String key=actionIds.next();
				CActionEntity actionEntity=this.actionMap.get(key);
				List<CEventBean> listeners=actionEntity.listeners;
				for(int n=0;n<listeners.size();n++){
					CEventBean eventBean=listeners.get(n);
					String curId=eventBean.getAppId();
					if(curId!=null && curId.equals(appId)){
						listeners.remove(eventBean);
					}
				}
			}
		}
	}
}

class CActionEntity {
	public CActionImpl action;
	public List<CEventBean> listeners = new LinkedList<CEventBean>();
    
	public CActionEntity(CActionImpl action) {
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