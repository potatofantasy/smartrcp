package cn.smartinvoke.smartrcp.gui.control;

import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

import cn.smartinvoke.ObjectPool;
import cn.smartinvoke.smartrcp.gui.CAppToolBarManager;
import cn.smartinvoke.smartrcp.gui.module.CActionEntity;
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
    	this.setId(bean.getActionId());
    	 // Associate the action with a pre-defined command, to allow key bindings.
    	this.setActionDefinitionId(bean.getActionId());
    	this.setToolTipText(bean.getToolTip());
    	try{
    	String imgUrl=bean.getImageUrl();
    	if(imgUrl!=null){
    		this.setImageDescriptor(ImageManager.getImageDescriptor(imgUrl));
    	}
		String hoverImg=bean.getHoverImageUrl();
		if(hoverImg!=null){
    		this.setHoverImageDescriptor(ImageManager.getImageDescriptor(hoverImg));
    	}
		String disableImg=bean.getDisableImageUrl();
		if(disableImg!=null){
    		this.setDisabledImageDescriptor(ImageManager.getImageDescriptor(disableImg));
    	}
    	}catch(Exception e){};
	}
//    public void update(CAction bean){
//    	if(bean!=null){
//    		this.setChecked(bean.isChecked());
//    		this.setEnabled(bean.isEnable());
//    		this.setText(bean.getText());
//    		this.setToolTipText(bean.getToolTip());
//    	}
//    }
    private static CAppToolBarManager appToolBarManager;
	public void run(){
	   cn.smartinvoke.ObjectPool pool=ObjectPool.INSTANCE;
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
				 CActionEvent actionEvent=new CActionEvent();
				 if(EventFilter.cur_point!=null){
				   try{
					    //设置工具栏action的点击位置
					    ToolBarManager toolBarManager=appToolBarManager.getToolBarManager();
				        ToolBar  toolBar=toolBarManager.getControl();
				        ToolItem toolItem=toolBar.getItem(EventFilter.cur_point);
				        if(toolItem!=null){
				         Rectangle rect = toolItem.getBounds ();
				         Point pt = new Point (rect.x, rect.y + rect.height);
				         actionEvent.x=pt.x;actionEvent.y=pt.y;
				        }
				   }catch(Throwable e){};
				   EventFilter.cur_point=null;
				 }
				 actionEvent.checked=this.isChecked();
				 actionEvent.actionId=this.getId();
				 actionEvent.path=this.getDescription();
				 
				 eventBean.fireAction(actionEvent);
				}catch(Throwable e){
					e.printStackTrace();
				}
			  }
		  }
	   }
	}
}