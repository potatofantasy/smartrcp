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
import cn.smartinvoke.smartrcp.gui.control.CActionManager;
import cn.smartinvoke.smartrcp.gui.control.EventFilter;
import cn.smartinvoke.smartrcp.gui.control.EventRegister;
import cn.smartinvoke.smartrcp.gui.control.GlobalServiceId;
import cn.smartinvoke.util.Log;

public class FlashViewer implements IServerObject{
	private static List<FlashViewer> containers = new LinkedList<FlashViewer>();
	//当前打开的FlashViewer计数器
	private static  int viewer_Num=0;
	//返回当前的viewerNum值，并将计数器加一
	public static synchronized int getViewNum(){
		return viewer_Num++;
	}
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
	private Object parent=null;
	public FlashViewer(String appId){
		this.appId=appId;
	}
	private FlashContainer flashContainer;

	public FlashViewer(String appId,Composite parent, String swfPath) {
		this(appId);
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
	public FlashViewer(String appId,Composite parent, String[] swfPath) {
		this(appId);
		this.createView(parent, swfPath);
		FlashViewer.add_Viewer(this);
	}
    private String[] swfAndModulePath;
	private void createView(Composite parent, String swfPath) {
		this.createFlashContainer(parent);
		this.swfPath=swfPath;
	}

	private void createView(Composite parent, String[] swfPath) {
		this.createFlashContainer(parent);
		swfAndModulePath=swfPath;
		Log.println("in FlashViewer's createView...");
	}
	/**
	 * 加载flash
	 */
    public void loadFlash(){
    	// 加载flash
		if (this.swfPath != null) {
			this.flashContainer.loadMovie(0, swfPath);
		}else if(this.swfAndModulePath!=null){
			if (swfAndModulePath.length >= 2) {
				this.flashContainer.loadMovie(0, swfAndModulePath);
				this.swfPath = swfAndModulePath[1];
			}
		}
    }
	private void createFlashContainer(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new FillLayout());
		//设置FlashViewer的唯一标识符
		String appId=this.getAppId();
		flashContainer = new FlashContainer(container,appId);
		//flashContainer.setAppId(appId);
		
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
				if (message.getMessage() == Win32Constant.WM_LBUTTONDOWN) {
					Point cursor = flashContainer.getParent().toControl(
							Display.getCurrent().getCursorLocation());
					if (flashContainer.getBounds().contains(cursor) && flashContainer.isVisible()) {
						createMouseClickEvent(1,message.getX(),message.getY());
						return false;
					}
				}
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
		String appId=this.flashContainer.getAppId();
		eventRegister.removeListeners(appId);
		//释放action监听器资源
		CActionManager actionManager=(CActionManager)pool.getObject(GlobalServiceId.CAction_Manager);
		actionManager.desposeResource(appId);
		// 删除对象池中的对应服务类
		if (this.flashContainer != null) {
			this.flashContainer.dispose();
		}
		
	}
    //-----------------
	public Object getParent() {
		return parent;
	}
	public void setParent(Object parent) {
		this.parent = parent;
	}
	private String appId;
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	
}
