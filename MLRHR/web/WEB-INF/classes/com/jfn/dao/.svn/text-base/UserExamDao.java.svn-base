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

import com.jfn.entity.UserExam;

/**
 * @create-time 2014-8-17 下午4:24:59
 * @author 佟德慧
 * @remarks 无
 */
@Repository
public class UserExamDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String SQL_INSERT_user_exam = "insert into user_exam(user_id,type,exam_date,kemu,chengji,zuzhizhe) values(?,?,?,?,?,?)";

	private final String SQL_Get_BY_ID = "select * from user_exam where Id=?";
	private final String SQL_GET_user_exam_LIST = "select * from user_exam order by Id  ";
	private final String SQL_SET_user_exam_UPDATE = "update user_exam set user_id=?,type=?,exam_date=?,kemu=?,chengji=?,zuzhizhe=? where id=?";

	private final static String SQL_DEL_BY_ID = "delete from user_exam where id = ?";
	// 通过user_id查询
	private final String SQL_GET_LIST_BY_USER_ID = "select * from user_exam where user_id=?  order by exam_date desc";

	public boolean insert(UserExam user_exam) {
		return jdbcTemplate.update(SQL_INSERT_user_exam,
				new Object[] { user_exam.getUser_id(), user_exam.getType(), user_exam.getExam_date(), user_exam.getKemu(), user_exam.getChengji(), user_exam.getZuzhizhe() }) == 1;
	}

	public UserExam get(int id) {
		return jdbcTemplate.query(SQL_Get_BY_ID, new Object[] { id }, new ResultSetExtractor<UserExam>() {
			@Override
			public UserExam extractData(ResultSet rs) throws SQLException, DataAccessException {
				UserExam user_exam = new UserExam();
				if (rs.next()) {
					user_exam.setId(rs.getInt("id"));
					user_exam.setUser_id(rs.getString("user_id"));
					user_exam.setType(rs.getString("type"));

					String temp = rs.getString("exam_date");
					if (temp != null) {
						String Year = temp.substring(0, 4);
						String Month = temp.substring(5, 7);
						String Day = temp.substring(8, 10);
						temp = Year + "." + Month + "." + Day;
					}
					user_exam.setExam_date(temp);

					user_exam.setKemu(rs.getString("kemu"));
					user_exam.setChengji(rs.getString("chengji"));
					user_exam.setZuzhizhe(rs.getString("zuzhizhe"));

				}
				return user_exam;
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

	public boolean Update(UserExam user_exam) {
		Object[] params = new Object[] { user_exam.getUser_id(), user_exam.getType(), user_exam.getExam_date(), user_exam.getKemu(), user_exam.getChengji(), user_exam.getZuzhizhe(), user_exam.getId() };
		return jdbcTemplate.update(SQL_SET_user_exam_UPDATE, params) == 1;
	}

	public boolean delete(int id) {
		return jdbcTemplate.update(SQL_DEL_BY_ID, new Object[] { id }) == 1;
	}

	public boolean isPropertyUnique(String newLoginName, String oldLoginName) {
		return false;
	}

	public List<UserExam> getAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(SQL_GET_user_exam_LIST, new user_examRowMapper());
	}

	/**
	 * 定义内部类实现RowMapper接口
	 */
	public class user_examRowMapper implements ParameterizedRowMapper<UserExam> {
		// 实现mapRow方法
		@Override
		public UserExam mapRow(ResultSet rs, int num) throws SQLException {
			// 对类进行封装
			UserExam user_exam = new UserExam();
			user_exam.setId(rs.getInt("id"));
			user_exam.setUser_id(rs.getString("user_id"));
			user_exam.setType(rs.getString("type"));

			String temp = rs.getString("exam_date");
			if (temp != null) {
				String Year = temp.substring(0, 4);
				String Month = temp.substring(5, 7);
				String Day = temp.substring(8, 10);
				temp = Year + "." + Month + "." + Day;
			}
			user_exam.setExam_date(temp);

			user_exam.setKemu(rs.getString("kemu"));
			user_exam.setChengji(rs.getString("chengji"));
			user_exam.setZuzhizhe(rs.getString("zuzhizhe"));
			return user_exam;
		}
	}

	// 通过user_id查询
	public List<UserExam> getAllByUserId(String user_id) {
		return jdbcTemplate.query(SQL_GET_LIST_BY_USER_ID, new Object[] { user_id }, new user_examRowMapper());
	}
}
