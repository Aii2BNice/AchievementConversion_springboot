package com.dyq.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.dyq.entity.FileGroupByType;
import com.dyq.entity.FileGroupByYear;
import com.dyq.entity.FileInfo;
import com.dyq.entity.FileState;
import com.dyq.entity.FileType;

@Mapper
public interface FileMapper {
	
	List<FileInfo> queryAllFile(FileInfo file);
	List<FileState> queryAllState();
	List<FileType> queryAllType();
	FileInfo queryFileById(@Param("fileId")Integer fileId);
	int insertFile(FileInfo file);
	int updateFileState(@Param("fileId") Integer fileId,@Param("fileStateId") Integer fileStateId);
	int updateFileInfo(FileInfo file);
	int fileCount(FileInfo file);
	
	int deleteFile(@Param("fileId") Integer fileId);
	
	List<FileGroupByYear> getGroupByFileYear();
	List<FileGroupByYear> getSuccessGroupByFileYear();
	List<FileGroupByType> getGroupByFileType();
	
}
