package com.jfn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.stereotype.Repository;

import com.jfn.entity.KjljDoc01;


@Repository
public class KjljDoc01Dao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String SQL_INSERT = "insert into kjlj_doc01(user_id,name,sex,minzu,birthday,title,document_type,document_number,direction,declaration_area,telephone,fax,mobile_phone,email,zip_code,addresses,"
			+ "study_country,study_colleges,study_major,study_education,study_start_time,study_end_time,user_studcountry2,user_studcollege2,user_studmajor2,user_studdegree2,user_studfirsttime2,user_studlasttime2,"
			+ "work_country,work_company,work_position,work_start_time,work_end_time,user_workcountry,user_workcollege,user_workmajor,work_starttime,work_endtime,"
			+ "journal_title,organization_position,organization_term,journal_title1,organization_position1,organization_term1,journal_title2,organization_position2,organization_term2,unit_name,organization_code,legal_representative,"
			+ "supervisor_unit,unit_address,postcode,unit_contact,work_telephone,work_fax) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private final String SQL_Get_BY_ID = "select * from kjlj_doc01 where Id=?";
	private final String SQL_Get_BY_USERID = "select * from kjlj_doc01 where user_id=?";
	private final String SQL_SET_UPDATE = "update kjlj_doc01 set name=?,sex=?,minzu=?,birthday=?,title=?,document_type=?,"
			 +"document_number=?,direction=?,declaration_area=?,telephone=?,fax=?,mobile_phone=?,email=?,zip_code=?,addresses=?,study_country=?"
			 +",study_colleges=?,study_major=?,study_education=?,study_start_time=?,study_end_time=?,user_studcountry2=?,user_studcollege2=?,user_studmajor2=?,user_studdegree2=?,user_studfirsttime2=?,user_studlasttime2=?"
			 +",work_country=?,work_company=?,work_position=?,work_start_time=?,work_end_time=?,user_workcountry=?,user_workcollege=?,user_workmajor=?,work_starttime=?,work_endtime=?"
			 + ",journal_title=?,organization_position=?,organization_term=?,journal_title1=?,organization_position1=?,organization_term1=?,journal_title2=?,organization_position2=?,organization_term2=?,"
			 +"unit_name=?,organization_code=?,legal_representative=?,supervisor_unit=?,unit_address=?,postcode=?,unit_contact=?,"
			+ "work_telephone=?,work_fax=? where user_id=?";
	// 查询是否已经有数据写入
	// private final String SQL_QUERY_EXISTED = "SELECT COUNT(id) from
	// kjlj_doc01 where user_id = ?";

	private final String SQL_DEL_BY_USERID = "delete from kjlj_doc01 where user_id = ?";

	// 插入数据
	public boolean insert(KjljDoc01 kjljdoc01) {

		return jdbcTemplate.update(SQL_INSERT,
				new Object[] { 
						kjljdoc01.getUser_id(),
						kjljdoc01.getName(),
						kjljdoc01.getSex(),
						kjljdoc01.getMinzu(), 
						kjljdoc01.getBirthday(),
						kjljdoc01.getTitle(), 
						kjljdoc01.getDocument_type(),
						kjljdoc01.getDocument_number(),
						kjljdoc01.getDirection(),
						kjljdoc01.getDeclaration_area(),
						kjljdoc01.getTelephone(), 
						kjljdoc01.getFax(),
						kjljdoc01.getMobile_phone(), 
						kjljdoc01.getEmail(),
						kjljdoc01.getZip_code(),
						kjljdoc01.getAddresses(),
						kjljdoc01.getStudy_country(),
						kjljdoc01.getStudy_colleges(),
						kjljdoc01.getStudy_major(),
						kjljdoc01.getStudy_education(),
						kjljdoc01.getStudy_start_time(),
						kjljdoc01.getStudy_end_time(),
						kjljdoc01.getUser_studcountry2(),
						kjljdoc01.getUser_studcollege2(),
						kjljdoc01.getUser_studmajor2(),
						kjljdoc01.getUser_studdegree2(),
						kjljdoc01.getUser_studfirsttime2(),
						kjljdoc01.getUser_studlasttime2(),		
						kjljdoc01.getWork_country(),
						kjljdoc01.getWork_company(),
						kjljdoc01.getWork_position(),
						kjljdoc01.getWork_start_time(),
						kjljdoc01.getWork_end_time(),
						kjljdoc01.getUser_workcountry(),
						kjljdoc01.getUser_workcollege(),
						kjljdoc01.getUser_workmajor(),
						kjljdoc01.getWork_starttime(),
						kjljdoc01.getWork_endtime(),
						kjljdoc01.getJournal_title(),
						kjljdoc01.getOrganization_position(),
						kjljdoc01.getOrganization_term(),
						kjljdoc01.getJournal_title1(),
						kjljdoc01.getOrganization_position1(),
						kjljdoc01.getOrganization_term1(),
						kjljdoc01.getJournal_title2(),
						kjljdoc01.getOrganization_position2(),
						kjljdoc01.getOrganization_term2(),
						kjljdoc01.getUnit_name(),
						kjljdoc01.getOrganization_code(),
						kjljdoc01.getLegal_representative(),
						kjljdoc01.getSupervisor_unit(),
						kjljdoc01.getUnit_address(), 
						kjljdoc01.getPostcode(),
						kjljdoc01.getUnit_contact(),
						kjljdoc01.getWork_telephone(),
						kjljdoc01.getWork_fax() }) == 1;
	}

	public boolean update(KjljDoc01 kjljdoc01) {
		Object[] params = new Object[] {
				kjljdoc01.getName(),
				kjljdoc01.getSex(),
				kjljdoc01.getMinzu(), 
				kjljdoc01.getBirthday(),
				kjljdoc01.getTitle(), 
				kjljdoc01.getDocument_type(),
				kjljdoc01.getDocument_number(),
				kjljdoc01.getDirection(),
				kjljdoc01.getDeclaration_area(),
				kjljdoc01.getTelephone(), 
				kjljdoc01.getFax(),
				kjljdoc01.getMobile_phone(), 
				kjljdoc01.getEmail(),
				kjljdoc01.getZip_code(),
				kjljdoc01.getAddresses(),
				kjljdoc01.getStudy_country(),
				kjljdoc01.getStudy_colleges(),
				kjljdoc01.getStudy_major(),
				kjljdoc01.getStudy_education(),
				kjljdoc01.getStudy_start_time(),
				kjljdoc01.getStudy_end_time(),
				kjljdoc01.getUser_studcountry2(),
				kjljdoc01.getUser_studcollege2(),
				kjljdoc01.getUser_studmajor2(),
				kjljdoc01.getUser_studdegree2(),
				kjljdoc01.getUser_studfirsttime2(),
				kjljdoc01.getUser_studlasttime2(),
				kjljdoc01.getWork_country(),
				kjljdoc01.getWork_company(),
				kjljdoc01.getWork_position(),
				kjljdoc01.getWork_start_time(),
				kjljdoc01.getWork_end_time(),
				kjljdoc01.getUser_workcountry(),
				kjljdoc01.getUser_workcollege(),
				kjljdoc01.getUser_workmajor(),
				kjljdoc01.getWork_starttime(),
				kjljdoc01.getWork_endtime(),
				kjljdoc01.getJournal_title(),
				kjljdoc01.getOrganization_position(),
				kjljdoc01.getOrganization_term(),
				kjljdoc01.getJournal_title1(),
				kjljdoc01.getOrganization_position1(),
				kjljdoc01.getOrganization_term1(),
				kjljdoc01.getJournal_title2(),
				kjljdoc01.getOrganization_position2(),
				kjljdoc01.getOrganization_term2(),
				kjljdoc01.getUnit_name(),
				kjljdoc01.getOrganization_code(),
				kjljdoc01.getLegal_representative(),
				kjljdoc01.getSupervisor_unit(),
				kjljdoc01.getUnit_address(), 
				kjljdoc01.getPostcode(),
				kjljdoc01.getUnit_contact(),
				kjljdoc01.getWork_telephone(),
				kjljdoc01.getWork_fax(),
				kjljdoc01.getUser_id()

		};
		return jdbcTemplate.update(SQL_SET_UPDATE, params) == 1;

	}

	public boolean delete(int user_id) {
		return jdbcTemplate.update(SQL_DEL_BY_USERID, new Object[] { user_id }) == 1;
	}

	// 根据USERID查询
	public KjljDoc01 getByUserId(int user_id) {
		return jdbcTemplate.query(SQL_Get_BY_USERID, new Object[] { user_id }, new ResultSetExtractor<KjljDoc01>() {
			@Override
			public KjljDoc01 extractData(ResultSet rs) throws SQLException, DataAccessException {
				KjljDoc01 kjljdoc01 = new KjljDoc01();
				if (rs.next()) {
					kjljdoc01.setId(rs.getInt("id"));
					kjljdoc01.setUser_id(rs.getInt("user_id"));
					kjljdoc01.setName(rs.getString("name"));
					kjljdoc01.setSex(rs.getString("sex"));
					kjljdoc01.setMinzu(rs.getString("minzu"));
					String temp = rs.getString("birthday");
					if (temp != null && !temp.equals("")) {
						String Year = temp.substring(0, 4);
						String Month = temp.substring(5, 7);
						String Day = temp.substring(8, 10);
						temp = Year + "." + Month + "." + Day;
					}
					kjljdoc01.setBirthday(temp);
					kjljdoc01.setTitle(rs.getString("title"));
					kjljdoc01.setDocument_type(rs.getString("document_type"));
					kjljdoc01.setDocument_number(rs.getString("document_number"));
					kjljdoc01.setDirection(rs.getString("direction"));
					kjljdoc01.setDeclaration_area(rs.getString("declaration_area"));
					kjljdoc01.setTelephone(rs.getString("telephone"));
					kjljdoc01.setFax(rs.getString("fax"));
					kjljdoc01.setMobile_phone(rs.getString("mobile_phone"));
					kjljdoc01.setEmail(rs.getString("email"));
					kjljdoc01.setZip_code(rs.getString("zip_code"));
					kjljdoc01.setAddresses(rs.getString("addresses"));
					kjljdoc01.setStudy_country(rs.getString("study_country"));
					kjljdoc01.setStudy_colleges(rs.getString("study_colleges"));
					kjljdoc01.setStudy_major(rs.getString("study_major"));
					kjljdoc01.setStudy_education(rs.getString("study_education"));
					String temp2 = rs.getString("study_start_time");
					if (temp2 != null && !temp2.equals("")) {
						String Year = temp.substring(0, 4);
						String Month = temp.substring(5, 7);
						String Day = temp.substring(8, 10);
						temp2 = Year + "." + Month + "." + Day;
					}

					kjljdoc01.setStudy_start_time(temp2);
					String temp1 = rs.getString("study_end_time");
					if (temp1 != null && !temp1.equals("")) {
						String Year = temp.substring(0, 4);
						String Month = temp.substring(5, 7);
						String Day = temp.substring(8, 10);
						temp1 = Year + "." + Month + "." + Day;
					}

					kjljdoc01.setStudy_end_time(temp1);
					kjljdoc01.setUser_studcountry2(rs.getString("user_studcountry2"));
					kjljdoc01.setUser_studcollege2(rs.getString("user_studcollege2"));
					kjljdoc01.setUser_studmajor2(rs.getString("user_studmajor2"));
					kjljdoc01.setUser_studdegree2(rs.getString("user_studdegree2"));
					String temp4 = rs.getString("user_studfirsttime2");
					if (temp4 != null && !temp4.equals("")) {
						String Year = temp.substring(0, 4);
						String Month = temp.substring(5, 7);
						String Day = temp.substring(8, 10);
						temp4 = Year + "." + Month + "." + Day;
					}
					kjljdoc01.setUser_studfirsttime2(temp4);
					String temp3 = rs.getString("user_studlasttime2");
					if (temp3 != null && !temp3.equals("")) {
						String Year = temp.substring(0, 4);
						String Month = temp.substring(5, 7);
						String Day = temp.substring(8, 10);
						temp3 = Year + "." + Month + "." + Day;
					}
					kjljdoc01.setUser_studlasttime2(temp3);
					kjljdoc01.setWork_country(rs.getString("work_country"));
					kjljdoc01.setWork_company(rs.getString("work_company"));
					kjljdoc01.setWork_position(rs.getString("work_position"));
					
					String temp5 = rs.getString("work_start_time");
					if (temp5 != null && !temp5.equals("")) {
						String Year = temp.substring(0, 4);
						String Month = temp.substring(5, 7);
						String Day = temp.substring(8, 10);
						temp5 = Year + "." + Month + "." + Day;
					}
					kjljdoc01.setWork_start_time(temp5);
					String temp6 = rs.getString("work_end_time");
					if (temp6 != null && !temp6.equals("")) {
						String Year = temp.substring(0, 4);
						String Month = temp.substring(5, 7);
						String Day = temp.substring(8, 10);
						temp6 = Year + "." + Month + "." + Day;
					}
					kjljdoc01.setWork_end_time(temp6);
					kjljdoc01.setUser_workcountry(rs.getString("user_workcountry"));
					kjljdoc01.setUser_workcollege(rs.getString("user_workcollege"));
					kjljdoc01.setUser_workmajor(rs.getString("user_workmajor"));
					String temp7 = rs.getString("work_starttime");
					if (temp7 != null && !temp7.equals("")) {
						String Year = temp.substring(0, 4);
						String Month = temp.substring(5, 7);
						String Day = temp.substring(8, 10);
						temp7 = Year + "." + Month + "." + Day;
					}
					kjljdoc01.setWork_starttime(temp7);
					String temp8 = rs.getString("work_endtime");
					if (temp8 != null && !temp8.equals("")) {
						String Year = temp.substring(0, 4);
						String Month = temp.substring(5, 7);
						String Day = temp.substring(8, 10);
						temp8 = Year + "." + Month + "." + Day;
					}
					kjljdoc01.setWork_endtime(temp8);
					kjljdoc01.setJournal_title(rs.getString("journal_title"));
					kjljdoc01.setOrganization_position(rs.getString("organization_position"));
					kjljdoc01.setOrganization_term(rs.getString("organization_term"));
					kjljdoc01.setJournal_title1(rs.getString("journal_title1"));
					kjljdoc01.setOrganization_position1(rs.getString("organization_position1"));
					kjljdoc01.setOrganization_term1(rs.getString("organization_term1"));
					kjljdoc01.setJournal_title2(rs.getString("journal_title2"));
					kjljdoc01.setOrganization_position2(rs.getString("organization_position2"));
					kjljdoc01.setOrganization_term2(rs.getString("organization_term2"));
					kjljdoc01.setUnit_name(rs.getString("unit_name"));
					kjljdoc01.setOrganization_code(rs.getString("organization_code"));
					kjljdoc01.setLegal_representative(rs.getString("legal_representative"));
					kjljdoc01.setSupervisor_unit(rs.getString("supervisor_unit"));
					kjljdoc01.setUnit_address(rs.getString("unit_address"));
					kjljdoc01.setPostcode(rs.getString("postcode"));
					kjljdoc01.setUnit_contact(rs.getString("unit_contact"));
					kjljdoc01.setWork_telephone(rs.getString("work_telephone"));
					kjljdoc01.setWork_fax(rs.getString("work_fax"));
				}
				return kjljdoc01;
			}
		});
	}

	public KjljDoc01 getById(int id) {
		return jdbcTemplate.query(SQL_Get_BY_ID, new Object[] { id }, new ResultSetExtractor<KjljDoc01>() {
			@Override
			public KjljDoc01 extractData(ResultSet rs) throws SQLException, DataAccessException {
				KjljDoc01 kjljdoc01 = new KjljDoc01();
				if (rs.next()) {
					kjljdoc01.setId(rs.getInt("id"));
					kjljdoc01.setUser_id(rs.getInt("user_id"));
					kjljdoc01.setName(rs.getString("name"));
					kjljdoc01.setSex(rs.getString("sex"));
					kjljdoc01.setMinzu(rs.getString("minzu"));
					String temp = rs.getString("birthday");
					if (temp != null && !temp.equals("")) {
						String Year = temp.substring(0, 4);
						String Month = temp.substring(5, 7);
						String Day = temp.substring(8, 10);
						temp = Year + "." + Month + "." + Day;
					}
					kjljdoc01.setBirthday(temp);
					kjljdoc01.setTitle(rs.getString("title"));
					kjljdoc01.setDocument_type(rs.getString("document_type"));
					kjljdoc01.setDocument_number(rs.getString("document_number"));
					kjljdoc01.setDirection(rs.getString("direction"));
					kjljdoc01.setDeclaration_area(rs.getString("declaration_area"));
					kjljdoc01.setTelephone(rs.getString("telephone"));
					kjljdoc01.setFax(rs.getString("fax"));
					kjljdoc01.setMobile_phone(rs.getString("mobile_phone"));
					kjljdoc01.setEmail(rs.getString("email"));
					kjljdoc01.setZip_code(rs.getString("zip_code"));
					kjljdoc01.setAddresses(rs.getString("addresses"));
					kjljdoc01.setStudy_country(rs.getString("study_country"));
					kjljdoc01.setStudy_colleges(rs.getString("study_colleges"));
					kjljdoc01.setStudy_major(rs.getString("study_major"));
					kjljdoc01.setStudy_education(rs.getString("study_education"));
					String temp2 = rs.getString("study_start_time");
					if (temp2 != null && !temp2.equals("")) {
						String Year = temp.substring(0, 4);
						String Month = temp.substring(5, 7);
						String Day = temp.substring(8, 10);
						temp2 = Year + "." + Month + "." + Day;
					}

					kjljdoc01.setStudy_start_time(temp2);
					String temp1 = rs.getString("study_end_time");
					if (temp1 != null && !temp1.equals("")) {
						String Year = temp.substring(0, 4);
						String Month = temp.substring(5, 7);
						String Day = temp.substring(8, 10);
						temp1 = Year + "." + Month + "." + Day;
					}

					kjljdoc01.setStudy_end_time(temp1);
					kjljdoc01.setUser_studcountry2(rs.getString("user_studcountry2"));
					kjljdoc01.setUser_studcollege2(rs.getString("user_studcollege2"));
					kjljdoc01.setUser_studmajor2(rs.getString("user_studmajor2"));
					kjljdoc01.setUser_studdegree2(rs.getString("user_studdegree2"));
					String temp4 = rs.getString("user_studfirsttime2");
					if (temp4 != null && !temp4.equals("")) {
						String Year = temp.substring(0, 4);
						String Month = temp.substring(5, 7);
						String Day = temp.substring(8, 10);
						temp4 = Year + "." + Month + "." + Day;
					}
					kjljdoc01.setUser_studfirsttime2(temp4);
					String temp3 = rs.getString("user_studlasttime2");
					if (temp3 != null && !temp3.equals("")) {
						String Year = temp.substring(0, 4);
						String Month = temp.substring(5, 7);
						String Day = temp.substring(8, 10);
						temp3 = Year + "." + Month + "." + Day;
					}
					kjljdoc01.setUser_studlasttime2(temp3);
					kjljdoc01.setWork_country(rs.getString("work_country"));
					kjljdoc01.setWork_company(rs.getString("work_company"));
					kjljdoc01.setWork_position(rs.getString("work_position"));
					
					String temp5 = rs.getString("work_start_time");
					if (temp5 != null && !temp5.equals("")) {
						String Year = temp.substring(0, 4);
						String Month = temp.substring(5, 7);
						String Day = temp.substring(8, 10);
						temp5 = Year + "." + Month + "." + Day;
					}
					kjljdoc01.setWork_start_time(temp5);
					String temp6 = rs.getString("work_end_time");
					if (temp6 != null && !temp6.equals("")) {
						String Year = temp.substring(0, 4);
						String Month = temp.substring(5, 7);
						String Day = temp.substring(8, 10);
						temp6 = Year + "." + Month + "." + Day;
					}
					kjljdoc01.setWork_end_time(temp6);
					kjljdoc01.setUser_workcountry(rs.getString("user_workcountry"));
					kjljdoc01.setUser_workcollege(rs.getString("user_workcollege"));
					kjljdoc01.setUser_workmajor(rs.getString("user_workmajor"));
					String temp7 = rs.getString("work_starttime");
					if (temp7 != null && !temp7.equals("")) {
						String Year = temp.substring(0, 4);
						String Month = temp.substring(5, 7);
						String Day = temp.substring(8, 10);
						temp7 = Year + "." + Month + "." + Day;
					}
					kjljdoc01.setWork_starttime(temp7);
					String temp8 = rs.getString("work_endtime");
					if (temp8 != null && !temp8.equals("")) {
						String Year = temp.substring(0, 4);
						String Month = temp.substring(5, 7);
						String Day = temp.substring(8, 10);
						temp8 = Year + "." + Month + "." + Day;
					}
					kjljdoc01.setWork_endtime(temp8);
					kjljdoc01.setJournal_title(rs.getString("journal_title"));
					kjljdoc01.setOrganization_position(rs.getString("organization_position"));
					kjljdoc01.setOrganization_term(rs.getString("organization_term"));
					kjljdoc01.setJournal_title1(rs.getString("journal_title1"));
					kjljdoc01.setOrganization_position1(rs.getString("organization_position1"));
					kjljdoc01.setOrganization_term1(rs.getString("organization_term1"));
					kjljdoc01.setJournal_title2(rs.getString("journal_title2"));
					kjljdoc01.setOrganization_position2(rs.getString("organization_position2"));
					kjljdoc01.setOrganization_term2(rs.getString("organization_term2"));
					kjljdoc01.setUnit_name(rs.getString("unit_name"));
					kjljdoc01.setOrganization_code(rs.getString("organization_code"));
					kjljdoc01.setLegal_representative(rs.getString("legal_representative"));
					kjljdoc01.setSupervisor_unit(rs.getString("supervisor_unit"));
					kjljdoc01.setUnit_address(rs.getString("unit_address"));
					kjljdoc01.setPostcode(rs.getString("postcode"));
					kjljdoc01.setUnit_contact(rs.getString("unit_contact"));
					kjljdoc01.setWork_telephone(rs.getString("work_telephone"));
					kjljdoc01.setWork_fax(rs.getString("work_fax"));
				}
				return kjljdoc01;
			}
		});
	}

	/**
	 * 定义内部类实现RowMapper接口
	 */
	public class kjljdoc01RowMapper implements ParameterizedRowMapper<KjljDoc01>

	{
		// 实现mapRow方法
		@Override
		public KjljDoc01 mapRow(ResultSet rs, int num) throws SQLException {
			// 对类进行封装
			KjljDoc01 kjljdoc01 = new KjljDoc01();
			kjljdoc01.setId(rs.getInt("id"));
			kjljdoc01.setUser_id(rs.getInt("user_id"));
			kjljdoc01.setName(rs.getString("name"));
			kjljdoc01.setSex(rs.getString("sex"));
			kjljdoc01.setMinzu(rs.getString("minzu"));
			String temp = rs.getString("birthday");
			if (temp != null && !temp.equals("")) {
				String Year = temp.substring(0, 4);
				String Month = temp.substring(5, 7);
				String Day = temp.substring(8, 10);
				temp = Year + "." + Month + "." + Day;
			}
			kjljdoc01.setBirthday(temp);
			kjljdoc01.setTitle(rs.getString("title"));
			kjljdoc01.setDocument_type(rs.getString("document_type"));
			kjljdoc01.setDocument_number(rs.getString("document_number"));
			kjljdoc01.setDirection(rs.getString("direction"));
			kjljdoc01.setDeclaration_area(rs.getString("declaration_area"));
			kjljdoc01.setTelephone(rs.getString("telephone"));
			kjljdoc01.setFax(rs.getString("fax"));
			kjljdoc01.setMobile_phone(rs.getString("mobile_phone"));
			kjljdoc01.setEmail(rs.getString("email"));
			kjljdoc01.setZip_code(rs.getString("zip_code"));
			kjljdoc01.setAddresses(rs.getString("addresses"));
			kjljdoc01.setStudy_country(rs.getString("study_country"));
			kjljdoc01.setStudy_colleges(rs.getString("study_colleges"));
			kjljdoc01.setStudy_major(rs.getString("study_major"));
			kjljdoc01.setStudy_education(rs.getString("study_education"));
			String temp2 = rs.getString("study_start_time");
			if (temp2 != null && !temp2.equals("")) {
				String Year = temp.substring(0, 4);
				String Month = temp.substring(5, 7);
				String Day = temp.substring(8, 10);
				temp2 = Year + "." + Month + "." + Day;
			}

			kjljdoc01.setStudy_start_time(temp2);
			String temp1 = rs.getString("study_end_time");
			if (temp1 != null && !temp1.equals("")) {
				String Year = temp.substring(0, 4);
				String Month = temp.substring(5, 7);
				String Day = temp.substring(8, 10);
				temp1 = Year + "." + Month + "." + Day;
			}

			kjljdoc01.setStudy_end_time(temp1);
			kjljdoc01.setUser_studcountry2(rs.getString("user_studcountry2"));
			kjljdoc01.setUser_studcollege2(rs.getString("user_studcollege2"));
			kjljdoc01.setUser_studmajor2(rs.getString("user_studmajor2"));
			kjljdoc01.setUser_studdegree2(rs.getString("user_studdegree2"));
			String temp4 = rs.getString("user_studfirsttime2");
			if (temp4 != null && !temp4.equals("")) {
				String Year = temp.substring(0, 4);
				String Month = temp.substring(5, 7);
				String Day = temp.substring(8, 10);
				temp4 = Year + "." + Month + "." + Day;
			}
			kjljdoc01.setUser_studfirsttime2(temp4);
			String temp3 = rs.getString("user_studlasttime2");
			if (temp3 != null && !temp3.equals("")) {
				String Year = temp.substring(0, 4);
				String Month = temp.substring(5, 7);
				String Day = temp.substring(8, 10);
				temp3 = Year + "." + Month + "." + Day;
			}
			kjljdoc01.setUser_studlasttime2(temp3);
			kjljdoc01.setWork_country(rs.getString("work_country"));
			kjljdoc01.setWork_company(rs.getString("work_company"));
			kjljdoc01.setWork_position(rs.getString("work_position"));
			
			String temp5 = rs.getString("work_start_time");
			if (temp5 != null && !temp5.equals("")) {
				String Year = temp.substring(0, 4);
				String Month = temp.substring(5, 7);
				String Day = temp.substring(8, 10);
				temp5 = Year + "." + Month + "." + Day;
			}
			kjljdoc01.setWork_start_time(temp5);
			String temp6 = rs.getString("work_end_time");
			if (temp6 != null && !temp6.equals("")) {
				String Year = temp.substring(0, 4);
				String Month = temp.substring(5, 7);
				String Day = temp.substring(8, 10);
				temp6 = Year + "." + Month + "." + Day;
			}
			kjljdoc01.setWork_end_time(temp6);
			kjljdoc01.setUser_workcountry(rs.getString("user_workcountry"));
			kjljdoc01.setUser_workcollege(rs.getString("user_workcollege"));
			kjljdoc01.setUser_workmajor(rs.getString("user_workmajor"));
			String temp7 = rs.getString("work_starttime");
			if (temp7 != null && !temp7.equals("")) {
				String Year = temp.substring(0, 4);
				String Month = temp.substring(5, 7);
				String Day = temp.substring(8, 10);
				temp7 = Year + "." + Month + "." + Day;
			}
			kjljdoc01.setWork_starttime(temp7);
			String temp8 = rs.getString("work_endtime");
			if (temp8 != null && !temp8.equals("")) {
				String Year = temp.substring(0, 4);
				String Month = temp.substring(5, 7);
				String Day = temp.substring(8, 10);
				temp8 = Year + "." + Month + "." + Day;
			}
			kjljdoc01.setWork_endtime(temp8);
			kjljdoc01.setJournal_title(rs.getString("journal_title"));
			kjljdoc01.setOrganization_position(rs.getString("organization_position"));
			kjljdoc01.setOrganization_term(rs.getString("organization_term"));
			kjljdoc01.setJournal_title1(rs.getString("journal_title1"));
			kjljdoc01.setOrganization_position1(rs.getString("organization_position1"));
			kjljdoc01.setOrganization_term1(rs.getString("organization_term1"));
			kjljdoc01.setJournal_title2(rs.getString("journal_title2"));
			kjljdoc01.setOrganization_position2(rs.getString("organization_position2"));
			kjljdoc01.setOrganization_term2(rs.getString("organization_term2"));
			kjljdoc01.setUnit_name(rs.getString("unit_name"));
			kjljdoc01.setOrganization_code(rs.getString("organization_code"));
			kjljdoc01.setLegal_representative(rs.getString("legal_representative"));
			kjljdoc01.setSupervisor_unit(rs.getString("supervisor_unit"));
			kjljdoc01.setUnit_address(rs.getString("unit_address"));
			kjljdoc01.setPostcode(rs.getString("postcode"));
			kjljdoc01.setUnit_contact(rs.getString("unit_contact"));
			kjljdoc01.setWork_telephone(rs.getString("work_telephone"));
			kjljdoc01.setWork_fax(rs.getString("work_fax"));
			return kjljdoc01;
		}
	}

}