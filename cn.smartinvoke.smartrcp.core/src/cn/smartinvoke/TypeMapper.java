package cn.smartinvoke;

import java.util.LinkedList;
import java.util.List;

public class TypeMapper implements ITypeMapper{
	public static final List<String[]> typeMapper = new LinkedList<String[]>();
	private static final List<String> serverPackages = new LinkedList<String>();
    public static final TypeMapper Instance=new TypeMapper();
	public static void addServicePack(String pack) {
		if (pack != null) {
			if (!serverPackages.contains(pack)) {
				serverPackages.add(pack);
			}
		}
	}

	public static void addServiceConfig(String servicePacks) {
		if (servicePacks != null && (servicePacks.trim().length() != 0)) {
			String[] exportPacks = servicePacks.split(",");
			if (exportPacks != null) {
				for (int t = 0; t < exportPacks.length; t++) {
					String pack = exportPacks[t].trim();
					if (pack.length() != 0) {
						TypeMapper.addServicePack(pack);
					}
				}
			}
		}
	}

	public TypeMapper() {

	}

	public static String getNativeClsName(String remoteClsName) {
		// 判断serverClsName类型是否设置有映射类型
		List<String[]> mapperClsProperties = typeMapper;
		for (int i = 0; i < mapperClsProperties.size(); i++) {
			String[] clsMapperInfo = mapperClsProperties.get(i);
			String cfgRemoteCls = clsMapperInfo[0];
			int cfgRemoteClsLen = cfgRemoteCls.length();
			if (remoteClsName.equals(cfgRemoteCls)) {// 精确匹配
				return clsMapperInfo[1];
			}
			if (remoteClsName.indexOf(cfgRemoteCls) == 0) {// 匹配开头包部分
				String cfgNativeCls = clsMapperInfo[1];
				return cfgNativeCls + remoteClsName.substring(cfgRemoteClsLen);
			}
		}
		return remoteClsName;
	}

	public  boolean isServerObject(Object nativeValue) {
		boolean ret = false;
		if (nativeValue != null) {
			if (nativeValue instanceof IServerObject) {// 如果继承自IServerObject接口则返回true
				ret = true;
			}
			// IF(NATIVEVALUE.GETCLASS().GETNAME().INDEXOF("ORG.ECLIPSE.SWT")==0){
			// RETURN TRUE;
			// }
			List<String> serverPackNames = serverPackages;
			String clsName = nativeValue.getClass().getName();
			int packSp = clsName.lastIndexOf('.');
			if (packSp == -1) {// 没有包
				return false;
			}
			String nativePackName = clsName.substring(0, packSp);
			for (int i = 0; i < serverPackNames.size(); i++) {
				String serverPackName = serverPackNames.get(i);
				if (nativePackName.equals(serverPackName)) {// 匹配
					return true;
				}
			}
		}
		return ret;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * TypeFactory typeFactory=TypeFactory.getInstance();
		 * typeFactory.addMapperProperties("org.pengzhen.User",
		 * "com.microsoft.User"); typeFactory.addMapperProperties("org.jcs",
		 * "org.jfx"); typeFactory.addMapperProperties("org.pengzhen.util.io",
		 * "org.pengzhen.util.jcs.io");
		 * 
		 * typeFactory.addServerCls("org.pengzhen");
		 * 
		 * System.out.println(typeFactory.typeMapper.getNativeClsName("org.pengzhen.util.io.DirectoryChangeEvent"));
		 * System.out.println(typeFactory.typeMapper.getNativeClsName("org.jcs.Qq"));
		 * System.out.println(typeFactory.typeMapper.isServerObject(typeFactory));
		 */
	}

}
