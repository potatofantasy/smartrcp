package cn.smartinvoke.smartrcp.core;

import java.util.Map;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import cn.smartinvoke.gui.FlashViewer;
import cn.smartinvoke.rcp.CLayoutBasicInfo;
import cn.smartinvoke.smartrcp.gui.SplashWindow;
/**
 * 在SmartRCP中，只有两种ViewPart，分别是FlashViewPart，
 * 和SmartRCPViewPart，前者用于加载flex应用，后者是java所有扩展ViewPart的超类，方便Java对SmartRCP
 * 的扩展，实现Flex与java的互操作
 * @author pengzhen
 *
 */
public abstract class SmartRCPViewPart extends ViewPart {
    private FlashViewer flashViewer;
	public SmartRCPViewPart() {
		
	}

	@Override
	public void createPartControl(Composite parent) {
		String appId=null;
		String secondId=this.getViewSite().getSecondaryId();
		if(secondId!=null){
			appId=secondId;
		}else{
			appId=FlashViewer.getViewNum()+"";
		}
		this.flashViewer=new FlashViewer(appId);
		CLayoutBasicInfo layoutInfo =this.getLayoutInfo();
		String moduleStr=null;
   	    if(layoutInfo!=null){
   	    	moduleStr=layoutInfo.modulePath;
   	    }else{
   	    	moduleStr=this.getConfigurationElement().getAttribute("id");
   	    }
		this.flashViewer.setModulePath(moduleStr);
		this.flashViewer.setParent(this);
		
		//添加到flashViewer集合
		//这里的flashViewer代表的并不是Flash容器，而是将swt的ViewPart 当做FlashViewer来对待
		FlashViewer.add_Viewer(flashViewer);
		
	}
   	 /**
   	  * 从全局布局map中取出与当前viewPart对应的CLayoutBasicInfo，如果没有则返回null
   	  * @return
   	  */
    protected CLayoutBasicInfo getLayoutInfo(){
    	String secondId=this.getViewSite().getSecondaryId();
    	Map<Integer, CLayoutBasicInfo> layoutMap = Perspective.swfLayoutMap;
   	    CLayoutBasicInfo layoutInfo =layoutMap.get(Integer.valueOf(secondId));
    	return layoutInfo;
    }
	@Override
	public void setFocus() {
		
	}
	public FlashViewer getFlashViewer() {
		return flashViewer;
	}
	public void dispose(){
		if(this.flashViewer!=null){
			Perspective.swfLayoutMap.remove(Integer.valueOf(this.flashViewer
					.getAppId()));
			FlashViewer.remove_Viewer(this.flashViewer);
		}
	}
	public String getType(){
    	return "SmartRCPViewPart";
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}

}
