package com.jfn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jfn.dao.UserStudyDao;
import com.jfn.entity.UserChengguo;
import com.jfn.entity.UserStudy;

/**
 * @create-time 2014-8-18 下午6:37:13
 * @author 佟德慧
 * @remarks 无
 */
@Repository
public class UserStudyService {
	
	private static final Logger log = LoggerFactory.getLogger( UserStudyService.class );
	@Autowired
	private UserStudyDao user_studyDao;
	
	public List<UserStudy> getAll()
	{
		return user_studyDao.getAll();
	}
	

	public UserStudy getById(String user_studyId) {
		// TODO Auto-generated method stub
		return user_studyDao.get(Integer.parseInt(user_studyId));
	}
	public UserStudy getNewById(String user_studyId) {
		// TODO Auto-generated method stub
		return user_studyDao.getNewById(Integer.parseInt(user_studyId));
	}

	public boolean user_studyInsert(UserStudy entity) {
		// TODO Auto-generated method stub
		return user_studyDao.insert(entity);
	}

	public boolean user_studyUpdate(UserStudy entity) {
		// TODO Auto-generated method stub
		return user_studyDao.Update(entity);
	}

	public boolean deleteuser_study(String user_studyId) {
		// TODO Auto-generated method stub
		return user_studyDao.delete(Integer.parseInt(user_studyId));
	}
	//通过body_id查询user
	public List<UserStudy> getAllByUserId(String user_id)
	{
		return user_studyDao.getAllByUserId(user_id);
	}
	

}
