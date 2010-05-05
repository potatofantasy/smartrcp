import java.io.IOException;
import java.text.SimpleDateFormat;
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
		new AlarmT();
		System.in.read();
	}

}
