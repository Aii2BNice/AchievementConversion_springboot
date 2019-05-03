package com.dyq.file.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.dyq.user.domain.Login;

public class FileInfo {
	
	private Integer FileId;
	private String fileName;
	private Integer loginId;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date applyTime;
	private Integer fileStateId;
	private Integer fileTypeId;
	
	private Integer filePriceBegin;
	private Integer filePriceEnd;
	private Integer filePrice;
	
	private String fileIntroduce;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fileUploadTimeBegin;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fileUploadTimeEnd;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fileUploadTime;
	private String fileRealName;
	
	private Integer pageNum;
	
	private Login login;
	private FileState fileState;
	private FileType fileType;
	public FileInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FileInfo(Integer fileId, String fileName, Integer loginId, Date applyTime, Integer fileStateId,
			Integer fileTypeId, Integer filePriceBegin, Integer filePriceEnd, Integer filePrice, String fileIntroduce,
			Date fileUploadTimeBegin, Date fileUploadTimeEnd, Date fileUploadTime, String fileRealName, Login login,
			FileState fileState, FileType fileType) {
		super();
		FileId = fileId;
		this.fileName = fileName;
		this.loginId = loginId;
		this.applyTime = applyTime;
		this.fileStateId = fileStateId;
		this.fileTypeId = fileTypeId;
		this.filePriceBegin = filePriceBegin;
		this.filePriceEnd = filePriceEnd;
		this.filePrice = filePrice;
		this.fileIntroduce = fileIntroduce;
		this.fileUploadTimeBegin = fileUploadTimeBegin;
		this.fileUploadTimeEnd = fileUploadTimeEnd;
		this.fileUploadTime = fileUploadTime;
		this.fileRealName = fileRealName;
		this.login = login;
		this.fileState = fileState;
		this.fileType = fileType;
	}
	public Integer getFileId() {
		return FileId;
	}
	public void setFileId(Integer fileId) {
		FileId = fileId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Integer getLoginId() {
		return loginId;
	}
	public void setLoginId(Integer loginId) {
		this.loginId = loginId;
	}
	public Date getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
	public Integer getFileStateId() {
		return fileStateId;
	}
	public void setFileStateId(Integer fileStateId) {
		this.fileStateId = fileStateId;
	}
	public Integer getFileTypeId() {
		return fileTypeId;
	}
	public void setFileTypeId(Integer fileTypeId) {
		this.fileTypeId = fileTypeId;
	}
	public Integer getFilePriceBegin() {
		return filePriceBegin;
	}
	public void setFilePriceBegin(Integer filePriceBegin) {
		this.filePriceBegin = filePriceBegin;
	}
	public Integer getFilePriceEnd() {
		return filePriceEnd;
	}
	public void setFilePriceEnd(Integer filePriceEnd) {
		this.filePriceEnd = filePriceEnd;
	}
	public Integer getFilePrice() {
		return filePrice;
	}
	public void setFilePrice(Integer filePrice) {
		this.filePrice = filePrice;
	}
	public String getFileIntroduce() {
		return fileIntroduce;
	}
	public void setFileIntroduce(String fileIntroduce) {
		this.fileIntroduce = fileIntroduce;
	}
	public Date getFileUploadTimeBegin() {
		return fileUploadTimeBegin;
	}
	public void setFileUploadTimeBegin(Date fileUploadTimeBegin) {
		this.fileUploadTimeBegin = fileUploadTimeBegin;
	}
	public Date getFileUploadTimeEnd() {
		return fileUploadTimeEnd;
	}
	public void setFileUploadTimeEnd(Date fileUploadTimeEnd) {
		this.fileUploadTimeEnd = fileUploadTimeEnd;
	}
	public Date getFileUploadTime() {
		return fileUploadTime;
	}
	public void setFileUploadTime(Date fileUploadTime) {
		this.fileUploadTime = fileUploadTime;
	}
	public String getFileRealName() {
		return fileRealName;
	}
	public void setFileRealName(String fileRealName) {
		this.fileRealName = fileRealName;
	}
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	public FileState getFileState() {
		return fileState;
	}
	public void setFileState(FileState fileState) {
		this.fileState = fileState;
	}
	public FileType getFileType() {
		return fileType;
	}
	public void setFileType(FileType fileType) {
		this.fileType = fileType;
	}
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	@Override
	public String toString() {
		return "FileInfo [FileId=" + FileId + ", fileName=" + fileName + ", loginId=" + loginId + ", applyTime="
				+ applyTime + ", fileStateId=" + fileStateId + ", fileTypeId=" + fileTypeId + ", filePriceBegin="
				+ filePriceBegin + ", filePriceEnd=" + filePriceEnd + ", filePrice=" + filePrice + ", fileIntroduce="
				+ fileIntroduce + ", fileUploadTimeBegin=" + fileUploadTimeBegin + ", fileUploadTimeEnd="
				+ fileUploadTimeEnd + ", fileUploadTime=" + fileUploadTime + ", fileRealName=" + fileRealName
				+ ", login=" + login + ", fileState=" + fileState + ", fileType=" + fileType + "]";
	}
	
}
