package com.dyq.service;

import java.util.List;

import com.dyq.entity.FileGroupByType;
import com.dyq.entity.FileGroupByYear;
import com.dyq.entity.FileInfo;
import com.dyq.entity.FileState;
import com.dyq.entity.FileType;

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
