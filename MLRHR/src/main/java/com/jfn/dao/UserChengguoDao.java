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

import com.jfn.entity.JcqnDocThesis;

/**
 * @create-time 2014-8-17 下午4:04:22
 * @author 佟德慧
 * @remarks 无
 */
@Repository
public class UserChengguoDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String SQL_INSERT_user_chengguo = "insert into jcqn_doc02_03(xuhao_id,user_id,thesis_topic,author_sort,journal_title,year_volume_pagenumber,influence_factor,sci_times) values(?,?,?,?,?,?,?,?)";

	private final String SQL_Get_BY_ID = "select * from jcqn_doc02_03 where Id=?";
	private final String SQL_GET_user_chengguo_LIST = "select * from jcqn_doc02_03 order by Id  ";
	private final String SQL_SET_user_chengguo_UPDATE = "update jcqn_doc02_03 set xuhao_id=?,user_id=?,thesis_topic=?,author_sort=?,journal_title=?,year_volume_pagenumber=?,influence_factor=?,sci_times=? where id=?";

	private final static String SQL_DEL_BY_ID = "delete from jcqn_doc02_03 where id = ?";
	// 通过user_id查询
	private final String SQL_GET_LIST_BY_USER_ID = "select * from jcqn_doc02_03 where user_id=?";

	public boolean insert(JcqnDocThesis user_chengguo) {
		return jdbcTemplate.update(SQL_INSERT_user_chengguo, new Object[] { user_chengguo.getXuhao_id(),user_chengguo.getUserId(), user_chengguo.getThesisTopic(), user_chengguo.getAuthorSort(), user_chengguo.getJournalTitle(),
				user_chengguo.getYearVolumePagenumber(), user_chengguo.getInfluenceFactor(), user_chengguo.getSciTimes() }) == 1;
	}

	public JcqnDocThesis get(int id) {
		return jdbcTemplate.query(SQL_Get_BY_ID, new Object[] { id }, new ResultSetExtractor<JcqnDocThesis>() {
			@Override
			public JcqnDocThesis extractData(ResultSet rs) throws SQLException, DataAccessException {
				JcqnDocThesis user_chengguo = new JcqnDocThesis();
				if (rs.next()) {
					user_chengguo.setXuhao_id(rs.getInt("xuhao_id"));
					user_chengguo.setId(rs.getInt("id"));
					user_chengguo.setUserId(rs.getInt("user_id"));
					user_chengguo.setThesisTopic(rs.getString("thesis_topic"));
					user_chengguo.setAuthorSort(rs.getString("author_sort"));
					user_chengguo.setJournalTitle(rs.getString("journal_title"));
					user_chengguo.setYearVolumePagenumber(rs.getString("year_volume_pagenumber"));
					user_chengguo.setInfluenceFactor(rs.getString("influence_factor"));
					user_chengguo.setSciTimes(rs.getString("sci_times"));

//					String temp = rs.getString("cg_date");
//					if (temp != null) {
//						String Year = temp.substring(0, 4);
//						String Month = temp.substring(5, 7);
//						String Day = temp.substring(8, 10);
//						temp = Year + "." + Month + "." + Day;
//					}
//					user_chengguo.setCg_date(temp);
//
//					user_chengguo.setCg_jieshao(rs.getString("cg_jieshao"));
//					user_chengguo.setJiaose(rs.getString("jiaose"));
//					user_chengguo.setType(rs.getString("type"));
//					user_chengguo.setYingxiangyinzi(rs.getString("yingxiangyinzi"));

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

	public boolean Update(JcqnDocThesis user_chengguo) {
		Object[] params = new Object[] { user_chengguo.getXuhao_id(),user_chengguo.getUserId(), user_chengguo.getThesisTopic(), user_chengguo.getAuthorSort(), user_chengguo.getJournalTitle(),
				user_chengguo.getYearVolumePagenumber(), user_chengguo.getInfluenceFactor(), user_chengguo.getSciTimes() };
		return jdbcTemplate.update(SQL_SET_user_chengguo_UPDATE, params) == 1;
	}

	public boolean delete(int id) {
		return jdbcTemplate.update(SQL_DEL_BY_ID, new Object[] { id }) == 1;
	}

	public boolean isPropertyUnique(String newLoginName, String oldLoginName) {
		return false;
	}

	public List<JcqnDocThesis> getAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(SQL_GET_user_chengguo_LIST, new user_chengguoRowMapper());
	}

	/**
	 * 定义内部类实现RowMapper接口
	 */
	public class user_chengguoRowMapper implements ParameterizedRowMapper<JcqnDocThesis> {
		// 实现mapRow方法
		@Override
		public JcqnDocThesis mapRow(ResultSet rs, int num) throws SQLException {
			// 对类进行封装
			JcqnDocThesis user_chengguo = new JcqnDocThesis();
			user_chengguo.setXuhao_id(rs.getInt("xuhao_id"));
			user_chengguo.setId(rs.getInt("id"));
			user_chengguo.setUserId(rs.getInt("user_id"));
			user_chengguo.setThesisTopic(rs.getString("thesis_topic"));
			user_chengguo.setAuthorSort(rs.getString("author_sort"));
			user_chengguo.setJournalTitle(rs.getString("journal_title"));
			user_chengguo.setYearVolumePagenumber(rs.getString("year_volume_pagenumber"));
			user_chengguo.setInfluenceFactor(rs.getString("influence_factor"));
			user_chengguo.setSciTimes(rs.getString("sci_times"));
			return user_chengguo;
		}
	}

	// 通过user_id查询
	public List<JcqnDocThesis> getAllByUserId(String user_id) {
		return jdbcTemplate.query(SQL_GET_LIST_BY_USER_ID, new Object[] { user_id }, new user_chengguoRowMapper());
	}
}
