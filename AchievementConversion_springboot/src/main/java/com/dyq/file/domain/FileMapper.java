package com.dyq.file.domain;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FileMapper {
	
	List<FileInfo> queryAllFile(FileInfo file);
	List<FileState> queryAllState();
	List<FileType> queryAllType();
	FileInfo queryFileById(@Param("fileId")Integer fileId);
	int insertFile(FileInfo file);
	int updateFileState(@Param("fileId") Integer fileId,@Param("fileStateId") Integer fileStateId);

}
