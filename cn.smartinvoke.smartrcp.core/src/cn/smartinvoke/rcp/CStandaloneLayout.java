package cn.smartinvoke.rcp;

public class CStandaloneLayout implements ICFolderLayout{
	public boolean showTitle = true;
	
	public int relationship;
	public double ratio;
	public boolean closeable = true;
	public boolean moveable = true;
	public ICFolderLayout refLayout = null;
	/**
	 * 该layout中显示的模块
	 */
	public CLayoutBasicInfo module=null;
}
