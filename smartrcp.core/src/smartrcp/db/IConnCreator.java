package smartrcp.db;

import java.sql.Connection;
/**
 * 数据库连接Creator
 * @author pengzhen
 *
 */
public interface IConnCreator {
   Connection getConnection(String url,String name,String pwd);
}
