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

import com.jfn.entity.JcqnDocPrize;
import com.jfn.entity.JcqnDocPrize;

/**
 * @create-time 2014-8-17 下午4:04:22
 * @author 佟德慧
 * @remarks 无
 */
@Repository
public class UserAwardDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String SQL_INSERT_user_award = "insert into jcqn_doc02_02(xuhao_id,user_id,award_item_name,prize_name,grade,sort,reward_time,grant_institution) values(?,?,?,?,?,?,?,?)";

	private final String SQL_Get_BY_ID = "select * from jcqn_doc02_02 where Id=?";
	private final String SQL_GET_user_award_LIST = "select * from jcqn_doc02_02 order by Id  ";
	private final String SQL_SET_user_award_UPDATE = "update jcqn_doc02_02 set xuhao_id=?,user_id=?,award_item_name=?,prize_name=?,grade=?,sort=?,reward_time=?,grant_institution=?  where id=?";

	private final static String SQL_DEL_BY_ID = "delete from jcqn_doc02_02 where id = ?";
	// 通过user_id查询
	private final String SQL_GET_LIST_BY_USER_ID = "select * from jcqn_doc02_02 where user_id=?";

	public boolean insert(JcqnDocPrize user_award) {
		return jdbcTemplate.update(SQL_INSERT_user_award,
				new Object[] { user_award.getXuhao_id(),user_award.getUserId(), user_award.getAwardItemName(), user_award.getPrizeName(), user_award.getGrade(), user_award.getSort(), user_award.getRewardTime(),user_award.getGrantInstitution() }) == 1;
	}

	public JcqnDocPrize get(int id) {
		return jdbcTemplate.query(SQL_Get_BY_ID, new Object[] { id }, new ResultSetExtractor<JcqnDocPrize>() {
			@Override
			public JcqnDocPrize extractData(ResultSet rs) throws SQLException, DataAccessException {
				JcqnDocPrize user_award = new JcqnDocPrize();
				if (rs.next()) {
					user_award.setId(rs.getInt("id"));
					user_award.setXuhao_id(rs.getInt("xuhao_id"));
					user_award.setUserId(rs.getInt("user_id"));
					user_award.setAwardItemName(rs.getString("award_item_name"));
					

//					String temp = rs.getString("date");
//					if (temp != null) {
//						String Year = temp.substring(0, 4);
//						String Month = temp.substring(5, 7);
//						String Day = temp.substring(8, 10);
//						temp = Year + "." + Month + "." + Day;
//					}
//					user_award.setDate(temp);

					user_award.setPrizeName(rs.getString("prize_name"));
					user_award.setGrade(rs.getString("grade"));
					user_award.setSort(rs.getString("sort"));
					String temp = rs.getString("reward_time");
					if (temp != null) {
						String Year = temp.substring(0, 4);
						String Month = temp.substring(5, 7);
						String Day = temp.substring(8, 10);
						temp = Year + "." + Month + "." + Day;
					}
					user_award.setRewardTime(temp);
					user_award.setGrantInstitution(rs.getString("grant_institution"));

				}
				return user_award;
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

	public boolean Update(JcqnDocPrize user_award) {
		Object[] params = new Object[] { user_award.getXuhao_id(),user_award.getUserId(), user_award.getAwardItemName(), user_award.getPrizeName(), user_award.getGrade(), user_award.getSort(), user_award.getRewardTime(),user_award.getGrantInstitution(),user_award.getId() };
		return jdbcTemplate.update(SQL_SET_user_award_UPDATE, params) == 1;
	}

	public boolean delete(int id) {
		return jdbcTemplate.update(SQL_DEL_BY_ID, new Object[] { id }) == 1;
	}

	public boolean isPropertyUnique(String newLoginName, String oldLoginName) {
		return false;
	}

	public List<JcqnDocPrize> getAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(SQL_GET_user_award_LIST, new user_awardRowMapper());
	}

	/**
	 * 定义内部类实现RowMapper接口
	 */
	public class user_awardRowMapper implements ParameterizedRowMapper<JcqnDocPrize> {
		// 实现mapRow方法
		@Override
		public JcqnDocPrize mapRow(ResultSet rs, int num) throws SQLException {
			// 对类进行封装
			JcqnDocPrize user_award = new JcqnDocPrize();
			user_award.setId(rs.getInt("id"));
			user_award.setXuhao_id(rs.getInt("xuhao_id"));
			user_award.setUserId(rs.getInt("user_id"));
			user_award.setAwardItemName(rs.getString("award_item_name"));
			

//			String temp = rs.getString("date");
//			if (temp != null) {
//				String Year = temp.substring(0, 4);
//				String Month = temp.substring(5, 7);
//				String Day = temp.substring(8, 10);
//				temp = Year + "." + Month + "." + Day;
//			}
//			user_award.setDate(temp);

			user_award.setPrizeName(rs.getString("prize_name"));
			user_award.setGrade(rs.getString("grade"));
			user_award.setSort(rs.getString("sort"));
			String temp = rs.getString("reward_time");
			if (temp != null) {
				String Year = temp.substring(0, 4);
				String Month = temp.substring(5, 7);
				String Day = temp.substring(8, 10);
				temp = Year + "." + Month + "." + Day;
			}
			user_award.setRewardTime(temp);
			user_award.setGrantInstitution(rs.getString("grant_institution"));
			return user_award;
		}
	}

	// 通过user_id查询
	public List<JcqnDocPrize> getAllByUserId(String user_id) {
		return jdbcTemplate.query(SQL_GET_LIST_BY_USER_ID, new Object[] { user_id }, new user_awardRowMapper());
	}
}
