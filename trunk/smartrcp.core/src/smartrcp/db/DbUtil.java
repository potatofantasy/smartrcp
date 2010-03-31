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
    private IConnCreator connCreator;
	/**
	 * ¼ÓÔØÇý¶¯Æ÷
	 * 
	 * @param driverName
	 */
	public void loadDriver(String driverName) {
		connCreator=
			ConnCreatorRegister.Instance.getConnCreator(driverName);
		if(connCreator==null){
			throw new RuntimeException(ErrorMessages.DB_ConnCreator_Null);
		}
	}

	public void getConnection(String url, String user, String pwd,CEventBean listener) {
		//Connection connection = null;
		try {
			Connection connection = connCreator.getConnection(url, user, pwd);
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
