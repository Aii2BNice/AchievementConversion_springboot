
package com.dyq.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dyq.entity.Finance;
import com.dyq.entity.FinanceGroupByYear;
import com.dyq.mapper.FinanceMapper;

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
	
	public List<FinanceGroupByYear> queryFinanceByYear(){
		return financeMapper.queryFinanceByYear();
	}
	
}
