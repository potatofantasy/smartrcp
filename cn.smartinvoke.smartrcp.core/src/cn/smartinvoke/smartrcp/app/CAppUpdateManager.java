package cn.smartinvoke.smartrcp.app;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import cn.smartinvoke.IServerObject;
import cn.smartinvoke.smartrcp.app.pack.CAppInfo;

/**
 * 应用程序更新管理器
 * 该类会自动启动一线程，轮询每个程序的更新地址，检查是否有更新，如果有则下载该更新
 * 
 * @author pengzhen
 *
 */
public class CAppUpdateManager extends Thread implements IServerObject{
    private List<CAppInfo> apps;
    //TODO 需要配置
    public static int Sleep_Mill=1000*60*20;//
	public CAppUpdateManager(List<CAppInfo> apps) {
	   	this.apps=apps;
	   	this.setName("smartrcp-update-manager");
	   	this.setDaemon(true);
	   	this.start();
	} 
	public void run(){
	    while(true){
	    	try {
	    		//循环每个程序检查是否有更新，如果有则提示用户
	    		for(int i=0;i<apps.size();i++){
	    		  CAppInfo appInfo=apps.get(i);
	    		  if(appInfo.updateUrl!=null){
	    			try{
	    		     UpdateInfoParser infoParser=this.getUpdateInfo(appInfo.updateUrl);
	    		     if(infoParser.isUpdate()){//可以更新
	    		    	
	    		     }
	    		    }catch (Exception e) {}
	    		  }
	    		}
				Thread.sleep(Sleep_Mill);
			} catch (Exception e) {}
	    }
	}
	private UpdateInfoParser getUpdateInfo(String urlStr)throws SAXException, IOException{
		UpdateInfoParser updateInfoParser=new UpdateInfoParser();
		XMLReader reader = XMLReaderFactory.createXMLReader(); 
		reader.setContentHandler(updateInfoParser);
		InputStream in=null;
		try{
		 in=getStreamFromUrl("http://localhost:8080/update.xml");
		 if(in!=null){
		  reader.parse(new InputSource(in));
		 }
		 return updateInfoParser;
		}finally{
		 if(in!=null){
			 in.close();
		 }
		}
	}
	/**
	 * @param args
	 * @throws SAXException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws SAXException, IOException {
		
		
		
	}
    static InputStream getStreamFromUrl(String urlStr) throws IOException{
    	InputStream ret=null;
    	if(urlStr!=null){
    		URL url=new URL(urlStr);
    		ret=url.openConnection().getInputStream();
    	}
    	return ret;
    }
	public void dispose() {
		
	}
}
/**
 * 对更新地址返回的XML信息进行解析的类
 * @author pengzhen
 *
 */
class UpdateInfoParser extends DefaultHandler {
	
	//当前xml节点名称
	private String curEleName=null;
	static final String Key_Update="update",Key_Version="version",
	Key_describe="describe";
	//数据
	private Map<String,StringBuilder> data=new HashMap<String, StringBuilder>(3);
	public UpdateInfoParser(){
		data.put(Key_Update, new StringBuilder());
		data.put(Key_Version, new StringBuilder());
		data.put(Key_describe, new StringBuilder());
	}
	
	@Override
	public void startDocument() throws SAXException {
		//System.out.println("UpdateInfoParser.startDocument()");
	}
	
	@Override
	public void endDocument() throws SAXException {
		//System.out.println("UpdateInfoParser.endDocument()");
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, 
			Attributes attrs) throws SAXException {	
		curEleName=localName;
	}
	
	@Override
	public void endElement(String uri,String localName,String qName)
			throws SAXException {
		
	}

	@Override
	public void characters(char[] ch, int begin, int length) 
			throws SAXException {
		StringBuilder buf=this.data.get(curEleName);
		if(buf!=null){
			buf.append(ch,begin,length);
		}
	}

	public boolean isUpdate() {
		boolean ret=false;
		String blStr=this.data.get(Key_Update).toString().trim();
		if(blStr.equals("true")){
			ret=true;
		}
		return ret;
	}

	public String getVersion() {
		return this.data.get(Key_Version).toString().trim();
	}
	
	public String getDescribe() {
		return this.data.get(Key_describe).toString().trim();
	}
}

