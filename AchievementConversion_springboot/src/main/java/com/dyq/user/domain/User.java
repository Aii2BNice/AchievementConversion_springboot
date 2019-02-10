package com.dyq.user.domain;

import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer UserId;
	private String LoginName;
	private String realName;
	private Integer Sex;
	private Long postCode;
	private String Email;
	private Long Tel;
	private Integer sId;
	
	public User() {
		super();
	}

	public User(Integer userId, String loginName, String realName, Integer sex, Long postCode, String email, Long tel,
			Integer sId) {
		super();
		UserId = userId;
		LoginName = loginName;
		this.realName = realName;
		Sex = sex;
		this.postCode = postCode;
		Email = email;
		Tel = tel;
		this.sId = sId;
	}

	public Integer getUserId() {
		return UserId;
	}

	public void setUserId(Integer userId) {
		UserId = userId;
	}

	public String getLoginName() {
		return LoginName;
	}

	public void setLoginName(String loginName) {
		LoginName = loginName;
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

	@Override
	public String toString() {
		return "User [UserId=" + UserId + ", LoginName=" + LoginName + ", realName=" + realName + ", Sex=" + Sex
				+ ", postCode=" + postCode + ", Email=" + Email + ", Tel=" + Tel + ", sId=" + sId + "]";
	}
}
