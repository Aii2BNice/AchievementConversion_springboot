package com.dyq.entity;

public class FileType {
	
	private Integer fileTypeId;
	private String fileTypeName;
	public FileType() {
		super();
	}
	public FileType(Integer fileTypeId, String fileTypeName) {
		super();
		this.fileTypeId = fileTypeId;
		this.fileTypeName = fileTypeName;
	}
	public Integer getFileTypeId() {
		return fileTypeId;
	}
	public void setFileTypeId(Integer fileTypeId) {
		this.fileTypeId = fileTypeId;
	}
	public String getFileTypeName() {
		return fileTypeName;
	}
	public void setFileTypeName(String fileTypeName) {
		this.fileTypeName = fileTypeName;
	}
	@Override
	public String toString() {
		return "FileType [fileTypeId=" + fileTypeId + ", fileTypeName=" + fileTypeName + "]";
	}
	
}
