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

import com.jfn.entity.JcqnDocReport;

/**
 * @create-time 2014-8-18 下午6:10:39
 * @author 佟德慧
 * @remarks 无
 */
@Repository
public class UserBaogaoDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String SQL_INSERT_user_study = "insert into jcqn_doc02_05(xuhao_id,user_id,report_name,meeting_name,organizers,meeting_time,meeting_place,report_type) values(?,?,?,?,?,?,?,?)";

	private final String SQL_Get_BY_ID = "select * from jcqn_doc02_05 where Id=?";
	private final String SQL_GET_user_study_LIST = "select * from jcqn_doc02_05 order by Id  ";
	private final String SQL_SET_user_study_UPDATE = "update jcqn_doc02_05 set xuhao_id=?,user_id=?,report_name=?,meeting_name=?,organizers=?,meeting_time=?,meeting_place=?,report_type=? where id=?";

	private final static String SQL_DEL_BY_ID = "delete from jcqn_doc02_05 where id = ?";
	// 通过user_id查询
	private final String SQL_GET_LIST_BY_USER_ID = "select * from jcqn_doc02_05 where user_id=? ";
	// 查询最新一条记录
	private final String SQL_GET_NEW = "select * from jcqn_doc02_05 where user_id=? ";

	public boolean insert(JcqnDocReport user_study) {
		return jdbcTemplate.update(SQL_INSERT_user_study, new Object[] { user_study.getXuhao_id(),user_study.getUserId(), user_study.getReportName(), user_study.getMeetingName(), user_study.getOrganizers(), user_study.getMeetingTime(),
				user_study.getMeetingPlace(), user_study.getReportType() }) == 1;
	}

	public JcqnDocReport get(int id) {
		return jdbcTemplate.query(SQL_Get_BY_ID, new Object[] { id }, new ResultSetExtractor<JcqnDocReport>() {
			@Override
			public JcqnDocReport extractData(ResultSet rs) throws SQLException, DataAccessException {
				JcqnDocReport user_study = new JcqnDocReport();
				if (rs.next()) {
					user_study.setXuhao_id(rs.getInt("xuhao_id"));
					user_study.setId(rs.getInt("id"));
					user_study.setUserId(rs.getInt("user_id"));
					user_study.setReportName(rs.getString("report_name"));
					user_study.setMeetingName(rs.getString("report_name"));
					user_study.setOrganizers(rs.getString("organizers"));
					
					String temp = rs.getString("meeting_time");
					if (temp != null) {
						String Year = temp.substring(0, 4);
						String Month = temp.substring(5, 7);
						String Day = temp.substring(8, 10);
						temp = Year + "." + Month + "." + Day;
					}
					user_study.setMeetingTime(temp);
					user_study.setMeetingPlace(rs.getString("meeting_place"));
					user_study.setReportType(rs.getString("report_type"));
			

				}
				return user_study;
			}
		});
	}

	public JcqnDocReport getNewById(int id) {
		return jdbcTemplate.query(SQL_GET_NEW, new Object[] { id }, new ResultSetExtractor<JcqnDocReport>() {
			@Override
			public JcqnDocReport extractData(ResultSet rs) throws SQLException, DataAccessException {
				JcqnDocReport user_study = new JcqnDocReport();
				if (rs.next()) {
					user_study.setXuhao_id(rs.getInt("xuhao_id"));
					user_study.setId(rs.getInt("id"));
					user_study.setUserId(rs.getInt("user_id"));
					user_study.setReportName(rs.getString("report_name"));
					user_study.setMeetingName(rs.getString("report_name"));
					user_study.setOrganizers(rs.getString("organizers"));
					
					String temp = rs.getString("meeting_time");
					if (temp != null) {
						String Year = temp.substring(0, 4);
						String Month = temp.substring(5, 7);
						String Day = temp.substring(8, 10);
						temp = Year + "." + Month + "." + Day;
					}
					user_study.setMeetingTime(temp);
					user_study.setMeetingPlace(rs.getString("meeting_place"));
					user_study.setReportType(rs.getString("report_type"));
			

				}
				return user_study;
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

	public boolean Update(JcqnDocReport user_study) {
		Object[] params = new Object[] { user_study.getXuhao_id(),user_study.getUserId(), user_study.getReportName(), user_study.getMeetingName(), user_study.getOrganizers(), user_study.getMeetingTime(),
				user_study.getMeetingPlace(), user_study.getReportType() };
		return jdbcTemplate.update(SQL_SET_user_study_UPDATE, params) == 1;
	}

	public boolean delete(int id) {
		return jdbcTemplate.update(SQL_DEL_BY_ID, new Object[] { id }) == 1;
	}

	public boolean isPropertyUnique(String newLoginName, String oldLoginName) {
		return false;
	}

	public List<JcqnDocReport> getAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(SQL_GET_user_study_LIST, new user_studyRowMapper());
	}

	/**
	 * 定义内部类实现RowMapper接口
	 */
	public class user_studyRowMapper implements ParameterizedRowMapper<JcqnDocReport> {
		// 实现mapRow方法
		@Override
		public JcqnDocReport mapRow(ResultSet rs, int num) throws SQLException {
			// 对类进行封装
			JcqnDocReport user_study = new JcqnDocReport();
			user_study.setXuhao_id(rs.getInt("xuhao_id"));
			user_study.setId(rs.getInt("id"));
			user_study.setUserId(rs.getInt("user_id"));
			user_study.setReportName(rs.getString("report_name"));
			user_study.setMeetingName(rs.getString("report_name"));
			user_study.setOrganizers(rs.getString("organizers"));
			
			String temp = rs.getString("meeting_time");
			if (temp != null) {
				String Year = temp.substring(0, 4);
				String Month = temp.substring(5, 7);
				String Day = temp.substring(8, 10);
				temp = Year + "." + Month + "." + Day;
			}
			user_study.setMeetingTime(temp);
			user_study.setMeetingPlace(rs.getString("meeting_place"));
			user_study.setReportType(rs.getString("report_type"));
			return user_study;
		}
	}

	// 通过user_id查询
	public List<JcqnDocReport> getAllByUserId(String user_id) {
		return jdbcTemplate.query(SQL_GET_LIST_BY_USER_ID, new Object[] { user_id }, new user_studyRowMapper());
	}
}
