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
import cn.smartinvoke.rcp.CLayout;
import cn.smartinvoke.rcp.CLayoutBasicInfo;
import cn.smartinvoke.rcp.CPageLayout;
import cn.smartinvoke.rcp.CPerspective;
import cn.smartinvoke.rcp.CStandaloneLayout;
import cn.smartinvoke.rcp.ICFolderLayout;
import cn.smartinvoke.smartrcp.gui.SplashWindow;
public class Perspective implements IPerspectiveFactory {
	public static final String ID="cn.smartinvoke.smartrcp.core.Perspective";
	/*public void createInitialLayout(IPageLayout layout) {
		String editorArea = layout.getEditorArea();
		layout.setEditorAreaVisible(false);
		layout.setFixed(true);
		layout.addView(FlashViewPart.ID+":1", IPageLayout.TOP, 0.5f, editorArea);
		layout.addView(FlashViewPart.ID+":2", IPageLayout.RIGHT, 0.5f, FlashViewPart.ID+":1");//"org.eclipse.ui.browser.view"
		//layout.addView("org.eclipse.ui.browser.view", IPageLayout.BOTTOM, 0.5f, FlashView.ID);
		//layout.addView(Test.ID, IPageLayout.BOTTOM, 0.5f, editorArea);
		
		
	}*/
	//private int viewNum=0;
	private String viewId=FlashViewPart.ID;
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
			layout.setFixed(false);
			layoutMap.put(pageLayout, editorArea);
			//
			List<CFolderLayout> folderLayouts=pageLayout.getFolderLayouts();
			if(folderLayouts!=null){
			  for(int i=0;i<folderLayouts.size();i++){
				  CFolderLayout folderLayout=folderLayouts.get(i);
				  layoutMap.put(folderLayout, "folderLayout"+i);
				  folderLayout.setCreate(false);
			  }
			}
			//设置布局
			if(folderLayouts!=null){
				  for(int i=0;i<folderLayouts.size();i++){
					  createFolder(folderLayouts.get(i));
				  }
		    }
			//
			List<CStandaloneLayout> standaloneLayouts=pageLayout.getStandaloneLayouts();
			if(standaloneLayouts!=null){
				for(int t=0;t<standaloneLayouts.size();t++){
					//CStandaloneLayout standaloneLayout=standaloneLayouts.get(t);
					createStandaloneFolder(standaloneLayouts.get(t));
				}
			}
		}
		
	}
	private void createFolder(CFolderLayout folderLayout){
		//CFolderLayout folderLayout=folderLayouts.get(i);
		  if(folderLayout==null || folderLayout.isCreate()){
			  return;
		  }
		  
		  String folderName=layoutMap.get(folderLayout);
		  ICFolderLayout refFolder=folderLayout.getRefLayout();
		  if(refFolder==null){
			  refFolder=pageLayout;
		  }else if(refFolder!=this.pageLayout){
			  if(refFolder instanceof CFolderLayout){
				  this.createFolder((CFolderLayout)refFolder);
			  }
		  }
		  
		  String relFolderName=layoutMap.get(refFolder);
		  if(folderName!=null && relFolderName!=null){
			 // System.out.println(">"+folderName+"*"+folderLayout.getRelationship()+"*"+folderLayout.getRatio());
		   IFolderLayout folder = layout.createFolder(folderName,folderLayout.getRelationship(),(float)folderLayout.getRatio(),
				   relFolderName);
		   String viewIdSstr=this.getViewIdString(folderLayout);
		   folder.addView(viewIdSstr);
		   //TODO　ｎａｍｅ
		   IViewLayout viewPart=layout.getViewLayout(viewIdSstr);
		   viewPart.setCloseable(folderLayout.isCloseable());
		   viewPart.setMoveable(folderLayout.isMoveable());
		   
		   folderLayout.setCreate(true);
		  }
	}
	private void createStandaloneFolder(CStandaloneLayout standaloneLayout){
		//CStandaloneLayout standaloneLayout=standaloneLayouts.get(t);
		if(standaloneLayout==null){
			return;
		}
		//String folderName=layoutMap.get(standaloneLayout);
		ICFolderLayout refFolder=standaloneLayout.getRefLayout();
		if(refFolder==null){
			  refFolder=pageLayout;
		}else if(refFolder!=this.pageLayout){
			  if(refFolder instanceof CFolderLayout){
				  this.createFolder((CFolderLayout)refFolder);
			  }
		}
		String relFolderName=layoutMap.get(refFolder);
		if(relFolderName!=null){
			String viewIdSstr=this.getViewIdString(standaloneLayout);
			//System.out.println(">"+viewIdSstr+"*"+standaloneLayout.getRelationship()+"*"+standaloneLayout.getRatio());
			layout.addStandaloneView(viewIdSstr, standaloneLayout.isShowTitle(), standaloneLayout.getRelationship(),
					(float)standaloneLayout.getRatio(),relFolderName);
			
			layout.getViewLayout(viewIdSstr).setCloseable(standaloneLayout.isCloseable());
			layout.getViewLayout(viewIdSstr).setMoveable(standaloneLayout.isMoveable());
			
		}
	}
	private String getViewIdString(CLayout layout){
		   String viewIdSstr=null;
		   String layoutViewStr=layout.getViewId();
		   if(layoutViewStr!=null && layoutViewStr.endsWith(".swf")){
			   int viewNum=FlashViewer.getViewNum();
			   viewIdSstr=viewId+":"+viewNum;
               swfLayoutMap.put(viewNum,layout);
		   }else{
			   viewIdSstr=layoutViewStr;
		   }
		return viewIdSstr;
	}
	public static Map<Integer,CLayoutBasicInfo> swfLayoutMap=new HashMap<Integer, CLayoutBasicInfo>();
	
	
}
