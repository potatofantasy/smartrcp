
/*******************************************************************************
* Copyright (c) 2009 SmartInvoke.
* 此代理类由CodeTransform工具自动生成
* 您可以通过 
*  网站:http://smartinvoke.cn/ 
*  邮件:pzxiaoxiao130130@gmail.com
*  QQ：90636900*  联系到作者^_^ 
*******************************************************************************/ 
package cn.smartinvoke.rcp;

import java.util.LinkedList;
 public class CPageLayout  implements ICFolderLayout{
	 
	private boolean editorAreaVisible=true;
	public boolean fixed=false;
    private LinkedList<CLayout> layouts=null;
    
	public LinkedList<CLayout> getLayouts() {
		return layouts;
	}
	public void setLayouts(LinkedList<CLayout> layouts) {
		this.layouts = layouts;
	}
	public boolean isEditorAreaVisible() {
		return editorAreaVisible;
	}
	public void setEditorAreaVisible(boolean editorAreaVisible) {
		this.editorAreaVisible = editorAreaVisible;
	}
	public CPageLayout() {
		super();
	}
	
	
 }
