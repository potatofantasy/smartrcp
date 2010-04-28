package cn.smartinvoke.smartrcp.gui;

import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

import cn.smartinvoke.IServerObject;
import cn.smartinvoke.util.ImageManager;
/**
 * 状态栏管理器
 * @author pengzhen
 *
 */
public class CStatusLineManager implements IServerObject {
    private IStatusLineManager statusLineManager;
    private Image msgImg=null;
    private Image errorImg=null;
	public CStatusLineManager(IStatusLineManager statusLineManager) {
		this.statusLineManager=statusLineManager;
	}
	/**
	 * 设置状态栏一般信息图标，如果url为Null，状态栏就不会显示任何信息图标
	 * @param url
	 */
	public void setMsgImg(String url){
		if(this.msgImg!=null){
			try{
				this.msgImg.dispose();
			}catch(Exception e){};
		}
		ImageDescriptor imageDescriptor=ImageManager.getImageDescriptor(url);
		if(imageDescriptor!=null){
			this.msgImg=imageDescriptor.createImage();
		}else{
			this.msgImg=null;
		}
	}
	/**
	 * 设置状态栏错误信息图标，如果url为Null，状态栏错误信息就不会显示任何信息图标
	 * @param url
	 */
	public void setErrorImg(String url){
		if(this.errorImg!=null){
			try{
				this.errorImg.dispose();
			}catch(Exception e){};
		}
		ImageDescriptor imageDescriptor=ImageManager.getImageDescriptor(url);
		if(imageDescriptor!=null){
			this.errorImg=imageDescriptor.createImage();
		}else{
			this.errorImg=null;
		}
	}
	/**
	 * 设置状态栏一般信息
	 * @param msg
	 */
    public void setMsg(String msg){
    	if(this.msgImg!=null){
    		this.statusLineManager.setMessage(this.msgImg, msg);
    	}else{
    		this.statusLineManager.setMessage(msg);
    	}
    }
    /**
     * 设置状态栏错误信息
     * @param msg
     */
    public void setErrorMsg(String msg){
    	if(this.errorImg!=null){
    		this.statusLineManager.setErrorMessage(this.errorImg, msg);
    	}else{
    		this.statusLineManager.setErrorMessage(msg);
    	}
    }
	public void dispose() {
		
	}
}
