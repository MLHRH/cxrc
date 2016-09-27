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

import com.jfn.entity.JcqnDoc02;
import com.jfn.entity.JcqnDocProject;


/**
 * @create-time 2014-8-18 下午6:10:27
 * @author 佟德慧
 * @remarks 无
 */
@Repository
public class UserProjectDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String SQL_INSERT_user_project = "insert into jcqn_doc02_01(xuhao_id,userId,entryName,projectNumber,funds,startStopTime,projectNature,role) values(?,?,?,?,?,?,?,?)";

	private final String SQL_Get_BY_ID = "select * from jcqn_doc02_01 where Id=?";
	private final String SQL_GET_user_project_LIST = "select * from jcqn_doc02_01 order by Id  ";
	private final String SQL_SET_user_project_UPDATE = "update jcqn_doc02_01 set xuhao_id=?,userId=?,entryName=?,projectNumber=?,funds=?,startStopTime=?,projectNature=?,role=? where id=?";

	private final static String SQL_DEL_BY_ID = "delete from jcqn_doc02_01 where id = ?";
	// 通过user_id查询
//	private final String SQL_GET_LIST_BY_USER_ID = "select * from jcqn_doc02_01 where user_id=? order by start_date desc";
	private final String SQL_GET_LIST_BY_USER_ID = "select * from jcqn_doc02_01 where userId=?";
	public boolean insert(JcqnDocProject user_project) {
		return jdbcTemplate.update(SQL_INSERT_user_project, new Object[] { user_project.getXuhao_id(),user_project.getUserId(), user_project.getEntryName(), user_project.getProjectNumber(),
				user_project.getFunds(), user_project.getStartStopTime(), user_project.getProjectNature(),user_project.getRole()}) == 1;
	}

	public JcqnDocProject get(int id) {
		return jdbcTemplate.query(SQL_Get_BY_ID, new Object[] { id }, new ResultSetExtractor<JcqnDocProject>() {
			@Override
			public JcqnDocProject extractData(ResultSet rs) throws SQLException, DataAccessException {
				JcqnDocProject user_project = new JcqnDocProject();
				if (rs.next()) {
					user_project.setXuhao_id(rs.getInt("xuhao_id"));
					user_project.setId(rs.getInt("id"));
					user_project.setUserId(rs.getInt("userId"));
                   user_project.setEntryName(rs.getString("entryName"));
                   user_project.setProjectNumber(rs.getString("projectNumber"));
                   user_project.setFunds(rs.getString("funds"));
                   user_project.setStartStopTime(rs.getString("startStopTime"));
                   user_project.setProjectNature(rs.getString("projectNature"));
                   user_project.setRole(rs.getString("role"));
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

	public boolean Update(JcqnDocProject user_project) {
		Object[] params = new Object[] { user_project.getXuhao_id(), user_project.getUserId(), user_project.getEntryName(), user_project.getProjectNumber(),
				user_project.getFunds(), user_project.getStartStopTime(), user_project.getProjectNature(),user_project.getRole(),user_project.getId() };
		return jdbcTemplate.update(SQL_SET_user_project_UPDATE, params) == 1;
	}

	public boolean delete(int id) {
		return jdbcTemplate.update(SQL_DEL_BY_ID, new Object[] { id }) == 1;
	}

	public boolean isPropertyUnique(String newLoginName, String oldLoginName) {
		return false;
	}

	public List<JcqnDocProject> getAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(SQL_GET_user_project_LIST, new user_projectRowMapper());
	}

	/**
	 * 定义内部类实现RowMapper接口
	 */
	public class user_projectRowMapper implements ParameterizedRowMapper<JcqnDocProject> {
		// 实现mapRow方法
		@Override
		public JcqnDocProject mapRow(ResultSet rs, int num) throws SQLException {
			// 对类进行封装
			JcqnDocProject user_project = new JcqnDocProject();
			user_project.setXuhao_id(rs.getInt("xuhao_id"));
			user_project.setId(rs.getInt("id"));
			user_project.setUserId(rs.getInt("userId"));
           user_project.setEntryName(rs.getString("entryName"));
           user_project.setProjectNumber(rs.getString("projectNumber"));
           user_project.setFunds(rs.getString("funds"));
           user_project.setStartStopTime(rs.getString("startStopTime"));
           user_project.setProjectNature(rs.getString("projectNature"));
           user_project.setRole(rs.getString("role"));
//			user_project.setId(rs.getInt("id"));
//			user_project.setUser_id(rs.getString("user_id"));
//
//			String temp = rs.getString("start_date");
//			if (temp != null) {
//				String Year = temp.substring(0, 4);
//				String Month = temp.substring(5, 7);
//				String Day = temp.substring(8, 10);
//				temp = Year + "." + Month + "." + Day;
//			}
//			user_project.setStart_date(temp);
//
//			user_project.setProject_name(rs.getString("project_name"));
//			user_project.setJiaose(rs.getString("jiaose"));
//			user_project.setWork_content(rs.getString("work_content"));
//			user_project.setProject_result(rs.getString("project_result"));
//			user_project.setJine(rs.getString("jine"));
//			user_project.setLaiyuan(rs.getString("laiyuan"));
//
//			temp = rs.getString("end_date");
//			if (temp != null) {
//				String Year = temp.substring(0, 4);
//				String Month = temp.substring(5, 7);
//				String Day = temp.substring(8, 10);
//				temp = Year + "." + Month + "." + Day;
//			}
//			user_project.setEnd_date(temp);

			return user_project;
		}

	}

	// 通过user_id查询
	public List<JcqnDocProject> getAllByUserId(String userId) {
		return jdbcTemplate.query(SQL_GET_LIST_BY_USER_ID, new Object[] { userId }, new user_projectRowMapper());
	}
}
