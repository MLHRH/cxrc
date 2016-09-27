package com.jfn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springside.modules.utils.MD5Utils;

import com.jfn.dao.LoginDao;
import com.jfn.dao.UserDao;
import com.jfn.entity.LoginUser;

@Repository
public class LoginService {
	private static final Logger log = LoggerFactory.getLogger(LoginService.class);
	@Autowired
	private LoginDao dao;
	@Autowired
	private UserDao userDao;

	public List<LoginUser> login(String login_name, String login_pwd) {
		log.info("login_name = " + login_name + " , login_pwd = " + login_pwd);
		return dao.login(login_name, login_pwd);
	}

	public boolean changepwd(String login_name, String login_pwd) {
		return userDao.save(login_name, MD5Utils.PasswordEncryptByMD5(login_pwd));
	}

	public boolean check(String login_name, String login_pwd) {
		return userDao.checkLogin(login_name, MD5Utils.PasswordEncryptByMD5(login_pwd));
	}

	public List<String> checkGetPWD(String email, String username) {
		return dao.checkGetPWD(email, username);
	}
}
