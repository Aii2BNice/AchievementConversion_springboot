package com.dyq.finance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dyq.finance.domain.Finance;
import com.dyq.finance.domain.FinanceMapper;

@Service
public class FinanceService {

	@Autowired
	private FinanceMapper financeMapper;
	
	public List<Finance> queryAllFince(Finance finance){
		return financeMapper.queryAllFince(finance);
	}
	
	public Finance queryFinanceById(Integer financeId) {
		return financeMapper.queryFinanceById(financeId);
	}
	
	public int insFinance (Finance finance) {
		return financeMapper.insFinance(finance);
	}
	
}
