package cn.smartinvoke.smartrcp.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.IViewLayout;

import cn.smartinvoke.gui.FlashViewer;
import cn.smartinvoke.rcp.CFolderLayout;
import cn.smartinvoke.rcp.CLayoutBasicInfo;
import cn.smartinvoke.rcp.CPageLayout;
import cn.smartinvoke.rcp.CPerspective;
import cn.smartinvoke.rcp.CStandaloneLayout;
import cn.smartinvoke.rcp.ICFolderLayout;
import cn.smartinvoke.smartrcp.gui.FlashViewPart;
import cn.smartinvoke.smartrcp.gui.SplashWindow;
import cn.smartinvoke.util.Log;
public class Perspective implements IPerspectiveFactory {
	public static final String ID="cn.smartinvoke.smartrcp.core.perspective";
	
	private IPageLayout layout;
	//布局块表
	private HashMap<ICFolderLayout,String> layoutMap=new HashMap<ICFolderLayout, String>();
	private CPageLayout pageLayout;
	public void createInitialLayout(IPageLayout layout) {
		CPerspective perspective=SplashWindow.getPerspective();
		if(perspective==null){
			return;
		}
		
		this.layout=layout;
		
		pageLayout=perspective.page;
		if(pageLayout!=null){
			String editorArea = layout.getEditorArea();
			layout.setEditorAreaVisible(pageLayout.isEditorAreaVisible());
			layout.setFixed(pageLayout.fixed);
			layoutMap.put(pageLayout, editorArea);
			//
			List<ICFolderLayout> layouts=pageLayout.getLayouts();
			if(layouts!=null){
			  for(int i=0;i<layouts.size();i++){
				  ICFolderLayout cLayout=layouts.get(i);
				  if(cLayout instanceof CFolderLayout){
				   CFolderLayout folderLayout=(CFolderLayout)cLayout;
				   layoutMap.put(folderLayout, "folderLayout"+i);
				   //folderLayout.setCreate(false);
				  }
			  }
			 //设置布局
			  for(int i=0;i<layouts.size();i++){
				ICFolderLayout cLayout=layouts.get(i);
				if(cLayout!=null){
				  if(cLayout instanceof CFolderLayout){
					createFolder((CFolderLayout)cLayout);
				  }
				  if(cLayout instanceof CStandaloneLayout){
					createStandaloneFolder((CStandaloneLayout)cLayout);
				  }
				}
			  }
			}
			
			
		}
		
	}
	private void createFolder(CFolderLayout folderLayout){
		//CFolderLayout folderLayout=folderLayouts.get(i);
		  if(folderLayout==null){
			  return;
		  }
		  
		String folderName = layoutMap.get(folderLayout);
		ICFolderLayout refFolder = folderLayout.refLayout;
		if (refFolder == null) {
			refFolder = pageLayout;
		}
		String relFolderName = layoutMap.get(refFolder);
		// 创建folder并将module add进folderlayout
		if (folderName != null && relFolderName != null) {
			IFolderLayout folder = layout.createFolder(folderName,
					folderLayout.relationship, (float) folderLayout.ratio,
					relFolderName);
			if (folderLayout.placeholderViewPartId != null) {
				folder
						.addPlaceholder(folderLayout.placeholderViewPartId
								+ ":*");
			}
			// ----
			List<CLayoutBasicInfo> modules = folderLayout.getModules();
			for (int i = 0; i < modules.size(); i++) {
				CLayoutBasicInfo module = modules.get(i);
				if (module != null) {
					String viewIdSstr = this.getViewIdString(module);
					if (viewIdSstr != null) {
						folder.addView(viewIdSstr);
						IViewLayout viewPart = layout.getViewLayout(viewIdSstr);
						viewPart.setCloseable(module.closeable);
						viewPart.setMoveable(module.moveable);
					}
				}
			}
		}
	}
	private void createStandaloneFolder(CStandaloneLayout standaloneLayout){
		if(standaloneLayout==null){
			return;
		}
		ICFolderLayout refFolder=standaloneLayout.refLayout;
		if(refFolder==null){
			  refFolder=pageLayout;
		}
		String relFolderName=layoutMap.get(refFolder);
		if(relFolderName!=null){
			CLayoutBasicInfo module=standaloneLayout.module;
		   if(module!=null){
			String viewIdSstr=this.getViewIdString(module);
			if(viewIdSstr!=null){
			 layout.addStandaloneView(viewIdSstr, standaloneLayout.showTitle, standaloneLayout.relationship,
					(float)standaloneLayout.ratio,relFolderName);
			 
			 layout.getViewLayout(viewIdSstr).setCloseable(module.closeable);
			 layout.getViewLayout(viewIdSstr).setMoveable(module.moveable);
			}
		   }
		}
		
	}
	private String getViewIdString(CLayoutBasicInfo layoutInfo){
		   String viewIdSstr=null;
		   //String modulePath=layoutInfo.modulePath;
		   if(layoutInfo.viePartId!=null){
			   int viewNum=FlashViewer.getViewNum();
			   viewIdSstr=layoutInfo.viePartId+":"+viewNum;
               swfLayoutMap.put(viewNum,layoutInfo);
		   }
		return viewIdSstr;
	}
	public static Map<Integer,CLayoutBasicInfo> swfLayoutMap=new HashMap<Integer, CLayoutBasicInfo>();
	
	
}
