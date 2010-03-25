package smartrcp.platform;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

import smartrcp.platform.views.AppBrowserView;
import smartrcp.platform.views.PlatAppMana;
import smartrcp.platform.views.PlatAppSearch;
import smartrcp.platform.views.PlatformViewPart;

import cn.smartinvoke.gui.FlashViewer;
import cn.smartinvoke.rcp.CLayoutBasicInfo;

public class Perspective implements IPerspectiveFactory {
    
	public void createInitialLayout(IPageLayout layout) {
		String editorArea = layout.getEditorArea();
		layout.setEditorAreaVisible(false);
		layout.setFixed(false);
		
		IFolderLayout folderLayout=layout.createFolder("top", IPageLayout.TOP, 0.5f,editorArea);
		
		folderLayout.addPlaceholder(AppBrowserView.ID+":*");
		//添加程序管理视图
		folderLayout.addView(PlatAppMana.ID);
		
		String appViewSecId=AppBrowserView.getViewNum("C:/HTMLPage1.htm")+"";
		folderLayout.addView(AppBrowserView.ID+":"+appViewSecId);
		
		String progressId="org.eclipsercp.hyperbola.views.progress";
		folderLayout.addView(progressId);
		
		layout.getViewLayout(PlatAppMana.ID).setCloseable(false);
		layout.getViewLayout(AppBrowserView.ID).setCloseable(false);
		layout.getViewLayout(progressId).setCloseable(false);
		//
	    
	}
    private int initFlashViewPart(String path,String title){
    	CLayoutBasicInfo basicInfo=new CLayoutBasicInfo();
    	basicInfo.autoLoad=true;basicInfo.isModuleSwf=false;
    	basicInfo.setViewId(path);
    	basicInfo.setTitle(title);
    	
    	int appId = FlashViewer.getViewNum();
    	cn.smartinvoke.smartrcp.core.Perspective.swfLayoutMap.put(appId, basicInfo);
    	return appId;
    }
}
