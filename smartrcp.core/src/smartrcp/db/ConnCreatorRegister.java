package smartrcp.db;

import java.util.HashMap;
import java.util.Map;
/**
 * 数据库连接创建器注册服务类
 * @author pengzhen
 *
 */
public class ConnCreatorRegister {
	//单实例
	public static final ConnCreatorRegister Instance=new ConnCreatorRegister();
    private Map<String,IConnCreator> connCreators=
    new HashMap<String, IConnCreator>();
	private ConnCreatorRegister(){
		
	}
	/**
	 * 注册数据库连接创建器
	 * @param name
	 * @param connCreator
	 */
    public void register(String name,IConnCreator connCreator){
       if(name!=null && connCreator!=null){
    	  connCreators.put(name, connCreator);
       }
    }
    /**
     * 删除数据库驱动器
     * @param name
     */
    public void remove(String name){
    	if(name!=null){
    		connCreators.remove(name);
    	}
    }
    /**
     * 获得指定名称的数据库连接创建器
     * @param name
     * @return
     */
    public IConnCreator getConnCreator(String name){
    	return connCreators.get(name);
    }
}
