package cn.smartinvoke.util;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

public class ImageManager {

	public ImageManager() {
       
	}

	private static ImageRegistry imageRegistry;

	public static void init(ImageRegistry imageRegistry) {
		try {
			
			ImageManager.imageRegistry = imageRegistry;// new ImageRegistry();
			String plugInFolder = HelpMethods.getPluginFolder();
			String imgFolder = plugInFolder + "/icons";
			File folder = new File(imgFolder);
			if (!folder.exists()) {
				folder.mkdirs();
			} else {

				List<String> subFiles = getSubFiles(folder);
				for (int i = 0; i < subFiles.size(); i++) {
					String filePath = subFiles.get(i);
					String key = filePath.substring(plugInFolder.length());
					//Log.println("image key=" + key);
					URL url = new URL("file:/" + filePath);
					ImageDescriptor descriptor = ImageDescriptor
							.createFromURL(url);
					imageRegistry.put(key, descriptor);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 从文件夹中获得所有文件
	private static List<String> getSubFiles(File folder) {
		List<String> ret = new LinkedList<String>();
		if (folder != null) {
			Stack<File> stack = new Stack<File>();
			stack.push(folder);
			while (!stack.isEmpty()) {
				File temp = stack.pop();
				File[] subFiles = temp.listFiles();
				if (subFiles != null) {
					for (int i = 0; i < subFiles.length; i++) {
						File file = subFiles[i];
						if (!file.isDirectory()) {
							ret.add(file.getAbsolutePath().replace(
									File.separatorChar, '/'));
						} else {
							stack.push(file);
						}
					}
				}
			}
		}
		return ret;
	}

	public static ImageDescriptor getImageDescriptor(String key) {
		if (key == null) {
			return null;
		} else {
			return imageRegistry.getDescriptor(key);
		}
	}
    public static Image getImage(String key){
    	Image ret=null;
    	if(key!=null){
    	 ImageDescriptor imageDescriptor=getImageDescriptor(key);
    	 if(imageDescriptor!=null){
    		 ret=imageDescriptor.createImage();
    	 }
    	}
    	return ret;
    }
	/**
	 * @param args
	 * @throws MalformedURLException
	 */
	public static void main(String[] args) throws MalformedURLException {
		Display display = new Display();
		URL url = new URL("file:/F:/hhhh/img.png");
		ImageDescriptor descriptor = ImageDescriptor.createFromURL(url);
		System.out.println(descriptor.createImage());
	}

}
