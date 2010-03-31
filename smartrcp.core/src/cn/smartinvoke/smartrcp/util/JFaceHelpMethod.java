package cn.smartinvoke.smartrcp.util;

import java.io.File;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Display;

import cn.smartinvoke.smartrcp.core.SmartRCPBuilder;

public class JFaceHelpMethod {

	private JFaceHelpMethod() {
      
	}
	/**
	 * 检查path所在的文件的存在性，并且提示用户是否覆盖
	 * @return true为覆盖，false为不覆盖
	 */
	public static boolean checkOverWrite(String path){
		boolean ret = true;
		File file=new File(path);
		if (file.exists()){// 文件存在，判断是否覆盖
			String tok="";
			if(file.isDirectory()){
				tok="夹";
			}
			final String msg = "文件"+tok + path + "已存在，是否覆盖？";
			if (Display.getCurrent() == null) {
				final boolean[] res = new boolean[]{false};
				final boolean[] isRet = new boolean[]{false};
				SmartRCPBuilder.Main_Shell.getDisplay().asyncExec(
						new Runnable() {
							public void run() {
								boolean ret = MessageDialog.openQuestion(
										SmartRCPBuilder.Main_Shell, "选择", msg);
								res[0] = ret;
								isRet[0] = true;// 返回
							}
						});
				// 循环等等用户的返回
				while (true) {
					try {
						Thread.sleep(500);
					} catch (Exception e) {
					}
					;
					if (isRet[0]) {
						ret = res[0];
						break;
					}
				}
			} else {
				ret = MessageDialog.openQuestion(SmartRCPBuilder.Main_Shell,
						"选择", msg);
			}
		}
		return ret;
	}
	public static ImageDescriptor getImageDescriptor(String imgUrl) {
		//TODO 专业用一文件夹做图像注册表
		return null;//Activator.getImageDescriptor(imgUrl);
	}
	public static void showError(final String msg){
		if(Display.getCurrent()==null){
			SmartRCPBuilder.Main_Shell.getDisplay().asyncExec(new Runnable() {
				
				public void run() {
					MessageDialog.openError(SmartRCPBuilder.Main_Shell, "错误", msg);
				}
			});
		}else{
			MessageDialog.openError(SmartRCPBuilder.Main_Shell, "错误", msg);
		}
	}
	public static void showInfo(final String msg){
		if(Display.getCurrent()==null){
			SmartRCPBuilder.Main_Shell.getDisplay().asyncExec(new Runnable() {
				
				public void run() {
					MessageDialog.openInformation(SmartRCPBuilder.Main_Shell, "错误", msg);
				}
			});
		}else{
			MessageDialog.openInformation(SmartRCPBuilder.Main_Shell, "错误", msg);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
