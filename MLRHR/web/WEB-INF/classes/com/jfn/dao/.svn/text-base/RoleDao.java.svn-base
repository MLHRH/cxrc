package com.jfn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.stereotype.Repository;

import com.jfn.entity.Authority;
import com.jfn.entity.Role;

/**
 * 角色对象的泛型DAO.
 * 
 * @author calvin
 */
@Repository
public class RoleDao
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private final static String SQL_DEL = "delete from acct_role where id = ?";
	private final static String SQL_Get_BY_ID = "select * from acct_role where Id=?";
	private final static String GET_ALL = "select * from acct_role";
	private final static String GET_BY_USER = "select DISTINCT aa.name,aa.id from acct_user_role aur,acct_role_authority ara,acct_authority aa where aur.user_id=? and aur.role_id=ara.role_id and ara.authority_id=aa.id";
	private final String SQL_INSERT_ROLE = "insert into acct_role(name) values(?)";
	private final String SQL_ROLE_TOTAL = "select count(*) from acct_role";

	//chenz
	private final String SQL_GET_ROLE_BY_Name = "select * from acct_role where name=?";
	
	public boolean delete( int id )
	{
		return jdbcTemplate.update( SQL_DEL, new Object[]{ id} ) == 1;
	}

	public void deleteRoles( int[] ids )
	{
		for( int id : ids )
		{
			jdbcTemplate.update( SQL_DEL, new Object[]{ id} );
		}
	}

	public Role get( int id )
	{
		return jdbcTemplate.query( SQL_Get_BY_ID, new Object[]{ id},
				new ResultSetExtractor<Role>()
				{
					@Override
					public Role extractData( ResultSet rs )
							throws SQLException, DataAccessException
					{
						Role role = new Role();
						if( rs.next() )
						{
							role.setId( rs.getInt( "id" ) );
							role.setName( rs.getString( "name" ) );
						}
						return role;
					}
				} );
	}
	
	public Role getByName( String name )
	{
		return jdbcTemplate.query( SQL_GET_ROLE_BY_Name, new Object[]{ name},
				new ResultSetExtractor<Role>()
				{
					@Override
					public Role extractData( ResultSet rs )
							throws SQLException, DataAccessException
					{
						Role role = new Role();
						if( rs.next() )
						{
							role.setId( rs.getInt( "id" ) );
							role.setName( rs.getString( "name" ) );
						}
						return role;
					}
				} );
	}

	public List<Role> getAll()
	{
		return jdbcTemplate.query( GET_ALL, new ParameterizedRowMapper<Role>()
		{
			@Override
			public Role mapRow( ResultSet rs, int i ) throws SQLException
			{
				Role role = new Role();
				role.setId( rs.getInt( "id" ) );
				role.setName( rs.getString( "name" ) );
				return role;
			}
		} );
	}

	public boolean save( Role role )
	{
		return jdbcTemplate.update( SQL_INSERT_ROLE,
				new Object[]{ role.getName()} ) == 1;
	}

	public int getRoleCount()
	{
		return 0;
	}
	
	public List<Authority> getUserAuths( int userid )
	{
		return jdbcTemplate.query( GET_BY_USER, new Object[]{ userid},
				new ParameterizedRowMapper<Authority>()
				{
					@Override
					public Authority mapRow( ResultSet rs, int arg1 )
							throws SQLException
					{
						return new Authority( rs.getInt( 2 ), rs.getString( 1 ) );
					}

				} );
	}
}
