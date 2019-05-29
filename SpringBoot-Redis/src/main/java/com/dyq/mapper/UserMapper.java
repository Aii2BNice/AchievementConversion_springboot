package com.dyq.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dyq.entity.Login;
import com.dyq.entity.LoginGroupByTime;
import com.dyq.entity.User;

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
