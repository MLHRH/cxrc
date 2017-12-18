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

import com.jfn.entity.JcqnDocPatent;

/**
 * @create-time 2014-8-17 下午4:04:22
 * @author 佟德慧
 * @remarks 无
 */
@Repository
public class UserZhuanliDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String SQL_INSERT_user_zhuanli = "insert into jcqn_doc02_04(xuhao_id,user_id,patent_name,grant_number,type,inventor_sort,authorized_time,authorized_national) values(?,?,?,?,?,?,?,?)";

	private final String SQL_Get_BY_ID = "select * from jcqn_doc02_04 where Id=?";
	private final String SQL_GET_user_zhuanli_LIST = "select * from jcqn_doc02_04 order by Id  ";
	private final String SQL_SET_user_zhuanli_UPDATE = "update jcqn_doc02_04 set xuhao_id=?,user_id=?,patent_name=?,grant_number=?,type=?,inventor_sort=?,authorized_time=?,authorized_national=? where id=?";

	private final static String SQL_DEL_BY_ID = "delete from jcqn_doc02_04 where id = ?";
	// 通过user_id查询
	private final String SQL_GET_LIST_BY_USER_ID = "select * from jcqn_doc02_04 where user_id=? ";

	public boolean insert(JcqnDocPatent user_zhuanli) {
		return jdbcTemplate.update(SQL_INSERT_user_zhuanli, new Object[] { user_zhuanli.getXuhao_id(),user_zhuanli.getUserId(), user_zhuanli.getPatentName(), user_zhuanli.getGrantNumber(), user_zhuanli.getType(), user_zhuanli.getInventorSort(),
				user_zhuanli.getAuthorizedTime(),user_zhuanli.getAuthorizedNational() }) == 1;
	}

	public JcqnDocPatent get(int id) {
		return jdbcTemplate.query(SQL_Get_BY_ID, new Object[] { id }, new ResultSetExtractor<JcqnDocPatent>() {
			@Override
			public JcqnDocPatent extractData(ResultSet rs) throws SQLException, DataAccessException {
				JcqnDocPatent user_zhuanli = new JcqnDocPatent();
				if (rs.next()) {
					user_zhuanli.setXuhao_id(rs.getInt("xuhao_id"));
					user_zhuanli.setId(rs.getInt("id"));
					user_zhuanli.setUserId(rs.getInt("user_id"));
					user_zhuanli.setPatentName(rs.getString("patent_name"));


					user_zhuanli.setGrantNumber(rs.getString("grant_number"));
					user_zhuanli.setType(rs.getString("type"));
					user_zhuanli.setInventorSort(rs.getString("inventor_sort"));

//					String temp = rs.getString("authorized_time");
//					if (temp != null) {
//						String Year = temp.substring(0, 4);
//						String Month = temp.substring(5, 7);
//						String Day = temp.substring(8, 10);
//						temp = Year + "." + Month + "." + Day;
//					}
					user_zhuanli.setAuthorizedTime(rs.getString("authorized_time"));
					user_zhuanli.setAuthorizedNational(rs.getString("authorized_national"));

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

	public boolean Update(JcqnDocPatent user_zhuanli) {
		Object[] params = new Object[] {user_zhuanli.getXuhao_id(),user_zhuanli.getUserId(), user_zhuanli.getPatentName(), user_zhuanli.getGrantNumber(), user_zhuanli.getType(), user_zhuanli.getInventorSort(),
				user_zhuanli.getAuthorizedTime(),user_zhuanli.getAuthorizedNational(),user_zhuanli.getId() };
		return jdbcTemplate.update(SQL_SET_user_zhuanli_UPDATE, params) == 1;
	}

	public boolean delete(int id) {
		return jdbcTemplate.update(SQL_DEL_BY_ID, new Object[] { id }) == 1;
	}

	public boolean isPropertyUnique(String newLoginName, String oldLoginName) {
		return false;
	}

	public List<JcqnDocPatent> getAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(SQL_GET_user_zhuanli_LIST, new user_zhuanliRowMapper());
	}

	/**
	 * 定义内部类实现RowMapper接口
	 */
	public class user_zhuanliRowMapper implements ParameterizedRowMapper<JcqnDocPatent> {
		// 实现mapRow方法
		@Override
		public JcqnDocPatent mapRow(ResultSet rs, int num) throws SQLException {
			// 对类进行封装
			JcqnDocPatent user_zhuanli = new JcqnDocPatent();
			
				user_zhuanli.setXuhao_id(rs.getInt("xuhao_id"));
				user_zhuanli.setId(rs.getInt("id"));
				user_zhuanli.setUserId(rs.getInt("user_id"));
				user_zhuanli.setPatentName(rs.getString("patent_name"));


				user_zhuanli.setGrantNumber(rs.getString("grant_number"));
				user_zhuanli.setType(rs.getString("type"));
				user_zhuanli.setInventorSort(rs.getString("inventor_sort"));

//				String temp = rs.getString("authorized_time");
//				if (temp != null) {
//					String Year = temp.substring(0, 4);
//					String Month = temp.substring(5, 7);
//					String Day = temp.substring(8, 10);
//					temp = Year + "." + Month + "." + Day;
//				}
				user_zhuanli.setAuthorizedTime(rs.getString("authorized_time"));
				user_zhuanli.setAuthorizedNational(rs.getString("authorized_national"));

			
			return user_zhuanli;
		}
	}

	// 通过user_id查询
	public List<JcqnDocPatent> getAllByUserId(String user_id) {
		return jdbcTemplate.query(SQL_GET_LIST_BY_USER_ID, new Object[] { user_id }, new user_zhuanliRowMapper());
	}
}
