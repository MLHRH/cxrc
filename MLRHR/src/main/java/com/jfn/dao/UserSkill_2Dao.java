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

import com.jfn.entity.UserSkill_2;

/**
 * @create-time 2014-8-18 下午6:10:27
 * @author 佟德慧
 * @remarks 无
 */
@Repository
public class UserSkill_2Dao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String SQL_INSERT_user_skill_2 = "insert into user_skill_2(user_id,start_date,project_name,jiaose,work_content,project_result,jine,laiyuan,end_date) values(?,?,?,?,?,?,?,?,?)";

	private final String SQL_Get_BY_ID = "select * from user_skill_2 where Id=?";
	private final String SQL_GET_user_skill_2_LIST = "select * from user_skill_2 order by Id  ";
	private final String SQL_SET_user_skill_2_UPDATE = "update user_skill_2 set user_id=?,start_date=?,project_name=?,jiaose=?,work_content=?,project_result=?,jine=?,laiyuan=?,end_date=? where id=?";

	private final static String SQL_DEL_BY_ID = "delete from user_skill_2 where id = ?";
	// 通过user_id查询
	private final String SQL_GET_LIST_BY_USER_ID = "select * from user_skill_2 where user_id=? order by start_date desc";

	public boolean insert(UserSkill_2 user_skill_2) {
		return jdbcTemplate.update(SQL_INSERT_user_skill_2, new Object[] { user_skill_2.getUser_id(), user_skill_2.getStart_date(), user_skill_2.getProject_name(), user_skill_2.getJiaose(),
				user_skill_2.getWork_content(), user_skill_2.getProject_result(), user_skill_2.getJine(), user_skill_2.getLaiyuan(), user_skill_2.getEnd_date() }) == 1;
	}

	public UserSkill_2 get(int id) {
		return jdbcTemplate.query(SQL_Get_BY_ID, new Object[] { id }, new ResultSetExtractor<UserSkill_2>() {
			@Override
			public UserSkill_2 extractData(ResultSet rs) throws SQLException, DataAccessException {
				UserSkill_2 user_skill_2 = new UserSkill_2();
				if (rs.next()) {
					user_skill_2.setId(rs.getInt("id"));
					user_skill_2.setUser_id(rs.getString("user_id"));

					String temp = rs.getString("start_date");
					if (temp != null) {
						String Year = temp.substring(0, 4);
						String Month = temp.substring(5, 7);
						String Day = temp.substring(8, 10);
						temp = Year + "." + Month + "." + Day;
					}
					user_skill_2.setStart_date(temp);

					user_skill_2.setProject_name(rs.getString("project_name"));
					user_skill_2.setJiaose(rs.getString("jiaose"));
					user_skill_2.setWork_content(rs.getString("work_content"));
					user_skill_2.setProject_result(rs.getString("project_result"));
					user_skill_2.setJine(rs.getString("jine"));
					user_skill_2.setLaiyuan(rs.getString("laiyuan"));

					temp = rs.getString("end_date");
					if (temp != null) {
						String Year = temp.substring(0, 4);
						String Month = temp.substring(5, 7);
						String Day = temp.substring(8, 10);
						temp = Year + "." + Month + "." + Day;
					}
					user_skill_2.setEnd_date(temp);

				}
				return user_skill_2;
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

	public boolean Update(UserSkill_2 user_skill_2) {
		Object[] params = new Object[] { user_skill_2.getUser_id(), user_skill_2.getStart_date(), user_skill_2.getProject_name(), user_skill_2.getJiaose(), user_skill_2.getWork_content(),
				user_skill_2.getProject_result(), user_skill_2.getJine(), user_skill_2.getLaiyuan(), user_skill_2.getEnd_date(), user_skill_2.getId() };
		return jdbcTemplate.update(SQL_SET_user_skill_2_UPDATE, params) == 1;
	}

	public boolean delete(int id) {
		return jdbcTemplate.update(SQL_DEL_BY_ID, new Object[] { id }) == 1;
	}

	public boolean isPropertyUnique(String newLoginName, String oldLoginName) {
		return false;
	}

	public List<UserSkill_2> getAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(SQL_GET_user_skill_2_LIST, new user_skill_2RowMapper());
	}

	/**
	 * 定义内部类实现RowMapper接口
	 */
	public class user_skill_2RowMapper implements ParameterizedRowMapper<UserSkill_2> {
		// 实现mapRow方法
		@Override
		public UserSkill_2 mapRow(ResultSet rs, int num) throws SQLException {
			// 对类进行封装
			UserSkill_2 user_skill_2 = new UserSkill_2();
			user_skill_2.setId(rs.getInt("id"));
			user_skill_2.setUser_id(rs.getString("user_id"));

			String temp = rs.getString("start_date");
			if (temp != null) {
				String Year = temp.substring(0, 4);
				String Month = temp.substring(5, 7);
				String Day = temp.substring(8, 10);
				temp = Year + "." + Month + "." + Day;
			}
			user_skill_2.setStart_date(temp);

			user_skill_2.setProject_name(rs.getString("project_name"));
			user_skill_2.setJiaose(rs.getString("jiaose"));
			user_skill_2.setWork_content(rs.getString("work_content"));
			user_skill_2.setProject_result(rs.getString("project_result"));
			user_skill_2.setJine(rs.getString("jine"));
			user_skill_2.setLaiyuan(rs.getString("laiyuan"));

			temp = rs.getString("end_date");
			if (temp != null) {
				String Year = temp.substring(0, 4);
				String Month = temp.substring(5, 7);
				String Day = temp.substring(8, 10);
				temp = Year + "." + Month + "." + Day;
			}
			user_skill_2.setEnd_date(temp);

			return user_skill_2;
		}

	}

	// 通过user_id查询
	public List<UserSkill_2> getAllByUserId(String user_id) {
		return jdbcTemplate.query(SQL_GET_LIST_BY_USER_ID, new Object[] { user_id }, new user_skill_2RowMapper());
	}
}
