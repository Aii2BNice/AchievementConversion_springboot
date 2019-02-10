package com.dyq.file.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dyq.file.domain.FileInfo;
import com.dyq.file.domain.FileMapper;
@Service
public class FileServiceImpl implements FileService {
	
	@Autowired
	private FileMapper dao;
	
	@Override
	public List<FileInfo> queryAllFile(FileInfo file) {
		return dao.queryAllFile(file);
	}

	@Override
	public int insertFile(FileInfo file) {
		return dao.insertFile(file);
	}

}
