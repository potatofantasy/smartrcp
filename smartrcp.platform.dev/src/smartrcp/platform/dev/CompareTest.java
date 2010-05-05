package smartrcp.platform.dev;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URI;
import java.util.Arrays;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

public class CompareTest {
	public static void main(String[] args) throws Exception {
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);

//		Iterable<? extends JavaFileObject> files = fileManager.getJavaFileObjectsFromStrings(Arrays.asList("src/Calculator.java"));

//		JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, null, null, null, files);
		
		StringObject so = new StringObject("test.ExpTest", "package test;" +
															"public class ExpTest {" +
															"	public String hello() {" +
															"		System.out.println(\"nihao......\");" +
															"		return \"abccccccc\";" +
															"	}" +
															"}");
		
		JavaFileObject file = so;
		
		Iterable<? extends JavaFileObject> files = Arrays.asList(file);
		JavaCompiler.CompilationTask task = compiler.getTask (
		                 null, fileManager, null, null, null, files);
		
		Boolean result = task.call();
		System.out.println(result);
		if(result){
			Class<?> clazz = Class.forName("test.ExpTest");
			
			Object instance = clazz.newInstance();
			
			System.out.println(instance);
		}
	}
}

class StringObject extends SimpleJavaFileObject{
	private String contents = null;
	
	public StringObject(String className, String contents) throws Exception{
		super(URI.create("string:///" + className.replace('.','/') + Kind.SOURCE.extension),  
				 Kind.SOURCE);  
		this.contents = contents;
	 }
	
	public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException {
		return contents;
	}
}
