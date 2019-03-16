package com.dyq.existsCheck.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dyq.existsCheck.domain.ExistCheckMapper;

@Service
public class ExistService {

	@Autowired
	private ExistCheckMapper existCheckMapper;
	
	boolean existCheckUser(String loginName) {
		return existCheckMapper.existCheckUser(loginName) > 0 ? false : true ;
	}
	
	boolean exitCheckPower(Integer powerId) {
		return existCheckMapper.exitCheckPower(powerId) > 0 ? false : true ;
	}
	
	boolean existCheckFile(Integer fileId) {
		return existCheckMapper.existCheckFile(fileId) > 0 ? false : true ;
	}
	
	boolean existCheckContract(Integer contractId) {
		return existCheckMapper.existCheckContract(contractId) > 0 ? false : true ;
	}
	
}
