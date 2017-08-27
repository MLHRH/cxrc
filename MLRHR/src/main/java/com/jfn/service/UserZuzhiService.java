package com.jfn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jfn.dao.UserZuzhiDao;
import com.jfn.entity.UesrZuzhi;

@Repository
public class UserZuzhiService {
@Autowired
private UserZuzhiDao userZuzhiDao  ;

public boolean  zuzhiInsert(UesrZuzhi uesrZuzhi) {
	return userZuzhiDao.zuzhiInsert(uesrZuzhi);
	// TODO Auto-generated method stub
	
}

public boolean  zuzhiUpdate(UesrZuzhi uesrZuzhi) {
	return userZuzhiDao.zuzhiUpdate(uesrZuzhi);
	// TODO Auto-generated method stu	
}

public List<UesrZuzhi> getAllByUser(String userId) {
	// TODO Auto-generated method stub
	return userZuzhiDao.getAllByUserId(userId);
}

}
