package com.dyq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dyq.entity.Contract;
import com.dyq.service.ContractService;
import com.dyq.service.FileService;

@RestController
public class ContractRestController {

	@Autowired
	private ContractService contractservice;
	@Autowired
	private FileService fileservice;
	
	// 签订转化合同
	@RequestMapping("insContract")
	public String insContract(@RequestBody Contract contract) {
		String msg = "";
		// 向数据库插入合同信息
		int count = contractservice.insContract(contract);
		// 更改文件状态为转化完成
		fileservice.updateFileState(contract.getFileId(), 4);
		if(count > 0) {
			msg = "合同签订成功";
		}else {
			msg = "合同签订失败";
		}
		return msg;
	}
	
}
