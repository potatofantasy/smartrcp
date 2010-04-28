package cn.smartinvoke;
/**
 * 继承此接口的类型都是服务对象类型
 * @author pengzhen
 *此实现类的方法，不能返回当前类型的对象
 */
public interface IServerObject {
//	public String getAppId();
//	public void setAppId(String appId);
//	public String getRemoteId();
//	public void setRemoteId(String remoteId);
	public  void dispose();
}
