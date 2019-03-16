package com.dyq.existsCheck.domain;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ExistCheckMapper {

	int existCheckUser(@Param("loginName")String loginName);
	
	int exitCheckPower(@Param("powerId")Integer powerId);
	
	int existCheckFile(@Param("fileId")Integer fileId);
	
	int existCheckContract(@Param("contractId")Integer contractId);
	
}
