
/*******************************************************************************
* Copyright (c) 2009 SmartInvoke.
* 你可以复制或修改此代码，但是必须在源代码和二进制包中添加申明以表示引用或修改了smartinvoke的代码
* 请珍惜作者的劳动成果* 您可以通过 
*  网站:http://smartinvoke.cn/ 
*  邮件:pzxiaoxiao130130@gmail.com
*  QQ：90636900*  联系到作者^_^ 
*******************************************************************************/ 
package cn.smartinvoke;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.internal.win32.OS;
import org.eclipse.swt.ole.win32.OleEvent;
import org.eclipse.swt.ole.win32.OleListener;
import org.eclipse.swt.ole.win32.Variant;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

import cn.smartinvoke.gui.Executor;
import cn.smartinvoke.gui.Flash;
import cn.smartinvoke.gui.ObjectPool;
import cn.smartinvoke.gui.OleDispatch;

public class FlashContainer extends Flash {
	// flashCall事件
	final static int EVENT_FLASH_CALL = 0x000000c5;
	final static int EVENT_FSCOMMAND = 0x00000096;

	final static String CMD_FINISH = "cmd_finish";
	final static String CMD_DISPOSE = "cmd_dispose", CMD_BOUNDS = "3";
	
	private boolean isFlashLoaded = false;
	private Executor executor = null;
	public ILoadCompleteListener completeListener = null;
    
	public FlashContainer(Composite parent) {
		super(parent, SWT.NO_BACKGROUND, null);
		
		
		this.executor = new Executor(this.getAppId());
		//
		oleControlSite.addEventListener(EVENT_FSCOMMAND, new OleListener() {
			public void handleEvent(OleEvent event) {
				Variant command = event.arguments[0];
				Variant args = event.arguments[1];
				String val = args.getString();
				if (command != null && val != null) {
					String cmd = command.getString();
					if (cmd != null) {
						if (cmd.equals(CMD_FINISH)) {
							if (val.equals("1")) {
								isFlashLoaded = true;
								//将此应用程序ID传递给flash
								String pack="<invoke name=\"setId\" returntype=\"xml\"><arguments><string>" +
								        FlashContainer.this.getAppId()+
										"</string></arguments></invoke>";
								FlashContainer.this.asyncCallFunction(pack);
								
								if (completeListener != null) {
									completeListener.run();
								}
								notifyAllCaller();
							}
						} else if (cmd.equals(CMD_DISPOSE)) {
							executor.dispose(val);
						} else if (cmd.equals(CMD_BOUNDS)) {
							// String[] bounds=val.split(",");
							// FlexAppWin.instance.setBounds(Float.valueOf(bounds[0]),Float.valueOf(bounds[1]),
							// Float.valueOf(bounds[2]),
							// Float.valueOf(bounds[3]));
						}
					}
				}
			}
		});
		// flash call
		oleControlSite.addEventListener(EVENT_FLASH_CALL, new OleListener() {
			public void handleEvent(OleEvent event) {
				Variant command = event.arguments[0];
				if (command != null) {
					String reqPack = command.getString();
					
					if (reqPack != null) {
						StringBuilder resPack = new StringBuilder("<string>");
						resPack.append(executor.execute(reqPack))
						.append("</string>");
						setReturnValue(resPack.toString());
					}
				}
			}
		});
	}

	private synchronized void notifyAllCaller() {
		this.notifyAll();
	}

	/**
	 * 调用flash的指定函数，挂起调用线程直到返回 asyncCallFunction
	 * 
	 * @param info
	 */
	public synchronized String asyncCallFunction(final String info) {
		
		if (Display.getCurrent() == null) {
			final String[] ret = new String[1];
			this.getDisplay().asyncExec(new Runnable() {
				public void run() {
					ret[0] = directCall(info);
				}
			});
			// 挂起调用线程
			while (ret[0] == null) {
				try {
					this.wait(2);
				} catch (InterruptedException e) {
				}
			}
			return ret[0];
		} else {
			return directCall(info);
		}
	}

	private synchronized String directCall(final String info) {
		// 等待flash的加载完毕
		if (!this.isFlashLoaded) {
			boolean isInterrupt = false;
			do {
				isInterrupt = false;
				try {
					this.wait();
				} catch (InterruptedException e) {
					isInterrupt = true;
				}
			} while (isInterrupt);
		}
		final String[] retArr = new String[1];
		Variant[] args = new Variant[1];
		args[0] = new Variant(info);
		// System.out.println("FlashContainer.callFunction()1");

		Variant ret = this.flashObject.invoke(0x000000c6, args);
		if(ret==null){
			throw new RuntimeException("flex返回null可能是flex无法加载对应服务类，请在flex项目中显示定义对应服务类");
		}
		if (ret != null) {
			retArr[0] = ret.getString();
			ret.dispose();
		}
		return retArr[0].substring(8, retArr[0].length() - 9);
	}

	/**
	 * 设置返回值
	 * 
	 * @param retVal
	 */
	public void setReturnValue(String retVal) {
		Variant[] args = new Variant[1];
		args[0] = new Variant(retVal);
		int methodId = this.flashObject.getDispID("SetReturnValue");
		Variant ret = flashObject.invoke(methodId, args);
		// System.out.println(ret);
		ret.dispose();
	}

	public void disableLocalSecurity() {
		// Variant[] args = new Variant[0];
		int methodId = this.flashObject.getDispID("DisableLocalSecurity");
		Variant ret = flashObject.invoke(methodId);
		ret.dispose();
	}
    public void superDispose(){
    	super.dispose();
    }
    
    public String getAppId(){
    	return this.hashCode()+"";
    }
	public void dispose() {
		Display curDisplay=Display.getCurrent();
		if(curDisplay==null){//另外线程调用
		 this.getDisplay().asyncExec(new Runnable(){
			public void run() {
				FlashContainer.this.superDispose();
				ObjectPool.INSTANCE.clearAppPool(FlashContainer.this.getAppId());
			}
		 });
	   }else{
		   super.dispose();
		   ObjectPool.INSTANCE.clearAppPool(this.getAppId());
	   }
	   
	}
	protected void finalize(){
		this.dispose();
	}
	private OleDispatch oleDispatch;
	public OleDispatch getOleDispatch(){
        if(oleDispatch==null){
        	oleDispatch=new OleDispatch();
        }
        return this.oleDispatch;
	}
	public Integer[] getRectangle(){
		Integer[] ret=new Integer[2];
		Rectangle rect=this.getShell().getDisplay().getBounds();
		ret[0]=rect.width;
		ret[1]=rect.height;
	   
		return ret;
	}
	public static String Cur_App_Id=null;//当前获得焦点的flash
	public boolean setFocus () {
		Cur_App_Id=this.getAppId();
		System.out.println("FlashContainer.setFocus()"+this.getAppId());
		return super.setFocus();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		OS.MessageBoxW(0, "你好！\0".toCharArray(), "hello\0".toCharArray(), 0);
	}

}
