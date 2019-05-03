package com.dyq.contract.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.dyq.file.domain.FileInfo;
import com.dyq.user.domain.Login;

public class Contract {
	
	private Integer contractId;
	private String contractName;
	private Integer userId;
	private Integer customerId;
	private Integer fileId;
	private Integer contractPrice;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date contractTime;
	private String contractUrl;
	
	private Login user;
	private Login customer;
	private FileInfo file;
	
	public Contract() {
		super();
	}
	public Contract(Integer contractId, String contractName, Integer userId, Integer customerId, Integer fileId,
			Date contractTime, String contractUrl) {
		super();
		this.contractId = contractId;
		this.contractName = contractName;
		this.userId = userId;
		this.customerId = customerId;
		this.fileId = fileId;
		this.contractTime = contractTime;
		this.contractUrl = contractUrl;
	}
	
	public Integer getContractId() {
		return contractId;
	}
	public void setContractId(Integer contractId) {
		this.contractId = contractId;
	}
	public String getContractName() {
		return contractName;
	}
	public void setContractName(String contractName) {
		this.contractName = contractName;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Integer getFileId() {
		return fileId;
	}
	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}
	public Date getContractTime() {
		return contractTime;
	}
	public void setContractTime(Date contractTime) {
		this.contractTime = contractTime;
	}
	public String getContractUrl() {
		return contractUrl;
	}
	public void setContractUrl(String contractUrl) {
		this.contractUrl = contractUrl;
	}
	public Login getUser() {
		return user;
	}
	public void setUser(Login user) {
		this.user = user;
	}
	public Login getCustomer() {
		return customer;
	}
	public void setCustomer(Login customer) {
		this.customer = customer;
	}
	public FileInfo getFile() {
		return file;
	}
	public void setFile(FileInfo file) {
		this.file = file;
	}
	public Integer getContractPrice() {
		return contractPrice;
	}
	public void setContractPrice(Integer contractPrice) {
		this.contractPrice = contractPrice;
	}
	@Override
	public String toString() {
		return "Contract [contractId=" + contractId + ", contractName=" + contractName + ", userId=" + userId
				+ ", customerId=" + customerId + ", fileId=" + fileId + ", contractTime=" + contractTime
				+ ", contractUrl=" + contractUrl + ", user=" + user + ", customer=" + customer + ", file=" + file + "]";
	}
	
}
