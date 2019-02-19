package com.dyq.file.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dyq.file.domain.FileInfo;
import com.dyq.file.service.FileService;
import com.dyq.user.domain.Login;
import com.dyq.user.service.UserService;

@Controller
public class FileController {

	@Autowired
	private FileService fileService;
	@Autowired
	private UserService userService;
	
	@RequestMapping("queryAllFile")
	public String queryAllFile(HttpServletRequest req,FileInfo file,String loginName){
		String url = "";
		Login user = userService.queryLoginByName(loginName);
		switch(user.getPowerId()) {
		case 1:
			url = "/user/filemanage";
			file.setLoginId(user.getLoginId());
			break;
		case 2:url = "/customer/filemanage";break;
		case 3:url = "/system/file/queryfile";break;
		}
		req.setAttribute("files", fileService.queryAllFile(file));
		return url; 
	}
	
	@RequestMapping("tofiledetail")
	public String toFileDetail(HttpServletRequest req,Integer fileId){
		req.setAttribute("file",fileService.queryFileById(fileId));
		return "/system/file/filedetail"; 
	}
	
	@RequestMapping("adopt")
	public String adopt(HttpServletRequest req,Integer fileId){
		int count = 0;
		String msg = "";
		count = fileService.updateFileState(fileId,2);
		if(count > 0) {
			msg = "文件审核成功";
		}else {
			msg = "文件审核失败";
		}
		req.setAttribute("msg", msg);
		return "/system/file/queryfile"; 
	}
	
	@RequestMapping("reject")
	public String reject(HttpServletRequest req,Integer fileId){
		int count = 0;
		String msg = "";
		try {count = fileService.updateFileState(fileId,3);}
		catch(Exception e) {count = 0;};
		if(count > 0) {
			msg = "文件驳回成功";
		}else {
			msg = "文件驳回失败";
		}
		req.setAttribute("msg", msg);
		return "/system/file/queryfile"; 
	}
	
	
	
}
