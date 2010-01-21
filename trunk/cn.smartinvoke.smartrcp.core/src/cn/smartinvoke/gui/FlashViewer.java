package cn.smartinvoke.gui;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;

import cn.smartinvoke.IServerObject;
import cn.smartinvoke.smartrcp.gui.control.EventFilter;
import cn.smartinvoke.smartrcp.gui.control.EventRegister;
import cn.smartinvoke.smartrcp.gui.control.GlobalServiceId;

public class FlashViewer implements IServerObject{
	private static List<FlashViewer> containers = new LinkedList<FlashViewer>();

	public static void add_Viewer(FlashViewer container) {
		if (container != null) {
			if (!containers.contains(container)) {
				containers.add(container);
			}
		}
	}

	public static void remove_Viewer(FlashViewer container) {
		if (container != null) {
			if (containers.contains(container)) {
				containers.remove(container);
			}
		}
	}

	public static List<FlashViewer> getViewers() {
		return containers;
	}

	public static FlashViewer getViewerBySwfPath(String swfPath) {
		FlashViewer ret = null;
		if (swfPath != null) {
			for (int i = 0; i < containers.size(); i++) {
				FlashViewer temp = containers.get(i);
				if (temp != null) {
					String path = temp.getSwfPath();
					if (path != null && path.equals(swfPath)) {
						ret = temp;
						break;
					}
				}
			}
		}
		return ret;
	}

	public static FlashViewer getViewerByAppId(String appId) {
		FlashViewer ret = null;
		if (appId != null) {
			for (int i = 0; i < containers.size(); i++) {
				FlashViewer temp = containers.get(i);
				if (temp != null) {
					String id = temp.getFlashContainer().getAppId();
					if (id != null && id.equals(appId)) {
						ret = temp;
						break;
					}
				}
			}
		}
		return ret;
	}
	public FlashViewer(Composite parent){
		
	}
	private FlashContainer flashContainer;

	public FlashViewer(Composite parent, String swfPath) {
		this.createView(parent, swfPath);
		FlashViewer.add_Viewer(this);
	}

	private String swfPath = null;

	/**
	 * 
	 * @param parent
	 * @param swfPath
	 *            第一个元素为swf运行文件路径，第二个元素为模块路径
	 */
	public FlashViewer(Composite parent, String[] swfPath) {
		this.createView(parent, swfPath);
		FlashViewer.add_Viewer(this);
	}

	private void createView(Composite parent, String swfPath) {
		this.createFlashContainer(parent);
		// 加载flash
		if (this.swfPath != null) {
			this.flashContainer.loadMovie(0, swfPath);
			this.swfPath = swfPath;
		}
	}

	private void createView(Composite parent, String[] swfPath) {
		this.createFlashContainer(parent);
		// 加载flash
		if (swfPath != null && swfPath.length >= 2) {
			this.flashContainer.loadMovie(0, swfPath);
			this.swfPath = swfPath[1];
		}
	}

	private void createFlashContainer(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new FillLayout());
		flashContainer = new FlashContainer(container);
		
		//将当前的FlashViewer注册为服务对象，以便该容器内的flex的调用
		ObjectPool.INSTANCE.putObject(flashContainer.getAppId(), this,GlobalServiceId.FlashViewer);
		//将flash控件作为服务类
		ObjectPool.INSTANCE.putObject(flashContainer.getAppId(), flashContainer,GlobalServiceId.FlashViewer_Control);
		
		flashContainer.addHookInterceptor(new OleHookInterceptor(){
			public boolean intercept(Msg message, int code, int param,
					int param2) {
				if (message.getMessage() == Win32Constant.WM_RBUTTONDOWN) {
					Point cursor = flashContainer.getParent().toControl(
							Display.getCurrent().getCursorLocation());
					if (flashContainer.getBounds().contains(cursor) && flashContainer.isVisible()) {
						createMouseClickEvent(3,message.getX(),message.getY());
						return true;
					}
				}
				if (message.getMessage() == Win32Constant.WM_MBUTTONDOWN) {
					Point cursor = flashContainer.getParent().toControl(
							Display.getCurrent().getCursorLocation());
					if (flashContainer.getBounds().contains(cursor) && flashContainer.isVisible()) {
						createMouseClickEvent(2,message.getX(),message.getY());
						return true;
					}
				}
//				if (message.getMessage() == Win32Constant.WM_LBUTTONDOWN) {
//					Point cursor = flashContainer.getParent().toControl(
//							Display.getCurrent().getCursorLocation());
//					if (flashContainer.getBounds().contains(cursor) && flashContainer.isVisible()) {
//						createMouseClickEvent(1,message.getX(),message.getY());
//						return true;
//					}
//				}
				return false;
			}
			
		});
	}
	/**
	 * 创建并派发鼠标事件
	 * @param button
	 * @param x
	 * @param y
	 */
    private void createMouseClickEvent(int button,int x,int y){
    	Event evt=new Event();
		evt.widget=flashContainer;
		
		Point loca=this.flashContainer.toControl(x, y);
		evt.x=loca.x;evt.y=loca.y;
		evt.button=button;
		evt.widget=this.flashContainer;
		evt.type=SWT.MouseDown;
		
		EventFilter.dealEvent(evt);
    }
	public FlashContainer getFlashContainer() {
		return flashContainer;
	}

	public void setFlashContainer(FlashContainer flashContainer) {
		this.flashContainer = flashContainer;
	}
	public String getSwfPath() {
		return swfPath;
	}
	public void dispose() {
		// 从全局容器集合中删除
		FlashViewer.remove_Viewer(this);
		//删除监听器
		ObjectPool pool=ObjectPool.INSTANCE;
		EventRegister eventRegister=(EventRegister)pool.getObject(GlobalServiceId.Event_Register);
		eventRegister.removeListeners(this.flashContainer.getAppId());
		// 删除对象池中的对应服务类
		if (this.flashContainer != null) {
			this.flashContainer.dispose();
		}
		
	}
}
