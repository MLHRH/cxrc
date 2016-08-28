package com.jfn.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jfn.dao.RoleDao;
import com.jfn.dao.UserBaseInforDao;
import com.jfn.entity.Role;
import com.jfn.entity.User;
import com.jfn.entity.UserBaseInfor;

@Repository
public class UserBaseInforService
{
	private static final Logger log = LoggerFactory
			.getLogger( UserBaseInforService.class );
	@Autowired
	private UserBaseInforDao userBaseInforDao;

	@Autowired
	private RoleDao roleDao;

	
	
	public List<UserBaseInfor> getAll()
	{
		return userBaseInforDao.getAll();
	}
	

	public UserBaseInfor getById( String userBaseInforId )
	{
		return userBaseInforDao.get( Integer.parseInt( userBaseInforId ) );
	}
	
	public UserBaseInfor getByUserId( String userBaseInforId )
	{
		return userBaseInforDao.getByUserId( Integer.parseInt( userBaseInforId ) );
	}
	public boolean userBaseInforInsert( UserBaseInfor entity )
	{
		return userBaseInforDao.insert( entity );
	}

	public boolean deleteUserBaseInfor( String userBaseInforId )
	{
		return userBaseInforDao.delete( Integer.parseInt( userBaseInforId ) );
	}

	//完善个人信息（不修改login_name,login_pwd）
	public boolean userBaseInforUpdateDetail( UserBaseInfor entity )
	{
		return userBaseInforDao.UpdateDetail( entity );
	}
}
