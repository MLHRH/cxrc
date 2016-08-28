package com.jfn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jfn.dao.UserExamDao;
import com.jfn.entity.UserChengguo;
import com.jfn.entity.UserExam;


/**
 * @create-time 2014-8-18 下午6:35:14
 * @author 佟德慧
 * @remarks 无
 */
@Repository
public class UserExamService {
	
	private static final Logger log = LoggerFactory.getLogger( UserExamService.class );
	@Autowired
	private UserExamDao user_examDao;
	
	public List<UserExam> getAll()
	{
		return user_examDao.getAll();
	}
	

	public UserExam getById(String user_examId) {
		// TODO Auto-generated method stub
		return user_examDao.get(Integer.parseInt(user_examId));
	}

	public boolean user_examInsert(UserExam entity) {
		// TODO Auto-generated method stub
		return user_examDao.insert(entity);
	}

	public boolean user_examUpdate(UserExam entity) {
		// TODO Auto-generated method stub
		return user_examDao.Update(entity);
	}

	public boolean deleteuser_exam(String user_examId) {
		// TODO Auto-generated method stub
		return user_examDao.delete(Integer.parseInt(user_examId));
	}
	
	//通过body_id查询user
	public List<UserExam> getAllByUserId(String user_id)
	{
		return user_examDao.getAllByUserId(user_id);
	}

}
