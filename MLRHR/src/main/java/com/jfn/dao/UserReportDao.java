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

import com.jfn.entity.JcqnDocTreatise;

/**
 * @create-time 2014-8-17 下午4:04:22
 * @author 佟德慧
 * @remarks 无
 */
@Repository
public class UserReportDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String SQL_INSERT_user_report = "insert into jcqn_doc02_06(xuhao_id,user_id,treatise_name,press,issuing_country,year) values(?,?,?,?,?,?)";

	private final String SQL_Get_BY_ID = "select * from jcqn_doc02_06 where Id=?";
	private final String SQL_GET_user_report_LIST = "select * from jcqn_doc02_06 order by Id  ";
	private final String SQL_SET_user_report_UPDATE = "update jcqn_doc02_06 set xuhao_id=?,user_id=?,treatise_name=?,press=?,issuing_country=?,year=? where id=?";

	private final static String SQL_DEL_BY_ID = "delete from jcqn_doc02_06 where id = ?";
	// 通过user_id查询
	private final String SQL_GET_LIST_BY_USER_ID = "select * from jcqn_doc02_06 where user_id=? ";

	public boolean insert(JcqnDocTreatise user_report) {
		return jdbcTemplate.update(SQL_INSERT_user_report, new Object[] {user_report.getXuhao_id(), user_report.getUserId(), user_report.getTreatiseName(), user_report.getPress(), user_report.getIssuingCountry(), user_report.getYear()
				 }) == 1;
	}

	public JcqnDocTreatise get(int id) {
		return jdbcTemplate.query(SQL_Get_BY_ID, new Object[] { id }, new ResultSetExtractor<JcqnDocTreatise>() {
			@Override
			public JcqnDocTreatise extractData(ResultSet rs) throws SQLException, DataAccessException {
				JcqnDocTreatise user_report = new JcqnDocTreatise();
				if (rs.next()) {
					user_report.setXuhao_id(rs.getInt("xuhao_id"));
					user_report.setId(rs.getInt("id"));
					user_report.setUserId(rs.getInt("user_id"));
					user_report.setTreatiseName(rs.getString("treatise_name"));
					user_report.setPress(rs.getString("press"));
					user_report.setIssuingCountry(rs.getString("issuing_country"));
					user_report.setYear(rs.getString("year"));
//					String temp = rs.getString("date");
//					if (temp != null) {
//						String Year = temp.substring(0, 4);
//						String Month = temp.substring(5, 7);
//						String Day = temp.substring(8, 10);
//						temp = Year + "." + Month + "." + Day;
//					}
//					user_report.setDate( rs.getString("date"));
//
//					user_report.setContent_summary(rs.getString("content_summary"));
//					user_report.setSituation(rs.getString("situation"));
//					user_report.setIsAlone(rs.getString("isAlone"));

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

	public boolean Update(JcqnDocTreatise user_report) {
		Object[] params = new Object[] { user_report.getXuhao_id(), user_report.getUserId(), user_report.getTreatiseName(), user_report.getPress(), user_report.getIssuingCountry(), user_report.getYear()
				 ,user_report.getId() };
		return jdbcTemplate.update(SQL_SET_user_report_UPDATE, params) == 1;
	}

	public boolean delete(int id) {
		return jdbcTemplate.update(SQL_DEL_BY_ID, new Object[] { id }) == 1;
	}

	public boolean isPropertyUnique(String newLoginName, String oldLoginName) {
		return false;
	}

	public List<JcqnDocTreatise> getAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(SQL_GET_user_report_LIST, new user_reportRowMapper());
	}

	/**
	 * 定义内部类实现RowMapper接口
	 */
	public class user_reportRowMapper implements ParameterizedRowMapper<JcqnDocTreatise> {
		// 实现mapRow方法
		@Override
		public JcqnDocTreatise mapRow(ResultSet rs, int num) throws SQLException {
			// 对类进行封装
			JcqnDocTreatise user_report = new JcqnDocTreatise();
			user_report.setXuhao_id(rs.getInt("xuhao_id"));
			user_report.setId(rs.getInt("id"));
			user_report.setUserId(rs.getInt("user_id"));
			user_report.setTreatiseName(rs.getString("treatise_name"));
			user_report.setPress(rs.getString("press"));
			user_report.setIssuingCountry(rs.getString("issuing_country"));
			user_report.setYear(rs.getString("year"));
			return user_report;
		}
	}

	// 通过user_id查询
	public List<JcqnDocTreatise> getAllByUserId(String user_id) {
		return jdbcTemplate.query(SQL_GET_LIST_BY_USER_ID, new Object[] { user_id }, new user_reportRowMapper());
	}
}
