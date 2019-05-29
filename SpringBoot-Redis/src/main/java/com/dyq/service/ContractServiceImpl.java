package com.dyq.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dyq.entity.Contract;
import com.dyq.mapper.ContractMapper;
@Service
public class ContractServiceImpl implements ContractService {
	
	@Autowired
	private ContractMapper dao;
	
	@Override
	public List<Contract> queryAllContract(Contract contract) {
		return dao.queryAllContract(contract);
	}

	@Override
	public Contract queryContractById(Integer contractId) {
		return dao.queryContractById(contractId);
	}

	@Override
	public int insContract(Contract contract) {
		return dao.insContract(contract);
	}

	@Override
	public int deleteContract(Integer contractId) {
		return dao.deleteContract(contractId);
	}

}
