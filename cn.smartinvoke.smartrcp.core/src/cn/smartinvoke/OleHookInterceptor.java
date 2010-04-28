
package cn.smartinvoke;

public interface OleHookInterceptor {
	
	boolean intercept(Msg message, int code, int wParam, int lParam);
}
