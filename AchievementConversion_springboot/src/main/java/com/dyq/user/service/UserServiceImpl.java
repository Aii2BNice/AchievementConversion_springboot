package com.dyq.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dyq.user.domain.Login;
import com.dyq.user.domain.LoginGroupByTime;
import com.dyq.user.domain.User;
import com.dyq.user.domain.UserMapper;

/**
 * �û�Serviceʵ����
 * @author dyq
 *
 */
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper dao;
	
	@Override
	public Login login(Login login) {
		return dao.login(login);
	}

	@Override
	public List<User> queryAll(User user) {
		return dao.queryAll(user);
	}

	@Override
	public User queryUserById(Integer userId) {
		return dao.queryUserById(userId);
	}

	@Override
	public int insertLogin(Login login) {
		return dao.insertLogin(login);
	}

	@Override
	public int insertUser(User user) {
		return dao.insertUser(user);
	}

	@Override
	public int updateLogin(Login login) {
		return dao.updateLogin(login);
	}

	@Override
	public int updateUser(User user) {
		return dao.updateUser(user);
	}

	@Override
	public int deleteLogin(Integer loginId) {
		return dao.deleteLogin(loginId);
	}

	@Override
	public Login queryLoginByName(String loginName) {
		return dao.queryLoginByName(loginName);
	}

	@Override
	public List<Login> queryAllLogin(Login login) {
		return dao.queryAllLogin(login);
	}

	@Override
	public int loginCount(Login login) {
		return dao.loginCount(login);
	}

	@Override
	public List<LoginGroupByTime> queryUserGroupByTime() {
		return dao.queryUserGroupByTime();
	}


}
