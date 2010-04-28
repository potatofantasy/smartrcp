package test;

import java.io.IOException;

import cn.smartinvoke.util.Path;

public class Test {
	
	public static void main(String[] args) throws IOException {
		System.out.println(Path.getPathFromClass(Test.class));
	}

}
