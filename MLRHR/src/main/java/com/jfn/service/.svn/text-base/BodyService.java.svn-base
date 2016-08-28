package com.jfn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jfn.dao.BodyDao;
import com.jfn.entity.Body;

/**
 * @create-time 2014-8-8 下午9:07:25
 * @creator     佟德慧
 */
@Repository
public class BodyService {
	
	private static final Logger log = LoggerFactory.getLogger( BodyService.class );
	@Autowired
	private BodyDao bodyDao;
	
	public List<Body> getAll()
	{
		return bodyDao.getAll();
	}
	

	public Body getById(String bodyId) {
		// TODO Auto-generated method stub
		return bodyDao.get(Integer.parseInt(bodyId));
	}

	public boolean bodyInsert(Body entity) {
		// TODO Auto-generated method stub
		return bodyDao.insert(entity);
	}

	public boolean bodyUpdate(Body entity) {
		// TODO Auto-generated method stub
		return bodyDao.Update(entity);
	}

	public boolean deletebody(String bodyId) {
		// TODO Auto-generated method stub
		return bodyDao.delete(Integer.parseInt(bodyId));
	}
	
	

}
