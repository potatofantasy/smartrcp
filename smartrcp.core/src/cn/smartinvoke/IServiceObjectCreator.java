package cn.smartinvoke;

public interface IServiceObjectCreator {
   public Class getClass(String clsName)throws ClassNotFoundException;
}
