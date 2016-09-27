package com.jfn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jfn.dao.ZhichengApplyDao;
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


}
