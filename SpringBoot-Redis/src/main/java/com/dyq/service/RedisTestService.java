package com.dyq.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.dyq.entity.Power;
import com.dyq.mapper.PowerMapper;

@Service
public class RedisTestService {

	@Autowired
	private PowerMapper powerMapper;
	
	@Cacheable(cacheNames="powersTest")
	public List<Power> getPowerList() {
		return powerMapper.queryAllPower(null);
	}
	
	@CachePut(cacheNames="updPower", condition="#power!=null", unless="result>0")
	public int updatePower() {
		return powerMapper.updatePower(new Power(1, "redisPower"));
	}
	
	@CacheEvict(cacheNames="delPower", allEntries=true, beforeInvocation=true, condition="powerId>0")
	public int deletePower() {
		return powerMapper.deletePower(1);
	}
	
}
