package cn.smartinvoke.rcp;

import org.eclipse.ui.IMemento;

public class CLayoutBasicInfo {
	private static String key_layoutBasicInfo="key_layoutBasicInfo";
	//当前layout的viewId所对应的swf是否是模块swf
	public boolean isModuleSwf=true;
	//是否在FlashViewer打开的时候自动加载swf
	public boolean autoLoad=false;
	private String viewId=null;
	private String title;
	public String image=null;
	public CLayoutBasicInfo() {
		
	}
	public boolean init(IMemento memento){
		if(memento!=null){
			String info=memento.getString(key_layoutBasicInfo);
			if(info!=null){
				String[] items=info.split("\n");
				if(items!=null){
					this.isModuleSwf=Boolean.valueOf(items[0]);
					this.autoLoad=Boolean.valueOf(items[1]);
					this.viewId=items[2];
					this.title=items[3];
					this.image=items[4];
				}
			}
			return true;
		}else{
			return false;
		}
	}
	public void save(IMemento memento){
		if(memento!=null){
			String info=this.isModuleSwf+"\n"+this.autoLoad+"\n"+this.viewId
			            +"\n"+this.title+"\n"+this.image;
			memento.putString(key_layoutBasicInfo, info);
		}
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
	public static void main(String[] args) {
		String str="a\n b\n c\n";
		String[] items=str.split("\n");
		System.out.println(items);
	}
}
