package com.dyq.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.dyq.entity.Finance;
import com.dyq.entity.FinanceGroupByYear;

@Mapper
public interface FinanceMapper {

	List<Finance> queryAllFince(Finance finance);
	
	Finance queryFinanceById(@Param("financeId")Integer financeId);
	
	int insFinance (Finance finance);
	
	List<FinanceGroupByYear> queryFinanceByYear();
	
}
