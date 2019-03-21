package com.dyq.file.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dyq.file.domain.FileGroupByType;
import com.dyq.file.domain.FileGroupByYear;
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
		fileinfo.setFileName(fileName);
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
		return msg + "<a href='toInsFinance?fileId="+ fileinfo.getFileId() +"'>缴费</a>";
	}
	
	// 下载成果文件
	@RequestMapping("download")
	public String downloadFile(Integer fileId,HttpServletResponse resp) throws Exception {
		// 查询是否有该文件
		FileInfo file = fileService.queryFileById(fileId);
		File dest = new File(path + "/" + file.getFileName());
		// 本地磁盘里是否有该文件
		if(dest.exists()) {
			resp.setContentType("application/x-msdownload");
			resp.setHeader("Content-Disposition", "attachment;filename="+new String(dest.getName().getBytes("utf-8"),"ISO-8859-1"));
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
	
	// 以年份分组统计转化成功成果
	@RequestMapping("groupByYear")
	public List<List<FileGroupByYear>> getGroupByYear(){
		List<List<FileGroupByYear>> resultList = new ArrayList<>();
		// 获取上传分组结果
		resultList.add(fileService.getGroupByFileYear());
		// 获取转化成功分组结果
		resultList.add(fileService.getSuccessGroupByFileYear());
		return resultList;
	}
	
	// 以分类分组统计转化成功成果
	@RequestMapping("groupByType")
	public Map<String, String> getGroupByType(){
		Map<String, String> typeMap = new LinkedHashMap<>();
		// 获取成功类型分组结果
		List<FileGroupByType> list = fileService.getGroupByFileType();
		for(FileGroupByType type : list) {
			typeMap.put(type.getType(), type.getAmount());
		}
		return typeMap;
	}
	
	@RequestMapping("getFileById")
	public String getFileById(@RequestBody FileInfo file) {
		return fileService.queryFileById(file.getFileId()).getFilePrice().toString();
	}
	
}
