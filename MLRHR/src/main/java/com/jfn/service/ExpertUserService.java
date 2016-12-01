package com.jfn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jfn.dao.ExpertUserDao;
import com.jfn.entity.ExpertUser;

@Repository
public class ExpertUserService {
	@Autowired
	private ExpertUserDao expertUserDao;

//	/**
//	 * 选取专家进行分组
//	 * 
//	 * @param group_id  所属分组id
//	 * @param ids  选取的专家id集合
//	 * @return
//	 */
//	public boolean updateGroup(Integer group_id, List<Integer> ids) {
//
//		boolean ss = false;
//		for (int id : ids) {
//			ExpertUser expertUser = new ExpertUser();
//			expertUser.setGroup_id(group_id);
//			expertUser.setId(id);
//			ss = expertUserDao.update(expertUser);
//			if (ss == false) {
//			break;
//			}
//		}
//
//		return ss;
//
//	}

	/**
	 * 根据分组id查询专家列表
	 * 
	 * @param group_id
	 * @return
	 */
	public List<ExpertUser> queryExpertByGroupId(Integer group_id) {
		return expertUserDao.getByGroupId(group_id);
	}

	/**
	 * 查询专家列表 
	 * 
	 * @return
	 */
	public List<ExpertUser> queryExpert() {
		return expertUserDao.queryExpertUser();
	}

	/**
	 * 新建专家
	 * 
	 * @param expertUser
	 * @return
	 */
	public boolean insertExpert(ExpertUser expertUser) {
		return expertUserDao.insert(expertUser);
	}

	/**
	 * 修改专家信息
	 * 
	 * @param expertUser
	 * @return
	 */

	public boolean updateExpert(ExpertUser expertUser) {
		return expertUserDao.update(expertUser);
	}
	
	
	public ExpertUser getByUserId(Integer user_id){
		
		return expertUserDao.getByUserId(user_id);
		
	}

}
