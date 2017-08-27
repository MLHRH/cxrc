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

import com.jfn.entity.UserProject;

/**
 * @create-time 2014-8-18 下午6:10:27
 * @author 佟德慧
 * @remarks 无
 */
@Repository
public class UserProjectDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String SQL_INSERT_user_project = "insert into user_project(user_id,start_date,project_name,jiaose,work_content,project_result,jine,laiyuan,end_date) values(?,?,?,?,?,?,?,?,?)";

	private final String SQL_Get_BY_ID = "select * from user_project where Id=?";
	private final String SQL_GET_user_project_LIST = "select * from user_project order by Id  ";
	private final String SQL_SET_user_project_UPDATE = "update user_project set user_id=?,start_date=?,project_name=?,jiaose=?,work_content=?,project_result=?,jine=?,laiyuan=?,end_date=? where id=?";

	private final static String SQL_DEL_BY_ID = "delete from user_project where id = ?";
	// 通过user_id查询
	private final String SQL_GET_LIST_BY_USER_ID = "select * from user_project where user_id=? order by start_date desc";

	public boolean insert(UserProject user_project) {
		return jdbcTemplate.update(SQL_INSERT_user_project, new Object[] { user_project.getUser_id(), user_project.getStart_date(), user_project.getProject_name(), user_project.getJiaose(),
				user_project.getWork_content(), user_project.getProject_result(), user_project.getJine(), user_project.getLaiyuan(), user_project.getEnd_date() }) == 1;
	}

	public UserProject get(int id) {
		return jdbcTemplate.query(SQL_Get_BY_ID, new Object[] { id }, new ResultSetExtractor<UserProject>() {
			@Override
			public UserProject extractData(ResultSet rs) throws SQLException, DataAccessException {
				UserProject user_project = new UserProject();
				if (rs.next()) {
					user_project.setId(rs.getInt("id"));
					user_project.setUser_id(rs.getString("user_id"));

					String temp = rs.getString("start_date");
					if (temp != null) {
						String Year = temp.substring(0, 4);
						String Month = temp.substring(5, 7);
						String Day = temp.substring(8, 10);
						temp = Year + "." + Month + "." + Day;
					}
					user_project.setStart_date(temp);

					user_project.setProject_name(rs.getString("project_name"));
					user_project.setJiaose(rs.getString("jiaose"));
					user_project.setWork_content(rs.getString("work_content"));
					user_project.setProject_result(rs.getString("project_result"));
					user_project.setJine(rs.getString("jine"));
					user_project.setLaiyuan(rs.getString("laiyuan"));

					temp = rs.getString("end_date");
					if (temp != null) {
						String Year = temp.substring(0, 4);
						String Month = temp.substring(5, 7);
						String Day = temp.substring(8, 10);
						temp = Year + "." + Month + "." + Day;
					}
					user_project.setEnd_date(temp);

				}
				return user_project;
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

	public boolean Update(UserProject user_project) {
		Object[] params = new Object[] { user_project.getUser_id(), user_project.getStart_date(), user_project.getProject_name(), user_project.getJiaose(), user_project.getWork_content(),
				user_project.getProject_result(), user_project.getJine(), user_project.getLaiyuan(), user_project.getEnd_date(), user_project.getId() };
		return jdbcTemplate.update(SQL_SET_user_project_UPDATE, params) == 1;
	}

	public boolean delete(int id) {
		return jdbcTemplate.update(SQL_DEL_BY_ID, new Object[] { id }) == 1;
	}

	public boolean isPropertyUnique(String newLoginName, String oldLoginName) {
		return false;
	}

	public List<UserProject> getAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(SQL_GET_user_project_LIST, new user_projectRowMapper());
	}

	/**
	 * 定义内部类实现RowMapper接口
	 */
	public class user_projectRowMapper implements ParameterizedRowMapper<UserProject> {
		// 实现mapRow方法
		@Override
		public UserProject mapRow(ResultSet rs, int num) throws SQLException {
			// 对类进行封装
			UserProject user_project = new UserProject();
			user_project.setId(rs.getInt("id"));
			user_project.setUser_id(rs.getString("user_id"));

			String temp = rs.getString("start_date");
			if (temp != null) {
				String Year = temp.substring(0, 4);
				String Month = temp.substring(5, 7);
				String Day = temp.substring(8, 10);
				temp = Year + "." + Month + "." + Day;
			}
			user_project.setStart_date(temp);

			user_project.setProject_name(rs.getString("project_name"));
			user_project.setJiaose(rs.getString("jiaose"));
			user_project.setWork_content(rs.getString("work_content"));
			user_project.setProject_result(rs.getString("project_result"));
			user_project.setJine(rs.getString("jine"));
			user_project.setLaiyuan(rs.getString("laiyuan"));

			temp = rs.getString("end_date");
			if (temp != null) {
				String Year = temp.substring(0, 4);
				String Month = temp.substring(5, 7);
				String Day = temp.substring(8, 10);
				temp = Year + "." + Month + "." + Day;
			}
			user_project.setEnd_date(temp);

			return user_project;
		}

	}

	// 通过user_id查询
	public List<UserProject> getAllByUserId(String user_id) {
		return jdbcTemplate.query(SQL_GET_LIST_BY_USER_ID, new Object[] { user_id }, new user_projectRowMapper());
	}
}
