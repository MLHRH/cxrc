package com.jfn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.stereotype.Repository;

import com.jfn.entity.JcqnDoc01;

@Repository
public class JcqnDoc01Dao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String SQL_INSERT = "insert into jcqn_doc01(user_id,name,sex,minzu,birthday,title,document_type,document_number,direction,declaration_area,telephone,fax,mobile_phone,email,zip_code,addresses,"
			+ "unit_name,organization_code,legal_representative,"
			+ "supervisor_unit,unit_address,postcode,unit_contact,work_telephone,work_fax) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private final String SQL_Get_BY_ID = "select * from jcqn_doc01 where Id=?";
	private final String SQL_Get_BY_USERID = "select * from jcqn_doc01 where user_id=?";
	private final String SQL_SET_UPDATE = "update jcqn_doc01 set name=?,sex=?,minzu=?,birthday=?,title=?,document_type=?,"
			+ "document_number=?,direction=?,declaration_area=?,telephone=?,fax=?,mobile_phone=?,email=?,zip_code=?,addresses=?,"
			+ "unit_name=?,organization_code=?,legal_representative=?,supervisor_unit=?,unit_address=?,postcode=?,unit_contact=?,"
			+ "work_telephone=?,work_fax=? where user_id=?";
	// 查询是否已经有数据写入
	// private final String SQL_QUERY_EXISTED = "SELECT COUNT(id) from
	// jcqn_doc01 where user_id = ?";

	private final String SQL_DEL_BY_USERID = "delete from jcqn_doc01 where user_id = ?";

	// 插入数据
	public boolean insert(JcqnDoc01 jcqndoc01) {

		return jdbcTemplate.update(SQL_INSERT,
				new Object[] { jcqndoc01.getUser_id(), jcqndoc01.getName(), jcqndoc01.getSex(), jcqndoc01.getMinzu(),
						jcqndoc01.getBirthday(), jcqndoc01.getTitle(), jcqndoc01.getDocument_type(),
						jcqndoc01.getDocument_number(), jcqndoc01.getDirection(), jcqndoc01.getDeclaration_area(),
						jcqndoc01.getTelephone(), jcqndoc01.getFax(), jcqndoc01.getMobile_phone(), jcqndoc01.getEmail(),
						jcqndoc01.getZip_code(), jcqndoc01.getAddresses(), jcqndoc01.getUnit_name(),
						jcqndoc01.getOrganization_code(), jcqndoc01.getLegal_representative(),
						jcqndoc01.getSupervisor_unit(), jcqndoc01.getUnit_address(), jcqndoc01.getPostcode(),
						jcqndoc01.getUnit_contact(), jcqndoc01.getWork_telephone(), jcqndoc01.getWork_fax() }) == 1;
	}

	public boolean update(JcqnDoc01 jcqndoc01) {
		Object[] params = new Object[] {

				jcqndoc01.getName(), jcqndoc01.getSex(), jcqndoc01.getMinzu(), jcqndoc01.getBirthday(),
				jcqndoc01.getTitle(), jcqndoc01.getDocument_type(), jcqndoc01.getDocument_number(),
				jcqndoc01.getDirection(), jcqndoc01.getDeclaration_area(), jcqndoc01.getTelephone(), jcqndoc01.getFax(),
				jcqndoc01.getMobile_phone(), jcqndoc01.getEmail(), jcqndoc01.getZip_code(), jcqndoc01.getAddresses(),
				jcqndoc01.getUnit_name(), jcqndoc01.getOrganization_code(), jcqndoc01.getLegal_representative(),
				jcqndoc01.getSupervisor_unit(), jcqndoc01.getUnit_address(), jcqndoc01.getPostcode(),
				jcqndoc01.getUnit_contact(), jcqndoc01.getWork_telephone(), jcqndoc01.getWork_fax(),
				jcqndoc01.getUser_id()

		};
		return jdbcTemplate.update(SQL_SET_UPDATE, params) == 1;

	}

	public boolean delete(int user_id) {
		return jdbcTemplate.update(SQL_DEL_BY_USERID, new Object[] { user_id }) == 1;
	}

	// 根据USERID查询
	public JcqnDoc01 getByUserId(int user_id) {
		return jdbcTemplate.query(SQL_Get_BY_USERID, new Object[] { user_id }, new ResultSetExtractor<JcqnDoc01>() {
			@Override
			public JcqnDoc01 extractData(ResultSet rs) throws SQLException, DataAccessException {
				JcqnDoc01 jcqndoc01 = new JcqnDoc01();
				if (rs.next()) {
					jcqndoc01.setId(rs.getInt("id"));
					jcqndoc01.setUser_id(rs.getInt("user_id"));
					jcqndoc01.setName(rs.getString("name"));
					jcqndoc01.setSex(rs.getString("sex"));
					jcqndoc01.setMinzu(rs.getString("minzu"));
					// String temp = rs.getString("birthday");
					// if (temp != null && !temp.equals("")) {
					// String Year = temp.substring(0, 4);
					// String Month = temp.substring(5, 7);
					// String Day = temp.substring(8, 10);
					// temp = Year + "." + Month + "." + Day;
					// }
					jcqndoc01.setBirthday(rs.getString("birthday"));
					jcqndoc01.setTitle(rs.getString("title"));
					jcqndoc01.setDocument_type(rs.getString("document_type"));
					jcqndoc01.setDocument_number(rs.getString("document_number"));
					jcqndoc01.setDirection(rs.getString("direction"));
					jcqndoc01.setDeclaration_area(rs.getString("declaration_area"));
					jcqndoc01.setTelephone(rs.getString("telephone"));
					jcqndoc01.setFax(rs.getString("fax"));
					jcqndoc01.setMobile_phone(rs.getString("mobile_phone"));
					jcqndoc01.setEmail(rs.getString("email"));
					jcqndoc01.setZip_code(rs.getString("zip_code"));
					jcqndoc01.setAddresses(rs.getString("addresses"));
					jcqndoc01.setUnit_name(rs.getString("unit_name"));
					jcqndoc01.setOrganization_code(rs.getString("organization_code"));
					jcqndoc01.setLegal_representative(rs.getString("legal_representative"));
					jcqndoc01.setSupervisor_unit(rs.getString("supervisor_unit"));
					jcqndoc01.setUnit_address(rs.getString("unit_address"));
					jcqndoc01.setPostcode(rs.getString("postcode"));
					jcqndoc01.setUnit_contact(rs.getString("unit_contact"));
					jcqndoc01.setWork_telephone(rs.getString("work_telephone"));
					jcqndoc01.setWork_fax(rs.getString("work_fax"));
				}
				return jcqndoc01;
			}
		});
	}

	public JcqnDoc01 getById(int id) {
		return jdbcTemplate.query(SQL_Get_BY_ID, new Object[] { id }, new ResultSetExtractor<JcqnDoc01>() {
			@Override
			public JcqnDoc01 extractData(ResultSet rs) throws SQLException, DataAccessException {
				JcqnDoc01 jcqndoc01 = new JcqnDoc01();
				if (rs.next()) {
					jcqndoc01.setId(rs.getInt("id"));
					jcqndoc01.setUser_id(rs.getInt("user_id"));
					jcqndoc01.setName(rs.getString("name"));
					jcqndoc01.setSex(rs.getString("sex"));
					jcqndoc01.setMinzu(rs.getString("minzu"));
					// String temp = rs.getString("birthday");
					// if (temp != null && !temp.equals("")) {
					// String Year = temp.substring(0, 4);
					// String Month = temp.substring(5, 7);
					// String Day = temp.substring(8, 10);
					// temp = Year + "." + Month + "." + Day;
					// }
					jcqndoc01.setBirthday(rs.getString("birthday"));
					jcqndoc01.setTitle(rs.getString("title"));
					jcqndoc01.setDocument_type(rs.getString("document_type"));
					jcqndoc01.setDocument_number(rs.getString("document_number"));
					jcqndoc01.setDirection(rs.getString("direction"));
					jcqndoc01.setDeclaration_area(rs.getString("declaration_area"));
					jcqndoc01.setTelephone(rs.getString("telephone"));
					jcqndoc01.setFax(rs.getString("fax"));
					jcqndoc01.setMobile_phone(rs.getString("mobile_phone"));
					jcqndoc01.setEmail(rs.getString("email"));
					jcqndoc01.setZip_code(rs.getString("zip_code"));
					jcqndoc01.setAddresses(rs.getString("addresses"));
					jcqndoc01.setUnit_name(rs.getString("unit_name"));
					jcqndoc01.setOrganization_code(rs.getString("organization_code"));
					jcqndoc01.setLegal_representative(rs.getString("legal_representative"));
					jcqndoc01.setSupervisor_unit(rs.getString("supervisor_unit"));
					jcqndoc01.setUnit_address(rs.getString("unit_address"));
					jcqndoc01.setPostcode(rs.getString("postcode"));
					jcqndoc01.setUnit_contact(rs.getString("unit_contact"));
					jcqndoc01.setWork_telephone(rs.getString("work_telephone"));
					jcqndoc01.setWork_fax(rs.getString("work_fax"));
				}
				return jcqndoc01;
			}
		});
	}

	/**
	 * 定义内部类实现RowMapper接口
	 */
	public class jcqndoc01RowMapper implements ParameterizedRowMapper<JcqnDoc01>

	{
		// 实现mapRow方法
		@Override
		public JcqnDoc01 mapRow(ResultSet rs, int num) throws SQLException {
			// 对类进行封装
			JcqnDoc01 jcqndoc01 = new JcqnDoc01();

			jcqndoc01.setId(rs.getInt("id"));
			jcqndoc01.setUser_id(rs.getInt("user_id"));
			jcqndoc01.setName(rs.getString("name"));
			jcqndoc01.setSex(rs.getString("sex"));
			jcqndoc01.setMinzu(rs.getString("minzu"));
			String temp = rs.getString("birthday");
			// if (temp != null && !temp.equals("")) {
			// String Year = temp.substring(0, 4);
			// String Month = temp.substring(5, 7);
			// String Day = temp.substring(8, 10);
			// temp = Year + "." + Month + "." + Day;
			// }
			jcqndoc01.setBirthday(temp);
			jcqndoc01.setTitle(rs.getString("title"));
			jcqndoc01.setDocument_type(rs.getString("document_type"));
			jcqndoc01.setDocument_number(rs.getString("document_number"));
			jcqndoc01.setDirection(rs.getString("direction"));
			jcqndoc01.setDeclaration_area(rs.getString("declaration_area"));
			jcqndoc01.setTelephone(rs.getString("telephone"));
			jcqndoc01.setFax(rs.getString("fax"));
			jcqndoc01.setMobile_phone(rs.getString("mobile_phone"));
			jcqndoc01.setEmail(rs.getString("email"));
			jcqndoc01.setZip_code(rs.getString("zip_code"));
			jcqndoc01.setAddresses(rs.getString("addresses"));
			jcqndoc01.setUnit_name(rs.getString("unit_name"));
			jcqndoc01.setOrganization_code(rs.getString("organization_code"));
			jcqndoc01.setLegal_representative(rs.getString("legal_representative"));
			jcqndoc01.setSupervisor_unit(rs.getString("supervisor_unit"));
			jcqndoc01.setUnit_address(rs.getString("unit_address"));
			jcqndoc01.setPostcode(rs.getString("postcode"));
			jcqndoc01.setUnit_contact(rs.getString("unit_contact"));
			jcqndoc01.setWork_telephone(rs.getString("work_telephone"));
			jcqndoc01.setWork_fax(rs.getString("work_fax"));
			return jcqndoc01;
		}
	}

}