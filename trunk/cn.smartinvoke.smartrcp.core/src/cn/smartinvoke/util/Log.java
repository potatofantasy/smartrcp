package cn.smartinvoke.util;

public class Log {
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
}
