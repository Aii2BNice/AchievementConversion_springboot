package com.dyq.user.domain;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
	
	Login login(Login login);
	
	List<User> queryAll(User user);
	List<Login> queryAllLogin(Login login);
	int loginCount(Login login);
	
	User queryUserById(Integer userId);
	Login queryLoginByName(String loginName);
	
	int insertLogin(Login login);
	int insertUser(User user);
	
	
	int updateLogin(Login login);
	int updateUser(User user);
	
	int deleteLogin(Integer loginId);
	int deleteUser(User user);
	
	List<LoginGroupByTime> queryUserGroupByTime();
	
	
}
