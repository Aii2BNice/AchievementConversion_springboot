package com.dyq.user.controller;

import java.util.List;

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
	
	/**
	 * 登录
	 * @param req
	 * @param login
	 * @return
	 */
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
	
	/**
	 * 注册
	 * @param req
	 * @param login
	 * @return
	 */
	@RequestMapping("register")
	public String register(HttpServletRequest req,Login login) {
		String msg = "";
		String url = "";
		int count = 0;
		try { count = userService.insertLogin(login); }
		catch(Exception e) { count = 0;}
		finally {
			if(count>0) { 
				System.out.println(login);
				if(login.getPowerId()!=1) {
					url = "/system/user/queryuser";
					msg = "用户添加成功";
				}else {
					url = "/login";
				}
			}
			else { 
				if(login.getPowerId()!=null) {
					url = "/system/user/queryuser";
					msg = "用户添加失败";
				}else {
					msg = "用户注册失败,请重试";
					url = "/register";
				}
				req.setAttribute("msg", msg);
			}
		}
		return url;
	}
	
	/**
	 * 转到修改页面
	 * @param req
	 * @param loginName
	 * @return
	 */
	@RequestMapping("tomodifylogin")
	public String tomodifylogin(HttpServletRequest req,String loginName){
		req.setAttribute("user",userService.queryLoginByName(loginName));
		return "/modifylogin";
	}
	
	/**
	 * 转到修个人登录信息改页面
	 * @param req
	 * @param loginName
	 * @return
	 */
	@RequestMapping("toselfupdate")
	public String toselfupdate(HttpServletRequest req,String loginName){
		String url = "";
		Login user = userService.queryLoginByName(loginName);
		switch(user.getPowerId()) {
		case 1:url = "/user/updateuser";break;
		case 2:url = "/customer/updatecustomer";break;
		case 3:url = "/system/admindetail";break;
		}
		req.setAttribute("user",user);
		return url;
	}
	
	/**
	 * 查询所有登录用户
	 * @param login
	 * @return
	 */
	@RequestMapping("queryAllLogin")
	public String queryAllLogin(HttpServletRequest req,Login login) {
		List<Login> logins = userService.queryAllLogin(login);
		req.setAttribute("logins", logins);
		return "/system/user/queryuser";
	}
	
	/**
	 * 跳转到管理员修改个人信息页面
	 * @param req
	 * @param loginName
	 * @return
	 */
	@RequestMapping("toupdate")
	public String toupdate(HttpServletRequest req,String loginName) {
		req.setAttribute("user",userService.queryLoginByName(loginName));
		return "/system/user/updateuser";
	}
	
	/**
	 * 删除登录用户
	 * @param login
	 * @return
	 */
	@RequestMapping("dodelete")
	public String dodelete(HttpServletRequest req,Integer loginId) {
		int count = 0;
		try { count = userService.deleteLogin(loginId); }
		catch(Exception e) { count = 0;}
		finally {
			if(count>0) { 
				req.setAttribute("msg", "用户删除成功");
			}
			else {
				req.setAttribute("msg", "用户删除失败");
			}
		}
		return "/system/user/queryuser";
	}
	
	/**
	 * 退出登录
	 * @param req
	 * @param loginName
	 * @return
	 */
	@RequestMapping("toexit")
	public String toexit(HttpServletRequest req,String loginName){
		req.getSession().removeAttribute("user");
		return "/login";
	}
	
	@RequestMapping("toselfpage")
	public String toSelfPage(Integer powerId) {
		String url = "";
		switch(powerId) {
		case 1:url = "/user/userpage";break;
		case 2:url = "/customer/customerpage";break;
		case 3:url = "/system/adminpage";break;
		}
		return url;
	}
	
}
