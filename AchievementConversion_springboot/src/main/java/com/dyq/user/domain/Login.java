package com.dyq.user.domain;

import com.dyq.power.domain.Power;

public class Login {
	
	private Integer loginId;
	private String loginName;
	private String pass;
	private Integer powerId;
	private Integer insUser;
	
	private Power power;

	public Integer getLoginId() {
		return loginId;
	}

	public void setLoginId(Integer loginId) {
		this.loginId = loginId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Integer getPowerId() {
		return powerId;
	}

	public void setPowerId(Integer powerId) {
		this.powerId = powerId;
	}

	public Integer getInsUser() {
		return insUser;
	}

	public void setInsUser(Integer insUser) {
		this.insUser = insUser;
	}

	public Power getPower() {
		return power;
	}

	public void setPower(Power power) {
		this.power = power;
	}

}
