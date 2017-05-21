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
import com.jfn.entity.CxtdMemberInfo;
import com.jfn.entity.CxtdMemberNum;

@Repository
public class CxtdDoc01Dao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	//private final String SQL_SELECT_TIME = "select id from user_team where userid=?";
	//团队基本信息
	private final String SQL_UPDATE_BASE = "update cxtd_base_info set team_name=?,research_direction=?,subordinate_subject1=?,subordinate_subject2=?,"
				+"project_type=?,project_name=?,project_source=?,unit_name=?,organization_code=?,legal_representative=?,competent_department=?,unit_addresses=?,"
				+"zip_code=?,contacts=?,mobile_phone=?,email=?,fax=?,telephone=? where user_id=?";
	private final String SQL_INSERT_BASE = "insert into cxtd_base_info( user_id,team_id,team_name,research_direction,subordinate_subject1,subordinate_subject2,"
				+"project_type,orther,project_name,project_source,unit_name,organization_code,legal_representative,competent_department,unit_addresses,"
				+"zip_code,contacts,mobile_phone,email,fax,telephone) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	//团队负责人信息
	//private final String SQL_SELECT_LEADER = "select * from cxtd_leader_info where user_id = ?";
	private final String SQL_UPDATE_LEADER = "update cxtd_leader_info set name=?,sex=?,country=?,minzu=?,position=?,birthday=?,id_type=?,id_num=?,direction=?,subordinate_subject1=?,subordinate_subject2=?,telephone_fax=?,mobile_phone=?,email=?,zip_code=?,"
			+"addresses=?,study_country=?"
			 +",study_colleges=?,study_major=?,study_education=?,study_start_time=?,study_end_time=?,user_studcountry2=?,user_studcollege2=?,user_studmajor2=?,user_studdegree2=?,user_studfirsttime2=?,user_studlasttime2=?"
			 +",work_country=?,work_company=?,work_position=?,work_start_time=?,work_end_time=?,user_workcountry=?,user_workcollege=?,user_workmajor=?,work_starttime=?,work_endtime=?"
			 + ",journal_title=?,organization_position=?,organization_term=?,journal_title1=?,organization_position1=?,organization_term1=?,journal_title2=?,organization_position2=?,organization_term2=? where user_id=?";
	private final String SQL_INSERT_LEADER = "insert into cxtd_leader_info(user_id,team_id,name,sex,country,minzu,position,birthday,id_type,id_num,direction,subordinate_subject1,subordinate_subject2,telephone_fax,mobile_phone,email,zip_code,"
			+"addresses,study_country,study_colleges,study_major,study_education,study_start_time,study_end_time,user_studcountry2,user_studcollege2,user_studmajor2,user_studdegree2,user_studfirsttime2,user_studlasttime2,"
			+ "work_country,work_company,work_position,work_start_time,work_end_time,user_workcountry,user_workcollege,user_workmajor,work_starttime,work_endtime,"
			+ "journal_title,organization_position,organization_term,journal_title1,organization_position1,organization_term1,journal_title2,organization_position2,organization_term2) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
/*	private final String SQL_SELECT_STUDY = "select * from user_peixun where user_id=?";
	private final String SQL_SELECT_WORK = "select * from user_work where user_id=?";*/
	private final String SQL_SELECT_ZUZHI = "select * from cxtd_leader_zuzhi where user_id = ?";
	private final String SQL_UPDATE_ZUZHI ="update cxtd_leader_zuzhi set name=?,job=?,renqi=? where user_id=?";
	private final String SQL_INSERT_ZUZHI ="insert into cxtd_leader_zuzhi(user_id,name,job,renqi) values(?,?,?,?)";
    private final String SQL_DEL_ZUZHI="delete from cxtd_leader_zuzhi where user_id=?";	
	//团队成员情况
	private final String SQL_SELECT_MEMBER_NUM="select * from cxtd_member_num where team_id=?";
	private final String SQL_UPDATE_MEMBER_NUM = "update cxtd_member_num set num=?,age_56=?,age_46_55=?,age_36_45=?,"
			+ "age_35=?,gaoji=?,fugao=?,zhongji=?,z_orther=?,boshi=?,shuoshi=?,benke=?,z_orther=? where team_id=? ";
	private final String SQL_INSERT_MEMBER_NUM="insert into cxtd_member_num(team_id,num,age_56,age_46_55,age_36_45,age_35,"
			+ "gaoji,fugao,zhongji,z_orther,boshi,shuoshi,benke,x_orther)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	private final String SQL_SELECT_MEMBER_INFO="select * from cxtd_member_info where team_id=?";
	private final String SQL_UPDATE_MEMBER_INFO="update cxtd_member_info set name=?,sex=?,birthday=?,id_type=?,id_num=?,"
			+ "study_education=?,work_position=?,direction=?,work_company=? where team_id=?";
	private final String SQL_INSERT_MEMBER_INFO="insert into cxtd_member_info(team_id,name,sex,birthday,id_type,id_num,study_education,"
			+ "work_position,direction,work_company) values(?,?,?,?,?,?,?,?,?,?)";
	private final String SQL_DEL_MEM="delete from cxtd_member_info where team_id=?";
	/**
	 * 查询用户对应的团队ID
	 * @param user_id
	 * @return
	 */
	public Integer getTimeId(int user_id) {
		String SQL_SELECT_TIME = "select id from user_team where userid="+user_id;
			return jdbcTemplate.query(SQL_SELECT_TIME, new ResultSetExtractor<Integer>(){

				@Override
				public Integer extractData(ResultSet rs)
						throws SQLException, DataAccessException {
					Integer id = null;
					while(rs.next()){
						id = rs.getInt("id");
						System.err.println("团队ID为："+id);
					}					
					return id;
				}
			});
}
	public void insertTeamId(int user_id){
		String sql = "insert into user_team(userid) values('"+user_id+"')";
		jdbcTemplate.update(sql);
		
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
	public void deletezu(int user_id) {
		jdbcTemplate.update(SQL_DEL_ZUZHI, new Object[] { user_id });
	}
	public void deleteme(int team_id) {
		jdbcTemplate.update(SQL_DEL_MEM, new Object[] { team_id });
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
	public boolean insertCxtdBase(CxtdBaseInfo baseinfo,int user_id , int teamid){
		Object[] params =new Object[]{
				user_id,
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
						CxtdLeaderInfo Leaderinfo = new CxtdLeaderInfo();
						while (rs.next()) {
							Leaderinfo.setId(rs.getInt("id"));
							Leaderinfo.setName(rs.getString("name"));
							Leaderinfo.setSex(rs.getString("sex"));
							Leaderinfo.setCountry(rs.getString("country"));
							Leaderinfo.setMinzu(rs.getString("minzu"));
							Leaderinfo.setPosition(rs.getString("position"));
							Leaderinfo.setBirthday(rs.getString("birthday"));
							Leaderinfo.setDocumentType(rs.getString("id_type"));
							Leaderinfo.setDocumentNumber(rs.getString("id_num"));
							Leaderinfo.setDirection(rs.getString("direction"));
							Leaderinfo.setSubordinateSubject1(rs.getString("subordinate_subject1"));
							Leaderinfo.setSubordinateSubject2(rs.getString("subordinate_subject2"));
							Leaderinfo.setTelephoneFax(rs.getString("telephone_fax"));
							Leaderinfo.setMobilePhone(rs.getString("mobile_phone"));
							Leaderinfo.setEmail(rs.getString("email"));
							Leaderinfo.setZipCode(rs.getString("zip_code"));
							Leaderinfo.setAddresses(rs.getString("addresses"));
							Leaderinfo.setStudy_country(rs.getString("study_country"));
							Leaderinfo.setStudy_colleges(rs.getString("study_colleges"));
							Leaderinfo.setStudy_major(rs.getString("study_major"));
							Leaderinfo.setStudy_education(rs.getString("study_education"));
							String temp2 = rs.getString("study_start_time");
							if (temp2 != null && !temp2.equals("")) {
								String Year = temp2.substring(0, 4);
								String Month = temp2.substring(5, 7);
								String Day = temp2.substring(8, 10);
								temp2 = Year + "." + Month + "." + Day;
							}

							Leaderinfo.setStudy_start_time(temp2);
							String temp1 = rs.getString("study_end_time");
							if (temp1 != null && !temp1.equals("")) {
								String Year = temp1.substring(0, 4);
								String Month = temp1.substring(5, 7);
								String Day = temp1.substring(8, 10);
								temp1 = Year + "." + Month + "." + Day;
							}

							Leaderinfo.setStudy_end_time(temp1);
							Leaderinfo.setUser_studcountry2(rs.getString("user_studcountry2"));
							Leaderinfo.setUser_studcollege2(rs.getString("user_studcollege2"));
							Leaderinfo.setUser_studmajor2(rs.getString("user_studmajor2"));
							Leaderinfo.setUser_studdegree2(rs.getString("user_studdegree2"));
							String temp4 = rs.getString("user_studfirsttime2");
							if (temp4 != null && !temp4.equals("")) {
								String Year = temp4.substring(0, 4);
								String Month = temp4.substring(5, 7);
								String Day = temp4.substring(8, 10);
								temp4 = Year + "." + Month + "." + Day;
							}
							Leaderinfo.setUser_studfirsttime2(temp4);
							String temp3 = rs.getString("user_studlasttime2");
							if (temp3 != null && !temp3.equals("")) {
								String Year = temp3.substring(0, 4);
								String Month = temp3.substring(5, 7);
								String Day = temp3.substring(8, 10);
								temp3 = Year + "." + Month + "." + Day;
							}
							Leaderinfo.setUser_studlasttime2(temp3);
							Leaderinfo.setWork_country(rs.getString("work_country"));
							Leaderinfo.setWork_company(rs.getString("work_company"));
							Leaderinfo.setWork_position(rs.getString("work_position"));
							
							String temp5 = rs.getString("work_start_time");
							if (temp5 != null && !temp5.equals("")) {
								String Year = temp5.substring(0, 4);
								String Month = temp5.substring(5, 7);
								String Day = temp5.substring(8, 10);
								temp5 = Year + "." + Month + "." + Day;
							}
							Leaderinfo.setWork_start_time(temp5);
							String temp6 = rs.getString("work_end_time");
							if (temp6 != null && !temp6.equals("")) {
								String Year = temp6.substring(0, 4);
								String Month = temp6.substring(5, 7);
								String Day = temp6.substring(8, 10);
								temp6 = Year + "." + Month + "." + Day;
							}
							Leaderinfo.setWork_end_time(temp6);
							Leaderinfo.setUser_workcountry(rs.getString("user_workcountry"));
							Leaderinfo.setUser_workcollege(rs.getString("user_workcollege"));
							Leaderinfo.setUser_workmajor(rs.getString("user_workmajor"));
							String temp7 = rs.getString("work_starttime");
							if (temp7 != null && !temp7.equals("")) {
								String Year = temp7.substring(0, 4);
								String Month = temp7.substring(5, 7);
								String Day = temp7.substring(8, 10);
								temp7 = Year + "." + Month + "." + Day;
							}
							Leaderinfo.setWork_starttime(temp7);
							String temp8 = rs.getString("work_endtime");
							if (temp8 != null && !temp8.equals("")) {
								String Year = temp8.substring(0, 4);
								String Month = temp8.substring(5, 7);
								String Day = temp8.substring(8, 10);
								temp8 = Year + "." + Month + "." + Day;
							}
							Leaderinfo.setWork_endtime(temp8);
							Leaderinfo.setJournal_title(rs.getString("journal_title"));
							Leaderinfo.setOrganization_position(rs.getString("organization_position"));
							Leaderinfo.setOrganization_term(rs.getString("organization_term"));
							Leaderinfo.setJournal_title1(rs.getString("journal_title1"));
							Leaderinfo.setOrganization_position1(rs.getString("organization_position1"));
							Leaderinfo.setOrganization_term1(rs.getString("organization_term1"));
							Leaderinfo.setJournal_title2(rs.getString("journal_title2"));
							Leaderinfo.setOrganization_position2(rs.getString("organization_position2"));
							Leaderinfo.setOrganization_term2(rs.getString("organization_term2"));
						}
						return Leaderinfo;
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
				Leaderinfo.getStudy_country(),
				Leaderinfo.getStudy_colleges(),
				Leaderinfo.getStudy_major(),
				Leaderinfo.getStudy_education(),
				Leaderinfo.getStudy_start_time(),
				Leaderinfo.getStudy_end_time(),
				Leaderinfo.getUser_studcountry2(),
				Leaderinfo.getUser_studcollege2(),
				Leaderinfo.getUser_studmajor2(),
				Leaderinfo.getUser_studdegree2(),
				Leaderinfo.getUser_studfirsttime2(),
				Leaderinfo.getUser_studlasttime2(),
				Leaderinfo.getWork_country(),
				Leaderinfo.getWork_company(),
				Leaderinfo.getWork_position(),
				Leaderinfo.getWork_start_time(),
				Leaderinfo.getWork_end_time(),
				Leaderinfo.getUser_workcountry(),
				Leaderinfo.getUser_workcollege(),
				Leaderinfo.getUser_workmajor(),
				Leaderinfo.getWork_starttime(),
				Leaderinfo.getWork_endtime(),
				Leaderinfo.getJournal_title(),
				Leaderinfo.getOrganization_position(),
				Leaderinfo.getOrganization_term(),
				Leaderinfo.getJournal_title1(),
				Leaderinfo.getOrganization_position1(),
				Leaderinfo.getOrganization_term1(),
				Leaderinfo.getJournal_title2(),
				Leaderinfo.getOrganization_position2(),
				Leaderinfo.getOrganization_term2(),
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
	public boolean insertCxtdLeaderInfo(CxtdLeaderInfo Leaderinfo,int user_id , int team_id){
		Object[] params =new Object[]{
				user_id,
				team_id,
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
				Leaderinfo.getStudy_country(),
				Leaderinfo.getStudy_colleges(),
				Leaderinfo.getStudy_major(),
				Leaderinfo.getStudy_education(),
				Leaderinfo.getStudy_start_time(),
				Leaderinfo.getStudy_end_time(),
				Leaderinfo.getUser_studcountry2(),
				Leaderinfo.getUser_studcollege2(),
				Leaderinfo.getUser_studmajor2(),
				Leaderinfo.getUser_studdegree2(),
				Leaderinfo.getUser_studfirsttime2(),
				Leaderinfo.getUser_studlasttime2(),
				Leaderinfo.getWork_country(),
				Leaderinfo.getWork_company(),
				Leaderinfo.getWork_position(),
				Leaderinfo.getWork_start_time(),
				Leaderinfo.getWork_end_time(),
				Leaderinfo.getUser_workcountry(),
				Leaderinfo.getUser_workcollege(),
				Leaderinfo.getUser_workmajor(),
				Leaderinfo.getWork_starttime(),
				Leaderinfo.getWork_endtime(),
				Leaderinfo.getJournal_title(),
				Leaderinfo.getOrganization_position(),
				Leaderinfo.getOrganization_term(),
				Leaderinfo.getJournal_title1(),
				Leaderinfo.getOrganization_position1(),
				Leaderinfo.getOrganization_term1(),
				Leaderinfo.getJournal_title2(),
				Leaderinfo.getOrganization_position2(),
				Leaderinfo.getOrganization_term2(),
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
		
		/**
		 * 查询团队成员统计情况
		 * @param userid
		 * @return
		 */
		public CxtdMemberNum queryCxtdMemberNum(int team_id){
			return jdbcTemplate.query(SQL_SELECT_MEMBER_NUM, new Object[] { team_id },
					new ResultSetExtractor<CxtdMemberNum>(){
				
						public CxtdMemberNum extractData(ResultSet rs) throws SQLException, DataAccessException {
							CxtdMemberNum num = new CxtdMemberNum();
							while (rs.next()) {
								num.setId(rs.getInt("id"));
								num.setTeam_id(rs.getInt("team_id"));
								num.setNum(rs.getInt("num"));
								num.setAge_56(rs.getInt("age_56"));
								num.setAge_46_55(rs.getInt("age_46_55"));
								num.setAge_36_45(rs.getInt("age_36_45"));
								num.setAge_35(rs.getInt("age_35"));
								num.setGaoji(rs.getInt("gaoji"));
								num.setFugao(rs.getInt("fugao"));
								num.setZhongji(rs.getInt("zhongji"));
								num.setZ_orther(rs.getInt("z_orther"));
								num.setBoshi(rs.getInt("boshi"));
								num.setShuoshi(rs.getInt("shuoshi"));
								num.setBenke(rs.getInt("benke"));
								num.setX_orther(rs.getInt("x_orther"));
							}
							return num;
						}
			});
		}
		
		/**
		 * 更新团队成员统计信息
		 * @param baseinfo
		 * @param user_id
		 * @return
		 */
		public boolean updateCxtdMemberNum(CxtdMemberNum num,int team_id){
			Object[] params =new Object[]{
				num.getNum(),
					num.getAge_56(),
					num.getAge_46_55(),
					num.getAge_36_45(),
					num.getAge_35(),
					num.getGaoji(),
					num.getFugao(),
					num.getZhongji(),
					num.getZ_orther(),
					num.getBoshi(),
					num.getShuoshi(),
					num.getBenke(),
					num.getZ_orther(),
					team_id
			};
			return jdbcTemplate.update(SQL_UPDATE_MEMBER_NUM,params) == 1;
		}
		/**
		 * 插入团队成员统计
		 * @param num
		 * @param user_id
		 * @return
		 */
		public boolean insertCxtdMemberNum(CxtdMemberNum num,int team_id){
			Object[] params =new Object[]{
					team_id,
					num.getNum(),
					num.getAge_56(),
					num.getAge_46_55(),
					num.getAge_36_45(),
					num.getAge_35(),
					num.getGaoji(),
					num.getFugao(),
					num.getZhongji(),
					num.getZ_orther(),
					num.getBoshi(),
					num.getShuoshi(),
					num.getBenke(),
					num.getX_orther()
			};
			return jdbcTemplate.update(SQL_INSERT_MEMBER_NUM, params) == 1;
		}
		
		/**
		 * 定义内部类实现RowMapper接口
		 */
		public class Member_infoRowMapper implements ParameterizedRowMapper<CxtdMemberInfo> {
			// 实现mapRow方法
			@Override
			public CxtdMemberInfo mapRow(ResultSet rs, int num) throws SQLException {
				// 对类进行封装
				CxtdMemberInfo memInfo = new CxtdMemberInfo();
				memInfo.setId(rs.getInt("id"));
				memInfo.setTeam_id(rs.getInt("team_id"));
				memInfo.setName(rs.getString("name"));
				memInfo.setSex(rs.getString("sex"));
				memInfo.setBirthday(rs.getString("birthday"));
				memInfo.setId_type(rs.getString("id_type"));
				memInfo.setId_num(rs.getString("id_num"));
				memInfo.setStudy_education(rs.getString("study_education"));
				memInfo.setDirection(rs.getString("direction"));
				memInfo.setWork_position(rs.getString("work_position"));
				memInfo.setWork_company(rs.getString("work_company"));
				return memInfo;
			}
		}
		
		/**
		 * 查询团队成员详细情况
		 * @param team_id
		 * @return
		 */
		public List<CxtdMemberInfo> queryCxtdMemberInfo(int team_id){
			return jdbcTemplate.query(SQL_SELECT_MEMBER_INFO, new Object[] { team_id },new Member_infoRowMapper());
		}
		/**
		 * 更新团队成员详细信息
		 * @param baseinfo
		 * @param user_id
		 * @return
		 */
		public boolean updateCxtdMemberInfo(CxtdMemberInfo memInfo,int team_id){
			Object[] params =new Object[]{
					memInfo.getName(),
					memInfo.getSex(),
					memInfo.getBirthday(),
					memInfo.getId_type(),
					memInfo.getId_num(),
					memInfo.getStudy_education(),
					memInfo.getWork_position(),
					memInfo.getDirection(),
					memInfo.getWork_company(),
					team_id
			};
			return jdbcTemplate.update(SQL_UPDATE_MEMBER_INFO,params) == 1;
		}
		/**
		 * 插入团队成员
		 * @param num
		 * @param user_id
		 * @return
		 */
		public boolean insertCxtdMemberInfo(CxtdMemberInfo memInfo,int team_id){
			Object[] params =new Object[]{
					team_id,
					memInfo.getName(),
					memInfo.getSex(),
					memInfo.getBirthday(),
					memInfo.getId_type(),
					memInfo.getId_num(),
					memInfo.getStudy_education(),
					memInfo.getWork_position(),
					memInfo.getDirection(),
					memInfo.getWork_company(),
			};
			return jdbcTemplate.update(SQL_INSERT_MEMBER_INFO, params) == 1;
		}
		
		
	
	

	

}
