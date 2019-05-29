package com.dyq.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.dyq.entity.Power;
import com.dyq.mapper.PowerMapper;
@Service
public class PowerServiceImpl implements PowerService{
	
	@Autowired
	private PowerMapper dao;
	
	@Override
	@Cacheable(cacheNames="powers")
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

	@Override
	public int updatePower(Power power) {
		return dao.updatePower(power);
	}

	@Override
	public int deletePower(Integer powerId) {
		return dao.deletePower(powerId);
	}

}
