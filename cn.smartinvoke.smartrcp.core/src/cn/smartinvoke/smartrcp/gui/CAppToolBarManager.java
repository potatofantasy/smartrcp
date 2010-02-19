package cn.smartinvoke.smartrcp.gui;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.SWT;

import cn.smartinvoke.IServerObject;
import cn.smartinvoke.rcp.CToolBar;
import cn.smartinvoke.smartrcp.core.SmartRCPBuilder;
import cn.smartinvoke.smartrcp.util.JFaceConstant;

public class CAppToolBarManager implements IServerObject {
	private ICoolBarManager coolBar;
	// 所有的工具栏对象字典
	// private Map<String,IToolBarManager> toolBarMap=new HashMap<String,
	// IToolBarManager>();
	// 当前显示的工具栏
	// public ToolBarManager curDisplayToolBar=null;
	public LinkedList<ToolBarManager> visualableToolBars = new LinkedList<ToolBarManager>();
	// private List<CToolBar> toolBarData=new LinkedList<CToolBar>();
	private CToolBar curToolBar =null;

	public CAppToolBarManager(ICoolBarManager coolBar) {
		this.coolBar = coolBar;
	}
	public CToolBar getCurToolBar(){
		return this.curToolBar;
	}
	public void fillToolBar(CToolBar toolBar) {
		if(toolBar==null){
			toolBar=new CToolBar();
			//toolBar.actionIds=new Object[]{JFaceConstant.Menu_Separator_Str};
		}
		if (toolBar != null) {
			//首先清空
			visualableToolBars.clear();
			this.coolBar.removeAll();
			//缓存当前配置
			curToolBar=toolBar;
			
			List<String> actionIds = toolBar.actionIds;
			if (actionIds != null) {
				ToolBarManager curDisplayToolBar =this.createToolBar(toolBar.type);
				this.coolBar.add(curDisplayToolBar);
				visualableToolBars.add(curDisplayToolBar);
				
				for (int n = 0; n < actionIds.size(); n++) {
					Object idObj = actionIds.get(n);
					if (idObj instanceof String) {
						String id = (String) idObj;
						if (id.equals(JFaceConstant.Menu_Separator_Str)) {
							//curDisplayToolBar = this.createToolBar(toolBar.type);
							curDisplayToolBar.add(new Separator());
						} else {
							IAction action = SmartRCPBuilder.actionManager
									.getAction(id);
							if (action != null) {
								ActionContributionItem contributionItem = new ActionContributionItem(
										action);
								if (toolBar.type != CToolBar.Image) {
									contributionItem
											.setMode(ActionContributionItem.MODE_FORCE_TEXT);
								}
								curDisplayToolBar.add(contributionItem);
							}
						}
					}
				}// end for
			}// end if
			this.coolBar.update(true);
		}
	}

	private ToolBarManager createToolBar(int type) {
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
		return curDisplayToolBar;
	}

	/**
	 * 隐藏工具条上的指定项
	 * 
	 * @param toolBarId
	 */
	public void removeItem(String actionId) {
		if (actionId != null) {
			for (ToolBarManager barManager : visualableToolBars) {
				if (barManager.find(actionId) != null) {
					barManager.remove(actionId);
					this.coolBar.update(true);
					this.curToolBar.actionIds.remove(actionId);
				}
			}
		}
		//this.coolBar.update(true);
	}

	public void removeAll() {
		//this.visualableToolBars.clear();
		this.fillToolBar(null);
	}
	/**
	 * 显示工具条上的指定项
	 * 
	 * @param actionId
	 */
	public void insertItem(String actionId) {
		if (actionId != null && visualableToolBars.size() > 0) {
			if(this.curToolBar.actionIds.contains(actionId)){//如果已经添加则返回
				return;
			}
			
			IAction action = SmartRCPBuilder.actionManager.getAction(actionId);
			if (action != null) {
				ActionContributionItem contributionItem = new ActionContributionItem(
						action);
				if (this.curToolBar.type != CToolBar.Image) {
					contributionItem
							.setMode(ActionContributionItem.MODE_FORCE_TEXT);
				}
				ToolBarManager barManager=visualableToolBars.get(visualableToolBars.size()-1);
				barManager.add(contributionItem);
				//barManager.update(true);
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
			IAction action = SmartRCPBuilder.actionManager.getAction(actionId);
			if (action != null) {
				    ActionContributionItem contributionItem = new ActionContributionItem(action);
					if (this.curToolBar.type != CToolBar.Image) {
						contributionItem.setMode(ActionContributionItem.MODE_FORCE_TEXT);
					}
					for(ToolBarManager item:visualableToolBars){
						  if(item.find(beforeId)!=null){
							item.insertBefore(beforeId, contributionItem);
							//item.update(true);
							this.coolBar.update(true);
							
							List<String> actionIds=this.curToolBar.actionIds;
							int idIndex=actionIds.indexOf(beforeId);
							actionIds.add(idIndex-1, actionId);
							return;
						  }
					}//end for
			}
		}
	}
	public void insertAfter(String afterId, String actionId) {
		if (afterId != null && actionId != null) {
			if(this.curToolBar.actionIds.contains(actionId)){
				return;
			}
			IAction action = SmartRCPBuilder.actionManager.getAction(actionId);
			if (action != null) {
				    ActionContributionItem contributionItem = new ActionContributionItem(action);
					if (this.curToolBar.type != CToolBar.Image) {
						contributionItem.setMode(ActionContributionItem.MODE_FORCE_TEXT);
					}
					for(ToolBarManager item:visualableToolBars){
						  if(item.find(afterId)!=null){
							item.insertAfter(afterId, contributionItem);
							//item.update(true);
							this.coolBar.update(true);
							
							List<String> actionIds=this.curToolBar.actionIds;
							int idIndex=actionIds.indexOf(afterId);
							actionIds.add(idIndex, actionId);
							
							return;
						  }
					}//end for
			}
			
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	public void dispose() {

	}

}
