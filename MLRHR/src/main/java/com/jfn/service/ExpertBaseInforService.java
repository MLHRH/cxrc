package com.jfn.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jfn.dao.ExpertBaseInforDao;
import com.jfn.dao.RoleDao;
import com.jfn.dao.UserBaseInforDao;
import com.jfn.entity.ExpertBaseInfor;
import com.jfn.entity.Role;
import com.jfn.entity.User;
import com.jfn.entity.UserBaseInfor;

@Repository
public class ExpertBaseInforService
{
	private static final Logger log = LoggerFactory
			.getLogger( ExpertBaseInforService.class );
	@Autowired
	private ExpertBaseInforDao expertBaseInforDao;

	@Autowired
	private RoleDao roleDao;

	
	
	public List<ExpertBaseInfor> getAll()
	{
		return expertBaseInforDao.getAll();
	}
	

	public ExpertBaseInfor getById( String userBaseInforId )
	{
		return expertBaseInforDao.get( Integer.parseInt( userBaseInforId ) );
	}
	
	public ExpertBaseInfor getByUserId( String userBaseInforId )
	{
		return expertBaseInforDao.getByUserId( Integer.parseInt( userBaseInforId ) );
	}
	public boolean userBaseInforInsert( ExpertBaseInfor entity )
	{
		return expertBaseInforDao.insert( entity );
	}

	public boolean deleteUserBaseInfor( String userBaseInforId )
	{
		return expertBaseInforDao.delete( Integer.parseInt( userBaseInforId ) );
	}

	//完善个人信息（不修改login_name,login_pwd）
	public boolean userBaseInforUpdateDetail( ExpertBaseInfor entity )
	{
		return expertBaseInforDao.UpdateDetail( entity );
	}
}
