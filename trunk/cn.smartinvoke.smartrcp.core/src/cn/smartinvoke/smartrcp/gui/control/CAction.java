package cn.smartinvoke.smartrcp.gui.control;


import cn.smartinvoke.ServiceObject;

public class CAction extends ServiceObject{
    
    //private CActionImpl actionImpl=null;
  //  private FlashContainer container;
	public CAction() {
		
	}
	public CAction(String text) {
		this.setText(text);
	}
	public CAction(String text, String imgUrl) {
		this(text);
	    this.setImageUrl(imageUrl);
	}
	public CAction(String text, String imgUrl,String toolTip) {
		this(text,imgUrl);
		this.setToolTip(toolTip);
	}
//------------bean
//	private String runFunId=null;//
//	public String getRunFunId() {
//		return runFunId;
//	}
//	public void setRunFunId(String runFunId) {
//		this.runFunId = runFunId;
//	}
	private String text=null,imageUrl,toolTip,hoverImageUrl,DisableImageUrl;
	private int type=-1;
	private String actionId=null;
	private boolean checked=false;
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getToolTip() {
		return toolTip;
	}
	public void setToolTip(String toolTip) {
		this.toolTip = toolTip;
	}
	public String getHoverImageUrl() {
		return hoverImageUrl;
	}
	public void setHoverImageUrl(String hoverImageUrl) {
		this.hoverImageUrl = hoverImageUrl;
	}
	public String getDisableImageUrl() {
		return DisableImageUrl;
	}
	public void setDisableImageUrl(String disableImageUrl) {
		DisableImageUrl = disableImageUrl;
	}
	//-----------eclipse
    //当用户点击按钮后会调用此方法
    public void run(){
    	//调用flex的action监听函数
    	/*if(this.container==null){
    		FlashView flashView=FlashView.FlashViewMap.get(this.getAppId());
    		if(flashView!=null){
    		 this.container=flashView.getFlashContainer();
    		}
    	}
    	if(this.container!=null && this.runFunId!=null){
    	 RemoteObject remoteObject=new RemoteObject(this.container);
    	 remoteObject.setRemoteId(this.runFunId);
    	 remoteObject.asyncCall("apply",null);
    	}*/
    }
    private String appId=null;
    
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	
	
	public String getActionId() {
		return actionId;
	}
	public void setActionId(String actionId) {
		this.actionId = actionId;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}

}

