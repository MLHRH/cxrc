package com.jfn.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springside.modules.utils.web.ServletUtils;

import com.jfn.entity.Authority;
import com.jfn.entity.Role;
import com.jfn.entity.User;

/**
 * 实现SpringSecurity的UserDetailsService接口,实现获取用户Detail信息的回调函数.
 * 
 * @author calvin
 */
@Repository
public class UserDetailsServiceImpl implements UserDetailsService
{
	@Autowired
	private AccountManager accountManager;

	/**
	 * 获取用户Details信息的回调函数.
	 */
	@Override
	public UserDetails loadUserByUsername( String username )
			throws UsernameNotFoundException, DataAccessException
	{
		User user = accountManager.findUserByLoginName( username );
		if( user == null )
		{
			throw new UsernameNotFoundException( "User " + username
					+ " not exists." );
		}
		Set<GrantedAuthority> grantedAuths = obtainGrantedAuthorities( user );
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;

		UserDetails userdetails = new org.springframework.security.core.userdetails.User(
				user.getLoginName(), user.getPassword(), enabled,
				accountNonExpired, credentialsNonExpired, accountNonLocked,
				grantedAuths );

		return userdetails;
	}

	/**
	 * 获得用户所有角色的权限集合.
	 */
	private Set<GrantedAuthority> obtainGrantedAuthorities( User user )
	{
		Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();
		for( Authority authority : accountManager.getUserAuths( user ) )
		{
			authSet.add( new SimpleGrantedAuthority( authority
					.getPrefixedName() ) );
		}
		return authSet;
	}
}
