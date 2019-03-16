package com.dyq.contract.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dyq.contract.domain.Contract;
import com.dyq.contract.service.ContractService;

@RestController
public class ContractRestController {

	@Autowired
	private ContractService contractservice;
	
	@RequestMapping("insContract")
	public String insContract(@RequestBody Contract contract) {
		String msg = "";
		int count = contractservice.insContract(contract);
		if(count > 0) {
			msg = "合同签订成功";
		}else {
			msg = "合同签订失败";
		}
		return msg;
	}
	
}
