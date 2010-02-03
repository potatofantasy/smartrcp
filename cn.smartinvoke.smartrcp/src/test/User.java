package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import cn.smartinvoke.IServerObject;

public class User implements IServerObject {
	public String hello() {
		return "hello";
	}

	public static void main(String[] args) throws Exception {
		File f=new File("C:/grade.txt");
		FileReader reader=new FileReader(f);
		BufferedReader buf=new BufferedReader(reader);
		String line=buf.readLine();
		int total=0;
		int qT=0;
		while(line!=null){
			line=line.substring(1);
			//System.out.println("line="+line);
			String[] items=line.split(",");
			String a=(items[0]).trim();
			String b=(items[1]).trim();
			//System.out.println(a);
			//System.out.println(b);
			int grd=Integer.valueOf(items[0].trim());
			int q=Integer.valueOf(items[1].trim());
			qT+=q;
			total+=grd*q;
			
			line=buf.readLine();
		}
		System.out.println(total/qT);
	}

	public void dispose() {
		// TODO Auto-generated method stub

	}
}
