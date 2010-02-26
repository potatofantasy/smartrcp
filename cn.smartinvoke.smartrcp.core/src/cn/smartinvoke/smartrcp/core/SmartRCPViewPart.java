package cn.smartinvoke.smartrcp.core;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import cn.smartinvoke.gui.FlashViewer;
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
		this.flashViewer.setModulePath(this.getConfigurationElement().getAttribute("id"));
		this.flashViewer.setParent(this);
		
		//添加到flashViewer集合
		//这里的flashViewer代表的并不是Flash容器，而是将swt的ViewPart 当做FlashViewer来对待
		FlashViewer.add_Viewer(flashViewer);
		//将当前打开的viewPart的信息添加进模块对应表中
		SplashWindow.getPerspective().
			page.addViewPartInfo(flashViewer.getModulePath(), flashViewer.getAppId());
		
		//super.setPartName(flashViewer.getAppId());
	}

	@Override
	public void setFocus() {
		
	}
	public FlashViewer getFlashViewer() {
		return flashViewer;
	}
	public void dispose(){
		if(this.flashViewer!=null){
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
