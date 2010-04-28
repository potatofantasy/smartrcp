package cn.smartinvoke.smartrcp.util;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;

import cn.smartinvoke.smartrcp.core.SmartRCPBuilder;
import cn.smartinvoke.util.Log;

/**
 * OSGI 的bundle帮助方法
 * 
 * @author pengzhen
 * 
 */
public class BundleHelpMethod {
	/**
	 * 以有序方式安装osgi bundle， 这里的有序方式指：按照 bundle jar名称的启动级别
	 * 
	 * @param libFolder
	 * @return 返回被启动的bundle
	 * @throws BundleException 
	 */
	public static List<Bundle> installBundles(File libFolder) throws BundleException {
		List<Bundle> bundles = new LinkedList<Bundle>();// 返回
		File[] libFiles = libFolder.listFiles();
		List<BundleFile> bundleFiels = new LinkedList<BundleFile>();
		if (libFiles != null) {
			for (int i = 0; i < libFiles.length; i++) {
				String path = libFiles[i].getAbsolutePath();
				if (path.endsWith(".jar")) {// 如果是jar bundle
					bundleFiels.add(new BundleFile(path));
				}
			}
		}
		// 启动所有的bundle
		BundleContext context = SmartRCPBuilder.getCurContext();
		Object[] bundleFileArr = bundleFiels.toArray();
		Arrays.sort(bundleFileArr);// 排序

		for (int i = 0; i < bundleFileArr.length; i++) {
			BundleFile bundleFile=(BundleFile)bundleFileArr[i];
			String path = bundleFile.getLocation();
			Bundle bundle = context.installBundle(path);
			bundle.start();
			Log.println("load bundle jar:" + path);
			bundles.add(bundle);
		}
		return bundles;
	}

}

class BundleFile implements Comparable {
	private String path = null;
	private int leve = 5;// bundle的启动级别

	public BundleFile(String path) {
		this.path = path;
		int spl = this.path.indexOf('_');
		if (spl != -1) {
			String leveStr = this.path.substring(0, spl);
			try {
				leve = Integer.valueOf(leveStr);
			} catch (Exception e) {
				//e.printStackTrace();
			}
			;
		}
	}

	public String getLocation() {
		return "file:" + this.path;
	}

	public int compareTo(Object o) {
		BundleFile bundle1 = (BundleFile) o;
		return this.leve - bundle1.leve;
	}
}
