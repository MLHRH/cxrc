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

import com.jfn.entity.UserSkill;

/**
 * @create-time 2014-8-18 下午6:10:27
 * @author 佟德慧
 * @remarks 无
 */
@Repository
public class UserSkillDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String SQL_INSERT_user_skill = "insert into user_skill(user_id,start_date,project_name,jiaose,project_result,end_date) values(?,?,?,?,?,?)";

	private final String SQL_Get_BY_ID = "select * from user_skill where Id=?";
	private final String SQL_GET_user_skill_LIST = "select * from user_skill order by Id  ";
	private final String SQL_SET_user_skill_UPDATE = "update user_skill set user_id=?,start_date=?,project_name=?,jiaose=?,project_result=?,end_date=? where id=?";

	private final static String SQL_DEL_BY_ID = "delete from user_skill where id = ?";
	// 通过user_id查询
	private final String SQL_GET_LIST_BY_USER_ID = "select * from user_skill where user_id=? order by start_date desc";

	public boolean insert(UserSkill user_skill) {
		return jdbcTemplate.update(SQL_INSERT_user_skill,
				new Object[] { user_skill.getUser_id(), user_skill.getStart_date(), user_skill.getProject_name(), user_skill.getJiaose(), user_skill.getProject_result(),
						 user_skill.getEnd_date() }) == 1;
	}

	public UserSkill get(int id) {
		return jdbcTemplate.query(SQL_Get_BY_ID, new Object[] { id }, new ResultSetExtractor<UserSkill>() {
			@Override
			public UserSkill extractData(ResultSet rs) throws SQLException, DataAccessException {
				UserSkill user_skill = new UserSkill();
				if (rs.next()) {
					user_skill.setId(rs.getInt("id"));
					user_skill.setUser_id(rs.getString("user_id"));

					String temp = rs.getString("start_date");
					if (temp != null) {
						String Year = temp.substring(0, 4);
						String Month = temp.substring(5, 7);
						String Day = temp.substring(8, 10);
						temp = Year + "." + Month + "." + Day;
					}
					user_skill.setStart_date(temp);

					user_skill.setProject_name(rs.getString("project_name"));
					user_skill.setJiaose(rs.getString("jiaose"));
					
					user_skill.setProject_result(rs.getString("project_result"));
				

					temp = rs.getString("end_date");
					if (temp != null) {
						String Year = temp.substring(0, 4);
						String Month = temp.substring(5, 7);
						String Day = temp.substring(8, 10);
						temp = Year + "." + Month + "." + Day;
					}
					user_skill.setEnd_date(temp);

				}
				return user_skill;
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

	public boolean Update(UserSkill user_skill) {
		Object[] params = new Object[] { user_skill.getUser_id(), user_skill.getStart_date(), user_skill.getProject_name(), user_skill.getJiaose(), 
				user_skill.getProject_result(),  user_skill.getEnd_date(), user_skill.getId() };
		return jdbcTemplate.update(SQL_SET_user_skill_UPDATE, params) == 1;
	}

	public boolean delete(int id) {
		return jdbcTemplate.update(SQL_DEL_BY_ID, new Object[] { id }) == 1;
	}

	public boolean isPropertyUnique(String newLoginName, String oldLoginName) {
		return false;
	}

	public List<UserSkill> getAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(SQL_GET_user_skill_LIST, new user_skillRowMapper());
	}

	/**
	 * 定义内部类实现RowMapper接口
	 */
	public class user_skillRowMapper implements ParameterizedRowMapper<UserSkill> {
		// 实现mapRow方法
		@Override
		public UserSkill mapRow(ResultSet rs, int num) throws SQLException {
			// 对类进行封装
			UserSkill user_skill = new UserSkill();
			user_skill.setId(rs.getInt("id"));
			user_skill.setUser_id(rs.getString("user_id"));

			String temp = rs.getString("start_date");
			if (temp != null) {
				String Year = temp.substring(0, 4);
				String Month = temp.substring(5, 7);
				String Day = temp.substring(8, 10);
				temp = Year + "." + Month + "." + Day;
			}
			user_skill.setStart_date(temp);

			user_skill.setProject_name(rs.getString("project_name"));
			user_skill.setJiaose(rs.getString("jiaose"));
			user_skill.setProject_result(rs.getString("project_result"));
			

			temp = rs.getString("end_date");
			if (temp != null) {
				String Year = temp.substring(0, 4);
				String Month = temp.substring(5, 7);
				String Day = temp.substring(8, 10);
				temp = Year + "." + Month + "." + Day;
			}
			user_skill.setEnd_date(temp);

			return user_skill;
		}

	}

	// 通过user_id查询
	public List<UserSkill> getAllByUserId(String user_id) {
		return jdbcTemplate.query(SQL_GET_LIST_BY_USER_ID, new Object[] { user_id }, new user_skillRowMapper());
	}
}
