package com.dyq.file.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dyq.JumpController;
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
	
	// 查询所有上传文件
	@RequestMapping("queryAllFile")
	public String queryAllFile(HttpServletRequest req,FileInfo file,String loginName){
		// 获取当前用户
		Login user = userService.queryLoginByName(loginName);
		// 获取所有文件列表
		if(user.getPowerId() == 1) {
			file.setLoginId(user.getLoginId());
		}
		List<FileInfo> files = fileService.queryAllFile(file);
		// 存放到请求中
		req.setAttribute("files", files);
		return JumpController.getJumpUrl("queryFile", user.getPowerId()); 
	}
	
	// 查看成果详情
	@RequestMapping("tofiledetail")
	public String toFileDetail(HttpServletRequest req,Integer fileId,String loginName){
		// 获取当前用户
		Login user = userService.queryLoginByName(loginName);
		// 获取当前成果
		FileInfo file = fileService.queryFileById(fileId);
		req.setAttribute("file",file);
		return JumpController.getJumpUrl("fileDetail", user.getPowerId()); 
	}
	
	// 审核通过成果文件
	@RequestMapping("adopt")
	public String adopt(HttpServletRequest req,Integer fileId){
		int count = 0;
		String msg = "";
		// 修改文件状态为审核通过
		count = fileService.updateFileState(fileId,2);
		if(count > 0) {
			msg = "文件审核成功";
		}else {
			msg = "文件审核失败";
		}
		req.setAttribute("msg", msg);
		return "/system/file/queryfile"; 
	}
	
	// 驳回成果转化申请
	@RequestMapping("reject")
	public String reject(HttpServletRequest req,Integer fileId){
		int count = 0;
		String msg = "";
		// 修改文件状态为审核未通过
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
	
	@RequestMapping("toexamfile")
	public String toexamfile(HttpServletRequest req,String loginName){ 
		Login user = userService.queryLoginByName(loginName);
		return JumpController.getJumpUrl("examFile", user.getPowerId());
	}
	
}
