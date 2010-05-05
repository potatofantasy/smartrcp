package smartrcp.platform.dev;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;


public class ExtClassLoader extends ClassLoader {
	  //private final Bundle delegate;
	  //private ClassLoader parent;
	  

	public ExtClassLoader(ClassLoader parent) {
		super(parent);
		byte[] bts=this.loadClassBytes(null);
		try{
		   createClass(parent,bts);
		   super.defineClass("test.ExpTest",bts, 0, bts.length);
		}catch(Exception e){
		   e.printStackTrace();
		}
	}
    private void createClass(ClassLoader parent,byte[] bts){
    	try{
    	   Method method=parent.getClass().getDeclaredMethod("defineClass", String.class,byte[].class,Integer.class,Integer.class);
    	   method.setAccessible(true);
    	   method.invoke(parent,"test.ExpTest",bts,0,bts.length);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
	protected Class findClass(String name) throws ClassNotFoundException {
		
		System.err.println("\n extClassLoader load cls="+name);
		throw new ClassNotFoundException();
//		byte[] bytes = loadClassBytes(name);
//		Class theClass = defineClass(name, bytes, 0, bytes.length);
//		if (theClass == null) {
//			throw new ClassFormatError();
//		}
//		return theClass;
	}
    
	private byte[] loadClassBytes(String className){
		try {
			File file=new File("D:/ExpTest.class");
			byte[] bts=new byte[(int)file.length()];
			InputStream in=new FileInputStream(file);
			in.read(bts);
			return bts;
		} catch (IOException fnfe) {
			//throw new ClassNotFoundException(className);
		}
		return null;
	}

	private String getClassFile(String name) {
	  return null;
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
		return null;
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
    	
	}
}