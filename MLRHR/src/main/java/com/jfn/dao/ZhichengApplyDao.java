package com.jfn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.lang.model.type.PrimitiveType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSON;
import com.jfn.dao.GroupDao.expertGroupRowMapper;
import com.jfn.dao.NewsDao.newsRowMapper;
import com.jfn.entity.AcctUserRole;
import com.jfn.entity.ExpertGroup;
import com.jfn.entity.ExpertScore;
import com.jfn.entity.ExpertUser;
import com.jfn.entity.ExpertVote;
import com.jfn.entity.JcqnDoc04;
import com.jfn.entity.ZhichengApply;

@Repository
public class ZhichengApplyDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String SQL_INSERT_Apply = "insert into apply(user_id,group_id,apply_date,apply_type,status,pre_approve_date,pre_approve_id,pre_approve_sug,finial_approve_date,finial_approve_id,finial_approve_sug,expert1_date,expert1_id,expert1_score,expert1_sug,expert2_date,expert2_id,expert2_score,expert2_sug) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	private final String SQL_Get_BY_ID = "select * from apply where Id=?";
	private final String SQL_GET_Apply_LIST = "select * from apply order by apply_date desc ";

	private final String SQL_GET_Apply_LIST_By_UserID = "select * from apply where user_id=? order by apply_date desc ";
	private final String SQL_GET_Apply_LIST_By_UserIDAndDate = "select * from apply where user_id=? and ( apply_date between ? and ?)  order by apply_date desc ";

	private final String SQL_SET_Apply_UPDATE = "update apply set user_id=?,group_id=?,apply_date = ?,apply_type = ?,status = ?,pre_approve_date = ?,pre_approve_id = ?,pre_approve_sug = ?,finial_approve_date=?,finial_approve_id = ?,finial_approve_sug = ?,expert1_date = ?,expert1_id=?,expert1_score = ?,expert1_sug = ?,expert2_date = ?,expert2_id = ?,expert2_score = ?,expert2_sug = ? where id=?";

	private final static String SQL_DEL_BY_ID = "delete from apply where id = ?";
	
	private final String SQL_GET_Apply_LIST_By_GroupID = "select * from apply where group_id=? order by apply_date desc ";
	
	private final String SQL_Get_BY_USERID = "select * from expert_user where user_id=?";
	
	private final String SQL_GetROLE_BY_USERID = "select * from acct_user_role where user_id=?";
	
	private final String SQL_GET_EXPERT_SCORE ="SELECT es.expert_score AS score ,au.`name` FROM expert_score es LEFT JOIN acct_user au ON au.id = es.expert_id where es.apply_id =?";
	
	private final String SQL_GET_EXPERT_VOTE = "SELECT es.expert_vote AS expert_vote ,au.`name` FROM expert_vote es LEFT JOIN acct_user au ON au.id = es.expert_id WHERE es.apply_id =?";
	
	private final String SQL_INSERT_VOTE = "insert into expert_vote(expert_id,apply_id,expert_vote) values(?,?,?)";
	
	private final String SQL_SET_UPDATE_VOTE = "update expert_vote set expert_vote=? where expert_id=? and apply_id=?";
	
	private final String SQL_GetVOTE_BY_USERID = "select * from expert_vote where expert_id=? and apply_id=?";
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public boolean insert(ZhichengApply Apply) {
		Object[] params = new Object[]{Apply.getUser_id(),Apply.getGroup_id(),sdf.format(new Date()),Apply.getApply_type(), 
				Apply.getStatus(),Apply.getPre_approve_date(),  Apply.getPre_approve_id(),Apply.getPre_approve_sug(),Apply.getFinial_approve_date(), Apply.getFinial_approve_id(),
				Apply.getFinial_approve_sug(),Apply.getExpert1_date(),Apply.getExpert1_id(),Apply.getExpert1_score(),Apply.getExpert1_sug(),Apply.getExpert2_date(),Apply.getExpert2_id(),Apply.getExpert2_score(),Apply.getExpert2_sug()};
		return jdbcTemplate.update(SQL_INSERT_Apply, params) == 1;
//		return jdbcTemplate.update(
//				SQL_INSERT_Apply,
//				new Object[] { Apply.getUser_id(),Apply.getApply_date(),Apply.getApply_type(), 
//						Apply.getStatus(),Apply.getPre_approve_date(),  Apply.getPre_approve_id(),Apply.getPre_approve_sug(),Apply.getFinial_approve_date(), Apply.getFinial_approve_id(),
//						Apply.getFinial_approve_sug(),Apply.getExpert1_date(),Apply.getExpert1_id(),Apply.getExpert1_score(),Apply.getExpert1_sug(),Apply.getExpert2_date(),Apply.getExpert2_id(),Apply.getExpert2_score(),Apply.getExpert2_sug() }) == 1;
	}

	public ZhichengApply get(int id) {
		return jdbcTemplate.query(SQL_Get_BY_ID, new Object[] { id }, new ResultSetExtractor<ZhichengApply>() {
			@Override
			public ZhichengApply extractData(ResultSet rs) throws SQLException, DataAccessException {
				ZhichengApply Apply = new ZhichengApply();
				if (rs.next()) {
					Apply.setId(rs.getInt("id"));
					Apply.setApply_type(rs.getString("apply_type"));
//					Apply.setApply_name(rs.getString("apply_name"));
					Apply.setUser_id(rs.getInt("user_id"));
                 Apply.setGroup_id(rs.getString("group_id"));
					// 下面是截取时间，例：2014-09-15 18:55:50.275 最后.275去掉。
					String apply_date = rs.getString("apply_date");
					String a[] = apply_date.split("\\.");

					String temp = a[0];
					if (temp != null&&temp!="") {
						String Year = temp.substring(0, 4);
						String Month = temp.substring(5, 7);
						String Day = temp.substring(8, 19);
						temp = Year + "-" + Month + "-" + Day;
					}

					Apply.setApply_date(temp);

					Apply.setStatus(rs.getString("status"));

					temp = rs.getString("pre_approve_date");
					if (temp != null&&temp!="") {
						String Year = temp.substring(0, 4);
						String Month = temp.substring(5, 7);
						String Day = temp.substring(8, 10);
						temp = Year + "-" + Month + "-" + Day;
					}
					Apply.setPre_approve_date(temp);
					Apply.setPre_approve_id(rs.getString("pre_approve_id"));

					Apply.setPre_approve_sug(rs.getString("pre_approve_sug"));

					temp = rs.getString("finial_approve_date");
					if (temp != null&&temp!="") {
						String Year = temp.substring(0, 4);
						String Month = temp.substring(5, 7);
						String Day = temp.substring(8, 10);
						temp = Year + "-" + Month + "-" + Day;
					}
					Apply.setFinial_approve_date(temp);
					Apply.setFinial_approve_id(rs.getString("finial_approve_id"));
					Apply.setFinial_approve_sug(rs.getString("finial_approve_sug"));
//					expert1_date,expert1_id,expert1_score,expert1_sug,expert2_date,expert2_id,expert2_score,expert2_sug
					temp = rs.getString("expert1_date");
					if (temp != null&&temp!="") {
						String Year = temp.substring(0, 4);
						String Month = temp.substring(5, 7);
						String Day = temp.substring(8, 10);
						temp = Year + "-" + Month + "-" + Day;
					}					
					Apply.setExpert1_date(temp);
					Apply.setExpert1_id(rs.getString("expert1_id"));
					Apply.setExpert1_score(rs.getString("expert1_score"));
					Apply.setExpert1_sug(rs.getString("expert1_sug"));
				
					temp = rs.getString("expert2_date");
					if (temp != null&&temp!="") {
						String Year = temp.substring(0, 4);
						String Month = temp.substring(5, 7);
						String Day = temp.substring(8, 10);
						temp = Year + "-" + Month + "-" + Day;
					}	
					
					Apply.setExpert2_date(temp);
					Apply.setExpert2_id(rs.getString("expert2_id"));
					Apply.setExpert2_score(rs.getString("expert2_score"));
					Apply.setExpert2_sug(rs.getString("expert2_sug"));
				}
				return Apply;
			}
		});
	}

	/**
	 * 修改保存
	 * 
	 * @param request
	 * @param model
	 * @return
	 */	
//	update apply set user_id=?,apply_date = ?,apply_type = ?,status = ?,pre_approve_date = ?,pre_approve_id = ?,pre_approve_sug = ?,finial_approve_date=?,finial_approve_id = ?,"
//			+ "finial_approve_sug = ?,expert1_date = ?,expert1_id = ?,expert1_score = ?,expert1_sug = ?,expert2_date = ?,expert2_id = ?,expert2_score = ?,expert2_sug = ? where id=?";

	public boolean Update(ZhichengApply Apply) {
//		sdf.format(new Date());
		Object[] params = new Object[] { Apply.getUser_id(),Apply.getGroup_id(),Apply.getApply_date(),Apply.getApply_type(), 
				Apply.getStatus(),Apply.getPre_approve_date(),  Apply.getPre_approve_id(),Apply.getPre_approve_sug(),Apply.getFinial_approve_date(), Apply.getFinial_approve_id(),
				Apply.getFinial_approve_sug(),Apply.getExpert1_date(),Apply.getExpert1_id(),Apply.getExpert1_score(),Apply.getExpert1_sug(),Apply.getExpert2_date(),Apply.getExpert2_id(),Apply.getExpert2_score(),Apply.getExpert2_sug(),Apply.getId() };
System.err.println(JSON.toJSON(Apply));
		return jdbcTemplate.update(SQL_SET_Apply_UPDATE, params) == 1;
	}

	public boolean delete(int id) {
		return jdbcTemplate.update(SQL_DEL_BY_ID, new Object[] { id }) == 1;
	}

	public List<ZhichengApply> getAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(SQL_GET_Apply_LIST, new ApplyRowMapper());
	}

	/**
	 * 定义内部类实现RowMapper接口
	 */
	public class ApplyRowMapper implements ParameterizedRowMapper<ZhichengApply> {
		// 实现mapRow方法
		@Override
		public ZhichengApply mapRow(ResultSet rs, int num) throws SQLException {
			// 对类进行封装
			ZhichengApply Apply = new ZhichengApply();
			Apply.setId(rs.getInt("id"));
			Apply.setApply_type(rs.getString("apply_type"));
//			Apply.setApply_name(rs.getString("apply_name"));
			Apply.setUser_id(rs.getInt("user_id"));
          Apply.setGroup_id(rs.getString("group_id"));
			// 下面是截取时间，例：2014-09-15 18:55:50.275 最后.275去掉。
			String apply_date = rs.getString("apply_date");
			String a[] = apply_date.split("\\.");
//			String a = apply_date;
			String temp = a[0];
			if (temp != null&&temp!="") {
				String Year = temp.substring(0, 4);
				String Month = temp.substring(5, 7);
				String Day = temp.substring(8, 19);
				temp = Year + "-" + Month + "-" + Day;
			}

			Apply.setApply_date(temp);

			Apply.setStatus(rs.getString("status"));

			temp = rs.getString("pre_approve_date");
			if (temp != null&&temp!="") {
				String Year = temp.substring(0, 4);
				String Month = temp.substring(5, 7);
				String Day = temp.substring(8, 10);
				temp = Year + "-" + Month + "-" + Day;
			}
			Apply.setPre_approve_date(temp);
			Apply.setPre_approve_id(rs.getString("pre_approve_id"));

			Apply.setPre_approve_sug(rs.getString("pre_approve_sug"));

			temp = rs.getString("finial_approve_date");
			if (temp != null&&temp!="") {
				String Year = temp.substring(0, 4);
				String Month = temp.substring(5, 7);
				String Day = temp.substring(8, 10);
				temp = Year + "-" + Month + "-" + Day;
			}
			Apply.setFinial_approve_date(temp);
			Apply.setFinial_approve_id(rs.getString("finial_approve_id"));
			Apply.setFinial_approve_sug(rs.getString("finial_approve_sug"));
//			expert1_date,expert1_id,expert1_score,expert1_sug,expert2_date,expert2_id,expert2_score,expert2_sug
			temp = rs.getString("expert1_date");
			if (temp != null&&temp!="") {
				String Year = temp.substring(0, 4);
				String Month = temp.substring(5, 7);
				String Day = temp.substring(8, 10);
				temp = Year + "-" + Month + "-" + Day;
			}					
			Apply.setExpert1_date(temp);
			Apply.setExpert1_id(rs.getString("expert1_id"));
			Apply.setExpert1_score(rs.getString("expert1_score"));
			Apply.setExpert1_sug(rs.getString("expert1_sug"));
			
			temp = rs.getString("expert2_date");
			if (temp != null&&temp!="") {
				String Year = temp.substring(0, 4);
				String Month = temp.substring(5, 7);
				String Day = temp.substring(8, 10);
				temp = Year + "-" + Month + "-" + Day;
			}
			Apply.setExpert2_date(temp);
			Apply.setExpert2_id(rs.getString("expert2_id"));
			Apply.setExpert2_score(rs.getString("expert2_score"));
			Apply.setExpert2_sug(rs.getString("expert2_sug"));
			return Apply;
		}
	}

	public List<ZhichengApply> getAllByUserId(Integer userid) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(SQL_GET_Apply_LIST_By_UserID, new Object[] { userid }, new ApplyRowMapper());
	}

	public List<ZhichengApply> getUserByUserIdAndDate(Integer userid, String startDate, String endDate) {
		// TODO Auto-generated method stub
		if (startDate.equals("") && endDate.equals(""))
			return jdbcTemplate.query(SQL_GET_Apply_LIST_By_UserID, new Object[] { userid }, new ApplyRowMapper());
		else
			return jdbcTemplate.query(SQL_GET_Apply_LIST_By_UserIDAndDate, new Object[] { userid, startDate, endDate }, new ApplyRowMapper());
	}
	
	
	public List<ZhichengApply> getAllByGroupId(Integer groupId) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(SQL_GET_Apply_LIST_By_GroupID, new Object[] { groupId }, new ApplyRowMapper());
	}
	
	
	public ExpertUser getByUserId( int user_id )
	{
		return jdbcTemplate.query( SQL_Get_BY_USERID, new Object[]{user_id},
				new ResultSetExtractor<ExpertUser>()
				{
			@Override
			public ExpertUser extractData( ResultSet rs )
					throws SQLException, DataAccessException
					{
				ExpertUser expertUser = new ExpertUser(); 
				if( rs.next() )
				{
					expertUser.setId(rs.getInt("id"));
					expertUser.setUser_id(rs.getInt("user_id"));
					expertUser.setGroup_id(rs.getInt("group_id"));
					expertUser.setTeam_leader_type(rs.getInt("team_leader_type"));
					expertUser.setGender(rs.getString("gender"));
					expertUser.setMinzu(rs.getString("minzu"));
					expertUser.setBirthday(rs.getString("birthday"));
					expertUser.setAddress(rs.getString("address"));
					expertUser.setZhicheng(rs.getString("zhicheng"));
					expertUser.setCongshizhuanye(rs.getString("congshizhuanye"));
					expertUser.setWithin_beijing(rs.getString("within_beijing"));
		
				}
				return expertUser;
					}
				} );
	}
	public AcctUserRole getRoleByUserId( int user_id )
	{
		return jdbcTemplate.query( SQL_GetROLE_BY_USERID, new Object[]{user_id},
				new ResultSetExtractor<AcctUserRole>()
				{
			@Override
			public AcctUserRole extractData( ResultSet rs )
					throws SQLException, DataAccessException
					{
				AcctUserRole expertUser = new AcctUserRole(); 
				if( rs.next() )
				{
					expertUser.setId(rs.getInt("id"));
					expertUser.setUser_id(rs.getInt("user_id"));
			expertUser.setRole_id(rs.getInt("role_id"));
		
				}
				return expertUser;
					}
				} );
	}
	
	
	/**
	 * 查找专家的打分情况
	 * @param id
	 * @param role
	 * @return
	 */
	public List<ExpertScore> getExpertScore(Integer id){
//		Object [] params = new Object[]{id};
		return jdbcTemplate.query(SQL_GET_EXPERT_SCORE, 
				new Object[] { id }, 
				new ExpertScoreRowMapper());
	}
	public class ExpertScoreRowMapper implements ParameterizedRowMapper<ExpertScore>
	{
		// 实现mapRow方法
		@Override
		public ExpertScore mapRow( ResultSet rs, int num ) throws SQLException
		{
			// 对类进行封装
			ExpertScore group = new ExpertScore();
			group.setExpert_score(rs.getString("score"));
			group.setName(rs.getString("name"));
			return group;
		}
	}
	
	public List<ExpertVote> getExpertVote(Integer id){
//		Object [] params = new Object[]{id};
		return jdbcTemplate.query(SQL_GET_EXPERT_VOTE, 
				new Object[] { id }, 
				new ExpertVoteRowMapper());
	}
	
	public class ExpertVoteRowMapper implements ParameterizedRowMapper<ExpertVote>
	{
		// 实现mapRow方法
		@Override
		public ExpertVote mapRow( ResultSet rs, int num ) throws SQLException
		{
			// 对类进行封装
			ExpertVote group = new ExpertVote();
			group.setExpert_vote(rs.getString("expert_vote"));
			group.setName(rs.getString("name"));
			return group;
		}
	}
	
	public boolean insertVote(ExpertVote expertvote) {
		return jdbcTemplate.update(SQL_INSERT_VOTE,
				new Object[] {expertvote.getExpert_id(),expertvote.getApply_id(),expertvote.getExpert_vote()}) == 1;
	}
	public boolean updateVote(ExpertVote expertScore){
		Object[] params = new Object[] {	
				 expertScore.getExpert_vote(),
			     expertScore.getExpert_id(),
			     expertScore.getApply_id()
			    		     
				
		};
		return jdbcTemplate.update(SQL_SET_UPDATE_VOTE,params) == 1;
		
		
	}
	
	public ExpertVote getByExpertId( int expert_id ,int apply_id )
	{
		return jdbcTemplate.query( SQL_GetVOTE_BY_USERID, new Object[]{expert_id,apply_id},
				new ResultSetExtractor<ExpertVote>()
				{
			@Override
			public ExpertVote extractData( ResultSet rs )
					throws SQLException, DataAccessException
					{
				ExpertVote expertScore = new ExpertVote(); 
				if( rs.next() )
				{
					expertScore.setId(rs.getInt("id"));
					expertScore.setExpert_id(rs.getInt("expert_id"));				
					expertScore.setApply_id(rs.getInt("apply_id"));
					expertScore.setExpert_vote(rs.getString("expert_vote"));
		
				}
				return expertScore;
					}
				} );
	}
}
