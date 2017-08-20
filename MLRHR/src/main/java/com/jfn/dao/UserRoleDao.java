package com.jfn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.jfn.entity.AcctUserRole;
import com.jfn.entity.UserExam;
@Repository
public class UserRoleDao {
	private static final String SQL_Get_BY_USER_ID = "select * from acct_user_role where user_id=?";
	private final String SQL_UPDATE_USER_ROLE = "update acct_user_role set role_id = ?  where user_id = ?";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public AcctUserRole getByUserId(Integer user_id) {

		return jdbcTemplate.query(SQL_Get_BY_USER_ID, new Object[] { user_id }, new ResultSetExtractor<AcctUserRole>() {
			@Override
			public AcctUserRole extractData(ResultSet rs) throws SQLException, DataAccessException {
				AcctUserRole role = new AcctUserRole();
				if (rs.next()) {
					role.setId(rs.getInt("id"));
					role.setRole_id(rs.getInt("role_id"));
					role.setUser_id(rs.getInt("user_id"));
				}
				return role;
			}
		});
	
	}

	public boolean update(Integer role_id, int user_id) {
		Object [] params = new Object[]{role_id,user_id};
		return jdbcTemplate.update(SQL_UPDATE_USER_ROLE, params) == 1;
		
	}
}
