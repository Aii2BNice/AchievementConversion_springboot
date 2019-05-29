package com.dyq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dyq.entity.Power;
import com.dyq.service.RedisTestService;

@RestController
public class RedisTestController {

	@Autowired
	private RedisTestService redisTestService;
	
	@RequestMapping("getAllPower")
	public List<Power> getAllPower() {
		return redisTestService.getPowerList();
	}
	
	
	
}
