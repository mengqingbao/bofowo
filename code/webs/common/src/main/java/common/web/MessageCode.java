package common.web;

import java.io.Serializable;

@SuppressWarnings("serial")
public class MessageCode implements Serializable {
	private int status;
	private String describe;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
}
