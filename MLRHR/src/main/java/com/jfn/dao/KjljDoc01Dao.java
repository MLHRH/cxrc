package com.jfn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	private final String SQL_INSERT = "insert into kjlj_doc01(user_id,name,sex,minzu,birthday,title,document_type,document_number,direction,declaration_area,telephone,fax,mobile_phone,email,zip_code,addresses,study_country,study_colleges,"
			+ "study_major,study_education,study_start_time,study_end_time,work_country,work_company,work_position,work_start_time,work_end_time,journal_title,organization_position,organization_term,unit_name,organization_code,legal_representative,"
			+ "supervisor_unit,unit_address,postcode,unit_contact,work_telephone,work_fax) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private final String SQL_Get_BY_USERID = "select * from kjlj_doc01 where user_id=?";
	private final String SQL_SET_UPDATE = "update kjlj_doc01 set user_id=?,name=?,sex=?,minzu=?,birthday=?,title=?,document_type=?,document_number=?,direction=?,declaration_area=?,telephone=?,fax,mobile_phone=?,email=?,zip_code=?,addresses=?,study_country=?,study_colleges=?,"
			+ "study_major=?,study_education=?,study_start_time=?,study_end_time=?,work_country=?,work_company=?,work_position=?,work_start_time=?,work_end_time=?,journal_title=?,organization_position=?,organization_term=?,unit_name=?,organization_code=?,legal_representative=?,"
			+ "supervisor_unit=?,unit_address=?,postcode=?,unit_contact=?,work_telephone=?,work_fax=? where id=?";
	//查询是否已经有数据写入
//	private final String SQL_QUERY_EXISTED = "SELECT COUNT(id) from kjlj_doc01 where user_id = ?";
	
	private final String SQL_DEL_BY_USERID = "delete from kjlj_doc01 where user_id = ?";
		//插入数据
	public boolean insert( KjljDoc01 kjljdoc01){
		
		return jdbcTemplate.update(
				SQL_INSERT,
				new Object[]{
					kjljdoc01.getUser_id(),
					kjljdoc01.getName(),
					kjljdoc01.getSex(),
					kjljdoc01.getMinzu(),
					kjljdoc01.getBirthday(),
					kjljdoc01.getTitle(),
					kjljdoc01.getDocument_type(),
					kjljdoc01.getDocument_number(),
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
					kjljdoc01.getWork_country(),
					kjljdoc01.getWork_company(),
					kjljdoc01.getWork_position(),
					kjljdoc01.getWork_start_time(),
					kjljdoc01.getWork_end_time(),
					kjljdoc01.getJournal_title(),
					kjljdoc01.getOrganization_position(),
					kjljdoc01.getOrganization_term(),
					kjljdoc01.getUnit_name(),
					kjljdoc01.getOrganization_code(),
					kjljdoc01.getLegal_representative(),
					kjljdoc01.getSupervisor_unit(),
					kjljdoc01.getUnit_address(),
					kjljdoc01.getPostcode(),
					kjljdoc01.getUnit_contact(),
					kjljdoc01.getWork_telephone(),
					kjljdoc01.getWork_fax()
					}) == 1;
	}
	public boolean update(KjljDoc01 kjljdoc01){
		Object[] params = new Object[] {
				kjljdoc01.getUser_id(),
				kjljdoc01.getName(),
				kjljdoc01.getSex(),
				kjljdoc01.getMinzu(),
				kjljdoc01.getBirthday(),
				kjljdoc01.getTitle(),
				kjljdoc01.getDocument_type(),
				kjljdoc01.getDocument_number(),
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
				kjljdoc01.getWork_country(),
				kjljdoc01.getWork_company(),
				kjljdoc01.getWork_position(),
				kjljdoc01.getWork_start_time(),
				kjljdoc01.getWork_end_time(),
				kjljdoc01.getJournal_title(),
				kjljdoc01.getOrganization_position(),
				kjljdoc01.getOrganization_term(),
				kjljdoc01.getUnit_name(),
				kjljdoc01.getOrganization_code(),
				kjljdoc01.getLegal_representative(),
				kjljdoc01.getSupervisor_unit(),
				kjljdoc01.getUnit_address(),
				kjljdoc01.getPostcode(),
				kjljdoc01.getUnit_contact(),
				kjljdoc01.getWork_telephone(),
				kjljdoc01.getWork_fax()
				
		};
		return jdbcTemplate.update(SQL_SET_UPDATE,params) == 1;
		
		
	}
	public boolean delete( int user_id )
	{
		 return jdbcTemplate.update( SQL_DEL_BY_USERID, new Object[]{user_id} )==1;
	}
	//根据USERID查询
	public List<KjljDoc01> getByUserId( int user_id )
	{
		return jdbcTemplate.query( SQL_Get_BY_USERID, new Object[]{ user_id},
				new ResultSetExtractor<List<KjljDoc01>>()
				{
			@Override
			public List<KjljDoc01> extractData( ResultSet rs )
					throws SQLException, DataAccessException
					{
				int i=0;
				List<KjljDoc01> list = new ArrayList<KjljDoc01>();
				while( rs.next() )
				{   
					KjljDoc01 kjljdoc01 = new KjljDoc01();
					kjljdoc01.setId(rs.getInt("id"));
					kjljdoc01.setUser_id(rs.getInt("user_id"));
					kjljdoc01.setName(rs.getString("name"));
					kjljdoc01.setMinzu(rs.getString("minzu"));
					kjljdoc01.setBirthday(rs.getDate("birthday"));
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
					kjljdoc01.setStudy_start_time(rs.getDate("study_start_time"));
					kjljdoc01.setStudy_end_time(rs.getDate("study_end_time"));
					kjljdoc01.setWork_country(rs.getString("work_country"));
					kjljdoc01.setWork_company(rs.getString("work_company"));
					kjljdoc01.setWork_position(rs.getString("work_position"));
					kjljdoc01.setWork_start_time(rs.getDate("work_start_time"));
					kjljdoc01.setWork_end_time(rs.getDate("work_end_time"));
					kjljdoc01.setJournal_title(rs.getString("journal_title"));
					kjljdoc01.setOrganization_position(rs.getString("organization_position"));
					kjljdoc01.setOrganization_term(rs.getString("organization_term"));
					kjljdoc01.setUnit_name(rs.getString("unit_name"));
					kjljdoc01.setOrganization_code(rs.getString("organization_code"));
					kjljdoc01.setLegal_representative(rs.getString("legal_representative"));
					kjljdoc01.setSupervisor_unit(rs.getString("supervisor_unit"));
					kjljdoc01.setUnit_address(rs.getString("unit_address"));
					kjljdoc01.setPostcode(rs.getString("postcode"));
					kjljdoc01.setUnit_contact(rs.getString("unit_contact"));
					kjljdoc01.setWork_telephone(rs.getString("work_telephone"));
					kjljdoc01.setWork_fax(rs.getString("work_fax"));
					list.add(kjljdoc01);
				}
				System.err.println("tiaoshu"+i);
				return list;
					}
				} );
	}
/*	public kjljdoc01 getById( int id )
	{
		return jdbcTemplate.query( SQL_Get_BY_ID, new Object[]{id},
				new ResultSetExtractor<kjljdoc01>()
				{
			@Override
			public kjljdoc01 extractData( ResultSet rs )
					throws SQLException, DataAccessException
					{
				kjljdoc01 kjljdoc01 = new kjljdoc01(); 
				if( rs.next() )
				{
					kjljdoc01.setId(rs.getInt("id"));
					kjljdoc01.setUser_id(rs.getInt("user_id"));
					kjljdoc01.setName(rs.getString("name"));
					kjljdoc01.setMinzu(rs.getString("minzu"));
					kjljdoc01.setBirthday(rs.getDate("birthday"));
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
					kjljdoc01.setStudy_start_time(rs.getDate("study_start_time"));
					kjljdoc01.setStudy_end_time(rs.getDate("study_end_time"));
					kjljdoc01.setWork_country(rs.getString("work_country"));
					kjljdoc01.setWork_company(rs.getString("work_company"));
					kjljdoc01.setWork_position(rs.getString("work_position"));
					kjljdoc01.setWork_start_time(rs.getDate("work_start_time"));
					kjljdoc01.setWork_end_time(rs.getDate("work_end_time"));
					kjljdoc01.setJournal_title(rs.getString("journal_title"));
					kjljdoc01.setOrganization_position(rs.getString("organization_position"));
					kjljdoc01.setOrganization_term(rs.getString("organization_term"));
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
				} );
	}*/
	/**
	 * 定义内部类实现RowMapper接口
	 */
	public class kjljdoc01RowMapper implements ParameterizedRowMapper<KjljDoc01>

	{
		// 实现mapRow方法
		@Override
		public KjljDoc01 mapRow( ResultSet rs, int num ) throws SQLException
		{
			// 对类进行封装
			KjljDoc01 kjljdoc01 = new KjljDoc01();
			kjljdoc01.setId(rs.getInt("id"));
			kjljdoc01.setUser_id(rs.getInt("user_id"));
			kjljdoc01.setName(rs.getString("name"));
			kjljdoc01.setMinzu(rs.getString("minzu"));
			kjljdoc01.setBirthday(rs.getDate("birthday"));
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
			kjljdoc01.setStudy_start_time(rs.getDate("study_start_time"));
			kjljdoc01.setStudy_end_time(rs.getDate("study_end_time"));
			kjljdoc01.setWork_country(rs.getString("work_country"));
			kjljdoc01.setWork_company(rs.getString("work_company"));
			kjljdoc01.setWork_position(rs.getString("work_position"));
			kjljdoc01.setWork_start_time(rs.getDate("work_start_time"));
			kjljdoc01.setWork_end_time(rs.getDate("work_end_time"));
			kjljdoc01.setJournal_title(rs.getString("journal_title"));
			kjljdoc01.setOrganization_position(rs.getString("organization_position"));
			kjljdoc01.setOrganization_term(rs.getString("organization_term"));
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
