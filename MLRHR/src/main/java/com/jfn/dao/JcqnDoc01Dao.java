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

	private final String SQL_INSERT = "insert into jcqn_doc01(user_id,name,sex,minzu,birthday,title,document_type,document_number,direction,declaration_area,telephone,fax,mobile_phone,email,zip_code,addresses,unit_name,organization_code,legal_representative,"
			+ "supervisor_unit,unit_address,postcode,unit_contact,work_telephone,work_fax) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private final String SQL_Get_BY_ID = "select * from jcqn_doc01 where Id=?";
	private final String SQL_Get_BY_USERID = "select * from jcqn_doc01 where user_id=?";
	private final String SQL_SET_UPDATE = "update jcqn_doc01 set sex=?,minzu=?,birthday=?,"
			+ "title=?,document_type=?,"
			 +"document_number=?,direction=?,declaration_area=?,telephone=?,fax=?,mobile_phone=?,email=?,zip_code=?,addresses=?,"
			// + ",addresses=?,study_country=?"
			// +
			// ",study_colleges=?,study_major=?,study_education=?,study_start_time=?,study_end_time=?"
			// +
			// ",work_country=?,work_company=?,work_position=?,work_start_time=?,work_end_time=?"
			// +
			// ",journal_title=?,organization_position=?,organization_term=?,"
			 +
			 "unit_name=?,organization_code=?,legal_representative=?,supervisor_unit=?,unit_address=?,postcode=?,unit_contact=?,"
			+ "work_telephone=?,work_fax=? where user_id=?";
	// 查询是否已经有数据写入
	// private final String SQL_QUERY_EXISTED = "SELECT COUNT(id) from
	// jcqn_doc01 where user_id = ?";

	private final String SQL_DEL_BY_USERID = "delete from jcqn_doc01 where user_id = ?";

	// 插入数据
	public boolean insert(JcqnDoc01 jcqndoc01) {

		return jdbcTemplate.update(
				SQL_INSERT,
				new Object[] { jcqndoc01.getUser_id(),
						jcqndoc01.getName(),
						jcqndoc01.getSex(),
						jcqndoc01.getMinzu(), jcqndoc01.getBirthday(),
						jcqndoc01.getTitle(), jcqndoc01.getDocument_type(),
						jcqndoc01.getDocument_number(),
						jcqndoc01.getDeclaration_area(),
						jcqndoc01.getTelephone(), jcqndoc01.getFax(),
						jcqndoc01.getMobile_phone(), jcqndoc01.getEmail(),
						jcqndoc01.getZip_code(), jcqndoc01.getAddresses(),
//						jcqndoc01.getStudy_country(),
//						jcqndoc01.getStudy_colleges(),
//						jcqndoc01.getStudy_major(),
//						jcqndoc01.getStudy_education(),
//						jcqndoc01.getStudy_start_time(),
//						jcqndoc01.getStudy_end_time(),
//						jcqndoc01.getWork_country(),
//						jcqndoc01.getWork_company(),
//						jcqndoc01.getWork_position(),
//						jcqndoc01.getWork_start_time(),
//						jcqndoc01.getWork_end_time(),
//						jcqndoc01.getJournal_title(),
//						jcqndoc01.getOrganization_position(),
//						jcqndoc01.getOrganization_term(),
//						jcqndoc01.getJournal_titlef(),
						jcqndoc01.getUnit_name(),
						jcqndoc01.getOrganization_code(),
						jcqndoc01.getLegal_representative(),
						jcqndoc01.getSupervisor_unit(),
						jcqndoc01.getUnit_address(), jcqndoc01.getPostcode(),
						jcqndoc01.getUnit_contact(),
						jcqndoc01.getWork_telephone(), jcqndoc01.getWork_fax(),
						jcqndoc01.getUser_id() }) == 1;
	}

	public boolean update(JcqnDoc01 jcqndoc01) {
		Object[] params = new Object[] { 
				jcqndoc01.getSex(), jcqndoc01.getMinzu(),
				jcqndoc01.getBirthday(), jcqndoc01.getTitle(),
				jcqndoc01.getDocument_type(), 
				jcqndoc01.getDocument_number(),
				jcqndoc01.getDirection(), jcqndoc01.getDeclaration_area(),
				jcqndoc01.getTelephone(), jcqndoc01.getFax(),
				jcqndoc01.getMobile_phone(), jcqndoc01.getEmail(),
				jcqndoc01.getZip_code(), jcqndoc01.getAddresses(),
//				jcqndoc01.getStudy_country(), jcqndoc01.getStudy_colleges(),
//				jcqndoc01.getStudy_major(), jcqndoc01.getStudy_education(),
//				jcqndoc01.getStudy_start_time(), jcqndoc01.getStudy_end_time(),
//				jcqndoc01.getWork_country(), jcqndoc01.getWork_company(),
//				jcqndoc01.getWork_position(), jcqndoc01.getWork_start_time(),
//				jcqndoc01.getWork_end_time(), jcqndoc01.getJournal_title(),
//				jcqndoc01.getJournal_titlef(),
//				jcqndoc01.getOrganization_position(),
//				jcqndoc01.getOrganization_term(),
				jcqndoc01.getUnit_name(),
				jcqndoc01.getOrganization_code(),
				jcqndoc01.getLegal_representative(),
				jcqndoc01.getSupervisor_unit(), jcqndoc01.getUnit_address(),
				jcqndoc01.getPostcode(), jcqndoc01.getUnit_contact(),
				jcqndoc01.getWork_telephone(), jcqndoc01.getWork_fax(),
				jcqndoc01.getUser_id()

		};
		return jdbcTemplate.update(SQL_SET_UPDATE, params) == 1;

	}

	public boolean delete(int user_id) {
		return jdbcTemplate.update(SQL_DEL_BY_USERID, new Object[] { user_id }) == 1;
	}

	// 根据USERID查询
	public JcqnDoc01 getByUserId(int user_id) {
		return jdbcTemplate.query(SQL_Get_BY_USERID, new Object[] { user_id },
				new ResultSetExtractor<JcqnDoc01>() {
					@Override
					public JcqnDoc01 extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						JcqnDoc01 jcqndoc01 = new JcqnDoc01();
						if (rs.next()) {
							jcqndoc01.setId(rs.getInt("id"));
							jcqndoc01.setUser_id(rs.getInt("user_id"));
							jcqndoc01.setName(rs.getString("name"));
							jcqndoc01.setMinzu(rs.getString("minzu"));
							jcqndoc01.setBirthday(rs.getString("birthday"));
							jcqndoc01.setTitle(rs.getString("title"));
							jcqndoc01.setDocument_type(rs
									.getString("document_type"));
							jcqndoc01.setDocument_number(rs
									.getString("document_number"));
							jcqndoc01.setDirection(rs.getString("direction"));
							jcqndoc01.setDeclaration_area(rs
									.getString("declaration_area"));
							jcqndoc01.setTelephone(rs.getString("telephone"));
							jcqndoc01.setFax(rs.getString("fax"));
							jcqndoc01.setMobile_phone(rs
									.getString("mobile_phone"));
							jcqndoc01.setEmail(rs.getString("email"));
							jcqndoc01.setZip_code(rs.getString("zip_code"));
							jcqndoc01.setAddresses(rs.getString("addresses"));
							jcqndoc01.setStudy_country(rs
									.getString("study_country"));
							jcqndoc01.setStudy_colleges(rs
									.getString("study_colleges"));
							jcqndoc01.setStudy_major(rs
									.getString("study_major"));
							jcqndoc01.setStudy_education(rs
									.getString("study_education"));
							jcqndoc01.setStudy_start_time(rs
									.getString("study_start_time"));
							jcqndoc01.setStudy_end_time(rs
									.getString("study_end_time"));
							jcqndoc01.setWork_country(rs
									.getString("work_country"));
							jcqndoc01.setWork_company(rs
									.getString("work_company"));
							jcqndoc01.setWork_position(rs
									.getString("work_position"));
							jcqndoc01.setWork_start_time(rs
									.getString("work_start_time"));
							jcqndoc01.setWork_end_time(rs
									.getString("work_end_time"));
							jcqndoc01.setJournal_title(rs
									.getString("journal_title"));
							jcqndoc01.setOrganization_position(rs
									.getString("organization_position"));
							jcqndoc01.setOrganization_term(rs
									.getString("organization_term"));
							jcqndoc01.setJournal_titlef(rs
									.getString("journal_titlef"));
							jcqndoc01.setOrganization_position1(rs
									.getString("organization_position1"));
							jcqndoc01.setOrganization_term1(rs
									.getString("organization_term1"));
							jcqndoc01.setJournal_title2(rs
									.getString("journal_title2"));
							jcqndoc01.setOrganization_position2(rs
									.getString("organization_position2"));
							jcqndoc01.setOrganization_term2(rs
									.getString("organization_term2"));
							jcqndoc01.setUnit_name(rs.getString("unit_name"));
							jcqndoc01.setOrganization_code(rs
									.getString("organization_code"));
							jcqndoc01.setLegal_representative(rs
									.getString("legal_representative"));
							jcqndoc01.setSupervisor_unit(rs
									.getString("supervisor_unit"));
							jcqndoc01.setUnit_address(rs
									.getString("unit_address"));
							jcqndoc01.setPostcode(rs.getString("postcode"));
							jcqndoc01.setUnit_contact(rs
									.getString("unit_contact"));
							jcqndoc01.setWork_telephone(rs
									.getString("work_telephone"));
							jcqndoc01.setWork_fax(rs.getString("work_fax"));
						}
						return jcqndoc01;
					}
				});
	}

	public JcqnDoc01 getById(int id) {
		return jdbcTemplate.query(SQL_Get_BY_ID, new Object[] { id },
				new ResultSetExtractor<JcqnDoc01>() {
					@Override
					public JcqnDoc01 extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						JcqnDoc01 jcqndoc01 = new JcqnDoc01();
						if (rs.next()) {
							jcqndoc01.setId(rs.getInt("id"));
							jcqndoc01.setUser_id(rs.getInt("user_id"));
							jcqndoc01.setName(rs.getString("name"));
							jcqndoc01.setMinzu(rs.getString("minzu"));
							jcqndoc01.setBirthday(rs.getString("birthday"));
							jcqndoc01.setTitle(rs.getString("title"));
							jcqndoc01.setDocument_type(rs
									.getString("document_type"));
							jcqndoc01.setDocument_number(rs
									.getString("document_number"));
							jcqndoc01.setDirection(rs.getString("direction"));
							jcqndoc01.setDeclaration_area(rs
									.getString("declaration_area"));
							jcqndoc01.setTelephone(rs.getString("telephone"));
							jcqndoc01.setFax(rs.getString("fax"));
							jcqndoc01.setMobile_phone(rs
									.getString("mobile_phone"));
							jcqndoc01.setEmail(rs.getString("email"));
							jcqndoc01.setZip_code(rs.getString("zip_code"));
							jcqndoc01.setAddresses(rs.getString("addresses"));
							jcqndoc01.setStudy_country(rs
									.getString("study_country"));
							jcqndoc01.setStudy_colleges(rs
									.getString("study_colleges"));
							jcqndoc01.setStudy_major(rs
									.getString("study_major"));
							jcqndoc01.setStudy_education(rs
									.getString("study_education"));
							jcqndoc01.setStudy_start_time(rs
									.getString("study_start_time"));
							jcqndoc01.setStudy_end_time(rs
									.getString("study_end_time"));
							jcqndoc01.setWork_country(rs
									.getString("work_country"));
							jcqndoc01.setWork_company(rs
									.getString("work_company"));
							jcqndoc01.setWork_position(rs
									.getString("work_position"));
							jcqndoc01.setWork_start_time(rs
									.getString("work_start_time"));
							jcqndoc01.setWork_end_time(rs
									.getString("work_end_time"));
							jcqndoc01.setJournal_title(rs
									.getString("journal_title"));
							jcqndoc01.setOrganization_position(rs
									.getString("organization_position"));
							jcqndoc01.setOrganization_term(rs
									.getString("organization_term"));
							jcqndoc01.setJournal_titlef(rs
									.getString("journal_titlef"));
							jcqndoc01.setOrganization_position1(rs
									.getString("organization_position1"));
							jcqndoc01.setOrganization_term1(rs
									.getString("organization_term1"));
							jcqndoc01.setJournal_title2(rs
									.getString("journal_title2"));
							jcqndoc01.setOrganization_position2(rs
									.getString("organization_position2"));
							jcqndoc01.setOrganization_term2(rs
									.getString("organization_term2"));
							jcqndoc01.setUnit_name(rs.getString("unit_name"));
							jcqndoc01.setOrganization_code(rs
									.getString("organization_code"));
							jcqndoc01.setLegal_representative(rs
									.getString("legal_representative"));
							jcqndoc01.setSupervisor_unit(rs
									.getString("supervisor_unit"));
							jcqndoc01.setUnit_address(rs
									.getString("unit_address"));
							jcqndoc01.setPostcode(rs.getString("postcode"));
							jcqndoc01.setUnit_contact(rs
									.getString("unit_contact"));
							jcqndoc01.setWork_telephone(rs
									.getString("work_telephone"));
							jcqndoc01.setWork_fax(rs.getString("work_fax"));
						}
						return jcqndoc01;
					}
				});
	}

	/**
	 * 定义内部类实现RowMapper接口
	 */
	public class jcqndoc01RowMapper implements
			ParameterizedRowMapper<JcqnDoc01>

	{
		// 实现mapRow方法
		@Override
		public JcqnDoc01 mapRow(ResultSet rs, int num) throws SQLException {
			// 对类进行封装
			JcqnDoc01 jcqndoc01 = new JcqnDoc01();
			jcqndoc01.setId(rs.getInt("id"));
			jcqndoc01.setUser_id(rs.getInt("user_id"));
			jcqndoc01.setName(rs.getString("name"));
			jcqndoc01.setMinzu(rs.getString("minzu"));
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
			jcqndoc01.setStudy_country(rs.getString("study_country"));
			jcqndoc01.setStudy_colleges(rs.getString("study_colleges"));
			jcqndoc01.setStudy_major(rs.getString("study_major"));
			jcqndoc01.setStudy_education(rs.getString("study_education"));
			jcqndoc01.setStudy_start_time(rs.getString("study_start_time"));
			jcqndoc01.setStudy_end_time(rs.getString("study_end_time"));
			jcqndoc01.setWork_country(rs.getString("work_country"));
			jcqndoc01.setWork_company(rs.getString("work_company"));
			jcqndoc01.setWork_position(rs.getString("work_position"));
			jcqndoc01.setWork_start_time(rs.getString("work_start_time"));
			jcqndoc01.setWork_end_time(rs.getString("work_end_time"));
			jcqndoc01.setJournal_title(rs.getString("journal_title"));
			jcqndoc01.setOrganization_position(rs
					.getString("organization_position"));
			jcqndoc01.setOrganization_term(rs.getString("organization_term"));
			jcqndoc01.setJournal_titlef(rs.getString("journal_titlef"));
			// jcqndoc01.setOrganization_position1(rs.getString("organization_position1"));
			// jcqndoc01.setOrganization_term1(rs.getString("organization_term1"));
			// jcqndoc01.setJournal_title2(rs.getString("journal_title2"));
			// jcqndoc01.setOrganization_position2(rs.getString("organization_position2"));
			// jcqndoc01.setOrganization_term2(rs.getString("organization_term2"));
			jcqndoc01.setUnit_name(rs.getString("unit_name"));
			jcqndoc01.setOrganization_code(rs.getString("organization_code"));
			jcqndoc01.setLegal_representative(rs
					.getString("legal_representative"));
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