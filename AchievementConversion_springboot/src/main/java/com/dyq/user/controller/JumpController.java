package com.dyq.user.controller;

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
	@RequestMapping("test")
	public String test(){ return "/test";}
	
}
