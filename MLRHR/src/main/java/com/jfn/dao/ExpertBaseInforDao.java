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

import com.jfn.entity.ExpertBaseInfor;
import com.jfn.entity.UserBaseInfor;

/**
 * @create-time 2014-8-13 下午5:47:02
 * @author 佟德慧
 * @remarks 增加userBaseInfor其他信息变量后修改
 */
@Repository
public class ExpertBaseInforDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String SQL_Get_BY_ID = "select * from expert_user where Id=?";
	private final String SQL_Get_BY_USER_ID = "select * from expert_user where user_id=?";
	private final String SQL_INSERT_USER_NEW = "insert into expert_user(user_id,group_id,team_leader_type,gender,minzu,birthday,address,zhicheng,congshizhuanye,within_beijing,name,id_num,canjiashijian,xingzhengzhiwu) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private final String SQL_GET_USER_LIST = "select * from expert_user";
	private final String SQL_SET_USER_UPDATE_DETAIL = "update expert_user set user_id=?, group_id=?,team_leader_type=?,gender=?,minzu=?,birthday=?,address=?,zhicheng=?,congshizhuanye=?,within_beijing=?,name=?,id_num=?,canjiashijian=?,xingzhengzhiwu=? where id=?";
	private final static String SQL_DEL_BY_ID = "delete from expert_user where user_id = ?";

	public boolean insert(ExpertBaseInfor userBaseInfor) {

		return jdbcTemplate.update(
				SQL_INSERT_USER_NEW,
				new Object[] { userBaseInfor.getUser_id(),userBaseInfor.getGroup_id(),userBaseInfor.getTeam_leader_type(), 
						userBaseInfor.getGender(),userBaseInfor.getMinzu(),userBaseInfor.getBirthday() != "" ? 
						userBaseInfor.getBirthday() : null, userBaseInfor.getAddress(),	userBaseInfor.getZhicheng(),
						userBaseInfor.getCongshizhuanye() ,userBaseInfor.getWithin_beijing(),userBaseInfor.getName(),
						userBaseInfor.getId_num(),userBaseInfor.getCanjiashijian(),userBaseInfor.getXingzhengzhiwu()}) == 1;
	}

	public ExpertBaseInfor get(int id) {
		return jdbcTemplate.query(SQL_Get_BY_ID, new Object[] { id }, new ResultSetExtractor<ExpertBaseInfor>() {
			@Override
			public ExpertBaseInfor extractData(ResultSet rs) throws SQLException, DataAccessException {
				ExpertBaseInfor userBaseInfor = new ExpertBaseInfor();
				if (rs.next()) {
					userBaseInfor.setId(rs.getInt("id"));
					userBaseInfor.setUser_id(rs.getInt("user_id"));
					userBaseInfor.setGroup_id(rs.getString("group_id"));
//					zhicheng,congshizhuanye,within_beijing,name,id_num,canjiashijian,xingzhengzhiwu
					userBaseInfor.setTeam_leader_type(rs.getString("team_leader_type"));
					userBaseInfor.setGender(rs.getString("gender"));
					userBaseInfor.setMinzu(rs.getString("minzu"));
					String temp = rs.getString("birthday");
					if (temp != null) {
						String Year = temp.substring(0, 4);
						String Month = temp.substring(5, 7);
						String Day = temp.substring(8, 10);
						temp = Year + "." + Month + "." + Day;
					}
					userBaseInfor.setBirthday(temp);
                     userBaseInfor.setAddress(rs.getString("address"));
					userBaseInfor.setZhicheng(rs.getString("zhicheng"));
                    userBaseInfor.setCongshizhuanye(rs.getString("congshizhuanye"));
                    userBaseInfor.setWithin_beijing(rs.getString("within_beijing"));
                    userBaseInfor.setName(rs.getString("name"));
                    userBaseInfor.setId_num(rs.getString("id_num"));
                    userBaseInfor.setCanjiashijian(rs.getString("canjiashijian"));
                    userBaseInfor.setXingzhengzhiwu(rs.getString("xingzhengzhiwu"));				
				}
				return userBaseInfor;
			}
		});
	}

	public ExpertBaseInfor getByUserId(int id) {
		return jdbcTemplate.query(SQL_Get_BY_USER_ID, new Object[] { id }, new ResultSetExtractor<ExpertBaseInfor>() {
			@Override
			public ExpertBaseInfor extractData(ResultSet rs) throws SQLException, DataAccessException {
				ExpertBaseInfor userBaseInfor = new ExpertBaseInfor();
				if (rs.next()) {
					userBaseInfor.setId(rs.getInt("id"));
					userBaseInfor.setUser_id(rs.getInt("user_id"));
					userBaseInfor.setGroup_id(rs.getString("group_id"));
//					zhicheng,congshizhuanye,within_beijing,name,id_num,canjiashijian,xingzhengzhiwu
					userBaseInfor.setTeam_leader_type(rs.getString("team_leader_type"));
					userBaseInfor.setGender(rs.getString("gender"));
					userBaseInfor.setMinzu(rs.getString("minzu"));
					String temp = rs.getString("birthday");
					if (temp != null) {
						String Year = temp.substring(0, 4);
						String Month = temp.substring(5, 7);
						String Day = temp.substring(8, 10);
						temp = Year + "." + Month + "." + Day;
					}
					userBaseInfor.setBirthday(temp);
                     userBaseInfor.setAddress(rs.getString("address"));
					userBaseInfor.setZhicheng(rs.getString("zhicheng"));
                    userBaseInfor.setCongshizhuanye(rs.getString("congshizhuanye"));
                    userBaseInfor.setWithin_beijing(rs.getString("within_beijing"));
                    userBaseInfor.setName(rs.getString("name"));
                    userBaseInfor.setId_num(rs.getString("id_num"));
                    userBaseInfor.setCanjiashijian(rs.getString("canjiashijian"));
                    userBaseInfor.setXingzhengzhiwu(rs.getString("xingzhengzhiwu"));				
				
				}
				return userBaseInfor;
			}
		});
	}

	public boolean delete(int user_id) {
		return jdbcTemplate.update(SQL_DEL_BY_ID, new Object[] { user_id }) == 1;
	}

	public boolean isPropertyUnique(String newLoginName, String oldLoginName) {
		return false;
	}

	public List<ExpertBaseInfor> getAll() {
		return jdbcTemplate.query(SQL_GET_USER_LIST, new UserBaseInforRowMapper());
	}

	/**
	 * 定义内部类实现RowMapper接口
	 */
	public class UserBaseInforRowMapper implements ParameterizedRowMapper<ExpertBaseInfor> {
		// 实现mapRow方法
		@Override
		public ExpertBaseInfor mapRow(ResultSet rs, int num) throws SQLException {
			// 对类进行封装
			ExpertBaseInfor userBaseInfor = new ExpertBaseInfor();
			userBaseInfor.setId(rs.getInt("id"));
			userBaseInfor.setUser_id(rs.getInt("user_id"));
			userBaseInfor.setGroup_id(rs.getString("group_id"));
//			zhicheng,congshizhuanye,within_beijing,name,id_num,canjiashijian,xingzhengzhiwu
			userBaseInfor.setTeam_leader_type(rs.getString("team_leader_type"));
			userBaseInfor.setGender(rs.getString("gender"));
			userBaseInfor.setMinzu(rs.getString("minzu"));
			String temp = rs.getString("birthday");
			if (temp != null) {
				String Year = temp.substring(0, 4);
				String Month = temp.substring(5, 7);
				String Day = temp.substring(8, 10);
				temp = Year + "." + Month + "." + Day;
			}
			userBaseInfor.setBirthday(temp);
             userBaseInfor.setAddress(rs.getString("address"));
			userBaseInfor.setZhicheng(rs.getString("zhicheng"));
            userBaseInfor.setCongshizhuanye(rs.getString("congshizhuanye"));
            userBaseInfor.setWithin_beijing(rs.getString("within_beijing"));
            userBaseInfor.setName(rs.getString("name"));
            userBaseInfor.setId_num(rs.getString("id_num"));
            userBaseInfor.setCanjiashijian(rs.getString("canjiashijian"));
            userBaseInfor.setXingzhengzhiwu(rs.getString("xingzhengzhiwu"));
			return userBaseInfor;
		}
	}

	// 完善个人信息（不修改login_name,login_pwd）
	public boolean UpdateDetail(ExpertBaseInfor userBaseInfor) {
		Object[] params = new Object[] {userBaseInfor.getUser_id(),userBaseInfor.getGroup_id(),userBaseInfor.getTeam_leader_type(), 
				userBaseInfor.getGender(),userBaseInfor.getMinzu(),userBaseInfor.getBirthday() != "" ? 
				userBaseInfor.getBirthday() : null, userBaseInfor.getAddress(),	userBaseInfor.getZhicheng(),
				userBaseInfor.getCongshizhuanye() ,userBaseInfor.getWithin_beijing(),userBaseInfor.getName(),
				userBaseInfor.getId_num(),userBaseInfor.getCanjiashijian(),userBaseInfor.getXingzhengzhiwu() };
		return jdbcTemplate.update(SQL_SET_USER_UPDATE_DETAIL, params) == 1;
	}
}
