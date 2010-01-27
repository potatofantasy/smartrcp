package cn.smartinvoke.smartrcp.gui.control;

import java.util.List;

import cn.smartinvoke.smartrcp.gui.module.CEventBean;

public class CNativeActionImpl extends CActionImpl {

	public CNativeActionImpl() {
		
	}

	public CNativeActionImpl(String text, int style, boolean checked) {
		super(text, style, checked);
		
	}
    
	public CNativeActionImpl(String text) {
		super(text);
		
	}
	private List<CEventBean> listeners;
	public void init(CAction bean,List<CEventBean> listeners){
		super.init(bean);
		this.listeners=listeners;
	}
    public void run(){
    	
    }
    public boolean equals(Object anoth) {
		boolean ret = false;
		if (anoth instanceof CNativeActionImpl) {
			CNativeActionImpl action = (CNativeActionImpl) anoth;
			String thisId=this.getId();
	        String anothId=action.getId();
	        if(thisId!=null && anothId!=null){
	        	if(thisId.equals(anothId)){
	        		return true;
	        	}
	        }
		}
		return ret;
	}
	public int hashCode() {
		if(this.getId()!=null){
			return this.getId().hashCode();
		}
		return -1;
	}
}
