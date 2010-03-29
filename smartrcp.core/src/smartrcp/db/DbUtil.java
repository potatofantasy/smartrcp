package smartrcp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import cn.smartinvoke.IServerObject;
import cn.smartinvoke.rcp.ErrorMessages;
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
