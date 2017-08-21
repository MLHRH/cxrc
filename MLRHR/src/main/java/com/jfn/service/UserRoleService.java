package com.jfn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jfn.dao.UserRoleDao;
import com.jfn.entity.AcctUserRole;

@Repository
public class UserRoleService {
@Autowired
private UserRoleDao userRoleDao ;

public AcctUserRole getByUserId(Integer user_id) {
	// TODO Auto-generated method stub
	return userRoleDao.getByUserId(user_id);
}

public void update(int role_id,Integer user_id) {
	// TODO Auto-generated method stub
	userRoleDao.update(role_id ,user_id);
}
}