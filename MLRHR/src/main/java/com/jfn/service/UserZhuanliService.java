package com.jfn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jfn.dao.UserZhuanliDao;
import com.jfn.entity.User;
import com.jfn.entity.JcqnDocPatent;


/**
 * @create-time 2014-8-18 下午6:33:38
 * @author 佟德慧
 * @remarks 无
 */
@Repository
public class UserZhuanliService {
	
	private static final Logger log = LoggerFactory.getLogger( UserZhuanliService.class );
	@Autowired
	private UserZhuanliDao user_zhuanliDao; 
	
	public List<JcqnDocPatent> getAll()
	{
		return user_zhuanliDao.getAll();
	}
	

	public JcqnDocPatent getById(String user_zhuanliId) {
		// TODO Auto-generated method stub
		return user_zhuanliDao.get(Integer.parseInt(user_zhuanliId));
	}

	public boolean user_zhuanliInsert(JcqnDocPatent entity) {
		// TODO Auto-generated method stub
		return user_zhuanliDao.insert(entity);
	}

	public boolean user_zhuanliUpdate(JcqnDocPatent entity) {
		// TODO Auto-generated method stub
		return user_zhuanliDao.Update(entity);
	}

	public boolean deleteuser_zhuanli(String user_zhuanliId) {
		// TODO Auto-generated method stub
		return user_zhuanliDao.delete(Integer.parseInt(user_zhuanliId));
	}
	
	//通过body_id查询user
	public List<JcqnDocPatent> getAllByUserId(String user_id)
	{
		return user_zhuanliDao.getAllByUserId(user_id);
	}

}
