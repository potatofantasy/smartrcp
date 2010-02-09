package cn.smartinvoke.smartrcp.gui.control;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.internal.PartListenerList2;
import org.eclipse.ui.part.ViewPart;

import cn.smartinvoke.IServerObject;
import cn.smartinvoke.gui.FlashViewer;
import cn.smartinvoke.rcp.CLayoutBasicInfo;
import cn.smartinvoke.rcp.CPerspective;
import cn.smartinvoke.smartrcp.core.Perspective;
import cn.smartinvoke.smartrcp.core.SmartRCPBuilder;
import cn.smartinvoke.smartrcp.gui.FlashViewPart;
import cn.smartinvoke.smartrcp.gui.module.CObservable;
import cn.smartinvoke.smartrcp.gui.module.CPartEvent;
import cn.smartinvoke.util.Log;

/**
 * 视图管理器，主要是flex调用此类的方法，实现java与flex的同步 这里的视图包括：ViewPart ,Shell窗口
 * 
 * @author pengzhen
 * 
 */
public class ViewManager  extends CObservable implements IServerObject{
    private IWorkbenchPage page;
    public static FlashViewer fillViewerList(String num,String viewId,IWorkbenchPart workbenchPart){
    	//创建与java ViewPart对应的FlashViewer
		 FlashViewer flashViewer=new FlashViewer(num+"");
		 flashViewer.setSwfPath(viewId);
		 flashViewer.setParent(workbenchPart);
		   //添加到flashViewer集合
		   //这里的flashViewer代表的并不是Flash容器，而是将swt的ViewPart 当做FlashViewer来对待
		 FlashViewer.add_Viewer(flashViewer);
		 return flashViewer;
    }
	public ViewManager() {
        
	}
	public void initIWorkbenchPageListener(IWorkbenchPage page){
		this.page=page;
		if(page!=null){
			page.addPartListener(new IPartListener(){

				public void partActivated(IWorkbenchPart part) {
					fireEvent(CPartEvent.Part_Activated, part);
				}

				public void partBroughtToTop(IWorkbenchPart part) {
					fireEvent(CPartEvent.Part_BroughtToTop, part);
				}

				public void partClosed(IWorkbenchPart part) {
					//从FlashViewer集合中删除掉当前关闭的ViewPart
					List<FlashViewer> curViews=FlashViewer.getViewers();//当前的所有FlashViewer
					for(int n=0;n<curViews.size();n++){
						FlashViewer viewer=curViews.get(n);
						if(viewer.getParent().equals(part)){//
							fireFlashViewer(CPartEvent.Part_Closed,viewer);
							curViews.remove(n);
							break;
						}
					}
					
				}

				public void partDeactivated(IWorkbenchPart part) {
					fireEvent(CPartEvent.Part_Deactivated, part);
				}
				public void partOpened(IWorkbenchPart part) {
					fireEvent(CPartEvent.Part_Opened, part);
				}
			});
		}
	}
	private void fireEvent(int type,IWorkbenchPart part){
		//FlashViewer flashViewer=null;
		if(part!=null){
			List<FlashViewer> flashViewers=FlashViewer.getViewers();
			for(int n=0;n<flashViewers.size();n++){
				FlashViewer flashViewer=flashViewers.get(n);
				if(flashViewer.getParent().equals(part)){
					fireFlashViewer(type,flashViewer);
					break;
				}
			}
		}
	}
	private void fireFlashViewer(int type,FlashViewer flashViewer){
		if(flashViewer!=null){
			CPartEvent partEvent=new CPartEvent();
			partEvent.type=type;
			partEvent.taget=flashViewer;
			
			ViewManager.this.fireEvent(partEvent);
		}
	}
    //private Map<String,Integer> multiplViewNum=new HashMap<String, Integer>();
	/**
	 * 根据配置信息打开一viewPart
	 * 如果CLayoutBasicInfo 的viewId以.swf结尾，打开FlashViewPart视图，并加载对应的swf，
	 * 否则打开viewId在plugin.xml中定义的视图。
	 * 
	 * @param basicInfo
	 * @return
	 */
	public FlashViewer openViewPart(CLayoutBasicInfo basicInfo,boolean isMultiple, int state) {
		try {
			FlashViewer ret=null;int appId=-1;
			if (basicInfo != null) {
				String viewId=basicInfo.getViewId();
				if(viewId!=null){
				  // IWorkbenchPage page=SmartRCPBuilder.window.getActivePage();
				   
				   if(viewId.endsWith(".swf")){//如果是swf
					  appId = FlashViewer.getViewNum();
					  basicInfo.autoLoad=true;//设置为true，以便FlashViewPart自动加载swf
					  Perspective.swfLayoutMap.put(Integer.valueOf(appId),basicInfo);
					  
					  FlashViewPart flashViewPart=(FlashViewPart)page.showView(FlashViewPart.ID, appId + "",state);
					  ret=flashViewPart.getFlashViewer();
				   }else{
					  Integer num=FlashViewer.getViewNum();
					  IViewPart showView=null;
					  if(isMultiple){
						 try{
						 showView=page.showView(viewId, num+"", state);
						 }catch(Exception e){e.printStackTrace();};
					  }
					  if(showView==null){
					    showView=page.showView(viewId);
					  }
					  if(showView!=null){
					   ret=fillViewerList(num+"", viewId, showView);
					  }
				   }
				}
			}
			return ret;
		} catch (Throwable e) {
			if(basicInfo!=null){
			  throw new RuntimeException("view "+basicInfo.getViewId()+" create fault,check isMultiple param or viewId");
			}else{
			  throw new RuntimeException(e.getMessage());
			}
		}
	}
	public void showViewPart(String appId,int state){
		if(appId!=null){
		 FlashViewer flashViewer=this.findFlashViewer(appId);
		 if(flashViewer!=null){
		  Object parent=flashViewer.getParent();
		  if(parent instanceof IViewPart){
			//IWorkbenchPage page=SmartRCPBuilder.window.getActivePage();
			if(state==IWorkbenchPage.VIEW_ACTIVATE){
				page.activate((IViewPart)parent);
			}else{
				page.bringToTop((IViewPart)parent);
			}
		  }
		 }
		}
	}
	
	/**
	 * 关闭加载了modulePath模块的所有视图
	 * @param modulePath
	 */
	public void closeViewParts(String modulePath){
		if(modulePath!=null){
		  List<FlashViewer> views=this.findFlashViewers(modulePath);
		  for(int n=0;n<views.size();n++){
			  FlashViewer viewer=views.get(n);
			  this.closeViewPart(viewer.getParent());
		  }
		}
	}
	
	/**
	 * 关闭指定appId的视图
	 * @param appId
	 */
	public void closeViewPart(String appId){
		if(appId!=null){
			 FlashViewer flashViewer=this.findFlashViewer(appId);
			 if(flashViewer!=null){
			  this.closeViewPart(flashViewer.getParent());
			 }
		}
	}
	private void closeViewPart(Object parent){
		if(parent!=null && parent instanceof ViewPart){
			ViewPart viewPart=(ViewPart)parent;
			
			page.hideView(viewPart);
			viewPart.dispose();
		}
	}
	//--------------------FlashView的管理方法
	/**
	 * 将指定的viewpart最大化
	 */
	public void  setState(String viewPartId,int state){
		//FlashViewer ret=null;
		if(viewPartId!=null){
		  FlashViewer flashViewer=this.findFlashViewer(viewPartId);
		  if(flashViewer!=null){
			  Object parent=flashViewer.getParent();
			  if(parent!=null && parent instanceof ViewPart){
				    ViewPart viewPart=(ViewPart)parent;
					//IWorkbenchPage page=SmartRCPBuilder.window.getActivePage();
				    
					//首先获得焦点
					page.activate(viewPart);
					//最大化
					page.setPartState(page.getActivePartReference(),state);
			  }
		  }
		}
		//return ret;
	}
	
	/**
	 * 获得当前获得焦点的viewPart
	 * @return
	 */
	public FlashViewer getActiveViewPart(){
		FlashViewer ret=null;
		IWorkbenchPart part=page.getActivePart();
		
		if(part!=null){
		  if(part instanceof FlashViewPart){
			FlashViewPart flashViewPart=(FlashViewPart)part;
			ret=flashViewPart.getFlashViewer();
		  }else{
			//java的ViewPart
			List<FlashViewer> curViews=FlashViewer.getViewers();
			for(int n=0;n<curViews.size();n++){
				FlashViewer viewer=curViews.get(n);
				if(viewer.getParent().equals(part)){
					return viewer;
				}
			}
		  }
		}
		return ret;
	}
	public List<String> findAppIds(String modulePath){
		List<String> ret=new LinkedList<String>();
		if(modulePath!=null){
			if(modulePath.endsWith(".swf")){
			 modulePath=CPerspective.getRuntimeSwfFolder() + "/"+modulePath;
			}
			List<FlashViewer> curViews=FlashViewer.getViewers();//当前的所有FlashViewer
			for(int n=0;n<curViews.size();n++){
				FlashViewer viewer=curViews.get(n);
				if(viewer.getSwfPath().equals(modulePath)){
					ret.add(viewer.getAppId());
				}
			}
		}
		return ret;
	}
	public List<FlashViewer> findFlashViewers(String modulePath){
		List<FlashViewer> ret=new LinkedList<FlashViewer>();
		if(modulePath!=null){
			if(modulePath.endsWith(".swf")){
			  modulePath=CPerspective.getRuntimeSwfFolder() + "/"+modulePath;
			}
			List<FlashViewer> curViews=FlashViewer.getViewers();//当前的所有FlashViewer
			for(int n=0;n<curViews.size();n++){
				FlashViewer viewer=curViews.get(n);
				if(viewer.getSwfPath().equals(modulePath)){
					ret.add(viewer);
				}
			}
		}
		return ret;
	}
	
	public FlashViewer findFlashViewer(String appId){
		if(appId!=null){
			List<FlashViewer> curViews=FlashViewer.getViewers();//当前的所有FlashViewer
			for(int n=0;n<curViews.size();n++){
				FlashViewer viewer=curViews.get(n);
				if(viewer.getAppId().equals(appId)){
					return viewer;
				}
			}
		}
		return null;
	}
	private ViewPart findViewPart(String appId){
		ViewPart ret=null;
		FlashViewer flashViewer=this.findFlashViewer(appId);
		if(flashViewer!=null){
			Object parent=flashViewer.getParent();
			if(parent instanceof IViewPart){
			  	 ret=(ViewPart)parent;
			}
		}
		return ret;
	}
	public void resetViews(){
		this.page.resetPerspective();
		/*this.page.activate(part);
		this.page.bringToTop(part);
		this.page.close();
		this.page.hideView(view);
		this.page.isPartVisible(part);
		this.page.setPartState(ref, state)
		this.page.f*/
	}
	public void close(){
		this.page.close();
	}
	public void activate(String appId){
		ViewPart viewPart=this.findViewPart(appId);
		if(viewPart!=null){
			this.page.activate(viewPart);
		}
	}
	public void bringToTop(String appId){
		ViewPart viewPart=this.findViewPart(appId);
		if(viewPart!=null){
			this.page.bringToTop(viewPart);
		}
	}
	public void hideView(String appId){
		ViewPart viewPart=this.findViewPart(appId);
		if(viewPart!=null){
			this.page.hideView(viewPart);
		}
	}
	public boolean isPartVisible(String appId){
		ViewPart viewPart=this.findViewPart(appId);
		//if(viewPart!=null){
		return this.page.isPartVisible(viewPart);
	}
	public static void main(String[] args) {
		System.out.println(IWorkbenchPage.STATE_MAXIMIZED);
		System.out.println(IWorkbenchPage.STATE_MINIMIZED);
		System.out.println(IWorkbenchPage.STATE_RESTORED);
	}
	public void dispose() {
		
	}
}
