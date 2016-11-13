package common.util;

import java.util.Date;

public class PdfFile {
	
	private String fileName;
	private String userName;
	private Date createDate;
	private String fileHtml;
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getFileHtml() {
		return fileHtml;
	}
	public void setFileHtml(String fileHtml) {
		this.fileHtml = fileHtml;
	}
	
	

}
