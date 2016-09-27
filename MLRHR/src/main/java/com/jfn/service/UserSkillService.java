package com.jfn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jfn.dao.UserSkillDao;
import com.jfn.entity.UserChengguo;
import com.jfn.entity.UserSkill;


/**
 * @create-time 2014-8-18 下午6:36:25
 * @author 佟德慧
 * @remarks 无
 */
@Repository
public class UserSkillService {
	
	private static final Logger log = LoggerFactory.getLogger( UserSkillService.class );
	@Autowired
	private UserSkillDao user_skillDao;
	
	public List<UserSkill> getAll()
	{
		return user_skillDao.getAll();
	}
	

	public UserSkill getById(String user_skillId) {
		// TODO Auto-generated method stub
		return user_skillDao.get(Integer.parseInt(user_skillId));
	}

	public boolean user_skillInsert(UserSkill entity) {
		// TODO Auto-generated method stub
		return user_skillDao.insert(entity);
	}

	public boolean user_skillUpdate(UserSkill entity) {
		// TODO Auto-generated method stub
		return user_skillDao.Update(entity);
	}

	public boolean deleteuser_skill(String user_skillId) {
		// TODO Auto-generated method stub
		return user_skillDao.delete(Integer.parseInt(user_skillId));
	}
	
	//通过body_id查询user
	public List<UserSkill> getAllByUserId(String user_id)
	{
		return user_skillDao.getAllByUserId(user_id);
	}

}
