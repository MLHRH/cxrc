package com.jfn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jfn.dao.UserProjectDao;
import com.jfn.entity.UserChengguo;
import com.jfn.entity.JcqnDocProject;


/**
 * @create-time 2014-8-18 下午6:36:25
 * @author 佟德慧
 * @remarks 无
 */
@Repository
public class UserProjectService {
	
	private static final Logger log = LoggerFactory.getLogger( UserProjectService.class );
	@Autowired
	private UserProjectDao user_projectDao;
	
	public List<JcqnDocProject> getAll()
	{
		return user_projectDao.getAll();
	}
	

	public JcqnDocProject getById(String user_projectId) {
		// TODO Auto-generated method stub
		return user_projectDao.get(Integer.parseInt(user_projectId));
	}

	public boolean user_projectInsert(JcqnDocProject entity) {
		// TODO Auto-generated method stub
		return user_projectDao.insert(entity);
	}

	public boolean user_projectUpdate(JcqnDocProject entity) {
		// TODO Auto-generated method stub
		return user_projectDao.Update(entity);
	}

	public boolean deleteuser_project(String user_projectId) {
		// TODO Auto-generated method stub
		return user_projectDao.delete(Integer.parseInt(user_projectId));
	}
	
	//通过body_id查询user
	public List<JcqnDocProject> getAllByUserId(String user_id)
	{
		return user_projectDao.getAllByUserId(user_id);
	}

}
