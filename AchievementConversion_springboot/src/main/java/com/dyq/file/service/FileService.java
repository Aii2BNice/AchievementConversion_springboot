package com.dyq.file.service;

import java.util.List;

import com.dyq.file.domain.FileGroupByType;
import com.dyq.file.domain.FileGroupByYear;
import com.dyq.file.domain.FileInfo;
import com.dyq.file.domain.FileState;
import com.dyq.file.domain.FileType;

public interface FileService {

	List<FileInfo> queryAllFile(FileInfo file);
	List<FileState> queryAllState();
	List<FileType> queryAllType();
	FileInfo queryFileById(Integer fileId);
	int insertFile(FileInfo file);
	int updateFileState(Integer fileId,Integer fileStateId);
	int updateFileInfo(FileInfo file);
	int queryFileCount(FileInfo file);
	
	int deleteFile(Integer fileId);
	
	List<FileGroupByYear> getGroupByFileYear();
	List<FileGroupByYear> getSuccessGroupByFileYear();
	List<FileGroupByType> getGroupByFileType();
	
}
