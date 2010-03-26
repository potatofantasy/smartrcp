package smartrcp.plugin;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IPerspectiveListener;
import org.eclipse.ui.IWindowListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import cn.smartinvoke.gui.ObjectPool;
import cn.smartinvoke.rcp.CPerspective;
import cn.smartinvoke.rcp.CWindowConfigurer;
import cn.smartinvoke.smartrcp.gui.SplashWindow;
import cn.smartinvoke.smartrcp.gui.control.GlobalServiceId;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "smartrcp.plugin";

	// The shared instance
	private static Activator plugin;
	
	/**
	 * The constructor
	 */
	public Activator() {
		
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		//初始化smartrcp插件
		SmartRCPBuilder.init(context);
		//初始化窗口
  		SmartRCPBuilder.initWindows();
     	//---------加载图像注册信息
     	SmartRCPBuilder.initImageRegistry(Activator.getDefault().getImageRegistry());
        
     	IWorkbenchWindow[] windows=this.getWorkbench().getWorkbenchWindows();
     	ObjectPool.INSTANCE.putObject(new smartrcp.plugin.ViewManager(windows[0]) , GlobalServiceId.View_Manager);
     	
     	this.getWorkbench().addWindowListener(new IWindowListener() {
			
			@Override
			public void windowOpened(IWorkbenchWindow window) {
				
				window.addPerspectiveListener(new WorkbenchWindowInit());
			    //窗口打开后设置smartrcp
				//设置窗体
				Shell shell=window.getShell();
				ObjectPool.INSTANCE.putObject(shell, GlobalServiceId.Swt_Main_Win);
				CPerspective cPerspective = SplashWindow.getPerspective();
				if (cPerspective != null) {
					CWindowConfigurer cWinConfig = cPerspective.windowConfigurer;
					shell.setText(cWinConfig.shellTitle);
				}
				//设置viewManager
				
			}
			@Override
			public void windowDeactivated(IWorkbenchWindow window){
				
			}
			
			@Override
			public void windowClosed(IWorkbenchWindow window) {
				
			}
			
			@Override
			public void windowActivated(IWorkbenchWindow window) {
				
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given
	 * plug-in relative path
	 *
	 * @param path the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}
}
class WorkbenchWindowInit implements IPerspectiveListener{

	@Override
	public void perspectiveActivated(IWorkbenchPage page,
			IPerspectiveDescriptor perspective) {
		page.addPartListener(new IPartListener2() {
			
			@Override
			public void partVisible(IWorkbenchPartReference partRef) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void partOpened(IWorkbenchPartReference partRef) {
				System.out.println("partOpened...");
			}
			
			@Override
			public void partInputChanged(IWorkbenchPartReference partRef) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void partHidden(IWorkbenchPartReference partRef) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void partDeactivated(IWorkbenchPartReference partRef) {
				
			}
			
			@Override
			public void partClosed(IWorkbenchPartReference partRef) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void partBroughtToTop(IWorkbenchPartReference partRef) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void partActivated(IWorkbenchPartReference partRef) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	@Override
	public void perspectiveChanged(IWorkbenchPage page,
			IPerspectiveDescriptor perspective, String changeId) {
		
	}
	
}
