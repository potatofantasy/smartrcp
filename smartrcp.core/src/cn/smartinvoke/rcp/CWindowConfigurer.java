package cn.smartinvoke.rcp;

import org.eclipse.swt.SWT;

public class CWindowConfigurer {
    public int shellStyle=SWT.NONE;
    public int shellWidth=800;
    public int shellHeight=600;
    public String shellTitle;
    public String shellImage;
    //窗口是否最大化
    public boolean maximized=false;
    public boolean showPerspectiveBar=true;
    public boolean showMenuBar=true;
    public boolean showCoolBar=true;
    public boolean showStatusLine=true;
    
	public CWindowConfigurer() {
		
	}

}
