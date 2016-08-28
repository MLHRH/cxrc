package com.jfn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jfn.dao.UserReportDao;
import com.jfn.entity.User;
import com.jfn.entity.UserReport;


/**
 * @create-time 2014-8-18 下午6:33:38
 * @author 佟德慧
 * @remarks 无
 */
@Repository
public class UserReportService {
	
	private static final Logger log = LoggerFactory.getLogger( UserReportService.class );
	@Autowired
	private UserReportDao user_reportDao; 
	
	public List<UserReport> getAll()
	{
		return user_reportDao.getAll();
	}
	

	public UserReport getById(String user_reportId) {
		// TODO Auto-generated method stub
		return user_reportDao.get(Integer.parseInt(user_reportId));
	}

	public boolean user_reportInsert(UserReport entity) {
		// TODO Auto-generated method stub
		return user_reportDao.insert(entity);
	}

	public boolean user_reportUpdate(UserReport entity) {
		// TODO Auto-generated method stub
		return user_reportDao.Update(entity);
	}

	public boolean deleteuser_report(String user_reportId) {
		// TODO Auto-generated method stub
		return user_reportDao.delete(Integer.parseInt(user_reportId));
	}
	
	//通过body_id查询user
	public List<UserReport> getAllByUserId(String user_id)
	{
		return user_reportDao.getAllByUserId(user_id);
	}

}
