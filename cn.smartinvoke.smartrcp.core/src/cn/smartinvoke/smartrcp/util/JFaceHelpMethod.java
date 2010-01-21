package cn.smartinvoke.smartrcp.util;

import org.eclipse.jface.resource.ImageDescriptor;

import cn.smartinvoke.gui.ObjectPool;
import cn.smartinvoke.rcp.CPerspective;
import cn.smartinvoke.smartrcp.gui.control.CAction;
import cn.smartinvoke.smartrcp.gui.control.CActionImpl;
import cn.smartinvoke.smartrcp.gui.control.CActionManager;
import cn.smartinvoke.smartrcp.gui.control.GlobalServiceId;

public class JFaceHelpMethod {

	private JFaceHelpMethod() {
      
	}
    /**
     * 将flex传递过来的CAction数组，初始化为对应的jface Action对象，并将该对象
     * 存储到CActionManager中，key为action的id，值为该action
     * @param actionArr
     */
	public static void initAction(Object[] actionArr) {
		if (actionArr == null) {
			return;
		}
		ObjectPool objectPool = ObjectPool.INSTANCE;
		// if(perspective!=null){
		CActionManager actionManager = null;
		Object obj = objectPool.getObject(GlobalServiceId.CAction_Manager);
		if (obj != null) {
			actionManager = (CActionManager) obj;
			int len=actionArr.length;
			for(int i=0;i<len;i++){
			   Object actionObj=actionArr[i];
			   if(actionObj instanceof CAction){
				   actionManager.addAction(new CActionImpl((CAction)actionObj));
			   }
			}
		}
		// }
	}

	public static ImageDescriptor getImageDescriptor(String imgUrl) {
		//TODO 专业用一文件夹做图像注册表
		return null;//Activator.getImageDescriptor(imgUrl);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
