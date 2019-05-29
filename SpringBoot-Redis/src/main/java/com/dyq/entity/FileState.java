package com.dyq.entity;

public class FileState {
	
	private Integer fileStateId;
	private String fileStateName;
	public FileState() {
		super();
	}
	public FileState(Integer fileStateId, String fileStateName) {
		super();
		this.fileStateId = fileStateId;
		this.fileStateName = fileStateName;
	}
	public Integer getFileStateId() {
		return fileStateId;
	}
	public void setFileStateId(Integer fileStateId) {
		this.fileStateId = fileStateId;
	}
	public String getFileStateName() {
		return fileStateName;
	}
	public void setFileStateName(String fileStateName) {
		this.fileStateName = fileStateName;
	}
	@Override
	public String toString() {
		return "FileState [fileStateId=" + fileStateId + ", fileStateName=" + fileStateName + "]";
	}
	
}
