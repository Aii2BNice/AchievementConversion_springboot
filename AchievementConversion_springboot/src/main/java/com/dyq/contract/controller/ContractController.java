package com.dyq.contract.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dyq.contract.domain.Contract;
import com.dyq.contract.service.ContractService;

@Controller
public class ContractController {
	
	@Autowired 
	private ContractService contractService;
	
	@RequestMapping("queryAllContract")
	public String queryAllContract(HttpServletRequest req,Contract contract) {
		req.setAttribute("contracts", contractService.queryAllContract(contract));
		return "/customer/querycontract";
	}
	
	
}
