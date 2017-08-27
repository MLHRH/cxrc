package com.jfn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jfn.dao.UserPeixunDao;
import com.jfn.entity.UserPeixun;

/**
 * @create-time 2014-8-18 下午6:35:46
 * @author 佟德慧
 * @remarks 无
 */
@Repository
public class UserPeixunService {

	private static final Logger log = LoggerFactory.getLogger(UserPeixunService.class);
	@Autowired
	private UserPeixunDao user_peixunDao;

	public List<UserPeixun> getAll() {
		return user_peixunDao.getAll();
	}

	public UserPeixun getById(String user_peixunId) {
		// TODO Auto-generated method stub
		return user_peixunDao.get(Integer.parseInt(user_peixunId));
	}

	public UserPeixun getByUserId(String id) {
		// TODO Auto-generated method stub
		return user_peixunDao.getByUserId(Integer.parseInt(id));
	}

	public boolean user_peixunInsert(UserPeixun entity) {
		// TODO Auto-generated method stub
		return user_peixunDao.insert(entity);
	}

	public boolean user_peixunUpdate(UserPeixun entity) {
		// TODO Auto-generated method stub
		return user_peixunDao.Update(entity);
	}

	public boolean deleteuser_peixun(String user_peixunId) {
		// TODO Auto-generated method stub
		return user_peixunDao.delete(Integer.parseInt(user_peixunId));
	}

	// 通过body_id查询user
	public List<UserPeixun> getAllByUserId(String user_id) {
		return user_peixunDao.getAllByUserId(user_id);
	}

}
