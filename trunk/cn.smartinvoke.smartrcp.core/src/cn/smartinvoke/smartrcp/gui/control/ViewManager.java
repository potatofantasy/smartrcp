package cn.smartinvoke.smartrcp.gui.control;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IViewReference;
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
import cn.smartinvoke.smartrcp.core.SmartRCPViewPart;
import cn.smartinvoke.smartrcp.gui.FlashViewPart;
import cn.smartinvoke.smartrcp.gui.SplashWindow;
import cn.smartinvoke.smartrcp.gui.module.CObservable;
import cn.smartinvoke.smartrcp.gui.module.CPartEvent;
import cn.smartinvoke.util.Log;

/**
 * ��ͼ����������Ҫ��flex���ô���ķ�����ʵ��java��flex��ͬ�� �������ͼ������ViewPart ,Shell����
 * 
 * @author pengzhen
 * 
 */
public class ViewManager  extends CObservable implements IServerObject{
    private IWorkbenchPage page;
    /**
     * Ϊ��FlashViewPart��ͼ����FlashViewer���󣬲����ӵ�FlashViewer���ϣ��Ա�ViewManagerͳһ����
     * @param num
     * @param viewId
     * @param workbenchPart
     * @return
     
    public static FlashViewer fillViewerList(String num,String viewId,IWorkbenchPart workbenchPart){
    	//������java ViewPart��Ӧ��FlashViewer
		 FlashViewer flashViewer=new FlashViewer(num+"");
		 flashViewer.setModulePath(viewId);
		 flashViewer.setParent(workbenchPart);
		   //���ӵ�flashViewer����
		   //�����flashViewer�����Ĳ�����Flash���������ǽ�swt��ViewPart ����FlashViewer���Դ�
		 FlashViewer.add_Viewer(flashViewer);
		//����ǰ�򿪵�viewPart����Ϣ���ӽ�ģ���Ӧ����
		 SplashWindow.getPerspective().
			page.addViewPartInfo(flashViewer.getModulePath(), flashViewer.getAppId());
		 
		 return flashViewer;
    }*/
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
					//��FlashViewer������ɾ������ǰ�رյ�ViewPart
					List<FlashViewer> curViews=FlashViewer.getViewers();//��ǰ������FlashViewer
					for(int n=0;n<curViews.size();n++){
						FlashViewer viewer=curViews.get(n);
						if(viewer.getParent().equals(part)){//
							//��PageLayout��appIdģ���Ӧ����ɾ����part����Ϣ
							SplashWindow.getPerspective().
							page.removeViewPartInfo(viewer.getModulePath(), viewer.getAppId());
							//����flex������
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
					if(part instanceof IViewPart){
					 FlashViewer flashViewer=FlashViewer.getViewerByParent((IViewPart)part);
					 if(flashViewer!=null){
						 //����ǰ�򿪵�viewPart����Ϣ���ӽ�ģ���Ӧ����
						 SplashWindow.getPerspective().
							page.addViewPartInfo(flashViewer.getModulePath(), flashViewer.getAppId());
					 }
					 fireEvent(CPartEvent.Part_Opened, part);
					}
					/**
					 *�򿪿���̨�洢��δ��ʾ��viewPart
					 */
					if(part instanceof FlashViewPart){
						FlashViewPart viewPart=(FlashViewPart)part;
						viewPart.getFlashViewer().loadFlash();
					}
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
	 * ����������Ϣ��һviewPart
	 * ���CLayoutBasicInfo ��viewId��.swf��β����FlashViewPart��ͼ�������ض�Ӧ��swf��
	 * �����viewId��plugin.xml�ж������ͼ��
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
				   
				   if(viewId.endsWith(".swf")){//�����swf
					  appId = FlashViewer.getViewNum();
					  basicInfo.autoLoad=true;//����Ϊtrue���Ա�FlashViewPart�Զ�����swf
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
					  if(showView!=null && (showView instanceof SmartRCPViewPart)){
						  SmartRCPViewPart smartRCPViewPart=(SmartRCPViewPart)showView;
						  ret=smartRCPViewPart.getFlashViewer();
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
	public void showViewPart(String appId){
		if(appId!=null){
		 FlashViewer flashViewer=this.findFlashViewer(appId);
		 if(flashViewer!=null){//���appId��Ӧ����ͼ�Ѿ���ʼ��
		  Object parent=flashViewer.getParent();
		  if(parent instanceof IViewPart){
			  IViewPart part=(IViewPart)parent;
			  this.page.activate(part);
		  }
		 }else{//��û��ʼ���򲻴���
		    IViewReference[] refs=this.page.getViewReferences();
		    if(refs!=null){
		    	String moduleStr=
		    		SplashWindow.getPerspective().page.getModuleStr(appId);
		    	if(moduleStr==null){
		    		throw new RuntimeException("appIdΪ"+appId+"����ͼ�����������޷���");
		    	}
		    	for(int n=0;n<refs.length;n++){
		    		IViewReference ref=refs[n];
		    		if(ref.getId().equals(FlashViewPart.ID)){//flash������ͼ
		    			if(ref.getSecondaryId().equals(appId)){
		    				this.page.activate(ref.getPart(true));
		    				break;
		    			}
		    		}else{//java������ͼ
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
	 * ɾ��viewPart��FlashViewer�����Լ�ģ���Ӧ���е�������Ϣ
	 * @param part
	 */
	private void deletePartInfo(IWorkbenchPart part){
		if(part==null || !(part instanceof IViewPart)){
			return;
		}
		//��FlashViewer������ɾ������ǰ�رյ�ViewPart
		List<FlashViewer> curViews=FlashViewer.getViewers();//��ǰ������FlashViewer
		for(int n=0;n<curViews.size();n++){
			FlashViewer viewer=curViews.get(n);
			if(viewer.getParent().equals(part)){//
				//��PageLayout��appIdģ���Ӧ����ɾ����part����Ϣ
				SplashWindow.getPerspective().
				page.removeViewPartInfo(viewer.getModulePath(), viewer.getAppId());
				
				curViews.remove(n);
				break;
			}
		}
	}
	
	/**
	 * �رռ�����modulePathģ���������ͼ
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
	 * �ر�ָ��appId����ͼ
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
			//ɾ����viewPart��������Ϣ
			deletePartInfo(viewPart);
			
			page.hideView(viewPart);
			viewPart.dispose();
		}
	}
	//--------------------FlashView�Ĺ�������
	/**
	 * ��ָ����viewpart��״̬������󻯣���С�������Ǳ���ԭ��
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
				    
					//���Ȼ�ý���
					page.activate(viewPart);
					//����state
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
	 * ��õ�ǰ��ý����viewPart
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
			//java��ViewPart
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
		
		/**List<String> ret=new LinkedList<String>();
		//���
		IViewReference[] refs=SmartRCPBuilder.window.getActivePage().getViewReferences();
		if(refs!=null){
			for(int n=0;n<refs.length;n++){
				IViewReference ref=refs[n];
				
			}
		}*/
		List<String> ret=null;
		if(modulePath!=null){
			if(modulePath.endsWith(".swf")){
			 modulePath=CPerspective.getRuntimeSwfFolder() + "/"+modulePath;
			}
			ret=SplashWindow.getPerspective().page.getModuleIdAppIdMap().get(modulePath);
		}
		return ret;
	}
	public List<FlashViewer> findFlashViewers(String modulePath){
		List<FlashViewer> ret=new LinkedList<FlashViewer>();
		if(modulePath!=null){
			if(modulePath.endsWith(".swf")){
			  modulePath=CPerspective.getRuntimeSwfFolder() + "/"+modulePath;
			}
			List<FlashViewer> curViews=FlashViewer.getViewers();//��ǰ������FlashViewer
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
			List<FlashViewer> curViews=FlashViewer.getViewers();//��ǰ������FlashViewer
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