package cn.smartinvoke.smartrcp.gui;

import java.util.Map;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.presentations.AbstractPresentationFactory;
import org.eclipse.ui.presentations.IPresentablePart;

import cn.smartinvoke.IServerObject;
import cn.smartinvoke.gui.FlashViewer;
import cn.smartinvoke.rcp.CLayoutBasicInfo;
import cn.smartinvoke.rcp.CPerspective;
import cn.smartinvoke.smartrcp.core.Perspective;
import cn.smartinvoke.smartrcp.gui.control.CAction;
import cn.smartinvoke.smartrcp.gui.control.CActionImpl;
import cn.smartinvoke.util.ImageManager;

public class FlashViewPart extends ViewPart implements IServerObject{
	public static final String ID = "cn.smartinvoke.smartrcp.gui.FlashViewPart"; //$NON-NLS-1$
	private CLayoutBasicInfo layoutInfo;

	private FlashViewer flashViewer;
    public IWorkbenchWindow window;
	@Override
	public void createPartControl(Composite parent) {
		try {
			this.window=this.getViewSite().getWorkbenchWindow();
			String secondId = this.getViewSite().getSecondaryId();
			Map<Integer, CLayoutBasicInfo> layoutMap = Perspective.swfLayoutMap;
			layoutInfo = layoutMap.get(Integer.valueOf(secondId));
			String viewId = layoutInfo.getViewId();
			if (viewId != null) {
				if(layoutInfo.isModuleSwf){
				  String[] paths = new String[] {
						CPerspective.getRuntimeSWFPath(),
						CPerspective.getRuntimeSwfFolder() + "/" + viewId };
				  flashViewer = new FlashViewer(secondId, parent, paths);
				}else{
				  flashViewer = new FlashViewer(secondId, parent, CPerspective.getRuntimeSwfFolder() + "/" + viewId);
				}
				//设置父亲控件
				this.flashViewer.setParent(this);
				// 设置布局信息
				this.setViewTitle(layoutInfo.getTitle());
				
				// 设置图标
				if (layoutInfo.image != null) {
					ImageDescriptor imageDescriptor = ImageManager
							.getImageDescriptor(layoutInfo.image);
					if (imageDescriptor != null) {
						this.setTitleImage(imageDescriptor.createImage());
					}
				}
				//加载swf
				if(layoutInfo.autoLoad){
					flashViewer.loadFlash();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		;
	}

	public FlashViewer getFlashViewer() {
		return flashViewer;
	}
    public void setViewTitle(String title){
    	super.setPartName(title);
    }
    public String getViewTitle(){
    	return this.getPartName();
    }
	@Override
	public void setFocus() {
         
	}
    public IToolBarManager getToolBarManager(){
    	return this.getViewSite().getActionBars().getToolBarManager();
    }
    public IMenuManager getMenuManager(){
    	return this.getViewSite().getActionBars().getMenuManager();
    }
	public void dispose() {
		//删除透视图对象中的layout信息对象
		try{
		 
		 Perspective.swfLayoutMap.remove(Integer.valueOf(this.flashViewer.getAppId()));
		 if (this.flashViewer != null) {
			this.flashViewer.dispose();
		 }
		}catch(Exception e){
			e.printStackTrace();
		}
		super.dispose();
	}
}