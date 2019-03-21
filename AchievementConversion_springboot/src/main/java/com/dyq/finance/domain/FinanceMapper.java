package com.dyq.finance.domain;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FinanceMapper {

	List<Finance> queryAllFince(Finance finance);
	
	Finance queryFinanceById(@Param("financeId")Integer financeId);
	
	int insFinance (Finance finance);
	
}
