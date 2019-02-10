package com.dyq.file.domain;

public class FileInfo {
	
	private Integer FileId;
	private String fileName;
	public FileInfo() {
		super();
	}
	public FileInfo(Integer fileId, String fileName) {
		super();
		FileId = fileId;
		this.fileName = fileName;
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
	@Override
	public String toString() {
		return "FileInfo [FileId=" + FileId + ", fileName=" + fileName + "]";
	}
	
}
