package smartrcp.db;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;

import javax.media.DeallocateEvent;

import cn.smartinvoke.IServerObject;

public class CResultSet implements IServerObject {
	private ResultSet instance;

	public CResultSet(ResultSet resultSet) {
		this.instance = resultSet;
	}

	public void dispose() {

	}

	public boolean absolute(int row) throws SQLException {
		return this.instance.absolute(row);
	}

	public void afterLast() throws SQLException {

		this.instance.afterLast();
		;
	}

	public void beforeFirst() throws SQLException {

		this.instance.beforeFirst();
	}

	public void cancelRowUpdates() throws SQLException {

		this.instance.cancelRowUpdates();
	}

	public void clearWarnings() throws SQLException {

		this.instance.clearWarnings();
	}

	public void close() throws SQLException {

		this.instance.close();
	}

	public void deleteRow() throws SQLException {

		this.instance.deleteRow();
	}

	public int findColumn(String columnLabel) throws SQLException {

		return this.instance.findColumn(columnLabel);
	}

	public boolean first() throws SQLException {

		return this.instance.first();
	}

	public Array getArray(int columnIndex) throws SQLException {

		return this.instance.getArray(columnIndex);
	}

	public Array getArray(String columnLabel) throws SQLException {

		return this.instance.getArray(columnLabel);
	}

	public InputStream getAsciiStream(int columnIndex) throws SQLException {

		return this.instance.getAsciiStream(columnIndex);
	}

	public InputStream getAsciiStream(String columnLabel) throws SQLException {

		return this.instance.getAsciiStream(columnLabel);
	}

	public BigDecimal getBigDecimal(int columnIndex) throws SQLException {

		return this.instance.getBigDecimal(columnIndex);
	}

	public BigDecimal getBigDecimal(String columnLabel) throws SQLException {

		return this.instance.getBigDecimal(columnLabel);
	}

	public BigDecimal getBigDecimal(int columnIndex, int scale)
			throws SQLException {

		return this.instance.getBigDecimal(columnIndex, scale);
	}

	public BigDecimal getBigDecimal(String columnLabel, int scale)
			throws SQLException {

		return this.instance.getBigDecimal(columnLabel, scale);
	}

	public InputStream getBinaryStream(int columnIndex) throws SQLException {

		return this.instance.getBinaryStream(columnIndex);
	}

	public InputStream getBinaryStream(String columnLabel) throws SQLException {

		return this.instance.getBinaryStream(columnLabel);
	}

	public Blob getBlob(int columnIndex) throws SQLException {

		return this.instance.getBlob(columnIndex);
	}

	public Blob getBlob(String columnLabel) throws SQLException {

		return this.instance.getBlob(columnLabel);
	}

	public boolean getBoolean(int columnIndex) throws SQLException {

		return this.instance.getBoolean(columnIndex);
	}

	public boolean getBoolean(String columnLabel) throws SQLException {

		return this.instance.getBoolean(columnLabel);
	}

	public byte getByte(int columnIndex) throws SQLException {

		return this.instance.getByte(columnIndex);
	}

	public byte getByte(String columnLabel) throws SQLException {

		return this.instance.getByte(columnLabel);
	}

	public byte[] getBytes(int columnIndex) throws SQLException {

		return this.instance.getBytes(columnIndex);
	}

	public byte[] getBytes(String columnLabel) throws SQLException {

		return this.instance.getBytes(columnLabel);
	}

	public Reader getCharacterStream(int columnIndex) throws SQLException {

		return this.instance.getCharacterStream(columnIndex);
	}

	public Reader getCharacterStream(String columnLabel) throws SQLException {

		return this.instance.getCharacterStream(columnLabel);
	}

	public Clob getClob(int columnIndex) throws SQLException {

		return this.instance.getClob(columnIndex);
	}

	public Clob getClob(String columnLabel) throws SQLException {

		return this.instance.getClob(columnLabel);
	}

	public int getConcurrency() throws SQLException {

		return this.instance.getConcurrency();
	}

	public String getCursorName() throws SQLException {

		return this.instance.getCursorName();
	}

	public Date getDate(int columnIndex) throws SQLException {

		return this.instance.getDate(columnIndex);
	}

	public Date getDate(String columnLabel) throws SQLException {

		return this.instance.getDate(columnLabel);
	}

	public Date getDate(int columnIndex, Calendar cal) throws SQLException {

		return this.instance.getDate(columnIndex, cal);
	}

	public Date getDate(String columnLabel, Calendar cal) throws SQLException {

		return this.instance.getDate(columnLabel, cal);
	}

	public double getDouble(int columnIndex) throws SQLException {

		return this.instance.getDouble(columnIndex);
	}

	public double getDouble(String columnLabel) throws SQLException {

		return this.instance.getDouble(columnLabel);
	}

	public int getFetchDirection() throws SQLException {

		return this.instance.getFetchDirection();
	}

	public int getFetchSize() throws SQLException {

		return this.instance.getFetchSize();
	}

	public float getFloat(int columnIndex) throws SQLException {

		return this.instance.getFloat(columnIndex);
	}

	public float getFloat(String columnLabel) throws SQLException {

		return this.instance.getFloat(columnLabel);
	}

	public int getHoldability() throws SQLException {

		return this.instance.getHoldability();
	}

	public int getInt(int columnIndex) throws SQLException {

		return this.instance.getInt(columnIndex);
	}

	public int getInt(String columnLabel) throws SQLException {

		return this.instance.getInt(columnLabel);
	}

	public long getLong(int columnIndex) throws SQLException {

		return this.instance.getLong(columnIndex);
	}

	public long getLong(String columnLabel) throws SQLException {

		return this.instance.getLong(columnLabel);
	}

	public ResultSetMetaData getMetaData() throws SQLException {

		return this.instance.getMetaData();
	}

	public Reader getNCharacterStream(int columnIndex) throws SQLException {

		return this.instance.getNCharacterStream(columnIndex);
	}

	public Reader getNCharacterStream(String columnLabel) throws SQLException {

		return this.instance.getNCharacterStream(columnLabel);
	}

	public NClob getNClob(int columnIndex) throws SQLException {

		return this.instance.getNClob(columnIndex);
	}

	public NClob getNClob(String columnLabel) throws SQLException {

		return this.instance.getNClob(columnLabel);
	}

	public String getNString(int columnIndex) throws SQLException {

		return this.instance.getNString(columnIndex);
	}

	public String getNString(String columnLabel) throws SQLException {

		return this.instance.getNString(columnLabel);
	}

	public Object getObject(int columnIndex) throws SQLException {

		return this.instance.getObject(columnIndex);
	}

	public Object getObject(String columnLabel) throws SQLException {

		return this.instance.getObject(columnLabel);
	}

	public Object getObject(int columnIndex, Map<String, Class<?>> map)
			throws SQLException {

		return this.instance.getObject(columnIndex, map);
	}

	public Object getObject(String columnLabel, Map<String, Class<?>> map)
			throws SQLException {

		return this.instance.getObject(columnLabel, map);
	}

	public Ref getRef(int columnIndex) throws SQLException {

		return this.instance.getRef(columnIndex);
	}

	public Ref getRef(String columnLabel) throws SQLException {

		return this.instance.getRef(columnLabel);
	}

	public int getRow() throws SQLException {

		return this.instance.getRow();
	}

	public RowId getRowId(int columnIndex) throws SQLException {

		return this.instance.getRowId(columnIndex);
	}

	public RowId getRowId(String columnLabel) throws SQLException {

		return this.instance.getRowId(columnLabel);
	}

	public SQLXML getSQLXML(int columnIndex) throws SQLException {

		return this.instance.getSQLXML(columnIndex);
	}

	public SQLXML getSQLXML(String columnLabel) throws SQLException {

		return this.instance.getSQLXML(columnLabel);
	}

	public short getShort(int columnIndex) throws SQLException {

		return this.instance.getShort(columnIndex);
	}

	public short getShort(String columnLabel) throws SQLException {

		return this.instance.getShort(columnLabel);
	}

	public Statement getStatement() throws SQLException {

		return this.instance.getStatement();
	}

	public String getString(int columnIndex) throws SQLException {

		return this.instance.getString(columnIndex);
	}

	public String getString(String columnLabel) throws SQLException {

		return this.instance.getString(columnLabel);
	}

	public Time getTime(int columnIndex) throws SQLException {

		return this.instance.getTime(columnIndex);
	}

	public Time getTime(String columnLabel) throws SQLException {

		return this.instance.getTime(columnLabel);
	}

	public Time getTime(int columnIndex, Calendar cal) throws SQLException {

		return this.instance.getTime(columnIndex, cal);
	}

	public Time getTime(String columnLabel, Calendar cal) throws SQLException {

		return this.instance.getTime(columnLabel, cal);
	}

	public Timestamp getTimestamp(int columnIndex) throws SQLException {

		return this.instance.getTimestamp(columnIndex);
	}

	public Timestamp getTimestamp(String columnLabel) throws SQLException {

		return this.instance.getTimestamp(columnLabel);
	}

	public Timestamp getTimestamp(int columnIndex, Calendar cal)
			throws SQLException {

		return this.instance.getTimestamp(columnIndex, cal);
	}

	public Timestamp getTimestamp(String columnLabel, Calendar cal)
			throws SQLException {

		return this.instance.getTimestamp(columnLabel, cal);
	}

	public int getType() throws SQLException {

		return this.instance.getType();
	}

	public URL getURL(int columnIndex) throws SQLException {

		return this.instance.getURL(columnIndex);
	}

	public URL getURL(String columnLabel) throws SQLException {

		return this.instance.getURL(columnLabel);
	}

	public InputStream getUnicodeStream(int columnIndex) throws SQLException {

		return this.instance.getUnicodeStream(columnIndex);
	}

	public InputStream getUnicodeStream(String columnLabel) throws SQLException {

		return this.instance.getUnicodeStream(columnLabel);
	}

	public SQLWarning getWarnings() throws SQLException {

		return this.instance.getWarnings();
	}

	public void insertRow() throws SQLException {

		this.instance.insertRow();
	}

	public boolean isAfterLast() throws SQLException {

		return this.instance.isAfterLast();
	}

	public boolean isBeforeFirst() throws SQLException {

		return this.instance.isBeforeFirst();
	}

	public boolean isClosed() throws SQLException {

		return this.instance.isClosed();
	}

	public boolean isFirst() throws SQLException {

		return this.instance.isFirst();
	}

	public boolean isLast() throws SQLException {

		return this.instance.isLast();
	}

	public boolean last() throws SQLException {

		return this.instance.last();
	}

	public void moveToCurrentRow() throws SQLException {

		this.instance.moveToCurrentRow();
	}

	public void moveToInsertRow() throws SQLException {
		this.instance.moveToInsertRow();

	}

	public boolean next() throws SQLException {

		return this.instance.next();
	}

	public boolean previous() throws SQLException {

		return this.instance.previous();
	}

	public void refreshRow() throws SQLException {
		this.instance.refreshRow();

	}

	public boolean relative(int rows) throws SQLException {

		return this.instance.relative(rows);
	}

	public boolean rowDeleted() throws SQLException {

		return this.instance.rowDeleted();
	}

	public boolean rowInserted() throws SQLException {

		return this.instance.rowInserted();
	}

	public boolean rowUpdated() throws SQLException {
		return this.instance.rowUpdated();
	}

	public void setFetchDirection(int direction) throws SQLException {
		this.instance.setFetchDirection(direction);

	}

	public void setFetchSize(int rows) throws SQLException {
		this.instance.setFetchSize(rows);

	}

	public void updateArray(int columnIndex, Array x) throws SQLException {
		this.instance.updateArray(columnIndex, x);

	}

	public void updateArray(String columnLabel, Array x) throws SQLException {

		this.instance.updateArray(columnLabel, x);
	}

	public void updateAsciiStream(int columnIndex, InputStream x)
			throws SQLException {
		this.instance.updateAsciiStream(columnIndex, x);

	}

	public void updateAsciiStream(String columnLabel, InputStream x)
			throws SQLException {
		this.instance.updateAsciiStream(columnLabel, x);

	}

	public void updateAsciiStream(int columnIndex, InputStream x, int length)
			throws SQLException {
		this.instance.updateAsciiStream(columnIndex, x, length);

	}

	public void updateAsciiStream(String columnLabel, InputStream x, int length)
			throws SQLException {
		this.instance.updateAsciiStream(columnLabel, x, length);

	}

	public void updateAsciiStream(int columnIndex, InputStream x, long length)
			throws SQLException {
		this.instance.updateAsciiStream(columnIndex, x, length);

	}

	public void updateAsciiStream(String columnLabel, InputStream x, long length)
			throws SQLException {

		this.instance.updateAsciiStream(columnLabel, x, length);
	}

	public void updateBigDecimal(int columnIndex, BigDecimal x)
			throws SQLException {
		this.instance.updateBigDecimal(columnIndex, x);

	}

	public void updateBigDecimal(String columnLabel, BigDecimal x)
			throws SQLException {
		this.instance.updateBigDecimal(columnLabel, x);

	}

	public void updateBinaryStream(int columnIndex, InputStream x)
			throws SQLException {
		this.instance.updateBinaryStream(columnIndex, x);

	}

	public void updateBinaryStream(String columnLabel, InputStream x)
			throws SQLException {
		this.instance.updateBinaryStream(columnLabel, x);

	}

	public void updateBinaryStream(int columnIndex, InputStream x, int length)
			throws SQLException {
		this.instance.updateBinaryStream(columnIndex, x, length);

	}

	public void updateBinaryStream(String columnLabel, InputStream x, int length)
			throws SQLException {
		this.instance.updateBinaryStream(columnLabel, x, length);

	}

	public void updateBinaryStream(int columnIndex, InputStream x, long length)
			throws SQLException {
		this.instance.updateBinaryStream(columnIndex, x, length);

	}

	public void updateBinaryStream(String columnLabel, InputStream x,
			long length) throws SQLException {
		this.instance.updateBinaryStream(columnLabel, x, length);

	}

	public void updateBlob(int columnIndex, Blob x) throws SQLException {
		this.instance.updateBlob(columnIndex, x);

	}

	public void updateBlob(String columnLabel, Blob x) throws SQLException {
		this.instance.updateBlob(columnLabel, x);

	}

	public void updateBlob(int columnIndex, InputStream inputStream)
			throws SQLException {

		this.instance.updateBlob(columnIndex, inputStream);
	}

	public void updateBlob(String columnLabel, InputStream inputStream)
			throws SQLException {
		this.instance.updateBlob(columnLabel, inputStream);

	}

	public void updateBlob(int columnIndex, InputStream inputStream, long length)
			throws SQLException {
		this.instance.updateBlob(columnIndex, inputStream, length);

	}

	public void updateBlob(String columnLabel, InputStream inputStream,
			long length) throws SQLException {

		this.instance.updateBlob(columnLabel, inputStream, length);
	}

	public void updateBoolean(int columnIndex, boolean x) throws SQLException {

		this.instance.updateBoolean(columnIndex, x);
	}

	public void updateBoolean(String columnLabel, boolean x)
			throws SQLException {
		this.instance.updateBoolean(columnLabel, x);

	}

	public void updateByte(int columnIndex, byte x) throws SQLException {
		this.instance.updateByte(columnIndex, x);

	}

	public void updateByte(String columnLabel, byte x) throws SQLException {
		this.instance.updateByte(columnLabel, x);

	}

	public void updateBytes(int columnIndex, byte[] x) throws SQLException {
		this.instance.updateBytes(columnIndex, x);

	}

	public void updateBytes(String columnLabel, byte[] x) throws SQLException {
		this.instance.updateBytes(columnLabel, x);

	}

	public void updateCharacterStream(int columnIndex, Reader x)
			throws SQLException {
		this.instance.updateCharacterStream(columnIndex, x);

	}

	public void updateCharacterStream(String columnLabel, Reader reader)
			throws SQLException {
		this.instance.updateCharacterStream(columnLabel, reader);

	}

	public void updateCharacterStream(int columnIndex, Reader x, int length)
			throws SQLException {

		this.instance.updateCharacterStream(columnIndex, x, length);
	}

	public void updateCharacterStream(String columnLabel, Reader reader,
			int length) throws SQLException {
		this.instance.updateCharacterStream(columnLabel, reader, length);

	}

	public void updateCharacterStream(int columnIndex, Reader x, long length)
			throws SQLException {

		this.instance.updateCharacterStream(columnIndex, x, length);
	}

	public void updateCharacterStream(String columnLabel, Reader reader,
			long length) throws SQLException {

		this.instance.updateCharacterStream(columnLabel, reader, length);
	}

	public void updateClob(int columnIndex, Clob x) throws SQLException {

		this.instance.updateClob(columnIndex, x);
	}

	public void updateClob(String columnLabel, Clob x) throws SQLException {

		this.instance.updateClob(columnLabel, x);
	}

	public void updateClob(int columnIndex, Reader reader) throws SQLException {

		this.instance.updateClob(columnIndex, reader);
	}

	public void updateClob(String columnLabel, Reader reader)
			throws SQLException {
		this.instance.updateClob(columnLabel, reader);

	}

	public void updateClob(int columnIndex, Reader reader, long length)
			throws SQLException {
		this.instance.updateClob(columnIndex, reader, length);

	}

	public void updateClob(String columnLabel, Reader reader, long length)
			throws SQLException {

		this.instance.updateClob(columnLabel, reader, length);
	}

	public void updateDate(int columnIndex, Date x) throws SQLException {

		this.instance.updateDate(columnIndex, x);
	}

	public void updateDate(String columnLabel, Date x) throws SQLException {
		this.instance.updateDate(columnLabel, x);

	}

	public void updateDouble(int columnIndex, double x) throws SQLException {
		this.instance.updateDouble(columnIndex, x);

	}

	public void updateDouble(String columnLabel, double x) throws SQLException {
		this.instance.updateDouble(columnLabel, x);

	}

	public void updateFloat(int columnIndex, float x) throws SQLException {
		this.instance.updateFloat(columnIndex, x);

	}

	public void updateFloat(String columnLabel, float x) throws SQLException {

		this.instance.updateFloat(columnLabel, x);
	}

	public void updateInt(int columnIndex, int x) throws SQLException {
		this.instance.updateInt(columnIndex, x);

	}

	public void updateInt(String columnLabel, int x) throws SQLException {

		this.instance.updateInt(columnLabel, x);
	}

	public void updateLong(int columnIndex, long x) throws SQLException {
		this.instance.updateLong(columnIndex, x);

	}

	public void updateLong(String columnLabel, long x) throws SQLException {
		this.instance.updateLong(columnLabel, x);

	}

	public void updateNCharacterStream(int columnIndex, Reader x)
			throws SQLException {

		this.instance.updateNCharacterStream(columnIndex, x);
	}

	public void updateNCharacterStream(String columnLabel, Reader reader)
			throws SQLException {

		this.instance.updateNCharacterStream(columnLabel, reader);
	}

	public void updateNCharacterStream(int columnIndex, Reader x, long length)
			throws SQLException {
		this.instance.updateNCharacterStream(columnIndex, x, length);

	}

	public void updateNCharacterStream(String columnLabel, Reader reader,
			long length) throws SQLException {
		this.instance.updateNCharacterStream(columnLabel, reader, length);

	}

	public void updateNClob(int columnIndex, NClob nClob) throws SQLException {
		this.instance.updateNClob(columnIndex, nClob);

	}

	public void updateNClob(String columnLabel, NClob nClob)
			throws SQLException {
		this.instance.updateNClob(columnLabel, nClob);

	}

	public void updateNClob(int columnIndex, Reader reader) throws SQLException {

		this.instance.updateNClob(columnIndex, reader);
	}

	public void updateNClob(String columnLabel, Reader reader)
			throws SQLException {
		this.instance.updateNClob(columnLabel, reader);

	}

	public void updateNClob(int columnIndex, Reader reader, long length)
			throws SQLException {
		this.instance.updateNClob(columnIndex, reader, length);

	}

	public void updateNClob(String columnLabel, Reader reader, long length)
			throws SQLException {

		this.instance.updateNClob(columnLabel, reader, length);
	}

	public void updateNString(int columnIndex, String nString)
			throws SQLException {

		this.instance.updateNString(columnIndex, nString);
	}

	public void updateNString(String columnLabel, String nString)
			throws SQLException {

		this.instance.updateNString(columnLabel, nString);
	}

	public void updateNull(int columnIndex) throws SQLException {

		this.instance.updateNull(columnIndex);
	}

	public void updateNull(String columnLabel) throws SQLException {
		this.instance.updateNull(columnLabel);

	}

	public void updateObject(int columnIndex, Object x) throws SQLException {

		this.instance.updateObject(columnIndex, x);
	}

	public void updateObject(String columnLabel, Object x) throws SQLException {

		this.instance.updateObject(columnLabel, x);
	}

	public void updateObject(int columnIndex, Object x, int scaleOrLength)
			throws SQLException {

		this.instance.updateObject(columnIndex, x, scaleOrLength);
	}

	public void updateObject(String columnLabel, Object x, int scaleOrLength)
			throws SQLException {
		this.instance.updateObject(columnLabel, x, scaleOrLength);

	}

	public void updateRef(int columnIndex, Ref x) throws SQLException {
		this.instance.updateRef(columnIndex, x);

	}

	public void updateRef(String columnLabel, Ref x) throws SQLException {
		this.instance.updateRef(columnLabel, x);

	}

	public void updateRow() throws SQLException {

		this.instance.updateRow();
	}

	public void updateRowId(int columnIndex, RowId x) throws SQLException {

		this.instance.updateRowId(columnIndex, x);
	}

	public void updateRowId(String columnLabel, RowId x) throws SQLException {
		this.instance.updateRowId(columnLabel, x);

	}

	public void updateSQLXML(int columnIndex, SQLXML xmlObject)
			throws SQLException {
		this.instance.updateSQLXML(columnIndex, xmlObject);

	}

	public void updateSQLXML(String columnLabel, SQLXML xmlObject)
			throws SQLException {
		this.instance.updateSQLXML(columnLabel, xmlObject);

	}

	public void updateShort(int columnIndex, short x) throws SQLException {
		this.instance.updateShort(columnIndex, x);

	}

	public void updateShort(String columnLabel, short x) throws SQLException {
		this.instance.updateShort(columnLabel, x);

	}

	public void updateString(int columnIndex, String x) throws SQLException {
		this.instance.updateString(columnIndex, x);

	}

	public void updateString(String columnLabel, String x) throws SQLException {
		this.instance.updateString(columnLabel, x);

	}

	public void updateTime(int columnIndex, Time x) throws SQLException {
		this.instance.updateTime(columnIndex, x);

	}

	public void updateTime(String columnLabel, Time x) throws SQLException {
		this.instance.updateTime(columnLabel, x);

	}

	public void updateTimestamp(int columnIndex, Timestamp x)
			throws SQLException {
		this.instance.updateTimestamp(columnIndex, x);

	}

	public void updateTimestamp(String columnLabel, Timestamp x)
			throws SQLException {
		this.instance.updateTimestamp(columnLabel, x);

	}

	public boolean wasNull() throws SQLException {

		return this.instance.wasNull();
	}

	public boolean isWrapperFor(Class<?> iface) throws SQLException {

		return this.instance.isWrapperFor(iface);
	}

	public <T> T unwrap(Class<T> iface) throws SQLException {

		return this.instance.unwrap(iface);
	}

}
