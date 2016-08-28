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

import com.jfn.entity.JcqnDocPatent;
import com.jfn.entity.JcqnDocPrize;
import com.jfn.entity.JcqnDocProject;
import com.jfn.entity.JcqnDocReport;
import com.jfn.entity.JcqnDocThesis;
import com.jfn.entity.JcqnDocTreatise;
@Repository
public class JcqnDoc02Dao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String SQL_INSERT_PROJECT = "insert into jcqn_doc02_01(xuhao_id,user_id,entry_name,project_number,funds,start_stop_time,project_nature,role) values(?,?,?,?,?,?,?,?)";
	private final String SQL_INSERT_PRIZE = "insert into jcqn_doc02_02(xuhao_id,user_id,award_item_name,prize_name,grade,sort,reward_time,grant_institution) values(?,?,?,?,?,?,?,?)";
	private final String SQL_INSERT_THESIS = "insert into jcqn_doc02_03(xuhao_id,user_id,thesis_topic,author_sort,journal_title,year_volume_pagenumber,influence_factor,sci_times) values(?,?,?,?,?,?,?,?)";
	private final String SQL_INSERT_PATENT = "insert into jcqn_doc02_04(xuhao_id,user_id,patent_name,grant_number,inventor_sort,type,authorized_time,authorized_national) values(?,?,?,?,?,?,?,?)";
	private final String SQL_INSERT_REPORT = "insert into jcqn_doc02_05(xuhao_id,user_id,report_name,meeting_name,organizers,meeting_time,meeting_place,report_type) values(?,?,?,?,?,?,?,?)";
	private final String SQL_INSERT_TREATISE = "insert into jcqn_doc02_06(xuhao_id,user_id,treatise_name,press,issuing_country,year) values(?,?,?,?,?,?)";

	private final String SQL_Get_BY_USERID_PROJECT = "select * from jcqn_doc02_01 where user_id=?";
	private final String SQL_Get_BY_USERID_PRIZE = "select * from jcqn_doc02_02 where user_id=?";
	private final String SQL_Get_BY_USERID_THESIS = "select * from jcqn_doc02_03 where user_id=?";
	private final String SQL_Get_BY_USERID_PATENT = "select * from jcqn_doc02_04 where user_id=?";
	private final String SQL_Get_BY_USERID_REPORT = "select * from jcqn_doc02_05 where user_id=?";
	private final String SQL_Get_BY_USERID_TREATISE = "select * from jcqn_doc02_06 where user_id=?";
	
	private final String SQL_SET_UPDATE_PROJECT = "update jcqn_doc02_01 set xuhao_id=?,user_id=?,entry_name=?,project_number=?,funds=?,start_stop_time=?,project_nature=?,role=? where id=?";
	private final String SQL_SET_UPDATE_PRIZE = "update jcqn_doc02_02 set xuhao_id=?,user_id=?,award_item_name=?,prize_name=?,grade=?,sort=?,reward_time=?,grant_institution=? where id=?";
	private final String SQL_SET_UPDATE_THESIS = "update jcqn_doc02_03 set xuhao_id=?,user_id=?,thesis_topic=?,author_sort=?,journal_title=?,year_volume_pagenumber=?,influence_factor=?,sci_times=? where id=?";
	private final String SQL_SET_UPDATE_PATENT = "update jcqn_doc02_04 set xuhao_id=?,user_id=?,patent_name=?,grant_number=?,inventor_sort=?,type=?,authorized_time=?,authorized_national=? where id=?";
	private final String SQL_SET_UPDATE_REPORT = "update jcqn_doc02_05 set xuhao_id=?,user_id=?,report_name=?,meeting_name=?,organizers=?,meeting_time=?,meeting_place=?,report_type=? where id=?";
	private final String SQL_SET_UPDATE_TREATISE = "update jcqn_doc02_06 set xuhao_id=?user_id=?,treatise_name=?,press=?,issuing_country=?,year=? where id=?";
	
	
	
	
	
	
	//查询是否已经有数据写入
//	private final String SQL_QUERY_EXISTED = "SELECT COUNT(id) from jcqn_doc01 where user_id = ?";
	
	private final String SQL_DEL_BY_USERID = "delete from jcqn_doc02_01 where user_id = ?";
		//插入数据
	public boolean insert( JcqnDocProject jcqnDocProject){
		
		return jdbcTemplate.update(
				SQL_INSERT_PROJECT,
				new Object[]{
						jcqnDocProject.getUserId(),
					    jcqnDocProject.getEntryName(),
					    jcqnDocProject.getFunds(),
					    jcqnDocProject.getProjectNature(),
					    jcqnDocProject.getProjectNumber(),
					    jcqnDocProject.getRole(),
					    jcqnDocProject.getStartStopTime()
					}) == 1;
	}
	
	
	public boolean update(JcqnDocProject jcqnDocProject){
		
		Object[] params = new Object[] {
				jcqnDocProject.getUserId(),
			    jcqnDocProject.getEntryName(),
			    jcqnDocProject.getFunds(),
			    jcqnDocProject.getProjectNature(),
			    jcqnDocProject.getProjectNumber(),
			    jcqnDocProject.getRole(),
			    jcqnDocProject.getStartStopTime()
				
		};
		return jdbcTemplate.update(SQL_SET_UPDATE_PROJECT,params) == 1;
	} 
	
	public boolean update(JcqnDocPrize jcqnDocPrize){
		
		Object[] params = new Object[] {
				jcqnDocPrize.getUserId(),
				jcqnDocPrize.getAwardItemName(),
				jcqnDocPrize.getGrade(),
				jcqnDocPrize.getGrantInstitution(),
				jcqnDocPrize.getPrizeName(),
				jcqnDocPrize.getRewardTime(),
				jcqnDocPrize.getSort(),
//				
		};
		return jdbcTemplate.update(SQL_SET_UPDATE_PRIZE,params) == 1;
	}
	
	public boolean update(JcqnDocThesis jcqnDocThesis){
		
		Object[] params = new Object[] {
				jcqnDocThesis.getUserId(),
			    jcqnDocThesis.getAuthorSort(),
			    jcqnDocThesis.getInfluenceFactor(),
			    jcqnDocThesis.getJournalTitle(),
			    jcqnDocThesis.getSciTimes(),
			    jcqnDocThesis.getThesisTopic(),
			    jcqnDocThesis.getYearVolumePagenumber(),
				
		};
		return jdbcTemplate.update(SQL_SET_UPDATE_THESIS,params) == 1;
	}
	

	public boolean update(JcqnDocPatent jcqnDocPatent){
		
		Object[] params = new Object[] {
				jcqnDocPatent.getUserId(),
				jcqnDocPatent.getAuthorizedNational(),
				jcqnDocPatent.getAuthorizedTime(),
				jcqnDocPatent.getGrantNumber(),
				jcqnDocPatent.getInventorSort(),
				jcqnDocPatent.getPatentName(),
				jcqnDocPatent.getType(),
				
		};
		return jdbcTemplate.update(SQL_SET_UPDATE_PATENT,params) == 1;
	}
	
	
public boolean update(JcqnDocReport jcqnDocReport){
		
		Object[] params = new Object[] {
				jcqnDocReport.getUserId(),
				jcqnDocReport.getMeetingName(),
				jcqnDocReport.getMeetingPlace(),
				jcqnDocReport.getMeetingTime(),
				jcqnDocReport.getOrganizers(),
				jcqnDocReport.getReportName(),
				jcqnDocReport.getReportType(),
				
		};
		return jdbcTemplate.update(SQL_SET_UPDATE_REPORT,params) == 1;
	}
	
public boolean update(JcqnDocTreatise jcqnDocTreatise){
	
	Object[] params = new Object[] {
			jcqnDocTreatise.getUserId(),
			jcqnDocTreatise.getIssuingCountry(),
			jcqnDocTreatise.getPress(),
			jcqnDocTreatise.getTreatiseName(),
			jcqnDocTreatise.getYear(),
		
			
	};
	return jdbcTemplate.update(SQL_SET_UPDATE_TREATISE,params) == 1;
}
	
	
	public boolean delete( int user_id )
	{
		 return jdbcTemplate.update( SQL_DEL_BY_USERID, new Object[]{user_id} )==1;
	}
	//根据USERID查询
	public List<Object> getByUserIdProject( int user_id,final List<Object> list)
	{
		return jdbcTemplate.query( SQL_Get_BY_USERID_PROJECT, new Object[]{ user_id},
				new ResultSetExtractor<List<Object>>()
				{
			@Override
			public List<Object> extractData( ResultSet rs )
					throws SQLException, DataAccessException
					{
				int i=0;
				while( rs.next() )
				{   
					JcqnDocProject jDocProject = new JcqnDocProject();
					jDocProject.setId(rs.getLong("id"));
					jDocProject.setUserId(rs.getLong("user_id"));
					jDocProject.setEntryName(rs.getString("entry_name"));
					jDocProject.setFunds(rs.getString("funds"));
					jDocProject.setProjectNature(rs.getString("project_nature"));
					jDocProject.setProjectNumber(rs.getString("project_number"));
					jDocProject.setRole(rs.getString("role"));
					jDocProject.setStartStopTime(rs.getString("start_stop_time"));
					list.add(jDocProject);
				}
				System.err.println("tiaoshu"+i);
				return list;
					}
				} );
	}
	
	public List<Object> getByUserIdPrize( int user_id ,final List<Object> list)
	{
		return jdbcTemplate.query( SQL_Get_BY_USERID_PRIZE, new Object[]{ user_id},
				new ResultSetExtractor<List<Object>>()
				{
			@Override
			public List<Object> extractData( ResultSet rs )
					throws SQLException, DataAccessException
					{
				int i=0;
				
				while( rs.next() )
				{   
					JcqnDocPrize jcqnDocPrize = new JcqnDocPrize();
					jcqnDocPrize.setId(rs.getLong("id"));
					jcqnDocPrize.setUserId(rs.getLong("user_id"));
					jcqnDocPrize.setAwardItemName(rs.getString("award_item_name"));
					jcqnDocPrize.setGrade(rs.getString("grade"));
					jcqnDocPrize.setGrantInstitution(rs.getString("grant_institution"));
					jcqnDocPrize.setPrizeName(rs.getString("prize_name"));
					jcqnDocPrize.setRewardTime(rs.getString("reward_time"));
					jcqnDocPrize.setSort(rs.getString("sort"));
					list.add(jcqnDocPrize);
				}
				System.err.println("tiaoshu"+i);
				return list;
					}
				} );
	}
	
	public List<Object> getByUserIdThesis( int user_id,final List<Object> list )
	{
		return jdbcTemplate.query( SQL_Get_BY_USERID_THESIS, new Object[]{ user_id},
				new ResultSetExtractor<List<Object>>()
				{
			@Override
			public List<Object> extractData( ResultSet rs )
					throws SQLException, DataAccessException
					{
				int i=0;
			
				while( rs.next() )
				{   
					JcqnDocThesis jcqnDocThesis = new JcqnDocThesis();
					jcqnDocThesis.setId(rs.getLong("id"));
					jcqnDocThesis.setUserId(rs.getLong("user_id"));
					jcqnDocThesis.setAuthorSort(rs.getString("author_sort"));
					jcqnDocThesis.setInfluenceFactor(rs.getString("influence_factor"));
					jcqnDocThesis.setJournalTitle(rs.getString("journal_title"));
					jcqnDocThesis.setSciTimes(rs.getString("sci_times"));
					jcqnDocThesis.setThesisTopic(rs.getString("thesis_topic"));
					jcqnDocThesis.setYearVolumePagenumber(rs.getString("year_volume_pagenumber"));
					list.add(jcqnDocThesis);
				}
				System.err.println("tiaoshu"+i);
				return list;
					}
				} );
	}
	
	public List<Object> getByUserIdPatent( int user_id ,final List<Object> list)
	{
		return jdbcTemplate.query( SQL_Get_BY_USERID_PATENT, new Object[]{ user_id},
				new ResultSetExtractor<List<Object>>()
				{
			@Override
			public List<Object> extractData( ResultSet rs )
					throws SQLException, DataAccessException
					{
				int i=0;
				while( rs.next() )
				{   
					JcqnDocPatent jcqnDocPatent = new JcqnDocPatent();
					jcqnDocPatent.setId(rs.getLong("id"));
					jcqnDocPatent.setUserId(rs.getLong("user_id"));
					jcqnDocPatent.setAuthorizedNational(rs.getString("authorized_national"));
					jcqnDocPatent.setAuthorizedTime(rs.getString("authorized_time"));
					jcqnDocPatent.setGrantNumber(rs.getString("grant_number"));
					jcqnDocPatent.setInventorSort(rs.getString("inventor_sort"));
					jcqnDocPatent.setPatentName(rs.getString("patent_name"));
					jcqnDocPatent.setType(rs.getString("type"));
					list.add(jcqnDocPatent);
				}
				System.err.println("tiaoshu"+i);
				return list;
					}
				} );
	}
	
	
	public List<Object> getByUserIdReport( int user_id,final List<Object> list )
	{
		return jdbcTemplate.query( SQL_Get_BY_USERID_REPORT, new Object[]{ user_id},
				new ResultSetExtractor<List<Object>>()
				{
			@Override
			public List<Object> extractData( ResultSet rs )
					throws SQLException, DataAccessException
					{
				int i=0;
				while( rs.next() )
				{   
					JcqnDocReport jcqnDocReport = new JcqnDocReport();
					jcqnDocReport.setId(rs.getLong("id"));
					jcqnDocReport.setUserId(rs.getLong("user_id"));
					jcqnDocReport.setMeetingName(rs.getString("meeting_name"));
					jcqnDocReport.setMeetingPlace(rs.getString("meeting_place"));
					jcqnDocReport.setMeetingTime(rs.getString("meeting_time"));
					jcqnDocReport.setOrganizers(rs.getString("organizers"));
					jcqnDocReport.setReportName(rs.getString("report_name"));
					jcqnDocReport.setReportType(rs.getString("report_type"));
					list.add(jcqnDocReport);
				}
				System.err.println("tiaoshu"+i);
				return list;
					}
				} );
	}
	
	
	public List<Object> getByUserIdTreatise( int user_id ,final List<Object> list)
	{
		return jdbcTemplate.query( SQL_Get_BY_USERID_TREATISE, new Object[]{ user_id},
				new ResultSetExtractor<List<Object>>()
				{
			@Override
			public List<Object> extractData( ResultSet rs )
					throws SQLException, DataAccessException
					{
				int i=0;
			
				while( rs.next() )
				{   
					JcqnDocTreatise jcqnDocTreatise = new JcqnDocTreatise();
					jcqnDocTreatise.setId(rs.getLong("id"));
					jcqnDocTreatise.setUserId(rs.getLong("user_id"));
					jcqnDocTreatise.setIssuingCountry(rs.getString("issuing_country"));
					jcqnDocTreatise.setPress(rs.getString("press"));
					jcqnDocTreatise.setTreatiseName(rs.getString("treatise_name"));
					jcqnDocTreatise.setYear(rs.getString("year"));
					
					list.add(jcqnDocTreatise);
				}
				System.err.println("tiaoshu"+i);
				return list;
					}
				} );
	}
/*	public JcqnDoc01 getById( int id )
	{
		return jdbcTemplate.query( SQL_Get_BY_ID, new Object[]{id},
				new ResultSetExtractor<JcqnDoc01>()
				{
			@Override
			public JcqnDoc01 extractData( ResultSet rs )
					throws SQLException, DataAccessException
					{
				JcqnDoc01 jcqndoc01 = new JcqnDoc01(); 
				if( rs.next() )
				{
					jcqndoc01.setId(rs.getInt("id"));
					jcqndoc01.setUser_id(rs.getInt("user_id"));
					jcqndoc01.setName(rs.getString("name"));
					jcqndoc01.setMinzu(rs.getString("minzu"));
					jcqndoc01.setBirthday(rs.getDate("birthday"));
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
					jcqndoc01.setStudy_start_time(rs.getDate("study_start_time"));
					jcqndoc01.setStudy_end_time(rs.getDate("study_end_time"));
					jcqndoc01.setWork_country(rs.getString("work_country"));
					jcqndoc01.setWork_company(rs.getString("work_company"));
					jcqndoc01.setWork_position(rs.getString("work_position"));
					jcqndoc01.setWork_start_time(rs.getDate("work_start_time"));
					jcqndoc01.setWork_end_time(rs.getDate("work_end_time"));
					jcqndoc01.setJournal_title(rs.getString("journal_title"));
					jcqndoc01.setOrganization_position(rs.getString("organization_position"));
					jcqndoc01.setOrganization_term(rs.getString("organization_term"));
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
				} );
	}*/
	/**
	 * 定义内部类实现RowMapper接口
	 */
	public class jcqndocprojectRowMapper implements ParameterizedRowMapper<JcqnDocProject>

	{
		// 实现mapRow方法
		@Override
		public JcqnDocProject mapRow( ResultSet rs, int num ) throws SQLException
		{
			// 对类进行封装
			JcqnDocProject jDocProject = new JcqnDocProject();
			jDocProject.setId(rs.getLong("id"));
			jDocProject.setUserId(rs.getLong("user_id"));
			jDocProject.setEntryName(rs.getString("entryName"));
			jDocProject.setFunds(rs.getString("funds"));
			jDocProject.setProjectNature(rs.getString("projectNature"));
			jDocProject.setProjectNumber(rs.getString("projectNumber"));
			jDocProject.setRole(rs.getString("role"));
			jDocProject.setStartStopTime(rs.getString("startStopTime"));
			return jDocProject;
		}
	}
	

}
