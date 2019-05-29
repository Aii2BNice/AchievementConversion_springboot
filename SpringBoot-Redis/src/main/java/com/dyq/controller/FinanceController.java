package com.dyq.controller;

import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dyq.entity.Finance;
import com.dyq.entity.FinanceGroupByYear;
import com.dyq.service.FinanceService;

@Controller
public class FinanceController {

	@Autowired
	private FinanceService financeService;
	
	// 查询所有缴费记录
	@RequestMapping("queryAllFinance")
	public String queryAllFinanca(HttpServletRequest req,Finance finance) {
		req.setAttribute("finances", financeService.queryAllFince(finance));
		return "/system/finance/queryfinance";
	}
	
	// 新增缴费记录
	@RequestMapping("insFinance")
	@ResponseBody
	public String insFinance(@RequestBody Finance finance) {
		String msg = "";
		if(finance != null) {
			financeService.insFinance(finance);
			msg = "缴费成功";
		}else {
			msg = "缴费失败";
		}
		return msg;
	}
	
	// 打印记录
	@RequestMapping("queryFinanceById")
	public String queryFinanceById(HttpServletRequest req,Integer financeId) {
		req.setAttribute("finance", financeService.queryFinanceById(financeId));
		return "print";
	}
	
	//分组统计每年缴费
	@RequestMapping("queryFinanceGroup")
	@ResponseBody
	public Map<String, String> queryFinanceGroup(){
		Map<String, String> financeMap = new LinkedHashMap<>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<FinanceGroupByYear> queryFinanceByYear = financeService.queryFinanceByYear();
		for(FinanceGroupByYear fgby :queryFinanceByYear) {
			financeMap.put(sdf.format(fgby.getRegisterTime()), fgby.getAmount().toString());
		}
		return financeMap;
	}
	
}
