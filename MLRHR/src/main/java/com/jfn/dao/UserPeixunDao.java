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

import com.jfn.entity.UserPeixun;

/**
 * @create-time 2014-8-17 下午4:26:00
 * @author 佟德慧
 * @remarks 无
 */
@Repository
public class UserPeixunDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String SQL_INSERT_user_peixun = "insert into user_peixun(user_id,start_date,end_date,major,country,academy,xueli) values(?,?,?,?,?,?,?)";

	private final String SQL_Get_BY_ID = "select * from user_peixun where Id=?";
	private final String SQL_Get_BY_USERID = "select * from user_peixun where user_id=? order by end_date desc limit 1";
	private final String SQL_GET_user_peixun_LIST = "select * from user_peixun order by Id  ";
	private final String SQL_SET_user_peixun_UPDATE = "update user_peixun set user_id=?,start_date=?,end_date=?,major=?,country=?,academy=?,xueli=? where id=?";

	private final static String SQL_DEL_BY_ID = "delete from user_peixun where id = ?";
	// 通过user_id查询
	private final String SQL_GET_LIST_BY_USER_ID = "select * from user_peixun where user_id=?  order by start_date desc";

	public boolean insert(UserPeixun user_peixun) {
		return jdbcTemplate.update(SQL_INSERT_user_peixun,
				new Object[] { user_peixun.getUser_id(), user_peixun.getStart_date(), user_peixun.getEnd_date(), user_peixun.getMajor(), user_peixun.getCountry(),
						user_peixun.getAcademy(),  user_peixun.getXueli() }) == 1;
	}

	public UserPeixun get(int id) {
		return jdbcTemplate.query(SQL_Get_BY_ID, new Object[] { id }, new ResultSetExtractor<UserPeixun>() {
			@Override
			public UserPeixun extractData(ResultSet rs) throws SQLException, DataAccessException {
				UserPeixun user_peixun = new UserPeixun();
				if (rs.next()) {
					user_peixun.setId(rs.getInt("id"));
					user_peixun.setUser_id(rs.getString("user_id"));
					user_peixun.setStart_date(rs.getString("start_date"));
					user_peixun.setEnd_date(rs.getString("end_date"));
					user_peixun.setMajor(rs.getString("major"));
					user_peixun.setCountry(rs.getString("country"));
					user_peixun.setAcademy(rs.getString("academy"));
					user_peixun.setXueli(rs.getString("xueli"));
				}
				return user_peixun;
			}
		});
	}

	public UserPeixun getByUserId(int id) {
		return jdbcTemplate.query(SQL_Get_BY_USERID, new Object[] { id }, new ResultSetExtractor<UserPeixun>() {
			@Override
			public UserPeixun extractData(ResultSet rs) throws SQLException, DataAccessException {
				UserPeixun user_peixun = new UserPeixun();
				if (rs.next()) {
					user_peixun.setId(rs.getInt("id"));
					user_peixun.setUser_id(rs.getString("user_id"));
					user_peixun.setStart_date(rs.getString("start_date"));
					user_peixun.setEnd_date(rs.getString("end_date"));
					user_peixun.setMajor(rs.getString("major"));
					user_peixun.setCountry(rs.getString("country"));
					user_peixun.setAcademy(rs.getString("academy"));
					user_peixun.setXueli(rs.getString("xueli"));
				}
				return user_peixun;
			}
		});
	}

	/**
	 * 修改保存
	 * 
	 * @param request
	 * @param model
	 * @return
	 */

	public boolean Update(UserPeixun user_peixun) {
		Object[] params = new Object[] { user_peixun.getUser_id(), user_peixun.getStart_date(), user_peixun.getEnd_date(), user_peixun.getMajor(), user_peixun.getCountry(),
				 user_peixun.getAcademy(),  user_peixun.getXueli(), user_peixun.getId() };
		return jdbcTemplate.update(SQL_SET_user_peixun_UPDATE, params) == 1;
	}

	public boolean delete(int id) {
		return jdbcTemplate.update(SQL_DEL_BY_ID, new Object[] { id }) == 1;
	}

	public boolean isPropertyUnique(String newLoginName, String oldLoginName) {
		return false;
	}

	public List<UserPeixun> getAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(SQL_GET_user_peixun_LIST, new user_peixunRowMapper());
	}

	/**
	 * 定义内部类实现RowMapper接口
	 */
	public class user_peixunRowMapper implements ParameterizedRowMapper<UserPeixun> {
		// 实现mapRow方法
		@Override
		public UserPeixun mapRow(ResultSet rs, int num) throws SQLException {
			// 对类进行封装
			UserPeixun user_peixun = new UserPeixun();
			user_peixun.setId(rs.getInt("id"));
			user_peixun.setUser_id(rs.getString("user_id"));
			user_peixun.setStart_date(rs.getString("start_date"));
			user_peixun.setEnd_date(rs.getString("end_date"));
			user_peixun.setMajor(rs.getString("major"));
			user_peixun.setCountry(rs.getString("country"));
			user_peixun.setAcademy(rs.getString("academy"));
			user_peixun.setXueli(rs.getString("xueli"));
			return user_peixun;
		}
	}

	// 通过user_id查询
	public List<UserPeixun> getAllByUserId(String user_id) {
		return jdbcTemplate.query(SQL_GET_LIST_BY_USER_ID, new Object[] { user_id }, new user_peixunRowMapper());
	}
}
