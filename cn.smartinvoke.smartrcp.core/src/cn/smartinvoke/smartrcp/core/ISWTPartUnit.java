package cn.smartinvoke.smartrcp.core;

import org.eclipse.swt.widgets.Composite;

/**
 * 实现此接口的对象，可以注册到SmartRCPViewPartService
 * 以实现swt界面与flex的集成
 * @author pengzhen
 */
public interface ISWTPartUnit {
	/**
	 *当前swt界面单元被注册到 SmartRCPViewPartService中
	 *时使用的id
	 * @return
	 */
   public String getId();
   /**
    * 子类实现该方法已创建swt界面
    * @param parent
    */
   public void createPartControl(Composite parent);
   /**
    * 该方法提供给flex调用，以便flex可以方便的调用到当前SWT控件单元上的方法
    * @param methodName
    * @param params
    * @return
    */
   //public Object invoke(String methodName,Object[] params);
}
