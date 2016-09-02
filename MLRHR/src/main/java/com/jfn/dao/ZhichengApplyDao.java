package com.jfn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.stereotype.Repository;

import com.jfn.entity.Apply;

@Repository
public class ZhichengApplyDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String SQL_INSERT_Apply = "insert into apply(user_id,apply_date,apply_type,status,"
			+ "pre_approve_date,pre_approve_id,pre_approve_sug,finial_approve_date,finial_approve_id,"
			+ "finial_approve_sug,expert1_date,expert1_id,expert1_score,expert1_sug,expert2_date,expert2_id,expert2_score,expert2_sug) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	private final String SQL_Get_BY_ID = "select * from apply where Id=?";
	private final String SQL_GET_Apply_LIST = "select * from apply order by apply_date desc ";

	private final String SQL_GET_Apply_LIST_By_UserID = "select * from apply where user_id=? order by apply_date desc ";
	private final String SQL_GET_Apply_LIST_By_UserIDAndDate = "select * from apply where user_id=? and ( apply_date between ? and ?)  order by apply_date desc ";

	private final String SQL_SET_Apply_UPDATE = "update apply set user_id=?,apply_date = ?,apply_type = ?,status = ?,pre_approve_date = ?,pre_approve_id = ?,pre_approve_sug = ?,finial_approve_date=?,finial_approve_id = ?,finial_approve_sug = ?,expert1_date = ?,expert1_id = ?,expert1_score = ?,expert1_sug = ?,expert2_date = ?,expert2_id = ?,expert2_score = ?,expert2_sug = ? where id=?";

	private final static String SQL_DEL_BY_ID = "delete from apply where id = ?";
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	public boolean insert(Apply Apply) {
		return jdbcTemplate.update(
				SQL_INSERT_Apply,
				new Object[] { Apply.getUser_id(),Apply.getApply_date(),Apply.getApply_type(), 
						Apply.getStatus(),sdf.format(new Date()),  Apply.getPre_approve_id(),Apply.getPre_approve_sug(),sdf.format(new Date()), Apply.getFinial_approve_id(),
						Apply.getFinial_approve_sug(),sdf.format(new Date()),Apply.getExpert1_id(),Apply.getExpert1_score(),Apply.getExpert1_sug(),sdf.format(new Date()),Apply.getExpert2_id(),Apply.getExpert2_score(),Apply.getExpert2_sug() }) == 1;
	}

	public Apply get(int id) {
		return jdbcTemplate.query(SQL_Get_BY_ID, new Object[] { id }, new ResultSetExtractor<Apply>() {
			@Override
			public Apply extractData(ResultSet rs) throws SQLException, DataAccessException {
				Apply Apply = new Apply();
				if (rs.next()) {
					Apply.setId(rs.getInt("id"));
					Apply.setApply_type(rs.getString("apply_type"));
//					Apply.setApply_name(rs.getString("apply_name"));
					Apply.setUser_id(rs.getInt("user_id"));

					// 下面是截取时间，例：2014-09-15 18:55:50.275 最后.275去掉。
					String apply_date = rs.getString("apply_date");
					String a[] = apply_date.split("\\.");

					String temp = a[0];
					if (temp != null) {
						String Year = temp.substring(0, 4);
						String Month = temp.substring(5, 7);
						String Day = temp.substring(8, 19);
						temp = Year + "." + Month + "." + Day;
					}

					Apply.setApply_date(temp);

					Apply.setStatus(rs.getString("status"));

					temp = rs.getString("pre_approve_date");
					if (temp != null) {
						String Year = temp.substring(0, 4);
						String Month = temp.substring(5, 7);
						String Day = temp.substring(8, 10);
						temp = Year + "." + Month + "." + Day;
					}
					Apply.setPre_approve_date(temp);
					Apply.setPre_approve_id(rs.getString("pre_approve_id"));

					Apply.setPre_approve_sug(rs.getString("pre_approve_sug"));

					temp = rs.getString("finial_approve_date");
					if (temp != null) {
						String Year = temp.substring(0, 4);
						String Month = temp.substring(5, 7);
						String Day = temp.substring(8, 10);
						temp = Year + "." + Month + "." + Day;
					}
					Apply.setFinial_approve_date(temp);
					Apply.setFinial_approve_id(rs.getString("finial_approve_id"));
					Apply.setFinial_approve_sug(rs.getString("finial_approve_sug"));
//					expert1_date,expert1_id,expert1_score,expert1_sug,expert2_date,expert2_id,expert2_score,expert2_sug
					temp = rs.getString("expert1_date");
					if (temp != null) {
						String Year = temp.substring(0, 4);
						String Month = temp.substring(5, 7);
						String Day = temp.substring(8, 10);
						temp = Year + "." + Month + "." + Day;
					}					
					Apply.setExpert1_date(rs.getString("expert1_date"));
					Apply.setExpert1_id(rs.getString("expert1_id"));
					Apply.setExpert1_score(rs.getString("expert1_score"));
					Apply.setExpert1_sug(rs.getString("expert1_sug"));
					
					Apply.setExpert2_date(rs.getString("expert2_date"));
					Apply.setExpert2_id(rs.getString("expert2_id"));
					Apply.setExpert2_score(rs.getString("expert2_score"));
					Apply.setExpert2_sug(rs.getString("expert2_sug"));
				}
				return Apply;
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
//	insert into apply(user_id,apply_date,apply_type,status,"
//			+ "pre_approve_date,pre_approve_id,pre_approve_sug,finial_approve_date,finial_approve_id,"
//			+ "finial_approve_sug,expert1_date,expert1_id,expert1_score,expert1_sug,expert2_date,expert2_id,expert2_score,expert2_sug) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public boolean Update(Apply Apply) {

		Object[] params = new Object[] { Apply.getUser_id(),Apply.getApply_type(), 
				Apply.getStatus(),sdf.format(new Date()),  Apply.getPre_approve_id(),Apply.getPre_approve_sug(),sdf.format(new Date()), Apply.getFinial_approve_id(),
				Apply.getFinial_approve_sug(),sdf.format(new Date()),Apply.getId() };
//		Object[] params = new Object[] { Apply.getUser_id(),Apply.getApply_date(),Apply.getApply_type(), 
//				Apply.getStatus(),sdf.format(new Date()),  Apply.getPre_approve_id(),Apply.getPre_approve_sug(),sdf.format(new Date()), Apply.getFinial_approve_id(),
//				Apply.getFinial_approve_sug(),sdf.format(new Date()),Apply.getExpert1_id(),Apply.getExpert1_score(),Apply.getExpert1_sug(),sdf.format(new Date()),Apply.getExpert2_id(),Apply.getExpert2_score(),Apply.getExpert2_sug(),Apply.getId() };
		return jdbcTemplate.update(SQL_SET_Apply_UPDATE, params) == 1;
	}

	public boolean delete(int id) {
		return jdbcTemplate.update(SQL_DEL_BY_ID, new Object[] { id }) == 1;
	}

	public List<Apply> getAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(SQL_GET_Apply_LIST, new ApplyRowMapper());
	}

	/**
	 * 定义内部类实现RowMapper接口
	 */
	public class ApplyRowMapper implements ParameterizedRowMapper<Apply> {
		// 实现mapRow方法
		@Override
		public Apply mapRow(ResultSet rs, int num) throws SQLException {
			// 对类进行封装
			Apply Apply = new Apply();
			Apply.setId(rs.getInt("id"));
			Apply.setApply_type(rs.getString("apply_type"));
//			Apply.setApply_name(rs.getString("apply_name"));
			Apply.setUser_id(rs.getInt("user_id"));

			// 下面是截取时间，例：2014-09-15 18:55:50.275 最后.275去掉。
			String apply_date = rs.getString("apply_date");
			String a[] = apply_date.split("\\.");

			String temp = a[0];
			if (temp != null) {
				String Year = temp.substring(0, 4);
				String Month = temp.substring(5, 7);
				String Day = temp.substring(8, 19);
				temp = Year + "." + Month + "." + Day;
			}

			Apply.setApply_date(temp);

			Apply.setStatus(rs.getString("status"));

			temp = rs.getString("pre_approve_date");
			if (temp != null) {
				String Year = temp.substring(0, 4);
				String Month = temp.substring(5, 7);
				String Day = temp.substring(8, 10);
				temp = Year + "." + Month + "." + Day;
			}
			Apply.setPre_approve_date(temp);
			Apply.setPre_approve_id(rs.getString("pre_approve_id"));

			Apply.setPre_approve_sug(rs.getString("pre_approve_sug"));

			temp = rs.getString("finial_approve_date");
			if (temp != null) {
				String Year = temp.substring(0, 4);
				String Month = temp.substring(5, 7);
				String Day = temp.substring(8, 10);
				temp = Year + "." + Month + "." + Day;
			}
			Apply.setFinial_approve_date(temp);
			Apply.setFinial_approve_id(rs.getString("finial_approve_id"));
			Apply.setFinial_approve_sug(rs.getString("finial_approve_sug"));
//			expert1_date,expert1_id,expert1_score,expert1_sug,expert2_date,expert2_id,expert2_score,expert2_sug
			temp = rs.getString("expert1_date");
			if (temp != null) {
				String Year = temp.substring(0, 4);
				String Month = temp.substring(5, 7);
				String Day = temp.substring(8, 10);
				temp = Year + "." + Month + "." + Day;
			}					
			Apply.setExpert1_date(rs.getString("expert1_date"));
			Apply.setExpert1_id(rs.getString("expert1_id"));
			Apply.setExpert1_score(rs.getString("expert1_score"));
			Apply.setExpert1_sug(rs.getString("expert1_sug"));
			
			Apply.setExpert2_date(rs.getString("expert2_date"));
			Apply.setExpert2_id(rs.getString("expert2_id"));
			Apply.setExpert2_score(rs.getString("expert2_score"));
			Apply.setExpert2_sug(rs.getString("expert2_sug"));
			return Apply;
		}
	}

	public List<Apply> getAllByUserId(Integer userid) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(SQL_GET_Apply_LIST_By_UserID, new Object[] { userid }, new ApplyRowMapper());
	}

	public List<Apply> getUserByUserIdAndDate(Integer userid, String startDate, String endDate) {
		// TODO Auto-generated method stub
		if (startDate.equals("") && endDate.equals(""))
			return jdbcTemplate.query(SQL_GET_Apply_LIST_By_UserID, new Object[] { userid }, new ApplyRowMapper());
		else
			return jdbcTemplate.query(SQL_GET_Apply_LIST_By_UserIDAndDate, new Object[] { userid, startDate, endDate }, new ApplyRowMapper());
	}

}
