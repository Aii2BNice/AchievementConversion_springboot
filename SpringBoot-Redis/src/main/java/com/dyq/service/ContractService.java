package com.dyq.service;

import java.util.List;

import com.dyq.entity.Contract;

public interface ContractService {
	
	List<Contract> queryAllContract(Contract contract);
	Contract queryContractById(Integer contractId);
	int insContract(Contract contract);
	int deleteContract(Integer contractId);
	
}
