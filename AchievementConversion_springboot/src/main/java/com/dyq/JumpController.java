package com.dyq;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JumpController {
	
	@RequestMapping("toindex")
	public String toindex(){ return "/index";}
	@RequestMapping("toabout")
	public String toabout(){ return "/about";}
	@RequestMapping("tocase")
	public String tocase() { return "/case"; }
	@RequestMapping("tonews")
	public String tonews() { return "/news"; }
	@RequestMapping("tologin")
	public String tologin(){ return "/login";}
	@RequestMapping("toregister")
	public String toregister(){ return "/register";}
	@RequestMapping("toadminmessage")
	public String tomessage(){ return "/system/adminpage";}
	@RequestMapping("tocustomermessage")
	public String tocustomermessage(){ return "/customer/customerpage";}
	@RequestMapping("tousermessage")
	public String tousermessage(){ return "/user/userpage";}
	@RequestMapping("toadduser")
	public String toadduser(){ return "/system/user/adduser";}	
	@RequestMapping("toqueryuser")
	public String toqueryuser(){ return "/system/user/queryuser";}
	@RequestMapping("toquerypower")
	public String toquerypower(){ return "/system/power/querypower";}
	@RequestMapping("toexamfile")
	public String toexamfile(){ return "/system/file/queryfile";}
	@RequestMapping("toquerylogging")
	public String toquerylogging(){ return "/system/logging/querylogging";}
	
	
	@RequestMapping("test")
	public String test(){ return "/test";}
	
	
}
