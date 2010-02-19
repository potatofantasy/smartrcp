package cn.smartinvoke.smartrcp.gui.control;

import java.util.List;

import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

import cn.smartinvoke.gui.ObjectPool;
import cn.smartinvoke.smartrcp.gui.CAppToolBarManager;
import cn.smartinvoke.smartrcp.gui.ViewPartActionBar;
import cn.smartinvoke.smartrcp.gui.module.CActionEntity;
import cn.smartinvoke.smartrcp.gui.module.CActionEvent;
import cn.smartinvoke.smartrcp.gui.module.CEventBean;

public class CViewPartActionImpl extends CActionImpl {
    private ViewPartActionBar actionBar;
	public CViewPartActionImpl() {
		
	}

	public CViewPartActionImpl(String text, int style, boolean checked) {
		super(text, style, checked);
		
	}

	public CViewPartActionImpl(String text) {
		super(text);
		
	}

	public CViewPartActionImpl(String text, int type) {
		super(text, type);
		
	}
    public void init(CAction bean,ViewPartActionBar actionBar){
    	super.init(bean);
    	this.actionBar=actionBar;
    }
    public void run(){
 	   CActionEntity actionEntity=this.actionBar.getActionEntity(this.getId());
 	   if(actionEntity!=null){
 		  List<CEventBean>  listeners=actionEntity.listeners;
 		  for(int t=0;t<listeners.size();t++){
 			  CEventBean eventBean=listeners.get(t);
 			  if(eventBean!=null){
 				 CActionEvent actionEvent=new CActionEvent();
 				 actionEvent.checked=this.isChecked();
 				 actionEvent.actionId=this.getId();
 				 actionEvent.path=this.getDescription();
 				 eventBean.fireAction(actionEvent);
 			  }
 		  }
 	   }
 	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}

}
