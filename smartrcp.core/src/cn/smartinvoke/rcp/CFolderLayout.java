package cn.smartinvoke.rcp;

import java.util.List;

public class CFolderLayout implements ICFolderLayout{
	public int relationship;
	public double ratio;
	/**
	 * 定义viewPart的Id，该属性的作用是使该类型的视图在
	 * 该folder中打开
	 */
	public String placeholderViewPartId=null;
	/**
	 * 该folder在布局的时参照的layout
	 */
	public ICFolderLayout refLayout = null;
	/**
	 * 该layout中显示的模块集合
	 */
	private List<CLayoutBasicInfo> modules=null;
    public CFolderLayout(){
      
    }
	public List<CLayoutBasicInfo> getModules() {
		return modules;
	}
	public void setModules(List<CLayoutBasicInfo> modules) {
		this.modules = modules;
	}
    
}
