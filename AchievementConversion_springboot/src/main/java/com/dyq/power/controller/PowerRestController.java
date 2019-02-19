package com.dyq.power.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dyq.power.domain.Power;
import com.dyq.power.service.PowerService;

@RestController
public class PowerRestController {
	
	@Autowired
	private PowerService powerService;
	
	@RequestMapping("queryAllPower")
	public List<Power> queryAllPower(){
		return powerService.queryAllPower(null);
	}
	
	@RequestMapping("verPowerName")
	public String VerPowerName(@RequestBody Power power) {
		String msg = "";
		Power p = powerService.queryPowerByName(power.getPowerName());
		if(p!=null) {
			msg = "权限名已存在";
		}
		return msg;
	}
	
	@RequestMapping("insertPower")
	public String insertPower(@RequestBody Power power) {
		String msg = "";
		int count = 0;
		try {count = powerService.insertPower(power);}
		catch(Exception e) {count = 0;}
		if(count>0) {
			msg = "权限添加成功";
		}else {
			msg = "权限添加失败";
		}
		return msg;
	}
	
	@RequestMapping("updatePower")
	public String updatePower(@RequestBody Power power) {
		System.out.println(power);
		String msg = "";
		int count = 0;
		try {count = powerService.updatePower(power);}
		catch(Exception e) {count = 0;}
		if(count>0) {
			msg = "权限修改成功";
		}else {
			msg = "权限修改失败";
		}
		return msg;
	}
	
}
