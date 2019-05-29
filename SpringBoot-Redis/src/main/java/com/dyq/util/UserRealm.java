package com.dyq.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dyq.entity.Login;
import com.dyq.service.UserService;

public class UserRealm extends AuthorizingRealm{

	@Autowired
	private UserService userService;
	
	private static final Logger log = LoggerFactory.getLogger(UserRealm.class);

	
	// 执行授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		log.debug(">>>授权开始");
		// 获取当前登录用户
		Subject subject = SecurityUtils.getSubject();
		Login loginUser = (Login) subject.getPrincipal();
		log.debug(">>>给资源授权");
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		simpleAuthorizationInfo.addStringPermission(loginUser.getPowerId().toString());
		log.debug(">>>授权结束");
		return simpleAuthorizationInfo;
	}

	// 执行认证逻辑
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

		log.debug(">>>认证开始");
		UsernamePasswordToken user = (UsernamePasswordToken) token;
		Login loginUser = new Login();
		loginUser.setLoginName(user.getUsername());
		loginUser.setPass(String.copyValueOf(user.getPassword()));
		Login login = userService.login(loginUser);
		if (login == null) {
			return null;
		}
		log.debug(">>>认证结束");
		return new SimpleAuthenticationInfo(login, login.getPass(), "");
	}
	
}
