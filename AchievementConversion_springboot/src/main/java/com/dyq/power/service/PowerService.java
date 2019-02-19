package com.dyq.power.service;

import java.util.List;

import com.dyq.power.domain.Power;

public interface PowerService {
	
	List<Power> queryAllPower(Power power);
	Power queryPowerByName(String powerName);
	int insertPower(Power power);
	int updatePower(Power power);
	int deletePower(Integer powerId);
	
}
