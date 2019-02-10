package com.dyq.file.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dyq.file.domain.FileInfo;
import com.dyq.file.service.FileService;

@RestController
public class FileController {
	
	@Autowired
	private FileService fileService;
	
	private String path = "C:/fileupload";
	
	@RequestMapping("upload")
	public String uploadFile(MultipartFile file) throws IllegalStateException, IOException {
		
		String fileName = file.getOriginalFilename();
		String msg = "";
		File dest = new File(path + "/" + fileName);
		if(!dest.getParentFile().exists()) {
			dest.getParentFile().mkdir();
		}
		if(!dest.exists()) {
			file.transferTo(dest);
			fileService.insertFile(new FileInfo(null,fileName));
			msg = "文件上传成功";
		}else {
			msg = "文件已存在";
		}
		return msg;
	}
	
	@RequestMapping("download/{fileName}")
	public String downloadFile(@PathVariable String fileName,HttpServletResponse resp) throws Exception {
		
		File dest = new File(path + "/" + fileName);
		if(dest.exists()) {
			
			resp.setContentType("application/x-msdownload");
			resp.setHeader("Content-Disposition", "attachment;filename="+new String(fileName.getBytes("utf-8"),"ISO-8859-1"));
			//缓冲
			byte [] buffer = new byte[1024];
			//文件输入输出流
			FileInputStream fis = new FileInputStream(dest);
			OutputStream os = resp.getOutputStream();
			BufferedInputStream bis = new BufferedInputStream(fis);
			int i = bis.read(buffer);
			while(i!=-1) {
				os.write(buffer);
				i = bis.read(buffer);
			}
			bis.close();
			fis.close();
			System.out.println("文件下载成功");
		}
		return null;
	}
	
	@RequestMapping("queryAllFile")
	public List<FileInfo> queryAllFile(){
		return fileService.queryAllFile(null); 
	}
	
	
}
