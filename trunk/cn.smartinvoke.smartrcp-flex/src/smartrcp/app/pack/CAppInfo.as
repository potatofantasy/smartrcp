package smartrcp.app.pack
{
	import cn.smartinvoke.rcp.CAction;
	import cn.smartinvoke.rcp.CMenuRelation;
	
	import mx.collections.ArrayCollection;
	import mx.utils.StringUtil;
	
	[Bindable]
[RemoteClass(alias="cn.smartinvoke.smartrcp.app.pack.CAppInfo")]
	public class CAppInfo
 {
		//应用程序的父文件夹路径
	public var basePath:String;
	//应用程序名称必须符合文件（夹）名规范
    public var name:String;
    //版本号
    public var version:String;
    //提供者
    public var provider:String;
    //logo.png文件路径，只能是png格式
    public var logoPath:String;
    //应用程序说明
    public var describe:String;
    //程序包路径
    public var packLocation:String;
    //菜单路径
    public var menuPath:String;
    public var meunIcon:String;
    //更新地址
    public var updateUrl:String="http://smartinvoke.cn/update";
	public function CAppInfo(){
		
	}
	private var menuObj:Object=null;
	static const Action_Id_Tag:String="smartrcp_app_";
	/**
	 *创建该程序的启动菜单对象
	 */
    public function getStartMenu(actions:ArrayCollection):Object{
    	if(this.menuObj==null){
    		//创建action对象，并添加到actionManager
    		var actionId:String=Action_Id_Tag+this.name;
    		var action:CAction=new CAction(actionId,this.name,this.meunIcon,
    		"启动"+this.name);
    		actions.addItem(action);
    		//将菜单项添加到菜单
    		
    		if(menuPath==null || 
    		   StringUtil.trim(menuPath)==""){
    		   this.menuObj=actionId;
    		}else{
    		   var menuRel:CMenuRelation=new CMenuRelation();
    		   
    		   var arr:Array=menuPath.split("/");
    		   this.menuObj=this.createMenuRel(arr,0);
    		}
    	}
    	return menuObj;
    }
    
    private function createMenuRel(arr:Array,index:int):CMenuRelation{
    	var ret:CMenuRelation=null;
    	if(index<arr.length){
    	  ret=new CMenuRelation();
    	  ret.label=arr[index];
    	  var rel:CMenuRelation=createMenuRel(arr,index+1);
    	  if(rel==null){
    	   ret.actions=[Action_Id_Tag+this.name];
    	  }else{
    	   ret.actions=[rel];
    	  }
    	}
    	return ret;
    }
  }
}