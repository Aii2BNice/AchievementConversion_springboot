package com.dyq.user.domain;

import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer UserId;
	private Integer LoginId;
	private String realName;
	private Integer Sex;
	private Long postCode;
	private String Email;
	private Long Tel;
	private Integer sId;
	
	private Login login;
	
	public Integer getUserId() {
		return UserId;
	}
	public void setUserId(Integer userId) {
		UserId = userId;
	}
	public Integer getLoginId() {
		return LoginId;
	}
	public void setLoginId(Integer loginId) {
		LoginId = loginId;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public Integer getSex() {
		return Sex;
	}
	public void setSex(Integer sex) {
		Sex = sex;
	}
	public Long getPostCode() {
		return postCode;
	}
	public void setPostCode(Long postCode) {
		this.postCode = postCode;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public Long getTel() {
		return Tel;
	}
	public void setTel(Long tel) {
		Tel = tel;
	}
	public Integer getsId() {
		return sId;
	}
	public void setsId(Integer sId) {
		this.sId = sId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	
}
