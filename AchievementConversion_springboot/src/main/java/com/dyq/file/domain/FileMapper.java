package com.dyq.file.domain;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileMapper {
	
	List<FileInfo> queryAllFile(FileInfo file);
	int insertFile(FileInfo file);
	
}
