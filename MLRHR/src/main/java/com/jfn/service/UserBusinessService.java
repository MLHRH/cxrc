package com.jfn.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jfn.dao.UserBusinessDao;
import com.jfn.entity.UserBusiness;

@Repository
public class UserBusinessService {
	
	private static final Logger log = LoggerFactory.getLogger( UserBusinessService.class );
	@Autowired
	private UserBusinessDao userbusinessDao;
	
	
	public UserBusiness getById(String Id) {
		// TODO Auto-generated method stub
		return userbusinessDao.getById(Integer.parseInt(Id));
	}
	public UserBusiness getByUserId( int user_id) {
		// TODO Auto-generated method stub
		return userbusinessDao.getByUserId( user_id);
	}

	public boolean insert(UserBusiness entity) {
		// TODO Auto-generated method stub
		return userbusinessDao.insert(entity);
	}
	public int newFile(UserBusiness entity) {
		// TODO Auto-generated method stub
		return userbusinessDao.newFile(entity);
	}

	public boolean update(UserBusiness entity) {
		// TODO Auto-generated method stub
		return userbusinessDao.update(entity);
	}

	public boolean delete(String zhichengId) {
		// TODO Auto-generated method stub
		return userbusinessDao.delete(Integer.parseInt(zhichengId));
	}

}
