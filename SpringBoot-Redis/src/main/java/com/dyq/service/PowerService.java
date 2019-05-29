package com.dyq.service;

import java.util.List;

import com.dyq.entity.Power;

public interface PowerService {
	
	List<Power> queryAllPower(Power power);
	Power queryPowerByName(String powerName);
	int insertPower(Power power);
	int updatePower(Power power);
	int deletePower(Integer powerId);
	
}
