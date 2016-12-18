package com.jfn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jfn.dao.ZhichengApplyDao;
import com.jfn.entity.AcctUserRole;
import com.jfn.entity.ExpertGroup;
import com.jfn.entity.ExpertScore;
import com.jfn.entity.ExpertUser;
import com.jfn.entity.ExpertVote;
import com.jfn.entity.JcqnDoc04;
import com.jfn.entity.ZhichengApply;
import com.jfn.entity.ZhichengApply;

@Repository
public class ZhichengApplyService {
	
	private static final Logger log = LoggerFactory.getLogger( ZhichengApplyService.class );
	@Autowired
	private ZhichengApplyDao zhichengDao;
	
	public List<ZhichengApply> getAll()
	{
		return zhichengDao.getAll();
	}
	
	
	public ZhichengApply getById(String Id) {
		// TODO Auto-generated method stub
		return zhichengDao.get(Integer.parseInt(Id));
	}

	public boolean Insert(ZhichengApply entity) {
		// TODO Auto-generated method stub
		return zhichengDao.insert(entity);
	}

	public boolean Update(ZhichengApply entity) {
		// TODO Auto-generated method stub
		return zhichengDao.Update(entity);
	}

	public boolean delete(String zhichengId) {
		// TODO Auto-generated method stub
		return zhichengDao.delete(Integer.parseInt(zhichengId));
	}


	public List<ZhichengApply> getAllByUserId(Integer id) {
		// TODO Auto-generated method stub
		return zhichengDao.getAllByUserId(id);
	}
	public List<ZhichengApply> getUserByUserIdAndDate(Integer id,String startDate,String endDate) {
		// TODO Auto-generated method stub
		return zhichengDao.getUserByUserIdAndDate(id,startDate,endDate);
	}
	
	
	public List<ZhichengApply> getAllByGroupId(Integer id) {
		// TODO Auto-generated method stub
		return zhichengDao.getAllByGroupId(id);
	}


	public ExpertUser getByUserId( int user_id ){
		return zhichengDao.getByUserId(user_id);
	}
	
	
	public AcctUserRole getRoleByUserId( int user_id ){
		return zhichengDao.getRoleByUserId(user_id);
	}
	
	/**
	 * 获取专家打分信息
	 * @param id
	 * @param role
	 * @return
	 */
	public List<ExpertScore> gExpertScore(Integer id){
		return zhichengDao.getExpertScore(id);
	}
//	管理员获取所有投票详情
	
	public List<ExpertVote> gExpertVote(Integer id){
		return zhichengDao.getExpertVote(id);
	}
//	复审专家获取自己投票
	public ExpertVote getByExpertId( int expert_id ,int apply_id){
		return zhichengDao.getByExpertId(expert_id,apply_id);
	}
	
	public boolean updateVote(ExpertVote expertScore){
		return zhichengDao.updateVote(expertScore);
	}
	
	public boolean insertVote(ExpertVote expertScore){
		return zhichengDao.insertVote(expertScore);
		}
}
