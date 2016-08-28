package com.jfn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.jfn.entity.cxtdDoc02;
import com.jfn.entity.cxtdDoc02_study;
import com.jfn.entity.cxtdDoc02_work;
@Repository
public class cxtdDoc02Dao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private final String SQL_INSERT = "insert into cxtd_doc02(user_id,name,sex,country,minzu,position,birthday,document_type,document_number,direction,subordinate_subject1,subordinate_subject2,telephone_fax,mobile_phone,email,zip_code,"
	+"addresses,journal_title1,organization_position1,organization_term1,journal_title2,organization_position2,organization_term2) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private final String SQL_INSERT_STUDY = "insert into cxtd_doc02_study(user_id,country,college,major,degree,start_time,end_time) values(?,?,?,?,?,?,?)";
	private final String SQL_INSERT_WORK = "insert into cxtd_doc02_work(user_id,country,body,position,start_time,end_time) values(?,?,?,?,?,?)";
	private final String SQL_SELECT ="select * from cxtd_doc02 where user_id=?";;
	private final String SQL_SELECT_STUDY = "select * from cxtd_doc02_study where user_id=?";
	private final String SQL_SELECT_WORK = "select * from cxtd_doc02_work where user_id=?";
	public cxtdDoc02 getByUserId( int user_id )
	{
		return jdbcTemplate.query( SQL_SELECT, new Object[]{user_id},
				new ResultSetExtractor<cxtdDoc02>()
				{
			@Override
			public cxtdDoc02 extractData( ResultSet rs )
					throws SQLException, DataAccessException
					{
				cxtdDoc02 cxtddoc02 = new cxtdDoc02();
				while( rs.next() )
				{   
					cxtddoc02.setTeamId(rs.getInt("team_id"));
					cxtddoc02.setName(rs.getString("name"));
					cxtddoc02.setCountry(rs.getString("country"));
					cxtddoc02.setSex(rs.getString("sex"));
					cxtddoc02.setMinzu(rs.getString("minzu"));
					cxtddoc02.setPosition(rs.getString("position"));
					cxtddoc02.setBirthday(rs.getString("birthday"));
					cxtddoc02.setDocumentType(rs.getString("document_type"));
					cxtddoc02.setDocumentNumber(rs.getString("document_number"));
					cxtddoc02.setDirection(rs.getString("direction"));
					cxtddoc02.setSubordinateSubject1(rs.getString("subordinate_subject1"));
					cxtddoc02.setSubordinateSubject2(rs.getString("subordinate_subject2"));
					cxtddoc02.setTelephoneFax(rs.getString("telephone_fax"));
					cxtddoc02.setMobilePhone(rs.getString("mobile_phone"));
					cxtddoc02.setEmail(rs.getString("email"));
					cxtddoc02.setZipCode(rs.getString("zip_code"));
					cxtddoc02.setAddresses(rs.getString("addresses"));
				}
				return cxtddoc02;
					}
				} );
	}
	public List<cxtdDoc02_work> getCxtdDoc02_work( int user_id )
	{
		return jdbcTemplate.query( SQL_SELECT_WORK, new Object[]{ user_id},
				new ResultSetExtractor<List<cxtdDoc02_work>>()
				{
			@Override
			public List<cxtdDoc02_work> extractData( ResultSet rs )
					throws SQLException, DataAccessException
					{
				List<cxtdDoc02_work> work = new ArrayList<cxtdDoc02_work>();
				while( rs.next() )
				{   cxtdDoc02_work cxtddoc02_work = new cxtdDoc02_work();
				    cxtddoc02_work.setCountry(rs.getString("country"));
				    cxtddoc02_work.setBody(rs.getString("body"));
				    cxtddoc02_work.setPosition(rs.getString("position"));
				    cxtddoc02_work.setStart_time(rs.getString("start_time"));
				    cxtddoc02_work.setEnd_time(rs.getString("end_time"));
				    work.add(cxtddoc02_work);
				}
				return work;
					}
				} );
	}
	
	public List<cxtdDoc02_study> getCxtdDoc02_study( int user_id )
	{
		return jdbcTemplate.query( SQL_SELECT_STUDY, new Object[]{ user_id},
				new ResultSetExtractor<List<cxtdDoc02_study>>()
				{
			@Override
			public List<cxtdDoc02_study> extractData( ResultSet rs )
					throws SQLException, DataAccessException
					{
				List<cxtdDoc02_study> study = new ArrayList<cxtdDoc02_study>();
				while( rs.next() )
				{   cxtdDoc02_study cxtddoc02_study = new cxtdDoc02_study();
				    cxtddoc02_study.setCountry(rs.getString("country"));
				    cxtddoc02_study.setCollege(rs.getString("college"));
				    cxtddoc02_study.setDegree(rs.getString("degree"));
				    cxtddoc02_study.setMajor(rs.getString("major"));
				    cxtddoc02_study.setStart_time(rs.getString("start_time"));
				    cxtddoc02_study.setEnd_time(rs.getString("end_time"));
				    study.add(cxtddoc02_study);
				}
				return study;
					}
				} );
	}
	

}
