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
import org.springside.modules.utils.MD5Utils;

import com.jfn.entity.LoginUser;
import com.jfn.entity.Role;
import com.jfn.entity.User;

/**
 * @create-time 2014-8-13 下午5:47:02
 * @author 佟德慧
 * @remarks 增加user其他信息变量后修改
 */
@Repository
public class UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String SQL_INSERT_USER = "insert into acct_user(apply_name,email,login_name,name,password,body_id,id_num,telephone,mobile,telefax,zip_code) values(?,?,?,?,?,?,?,?,?,?,?)";
	private final String SQL_CHECK_LOGIN_NAME = "select count(id) from acct_user where login_name=?";
	private final String SQL_INSERT_USER_NEW = "insert into acct_user(login_name,name,id_num,email,body_id,password) values(?,?,?,?,?,?)";
	private final String SQL_Get_BY_ID = "select * from acct_user where Id=?";
	private final String SQL_GET_USER_LIST = "select * from acct_user";
	// 通过body_id查询user
	private final String SQL_GET_USER_LIST_BY_BODYID = "select * from acct_user where body_id=?";
	private final String SQL_Get_BY_Username = "select * from acct_user where login_name=?";
	private final String SQL_Get_BY_Uname = "select * from acct_user where name=?";
	private final String SQL_SET_USER_UPDATE = "update acct_user set name=?,login_name=?,email=?,body_id=?,id_num=? ,password=?  where id=?";
	// 完善个人信息（不修改login_name,login_pwd）
	private final String SQL_SET_USER_UPDATE_DETAIL = "update acct_user set body_id=?,email=?,id_num=?,mobile=?,name=?,telefax=?,telephone=? where id=?";

	private final static String SQL_DEL_BY_ID = "delete from acct_user where id = ?";
	private final static String SQL_CPW = "update acct_user set password=? where login_name=?";
	private final static String SQL_CHECK_LOGIN = "select count(id) from acct_user where login_name=? and password=?";

	private final static String SQL_DEL_USER_ROLE = "delete from acct_user_role where user_id=?";

	private final static String default_password = "cags123";

	private static final String SQL_INSERT_USER_RIGHT = "insert into acct_user_role(user_id,role_id) values(?,?)";

	private static final String SQL_GET_USER_ROLE_NAME = "select acct_role.name as role_name from acct_role, acct_user_role where acct_role.id = acct_user_role.role_id and acct_user_role.user_id=?";

	public boolean checkUsernameExists(String login_name) {
		return jdbcTemplate.queryForInt(SQL_CHECK_LOGIN_NAME, new Object[] { login_name }) == 0;
	}

	public boolean checkLogin(String login_name, String password) {
		return jdbcTemplate.queryForInt(SQL_CHECK_LOGIN, new Object[] { login_name, password }) > 0;
	}

	public boolean save(String login_name, String login_pwd) {
		return jdbcTemplate.update(SQL_CPW, new Object[] { login_pwd, login_name }) == 1;
	}

	public boolean add(LoginUser user) {
		return jdbcTemplate.update(SQL_INSERT_USER, new Object[] { user.getLogin_name(), user.getLogin_pwd(), user.getUsername() == "" ? " " : user.getUsername() }) == 1;
	}

	public boolean insert(User user) {
		return jdbcTemplate.update(SQL_INSERT_USER_NEW,
				new Object[] { user.getLoginName(), MD5Utils.PasswordEncryptByMD5(default_password), user.getName() == "" ? " " : user.getName(), user.getEmail(), user.getBody_id() }) == 1;
	}

	public User get(int id) {
		return jdbcTemplate.query(SQL_Get_BY_ID, new Object[] { id }, new ResultSetExtractor<User>() {
			@Override
			public User extractData(ResultSet rs) throws SQLException, DataAccessException {
				User user = new User();
				if (rs.next()) {
					user.setId(rs.getInt("id"));
					user.setApply_name(rs.getString("apply_name"));
					user.setEmail(rs.getString("email"));
					user.setLoginName(rs.getString("login_name"));
					user.setName(rs.getString("name"));
					user.setPassword(rs.getString("password"));
					user.setBody_id(rs.getString("body_id"));
					user.setId_num(rs.getString("id_num"));
					user.setTelephone(rs.getString("telephone"));
					user.setMobile(rs.getString("mobile"));
					user.setTelefax(rs.getString("telefax"));
					user.setTelephone(rs.getString("zip_code"));
				}
				return user;
			}
		});
	}

	public User getByLoginName(String login_name) {
		return jdbcTemplate.query(SQL_Get_BY_Username, new Object[] { login_name }, new ResultSetExtractor<User>() {
			@Override
			public User extractData(ResultSet rs) throws SQLException, DataAccessException {
				User user = new User();
				if (rs.next()) {
					user.setId(rs.getInt("id"));
					user.setApply_name(rs.getString("apply_name"));
					user.setEmail(rs.getString("email"));
					user.setLoginName(rs.getString("login_name"));
					user.setName(rs.getString("name"));
					user.setPassword(rs.getString("password"));
					user.setBody_id(rs.getString("body_id"));
					user.setId_num(rs.getString("id_num"));
					user.setTelephone(rs.getString("telephone"));
					user.setMobile(rs.getString("mobile"));
					user.setTelefax(rs.getString("telefax"));
					user.setTelephone(rs.getString("zip_code"));
				}
				return user;
			}
		});
	}

	public int getUserCount() {
		return 0;
	}

	/**
	 * 修改保存
	 * 
	 * @param request
	 * @param model
	 * @return
	 */

	public boolean Update(User user) {
		Object[] params = new Object[] { user.getName() == "" ? " " : user.getName(), user.getLoginName(), user.getEmail(), user.getBody_id(), user.getId_num(), user.getPassword(), user.getId() };
		return jdbcTemplate.update(SQL_SET_USER_UPDATE, params) == 1;
	}

	public void deleteUserRole(int id) {
		jdbcTemplate.update(SQL_DEL_USER_ROLE, new Object[] { id });
	}

	public boolean delete(int id) {
		return jdbcTemplate.update(SQL_DEL_BY_ID, new Object[] { id }) == 1;
	}

	public boolean isPropertyUnique(String newLoginName, String oldLoginName) {
		return false;
	}

	public List<User> getAll() {
		return jdbcTemplate.query(SQL_GET_USER_LIST, new UserRowMapper());
	}

	/**
	 * 定义内部类实现RowMapper接口
	 */
	public class UserRowMapper implements ParameterizedRowMapper<User> {
		// 实现mapRow方法
		@Override
		public User mapRow(ResultSet rs, int num) throws SQLException {
			// 对类进行封装
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setApply_name(rs.getString("apply_name"));
			user.setEmail(rs.getString("email"));
			user.setLoginName(rs.getString("login_name"));
			user.setName(rs.getString("name"));
			user.setPassword(rs.getString("password"));
			user.setBody_id(rs.getString("body_id"));
			user.setId_num(rs.getString("id_num"));
			user.setTelephone(rs.getString("telephone"));
			user.setMobile(rs.getString("mobile"));
			user.setTelefax(rs.getString("telefax"));
			user.setTelephone(rs.getString("zip_code"));
			return user;
		}
	}

	/**
	 * 定义内部类实现RowMapper接口
	 */
	public class RoleRowMapper implements ParameterizedRowMapper<Role> {
		// 实现mapRow方法
		@Override
		public Role mapRow(ResultSet rs, int num) throws SQLException {
			// 对类进行封装
			Role role = new Role();
			role.setName(rs.getString("role_name"));
			return role;
		}
	}

	public User findUserByName(String name) {
		return jdbcTemplate.query(SQL_Get_BY_Uname, new Object[] { name }, new ResultSetExtractor<User>() {
			@Override
			public User extractData(ResultSet rs) throws SQLException, DataAccessException {
				User user = new User();
				if (rs.next()) {
					user.setId(rs.getInt("id"));
					user.setApply_name(rs.getString("apply_name"));
					user.setEmail(rs.getString("email"));
					user.setLoginName(rs.getString("login_name"));
					user.setName(rs.getString("name"));
					user.setPassword(rs.getString("password"));
					user.setBody_id(rs.getString("body_id"));
					user.setId_num(rs.getString("id_num"));
					user.setTelephone(rs.getString("telephone"));
					user.setMobile(rs.getString("mobile"));
					user.setTelefax(rs.getString("telefax"));
					user.setTelephone(rs.getString("zip_code"));
				}
				return user;
			}
		});
	}

	// 完善个人信息（不修改login_name,login_pwd）
	public boolean UpdateDetail(User user) {
		Object[] params = new Object[] { user.getBody_id(), user.getEmail(), user.getId_num(), user.getMobile(), user.getName() == "" ? " " : user.getName(), user.getTelefax(), user.getTelephone(),
				user.getId() };
		return jdbcTemplate.update(SQL_SET_USER_UPDATE_DETAIL, params) == 1;
	}

	public boolean regUser(String j_username, String j_idnum, String j_email, String j_body, String j_password) {
		return jdbcTemplate.update(SQL_INSERT_USER_NEW, new Object[] { j_idnum, j_username, j_idnum, j_email, j_body, MD5Utils.PasswordEncryptByMD5(j_password) }) == 1;
	}

	public boolean setRight(Integer id, int i) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(SQL_INSERT_USER_RIGHT, new Object[] { id, i }) == 1;
	}

	// 通过body_id查询user
	public List<User> getAllByBodyId(String body_id) {
		return jdbcTemplate.query(SQL_GET_USER_LIST_BY_BODYID, new Object[] { body_id }, new UserRowMapper());
	}

	public List<Role> getUserRole(Integer userid) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(SQL_GET_USER_ROLE_NAME, new Object[] { userid }, new RoleRowMapper());
	}
}
