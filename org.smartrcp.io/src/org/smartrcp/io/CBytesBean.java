package org.smartrcp.io;
/**
 * 
 * @author pengzhen
 *
 */
public class CBytesBean {
    public int length=0;
    public byte[] bytes=null;
    
	public CBytesBean(int length, byte[] bytes) {
		super();
		this.length = length;
		this.bytes = bytes;
	}

	public CBytesBean(){
		
	}
}
