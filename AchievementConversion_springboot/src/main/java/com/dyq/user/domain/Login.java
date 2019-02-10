package com.dyq.user.domain;

import com.dyq.power.domain.Power;

public class Login {
	
	private Integer loginId;
	private String loginName;
	private String pass;
	private Integer powerId;
	private String image;
	
	private Power power;
	public Power getPower() {
		return power;
	}
	public void setPower(Power power) {
		this.power = power;
	}
	public Login() {
		super();
	}
	public Login(Integer loginId, String loginName, String pass, Integer powerId, String image) {
		super();
		this.loginId = loginId;
		this.loginName = loginName;
		this.pass = pass;
		this.powerId = powerId;
		this.image = image;
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Login [loginId=" + loginId + ", loginName=" + loginName + ", pass=" + pass + ", powerId=" + powerId
				+ ", image=" + image + ", power=" + power + "]";
	}
}
