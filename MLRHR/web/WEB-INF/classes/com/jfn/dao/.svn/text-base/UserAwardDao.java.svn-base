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

import com.jfn.entity.UserAward;

/**
 * @create-time 2014-8-17 下午4:04:22
 * @author 佟德慧
 * @remarks 无
 */
@Repository
public class UserAwardDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String SQL_INSERT_user_award = "insert into user_award(user_id,name,date,other,jiaose,type) values(?,?,?,?,?,?)";

	private final String SQL_Get_BY_ID = "select * from user_award where Id=?";
	private final String SQL_GET_user_award_LIST = "select * from user_award order by Id  ";
	private final String SQL_SET_user_award_UPDATE = "update user_award set user_id=?,name=?,date=?,other=?,jiaose=?,type=? where id=?";

	private final static String SQL_DEL_BY_ID = "delete from user_award where id = ?";
	// 通过user_id查询
	private final String SQL_GET_LIST_BY_USER_ID = "select * from user_award where user_id=?";

	public boolean insert(UserAward user_award) {
		return jdbcTemplate.update(SQL_INSERT_user_award,
				new Object[] { user_award.getUser_id(), user_award.getName(), user_award.getDate(), user_award.getOther(), user_award.getJiaose(), user_award.getType() }) == 1;
	}

	public UserAward get(int id) {
		return jdbcTemplate.query(SQL_Get_BY_ID, new Object[] { id }, new ResultSetExtractor<UserAward>() {
			@Override
			public UserAward extractData(ResultSet rs) throws SQLException, DataAccessException {
				UserAward user_award = new UserAward();
				if (rs.next()) {
					user_award.setId(rs.getInt("id"));
					user_award.setUser_id(rs.getString("user_id"));
					user_award.setName(rs.getString("name"));

					String temp = rs.getString("date");
					if (temp != null) {
						String Year = temp.substring(0, 4);
						String Month = temp.substring(5, 7);
						String Day = temp.substring(8, 10);
						temp = Year + "." + Month + "." + Day;
					}
					user_award.setDate(temp);

					user_award.setOther(rs.getString("other"));
					user_award.setJiaose(rs.getString("jiaose"));
					user_award.setType(rs.getString("type"));

				}
				return user_award;
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

	public boolean Update(UserAward user_award) {
		Object[] params = new Object[] { user_award.getUser_id(), user_award.getName(), user_award.getDate(), user_award.getOther(), user_award.getJiaose(), user_award.getType(), user_award.getId() };
		return jdbcTemplate.update(SQL_SET_user_award_UPDATE, params) == 1;
	}

	public boolean delete(int id) {
		return jdbcTemplate.update(SQL_DEL_BY_ID, new Object[] { id }) == 1;
	}

	public boolean isPropertyUnique(String newLoginName, String oldLoginName) {
		return false;
	}

	public List<UserAward> getAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(SQL_GET_user_award_LIST, new user_awardRowMapper());
	}

	/**
	 * 定义内部类实现RowMapper接口
	 */
	public class user_awardRowMapper implements ParameterizedRowMapper<UserAward> {
		// 实现mapRow方法
		@Override
		public UserAward mapRow(ResultSet rs, int num) throws SQLException {
			// 对类进行封装
			UserAward user_award = new UserAward();
			user_award.setId(rs.getInt("id"));
			user_award.setUser_id(rs.getString("user_id"));
			user_award.setName(rs.getString("name"));

			String temp = rs.getString("date");
			if (temp != null) {
				String Year = temp.substring(0, 4);
				String Month = temp.substring(5, 7);
				String Day = temp.substring(8, 10);
				temp = Year + "." + Month + "." + Day;
			}
			user_award.setDate(temp);

			user_award.setOther(rs.getString("other"));
			user_award.setJiaose(rs.getString("jiaose"));
			user_award.setType(rs.getString("type"));
			return user_award;
		}
	}

	// 通过user_id查询
	public List<UserAward> getAllByUserId(String user_id) {
		return jdbcTemplate.query(SQL_GET_LIST_BY_USER_ID, new Object[] { user_id }, new user_awardRowMapper());
	}
}
