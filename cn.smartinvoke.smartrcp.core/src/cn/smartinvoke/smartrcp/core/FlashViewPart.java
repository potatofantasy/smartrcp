package cn.smartinvoke.smartrcp.core;

import java.util.Map;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import cn.smartinvoke.gui.FlashViewer;
import cn.smartinvoke.rcp.CLayout;
import cn.smartinvoke.rcp.CPerspective;
import cn.smartinvoke.util.ImageManager;

public class FlashViewPart extends ViewPart {
	public static final String ID = "cn.smartinvoke.smartrcp.core.FlashViewPart"; //$NON-NLS-1$
	private CLayout clayout;

	private FlashViewer flashViewer;

	@Override
	public void createPartControl(Composite parent) {
		try {
			String secondId = this.getViewSite().getSecondaryId();
			Map<Integer, CLayout> layoutMap = Perspective.swfLayoutMap;
			clayout = layoutMap.get(Integer.valueOf(secondId));
			String viewId = clayout.getViewId();
			if (viewId != null) {
				if(clayout.isModuleSwf){
				  String[] paths = new String[] {
						CPerspective.getRuntimeSWFPath(),
						CPerspective.getRuntimeSwfFolder() + "/" + viewId };
				  flashViewer = new FlashViewer(secondId, parent, paths);
				}else{
				  flashViewer = new FlashViewer(secondId, parent, CPerspective.getRuntimeSwfFolder() + "/" + viewId);
				}
				// 设置布局信息
				this.setViewTitle(clayout.getTitle());
				
				// 设置图标
				if (clayout.image != null) {
					ImageDescriptor imageDescriptor = ImageManager
							.getImageDescriptor(clayout.image);
					if (imageDescriptor != null) {
						this.setTitleImage(imageDescriptor.createImage());
					}
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

	public void dispose() {
		if (this.flashViewer != null) {
			// FlashViewer.remove_Viewer(this.flashViewer);
			this.flashViewer.dispose();
		}
	}
}