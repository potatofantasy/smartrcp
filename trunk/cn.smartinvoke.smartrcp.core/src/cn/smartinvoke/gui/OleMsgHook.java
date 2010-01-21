
/*******************************************************************************
* Copyright (c) 2009 SmartInvoke.
* 你可以复制或修改此代码，但是必须在源代码和二进制包中添加申明以表示引用或修改了smartinvoke的代码
* 请珍惜作者的劳动成果* 您可以通过 
*  网站:http://smartinvoke.cn/ 
*  邮件:pzxiaoxiao130130@gmail.com
*  QQ：90636900*  联系到作者^_^ 
*******************************************************************************/ 
package cn.smartinvoke.gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.internal.Callback;
import org.eclipse.swt.internal.win32.MSG;
import org.eclipse.swt.internal.win32.OS;
import org.eclipse.swt.widgets.Display;

public class OleMsgHook {
	private int procHandle;

	private OleContainer container;

	private Callback oleMsgCallback;

	private int oleMsgProcAddress;
    public static final char spChar='#';
	public OleMsgHook(OleContainer container) {
		this.container = container;
		HHOOK = container.handle + spChar + container.hashCode() + spChar + "_hook";
		HHOOKMSG = container.handle + spChar + container.hashCode() + spChar
				+ "_hook_msg";
	}

	private final String HHOOK;

	private final String HHOOKMSG;

	public void installHook() {
		if (oleMsgCallback == null) {
			oleMsgCallback = new Callback(this, "OleMsgProc", 3);
			oleMsgProcAddress = oleMsgCallback.getAddress();
			if (oleMsgProcAddress == 0)
				SWT.error(SWT.ERROR_NO_MORE_CALLBACKS);
			int threadId = OS.GetCurrentThreadId();
			//Extension.SetWindowsHookEx(idHook, lpfn, hMod, dwThreadId)
			procHandle = OS.SetWindowsHookEx(OS.WH_GETMESSAGE,
					oleMsgProcAddress, 0, threadId);
			Display.getDefault().setData(HHOOK, new NumberVal(procHandle));
			Display.getDefault().setData(HHOOKMSG, new MSG());
		}
	}

	public void unInstallHook() {
		if (oleMsgCallback != null) {
			OS.UnhookWindowsHookEx(procHandle);
			oleMsgCallback.dispose();
			oleMsgCallback = null;
			oleMsgProcAddress = 0;
		}
	}

	int OleMsgProc(int /* long */code, int /* long */wParam,
			int /* long */lParam) {
		NumberVal hHook = (NumberVal) Display.getDefault().getData(HHOOK);
		if (hHook == null)
			return 0;
		if (code < 0) {
			return OS.CallNextHookEx(hHook.value, (int) /* 64 */code, wParam,
					lParam);
		}
		MSG msg = (MSG) Display.getDefault().getData(HHOOKMSG);
		OS.MoveMemory(msg, lParam, MSG.sizeof);
		if (!container.isDisposed()) {
			if (container.getHookInterceptor() != null) {
				Msg message = new Msg(msg);
				if (container.getHookInterceptor().intercept(message, code,
						wParam, lParam) == true) {
					message.setMessage(Win32Constant.WM_NULL);
					message.setLParam(0);
					message.setWParam(0);
					message.saveToPoint(lParam);
					return 0;
				}
			}
		}
		return OS.CallNextHookEx(hHook.value, (int) /* 64 */code,
				wParam, lParam);
	}
}
