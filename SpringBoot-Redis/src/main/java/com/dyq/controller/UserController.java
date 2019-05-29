package com.dyq.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dyq.entity.Login;
import com.dyq.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	/**
	 * 登录
	 * @param req
	 * @param login
	 * @return
	 */
	// 登录
	@RequestMapping("login")
	public String login(HttpServletRequest req,Login login) {
		String url = "";
		if(!"".equals(login.getLoginName()) && !"".equals(login.getPass())) {
			// 查询用户信息
			Login user = userService.login(login);
			if(user!=null) {
				url = JumpController.getJumpUrl("login", user.getPowerId());
				// 将用户信息存放到Session中
				req.getSession().setAttribute("user", user);
			}else {
				url = "/login";
				req.setAttribute("msg", "用户名或密码错误");
			}
		}else {
			req.setAttribute("msg", "请输入用户名或密码");
		}
		log.debug(">>>>用户登录");
		return url;
	}
	
	/**
	 * 注册
	 * @param req
	 * @param login
	 * @return
	 */
	//  注册/添加用户
	@RequestMapping("register")
	public String register(HttpServletRequest req,Login login,Integer insUser) {
		String msg = "";
		String url = "";
		int count = 0;
		//向数据库插入数据
		try { count = userService.insertLogin(login); }
		catch(Exception e) { count = 0;}
		finally {
			if(count>0) { 
				if(insUser == 3) {
					msg = "用户添加成功";
					url = "/system/user/queryuser";
				}else {
					msg = "注册成功";
					url = "/login";
				}
			}else { 
				if(insUser == 3) {
					msg = "用户添加失败";
					url = "/system/user/adduser";
				}else {
					msg = "注册失败,请重试";
					url = "/register";
				}
			}
			req.setAttribute("msg", msg);
		}
		return url;
	}
	
	/**
	 * 转到修个人登录信息改页面
	 * @param req
	 * @param loginName
	 * @return
	 */
	@RequestMapping("toselfupdate")
	public String toselfupdate(HttpServletRequest req,String loginName){
		Login user = userService.queryLoginByName(loginName);
		req.setAttribute("user",user);
		return JumpController.getJumpUrl("update", user.getPowerId());
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
	// 删除用户
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
	// 退出登录
	@RequestMapping("toexit")
	public String toexit(HttpServletRequest req,String loginName){
		req.getSession().removeAttribute("user");
		return "/login";
	}
	
	@RequestMapping("toselfpage")
	public String toSelfPage(Integer powerId) {
		return JumpController.getJumpUrl("selfPage", powerId);
	}
	
}
