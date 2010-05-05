package smartrcp.platform.dev;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;

import cn.smartinvoke.IServerObject;
import cn.smartinvoke.smartrcp.gui.module.CObservable;

public class ConsoleServer extends CObservable implements IServerObject,Runnable {
	private  ByteArrayOutputStream standOut,errorOut;
	public static final int Buff_Size=1024*1024;
	
	public static final ConsoleServer Instance=new ConsoleServer();
    public   void init(){
		  standOut=new ByteArrayOutputStream(Buff_Size);
		  errorOut=new ByteArrayOutputStream(Buff_Size);
		  System.setOut(new PrintStream(standOut));
		  System.setErr(new PrintStream(errorOut));
    }
	private ConsoleServer() {
	    this.init();
	    
	    Thread thread=new Thread(this);
	    thread.setDaemon(true);
	    thread.start();
	}
	public void run() {
		while(true){
			if(standOut.size()>0){
			 byte[] contentBts=standOut.toByteArray();
			 this.fireEvent(new Object[]{false,new String(contentBts).trim()});
			 standOut.reset();
			}
			if(errorOut.size()>0){
			  byte[] errorContent=errorOut.toByteArray();
			  this.fireEvent(new Object[]{true,new String(errorContent).trim()});
			  errorOut.reset();
			}
			try{Thread.sleep(2000);}catch(Exception e){};
		}
	}

}
