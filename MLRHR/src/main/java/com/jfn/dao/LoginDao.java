package com.jfn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.stereotype.Repository;

import com.jfn.entity.LoginUser;

@Repository
public class LoginDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private final String SQL_GETPWD = "select email from acct_user where email=? and login_name=?";

	private final String SQL_LOGIN = "select * from login where login_name=? and login_pwd=?";
	private final String SQL_CPW = "update login set login_pwd=? where login_name=?";

	public List<LoginUser> login(String login_name, String login_pwd) {
		return jdbcTemplate.query(SQL_LOGIN, new Object[] { login_name, login_pwd }, new ParameterizedRowMapper<LoginUser>() {
			@Override
			public LoginUser mapRow(ResultSet rs, int i) throws SQLException {
				LoginUser u = new LoginUser();
				u.setId(rs.getInt("id"));
				u.setLogin_name(rs.getString("login_name"));
				u.setLogin_pwd(rs.getString("login_pwd"));
				u.setUsername(rs.getString("username"));
				return u;
			}
		});
	}

	/**
	 * 判断身份验证是否通过，通过则向该用户发送找回密码邮件
	 * 
	 * @param bodyName
	 * @param username
	 * @param identification
	 * @return
	 */
	public List<String> checkGetPWD(String email, String username) {
		return jdbcTemplate.query(SQL_GETPWD, new Object[] { email, username }, new ParameterizedRowMapper<String>() {
			@Override
			public String mapRow(ResultSet res, int i) throws SQLException {
				String email = new String();
				email = res.getString("email");
				return email;
			}

		});
	}

	public boolean save(String login_name, String login_pwd) {
		return jdbcTemplate.update(SQL_CPW, new Object[] { login_pwd, login_name }) == 1;
	}
}
