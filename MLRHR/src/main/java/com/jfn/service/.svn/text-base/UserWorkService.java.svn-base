package com.jfn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jfn.dao.UserWorkDao;
import com.jfn.entity.UserChengguo;
import com.jfn.entity.UserWork;

/**
 * @create-time 2014-8-8 下午9:07:25
 * @creator     佟德慧
 */
@Repository
public class UserWorkService {
	
	private static final Logger log = LoggerFactory.getLogger( UserWorkService.class );
	@Autowired
	private UserWorkDao user_workDao;
	
	public List<UserWork> getAll()
	{
		return user_workDao.getAll();
	}
	

	public UserWork getById(String user_workId) {
		// TODO Auto-generated method stub
		return user_workDao.get(Integer.parseInt(user_workId));
	}

	public boolean user_workInsert(UserWork entity) {
		// TODO Auto-generated method stub
		return user_workDao.insert(entity);
	}

	public boolean user_workUpdate(UserWork entity) {
		// TODO Auto-generated method stub
		return user_workDao.Update(entity);
	}

	public boolean deleteuser_work(String user_workId) {
		// TODO Auto-generated method stub
		return user_workDao.delete(Integer.parseInt(user_workId));
	}
	//通过body_id查询user
	public List<UserWork> getAllByUserId(String user_id)
	{
		return user_workDao.getAllByUserId(user_id);
	}
	

}
