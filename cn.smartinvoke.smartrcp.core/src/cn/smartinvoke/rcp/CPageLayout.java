
/*******************************************************************************
* Copyright (c) 2009 SmartInvoke.
* 此代理类由CodeTransform工具自动生成
* 您可以通过 
*  网站:http://smartinvoke.cn/ 
*  邮件:pzxiaoxiao130130@gmail.com
*  QQ：90636900*  联系到作者^_^ 
*******************************************************************************/ 
package cn.smartinvoke.rcp;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
 public class CPageLayout  implements ICFolderLayout{
	/**
	 *以视图模块id为key以appId集合为值的map 
	 */
	private Map<String,List<String>> moduleIdAppIdMap=new HashMap<String, List<String>>();
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
	
	public void addViewPartInfo(String moduleStr,String appId){
		if(moduleStr!=null && appId!=null){
		  List<String> appIds=this.moduleIdAppIdMap.get(moduleStr);
		  if(appIds==null){
			  appIds=new LinkedList<String>();
			  moduleIdAppIdMap.put(moduleStr, appIds);
		  }
		  //保证唯一性
		  if(!appIds.contains(appId)){
		    appIds.add(appId);
		  }
		}
	}
	public void removeViewPartInfo(String moduleStr,String appId){
		if(moduleStr!=null && appId!=null){
		   List<String> appIds=this.moduleIdAppIdMap.get(moduleStr);
		   if(appIds!=null){
			  if(appIds.contains(appId)){
			    appIds.remove(appId);
			  }
		   }
		}
	}
	/**
	 * 返回该appId对应的模块字符串
	 * @param appId
	 * @return
	 */
	public String getModuleStr(String appId){
		String ret=null;
		if(appId==null){
			return null;
		}
		Iterator<String> keys=this.moduleIdAppIdMap.keySet().iterator();
		while(keys.hasNext()){
			String key=keys.next();
			List<String> appIds=this.moduleIdAppIdMap.get(key);
			if(appIds!=null){
				if(appIds.contains(appId)){
					ret=key;
					break;
				}
			}
		}
		return ret;
	}
	public Map<String, List<String>> getModuleIdAppIdMap() {
		return moduleIdAppIdMap;
	}
 }
