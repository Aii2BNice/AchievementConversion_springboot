package com.dyq.user.domain;

import java.util.Date;

public class LoginGroupByTime {
	
	private Date loginTime;
	private Integer amount;
	
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
}
