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

import com.jfn.entity.CxtdBaseInfo;
import com.jfn.entity.CxtdLeaderInfo;
import com.jfn.entity.CxtdLeaderZuzhi;

@Repository
public class CxtdDoc01Dao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private final String SQL_SELECT_TIME = "select id from user_team where userid=?";
	//团队基本信息
	private final String SQL_UPDATE_BASE = "update cxtd_base_info set team_name=?,research_direction=?,subordinate_subject1=?,subordinate_subject2=?,"
				+"project_type=?,project_name=?,project_source=?,unit_name=?,organization_code=?,legal_representative=?,competent_department=?,unit_addresses=?,"
				+"zip_code=?,contacts=?,mobile_phone=?,email=?,fax=?,telephone=? where user_id=?";
	private final String SQL_INSERT_BASE = "insert into cxtd_base_info( team_id,team_name,research_direction,subordinate_subject1,subordinate_subject2,"
				+"project_type,orther,project_name,project_source,unit_name,organization_code,legal_representative,competent_department,unit_addresses,"
				+"zip_code,contacts,mobile_phone,email,fax,telephone) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	//团队负责人信息
	//private final String SQL_SELECT_LEADER = "select * from cxtd_leader_info where user_id = ?";
	private final String SQL_UPDATE_LEADER = "update cxtd_leader_info set name=?,sex=?,country=?,minzu=?,position=?,birthday=?,id_type=?,id_num=?,direction=?,subordinate_subject1=?,subordinate_subject2=?,telephone_fax=?,mobile_phone=?,email=?,zip_code=?,"
			+"addresses=? where user_id=?";
	private final String SQL_INSERT_LEADER = "insert into cxtd_leader_info(user_id,name,sex,country,minzu,position,birthday,id_type,id_num,direction,subordinate_subject1,subordinate_subject2,telephone_fax,mobile_phone,email,zip_code,"
			+"addresses) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
/*	private final String SQL_SELECT_STUDY = "select * from user_peixun where user_id=?";
	private final String SQL_SELECT_WORK = "select * from user_work where user_id=?";*/
	private final String SQL_SELECT_ZUZHI = "select * from cxtd_leader_zuzhi where user_id = ?";
	private final String SQL_UPDATE_ZUZHI ="update cxtd_leader_zuzhi set name=?,job=?,renqi=? where user_id=?";
	private final String SQL_INSERT_ZUZHI ="insert into cxtd_leader_zuzhi(user_id,name,job,renqi) values(?,?,?,?)";
			
	//团队成员情况
	private final String SQL_SELECT_MEMBER_NUM="select * from cxtd_member_num where team_id=?";
	private final String SQL_UPDATE_MEMBER_NUM="update cxtd_member_num set age_56=?,age_46_55=?,age_36_45=?"
			+ "age_35=?,gaoji=?,fugao=?,zhongji=?,z_orther=?,boshi=?,shuoshi=?,benle=?,z_orther=? where team_id=? ";
	private final String SQL_INSERT_MEMBER_NUM="insert into cxtd_member_num(team_id,age_56,age_46_55,age_36_45,age_35,"
			+ "gaoji,fugao,zhongji,z_orther,boshi,shuoshi,benke,z_orther)values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	private final String SQL_SELECT_MEMBER_INFO="select * from cxtd_member_info where team_id=?";
	private final String SQL_UPDATE_MEMBER_INFO="update cxtd_member_info set name=?,sex?,birthday=?,id_type=?,id_num=?,"
			+ "study_education=?,work_position=?,direction=?,work_company=? where time_id=?";
	private final String SQL_INSERT_MEMBER_INFO="insert into cxtd_member_info(team_id,name,sex,birthday,id_type,id_num,study_education"
			+ "work_position,direction,work_company) values(?,?,?,?,?,?,?,?,?,?)";
	/**
	 * 查询用户对应的团队ID
	 * @param user_id
	 * @return
	 */
	public int getTimeId(int user_id) {
		  
		  int team_id = jdbcTemplate.queryForInt(SQL_SELECT_TIME,new Object[]{user_id});
		  return team_id;
		
	}
	/**
	 * 查询是否是已提交信息
	 * @param user_id
	 * @return
	 */
	public int  queryStatus(int user_id){
		String sql="select status from cxtd_doc01 where user"+user_id;
		return jdbcTemplate.queryForInt(sql);
	}

	/**
	 * 查询基本信息
	 * @param userid
	 * @return
	 */
	public CxtdBaseInfo queryCxtdBase(int userid){
		String SQL_SELECT_ID = "select * from cxtd_base_info where status = 0 and user_id="+userid ;
		return jdbcTemplate.query(SQL_SELECT_ID,
				new ResultSetExtractor<CxtdBaseInfo>(){

					@Override
					public CxtdBaseInfo extractData(ResultSet rs) throws SQLException, DataAccessException {
						CxtdBaseInfo baseinfo = new CxtdBaseInfo();
						while (rs.next()) {
							baseinfo.setTeamId(rs.getInt("team_id"));
							baseinfo.setTeamName(rs.getString("team_name"));
							baseinfo.setResearchDirection(rs.getString("research_direction"));
							baseinfo.setSubordinateSubject1(rs.getString("subordinate_subject1"));
							baseinfo.setSubordinateSubject2(rs.getString("subordinate_subject2"));
							baseinfo.setOrther(rs.getString("orther"));
							baseinfo.setProjectName(rs.getString("project_name"));
							baseinfo.setProjectType(rs.getString("project_type"));
							baseinfo.setProjectSource(rs.getString("project_source"));
							baseinfo.setUnitName(rs.getString("unit_name"));
							baseinfo.setOrganizationCode(rs.getString("organization_code"));
							baseinfo.setLegalRepresentative(rs.getString("legal_representative"));
							baseinfo.setCompetentDepartment(rs.getString("competent_department"));
							baseinfo.setUnitAddresses(rs.getString("unit_addresses"));
							baseinfo.setZipCode(rs.getInt("zip_code"));
							baseinfo.setContacts(rs.getString("contacts"));
							baseinfo.setMobilePhone(rs.getString("mobile_phone"));
							baseinfo.setEmail(rs.getString("email"));
							baseinfo.setFax(rs.getString("fax"));
							baseinfo.setTelephone(rs.getString("telephone"));
						}
						return baseinfo;
					}
			
		});
	}
	
	/**
	 * 更新基本信息
	 * @param baseinfo
	 * @param user_id
	 * @return
	 */
	public boolean updateCxtdBase(CxtdBaseInfo baseinfo,int user_id){
		Object[] params =new Object[]{
				baseinfo.getTeamName(),
				baseinfo.getResearchDirection(),
				baseinfo.getSubordinateSubject1(),
				baseinfo.getSubordinateSubject2(),
				baseinfo.getProjectType(),
				baseinfo.getProjectName(),
				baseinfo.getProjectSource(),
				baseinfo.getUnitName(),
				baseinfo.getOrganizationCode(),
				baseinfo.getLegalRepresentative(),
				baseinfo.getCompetentDepartment(),
				baseinfo.getUnitAddresses(),
				baseinfo.getZipCode(),
				baseinfo.getContacts(),
				baseinfo.getMobilePhone(),
				baseinfo.getEmail(),
				baseinfo.getFax(),
				baseinfo.getTelephone(),
				user_id
		};
		return jdbcTemplate.update(SQL_UPDATE_BASE,params) == 1;
	}
	/**
	 * 插入基本信息
	 * @param baseinfo
	 * @param user_id
	 * @return
	 */
	public boolean insertCxtdBase(CxtdBaseInfo baseinfo,int user_id){
		String sql = "insert into user_team(userid) values('"+user_id+"')";
		jdbcTemplate.update(sql);
		int teamid = jdbcTemplate.queryForInt("select id from user_team where userid ="+user_id);
		Object[] params =new Object[]{
				teamid,
				baseinfo.getTeamName(),
				baseinfo.getResearchDirection(),
				baseinfo.getSubordinateSubject1(),
				baseinfo.getSubordinateSubject2(),
				baseinfo.getProjectType(),
				baseinfo.getOrther(),
				baseinfo.getProjectName(),
				baseinfo.getProjectSource(),
				baseinfo.getUnitName(),
				baseinfo.getOrganizationCode(),
				baseinfo.getLegalRepresentative(),
				baseinfo.getCompetentDepartment(),
				baseinfo.getUnitAddresses(),
				baseinfo.getZipCode(),
				baseinfo.getContacts(),
				baseinfo.getMobilePhone(),
				baseinfo.getEmail(),
				baseinfo.getFax(),
				baseinfo.getTelephone(),
		};
		return jdbcTemplate.update(SQL_INSERT_BASE, params) == 1;
	}
	/**
	 * 查询团队负责人信息
	 * @param userid
	 * @return
	 */
	public CxtdLeaderInfo queryCxtdLeaderInfo(int userid){
		String SQL_SELECT_ID = "select * from cxtd_leader_info where user_id="+userid ;
		return jdbcTemplate.query(SQL_SELECT_ID,
				new ResultSetExtractor<CxtdLeaderInfo>(){
			
					public CxtdLeaderInfo extractData(ResultSet rs) throws SQLException, DataAccessException {
						CxtdLeaderInfo LeaderInfo = new CxtdLeaderInfo();
						while (rs.next()) {
							LeaderInfo.setName(rs.getString("name"));
							LeaderInfo.setSex(rs.getString("sex"));
							LeaderInfo.setCountry(rs.getString("country"));
							LeaderInfo.setMinzu(rs.getString("minzu"));
							LeaderInfo.setPosition(rs.getString("position"));
							LeaderInfo.setBirthday(rs.getString("birtyday"));
							LeaderInfo.setDocumentType(rs.getString("id_type"));
							LeaderInfo.setDocumentNumber(rs.getString("id_num"));
							LeaderInfo.setDirection(rs.getString("direction"));
							LeaderInfo.setSubordinateSubject1(rs.getString("subordinate_subject1"));
							LeaderInfo.setSubordinateSubject2(rs.getString("subordinate_subject2"));
							LeaderInfo.setTelephoneFax(rs.getString("telephone_fax"));
							LeaderInfo.setMobilePhone(rs.getString("mobile_phone"));
							LeaderInfo.setEmail(rs.getString("email"));
							LeaderInfo.setZipCode(rs.getString("zip_code"));
							LeaderInfo.setAddresses(rs.getString("addresses"));
						}
						return LeaderInfo;
					}
		});
	}
	/**
	 * 更新团队负责人信息
	 * @param baseinfo
	 * @param user_id
	 * @return
	 */
	public boolean updateCxtdLeaderInfo(CxtdLeaderInfo Leaderinfo,int user_id){
		Object[] params =new Object[]{
				Leaderinfo.getName(),
				Leaderinfo.getSex(),
				Leaderinfo.getCountry(),
				Leaderinfo.getMinzu(),
				Leaderinfo.getPosition(),
				Leaderinfo.getBirthday(),
				Leaderinfo.getDocumentType(),
				Leaderinfo.getDocumentNumber(),
				Leaderinfo.getDirection(),
				Leaderinfo.getSubordinateSubject1(),
				Leaderinfo.getSubordinateSubject2(),
				Leaderinfo.getTelephoneFax(),
				Leaderinfo.getMobilePhone(),
				Leaderinfo.getEmail(),
				Leaderinfo.getZipCode(),
				Leaderinfo.getAddresses(),
				user_id
		};
		return jdbcTemplate.update(SQL_UPDATE_LEADER,params) == 1;
	}
	/**
	 * 插入团队负责人信息
	 * @param baseinfo
	 * @param user_id
	 * @return
	 */
	public boolean insertCxtdLeaderInfo(CxtdLeaderInfo Leaderinfo,int user_id){
		Object[] params =new Object[]{
				user_id,
				Leaderinfo.getName(),
				Leaderinfo.getSex(),
				Leaderinfo.getCountry(),
				Leaderinfo.getMinzu(),
				Leaderinfo.getPosition(),
				Leaderinfo.getBirthday(),
				Leaderinfo.getDocumentType(),
				Leaderinfo.getDocumentNumber(),
				Leaderinfo.getDirection(),
				Leaderinfo.getSubordinateSubject1(),
				Leaderinfo.getSubordinateSubject2(),
				Leaderinfo.getTelephoneFax(),
				Leaderinfo.getMobilePhone(),
				Leaderinfo.getEmail(),
				Leaderinfo.getZipCode(),
				Leaderinfo.getAddresses(),
		};
		return jdbcTemplate.update(SQL_INSERT_LEADER, params) == 1;
	}
	
	/**
	 * 定义内部类实现RowMapper接口
	 */
	public class Leader_zuzhiRowMapper implements ParameterizedRowMapper<CxtdLeaderZuzhi> {
		// 实现mapRow方法
		@Override
		public CxtdLeaderZuzhi mapRow(ResultSet rs, int num) throws SQLException {
			// 对类进行封装
			CxtdLeaderZuzhi zuzhi = new CxtdLeaderZuzhi();
			zuzhi.setId(rs.getInt("id"));
			zuzhi.setName(rs.getString("name"));
			zuzhi.setJob(rs.getString("job"));
			zuzhi.setUser_id(rs.getInt("user_id"));
			zuzhi.setRenqi(rs.getString("renqi"));
			return zuzhi;
		}
	}
	/**
	 * 查询团队负责人国内外学术组织及重要学术期刊任职情况
	 * @param userid
	 * @return
	 */
		public List<CxtdLeaderZuzhi> getAllByUserId(String user_id) {
			return jdbcTemplate.query(SQL_SELECT_ZUZHI, new Object[] { user_id }, new Leader_zuzhiRowMapper());
		}
		
		/**
		 * 更新团队负责人国内外学术组织及重要学术期刊任职情况
		 * @param baseinfo
		 * @param user_id
		 * @return
		 */
		public boolean updateCxtdLeaderZuzhi(CxtdLeaderZuzhi zuzhi,int user_id){
			Object[] params =new Object[]{
					zuzhi.getName(),
					zuzhi.getJob(),
					zuzhi.getRenqi(),
					user_id
			};
			return jdbcTemplate.update(SQL_UPDATE_ZUZHI,params) == 1;
		}
		/**
		 * 插入团队负责人国内外学术组织及重要学术期刊任职情况
		 * @param baseinfo
		 * @param user_id
		 * @return
		 */
		public boolean insertCxtdLeaderZuzhi(CxtdLeaderZuzhi zuzhi,int user_id){
			Object[] params =new Object[]{
					user_id,
					zuzhi.getName(),
					zuzhi.getJob(),
					zuzhi.getRenqi(),
			};
			return jdbcTemplate.update(SQL_INSERT_ZUZHI, params) == 1;
		}
		
		
	
	

	

}
