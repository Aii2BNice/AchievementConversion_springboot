package com.dyq.power.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dyq.power.domain.Power;
import com.dyq.power.service.PowerService;

@RestController
public class PowerController {
	
	@Autowired
	private PowerService powerService;
	
	@RequestMapping("queryAllPower")
	public List<Power> queryAllPower(){
		return powerService.queryAllPower(null);
	}
	
	@RequestMapping("VerPowerName")
	public String VerPowerName(String powerName) {
		String msg = "";
		Power power = powerService.queryPowerByName(powerName);
		if(power!=null) {
			msg = "权限名已存在";
		}
		return msg;
	}
	
	@RequestMapping("insertPower")
	public String insertPower(Power power) {
		String msg = "";
		int count = powerService.insertPower(power);
		if(count>0) {
			msg = "权限添加成功";
		}else {
			msg = "权限添加失败";
		}
		return msg;
	}
}
