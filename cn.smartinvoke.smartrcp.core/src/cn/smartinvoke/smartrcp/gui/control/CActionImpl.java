package cn.smartinvoke.smartrcp.gui.control;

import java.util.List;

import org.eclipse.jface.action.Action;

import cn.smartinvoke.gui.ObjectPool;
import cn.smartinvoke.smartrcp.gui.module.CEventBean;
import cn.smartinvoke.util.ImageManager;

public class CActionImpl extends Action{
	CAction bean;
	public CActionImpl(CAction bean){
		//TODO type.........
		super(bean.getText());
		this.bean=bean;
		System.out.println("create action type"+bean.getActionId());
    	this.setId(bean.getActionId());
    	this.setToolTipText(bean.getToolTip());
    	this.setChecked(bean.isChecked());
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
	public CActionImpl(){
		
	}
	public void run(){
	    CActionManager actionManager=(CActionManager)
	        ObjectPool.INSTANCE.getObject(GlobalServiceId.CAction_Manager);
	   CActionEntity actionEntity= actionManager.getActionEntity(this.getId());
	   if(actionEntity!=null){
		  List<CEventBean>  listeners=actionEntity.listeners;
		  for(int t=0;t<listeners.size();t++){
			  CEventBean eventBean=listeners.get(t);
			  if(eventBean!=null){
				  eventBean.fireAction(this.isChecked());
			  }
		  }
	   }
	}
}