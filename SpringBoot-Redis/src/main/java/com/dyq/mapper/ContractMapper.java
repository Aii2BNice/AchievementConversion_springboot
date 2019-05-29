package com.dyq.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.dyq.entity.Contract;

@Mapper
public interface ContractMapper {
	
	List<Contract> queryAllContract(Contract contract);
	Contract queryContractById(Integer contractId);
	int insContract(Contract contract);
	int deleteContract(@Param("contractId")Integer contractId);
}
