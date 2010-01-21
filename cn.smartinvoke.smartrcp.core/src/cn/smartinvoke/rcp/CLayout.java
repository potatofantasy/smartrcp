
/*******************************************************************************
* Copyright (c) 2009 SmartInvoke.
* 此代理类由CodeTransform工具自动生成
* 您可以通过 
*  网站:http://smartinvoke.cn/ 
*  邮件:pzxiaoxiao130130@gmail.com
*  QQ：90636900*  联系到作者^_^ 
*******************************************************************************/ 
package cn.smartinvoke.rcp;
public class CLayout implements ILayout
{
	private int relationship;
	private double ratio;
	
	private boolean closeable=true;
	private boolean moveable=true;
	
	private String viewId=null;
	private String title;
	private ICFolderLayout refLayout=null;
	//该配置器对应的视图是否创建
	private boolean isCreate=false;
	
	public int getRelationship() {
		return relationship;
	}
	public void setRelationship(int relationship) {
		this.relationship = relationship;
	}
	public double getRatio() {
		return ratio;
	}
	public void setRatio(double ratio) {
		this.ratio = ratio;
	}
	public boolean isCloseable() {
		return closeable;
	}
	public void setCloseable(boolean closeable) {
		this.closeable = closeable;
	}
	public boolean isMoveable() {
		return moveable;
	}
	public void setMoveable(boolean moveable) {
		this.moveable = moveable;
	}
	public String getViewId() {
		return viewId;
	}
	public void setViewId(String viewId) {
		this.viewId = viewId;
	}
	public ICFolderLayout getRefLayout() {
		return refLayout;
	}
	public void setRefLayout(ICFolderLayout refLayout) {
		this.refLayout = refLayout;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public boolean isCreate() {
		return isCreate;
	}
	public void setCreate(boolean isCreate) {
		this.isCreate = isCreate;
	}
	
}
