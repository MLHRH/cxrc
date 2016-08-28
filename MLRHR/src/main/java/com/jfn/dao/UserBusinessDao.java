package com.jfn.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.jfn.entity.UserBusiness;

/**
 * create_time 2014年11月13日 下午8:49:42
 * 
 * @author tongdehui
 *
 */
@Repository
public class UserBusinessDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String SQL_INSERT = "insert into user_business(user_id,autobiography,chuangxin,yijian_1,yijian_2,yijian_3,fuzeren_1,fuzeren_2,fuzeren_3,fengpi) values(?,?,?,?,?,?,?,?,?,?)";
	private final String SQL_Get_BY_ID = "select * from user_business where Id=?";
	private final String SQL_Get_BY_USERID = "select * from user_business where user_id=?  order by id desc ";
	private final String SQL_SET_UPDATE = "update user_business set user_id=?,autobiography=?,chuangxin=?,yijian_1=? ,yijian_2=? ,yijian_3=?,fuzeren_1=? ,fuzeren_2=? ,fuzeren_3=?,fengpi=? where id=?";
	private final String SQL_DEL_BY_ID = "delete from user_business where id = ?";

	public int newFile(final UserBusiness userbusiness) {
		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public java.sql.PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				java.sql.PreparedStatement ps = conn.prepareStatement(SQL_INSERT, new String[] {});

				ps = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
				ps.setInt(1, userbusiness.getUser_id());
				ps.setString(2, userbusiness.getAutobiography());
				ps.setString(3, userbusiness.getChuangxin());
				ps.setString(4, userbusiness.getYijian_1());
				ps.setString(5, userbusiness.getYijian_2());
				ps.setString(6, userbusiness.getYijian_3());
				ps.setString(7, userbusiness.getFuzeren_1());
				ps.setString(8, userbusiness.getFuzeren_2());
				ps.setString(9, userbusiness.getFuzeren_3());
				ps.setString(10, userbusiness.getFengpi());

				return ps;
			}
		}, keyHolder);
		return keyHolder.getKey().intValue();
	}

	public boolean insert(UserBusiness userbusiness) {
		return jdbcTemplate.update(
				SQL_INSERT,
				new Object[] { userbusiness.getUser_id(), userbusiness.getAutobiography(), userbusiness.getChuangxin(), userbusiness.getYijian_1(), userbusiness.getYijian_2(),
						userbusiness.getYijian_3(), userbusiness.getFuzeren_1(), userbusiness.getFuzeren_2(), userbusiness.getFuzeren_3(), userbusiness.getFengpi() }) == 1;
	}

	public UserBusiness getById(int id) {
		return jdbcTemplate.query(SQL_Get_BY_ID, new Object[] { id }, new ResultSetExtractor<UserBusiness>() {
			@Override
			public UserBusiness extractData(ResultSet rs) throws SQLException, DataAccessException {
				UserBusiness userbusiness = new UserBusiness();
				if (rs.next()) {
					userbusiness.setId(rs.getInt("id"));
					userbusiness.setUser_id(rs.getInt("user_id"));
					userbusiness.setAutobiography(rs.getString("autobiography"));
					userbusiness.setChuangxin(rs.getString("chuangxin"));
					userbusiness.setYijian_1(rs.getString("yijian_1"));
					userbusiness.setYijian_2(rs.getString("yijian_2"));
					userbusiness.setYijian_3(rs.getString("yijian_3"));
					userbusiness.setFuzeren_1(rs.getString("fuzeren_1"));
					userbusiness.setFuzeren_2(rs.getString("fuzeren_2"));
					userbusiness.setFuzeren_3(rs.getString("fuzeren_3"));
					userbusiness.setFengpi(rs.getString("fengpi"));
				}
				return userbusiness;
			}
		});
	}

	public UserBusiness getByUserId(int user_id) {
		return jdbcTemplate.query(SQL_Get_BY_USERID, new Object[] { user_id }, new ResultSetExtractor<UserBusiness>() {
			@Override
			public UserBusiness extractData(ResultSet rs) throws SQLException, DataAccessException {
				UserBusiness userbusiness = new UserBusiness();
				if (rs.next()) {
					userbusiness.setId(rs.getInt("id"));
					userbusiness.setUser_id(rs.getInt("user_id"));
					userbusiness.setAutobiography(rs.getString("autobiography"));
					userbusiness.setChuangxin(rs.getString("chuangxin"));
					userbusiness.setYijian_1(rs.getString("yijian_1"));
					userbusiness.setYijian_2(rs.getString("yijian_2"));
					userbusiness.setYijian_3(rs.getString("yijian_3"));
					userbusiness.setFuzeren_1(rs.getString("fuzeren_1"));
					userbusiness.setFuzeren_2(rs.getString("fuzeren_2"));
					userbusiness.setFuzeren_3(rs.getString("fuzeren_3"));
					userbusiness.setFengpi(rs.getString("fengpi"));
				}
				return userbusiness;
			}
		});
	}

	public boolean update(UserBusiness userbusiness) {
		Object[] params = new Object[] { userbusiness.getUser_id(), userbusiness.getAutobiography(), userbusiness.getChuangxin(), userbusiness.getYijian_1(), userbusiness.getYijian_2(),
				userbusiness.getYijian_3(), userbusiness.getFuzeren_1(), userbusiness.getFuzeren_2(), userbusiness.getFuzeren_3(), userbusiness.getFengpi(), userbusiness.getId() };
		return jdbcTemplate.update(SQL_SET_UPDATE, params) == 1;
	}

	public boolean delete(int id) {
		return jdbcTemplate.update(SQL_DEL_BY_ID, new Object[] { id }) == 1;
	}

	/**
	 * 定义内部类实现RowMapper接口
	 */
	public class userbusinessRowMapper implements ParameterizedRowMapper<UserBusiness> {
		// 实现mapRow方法
		@Override
		public UserBusiness mapRow(ResultSet rs, int num) throws SQLException {
			// 对类进行封装
			UserBusiness userbusiness = new UserBusiness();
			userbusiness.setId(rs.getInt("id"));
			userbusiness.setUser_id(rs.getInt("user_id"));
			userbusiness.setAutobiography(rs.getString("autobiography"));
			userbusiness.setChuangxin(rs.getString("chuangxin"));
			userbusiness.setYijian_1(rs.getString("yijian_1"));
			userbusiness.setYijian_2(rs.getString("yijian_2"));
			userbusiness.setYijian_3(rs.getString("yijian_3"));
			userbusiness.setFuzeren_1(rs.getString("fuzeren_1"));
			userbusiness.setFuzeren_2(rs.getString("fuzeren_2"));
			userbusiness.setFuzeren_3(rs.getString("fuzeren_3"));
			userbusiness.setFengpi(rs.getString("fengpi"));

			return userbusiness;
		}
	}
}
