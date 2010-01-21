package cn.smartinvoke.smartrcp.gui;

import java.util.LinkedList;
import java.util.List;
/**
 * 所有本地视图的抽象父类
 * @author pengzhen
 *
 */
public abstract class AbstrNativeViewer implements IViewer {
	private static List<AbstrNativeViewer> containers = new LinkedList<AbstrNativeViewer>();
	public static void add_Viewer(AbstrNativeViewer container) {
		if (container != null) {
			if (!containers.contains(container)) {
				containers.add(container);
			}
		}
	}
	public static void remove_Viewer(AbstrNativeViewer container) {
		if (container != null) {
			if (containers.contains(container)) {
				containers.remove(container);
			}
		}
	}
	public static List<AbstrNativeViewer> getViewers() {
		return containers;
	}
	public static AbstrNativeViewer getViewerByClsName(String clsName){
		AbstrNativeViewer ret=null;
		if(clsName!=null){
			for(int t=0;t<containers.size();t++){
				AbstrNativeViewer viewer=containers.get(t);
				if(viewer.getClass().getName().equals(clsName)){
					return viewer;
				}
			}
		}
		return ret;
	}
	//----------------------------
	public AbstrNativeViewer() {
	    containers.add(this);
	}
	public void dispose() {
		containers.remove(this);
	}
	public static void main(String[] args) {
		
	}

}
