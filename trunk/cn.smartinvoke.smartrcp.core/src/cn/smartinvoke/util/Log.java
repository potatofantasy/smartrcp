package cn.smartinvoke.util;

import cn.smartinvoke.IServerObject;

public class Log implements IServerObject{
   public static boolean open=true;
   public static void print(Object obj){
	   if(!open){
		   return;
	   }
	   if(obj!=null){
		   System.out.print(obj.toString());
	   }
   }
   public static void println(Object obj){
	   if(!open){
		   return;
	   }
	   if(obj!=null){
		   System.out.println(obj.toString());
	   }
   }
   public  void trace(Object obj){
	   if(!open){
		   return;
	   }
	  // if(obj!=null){
		   System.out.println(obj+"");
	   //}
   }
   public void dispose() {
	 
   }
}
