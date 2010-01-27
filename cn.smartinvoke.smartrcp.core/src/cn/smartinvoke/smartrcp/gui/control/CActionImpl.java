package cn.smartinvoke.smartrcp.gui.control;

import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

import cn.smartinvoke.gui.ObjectPool;
import cn.smartinvoke.smartrcp.gui.CAppToolBarManager;
import cn.smartinvoke.smartrcp.gui.module.CActionEvent;
import cn.smartinvoke.smartrcp.gui.module.CEventBean;
import cn.smartinvoke.util.ImageManager;

public class CActionImpl extends Action{
	public CActionImpl(){
      	
	}
	public CActionImpl(String text, int style,boolean checked) {
		this(text, style);
		this.setChecked(checked);
	}

	public CActionImpl(String text) {
		super(text);
	}
	public CActionImpl(String text,int type) {
		super(text,type);
	}
    public void init(CAction bean){
		//this.bean=bean;
		System.out.println("create action type"+bean.getActionId());
    	this.setId(bean.getActionId());
    	this.setToolTipText(bean.getToolTip());
    	try{
    	String imgUrl=bean.getImageUrl();
    	if(imgUrl!=null){
    		this.setImageDescriptor(ImageManager.getImageDescriptor(imgUrl));
    	}
		String hoverImg=bean.getHoverImageUrl();
		if(hoverImg!=null){
    		this.setImageDescriptor(ImageManager.getImageDescriptor(hoverImg));
    	}
		String disableImg=bean.getDisableImageUrl();
		if(disableImg!=null){
    		this.setImageDescriptor(ImageManager.getImageDescriptor(disableImg));
    	}
    	}catch(Exception e){};
	}
    private static CAppToolBarManager appToolBarManager;
	public void run(){
	   ObjectPool pool=ObjectPool.INSTANCE;
	   CActionManager actionManager=(CActionManager)pool.getObject(GlobalServiceId.CAction_Manager);
	   CActionEntity actionEntity= actionManager.getActionEntity(this.getId());
	   if(appToolBarManager==null){
		 appToolBarManager=(CAppToolBarManager)pool.getObject(GlobalServiceId.App_ToolBar_Manager);
	   }
	   
	   if(actionEntity!=null){
		  List<CEventBean>  listeners=actionEntity.listeners;
		  for(int t=0;t<listeners.size();t++){
			  CEventBean eventBean=listeners.get(t);
			  if(eventBean!=null){
				try{
				 ToolBar toolBar=appToolBarManager.curDisplayToolBar.getControl();
				 ToolItem toolItem=
					 toolBar.getItem(EventFilter.cur_point);
				 Rectangle rect = toolItem.getBounds ();
				 Point pt = new Point (rect.x, rect.y + rect.height);
				 //toolItem.getControl()
				 //pt = toolBar.toDisplay (pt);
				 CActionEvent actionEvent=new CActionEvent();
				 actionEvent.x=pt.x;actionEvent.y=pt.y;
				 actionEvent.checked=this.isChecked();
				 eventBean.fireAction(actionEvent);
				}catch(Throwable e){
					e.printStackTrace();
				}
			  }
		  }
	   }
	}
}