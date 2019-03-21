package com.dyq.user.domain;

import com.dyq.power.domain.Power;

public class Login {
	
	private Integer loginId;
	private String loginName;
	private String pass;
	private Integer powerId;
	
	private Power power;
	private Login login;
	
	public Login() {
		super();
	}
	public Login(Integer loginId, String loginName, String pass, Integer powerId, Power power, Login login) {
		super();
		this.loginId = loginId;
		this.loginName = loginName;
		this.pass = pass;
		this.powerId = powerId;
		this.power = power;
		this.login = login;
	}


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
	public Power getPower() {
		return power;
	}
	public void setPower(Power power) {
		this.power = power;
	}
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	@Override
	public String toString() {
		return "Login [loginId=" + loginId + ", loginName=" + loginName + ", pass=" + pass + ", powerId=" + powerId
				+ ", power=" + power + ", login=" + login + "]";
	}
	
}
