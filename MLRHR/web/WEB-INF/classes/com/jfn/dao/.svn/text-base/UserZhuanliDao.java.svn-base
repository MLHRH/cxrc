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

import com.jfn.entity.UserZhuanli;

/**
 * @create-time 2014-8-17 下午4:04:22
 * @author 佟德慧
 * @remarks 无
 */
@Repository
public class UserZhuanliDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String SQL_INSERT_user_zhuanli = "insert into user_zhuanli(user_id,name,date,other,jiaose,type) values(?,?,?,?,?,?)";

	private final String SQL_Get_BY_ID = "select * from user_zhuanli where Id=?";
	private final String SQL_GET_user_zhuanli_LIST = "select * from user_zhuanli order by Id  ";
	private final String SQL_SET_user_zhuanli_UPDATE = "update user_zhuanli set user_id=?,name=?,date=?,other=?,jiaose=?,type=? where id=?";

	private final static String SQL_DEL_BY_ID = "delete from user_zhuanli where id = ?";
	// 通过user_id查询
	private final String SQL_GET_LIST_BY_USER_ID = "select * from user_zhuanli where user_id=? order by date desc";

	public boolean insert(UserZhuanli user_zhuanli) {
		return jdbcTemplate.update(SQL_INSERT_user_zhuanli, new Object[] { user_zhuanli.getUser_id(), user_zhuanli.getName(), user_zhuanli.getDate(), user_zhuanli.getOther(),
				user_zhuanli.getJiaose(), user_zhuanli.getType() }) == 1;
	}

	public UserZhuanli get(int id) {
		return jdbcTemplate.query(SQL_Get_BY_ID, new Object[] { id }, new ResultSetExtractor<UserZhuanli>() {
			@Override
			public UserZhuanli extractData(ResultSet rs) throws SQLException, DataAccessException {
				UserZhuanli user_zhuanli = new UserZhuanli();
				if (rs.next()) {
					user_zhuanli.setId(rs.getInt("id"));
					user_zhuanli.setUser_id(rs.getString("user_id"));
					user_zhuanli.setName(rs.getString("name"));

					String temp = rs.getString("date");
					if (temp != null) {
						String Year = temp.substring(0, 4);
						String Month = temp.substring(5, 7);
						String Day = temp.substring(8, 10);
						temp = Year + "." + Month + "." + Day;
					}
					user_zhuanli.setDate(temp);

					user_zhuanli.setOther(rs.getString("other"));
					user_zhuanli.setJiaose(rs.getString("jiaose"));
					user_zhuanli.setType(rs.getString("type"));

				}
				return user_zhuanli;
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

	public boolean Update(UserZhuanli user_zhuanli) {
		Object[] params = new Object[] { user_zhuanli.getUser_id(), user_zhuanli.getName(), user_zhuanli.getDate(), user_zhuanli.getOther(), user_zhuanli.getJiaose(), user_zhuanli.getType(),
				user_zhuanli.getId() };
		return jdbcTemplate.update(SQL_SET_user_zhuanli_UPDATE, params) == 1;
	}

	public boolean delete(int id) {
		return jdbcTemplate.update(SQL_DEL_BY_ID, new Object[] { id }) == 1;
	}

	public boolean isPropertyUnique(String newLoginName, String oldLoginName) {
		return false;
	}

	public List<UserZhuanli> getAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(SQL_GET_user_zhuanli_LIST, new user_zhuanliRowMapper());
	}

	/**
	 * 定义内部类实现RowMapper接口
	 */
	public class user_zhuanliRowMapper implements ParameterizedRowMapper<UserZhuanli> {
		// 实现mapRow方法
		@Override
		public UserZhuanli mapRow(ResultSet rs, int num) throws SQLException {
			// 对类进行封装
			UserZhuanli user_zhuanli = new UserZhuanli();
			user_zhuanli.setId(rs.getInt("id"));
			user_zhuanli.setUser_id(rs.getString("user_id"));
			user_zhuanli.setName(rs.getString("name"));

			String temp = rs.getString("date");
			if (temp != null) {
				String Year = temp.substring(0, 4);
				String Month = temp.substring(5, 7);
				String Day = temp.substring(8, 10);
				temp = Year + "." + Month + "." + Day;
			}
			user_zhuanli.setDate(temp);

			user_zhuanli.setOther(rs.getString("other"));
			user_zhuanli.setJiaose(rs.getString("jiaose"));
			user_zhuanli.setType(rs.getString("type"));
			return user_zhuanli;
		}
	}

	// 通过user_id查询
	public List<UserZhuanli> getAllByUserId(String user_id) {
		return jdbcTemplate.query(SQL_GET_LIST_BY_USER_ID, new Object[] { user_id }, new user_zhuanliRowMapper());
	}
}
