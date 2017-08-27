package com.jfn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.stereotype.Repository;

import com.jfn.entity.Authority;


/**
 * 授权对象的泛型DAO.
 * 
 * @author calvin
 */
@Repository
public class AuthorityDao 
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private final static String GET_ALL="select * from acct_authority";
	
	public List<Authority> getAll() {
		return jdbcTemplate.query(GET_ALL,
				new ParameterizedRowMapper<Authority>() {
					@Override
					public Authority mapRow(ResultSet rs, int i)
							throws SQLException {
						Authority authority = new Authority();
						authority.setId(rs.getInt("id"));
						authority.setName(rs.getString("name"));
						authority.setUrl(rs.getString("url"));
						return authority;

					}
				});
	}
}
