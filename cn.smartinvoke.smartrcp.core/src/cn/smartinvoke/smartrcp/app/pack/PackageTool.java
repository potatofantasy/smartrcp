package cn.smartinvoke.smartrcp.app.pack;

import cn.smartinvoke.smartrcp.gui.module.CEventBean;


/**
 * Ӧ�ó�������
 * @author pengzhen
 */
public class PackageTool {

	public PackageTool() {
	   	
	}
	/**
	 * ��baseDirĿ¼�µ�smartrcp�����ļ�ѹ����savePath·��
	 * �÷���������һ���߳�ר�Ÿ����ļ��������
	 * @param baseDir  
	 * @param savePath ����λ��
	 * @param comment �ó����ע��
	 * @throws Exception 
	 */
    public void packFiles(final String baseDir,final String savePath,final String comment,final CEventBean bean){
       
    }
    /**
     * ������zip�ļ�appFile��ѹ��saveDir��ʵ�ֶԳ���İ�װ
     * ͬʱ����һ��ݷ�ʽ
     * @param appFile
     */
    public CAppInfo install(String appFile,String saveDir){
    	CAppInfo ret=new CAppInfo();
    	
    	return ret;
    }
	public static final String Key_Modules_Folder="modules";
	public static final String Key_Icons_Folder="icons";
	
	public static final String Key_Config_File="config.properties";
	public static final String Key_Property_File="property.prop";
	
}