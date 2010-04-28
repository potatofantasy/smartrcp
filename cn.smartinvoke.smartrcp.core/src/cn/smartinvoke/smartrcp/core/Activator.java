package cn.smartinvoke.smartrcp.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.osgi.framework.internal.core.FrameworkProperties;
import org.eclipse.osgi.internal.baseadaptor.BundleInstall;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import cn.smartinvoke.ObjectPool;
import cn.smartinvoke.TypeFactory;

public class Activator implements BundleActivator {

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		System.out.println("Activator.start()");
		
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
	  	
	}

}
class ExtClassLoader extends ClassLoader {
	public ExtClassLoader(ClassLoader parent) {
		super(parent);
		
	}
	private byte[] loadClassBytes(String className){
		try {
			File file=new File("D:/ExpTest.class");
			byte[] bts=new byte[(int)file.length()];
			InputStream in=new FileInputStream(file);
			in.read(bts);
			in.close();
			return bts;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
