package cn.smartinvoke.smartrcp.gui.control;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.part.ViewPart;

import cn.smartinvoke.IServerObject;
import cn.smartinvoke.gui.FlashViewer;
import cn.smartinvoke.rcp.CLayoutBasicInfo;
import cn.smartinvoke.rcp.CPageLayout;
import cn.smartinvoke.rcp.CPerspective;
import cn.smartinvoke.smartrcp.core.Perspective;
import cn.smartinvoke.smartrcp.core.SmartRCPViewPart;
import cn.smartinvoke.smartrcp.gui.FlashViewPart;
import cn.smartinvoke.smartrcp.gui.module.CObservable;
import cn.smartinvoke.smartrcp.gui.module.CPartEvent;
import cn.smartinvoke.smartrcp.util.UIHelpMethod;
import cn.smartinvoke.util.Log;

/**
 * 视图管理器，主要是flex调用此类的方法，实现java与flex的同步 这里的视图包括：ViewPart ,Shell窗口
 * 
 * @author pengzhen
 * 
 */
public class ViewManager  extends CObservable implements IServerObject{
    private IWorkbenchPage page;
    /**
     * 单实例
     */
    public static final ViewManager Instance=new ViewManager();
    /**
     * 为非FlashViewPart视图创建FlashViewer对象，并添加到FlashViewer集合，以便ViewManager统一管理
     * @param num
     * @param viewId
     * @param workbenchPart
     * @return
     
    public static FlashViewer fillViewerList(String num,String viewId,IWorkbenchPart workbenchPart){
    	//创建与java ViewPart对应的FlashViewer
		 FlashViewer flashViewer=new FlashViewer(num+"");
		 flashViewer.setModulePath(viewId);
		 flashViewer.setParent(workbenchPart);
		   //添加到flashViewer集合
		   //这里的flashViewer代表的并不是Flash容器，而是将swt的ViewPart 当做FlashViewer来对待
		 FlashViewer.add_Viewer(flashViewer);
		//将当前打开的viewPart的信息添加进模块对应表中
		 SplashWindow.getPerspective().
			page.addViewPartInfo(flashViewer.getModulePath(), flashViewer.getAppId());
		 
		 return flashViewer;
    }*/
	private ViewManager() {
        
	}
	public void initIWorkbenchPageListener(IWorkbenchPage page){
		this.page=page;
		if(page!=null){
			page.addPartListener(new IPartListener(){

				public void partActivated(IWorkbenchPart part) {
				   if(part instanceof SmartRCPViewPart){
					fireEvent(CPartEvent.Part_Activated, (SmartRCPViewPart)part);
				   }
				}

				public void partBroughtToTop(IWorkbenchPart part) {
					if(part instanceof SmartRCPViewPart){
					  fireEvent(CPartEvent.Part_BroughtToTop,(SmartRCPViewPart)part);
					}
				}

				public void partClosed(IWorkbenchPart part) {
					//从FlashViewer集合中删除掉当前关闭的ViewPart
					/**List<FlashViewer> curViews=FlashViewer.getViewers();//当前的所有FlashViewer
					for(int n=0;n<curViews.size();n++){
						FlashViewer viewer=curViews.get(n);
						if(viewer.getParent().equals(part)){//
							//从PageLayout的appId模块对应表中删除该part的信息
							CPageLayout.Instance.removeViewPartInfo(viewer.getModulePath(), viewer.getAppId());
							//触发flex监听器
							fireFlashViewer(CPartEvent.Part_Closed,viewer);
							//curViews.remove(n);
							//curViews.remove(viewer);
							
							viewer.dispose();//释放对象
							Log.println("curSize="+curViews.size());
							
							break;
						}
					}*/
					if(part instanceof SmartRCPViewPart){
					   FlashViewer flashViewer=FlashViewer.getViewerByParent((SmartRCPViewPart)part);
					   if(flashViewer!=null){
						 //触发flex监听器
						   try{
							   
						     fireFlashViewer(CPartEvent.Part_Closed,flashViewer);
						     flashViewer.disposeResource();//释放对象资源
						     Log.println("curSize="+FlashViewer.getViewers().size());
						     
						   }catch(Throwable e){
							   e.printStackTrace();
						   }
					   }
					}
				}

				public void partDeactivated(IWorkbenchPart part) {
					if(part instanceof SmartRCPViewPart){
					  fireEvent(CPartEvent.Part_Deactivated, (SmartRCPViewPart)part);
					}
				}
				public void partOpened(IWorkbenchPart part) {
				  //让Flex模块可以监听到继承SmartRCPViewPart类，但非FlashViewPart类型的ViewPart的打开
				  if(part instanceof SmartRCPViewPart){
					 fireEvent(CPartEvent.Part_Opened, (SmartRCPViewPart)part);
				     if(part instanceof FlashViewPart){
				    	 ((FlashViewPart)part).getFlashViewer().loadFlash();
				     }
				  }	 
				}
			});
		}
	}
	/**
	 * 
	 * @param type 可选值:Part_Activated ，
	 * @param part
	 */
	public void fireEvent(int type,SmartRCPViewPart part){
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
	 * 否则打开viewId在plugin.xml中定义的视图，并且allowMultiple一定为true
	 * 
	 * @param basicInfo
	 * @return
	 */
	public FlashViewer openViewPart(CLayoutBasicInfo basicInfo,boolean isMultiple, int state) {
		try {
			FlashViewer ret=null;
			if (basicInfo != null) {
				String viewId=basicInfo.viePartId;String modulePath=basicInfo.modulePath;
				if(viewId!=null && modulePath!=null){
					int moduleId= FlashViewer.getViewNum();//模块的唯一标识符
					basicInfo.autoLoad=true;//设置为true，以便FlashViewPart自动加载swf
					
					//注册布局信息到全局变量，以便对应viewPart创建的时候可以得到
					Perspective.swfLayoutMap.put(Integer.valueOf(moduleId),basicInfo);
					
					IViewPart iViewPart=this.page.showView(viewId,moduleId+"",state);
					if(iViewPart instanceof SmartRCPViewPart){
						ret=((SmartRCPViewPart)iViewPart).getFlashViewer();
					}
				}else{
					throw new RuntimeException("CLayoutBasicInfo 's viePartId and modulePath property can not be null");
				}
			}
			return ret;
		} catch (Throwable e) {
			e.printStackTrace();
			if(basicInfo!=null){
			  throw new RuntimeException("view "+basicInfo.modulePath+" create fault,check isMultiple param or viewId");
			}else{
			  throw new RuntimeException(e.getMessage());
			}
		}
	}
	public void showViewPart(String appId){
		if(appId!=null){
		 FlashViewer flashViewer=this.findFlashViewer(appId);
		 if(flashViewer!=null){//如果appId对应的视图已经初始化
		  Object parent=flashViewer.getParent();
		  if(parent instanceof IViewPart){
			  IViewPart part=(IViewPart)parent;
			  this.page.activate(part);
		  }
		 }else{//还没初始化或不存在
		    IViewReference[] refs=this.page.getViewReferences();
		    if(refs!=null){
		    	String moduleStr=
		    		CPageLayout.Instance.getModuleStr(appId);
		    	if(moduleStr==null){
		    		throw new RuntimeException("appId为"+appId+"的视图不存在所以无法打开");
		    	}
		    	for(int n=0;n<refs.length;n++){
		    		IViewReference ref=refs[n];
		    		if(ref.getId().equals(FlashViewPart.ID)){//flash容器视图
		    			if(ref.getSecondaryId().equals(appId)){
		    				this.page.activate(ref.getPart(true));
		    				break;
		    			}
		    		}else{//java容器视图
		    			if(ref.getId().equals(moduleStr)){
		    				this.page.activate(ref.getPart(true));
		    				break;
		    			}
		    		}
		    	}
		    }
		 }
		}
	}
	/**
	 * 删除viewPart在FlashViewer集合以及模块对应表中的所有信息
	 * @param part
	 */
	private void deletePartInfo(IWorkbenchPart part){
		if(part==null || !(part instanceof IViewPart)){
			return;
		}
		//从FlashViewer集合中删除掉当前关闭的ViewPart
		List<FlashViewer> curViews=FlashViewer.getViewers();//当前的所有FlashViewer
		for(int n=0;n<curViews.size();n++){
			FlashViewer viewer=curViews.get(n);
			if(viewer.getParent().equals(part)){//
				//从PageLayout的appId模块对应表中删除该part的信息
				CPageLayout.Instance.removeViewPartInfo(viewer.getModulePath(), viewer.getAppId());
				
				curViews.remove(n);
				break;
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
			//删除该viewPart的所有信息
			deletePartInfo(viewPart);
			
			page.hideView(viewPart);
			viewPart.dispose();
		}
	}
	//--------------------FlashView的管理方法
	/**
	 * 将指定的viewpart的状态，是最大化，最小化，还是保持原样
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
					//设置state
					IWorkbenchPartReference partReference=page.getActivePartReference();
					if(page.getPartState(partReference)!=state){
					 page.setPartState(partReference,state);
					}
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
		List<String> ret=null;
		if(modulePath!=null){
			modulePath=UIHelpMethod.getFullPath(modulePath);
			ret=CPageLayout.Instance.getModuleIdAppIdMap().get(modulePath);
		}
		return ret;
	}
	public List<FlashViewer> findFlashViewers(String modulePath){
		List<FlashViewer> ret=new LinkedList<FlashViewer>();
		if(modulePath!=null){
			modulePath=UIHelpMethod.getFullPath(modulePath);
			List<FlashViewer> curViews=FlashViewer.getViewers();//当前的所有FlashViewer
			for(int n=0;n<curViews.size();n++){
				FlashViewer viewer=curViews.get(n);
				if(viewer.getModulePath().equals(modulePath)){
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
		
	}
	public void dispose() {
		super.dispose();
	}
}
