package cn.smartinvoke.smartrcp.gui;

import java.util.List;

import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.SWT;

import cn.smartinvoke.IServerObject;
import cn.smartinvoke.rcp.CToolBar;
import cn.smartinvoke.smartrcp.core.SmartRCPBuilder;
import cn.smartinvoke.smartrcp.util.JFaceConstant;

public class CAppToolBarManager implements IServerObject {
	private ICoolBarManager coolBar;
	
	private CToolBar curToolBar =null;
    private ToolBarManager toolBarManager=null;
	public CAppToolBarManager(ICoolBarManager coolBar) {
		this.coolBar = coolBar;
	}
	public CToolBar getCurToolBar(){
		return this.curToolBar;
	}
	
	public ToolBarManager getToolBarManager() {
		return toolBarManager;
	}
	public void fillToolBar(CToolBar toolBar) {
		if (toolBar != null) {
			//缓存当前配置
			curToolBar=toolBar;
			this.createToolBar(toolBar.type);
			
			List<String> actionIds = toolBar.actionIds;
			if (actionIds != null) {
				for (int n = 0; n < actionIds.size(); n++) {
					Object idObj = actionIds.get(n);
					if(idObj==null){
						continue;
					}
					
					if (idObj instanceof String) {
						String id = (String) idObj;
						if (id.equals(JFaceConstant.Menu_Separator_Str)) {
							//curDisplayToolBar = this.createToolBar(toolBar.type);
							toolBarManager.add(new Separator());
						} else {
							IAction action = SmartRCPBuilder.Instance.actionManager
									.getAction(id);
							if (action != null) {
								ActionContributionItem contributionItem = new ActionContributionItem(
										action);
								if (toolBar.type != CToolBar.Image) {
									contributionItem
											.setMode(ActionContributionItem.MODE_FORCE_TEXT);
								}
								toolBarManager.add(contributionItem);
							}
						}
					}
				}// end for
			}// end if
			this.coolBar.update(true);
		}
	}

	private void createToolBar(int type) {
		//清空以前的
		if(this.toolBarManager!=null){
			this.toolBarManager.removeAll();
		}
		//创建新的
		ToolBarManager curDisplayToolBar = null;
		if (type == CToolBar.Image) {
			curDisplayToolBar = new ToolBarManager(this.coolBar.getStyle());
		} else if (type == CToolBar.Image_Text_Horizontal) {
			curDisplayToolBar = new ToolBarManager(this.coolBar.getStyle()
					| SWT.FLAT);
		} else {
			curDisplayToolBar = new ToolBarManager(this.coolBar.getStyle()
					| SWT.FLAT | SWT.RIGHT);
		}
		
		this.toolBarManager=curDisplayToolBar;
		//添加进工具条容器
		this.coolBar.add(toolBarManager);
	}

	/**
	 * 隐藏工具条上的指定项
	 * 
	 * @param toolBarId
	 */
	public void removeItem(String actionId) {
		if (actionId != null) {
				this.toolBarManager.remove(actionId);
				this.coolBar.update(true);
				this.curToolBar.actionIds.remove(actionId);
		}
	}

	public void removeAll() {
		this.toolBarManager.removeAll();
		this.coolBar.update(true);
	}
	/**
	 * 显示工具条上的指定项
	 * 
	 * @param actionId
	 */
	public void insertItem(String actionId) {
		if (actionId != null) {
			if(this.curToolBar.actionIds.contains(actionId)){//如果已经添加则返回
				return;
			}
			IAction action = SmartRCPBuilder.Instance.actionManager.getAction(actionId);
			if (action != null) {
				ActionContributionItem contributionItem = new ActionContributionItem(
						action);
				if (this.curToolBar.type != CToolBar.Image) {
					contributionItem
							.setMode(ActionContributionItem.MODE_FORCE_TEXT);
				}
				this.toolBarManager.add(contributionItem);
				this.coolBar.update(true);
				this.curToolBar.actionIds.add(actionId);
			}
		}
	}

	public void insertBefore(String beforeId, String actionId) {
		if (beforeId != null && actionId != null) {
			if(this.curToolBar.actionIds.contains(actionId)){
				return;
			}
			IAction action = SmartRCPBuilder.Instance.actionManager.getAction(actionId);
			if (action != null) {
				    ActionContributionItem contributionItem = new ActionContributionItem(action);
					if (this.curToolBar.type != CToolBar.Image) {
						contributionItem.setMode(ActionContributionItem.MODE_FORCE_TEXT);
					}
					
					this.toolBarManager.add(contributionItem);
					this.coolBar.update(true);
							
					List<String> actionIds=this.curToolBar.actionIds;
					int idIndex=actionIds.indexOf(beforeId);
					actionIds.add(idIndex-1, actionId);		
			}
		}
	}
	public void insertAfter(String afterId, String actionId) {
		if (afterId != null && actionId != null) {
			if(this.curToolBar.actionIds.contains(actionId)){
				return;
			}
			IAction action = SmartRCPBuilder.Instance.actionManager.getAction(actionId);
			if (action != null) {
				    ActionContributionItem contributionItem = new ActionContributionItem(action);
					if (this.curToolBar.type != CToolBar.Image) {
						contributionItem.setMode(ActionContributionItem.MODE_FORCE_TEXT);
					}
					this.toolBarManager.add(contributionItem);
					this.coolBar.update(true);
				    
					List<String> actionIds=this.curToolBar.actionIds;
					int idIndex=actionIds.indexOf(afterId);
					actionIds.add(idIndex, actionId);	
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	public void dispose() {
       this.coolBar.removeAll();
	}

}
