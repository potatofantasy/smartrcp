package smartrcp.platform.dev.pack;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class FlexLibaryManifest {
    
	public static void main(String[] args) {
		String baseFolder="E:\\flexWork\\smartrcp\\src";
		List<String> ret=getFilePaths(baseFolder);
		StringBuilder buf=new StringBuilder("<?xml version=\"1.0\"?>" +
				"\n<componentPackage>\n");
		for (int i = 0; i < ret.size(); i++) {
			String fullPath=ret.get(i);
			if(fullPath.endsWith(".as")){
			  String name=fullPath.substring(fullPath.lastIndexOf(File.separatorChar)+1
					  ,fullPath.length()-3);
			  String pack=fullPath.substring(baseFolder.length()+1,fullPath.length()-3);
			  pack=pack.replace(File.separatorChar, '.');
			  buf.append("<component id=\""+name+"\" class=\""+pack+"\"/>\n");
			}
		}
		buf.append("</componentPackage>\n");
		System.out.println(buf);
	}
    private static List<String> getFilePaths(String folderPath){
    	List<String> ret=new LinkedList<String>();
    	Stack<File> stack=new Stack<File>();
    	stack.push(new File(folderPath));
    	
    	while(!stack.isEmpty()){
    		File file=stack.pop();
    		if(file.isDirectory()){
    		   File[] subFiles=file.listFiles();
    		   if(subFiles!=null){
    			   for(File subFile:subFiles){
    				   stack.push(subFile);
    			   }
    		   }
    		}else{
    			ret.add(file.getAbsolutePath());
    		}
    	}
    	return ret;
    }
}
