
package cn.smartinvoke;

public interface FlashEventListener {
	
	void onReadyStateChange(int newState);

	void onProgress(int percentDone);
	void onFSCommand(String command, String args);
	void onFlashCall(String command);
}
