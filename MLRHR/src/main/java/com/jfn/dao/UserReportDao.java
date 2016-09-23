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

import com.jfn.entity.UserReport;

/**
 * @create-time 2014-8-17 下午4:04:22
 * @author 佟德慧
 * @remarks 无
 */
@Repository
public class UserReportDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String SQL_INSERT_user_report = "insert into user_report(user_id,name,date,content_summary,situation,isAlone) values(?,?,?,?,?,?)";

	private final String SQL_Get_BY_ID = "select * from user_report where Id=?";
	private final String SQL_GET_user_report_LIST = "select * from user_report order by Id  ";
	private final String SQL_SET_user_report_UPDATE = "update user_report set user_id=?,name=?,date=?,content_summary=?,situation=?,isAlone=? where id=?";

	private final static String SQL_DEL_BY_ID = "delete from user_report where id = ?";
	// 通过user_id查询
	private final String SQL_GET_LIST_BY_USER_ID = "select * from user_report where user_id=? order by date desc";

	public boolean insert(UserReport user_report) {
		return jdbcTemplate.update(SQL_INSERT_user_report, new Object[] { user_report.getUser_id(), user_report.getName(), user_report.getDate(), user_report.getContent_summary(), user_report.getSituation(),
				user_report.getIsAlone() }) == 1;
	}

	public UserReport get(int id) {
		return jdbcTemplate.query(SQL_Get_BY_ID, new Object[] { id }, new ResultSetExtractor<UserReport>() {
			@Override
			public UserReport extractData(ResultSet rs) throws SQLException, DataAccessException {
				UserReport user_report = new UserReport();
				if (rs.next()) {
					user_report.setId(rs.getInt("id"));
					user_report.setUser_id(rs.getString("user_id"));
					user_report.setName(rs.getString("name"));

//					String temp = rs.getString("date");
//					if (temp != null) {
//						String Year = temp.substring(0, 4);
//						String Month = temp.substring(5, 7);
//						String Day = temp.substring(8, 10);
//						temp = Year + "." + Month + "." + Day;
//					}
					user_report.setDate( rs.getString("date"));

					user_report.setContent_summary(rs.getString("content_summary"));
					user_report.setSituation(rs.getString("situation"));
					user_report.setIsAlone(rs.getString("isAlone"));

				}
				return user_report;
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

	public boolean Update(UserReport user_report) {
		Object[] params = new Object[] { user_report.getUser_id(), user_report.getName(), user_report.getDate(), user_report.getContent_summary(), user_report.getSituation(), user_report.getIsAlone(),
				user_report.getId() };
		return jdbcTemplate.update(SQL_SET_user_report_UPDATE, params) == 1;
	}

	public boolean delete(int id) {
		return jdbcTemplate.update(SQL_DEL_BY_ID, new Object[] { id }) == 1;
	}

	public boolean isPropertyUnique(String newLoginName, String oldLoginName) {
		return false;
	}

	public List<UserReport> getAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(SQL_GET_user_report_LIST, new user_reportRowMapper());
	}

	/**
	 * 定义内部类实现RowMapper接口
	 */
	public class user_reportRowMapper implements ParameterizedRowMapper<UserReport> {
		// 实现mapRow方法
		@Override
		public UserReport mapRow(ResultSet rs, int num) throws SQLException {
			// 对类进行封装
			UserReport user_report = new UserReport();
			user_report.setId(rs.getInt("id"));
			user_report.setUser_id(rs.getString("user_id"));
			user_report.setName(rs.getString("name"));

//			String temp = rs.getString("date");
//			if (temp != null) {
//				String Year = temp.substring(0, 4);
//				String Month = temp.substring(5, 7);
//				String Day = temp.substring(8, 10);
//				temp = Year + "." + Month + "." + Day;
//			}
			user_report.setDate(rs.getString("date"));

			user_report.setContent_summary(rs.getString("content_summary"));
			user_report.setSituation(rs.getString("situation"));
			user_report.setIsAlone(rs.getString("isAlone"));

			return user_report;
		}
	}

	// 通过user_id查询
	public List<UserReport> getAllByUserId(String user_id) {
		return jdbcTemplate.query(SQL_GET_LIST_BY_USER_ID, new Object[] { user_id }, new user_reportRowMapper());
	}
}
