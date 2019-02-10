package com.dyq.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dyq.user.domain.Login;
import com.dyq.user.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("login")
	public String login(HttpServletRequest req,Login login) {
		
		String url = "";
		Login user = userService.login(login);
		if(user!=null) {
			switch(user.getPowerId()) {
			case 1:url = "/user/userpage";break;
			case 2:url = "/customer/customerpage";break;
			case 3:url = "/system/adminpage";break;
			}
			req.getSession().setAttribute("user", user);
		}else {
			url = "/login";
			req.setAttribute("msg", "用户名或密码错误");
		}
		return url;
	}
	
	@RequestMapping("register")
	public String register(HttpServletRequest req,Login login) {
		String msg = "";
		String url = "";
		int count = 0;
		try { count = userService.insertLogin(login); }
		catch(Exception e) { count = 0;}
		finally {
			if(count>0) { 
				url = "/login";
			}
			else { 
				msg = "用户注册失败,请重试"; 
				req.setAttribute("msg", msg);
				url = "/register";
			}
		}
		return url;
	}
	
	@RequestMapping("tomodifylogin")
	public String tomodifylogin(HttpServletRequest req,String loginName){
		req.setAttribute("user",userService.queryLoginByName(loginName));
		return "/user/modifylogin";
	}
	
	@RequestMapping("toexit")
	public String toexit(HttpServletRequest req,String loginName){
		req.getSession().removeAttribute("user");
		return "/login";
	}
	
	@RequestMapping("modifylogin")
	public String modifylogin(HttpServletRequest req,Login login) {
		String url = "";
		int count = 0;
		System.out.println(login);
		try { 
			Login log = userService.queryLoginByName(login.getLoginName());
			login.setLoginId(log.getLoginId());
			count = userService.updateLogin(login);
		}
		catch(Exception e) { count = 0;}
		finally {
			if(count>0) { 
				url = "/user/userpage";
				req.getSession().setAttribute("user", login);
			}
			else { 
				url = "/user/modifylogin";
				req.setAttribute("msg", "用户信息修改失败，请重试");
			}
		}
		return url;
	}
	
}
