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

import com.jfn.entity.KjljDocPatent;
import com.jfn.entity.KjljDocPrize;
import com.jfn.entity.KjljDocProject;
import com.jfn.entity.KjljDocReport;
import com.jfn.entity.KjljDocThesis;
import com.jfn.entity.KjljDocTreatise;
@Repository
public class KjljDoc02Dao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String SQL_INSERT_PROJECT = "insert into kjlj_doc02_01(xuhao_id,user_id,entry_name,project_number,funds,start_stop_time,project_nature,role) values(?,?,?,?,?,?,?,?)";
	private final String SQL_INSERT_PRIZE = "insert into kjlj_doc02_02(xuhao_id,user_id,award_item_name,prize_name,grade,sort,reward_time,grant_institution) values(?,?,?,?,?,?,?,?)";
	private final String SQL_INSERT_THESIS = "insert into kjlj_doc02_03(xuhao_id,user_id,thesis_topic,author_sort,journal_title,year_volume_pagenumber,influence_factor,sci_times) values(?,?,?,?,?,?,?,?)";
	private final String SQL_INSERT_PATENT = "insert into kjlj_doc02_04(xuhao_id,user_id,patent_name,grant_number,inventor_sort,type,authorized_time,authorized_national) values(?,?,?,?,?,?,?,?)";
	private final String SQL_INSERT_REPORT = "insert into kjlj_doc02_05(xuhao_id,user_id,report_name,meeting_name,organizers,meeting_time,meeting_place,report_type) values(?,?,?,?,?,?,?,?)";
	private final String SQL_INSERT_TREATISE = "insert into kjlj_doc02_06(xuhao_id,user_id,treatise_name,press,issuing_country,year) values(?,?,?,?,?,?)";

	private final String SQL_Get_BY_USERID_PROJECT = "select * from kjlj_doc02_01 where user_id=?";
	private final String SQL_Get_BY_USERID_PRIZE = "select * from kjlj_doc02_02 where user_id=?";
	private final String SQL_Get_BY_USERID_THESIS = "select * from kjlj_doc02_03 where user_id=?";
	private final String SQL_Get_BY_USERID_PATENT = "select * from kjlj_doc02_04 where user_id=?";
	private final String SQL_Get_BY_USERID_REPORT = "select * from kjlj_doc02_05 where user_id=?";
	private final String SQL_Get_BY_USERID_TREATISE = "select * from kjlj_doc02_06 where user_id=?";
	
	private final String SQL_SET_UPDATE_PROJECT = "update kjlj_doc02_01 set xuhao_id=?,user_id=?,entry_name=?,project_number=?,funds=?,start_stop_time=?,project_nature=?,role=? where id=?";
	private final String SQL_SET_UPDATE_PRIZE = "update kjlj_doc02_02 set xuhao_id=?,user_id=?,award_item_name=?,prize_name=?,grade=?,sort=?,reward_time=?,grant_institution=? where id=?";
	private final String SQL_SET_UPDATE_THESIS = "update kjlj_doc02_03 set xuhao_id=?,user_id=?,thesis_topic=?,author_sort=?,journal_title=?,year_volume_pagenumber=?,influence_factor=?,sci_times=? where id=?";
	private final String SQL_SET_UPDATE_PATENT = "update kjlj_doc02_04 set xuhao_id=?,user_id=?,patent_name=?,grant_number=?,inventor_sort=?,type=?,authorized_time=?,authorized_national=? where id=?";
	private final String SQL_SET_UPDATE_REPORT = "update kjlj_doc02_05 set xuhao_id=?,user_id=?,report_name=?,meeting_name=?,organizers=?,meeting_time=?,meeting_place=?,report_type=? where id=?";
	private final String SQL_SET_UPDATE_TREATISE = "update kjlj_doc02_06 set xuhao_id=?user_id=?,treatise_name=?,press=?,issuing_country=?,year=? where id=?";
	
	
	
	
	
	
	//查询是否已经有数据写入
//	private final String SQL_QUERY_EXISTED = "SELECT COUNT(id) from kjlj_doc01 where user_id = ?";
	
	private final String SQL_DEL_BY_USERID = "delete from kjlj_doc02_01 where user_id = ?";
		//插入数据
	public boolean insert( KjljDocProject kjljDocProject){
		
		return jdbcTemplate.update(
				SQL_INSERT_PROJECT,
				new Object[]{
						kjljDocProject.getUserId(),
					    kjljDocProject.getEntryName(),
					    kjljDocProject.getFunds(),
					    kjljDocProject.getProjectNature(),
					    kjljDocProject.getProjectNumber(),
					    kjljDocProject.getRole(),
					    kjljDocProject.getStartStopTime()
					}) == 1;
	}
	
	
	public boolean update(KjljDocProject kjljDocProject){
		
		Object[] params = new Object[] {
				kjljDocProject.getUserId(),
			    kjljDocProject.getEntryName(),
			    kjljDocProject.getFunds(),
			    kjljDocProject.getProjectNature(),
			    kjljDocProject.getProjectNumber(),
			    kjljDocProject.getRole(),
			    kjljDocProject.getStartStopTime()
				
		};
		return jdbcTemplate.update(SQL_SET_UPDATE_PROJECT,params) == 1;
	} 
	
	public boolean update(KjljDocPrize kjljDocPrize){
		
		Object[] params = new Object[] {
				kjljDocPrize.getUserId(),
				kjljDocPrize.getAwardItemName(),
				kjljDocPrize.getGrade(),
				kjljDocPrize.getGrantInstitution(),
				kjljDocPrize.getPrizeName(),
				kjljDocPrize.getRewardTime(),
				kjljDocPrize.getSort(),
//				
		};
		return jdbcTemplate.update(SQL_SET_UPDATE_PRIZE,params) == 1;
	}
	
	public boolean update(KjljDocThesis kjljDocThesis){
		
		Object[] params = new Object[] {
				kjljDocThesis.getUserId(),
			    kjljDocThesis.getAuthorSort(),
			    kjljDocThesis.getInfluenceFactor(),
			    kjljDocThesis.getJournalTitle(),
			    kjljDocThesis.getSciTimes(),
			    kjljDocThesis.getThesisTopic(),
			    kjljDocThesis.getYearVolumePagenumber(),
				
		};
		return jdbcTemplate.update(SQL_SET_UPDATE_THESIS,params) == 1;
	}
	

	public boolean update(KjljDocPatent kjljDocPatent){
		
		Object[] params = new Object[] {
				kjljDocPatent.getUserId(),
				kjljDocPatent.getAuthorizedNational(),
				kjljDocPatent.getAuthorizedTime(),
				kjljDocPatent.getGrantNumber(),
				kjljDocPatent.getInventorSort(),
				kjljDocPatent.getPatentName(),
				kjljDocPatent.getType(),
				
		};
		return jdbcTemplate.update(SQL_SET_UPDATE_PATENT,params) == 1;
	}
	
	
public boolean update(KjljDocReport kjljDocReport){
		
		Object[] params = new Object[] {
				kjljDocReport.getUserId(),
				kjljDocReport.getMeetingName(),
				kjljDocReport.getMeetingPlace(),
				kjljDocReport.getMeetingTime(),
				kjljDocReport.getOrganizers(),
				kjljDocReport.getReportName(),
				kjljDocReport.getReportType(),
				
		};
		return jdbcTemplate.update(SQL_SET_UPDATE_REPORT,params) == 1;
	}
	
public boolean update(KjljDocTreatise kjljDocTreatise){
	
	Object[] params = new Object[] {
			kjljDocTreatise.getUserId(),
			kjljDocTreatise.getIssuingCountry(),
			kjljDocTreatise.getPress(),
			kjljDocTreatise.getTreatiseName(),
			kjljDocTreatise.getYear(),
		
			
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
					KjljDocProject jDocProject = new KjljDocProject();
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
					KjljDocPrize kjljDocPrize = new KjljDocPrize();
					kjljDocPrize.setId(rs.getLong("id"));
					kjljDocPrize.setUserId(rs.getLong("user_id"));
					kjljDocPrize.setAwardItemName(rs.getString("award_item_name"));
					kjljDocPrize.setGrade(rs.getString("grade"));
					kjljDocPrize.setGrantInstitution(rs.getString("grant_institution"));
					kjljDocPrize.setPrizeName(rs.getString("prize_name"));
					kjljDocPrize.setRewardTime(rs.getString("reward_time"));
					kjljDocPrize.setSort(rs.getString("sort"));
					list.add(kjljDocPrize);
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
					KjljDocThesis kjljDocThesis = new KjljDocThesis	();
					kjljDocThesis.setId(rs.getLong("id"));
					kjljDocThesis.setUserId(rs.getLong("user_id"));
					kjljDocThesis.setAuthorSort(rs.getString("author_sort"));
					kjljDocThesis.setInfluenceFactor(rs.getString("influence_factor"));
					kjljDocThesis.setJournalTitle(rs.getString("journal_title"));
					kjljDocThesis.setSciTimes(rs.getString("sci_times"));
					kjljDocThesis.setThesisTopic(rs.getString("thesis_topic"));
					kjljDocThesis.setYearVolumePagenumber(rs.getString("year_volume_pagenumber"));
					list.add(kjljDocThesis);
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
					KjljDocPatent kjljDocPatent = new KjljDocPatent();
					kjljDocPatent.setId(rs.getLong("id"));
					kjljDocPatent.setUserId(rs.getLong("user_id"));
					kjljDocPatent.setAuthorizedNational(rs.getString("authorized_national"));
					kjljDocPatent.setAuthorizedTime(rs.getString("authorized_time"));
					kjljDocPatent.setGrantNumber(rs.getString("grant_number"));
					kjljDocPatent.setInventorSort(rs.getString("inventor_sort"));
					kjljDocPatent.setPatentName(rs.getString("patent_name"));
					kjljDocPatent.setType(rs.getString("type"));
					list.add(kjljDocPatent);
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
					KjljDocReport kjljDocReport = new KjljDocReport();
					kjljDocReport.setId(rs.getLong("id"));
					kjljDocReport.setUserId(rs.getLong("user_id"));
					kjljDocReport.setMeetingName(rs.getString("meeting_name"));
					kjljDocReport.setMeetingPlace(rs.getString("meeting_place"));
					kjljDocReport.setMeetingTime(rs.getString("meeting_time"));
					kjljDocReport.setOrganizers(rs.getString("organizers"));
					kjljDocReport.setReportName(rs.getString("report_name"));
					kjljDocReport.setReportType(rs.getString("report_type"));
					list.add(kjljDocReport);
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
					KjljDocTreatise kjljDocTreatise = new KjljDocTreatise();
					kjljDocTreatise.setId(rs.getLong("id"));
					kjljDocTreatise.setUserId(rs.getLong("user_id"));
					kjljDocTreatise.setIssuingCountry(rs.getString("issuing_country"));
					kjljDocTreatise.setPress(rs.getString("press"));
					kjljDocTreatise.setTreatiseName(rs.getString("treatise_name"));
					kjljDocTreatise.setYear(rs.getString("year"));
					
					list.add(kjljDocTreatise);
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
	public class kjljDocProjectRowMapper implements ParameterizedRowMapper<KjljDocProject>

	{
		// 实现mapRow方法
		@Override
		public KjljDocProject mapRow( ResultSet rs, int num ) throws SQLException
		{
			// 对类进行封装
			KjljDocProject jDocProject = new KjljDocProject();
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
