package cn.smartinvoke.smartrcp.gui.control;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.ui.IWorkbenchPage;

import cn.smartinvoke.gui.FlashViewer;
import cn.smartinvoke.rcp.CLayoutBasicInfo;
import cn.smartinvoke.smartrcp.core.FlashViewPart;
import cn.smartinvoke.smartrcp.core.Perspective;
import cn.smartinvoke.smartrcp.core.SmartRCPBuilder;

/**
 * 视图管理器，主要是flex调用此类的方法，实现java与flex的同步 这里的视图包括：ViewPart ,Shell窗口
 * 
 * @author pengzhen
 * 
 */
public class ViewManager {

	public ViewManager() {

	}
    private Map<String,Integer> multiplViewNum=new HashMap<String, Integer>();
	/**
	 * 根据配置信息打开一viewPart
	 * 如果CLayoutBasicInfo 的viewId以.swf结尾，打开FlashViewPart视图，并加载对应的swf，
	 * 否则打开viewId在plugin.xml中定义的视图。
	 * 
	 * @param basicInfo
	 * @return
	 */
	public int showViewPart(CLayoutBasicInfo basicInfo,boolean isMultiple, int state) {
		try {
			int appId = -1;
			if (basicInfo != null) {
				String viewId=basicInfo.getViewId();
				if(viewId!=null){
				   if(viewId.endsWith(".swf")){//如果是swf
					  appId = FlashViewer.getViewNum();
					  Perspective.swfLayoutMap.put(Integer.valueOf(appId),basicInfo);
					  basicInfo.autoLoad=true;//设置为true，以便FlashViewPart自动加载swf
					  SmartRCPBuilder.window.getActivePage().showView(FlashViewPart.ID, appId + "",state);
				   }else{
					  if(isMultiple){
						  Integer num=multiplViewNum.get(viewId);
						  if(num==null){
							  num=0;
						  }
						  multiplViewNum.put(viewId, num+1);
						  SmartRCPBuilder.window.getActivePage().showView(viewId, num+"", state);
					  }else{
						  SmartRCPBuilder.window.getActivePage().showView(viewId);
					  }
				   }
				}
			}
			return appId;
		} catch (Throwable e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
}
