package cn.smartinvoke.rcp;

public class CLayoutBasicInfo {
	//当前layout的viewId所对应的swf是否是模块swf
	public boolean isModuleSwf=true;
	//是否在FlashViewer打开的时候自动加载swf
	public boolean autoLoad=false;
	private String viewId=null;
	private String title;
	public String image=null;
	public CLayoutBasicInfo() {
		
	}
	public String getViewId() {
		return viewId;
	}
	public void setViewId(String viewId) {
		this.viewId = viewId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
