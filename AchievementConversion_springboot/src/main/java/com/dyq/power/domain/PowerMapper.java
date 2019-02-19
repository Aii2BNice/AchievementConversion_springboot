package com.dyq.power.domain;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PowerMapper {
	
	List<Power> queryAllPower(Power power);
	Power queryPowerByName(String powerName);
	int insertPower(Power power);
	int updatePower(Power power);
	int deletePower(Integer powerId);
	
}
