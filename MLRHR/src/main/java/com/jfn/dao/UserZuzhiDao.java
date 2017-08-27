package com.jfn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.stereotype.Repository;

import com.jfn.entity.UesrZuzhi;

@Repository
public class UserZuzhiDao {
	private static final String SQL_GET_LIST_BY_USER_ID = "select * from user_zuzhi where user_id=?";
	private  final String SQL_SET_user_zuzhi_UPDATE = "update user_zuzhi set user_id=?,zuzhi_job=?,zuzhi_name=?,zuzhi_renqi=? where id=?";
	private  final String SQL_INSERT_user_zuzhi = "insert into user_zuzhi(user_id,zuzhi_job,zuzhi_name,zuzhi_renqi) values(?,?,?,?)";
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public boolean zuzhiInsert(UesrZuzhi uesrZuzhi) {
		return jdbcTemplate.update(SQL_INSERT_user_zuzhi,
				new Object[] { uesrZuzhi.getUser_id(), uesrZuzhi.getZuzhi_job(), uesrZuzhi.getZuzhi_name(), uesrZuzhi.getZuzhi_renqi()}) == 1;
	}

	public boolean zuzhiUpdate(UesrZuzhi uesrZuzhi) {

		Object[] params = new Object[] { uesrZuzhi.getUser_id(),uesrZuzhi.getZuzhi_job(), uesrZuzhi.getZuzhi_name(), uesrZuzhi.getZuzhi_renqi(), uesrZuzhi.getId() };
		return jdbcTemplate.update(SQL_SET_user_zuzhi_UPDATE, params) == 1;
	
	}

	public List<UesrZuzhi> getAllByUserId(String user_id) {
		return jdbcTemplate.query(SQL_GET_LIST_BY_USER_ID, new Object[] { user_id }, new user_zuzhiRowMapper());

	}
	
	/**
	 * 定义内部类实现RowMapper接口
	 */
	public class user_zuzhiRowMapper implements ParameterizedRowMapper<UesrZuzhi> {
		// 实现mapRow方法
		@Override
		public UesrZuzhi mapRow(ResultSet rs, int num) throws SQLException {
			// 对类进行封装
			UesrZuzhi uesrZuzhi = new UesrZuzhi();
			uesrZuzhi.setId(rs.getInt("id"));
			uesrZuzhi.setUser_id(rs.getInt("user_id"));
			uesrZuzhi.setZuzhi_job(rs.getString("zuzhi_job"));
			uesrZuzhi.setZuzhi_name(rs.getString("zuzhi_name"));
			uesrZuzhi.setZuzhi_renqi(rs.getString("zuzhi_renqi"));
			return uesrZuzhi;
		}
	}
}
