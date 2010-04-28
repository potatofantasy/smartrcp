package cn.smartinvoke;

import org.eclipse.swt.widgets.Composite;
 abstract class OleContainer extends Composite {

	public OleContainer(Composite parent, int style) {
		super(parent, style);
	}

	public abstract void addHookInterceptor(OleHookInterceptor interceptor);
	public abstract OleHookInterceptor getHookInterceptor();
}
