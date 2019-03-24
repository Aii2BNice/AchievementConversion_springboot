package com.dyq.user.domain;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
	
	Login login(Login login);
	
	List<User> queryAll(User user);
	List<Login> queryAllLogin(Login login);
	
	User queryUserById(Integer userId);
	Login queryLoginByName(String loginName);
	Admin queryAdminById(Integer adminId);
	Customer queryCustomerById(Integer customerId);
	
	int insertLogin(Login login);
	int insertUser(User user);
	int insertAdmin(Admin admin);
	int insCustomer(Customer customer);
	
	
	int updateLogin(Login login);
	int updateUser(User user);
	int updatAdmin(Admin admin);
	int updateCustomer(Customer customer);
	
	int deleteLogin(Integer loginId);
	int deleteUser(User user);
	int deleteAdmin(Admin admin);
	int deleteCustomrt(Customer customer);
	
	
	
}
