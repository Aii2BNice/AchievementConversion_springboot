package com.dyq.file.service;

import java.util.List;

import com.dyq.file.domain.FileInfo;

public interface FileService {

	List<FileInfo> queryAllFile(FileInfo file);
	int insertFile(FileInfo file);
	
}
