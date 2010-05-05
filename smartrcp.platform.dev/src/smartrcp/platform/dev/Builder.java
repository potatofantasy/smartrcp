package smartrcp.platform.dev;

import cn.smartinvoke.smartrcp.DebugServer;
import cn.smartinvoke.smartrcp.core.SmartRCPBuilder;

public class Builder extends SmartRCPBuilder {
	//public static Builder Instance=new Builder();
	public Builder() {
		
	}
	/**
	 * 开发版本默认会启动调试器
	 */
	protected  void openDebugServer(){  
	     DebugServer.start();
	}
	
	public static void main(String[] args) {
		
	}

}
