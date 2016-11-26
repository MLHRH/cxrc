package com.jfn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jfn.dao.ExpertScoreDao;
import com.jfn.entity.ExpertScore;
import com.jfn.entity.JcqnDoc01;
@Repository
public class ExpertScoreService {
@Autowired
private ExpertScoreDao expertScoreDao;

public boolean insert01(ExpertScore expertScore){
	return expertScoreDao.insert(expertScore);
	}
	
	public boolean update01(ExpertScore expertScore){
		return expertScoreDao.update(expertScore);
	}
	
//	public boolean delete01( int expert_id ){
//		return expertScoreDao.delete(expert_id);
//		
//	}
	public ExpertScore getByExpertId01( int expert_id ,int apply_id){
		return expertScoreDao.getByExpertId(expert_id,apply_id);
	}

}
