package com.dyq.contract.service;

import java.util.List;

import com.dyq.contract.domain.Contract;

public interface ContractService {
	
	List<Contract> queryAllContract(Contract contract);
	Contract queryContractById(Integer contractId);
	
}
