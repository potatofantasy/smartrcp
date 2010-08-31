package cn.smartinvoke;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.swt.widgets.Control;

import cn.smartinvoke.exception.InvokeException;
import cn.smartinvoke.exception.Messages;
import cn.smartinvoke.smartrcp.gui.FlashShell;
import cn.smartinvoke.smartrcp.gui.module.CObservable;
import cn.smartinvoke.util.HelpMethods;
import cn.smartinvoke.util.Log;

/**
 * 对象池，管理着平台中的所有远程调用的响应对象
 * 
 * @author pengzhen
 * 
 */
public class ObjectPool implements IObjectPool{
	public static final ObjectPool INSTANCE = new ObjectPool();
	public  IServiceObjectCreator objectCreator=null;
	/**
	 * 为每个应用程序的响应对象创建一响应对象池
	 */
	private Map<String,PoolEntity> poolMaps = new HashMap<String, PoolEntity>();
    //全局对象池
	private Map<String,Object> globalMap=new HashMap<String, Object>();
	private ObjectPool() {
        this.objectCreator=new IServiceObjectCreator(){

			public Class getClass(String clsName) throws ClassNotFoundException {
				
				return Class.forName(clsName);
			}
        	
        };
	}

	public synchronized String putObject(String appId,
			Object object, String key) {

		if (appId == null || object == null || key == null) {
			return null;
		}
		
		PoolEntity poolEntity = this.getPoolEntity(appId);
		Map map = poolEntity.objMap;
		if (map.get(key)==null) {
			poolEntity.objMap.put(key, object);
		}
		return key;
	}

	public String putObject(String appId, Object object) {
		return this.putObject(appId, object, this.getObjectkey(object));
	}
	/**
	 * 全局对象
	 * @param object
	 * @return
	 */
	public String putObject(Object object) {
		String key=this.getObjectkey(object);
		this.globalMap.put(key, object);
		return key;
	}
	/**
	 * 设置全局对象，以指定key的方式
	 * @param object
	 * @return
	 */
	public String putObject(Object object,String key){
		
		this.globalMap.put(key, object);
		return key;
	}
	public String getObjectkey(Object object) {
		String ret = null;
		if (object != null) {
			ret = object.getClass().getName() + "" + object.hashCode();
		}
		return ret;
	}

	/**
	 * 容器是否已经包含指定id的对象
	 * 
	 * @param container
	 * @param objId
	 * @return
	 */
	public synchronized Object isAlreadyContainerObject(
			String appId, String objId) {
		Object ret = null;
		PoolEntity entity = this.getPoolEntity(appId);
		if (entity != null) {
			ret = entity.objMap.get(objId);
		}
		return ret;
	}
	public synchronized String createObject(String appId,
			String clsName, Object[] pars) throws Exception {// 
		String ret = "-1";
		try{
			if(objectCreator==null){
				throw new InvokeException("the ObjectCreator  must be creator!");
			}
			Class cls =objectCreator.getClass(clsName);
			Constructor con=HelpMethods.getConstructor(cls, pars);
			Object createObj=con.newInstance(pars);
			if(TypeMapper.Instance.isServerObject(createObj)){
				ret = this.putObject(appId, createObj);
			}else{
				throw new InvokeException(clsName+" must extend the cn.smartinvoke.ServiceObject class.");
			}
		}catch(ClassNotFoundException e){
			InvokeException invokException = new InvokeException(
					InvokeException.TYPE_INVOK_OBJ_CREATE_FAULT,
					Messages.INSTANCE.getMsg(
							Messages.Ivk_INVOK_OBJ_CREATE_FAULT,
							new String[] { clsName }));

			throw invokException;
		} catch (IllegalArgumentException e) {
			InvokeException invokException = new InvokeException(
					InvokeException.TYPE_INVOK_OBJ_CREATE_FAULT,
					Messages.INSTANCE.getMsg(
							Messages.Ivk_INVOK_OBJ_CREATE_FAULT,
							new String[] { clsName }));

			throw invokException;
		} catch (InstantiationException e) {
			InvokeException invokException = new InvokeException(
					InvokeException.TYPE_INVOK_OBJ_CREATE_FAULT,
					Messages.INSTANCE.getMsg(
							Messages.Ivk_INVOK_OBJ_CREATE_FAULT,
							new String[] { clsName }));

			throw invokException;
		} catch (IllegalAccessException e) {
			InvokeException invokException = new InvokeException(
					InvokeException.TYPE_INVOK_OBJ_CREATE_FAULT,
					Messages.INSTANCE.getMsg(
							Messages.Ivk_INVOK_OBJ_CREATE_FAULT,
							new String[] { clsName }));

			throw invokException;
		} catch (InvocationTargetException e) {
			InvokeException invokException = new InvokeException(
					InvokeException.TYPE_INVOK_OBJ_CREATE_FAULT,
					Messages.INSTANCE.getMsg(
							Messages.Ivk_INVOK_OBJ_CREATE_FAULT,
							new String[] { clsName }));

			throw invokException;
		}catch(Throwable e){
			throw new RuntimeException(e);
		}
		return ret;
	}

	public synchronized Object getObject(String appId, String objId) {
		Object ret = null;
		//首先在flash容器池中找
		PoolEntity poolEntity = this.getPoolEntity(appId);
		if (poolEntity != null) {
			ret = poolEntity.objMap.get(objId);
		}
		//如果找不到到全局池中找
		if(ret==null){
			ret=this.globalMap.get(objId);
		}
		return ret;
	}
	public synchronized Object getObject(String objId) {
		Object ret=null;
		if(objId!=null){
			ret=this.globalMap.get(objId);
		}
		return ret;
	}

	public synchronized void removeObject(String appId, String objId) {
		PoolEntity poolEntity = this.getPoolEntity(appId);
		if (poolEntity != null) {
			//Log.println("ObjectPool :dispose size="+poolEntity.objMap.size()+" id="+objId);
			Object obj=poolEntity.objMap.remove(objId);
			if(obj!=null && obj instanceof IServerObject){
				((IServerObject)obj).dispose();
			}
		}
	}
	public synchronized void removeObject(String objId) {
	  if(objId!=null){
		this.globalMap.remove(objId);
	  }
	}
	public synchronized void clearAppPool(String appId) {
		// TODO 调用析构方法
		if (appId != null) {
				PoolEntity temp = this.poolMaps.get(appId);
				if(temp!=null){
					temp.clearObjects();
				}
		}
	}

	/**
	 * 根据FlashContainer对象返回对应的PoolEntity对象
	 * 
	 * @param container
	 * @return
	 */
	private PoolEntity getPoolEntity(String appId) {
		PoolEntity ret = null;
		if (appId != null) {
			ret=poolMaps.get(appId);
			if(ret==null){
				ret=new PoolEntity();
				poolMaps.put(appId, ret);
			}
		}
		return ret;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}

/**
 * 池实体，管理以特定应用的所有响应对象池
 * 
 * @author pengzhen
 * 
 */
class PoolEntity {
	long objectIndex = 0;
	/**
	 * 对象池
	 */
	Map objMap = new HashMap();
	/**
	 * 释放objMap中的所有内存对象
	 */
	public void clearObjects(){
		//Iterator<Object> keys= objMap.keySet().iterator();
		System.err.println("ObjectPool.clearObjects>>");
		for(Object key: objMap.keySet()){
			//Object key =  keys.next();
			Object value=objMap.get(key);
			
			if(value instanceof IServerObject){
				if(!(value instanceof Control)){//如果是swt控件就不用调用dispose方法了
				  if(!(value instanceof FlashShell)){//如果是flashShell对象也不需要调用
				   //强制调用serviceObject的dispose方法以释放对象
				   ((IServerObject)value).dispose();
				  }
				}
			}
		}
		this.objMap.clear();
		System.out.println("PoolEntity.clearObjects() map size="+objMap.size());
	}
}
