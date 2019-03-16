package com.dyq.file.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dyq.file.domain.FileInfo;
import com.dyq.file.domain.FileState;
import com.dyq.file.domain.FileType;
import com.dyq.file.service.FileService;

@RestController
public class FileRestController {
	
	@Autowired
	private FileService fileService;
	
	private String path = "C:/fileupload";
	// 上传成果文件
	@RequestMapping("upload")
	public String uploadFile(MultipartFile uploadfile,FileInfo fileinfo) throws Exception {
		String fileName = uploadfile.getOriginalFilename();
		String msg = "";
		File dest = new File(path + "/" + fileName);
		if(!dest.getParentFile().exists()) {
			dest.getParentFile().mkdir();
		}
		if(!dest.exists()) {
			// 创建文件
			uploadfile.transferTo(dest);
			// 将文件信息存放到数据库
			fileService.insertFile(fileinfo);
			msg = "文件上传成功";
		}else {
			msg = "文件已存在";
		}
		return msg;
	}
	
	// 下载成果文件
	@RequestMapping("download")
	public String downloadFile(Integer fileId,HttpServletResponse resp) throws Exception {
		// 查询是否有该文件
		FileInfo file = fileService.queryFileById(fileId);
		File dest = new File(path + "/" + file.getFileName());
		// 本地磁盘里是否有该文件
		if(dest.exists()) {
			// 设置响应头
			resp.setContentType("application/x-msdownload");
			resp.setHeader("Content-Disposition", "attachment;filename="+new String(file.getFileName().getBytes("utf-8"),"ISO-8859-1"));
			byte [] buffer = new byte[2048];
			FileInputStream fis = new FileInputStream(dest);
			OutputStream os = resp.getOutputStream();
			BufferedInputStream bis = new BufferedInputStream(fis);
			int i = bis.read(buffer);
			// 将文件传输到浏览器
			while(i!=-1) {
				os.write(buffer);
				i = bis.read(buffer);
			}
			bis.close();
			fis.close();
		}
		return "<h2>资源丢失</h2><br /><br /><a href='#' onclick='javascript:history.back(-1)'>点击返回</a>";
	}
	
	@RequestMapping("queryAllState")
	public List<FileState> queryState(){
		return fileService.queryAllState();
	}
	
	@RequestMapping("queryAllType")
	public List<FileType> queryAllType(){
		return fileService.queryAllType();
	}
	
}
