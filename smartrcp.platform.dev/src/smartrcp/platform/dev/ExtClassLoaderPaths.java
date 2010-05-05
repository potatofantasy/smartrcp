package smartrcp.platform.dev;

import org.osgi.framework.Bundle;

import cn.smartinvoke.IServerObject;

public class ExtClassLoaderPaths implements IServerObject {
	 private final Bundle delegate;
	 
	  public ExtClassLoaderPaths(Bundle delegate) {
	    this.delegate = delegate;
	  }
	public void dispose() {
	  	
	}
}
