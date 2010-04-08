package cn.smartinvoke.smartrcp.core;

import java.util.Map;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Composite;

import cn.smartinvoke.rcp.CLayoutBasicInfo;
import cn.smartinvoke.util.ImageManager;

/**
 * 存载SWT控件单元的容器的类
 * @author pengzhen
 */
public class SWTUnitViewPart extends SmartRCPViewPart {
    
	public SWTUnitViewPart() {
		
	}
	private ISWTPartUnit partUnit;
	public void createPartControl(Composite parent){
		super.createPartControl(parent);
		
		String secondId=this.getViewSite().getSecondaryId();
	    if(secondId!=null){
	    	Map<Integer, CLayoutBasicInfo> layoutMap = Perspective.swfLayoutMap;
	    	 CLayoutBasicInfo layoutInfo =layoutMap.get(Integer.valueOf(secondId));
	    	 if(layoutInfo!=null){
	    		String unitId=layoutInfo.modulePath;//swt控件单元的id
	    		//设置标题和图片
	    		this.setPartName(layoutInfo.title);
	    		if (layoutInfo.image != null) {
					ImageDescriptor imageDescriptor = ImageManager
							.getImageDescriptor(layoutInfo.image);
					if (imageDescriptor != null){
						this.setTitleImage(imageDescriptor.createImage());
					}
				}
	    		
	    		partUnit=
	    			SmartRCPViewPartService.Instance.getSWTPartUnits().get(unitId);
	    		if(partUnit!=null){//创建swt控件单元
	    		   partUnit.createPartControl(parent);
	    		}
	    	 } 
	    }
	}
	
	public ISWTPartUnit getPartUnit(){
		return this.partUnit;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}

}
