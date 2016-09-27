package com.jfn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jfn.dao.UserSkill_2Dao;
import com.jfn.entity.UserSkill_2;

/**
 * @create-time 2014-8-18 下午6:36:25
 * @author 佟德慧
 * @remarks 无
 */
@Repository
public class UserSkill_2Service {

	private static final Logger log = LoggerFactory.getLogger(UserSkill_2Service.class);
	@Autowired
	private UserSkill_2Dao user_skill_2Dao;

	public List<UserSkill_2> getAll() {
		return user_skill_2Dao.getAll();
	}

	public UserSkill_2 getById(String user_skill_2Id) {
		// TODO Auto-generated method stub
		return user_skill_2Dao.get(Integer.parseInt(user_skill_2Id));
	}

	public boolean user_skill_2Insert(UserSkill_2 entity) {
		// TODO Auto-generated method stub
		return user_skill_2Dao.insert(entity);
	}

	public boolean user_skill_2Update(UserSkill_2 entity) {
		// TODO Auto-generated method stub
		return user_skill_2Dao.Update(entity);
	}

	public boolean deleteuser_skill_2(String user_skill_2Id) {
		// TODO Auto-generated method stub
		return user_skill_2Dao.delete(Integer.parseInt(user_skill_2Id));
	}

	// 通过body_id查询user
	public List<UserSkill_2> getAllByUserId(String user_id) {
		return user_skill_2Dao.getAllByUserId(user_id);
	}

}
