package com.jfn.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springside.modules.utils.MD5Utils;

import com.jfn.dao.AuthorityDao;
import com.jfn.dao.RoleDao;
import com.jfn.dao.UserDao;
import com.jfn.entity.Authority;
import com.jfn.entity.Role;
import com.jfn.entity.User;



/**
 * 安全相关实体的管理类, 包括用户,角色,资源与授权类.
 * 
 * @author calvin
 */
@Repository
public class AccountManager
{
	private static Logger logger = LoggerFactory
			.getLogger( AccountManager.class );
	@Autowired
	private UserDao userDao;
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private AuthorityDao authorityDao;
	
	public List<Authority> getUserAuths(User user)
	{
		return roleDao.getUserAuths( user.getId() );
	}

	public User getUser( int id )
	{
		return userDao.get( id );
	}
	
	public void saveUser(User entity )
	{
		// 使用Md5加密
		String password = MD5Utils.PasswordEncryptByMD5( entity
				.getPassword() );
		userDao.save( entity.getLoginName(), password);
	}

	/**
	 * 删除用户,如果尝试删除超级管理员将抛出异常.
	 */
	public void deleteUser( int id )
	{
		userDao.delete( id );
	}

	public User findUserByLoginName(String login_name)
	{
		return userDao.getByLoginName(login_name);
	}
	
	/**
	 * 删除用户(批量)
	 * 
	 * @param ids
	 */
	public void deleteUsers( int[] ids )
	{
		for( int id : ids )
		{
			deleteUser( id );
		}
	}

	/**
	 * 判断是否超级管理员.
	 */
	public boolean isSupervisor( int id )
	{
		return id == 1;
	}

	/**
	 * 检查用户名是否唯一.
	 * 
	 * @return loginName在数据库中唯一或等于oldLoginName时返回true.
	 */
	@Transactional(readOnly = true)
	public boolean isLoginNameUnique( String newLoginName, String oldLoginName )
	{
		return userDao.isPropertyUnique(newLoginName,oldLoginName );
	}

	// -- Role Manager --//
	public Role getRole( int id )
	{
		return roleDao.get( id );
	}

	public List<Role> getAllRole()
	{
		return roleDao.getAll();
	}

	public void saveRole( Role entity )
	{
		roleDao.save( entity );
	}

	public void deleteRole( int id )
	{
		roleDao.delete( id );
	}

	public void deleteRoles( int[] ids )
	{
		roleDao.deleteRoles(ids);
	}

	// -- Authority Manager --//
	public List<Authority> getAllAuthority()
	{
		return authorityDao.getAll();
	}

	/**
	 * 根据用户获取全部菜单(功能树形菜单展示使用)
	 * 
	 * @author figo1117
	 * @param user
	 * @return
	 */
	public Set<Authority> getUserAuthor( User user )
	{
		Set<Authority> authoritySet = new LinkedHashSet<Authority>();
		List<Role> roleList = user.getRoleList();
		for( Role role : roleList )
		{
			List<Authority> authorList = role.getAuthorityList();
			for( Authority authority : authorList )
			{
				authoritySet.add( authority );
			}
		}
		return authoritySet;
	}

	/**
	 * 获取全部菜单，角色已有菜单checked置true(修改角色权限时使用)
	 * 
	 * @author figo1117
	 * @param user
	 * @return
	 */
	public List<Authority> getRoleCheckedAuthor( Role role )
	{
		List<Authority> allAuthorityList = getAllAuthority();
		List<Authority> checkedAuthorList = role.getAuthorityList();
		for( Authority authority : allAuthorityList )
		{
			if( checkedAuthorList.contains( authority ) )
			{
				authority.setChecked( "true" );
				checkedAuthorList.remove( authority );
			}
			else
			{
				authority.setChecked( "false" );
			}
		}
		return allAuthorityList;

	}

	/**
	 * 根据用户获取菜单
	 * 
	 * @author figo1117
	 * @param userDao
	 */
	public List<Authority> getAuthorityByUser( User user )
	{
		List<Role> roleList = user.getRoleList();
		List<Authority> authorityList = new ArrayList<Authority>();
		List<Authority> topAuthorList = new ArrayList<Authority>();
		Set<Authority> authoritySet = new LinkedHashSet<Authority>();

		for( Role role : roleList )
		{
			List<Authority> authorList = role.getAuthorityList();
			for( Authority authority : authorList )
			{
				authoritySet.add( authority );	
			}
		}

		// 为顶级菜单添加子菜单
		for( Authority topAuth : topAuthorList )
		{
			authorityList.add( topAuth );
		}
		Collections.sort( authorityList );

		return authorityList;

	}

	/**
	 * 获取用户总记录数
	 * 
	 * @param userDao
	 * @author figo1117
	 */
	public int getUserTotalCount()
	{
		return this.userDao.getUserCount();
	}

	public long getRoleTotalCount()
	{
		return this.roleDao.getRoleCount();

	}

	public User findUserByName(String name) {
		// TODO Auto-generated method stub
		return userDao.findUserByName(name);
	}

	public List<Role> getUserRole(Integer userid) {
		// TODO Auto-generated method stub
		
		return userDao.getUserRole(userid);
	}
}
