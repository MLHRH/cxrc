package com.jfn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jfn.dao.UserAwardDao;
import com.jfn.entity.JcqnDocPrize;


/**
 * @create-time 2014-8-18 下午6:33:38
 * @author 佟德慧
 * @remarks 无
 */
@Repository
public class UserAwardService {
	
	private static final Logger log = LoggerFactory.getLogger( UserAwardService.class );
	@Autowired
	private UserAwardDao user_awardDao; 
	
	public List<JcqnDocPrize> getAll()
	{
		return user_awardDao.getAll();
	}
	

	public JcqnDocPrize getById(String user_awardId) {
		// TODO Auto-generated method stub
		return user_awardDao.get(Integer.parseInt(user_awardId));
	}

	public boolean user_awardInsert(JcqnDocPrize entity) {
		// TODO Auto-generated method stub
		return user_awardDao.insert(entity);
	}

	public boolean user_awardUpdate(JcqnDocPrize entity) {
		// TODO Auto-generated method stub
		return user_awardDao.Update(entity);
	}

	public boolean deleteuser_award(String user_awardId) {
		// TODO Auto-generated method stub
		return user_awardDao.delete(Integer.parseInt(user_awardId));
	}
	
	//通过body_id查询user
	public List<JcqnDocPrize> getAllByUserId(String user_id)
	{
		return user_awardDao.getAllByUserId(user_id);
	}

}
