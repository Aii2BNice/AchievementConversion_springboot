package com.dyq.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dyq.user.domain.Login;
import com.dyq.user.service.UserService;

@RestController
public class UserRestController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 用户名有效性验证
	 * @param login
	 * @return
	 */
	@RequestMapping("verLoginName")
	public String verLoginName(@RequestBody Login login) {
		String msg = "";
		Login name = userService.queryLoginByName(login.getLoginName());
		if(name!=null) {
			msg = "用户名已存在";
		}
		return msg;
	}
	
	@RequestMapping("doupdateuser")
	public String doupdateuser(@RequestBody Login login) {
		String msg = "";
		int count = 0;
		try { count = userService.updateLogin(login); }
		catch(Exception e) { count = 0;}
		finally {
			if(count>0) { msg = "用户修改成功"; }
			else { msg = "用户修改失败"; }
		}
		return msg;
	}
	
}
