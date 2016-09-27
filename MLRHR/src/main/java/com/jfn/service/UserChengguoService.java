package com.jfn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jfn.dao.UserChengguoDao;
import com.jfn.entity.JcqnDocThesis;


/**
 * @create-time 2014-8-18 下午6:33:38
 * @author 佟德慧
 * @remarks 无
 */
@Repository
public class UserChengguoService {
	
	private static final Logger log = LoggerFactory.getLogger( UserChengguoService.class );
	@Autowired
	private UserChengguoDao user_chengguoDao; 
	
	public List<JcqnDocThesis> getAll()
	{
		return user_chengguoDao.getAll();
	}
	

	public JcqnDocThesis getById(String user_chengguoId) {
		// TODO Auto-generated method stub
		return user_chengguoDao.get(Integer.parseInt(user_chengguoId));
	}

	public boolean user_chengguoInsert(JcqnDocThesis entity) {
		// TODO Auto-generated method stub
		return user_chengguoDao.insert(entity);
	}

	public boolean user_chengguoUpdate(JcqnDocThesis entity) {
		// TODO Auto-generated method stub
		return user_chengguoDao.Update(entity);
	}

	public boolean deleteuser_chengguo(String user_chengguoId) {
		// TODO Auto-generated method stub
		return user_chengguoDao.delete(Integer.parseInt(user_chengguoId));
	}
	
	//通过body_id查询user
	public List<JcqnDocThesis> getAllByUserId(String user_id)
	{
		return user_chengguoDao.getAllByUserId(user_id);
	}

}
