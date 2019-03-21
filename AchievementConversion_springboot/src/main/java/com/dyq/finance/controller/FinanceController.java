package com.dyq.finance.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dyq.finance.domain.Finance;
import com.dyq.finance.service.FinanceService;

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
		System.out.println(finance);
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
	
}
