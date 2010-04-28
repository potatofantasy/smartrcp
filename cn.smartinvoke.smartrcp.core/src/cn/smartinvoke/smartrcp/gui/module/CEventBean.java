package cn.smartinvoke.smartrcp.gui.module;

import java.util.List;

import org.eclipse.swt.widgets.Event;

import cn.smartinvoke.RemoteObject;
import cn.smartinvoke.gui.FlashViewer;
import cn.smartinvoke.smartrcp.gui.control.GlobalServiceId;
import cn.smartinvoke.util.Log;

/**
 * flex监听器传递的bean数据。 当flex有监听器添加到java时，会传递此实例， 作为监听器信息，当java对应事件触发时，会跟据该信息类
 * 调用flex中的指定方法。
 * 
 * @author pengzhen
 * 
 */
public class CEventBean {
	// private FlashViewPart flashView;
	// 监听器函数的Id
	private String funId = null;
	// private RemoteObject funRemoteObj=null;
	// 监听器函数的宿主对象，具体指。监听器函数中的this对象的id
	private String tagetId = null;
	// flex的应用程序Id，它与FlashViewer对应
	private String appId = null;
	// private RemoteObject tagetRemoteObj=null;

	private RemoteObject flexEventNotifer = null;

	public CEventBean() {

	}

	public String getFunId() {
		return funId;
	}

	public void setFunId(String funId) {
		this.funId = funId;
		// if(this.funId!=null && this.flashView!=null){
		// this.funRemoteObj=new
		// RemoteObject(this.flashView.getFlashContainer());
		// this.funRemoteObj.setRemoteId(this.funId);
		// }
	}

	public String getTagetId() {
		return tagetId;
	}

	public void setTagetId(String tagetId) {
		this.tagetId = tagetId;
		// IF(THIS.TAGETID!=NULL && THIS.FLASHVIEW!=NULL){
		// THIS.TAGETREMOTEOBJ=NEW
		// REMOTEOBJECT(THIS.FLASHVIEW.GETFLASHCONTAINER());
		// THIS.TAGETREMOTEOBJ.SETREMOTEID(THIS.TAGETID);
		// }
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}
    public Object fireResEvent(Object param) {
    	Object ret=null;
		try {
			this.init();

			if (this.flexEventNotifer != null) {
				ret=this.flexEventNotifer.call("fireEvent", new Object[] {
						this.tagetId, this.funId, param });
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}
    /**
     * 调用flex监听器
     * @param param
     */
	public void fireEvent(Object param) {
		try {
			this.init();

			if (this.flexEventNotifer != null) {
				this.flexEventNotifer.asyncCall("fireEvent", new Object[] {
						this.tagetId, this.funId, param });
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 触发flex oneTime监听器，该类型监听器只触发一次然后就删除
	 * @param param
	 */
	public void fireOnetimeEvent(Object param) {
		try {
			this.init();

			if (this.flexEventNotifer != null) {
				this.flexEventNotifer.asyncCall("fireEvent", new Object[] {
						this.tagetId, this.funId, param,true});
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void fireEvent(Event evt) {
		try {
			this.init();
			if (this.flexEventNotifer != null) {
				CEvent cEvent = new CEvent(evt.type, evt.index, evt.x, evt.y,
						evt.width, evt.height, evt.count, evt.time, evt.button,
						evt.character, evt.keyCode, evt.stateMask, evt.start,
						evt.end, evt.text);

				this.flexEventNotifer.asyncCall("fireEvent", new Object[] {
						this.tagetId, this.funId, cEvent });
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void fireEvent() {
		try {
			this.init();
			if (this.flexEventNotifer != null) {
				this.flexEventNotifer.asyncCall("fireEvent", new Object[] {
						this.tagetId, this.funId, null });
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void fireAction(CActionEvent evt) {
		try {
			this.init();
			if (this.flexEventNotifer != null) {
				this.flexEventNotifer.asyncCall("fireAction", new Object[] {
						this.tagetId, this.funId, evt });
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void init() {
		// this.flashView=flashView;
		if (this.flexEventNotifer == null && this.appId != null) {
			// 获得FlashViewer
			//List<FlashViewer> flashViewers=FlashViewer.getViewers();
			FlashViewer flashViewer = FlashViewer.getViewerByAppId(this.appId);
			if (flashViewer != null) {
				// 因为是全局服务对象，所以不要自动回收
				//TODO 这里可以进行优化
				this.flexEventNotifer = new RemoteObject(flashViewer
						.getFlashContainer(), false);
				this.flexEventNotifer
						.setRemoteId(GlobalServiceId.Flex_CEvent_Notifer);
			}
		}
	}

	public boolean equals(Object anoth) {
		boolean ret = false;
		if (anoth instanceof CEventBean) {
			CEventBean anBean = (CEventBean) anoth;
			if (this.funId != null && this.tagetId != null) {
				if (anBean.funId != null && anBean.tagetId != null) {
					if (this.funId.equals(anBean.funId)) {
						if (this.tagetId.equals(anBean.tagetId)) {
							ret = true;
						}
					}
				}
			}
		}

		return ret;
	}

	public int hashCode() {
		if (this.funId != null && this.tagetId != null) {
			return this.funId.hashCode() + this.tagetId.hashCode();
		}
		return super.hashCode();
	}
    public String toString(){
    	return this.appId;
    }
    public void dispose(){
    	//TODO CEventBean 对象内存的清理
    	/*Log.println("remove cEventBean listener:"+this.tagetId+" "+this.funId);
		if(this.flexEventNotifer!=null){
		 this.flexEventNotifer.asyncCall("removeListener",new Object[]{this.tagetId,this.funId});
		}*/
    }
	/**
	 * 释放flex ObjectPool中的资源，避免内存泄露
	 */
	protected void finalize() {
		// if(this.tagetRemoteObj!=null){
		// this.tagetRemoteObj.dispose();
		// }
		// if(this.funRemoteObj!=null){
		// this.funRemoteObj.dispose();
		// }
		/*Log.println("remove cEventBean listener:"+this.tagetId+" "+this.funId);
		if(this.flexEventNotifer!=null){
		 this.flexEventNotifer.asyncCall("removeListener",new Object[]{this.tagetId,this.funId});
		}*/
	}

}
