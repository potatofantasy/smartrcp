package cn.smartinvoke.smartrcp.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.jar.Attributes;
import java.util.jar.JarFile;

/**
 * @author Kobye
 */
public class JsportsClassLoader extends ClassLoader {
	private String dir;

	public JsportsClassLoader(ClassLoader parent, String dir) {
		super(parent);
		this.dir = dir;
	}

	protected Class findClass(String name) throws ClassNotFoundException {
		byte[] bytes = loadClassBytes(name);
		Class theClass = defineClass(name, bytes, 0, bytes.length);
		if (theClass == null) {
			throw new ClassFormatError();
		}
		return theClass;
	}

	private byte[] loadClassBytes(String className)
			throws ClassNotFoundException {
		try {
			String classFile = getClassFile(className);
			FileInputStream fis = new FileInputStream(classFile);
			FileChannel fileC = fis.getChannel();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			WritableByteChannel outC = Channels.newChannel(baos);
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			while (true) {
				int i = fileC.read(buffer);
				if (i == 0 || i == -1) {
					break;
				}
				buffer.flip();
				outC.write(buffer);
				buffer.clear();
			}
			fis.close();
			return baos.toByteArray();
		} catch (IOException fnfe) {
			throw new ClassNotFoundException(className);
		}
	}

	private String getClassFile(String name) {
		StringBuffer sb = new StringBuffer(dir);
		name = name.replace('.', File.separatorChar) + ".class";
		sb.append(File.separator + name);
		return sb.toString();
	}

	protected URL findResource(String name) {
		try {
			URL url = super.findResource(name);
			if (url != null) {
				return url;
			}
			url = new URL("file:///" + converName(name));
			return url;
		} catch (MalformedURLException mue) {
			return null;
		}
	}

	private String converName(String name) {
		StringBuffer sb = new StringBuffer(dir);
		name = name.replace('.', File.separatorChar);
		sb.append(File.separator + name);
		return sb.toString();
	}

	private String getClassName(String dir, File f) {
		String name = f.getAbsolutePath();
		if (name.startsWith(dir)) {
			name = name.substring(dir.length(), name.length());
		}
		name = name.replace(File.separatorChar, '.');
		if (name.endsWith(".class")) {
			name = name.substring(0, name.length() - ".class".length());
		}
		return name;
	}

//	private List getAllFiles(File base) {
//		File[] dirs = base.listFiles(new ClassFileFilter());
//		File[] classFile = base.listFiles(new ClassFileNameFilter());
//		List files = new ArrayList();
//		for (int i = 0; i < classFile.length; i++) {
//			files.add(classFile[i]);
//		}
//		for (int i = 0; i < dirs.length; i++) {
//			files.addAll(getAllFiles(dirs[i]));
//		}
//		return files;
//	}

	private File getDirByName(File dir, String dirName, String baseDir) {
		if (!dir.isDirectory()) {
			return null;
		}
		String dirPath = dir.getAbsolutePath();
		if (dirPath.startsWith(baseDir)) {
			// 检查 该目下的File dir
			dirPath = dirPath.substring(baseDir.length(), dirPath.length());
			System.out.println();
			if (dirPath.endsWith("model")) {
				return dir;
			}
		}
		File[] files = dir.listFiles();
		for (int i = 0; i < files.length; i++) {
			File f = getDirByName(files[i], dirName, baseDir);
			if (f != null) {
				return f;
			}
		}
		return null;
	}
    public static void main(String[] args)throws IOException{
    	String path="E:/java/tools/eclipse-SDK-3.3-win32/eclipse/plugins/org.eclipse.ant.ui_3.2.100.v20070511.jar";
    	JarFile jarFile=new JarFile(path);
    	Attributes attributes=jarFile.getManifest().getMainAttributes();
    	System.out.println(attributes.getValue("Export-Package"));
    	/**Iterator<Object> keySet=attributes.keySet().iterator();
    	while(keySet.hasNext()){
    		System.out.println(keySet.next());
    		
    	}*/
	}
}