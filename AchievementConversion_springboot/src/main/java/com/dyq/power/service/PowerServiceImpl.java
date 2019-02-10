package com.dyq.power.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dyq.power.domain.Power;
import com.dyq.power.domain.PowerMapper;
@Service
public class PowerServiceImpl implements PowerService{
	
	@Autowired
	private PowerMapper dao;
	
	@Override
	public List<Power> queryAllPower(Power power) {
		return dao.queryAllPower(power);
	}

	@Override
	public int insertPower(Power power) {
		return dao.insertPower(power);
	}

	@Override
	public Power queryPowerByName(String powerName) {
		return dao.queryPowerByName(powerName);
	}

}
