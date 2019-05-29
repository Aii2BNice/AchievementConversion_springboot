package com.dyq.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dyq.base.BaseController;
import com.dyq.entity.Login;
import com.dyq.service.UserService;

@Controller
public class ShiroTestController extends BaseController{

	@SuppressWarnings("unused")
	@Autowired
	private UserService userService;

	private static final Logger log = LoggerFactory.getLogger(ShiroTestController.class);
	
	@RequestMapping("shiroLogin")
	public String shiroLogin(Login login, HttpServletRequest req) {
		
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(login.getLoginName(), login.getPass());
		try {
			subject.login(token);
		}catch(UnknownAccountException e) {
			req.setAttribute("msg", "用户不存在");
		}catch(IncorrectCredentialsException e){
			req.setAttribute("msg","密码错误");
		}
		req.getSession().setAttribute("user", super.getLoginInfo());
		log.info(">>>登录");
		return "/system/adminpage";
	}
	
}
