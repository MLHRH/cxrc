package com.jfn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.stereotype.Repository;

import com.jfn.entity.UserWork;

/**
 * @create-time 2014-8-18 下午6:18:40
 * @author 佟德慧
 * @remarks 无
 */
@Repository
public class UserWorkDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String SQL_INSERT_user_work = "insert into user_work(user_id,start_date,country,work_content,zhiwu,end_date) values(?,?,?,?,?,?)";

	private final String SQL_Get_BY_ID = "select * from user_work where Id=?";
	private final String SQL_GET_user_work_LIST = "select * from user_work order by Id  ";
	private final String SQL_SET_user_work_UPDATE = "update user_work set user_id=?,start_date=?,country=?,work_content=?,zhiwu=?,end_date=? where id=?";

	private final static String SQL_DEL_BY_ID = "delete from user_work where id = ?";
	// 通过user_id查询
	private final String SQL_GET_LIST_BY_USER_ID = "select * from user_work where user_id=?  order by start_date desc ";

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");

	public boolean insert(UserWork user_work) {
	
			return jdbcTemplate.update(SQL_INSERT_user_work,
					new Object[] { user_work.getUser_id(), user_work.getStart_date(), user_work.getCountry(),
							user_work.getWork_content(), user_work.getZhiwu(), user_work.getEnd_date()
							 }) == 1;

	}

	public UserWork get(int id) {
		return jdbcTemplate.query(SQL_Get_BY_ID, new Object[] { id }, new ResultSetExtractor<UserWork>() {
			@Override
			public UserWork extractData(ResultSet rs) throws SQLException, DataAccessException {
				UserWork user_work = new UserWork();
				if (rs.next()) {
					user_work.setId(rs.getInt("id"));
					user_work.setUser_id(rs.getString("user_id"));
					user_work.setStart_date(rs.getString("start_date"));
					user_work.setCountry(rs.getString("country"));
					user_work.setWork_content(rs.getString("work_content"));
					user_work.setZhiwu(rs.getString("zhiwu"));
					user_work.setEnd_date(rs.getString("end_date"));

				}
				return user_work;
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

	public boolean Update(UserWork user_work) {
		
			Object[] params = new Object[] { user_work.getUser_id(), user_work.getStart_date(),

					user_work.getCountry(), user_work.getWork_content(), user_work.getZhiwu(),
					user_work.getEnd_date(),  user_work.getId() };
			return jdbcTemplate.update(SQL_SET_user_work_UPDATE, params) == 1;


	}

	public boolean delete(int id) {
		return jdbcTemplate.update(SQL_DEL_BY_ID, new Object[] { id }) == 1;
	}

	public boolean isPropertyUnique(String newLoginName, String oldLoginName) {
		return false;
	}

	public List<UserWork> getAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(SQL_GET_user_work_LIST, new user_workRowMapper());
	}

	/**
	 * 定义内部类实现RowMapper接口
	 */
	public class user_workRowMapper implements ParameterizedRowMapper<UserWork> {
		// 实现mapRow方法
		@Override
		public UserWork mapRow(ResultSet rs, int num) throws SQLException {
			// 对类进行封装
			UserWork user_work = new UserWork();
			user_work.setId(rs.getInt("id"));
			user_work.setUser_id(rs.getString("user_id"));
			user_work.setStart_date(rs.getString("start_date"));
			user_work.setCountry(rs.getString("country"));
			user_work.setWork_content(rs.getString("work_content"));
			user_work.setZhiwu(rs.getString("zhiwu"));
			user_work.setEnd_date(rs.getString("end_date"));
			return user_work;
		}
	}

	// 通过user_id查询
	public List<UserWork> getAllByUserId(String user_id) {
		return jdbcTemplate.query(SQL_GET_LIST_BY_USER_ID, new Object[] { user_id }, new user_workRowMapper());
	}
}
