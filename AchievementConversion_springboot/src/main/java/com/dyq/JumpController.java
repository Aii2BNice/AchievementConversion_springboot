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
	
	//文件上传跳转
	@RequestMapping("tofileupload")
	public String tofileupload(){ return "/user/fileupload";}
	
	//审核跳转
	@RequestMapping("tofilemanage")
	public String tofilemanage(){ return "/user/filemanage";}
	
	// 打印跳转
	@RequestMapping("toPrint")
	public String toPrint(){ return "/print";}
	
	// 缴费跳转
	@RequestMapping("toInsFinance")
	public String toInsFinance(){ return "/system/finance/addfinance";}
	
	//收费统计跳转
	@RequestMapping("tofinanceStatic")
	public String tofinanceStatic() {return "/system/finance/financeStati";}
	
	//根据不同权限跳转不同页面
	public static String getJumpUrl(String kbn,Integer powerId) {
		String url = "";
		if("login".equals(kbn)) {
			switch (powerId) {
			case 1:url = "/user/userpage";break;
			case 2:url = "/customer/customerpage";break;
			case 3:url = "/system/adminpage";break;
			}
		}
		if("update".equals(kbn)) {
			switch (powerId) {
			case 1:url = "/user/updateuser";break;
			case 2:url = "/customer/updatecustomer";break;
			case 3:url = "/system/admindetail";break;
			}
		}
		if("selfPage".equals(kbn)) {
			switch(powerId) {
			case 1:url = "/user/userpage";break;
			case 2:url = "/customer/customerpage";break;
			case 3:url = "/system/adminpage";break;
			}
		}
		if("queryFile".equals(kbn)) {
			switch(powerId) {
			case 1:url = "/user/queryfile";break;
			case 2:url = "/customer/queryfile";break;
			case 3:url = "/system/file/queryfile";break;
			}
		}
		if("fileDetail".equals(kbn)) {
			switch(powerId) {
			case 1:url = "/user/filedetail";break;
			case 2:url = "/customer/filedetail";break;
			case 3:url = "/system/file/filedetail";break;
			}
		}
		if("examFile".equals(kbn)) {
			switch(powerId) {
			case 1:url = "/user/queryfile";break;
			case 2:url = "/customer/queryfile";break;
			case 3:url = "/system/file/queryfile";break;
			}
		}
		if("queryContract".equals(kbn)) {
			switch(powerId) {
			case 1:url = "/user/querycontract";break;
			case 2:url = "/customer/querycontract";break;
			case 3:url = "/system/contract/querycontract";break;
			}
		}
		return url;
	}
	
	public static String getFileUploadUrl(String msg,Integer fileId) {
		String url = "";
		if("文件上传成功".equals(msg)) {
			url = "<h2>"+ msg + "</h2><a href='toInsFinance?fileId="+ fileId +"'>缴费</a>";
		}
		if("文件已存在".equals(msg)) {
			url = "<h2>"+ msg + "</h2><a href='javascript:history.back(-1);'>返回</a>";
		}
		return url;
	}
	
}
