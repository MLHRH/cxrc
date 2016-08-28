package com.jfn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.stereotype.Repository;

import com.jfn.dao.UserProjectDao.user_projectRowMapper;
import com.jfn.entity.UserProject;
import com.jfn.entity.UserStudy;

/**
 * @create-time 2014-8-18 下午6:10:39
 * @author 佟德慧
 * @remarks 无
 */
@Repository
public class UserStudyDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String SQL_INSERT_user_study = "insert into user_study(user_id,start_date,xuexiao,zhuanye,xuezhi,xuewei,xueli,zhengmingren,end_date) values(?,?,?,?,?,?,?,?,?)";

	private final String SQL_Get_BY_ID = "select * from user_study where Id=?";
	private final String SQL_GET_user_study_LIST = "select * from user_study order by Id  ";
	private final String SQL_SET_user_study_UPDATE = "update user_study set user_id=?,start_date=?,xuexiao=?,zhuanye=?,xuezhi=?,xuewei=?,xueli=?,zhengmingren=?,end_date=? where id=?";

	private final static String SQL_DEL_BY_ID = "delete from user_study where id = ?";
	// 通过user_id查询
	private final String SQL_GET_LIST_BY_USER_ID = "select * from user_study where user_id=? order by start_date desc";
	// 查询最新一条记录
	private final String SQL_GET_NEW = "select * from user_study where user_id=? order by start_date desc limit 1";

	public boolean insert(UserStudy user_study) {
		return jdbcTemplate.update(SQL_INSERT_user_study, new Object[] { user_study.getUser_id(), user_study.getStart_date(), user_study.getXuexiao(), user_study.getZhuanye(), user_study.getXuezhi(),
				user_study.getXuewei(), user_study.getXueli(), user_study.getZhengmingren(), user_study.getEnd_date() }) == 1;
	}

	public UserStudy get(int id) {
		return jdbcTemplate.query(SQL_Get_BY_ID, new Object[] { id }, new ResultSetExtractor<UserStudy>() {
			@Override
			public UserStudy extractData(ResultSet rs) throws SQLException, DataAccessException {
				UserStudy user_study = new UserStudy();
				if (rs.next()) {
					user_study.setId(rs.getInt("id"));
					user_study.setUser_id(rs.getString("user_id"));
					user_study.setStart_date(rs.getString("start_date"));
					user_study.setXuexiao(rs.getString("xuexiao"));
					user_study.setZhuanye(rs.getString("zhuanye"));
					user_study.setXuezhi(rs.getString("xuezhi"));
					user_study.setXuewei(rs.getString("xuewei"));
					user_study.setXueli(rs.getString("xueli"));
					user_study.setZhengmingren(rs.getString("zhengmingren"));
					user_study.setEnd_date(rs.getString("end_date"));

				}
				return user_study;
			}
		});
	}

	public UserStudy getNewById(int id) {
		return jdbcTemplate.query(SQL_GET_NEW, new Object[] { id }, new ResultSetExtractor<UserStudy>() {
			@Override
			public UserStudy extractData(ResultSet rs) throws SQLException, DataAccessException {
				UserStudy user_study = new UserStudy();
				if (rs.next()) {
					user_study.setId(rs.getInt("id"));
					user_study.setUser_id(rs.getString("user_id"));
					user_study.setStart_date(rs.getString("start_date"));
					user_study.setXuexiao(rs.getString("xuexiao"));
					user_study.setZhuanye(rs.getString("zhuanye"));
					user_study.setXuezhi(rs.getString("xuezhi"));
					user_study.setXuewei(rs.getString("xuewei"));
					user_study.setXueli(rs.getString("xueli"));
					user_study.setZhengmingren(rs.getString("zhengmingren"));
					user_study.setEnd_date(rs.getString("end_date"));

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

	public boolean Update(UserStudy user_study) {
		Object[] params = new Object[] { user_study.getUser_id(), user_study.getStart_date(), user_study.getXuexiao(), user_study.getZhuanye(), user_study.getXuezhi(), user_study.getXuewei(),
				user_study.getXueli(), user_study.getZhengmingren(), user_study.getEnd_date(), user_study.getId() };
		return jdbcTemplate.update(SQL_SET_user_study_UPDATE, params) == 1;
	}

	public boolean delete(int id) {
		return jdbcTemplate.update(SQL_DEL_BY_ID, new Object[] { id }) == 1;
	}

	public boolean isPropertyUnique(String newLoginName, String oldLoginName) {
		return false;
	}

	public List<UserStudy> getAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(SQL_GET_user_study_LIST, new user_studyRowMapper());
	}

	/**
	 * 定义内部类实现RowMapper接口
	 */
	public class user_studyRowMapper implements ParameterizedRowMapper<UserStudy> {
		// 实现mapRow方法
		@Override
		public UserStudy mapRow(ResultSet rs, int num) throws SQLException {
			// 对类进行封装
			UserStudy user_study = new UserStudy();
			user_study.setId(rs.getInt("id"));
			user_study.setUser_id(rs.getString("user_id"));
			user_study.setStart_date(rs.getString("start_date"));
			user_study.setXuexiao(rs.getString("xuexiao"));
			user_study.setZhuanye(rs.getString("zhuanye"));
			user_study.setXuezhi(rs.getString("xuezhi"));
			user_study.setXuewei(rs.getString("xuewei"));
			user_study.setXueli(rs.getString("xueli"));
			user_study.setZhengmingren(rs.getString("zhengmingren"));
			user_study.setEnd_date(rs.getString("end_date"));
			return user_study;
		}
	}

	// 通过user_id查询
	public List<UserStudy> getAllByUserId(String user_id) {
		return jdbcTemplate.query(SQL_GET_LIST_BY_USER_ID, new Object[] { user_id }, new user_studyRowMapper());
	}
}
