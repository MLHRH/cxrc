package com.jfn.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jfn.dao.RoleDao;
import com.jfn.dao.UserDao;
import com.jfn.entity.LoginUser;
import com.jfn.entity.Role;
import com.jfn.entity.User;

@Repository
public class UserService
{
	private static final Logger log = LoggerFactory
			.getLogger( UserService.class );
	@Autowired
	private UserDao userDao;

	@Autowired
	private RoleDao roleDao;

	
	public void addUser( LoginUser user )
	{
		if( !userDao.add( user ) )
		{
			log.error( "create user error..." );
		}
	}
	
	public List<User> getAll()
	{
		return userDao.getAll();
	}
	

	public User getById( String userId )
	{
		return userDao.get( Integer.parseInt( userId ) );
	}

	

	public boolean userInsert( User entity )
	{
		return userDao.insert( entity );
	}

	public boolean checkUsernameExists( String username )
	{
		return userDao.checkUsernameExists( username );
	}

	public boolean userUpdate( User entity )
	{
		return userDao.Update( entity );
	}

	public boolean deleteUser( String userId )
	{
		userDao.deleteUserRole( Integer.parseInt( userId ) );
		return userDao.delete( Integer.parseInt( userId ) );
	}

	//完善个人信息（不修改login_name,login_pwd）
	public boolean userUpdateDetail( User entity )
	{
		return userDao.UpdateDetail( entity );
	}
	//通过body_id查询user
	public List<User> getAllByBodyId(String body_id)
	{
		return userDao.getAllByBodyId(body_id);
	}
	public boolean regUser(String j_username, String j_idnum, String j_email,String j_body,
			String j_password) {
		return userDao.regUser( j_username, j_idnum,j_email,j_body,j_password);
		
	}

	public User getUserIdByLoginName(String j_email) {
		// TODO Auto-generated method stub
		return userDao.getByLoginName(j_email);
	}

	public boolean setRight(Integer id, String rolename) {
		// TODO Auto-generated method stub
		Role role = roleDao.getByName(rolename);
		return userDao.setRight( id,role.getId() );
		
	}
	public List<Role> getUserRole(Integer userid)
	{
		return userDao.getUserRole(userid);
	}

}
