package smartrcp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;

import cn.smartinvoke.IServerObject;
import cn.smartinvoke.rcp.ErrorMessages;
import cn.smartinvoke.smartrcp.CApplication;
import cn.smartinvoke.smartrcp.gui.control.GlobalServiceId;
import cn.smartinvoke.smartrcp.gui.module.CEventBean;

public class DbUtil implements IServerObject {

	public DbUtil() {
		
	}

	/**
	 * ¼ÓÔØÇý¶¯Æ÷
	 * 
	 * @param driverName
	 */
	public void loadDriver(String driverName) {
		try {
            Class.forName(driverName);
//		    List<Bundle> standardBundles=CApplication.getStandardBundles();
//		    for(int i=0;i<standardBundles.size();i++){
//		    	Bundle bundle=standardBundles.get(i);
//		    	String name=bundle.getSymbolicName();
//		    	if(name.equals(driverName)){
//		    		bundle.loadClass(name)
//		    	}
//		    }
//			Bundle bundle=Platform.getBundle(driverName);
//			if(bundle!=null){
//			  bundle.loadClass(driverName);
//			}else{
//			  throw new ClassNotFoundException(ErrorMessages.DB_Driver_Load_Error+driverName);
//			}
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(ErrorMessages.DB_Driver_Load_Error+driverName);
		}
	}

	public void getConnection(String url, String user, String pwd,CEventBean listener) {
		//Connection connection = null;
		try {
			Connection connection = DriverManager.getConnection(url, user, pwd);
			listener.fireOnetimeEvent(new CConnection(connection));
		} catch (Throwable e){
			if(listener!=null){
			 listener.fireOnetimeEvent(e.getMessage());
			}
		}
	}

	@Override
	public void dispose() {
       
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("over");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
