package cn.smartinvoke.smartrcp.core;

import java.util.HashMap;
import java.util.Map;

/**
 * 在smartrcp开发的时候需要swt界面与flex界面集成，通过本类，可以将
 * 方便的实现swt与flex界面的集成
 * @author pengzhen
 *
 */
public class SmartRCPViewPartService {
    public static final SmartRCPViewPartService Instance=new SmartRCPViewPartService();
    /**
     * swt界面单元被存储的map
     */
    private Map<String,ISWTPartUnit> viewParts=new HashMap<String, ISWTPartUnit>(5);
	private SmartRCPViewPartService() {
		
	}
	/**
	 * 扩展代码，调用此方法注册界面单元，以实现swt界面与Flex界面的互调
	 * @param partUnit
	 */
    public void registerSWTUnit(ISWTPartUnit partUnit){
    	if(partUnit!=null){
    		//如果已经注册了，就什么也不做
    		if(!viewParts.containsKey(partUnit.getId())){
    		   viewParts.put(partUnit.getId(), partUnit);
    		}
    	}
    }
    /**
     * 返回全部已注册的界面单元，该方法只是包可见
     * @return
     */
    Map<String,ISWTPartUnit> getSWTPartUnits(){
    	return viewParts;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<String,String> viewParts=new HashMap<String, String>(1);
		for(int i=0;i<20;i++){
			viewParts.put("key"+i,"value"+i);
		}
		System.out.println(viewParts.size());
	}

}
