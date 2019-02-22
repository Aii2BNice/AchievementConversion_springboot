package com.dyq.contract.domain;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ContractMapper {
	
	List<Contract> queryAllContract(Contract contract);
	Contract queryContractById(Integer contractId);
	
}
