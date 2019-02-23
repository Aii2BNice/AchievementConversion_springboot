package com.dyq;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JumpController {
	
	//首页跳转
	@RequestMapping("toabout")
	public String toabout(){ return "/about";}
	@RequestMapping("toindex")
	public String toindex(){ return "/index";}
	@RequestMapping("tocase")
	public String tocase() { return "/case"; }
	@RequestMapping("tonews")
	public String tonews() { return "/news"; }
	@RequestMapping("tostatistics")
	public String tostatistics() { return "/Statistics"; }
	
	//登录注册
	@RequestMapping("tologin")
	public String tologin(){ return "/login";}
	@RequestMapping("toregister")
	public String toregister(){ return "/register";}
	
	//登陆成功跳转页面
	@RequestMapping("toadminmessage")
	public String tomessage(){ return "/system/adminpage";}
	@RequestMapping("tocustomermessage")
	public String tocustomermessage(){ return "/customer/customerpage";}
	@RequestMapping("tousermessage")
	public String tousermessage(){ return "/user/userpage";}
	
	//用户管理跳转
	@RequestMapping("toadduser")
	public String toadduser(){ return "/system/user/adduser";}	
	@RequestMapping("toqueryuser")
	public String toqueryuser(){ return "/system/user/queryuser";}
	
	//权限管理跳转
	@RequestMapping("toquerypower")
	public String toquerypower(){ return "/system/power/querypower";}
	@RequestMapping("toaddpower")
	public String toaddpower(){ return "/system/power/addpower";}
	
	//审核跳转
	@RequestMapping("tofileupload")
	public String tofileupload(){ return "/user/fileupload";}
	@RequestMapping("tofilemanage")
	public String tofilemanage(){ return "/user/filemanage";}
	
	//日志跳转
	@RequestMapping("toquerylogging")
	public String toquerylogging(){ return "/system/logging/querylogging";}
	
	
}
