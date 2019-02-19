package com.dyq.power.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dyq.power.domain.Power;
import com.dyq.power.service.PowerService;

@Controller
public class PowerController {
	
	@Autowired
	private PowerService powerService;
	
	@RequestMapping("querypower")
	public String queryPower(HttpServletRequest req,Power power) {
		req.setAttribute("powers", powerService.queryAllPower(power));
		req.setAttribute("powerName", power.getPowerName());
		return "/system/power/querypower";
	}
	
	@RequestMapping("toupdatePower")
	public String toupdatepower(HttpServletRequest req,String powerName){
		req.setAttribute("power", powerService.queryPowerByName(powerName));
		return "/system/power/updatepower";
	}
	
	@RequestMapping("dodeletepower")
	public String dodeletepower(HttpServletRequest req,Integer powerId){
		int count = 0;
		try {count = powerService.deletePower(powerId);}
		catch(Exception e) { count = 0; }
		if(count>0) {
			req.setAttribute("msg", "权限删除成功");
		}else {
			req.setAttribute("msg", "权限删除失败");
		}
		return "/system/power/querypower";
	}
	
}
