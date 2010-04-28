package cn.smartinvoke.smartrcp.gui.module;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.action.IAction;

public class CActionEntity {
	public IAction action;
	public List<CEventBean> listeners = new LinkedList<CEventBean>();

	public CActionEntity(IAction action) {
		super();
		this.action = action;
	}

	public boolean isAlreadyAdd(CEventBean eventBean) {
		boolean ret = false;
		if (eventBean != null) {
			ret = this.listeners.contains(eventBean);
		}
		return ret;
	}
}
