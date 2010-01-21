package cn.smartinvoke;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Externalizable;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import cn.smartinvoke.exception.InvokeException;
import cn.smartinvoke.gui.ObjectPool;

import flex.messaging.MessageException;
import flex.messaging.io.AbstractProxy;
import flex.messaging.io.ClassAliasRegistry;
import flex.messaging.io.PropertyProxy;
import flex.messaging.io.PropertyProxyRegistry;
import flex.messaging.io.SerializationContext;
import flex.messaging.io.amf.ASObject;
import flex.messaging.io.amf.Amf3Input;
import flex.messaging.io.amf.Amf3Output;
import flex.messaging.io.amf.TraitsInfo;
import flex.messaging.util.ClassUtil;

public class ProtocolBuilder {
	private static SerializationContext serializationContext = new SerializationContext();
    static{
    	serializationContext.supportDatesByReference=false;
    	//serializationContext.
    }
	public ProtocolBuilder() {
         
	}

	public static Object getObject(String pack,String appId) {
		Object ret = null;
		if (pack != null) {
			ByteArrayInputStream in = new ByteArrayInputStream(Base64
					.decode(pack.getBytes()));
			MyAmf3Input amfIn = new MyAmf3Input(serializationContext,appId);
			amfIn.setInputStream(in);
			try {
				ret = amfIn.readObject();
				if (ret instanceof InvokeException) {
					throw (InvokeException) ret;
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				throw new InvokeException(e.getMessage());
			}
		}
		return ret;
	}

	public static String getProtocolStr(Object obj,String appId) {
		String ret = null;
		MyAmf3Output amfOut = new MyAmf3Output(serializationContext,appId);
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		try {
			amfOut.setOutputStream(outStream);
			amfOut.writeObject(obj);
			outStream.flush();
			ret = new String(Base64.encode(outStream.toByteArray()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	public static void main(String[] args) throws ClassNotFoundException {
		
	}
}

class MyAmf3Input extends Amf3Input {
    private String appId;
	public MyAmf3Input(SerializationContext context,String appId) {
		super(context);
        this.appId=appId;
	}
	protected Object readScriptObject() throws ClassNotFoundException,
			IOException {
		int ref = readUInt29();

		if ((ref & 1) == 0) {
			return getObjectReference(ref >> 1);
		} else {
			TraitsInfo ti = readTraits(ref);
			String className = ti.getClassName();
			//System.out.println(">"+className);
			boolean isRemoteObj=false;//flex传递过来的是否为代理对象
			//判断当前传递是否为代理对象
			//只要属性当中有appId与remoteId这两个就认为是代理对象
            List props=ti.getProperties();
            int appIdPropIndex=-1,remoteIdPropIndex=-1;//属性索引
            String appId=null,remoteId=null;
            if(props!=null){//
        	    for(int i=0;i<props.size();i++){
        	    	String prop=props.get(i).toString();
        	    	if(prop.equals("appId")){
        	    		appIdPropIndex=i;
        	    		if(remoteIdPropIndex!=-1){
        	    			break;
        	    		}
        	    	}
        	    	if(prop.equals("remoteId")){
        	    		remoteIdPropIndex=i;
        	    		if(appIdPropIndex!=-1){
        	    			break;
        	    		}
        	    	}
        	    }
            }
            if(appIdPropIndex!=-1 && remoteIdPropIndex!=-1){//两个属性都具备
            	isRemoteObj=true;
            	int len = ti.getProperties().size();
            	for (int i = 0; i < len; i++) {
					//String propName = (String) ti.getProperty(i);
					Object value = readObject();
					if(i==appIdPropIndex){
						 if(value!=null){
						   appId=value.toString();
						 }
					 }
					 if(i==remoteIdPropIndex){
						  if(value!=null){
							  remoteId=value.toString();
						  }
					 }
				}
            	Object obj= ObjectPool.INSTANCE.getObject(appId, remoteId);
            	return obj;
            }
			//System.out.println(">>" + className);
			boolean externalizable = ti.isExternalizable();
			Object object;
			PropertyProxy proxy = null;
			// Check for any registered class aliases
			String aliasedClass = ClassAliasRegistry.getRegistry()
					.getClassName(className);
			if (aliasedClass != null)
				className = aliasedClass;

			if (className == null || className.length() == 0) {
				object = new ASObject();
			} else if (className.startsWith(">")) // Handle [RemoteClass] (no
													// server alias)
			{
				object = new ASObject();
				((ASObject) object).setType(className);
			} else if (context.instantiateTypes
					|| className.startsWith("flex.")) {
				Class desiredClass = AbstractProxy
						.getClassFromClassName(className);

				proxy = PropertyProxyRegistry.getRegistry()
						.getProxyAndRegister(desiredClass);

				if (proxy == null)
					object = ClassUtil
							.createDefaultInstance(desiredClass, null);
				else
					object = proxy.createInstance(className);
			} else {
				// Just return type info with an ASObject...
				object = new ASObject();
				((ASObject) object).setType(className);
			}

			if (proxy == null)
				proxy = PropertyProxyRegistry.getProxyAndRegister(object);

			// Remember our instance in the object table
			int objectId = objectTable.size();
			objectTable.add(object);

			if (externalizable) {
				readExternalizable(className, object);
			} else {
				if (isDebug) {
					trace.startAMFObject(className, objectTable.size() - 1);
				}

				int len = ti.getProperties().size();

				for (int i = 0; i < len; i++) {
					String propName = (String) ti.getProperty(i);

					if (isDebug)
						trace.namedElement(propName);
                    
					Object value = readObject();
					if(isRemoteObj){
					  if(i==appIdPropIndex){
						  if(value!=null){
						   appId=value.toString();
						  }
					  }
					  if(i==remoteIdPropIndex){
						  if(value!=null){
							  remoteId=value.toString();
						  }
					  }
					}else{
					  proxy.setValue(object, propName, value);
					}
				}

				if (ti.isDynamic()) {
					for (;;) {
						String name = readString();
						if (name == null || name.length() == 0)
							break;

						if (isDebug)
							trace.namedElement(name);

						Object value = readObject();
						proxy.setValue(object, name, value);
					}
				}
			}

			if (isDebug)
				trace.endAMFObject();

			// This lets the BeanProxy substitute a new instance into the
			// BeanProxy
			// at the end of the serialization. You might for example create a
			// Map, store up
			// the properties, then construct the instance based on that. Note
			// that this does
			// not support recursive references to the parent object however.
			Object newObj = proxy.instanceComplete(object);

			// TODO: It is possible we gave out references to the
			// temporary object. it would be possible to warn users about
			// that problem by tracking if we read any references to this object
			// in the readObject call above.
			if (newObj != object) {
				objectTable.set(objectId, newObj);
				object = newObj;
			}
            if(isRemoteObj){
            	return ObjectPool.INSTANCE.getObject(appId, remoteId);
            }
			return object;
		}
	}
}

class MyAmf3Output extends Amf3Output {
    private String appId=null;
	public MyAmf3Output(SerializationContext context,String appId) {
		super(context);
		this.appId=appId;
	}

	protected void writeCustomObject(Object o) throws IOException {
		PropertyProxy proxy = null;

		if (o instanceof PropertyProxy) {
			proxy = (PropertyProxy) o;
			o = proxy.getDefaultInstance();

			// The proxy may wrap a null default instance, if so, short circuit
			// here.
			if (o == null) {
				writeAMFNull();
				return;
			}

			// HACK: Short circuit and unwrap if PropertyProxy is wrapping an
			// Array
			// or Collection or Map with legacyMap as true since we don't yet
			// have
			// the ability to proxy multiple AMF types. We write an AMF Array
			// directly
			// instead of an AMF Object...
			else if (o instanceof Collection) {
				if (context.legacyCollection)
					writeCollection((Collection) o, proxy.getDescriptor());
				else
					writeArrayCollection((Collection) o, proxy.getDescriptor());
				return;
			} else if (o.getClass().isArray()) {
				writeObjectArray((Object[]) o, proxy.getDescriptor());
				return;
			} else if (context.legacyMap && o instanceof Map
					&& !(o instanceof ASObject)) {
				writeMapAsECMAArray((Map) o);
				return;
			}
		}

		out.write(kObjectType);

		if (!byReference(o)) {
			if (proxy == null) {
				proxy = PropertyProxyRegistry.getProxyAndRegister(o);
			}
			
			writePropertyProxy(proxy, o);
		}
	}
	
	protected void writePropertyProxy(PropertyProxy proxy, Object instance) throws IOException
    {
        if(TypeMapper.isServerObject(instance)){//如果是服务对象，则写入服务对象
        	this.writeServiceObject(instance);
        	return;
        }
		/*
         * At this point we substitute the instance we want to serialize.
         */
        Object newInst = proxy.getInstanceToSerialize(instance);
        if (newInst != instance)
        {
            // We can't use writeAMFNull here I think since we already added this object
            // to the object table on the server side.  The player won't have any way
            // of knowing we have this reference mapped to null.
            if (newInst == null)
                throw new MessageException("PropertyProxy.getInstanceToSerialize class: " + proxy.getClass() + " returned null for instance class: " + instance.getClass().getName());

            // Grab a new proxy if necessary for the new instance
            proxy = PropertyProxyRegistry.getProxyAndRegister(newInst);
            instance = newInst;
        }
        
        List propertyNames = null;
        boolean externalizable = proxy.isExternalizable(instance);

        if (!externalizable)
            propertyNames = proxy.getPropertyNames(instance);

        TraitsInfo ti = new TraitsInfo(proxy.getAlias(instance), proxy.isDynamic(), externalizable, propertyNames);
        writeObjectTraits(ti);

        if (externalizable)
        {
            // Call user defined serialization
            ((Externalizable)instance).writeExternal(this);
        }
        else if (propertyNames != null)
        {
            Iterator it = propertyNames.iterator();
            while (it.hasNext())
            {
                String propName = (String)it.next();
                Object value = null;
                value = proxy.getValue(instance, propName);
                writeObjectProperty(propName, value);
            }
        }

        writeObjectEnd();
    }
	//static ObjectPool objectPool=
	private void writeServiceObject(Object instance)throws IOException{
		List propertyNames =new LinkedList();
		propertyNames.add("remoteId");
		Class cls=instance.getClass();
		String clsName=cls.getName();
        TraitsInfo ti = new TraitsInfo(clsName, false, false, propertyNames);
        writeObjectTraits(ti);

        Iterator it = propertyNames.iterator();
        while (it.hasNext()){
             String propName = (String)it.next();
             Object value = null;
             value =ObjectPool.INSTANCE.getObjectkey(instance);
             writeObjectProperty(propName, value);
        }
        writeObjectEnd();
	}
}