package com.dyq.base;

import org.apache.shiro.SecurityUtils;

import com.dyq.entity.Login;

public class BaseController {

	/**
	 * 获取用户信息
	 * @return
	 */
	public Login getLoginInfo() {
		return (Login) SecurityUtils.getSubject().getPrincipal();
	}
	
}
