package cn.smartinvoke.rcp;

import org.eclipse.ui.IMemento;

public class CLayoutBasicInfo {
	private static String key_layoutBasicInfo="smartrcp_key_layoutBasicInfo";
	//当前layout的viewId所对应的swf是否是模块swf
	public boolean isModuleSwf=true;
	//是否在FlashViewer打开的时候自动加载swf
	public boolean autoLoad=false;
	//RCP的viewPart定义ID
	public String viePartId=null;
	//需要加载的模块的Id
	public String modulePath=null;
    
	public boolean closeable = true;
	public boolean moveable = true;
	
	public String title;
	public String image=null;
	public CLayoutBasicInfo(){
	   
	}
	public boolean init(IMemento memento){
		if(memento!=null){
			String info=memento.getString(key_layoutBasicInfo);
			if(info!=null){
				String[] items=info.split("\n");
				if(items!=null){
					this.isModuleSwf=Boolean.valueOf(items[0]);
					this.autoLoad=Boolean.valueOf(items[1]);
					this.modulePath=items[2];
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
			String info=this.isModuleSwf+"\n"+this.autoLoad+"\n"+this.modulePath
			            +"\n"+this.title+"\n"+this.image;
			memento.putString(key_layoutBasicInfo, info);
		}
	}
	
	public static void main(String[] args) {
		String str="a\n b\n c\n";
		String[] items=str.split("\n");
		System.out.println(items);
	}
}
