package smartrcp.platform.dev;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Enumeration;

import org.eclipse.osgi.baseadaptor.HookConfigurator;
import org.eclipse.osgi.baseadaptor.HookRegistry;
import org.eclipse.osgi.framework.adaptor.BundleClassLoader;
import org.eclipse.osgi.framework.adaptor.BundleData;
import org.eclipse.osgi.framework.adaptor.ClassLoaderDelegateHook;

public class CustomClassLoaderDelegate implements ClassLoaderDelegateHook,
		HookConfigurator {

	@Override
	public Class postFindClass(String name, BundleClassLoader classLoader,
			BundleData data) throws ClassNotFoundException {
		System.out.println("CustomClassLoaderDelegate.postFindClass()");
		return null;
	}

	@Override
	public String postFindLibrary(String name, BundleClassLoader classLoader,
			BundleData data) {
		System.out.println("CustomClassLoaderDelegate.postFindClass()");
		return null;
	}

	@Override
	public URL postFindResource(String name, BundleClassLoader classLoader,
			BundleData data) throws FileNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Enumeration postFindResources(String name,
			BundleClassLoader classLoader, BundleData data)
			throws FileNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class preFindClass(String name, BundleClassLoader classLoader,
			BundleData data) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String preFindLibrary(String name, BundleClassLoader classLoader,
			BundleData data) throws FileNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public URL preFindResource(String name, BundleClassLoader classLoader,
			BundleData data) throws FileNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Enumeration preFindResources(String name,
			BundleClassLoader classLoader, BundleData data)
			throws FileNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addHooks(HookRegistry hookRegistry) {
		// TODO Auto-generated method stub

	}

}
