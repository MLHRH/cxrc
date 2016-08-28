package com.jfn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.jfn.entity.cxtdDoc01;

@Repository
public class cxtdDoc01Dao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private final String SQL_SELECT = "select id from user_team where userid=?";
	private final String SQL_UPDATE_DOC01 = "update cxtd_doc01 set  team_id=?,team_name=?,research_direction=?,subordinate_subject1=?,subordinate_subject2=?,"
				+"project_type=?,project_name=?,project_source=?,unit_name=?,organization_code=?,legal_representative=?,competent_department=?,unit_addresses=?,"
				+"zip_code=?,contacts=?,mobile_phone=?,email=?,fax=?,telephone=? where user_id=?";
	private final String SQL_INSERT_DOC01 = "insert into cxtd_doc01( team_id,team_name,research_direction,subordinate_subject1,subordinate_subject2,"
				+"project_type,orther,project_name,project_source,unit_name,organization_code,legal_representative,competent_department,unit_addresses,"
				+"zip_code,contacts,mobile_phone,email,fax,telephone) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	//查询
	public cxtdDoc01 queryCxtdDoc01(int userid){
		String SQL_SELECT_ID = "select * from cxtd_doc01 where status = 0 and user_id="+userid ;
		return jdbcTemplate.query(SQL_SELECT_ID,
				new ResultSetExtractor<cxtdDoc01>(){

					@Override
					public cxtdDoc01 extractData(ResultSet rs) throws SQLException, DataAccessException {
						// TODO Auto-generated method stub
						cxtdDoc01 cxtddoc01 = new cxtdDoc01();
						while (rs.next()) {
							cxtddoc01.setTeamId(rs.getInt("team_id"));
							cxtddoc01.setTeamName(rs.getString("team_name"));
							cxtddoc01.setResearchDirection(rs.getString("research_direction"));
							cxtddoc01.setSubordinateSubject1(rs.getString("subordinate_subject1"));
							cxtddoc01.setSubordinateSubject2(rs.getString("subordinate_subject2"));
							cxtddoc01.setOrther(rs.getString("orther"));
							cxtddoc01.setProjectName(rs.getString("project_name"));
							cxtddoc01.setProjectType(rs.getString("project_type"));
							cxtddoc01.setProjectSource(rs.getString("project_source"));
							cxtddoc01.setUnitName(rs.getString("unit_name"));
							cxtddoc01.setOrganizationCode(rs.getString("organization_code"));
							cxtddoc01.setLegalRepresentative(rs.getString("legal_representative"));
							cxtddoc01.setCompetentDepartment(rs.getString("competent_department"));
							cxtddoc01.setUnitAddresses(rs.getString("unit_addresses"));
							cxtddoc01.setZipCode(rs.getInt("zip_code"));
							cxtddoc01.setContacts(rs.getString("contacts"));
							cxtddoc01.setMobilePhone(rs.getString("mobile_phone"));
							cxtddoc01.setEmail(rs.getString("email"));
							cxtddoc01.setFax(rs.getString("fax"));
							cxtddoc01.setTelephone(rs.getString("telephone"));
						}
						return cxtddoc01;
					}
			
		});
	}
	
	
	
	
	
	
	//更新数据
	public boolean updateCxtdDoc01(cxtdDoc01 cxtddoc01,int user_id){
		
		
		Object[] params =new Object[]{
				cxtddoc01.getTeamId(),
				cxtddoc01.getTeamName(),
				cxtddoc01.getResearchDirection(),
				cxtddoc01.getSubordinateSubject1(),
				cxtddoc01.getSubordinateSubject2(),
				cxtddoc01.getProjectType(),
				cxtddoc01.getProjectName(),
				cxtddoc01.getProjectSource(),
				cxtddoc01.getUnitName(),
				cxtddoc01.getOrganizationCode(),
				cxtddoc01.getLegalRepresentative(),
				cxtddoc01.getCompetentDepartment(),
				cxtddoc01.getUnitAddresses(),
				cxtddoc01.getZipCode(),
				cxtddoc01.getContacts(),
				cxtddoc01.getMobilePhone(),
				cxtddoc01.getEmail(),
				cxtddoc01.getFax(),
				cxtddoc01.getTelephone(),
				user_id
				
		};
		return jdbcTemplate.update(SQL_UPDATE_DOC01,params) == 1;
	}
	
	public int insertCxtdDoc01(cxtdDoc01 cxtddoc01,int user_id){
		String sql = "insert into user_team(userid) values('"+user_id+"')";
		jdbcTemplate.update(sql);
		int teamid = jdbcTemplate.queryForInt("select id from user_team where userid ="+user_id);
		Object[] params =new Object[]{
				teamid,
				cxtddoc01.getTeamName(),
				cxtddoc01.getResearchDirection(),
				cxtddoc01.getSubordinateSubject1(),
				cxtddoc01.getSubordinateSubject2(),
				cxtddoc01.getProjectType(),
				cxtddoc01.getOrther(),
				cxtddoc01.getProjectName(),
				cxtddoc01.getProjectSource(),
				cxtddoc01.getUnitName(),
				cxtddoc01.getOrganizationCode(),
				cxtddoc01.getLegalRepresentative(),
				cxtddoc01.getCompetentDepartment(),
				cxtddoc01.getUnitAddresses(),
				cxtddoc01.getZipCode(),
				cxtddoc01.getContacts(),
				cxtddoc01.getMobilePhone(),
				cxtddoc01.getEmail(),
				cxtddoc01.getFax(),
				cxtddoc01.getTelephone(),
		};
		return jdbcTemplate.update(SQL_INSERT_DOC01, params);
		
	}
	
	
	public int  queryStatus(int user_id){
		String sql="select status from cxtd_doc01 where user"+user_id;
		return jdbcTemplate.queryForInt(sql);
	}
	
	public int getTimeId(int user_id) {
		  
		  int team_id = jdbcTemplate.queryForInt(SQL_SELECT,new Object[]{user_id});
		  return team_id;
		
	}

}
