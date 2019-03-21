package com.dyq.finance.domain;

import java.util.Date;

import com.dyq.file.domain.FileInfo;
import com.dyq.user.domain.Login;

public class Finance {

	private Integer financeId;
	private Integer price;
	private Integer userId; 
	private Integer fileId;
	private Date registerTime;
	
	private Login login;
	private FileInfo file;
	
	public Integer getFinanceId() {
		return financeId;
	}
	public void setFinanceId(Integer financeId) {
		this.financeId = financeId;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getFileId() {
		return fileId;
	}
	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}
	public Date getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	public FileInfo getFile() {
		return file;
	}
	public void setFile(FileInfo file) {
		this.file = file;
	}
	@Override
	public String toString() {
		return "Finance [financeId=" + financeId + ", price=" + price + ", userId=" + userId + ", fileId=" + fileId
				+ ", registerTime=" + registerTime + ", login=" + login + ", file=" + file + "]";
	}

}
