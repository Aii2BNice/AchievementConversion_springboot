package com.dyq.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dyq.entity.Power;

@Mapper
public interface PowerMapper {
	
	List<Power> queryAllPower(Power power);
	Power queryPowerByName(String powerName);
	int insertPower(Power power);
	int updatePower(Power power);
	int deletePower(Integer powerId);
	
}
