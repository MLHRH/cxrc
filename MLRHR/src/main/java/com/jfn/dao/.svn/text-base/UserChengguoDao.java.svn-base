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

import com.jfn.entity.UserChengguo;

/**
 * @create-time 2014-8-17 下午4:04:22
 * @author 佟德慧
 * @remarks 无
 */
@Repository
public class UserChengguoDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String SQL_INSERT_user_chengguo = "insert into user_chengguo(user_id,cg_name,cg_date,cg_jieshao,jiaose,type,yingxiangyinzi) values(?,?,?,?,?,?,?)";

	private final String SQL_Get_BY_ID = "select * from user_chengguo where Id=?";
	private final String SQL_GET_user_chengguo_LIST = "select * from user_chengguo order by Id  ";
	private final String SQL_SET_user_chengguo_UPDATE = "update user_chengguo set user_id=?,cg_name=?,cg_date=?,cg_jieshao=?,jiaose=?,type=?,yingxiangyinzi=? where id=?";

	private final static String SQL_DEL_BY_ID = "delete from user_chengguo where id = ?";
	// 通过user_id查询
	private final String SQL_GET_LIST_BY_USER_ID = "select * from user_chengguo where user_id=?  order by cg_date desc";

	public boolean insert(UserChengguo user_chengguo) {
		return jdbcTemplate.update(SQL_INSERT_user_chengguo, new Object[] { user_chengguo.getUser_id(), user_chengguo.getCg_name(), user_chengguo.getCg_date(), user_chengguo.getCg_jieshao(),
				user_chengguo.getJiaose(), user_chengguo.getType(), user_chengguo.getYingxiangyinzi() }) == 1;
	}

	public UserChengguo get(int id) {
		return jdbcTemplate.query(SQL_Get_BY_ID, new Object[] { id }, new ResultSetExtractor<UserChengguo>() {
			@Override
			public UserChengguo extractData(ResultSet rs) throws SQLException, DataAccessException {
				UserChengguo user_chengguo = new UserChengguo();
				if (rs.next()) {
					user_chengguo.setId(rs.getInt("id"));
					user_chengguo.setUser_id(rs.getString("user_id"));
					user_chengguo.setCg_name(rs.getString("cg_name"));

					String temp = rs.getString("cg_date");
					if (temp != null) {
						String Year = temp.substring(0, 4);
						String Month = temp.substring(5, 7);
						String Day = temp.substring(8, 10);
						temp = Year + "." + Month + "." + Day;
					}
					user_chengguo.setCg_date(temp);

					user_chengguo.setCg_jieshao(rs.getString("cg_jieshao"));
					user_chengguo.setJiaose(rs.getString("jiaose"));
					user_chengguo.setType(rs.getString("type"));
					user_chengguo.setYingxiangyinzi(rs.getString("yingxiangyinzi"));

				}
				return user_chengguo;
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

	public boolean Update(UserChengguo user_chengguo) {
		Object[] params = new Object[] { user_chengguo.getUser_id(), user_chengguo.getCg_name(), user_chengguo.getCg_date(), user_chengguo.getCg_jieshao(), user_chengguo.getJiaose(),
				user_chengguo.getType(), user_chengguo.getYingxiangyinzi(), user_chengguo.getId() };
		return jdbcTemplate.update(SQL_SET_user_chengguo_UPDATE, params) == 1;
	}

	public boolean delete(int id) {
		return jdbcTemplate.update(SQL_DEL_BY_ID, new Object[] { id }) == 1;
	}

	public boolean isPropertyUnique(String newLoginName, String oldLoginName) {
		return false;
	}

	public List<UserChengguo> getAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(SQL_GET_user_chengguo_LIST, new user_chengguoRowMapper());
	}

	/**
	 * 定义内部类实现RowMapper接口
	 */
	public class user_chengguoRowMapper implements ParameterizedRowMapper<UserChengguo> {
		// 实现mapRow方法
		@Override
		public UserChengguo mapRow(ResultSet rs, int num) throws SQLException {
			// 对类进行封装
			UserChengguo user_chengguo = new UserChengguo();
			user_chengguo.setId(rs.getInt("id"));
			user_chengguo.setUser_id(rs.getString("user_id"));
			user_chengguo.setCg_name(rs.getString("cg_name"));

			String temp = rs.getString("cg_date");
			if (temp != null) {
				String Year = temp.substring(0, 4);
				String Month = temp.substring(5, 7);
				String Day = temp.substring(8, 10);
				temp = Year + "." + Month + "." + Day;
			}
			user_chengguo.setCg_date(temp);

			user_chengguo.setCg_jieshao(rs.getString("cg_jieshao"));
			user_chengguo.setJiaose(rs.getString("jiaose"));
			user_chengguo.setType(rs.getString("type"));
			user_chengguo.setYingxiangyinzi(rs.getString("yingxiangyinzi"));
			return user_chengguo;
		}
	}

	// 通过user_id查询
	public List<UserChengguo> getAllByUserId(String user_id) {
		return jdbcTemplate.query(SQL_GET_LIST_BY_USER_ID, new Object[] { user_id }, new user_chengguoRowMapper());
	}
}
