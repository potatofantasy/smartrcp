import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.BitSet;
import java.util.Date;

import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.Display;


public class AlarmT implements Runnable{
	public AlarmT(){
		new Thread(this).start();
	}
	public void run(){
      while(true){
		 java.text.DateFormat format = new SimpleDateFormat("HHmm");
		 String  value = format.format(new Date()); 
		 if(value.equals("0739")){
			 try{
				 System.out.println("run...........");
				 Display display=new Display();
			 Program.launch("C:/kk.mp3");
			 }catch(Exception e){e.printStackTrace();};
		 }
		 try{Thread.sleep(1000);}catch(Exception e){};
      }
	}

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BitSet set=new BitSet(100);
		long a=Long.MIN_VALUE;
		//有第三个权限值
		long pt=Long.MAX_VALUE;
		System.out.println(Long.toBinaryString(pt));
		System.out.println(Long.toBinaryString(pt>>>3));
		a=a^(pt>>3);
		System.out.println(Long.toBinaryString(a));
		//System.in.read();
	}

}
