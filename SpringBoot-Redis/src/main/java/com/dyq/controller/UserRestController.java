package com.dyq.controller;

import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dyq.entity.Login;
import com.dyq.entity.LoginGroupByTime;
import com.dyq.entity.User;
import com.dyq.service.UserService;

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
	
	// 修改用户信息
	@RequestMapping("doupdateuser")
	public String doupdateuser(@RequestBody Login login) {
		String msg = "";
		int count = 0;
		// 修改用户信息
		try { count = userService.updateLogin(login); }
		catch(Exception e) { count = 0;}
		finally {
			if(count>0) { msg = "用户修改成功"; }
			else { msg = "用户修改失败"; }
		}
		return msg;
	}
	
	//平台注册用户统计
	@RequestMapping("queryLoginGroupByTime")
	public Map<String, String> queryLoginGroupByTime(){
		Map<String, String> timeMap = new LinkedHashMap<>();
		List<LoginGroupByTime> queryUserGroupByTime = userService.queryUserGroupByTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for(LoginGroupByTime lgbt : queryUserGroupByTime ) {
			timeMap.put(sdf.format(lgbt.getLoginTime()).toString(), lgbt.getAmount().toString());
		}
		return timeMap;
	}
	
	@RequestMapping("getUserMsg")
	public User getUserMsg(Integer userId) {
		return userService.queryUserById(userId);
	}
	
}
