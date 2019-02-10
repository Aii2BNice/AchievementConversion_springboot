package com.dyq.user.controller;

import java.util.List;

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
	
	@RequestMapping("queryAllLogin")
	public List<Login> queryAllLogin(@RequestBody Login login) {
		return userService.queryAllLogin(login);
	}
	
	@RequestMapping("verLoginName")
	public String verLoginName(@RequestBody Login login) {
		String msg = "";
		Login name = userService.queryLoginByName(login.getLoginName());
		if(name!=null) {
			msg = "用户名已存在";
		}
		return msg;
	}
	
	@RequestMapping("cancellation")
	public String cancellation(@RequestBody Login login) {
		String msg = "";
		int count = 0;
		try { count = userService.deleteLogin(login.getLoginId()); }
		catch(Exception e) { count = 0;}
		finally {
			if(count>0) { msg = "用户注销成功"; }
			else { msg = "用户注销失败,请重试"; }
		}
		return msg;
	}
	
}
