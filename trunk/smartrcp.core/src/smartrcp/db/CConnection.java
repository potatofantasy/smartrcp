package smartrcp.db;

import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;

import cn.smartinvoke.IServerObject;

public class CConnection implements IServerObject{
    private Connection connection;
	public CConnection(Connection connection) {
		this.connection= connection;
	}
	public void clearWarnings() throws SQLException {
	   this.connection.clearWarnings();	
	}
	public void close() throws SQLException {
	   this.connection.close();	
	}

	
	public void commit() throws SQLException {
		this.connection.commit();
	}

	
	public Array createArrayOf(String typeName, Object[] elements)
			throws SQLException {
		return this.connection.createArrayOf(typeName, elements);
	}
	public Blob createBlob() throws SQLException {
		return this.connection.createBlob();
	}
	public Clob createClob() throws SQLException {
		return this.connection.createClob();
	}

	
	public NClob createNClob() throws SQLException {
		return this.connection.createNClob();
	}

	
	public SQLXML createSQLXML() throws SQLException {
		return this.connection.createSQLXML();
	}

	
	public CStatement createStatement() throws SQLException {
		return new CStatement(this.connection.createStatement());
	}

	
	public CStatement createStatement(int resultSetType, int resultSetConcurrency)
			throws SQLException {
		return new CStatement(this.connection.createStatement(resultSetType, resultSetConcurrency));
	}

	
	public CStatement createStatement(int resultSetType,
			int resultSetConcurrency, int resultSetHoldability)
			throws SQLException {
		return new CStatement(this.connection.createStatement(resultSetType, resultSetConcurrency, resultSetHoldability));
	}

	
	public Struct createStruct(String typeName, Object[] attributes)
			throws SQLException {
		return this.connection.createStruct(typeName, attributes);
	}

	
	public boolean getAutoCommit() throws SQLException {
		return this.connection.getAutoCommit();
	}

	
	public String getCatalog() throws SQLException {
		return this.connection.getCatalog();
	}

	
	public Properties getClientInfo() throws SQLException {
		return this.connection.getClientInfo();
	}

	
	public String getClientInfo(String name) throws SQLException {
		return this.connection.getClientInfo(name);
	}

	
	public int getHoldability() throws SQLException {
		return this.connection.getHoldability();
	}

	
	public DatabaseMetaData getMetaData() throws SQLException {
		return this.connection.getMetaData();
	}

	
	public int getTransactionIsolation() throws SQLException {
		return this.connection.getTransactionIsolation();
	}

	
	public Map<String, Class<?>> getTypeMap() throws SQLException {
		return this.connection.getTypeMap();
	}

	
	public SQLWarning getWarnings() throws SQLException {
		return this.connection.getWarnings();
	}

	
	public boolean isClosed() throws SQLException {
		return this.connection.isClosed();
	}

	
	public boolean isReadOnly() throws SQLException {
		return this.connection.isReadOnly();
	}

	
	public boolean isValid(int timeout) throws SQLException {
		return this.connection.isValid(timeout);
	}

	
	public String nativeSQL(String sql) throws SQLException {
		return this.connection.nativeSQL(sql);
	}

	
	public CallableStatement prepareCall(String sql) throws SQLException {
		return this.connection.prepareCall(sql);
	}

	
	public CallableStatement prepareCall(String sql, int resultSetType,
			int resultSetConcurrency) throws SQLException {
		return this.connection.prepareCall(sql, resultSetType, resultSetConcurrency);
	}

	
	public CallableStatement prepareCall(String sql, int resultSetType,
			int resultSetConcurrency, int resultSetHoldability)
			throws SQLException {
		return this.connection.prepareCall(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
	}

	
	public PreparedStatement prepareStatement(String sql) throws SQLException {
		return this.connection.prepareStatement(sql);
	}

	
	public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys)
			throws SQLException {
		return this.connection.prepareStatement(sql, autoGeneratedKeys);
	}

	
	public PreparedStatement prepareStatement(String sql, int[] columnIndexes)
			throws SQLException {
		return this.connection.prepareStatement(sql, columnIndexes);
	}

	
	public PreparedStatement prepareStatement(String sql, String[] columnNames)
			throws SQLException {
		return this.connection.prepareStatement(sql, columnNames);
	}

	
	public PreparedStatement prepareStatement(String sql, int resultSetType,
			int resultSetConcurrency) throws SQLException {
		return this.connection.prepareStatement(sql, resultSetType, resultSetConcurrency);
	}

	
	public PreparedStatement prepareStatement(String sql, int resultSetType,
			int resultSetConcurrency, int resultSetHoldability)
			throws SQLException {
		return this.connection.prepareStatement(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
	}

	
	public void releaseSavepoint(Savepoint savepoint) throws SQLException {
		 this.connection.releaseSavepoint(savepoint);
	}

	
	public void rollback() throws SQLException {
		this.connection.rollback();
	}

	
	public void rollback(Savepoint savepoint) throws SQLException {
		this.connection.rollback(savepoint);
	}

	
	public void setAutoCommit(boolean autoCommit) throws SQLException {
		this.connection.setAutoCommit(autoCommit);
	}

	
	public void setCatalog(String catalog) throws SQLException {
		this.connection.setCatalog(catalog);
	}

	
	public void setClientInfo(Properties properties)
			throws SQLClientInfoException {
		this.connection.setClientInfo(properties);
	}

	
	public void setClientInfo(String name, String value)
			throws SQLClientInfoException {
		this.connection.setClientInfo(name, value);
	}

	
	public void setHoldability(int holdability) throws SQLException {
		this.connection.setHoldability(holdability);
	}

	
	public void setReadOnly(boolean readOnly) throws SQLException {
		this.connection.setReadOnly(readOnly);
	}

	
	public Savepoint setSavepoint() throws SQLException {
		return this.connection.setSavepoint();
	}

	
	public Savepoint setSavepoint(String name) throws SQLException {
		return this.connection.setSavepoint(name);
	}

	
	public void setTransactionIsolation(int level) throws SQLException {
		this.connection.setTransactionIsolation(level);
	}

	
	public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
		this.connection.setTypeMap(map);
	}

	
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return this.connection.isWrapperFor(iface);
	}

	
	public <T> T unwrap(Class<T> iface) throws SQLException {
		return this.connection.unwrap(iface);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}

	@Override
	public void dispose() {
		if(this.connection!=null){
			try {
				this.connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}