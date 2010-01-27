package cn.smartinvoke.smartrcp.gui;

import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.ToolBarManager;

import cn.smartinvoke.IServerObject;
import cn.smartinvoke.rcp.CToolBar;
import cn.smartinvoke.smartrcp.core.SmartRCPBuilder;
import cn.smartinvoke.smartrcp.util.JFaceConstant;

public class CAppToolBarManager implements IServerObject{
	private ICoolBarManager coolBar;
	//所有的工具栏对象字典
	//private Map<String,IToolBarManager> toolBarMap=new HashMap<String, IToolBarManager>();
	//当前显示的工具栏
	public ToolBarManager curDisplayToolBar=null;
	//private List<IToolBarManager> visualableToolBar=new LinkedList<IToolBarManager>();
	public CAppToolBarManager(ICoolBarManager coolBar) {
	    this.coolBar=coolBar;
	    
	}
	public void addToolBar(CToolBar toolBar){
		if(toolBar!=null){
			Object[] actionIds=toolBar.actionIds;
			if(actionIds!=null){
			  ToolBarManager toolbarManager= new ToolBarManager(this.coolBar.getStyle()|toolBar.type);
			  for(int n=0;n<actionIds.length;n++){
			   Object idObj=actionIds[n];
			   if(idObj instanceof String){
				 String id=(String)idObj;
				 if (id.equals(JFaceConstant.Menu_Separator_Str)) {
					toolbarManager.add(new Separator());
				 }else{
			        toolbarManager.add(SmartRCPBuilder.actionManager.getAction((String)idObj));
				 }
			   }
			  }//end for
			  
			  curDisplayToolBar=toolbarManager;
			  //将该工具栏显示出来
			  this.coolBar.add(toolbarManager);
			}//end if
		}
	}
	/**
	 * 隐藏工具条上的指定项
	 * @param toolBarId
	 */
	public void hideToolItem(String actionId){
		if(actionId!=null && curDisplayToolBar!=null){
			curDisplayToolBar.remove(actionId);
			this.coolBar.update(true);
		}
	}
	/**
	 * 显示工具条上的指定项
	 * @param actionId
	 */
	public void showToolItem(String actionId){
		if(actionId!=null && curDisplayToolBar!=null){
			curDisplayToolBar.add(SmartRCPBuilder.actionManager.getAction(actionId));
			this.coolBar.update(true);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}

}
