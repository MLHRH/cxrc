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

import com.jfn.entity.ExpertUser;

/**
 * 专家dao author :dongshuaishuai
 */
@Repository
public class ExpertUserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String SQL_INSERT
			= "insert into expert_user(user_id,group_id,team_leader_type,gender,minzu,birthday,address,zhicheng,congshizhuanye,within_beijing,xingzhengzhiwu) values(?,?,?,?,?,?,?,?,?,?,?)";
	private final String SQL_UPDATE = "update expert_user set group_id=?,team_leader_type=?,gender=?,minzu=?,birthday=?,address=?,zhicheng=?,congshizhuanye=?,within_beijing=?,xingzhengzhiwu=?  where user_id=?";
	private final String SQL_GET_ALL = "select*from expert_user";
	private final String SQL_GET_BY_GROUP_ID = "select*from expert_user where group_id=?";
	private final String SQL_GET_BY_USER_ID ="select*from expert_user where user_id=?";

	public boolean update(ExpertUser expertUser) {
		Object[] params = new Object[] {

				expertUser.getGroup_id(), expertUser.getTeam_leader_type(), expertUser.getGender(),
				expertUser.getMinzu(),
				expertUser.getBirthday(),
				expertUser.getAddress(),
				expertUser.getZhicheng(), expertUser.getCongshizhuanye(), expertUser.getWithin_beijing(),expertUser.getXingzhengzhiwu(),
				expertUser.getUser_id()

		};
		return jdbcTemplate.update(SQL_UPDATE, params) == 1;

	}

	public boolean insert(ExpertUser expertUser) {

		return jdbcTemplate.update(SQL_INSERT,
				new Object[] { expertUser.getUser_id(),1,expertUser.getTeam_leader_type(),  expertUser.getGender(), expertUser.getMinzu(), expertUser.getBirthday(),expertUser.getAddress(),
						expertUser.getZhicheng(), 
						expertUser.getCongshizhuanye(), expertUser.getWithin_beijing(),expertUser.getXingzhengzhiwu()
						

				}) == 1;
	}

	public List<ExpertUser> queryExpertUser() {
		return jdbcTemplate.query(SQL_GET_ALL, new ExpertUserMapper());
	}

	public List<ExpertUser> getByGroupId(int group_id) {
		return jdbcTemplate.query(SQL_GET_BY_GROUP_ID, new Object[] { group_id }, new ExpertUserMapper());
	}
	
	public ExpertUser getByUserId(int user_id) {
		return jdbcTemplate.query(SQL_GET_BY_USER_ID, new Object[] { user_id },
				new ResultSetExtractor<ExpertUser>() {
			@Override
			public ExpertUser extractData(ResultSet rs)
					throws SQLException, DataAccessException {
				ExpertUser expertUser = new ExpertUser();
				if (rs.next()) {
					expertUser.setAddress(rs.getString("address"));
					expertUser.setBirthday(rs.getString("birthday"));
					expertUser.setCongshizhuanye(rs.getString("congshizhuanye"));
					expertUser.setGender(rs.getString("gender"));
					expertUser.setGroup_id(rs.getInt("group_id"));
					expertUser.setMinzu(rs.getString("minzu"));
					expertUser.setTeam_leader_type(rs.getInt("team_leader_type"));
					expertUser.setWithin_beijing(rs.getString("within_beijing"));
					expertUser.setXingzhengzhiwu(rs.getString("xingzhengzhiwu"));
					expertUser.setZhicheng(rs.getString("zhicheng"));
							expertUser.setUser_id(rs.getInt("user_id"));

				}
				return expertUser;
			}
		});
}

	/**
	 * 定义内部类实现RowMapper接口
	 */
	public class ExpertUserMapper implements ParameterizedRowMapper<ExpertUser> {
		// 实现mapRow方法
		@Override
		public ExpertUser mapRow(ResultSet rs, int num) throws SQLException {
			// 对类进行封装
			ExpertUser expertUser = new ExpertUser();
			expertUser.setAddress(rs.getString("address"));
			expertUser.setBirthday(rs.getString("birthday"));
			expertUser.setCongshizhuanye(rs.getString("congshizhuanye"));
			expertUser.setGender(rs.getString("gender"));
			expertUser.setGroup_id(rs.getInt("group_id"));
			expertUser.setMinzu(rs.getString("minzu"));
			expertUser.setTeam_leader_type(rs.getInt("team_leader_type"));
			expertUser.setUser_id(rs.getInt("user_id"));
			expertUser.setWithin_beijing(rs.getString("within_beijing"));
			expertUser.setXingzhengzhiwu(rs.getString("xingzhengzhiwu"));
			expertUser.setZhicheng(rs.getString("zhicheng"));
			return expertUser;
		}
	}

}
