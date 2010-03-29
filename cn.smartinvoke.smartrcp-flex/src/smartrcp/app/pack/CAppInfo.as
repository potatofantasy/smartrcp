package smartrcp.app.pack
{
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
    //更新地址
    public var updateUrl:String="http://smartinvoke.cn/update";
	public function CAppInfo(){
	}

	}
}