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

import com.jfn.entity.ApplyGroup;
import com.jfn.entity.ExpertGroup;
import com.jfn.entity.Group;

@Repository
public class GroupDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private final String SQL_GET_GROUP_LIST="select * from group_tree order by id";
	private final String SQL_INSERT_GROUP = "INSERT INTO group_tree (pId,name) values(?,?)";
	private final String SQL_UPDATE_GROUP = "UPDATE group_tree SET name = ? WHERE id = ? ";
	private final String SQL_DEL_GROUP= "DELETE FROM group_tree where id = ? ";
	private final String SQL_GET_APPLY_GROUP = "SELECT p.id,p.user_id,bo.`name` AS 'body',p.apply_date ,p.apply_type,u.`name` ,t.name AS 'group',ar.`name` AS role,jc.`direction` ,kj.direction AS 'kjdirection' ,cx.research_direction  from apply p"
			+" LEFT JOIN group_tree t on t.id = p.group_id"
			+" LEFT JOIN acct_user u ON u.id = p.user_id"
			+" LEFT JOIN acct_user_role r ON r.user_id = p.user_id"
			+" LEFT JOIN acct_role ar on ar.id = r.role_id"
			+" LEFT JOIN body bo on bo.id = u.body_id "
			+" LEFT JOIN jcqn_doc01 jc on jc.user_id = p.user_id"
			+" LEFT JOIN kjlj_doc01 kj on kj.user_id = p.user_id"
			+" LEFT JOIN cxtd_base_info cx on cx.user_id = p.user_id"
			+" WHERE group_id = ? and ar.id = ?";
	private final String SQL_GET_EXPERT_GROUP = "SELECT e.id,e.team_leader_type,e.zhicheng,e.congshizhuanye ,a.`name` ,b.`name` AS body FROM expert_user e"
			+" LEFT JOIN acct_user a on a.id = e.user_id"
			+" LEFT JOIN acct_user_role aur ON aur.user_id = a.id"
			+" LEFT JOIN acct_role ar ON ar.id = aur.role_id"
			+" LEFT JOIN body b ON b.id = a.body_id"
			+" WHERE e.group_id = ? AND ar.id= ?";
	private final String SQL_GET_APPLY_INFO = "SELECT u.id AS `user_id`,p.id,p.group_id,bo.`name` AS 'body',p.apply_date ,p.apply_type,u.`name` ,t.name AS 'group',ar.`name` AS role from apply p"
			+" LEFT JOIN group_tree t on t.id = p.group_id"
			+" LEFT JOIN acct_user u ON u.id = p.user_id"
			+" LEFT JOIN acct_user_role r ON r.user_id = p.user_id"
			+" LEFT JOIN acct_role ar on ar.id = r.role_id"
			+" LEFT JOIN body bo on bo.id = u.body_id "
			+" WHERE p.id = ?";
	private final String SQL_GET_EXPERT_INFO ="SELECT e.id,e.team_leader_type,e.zhicheng,e.congshizhuanye ,a.`name` ,b.`name` AS body,g.name AS `group` FROM expert_user e"
			+" LEFT JOIN group_tree g ON g.id = e.group_id"
			+" LEFT JOIN acct_user a on a.id = e.user_id"
			+" LEFT JOIN body b ON b.id = a.body_id"
			+" WHERE e.id = ?";
	
	private final String SQL_UPDATE_APPLY_GROUP = "update apply set group_id = ? where id = ? ";
	private final String SQL_UPDATE_EXPERT_GROUP = "update expert_user set group_id = ? ,team_leader_type = ? where id = ?";
	
	
	private final String SQL_Get_BY_GROUP = "select * from group_tree where id=?";
	/**
	 * 根据groupID获取对应分组信息
	 * @param id
	 * @return
	 */
	public List<ApplyGroup> getApplyGroupById(Integer id,Integer role){
		Object[] params=new Object[]{id,role};
		return jdbcTemplate.query(SQL_GET_APPLY_GROUP, params, new applyGroupRowMapper());
	}
	
	/**
	 * 查找专家的分组情况
	 * @param id
	 * @param role
	 * @return
	 */
	public List<ExpertGroup> getExpertGroup(Integer id,Integer role){
		Object [] params = new Object[]{id,role};
		return jdbcTemplate.query(SQL_GET_EXPERT_GROUP, params, new expertGroupRowMapper());
	}
	/**
	 * 获取分组列表
	 * @return
	 */
	public List<Group> getGroupTree(){
		return jdbcTemplate.query(SQL_GET_GROUP_LIST, new groupRowMapper());
	}
	/**
	 * 添加分组
	 * @param group
	 * @return
	 */
	public boolean addGroup(Group group){
		Object [] params = new Object[] {group.getpId(),group.getName()};
		return jdbcTemplate.update(SQL_INSERT_GROUP, params)==1;
	}
	/**
	 * 更新分组信息
	 * @param group
	 * @return
	 */
	public boolean updateGroup(Group group){
		Object [] params = new Object[]{group.getName(),group.getId()};
		return jdbcTemplate.update(SQL_UPDATE_GROUP, params)==1;
	}
	/**
	 * 删除分组节点
	 * @param group
	 * @return
	 */
	public boolean delGroup(Group group){
		Object [] params = new Object[]{group.getId()};
		return jdbcTemplate.update(SQL_DEL_GROUP, params) == 1;
	}
	
	/**
	 * 申请更新分组信息
	 * @param applyId
	 * @return
	 */
	public boolean updateApplyGroup(Integer groupId,Integer applyId){
		Object [] params = new Object[]{groupId,applyId};
		return jdbcTemplate.update(SQL_UPDATE_APPLY_GROUP, params) == 1;
	}
	
	/**
	 * 更新专家分组信息
	 * @param groupId
	 * @param level
	 * @param userId
	 * @return
	 */
	public boolean updateExpertGroup(Integer groupId,Integer level,Integer userId){
		Object [] params = new Object[]{groupId,level,userId};
		return jdbcTemplate.update(SQL_UPDATE_EXPERT_GROUP, params) == 1;
	}
	/**
	 * 根据applyID查询apply信息(分组)
	 * @param applyId
	 * @return
	 */
	public ApplyGroup getApplyGroupByApplyId(Integer applyId){
		Object [] params = new Object[]{applyId};
		return jdbcTemplate.query(SQL_GET_APPLY_INFO, params, new ResultSetExtractor<ApplyGroup>(){

			@Override
			public ApplyGroup extractData(ResultSet rs) throws SQLException, DataAccessException {
				ApplyGroup group  = null;
				if(rs.next()){
					group = new ApplyGroup();
					group.setUser_id(rs.getInt("user_id"));
					group.setName(rs.getString("name"));
					group.setGroup(rs.getString("group"));
					group.setApply_id(rs.getInt("id"));
					group.setBody(rs.getString("body"));
					group.setType(rs.getString("apply_type"));
					group.setDate(rs.getString("apply_date"));
					group.setRole(rs.getString("role"));
				}
				return group;
			}
			
		});
	}
	/**
	 * 根据expertID查询专家信息(分组)
	 * @param expertId
	 * @return
	 */
	public ExpertGroup getExpertGroupByExpertId(Integer expertId){
		Object [] params = new Object[]{expertId};
		return jdbcTemplate.query(SQL_GET_EXPERT_INFO, params, new ResultSetExtractor<ExpertGroup>(){

			@Override
			public ExpertGroup extractData(ResultSet rs) throws SQLException, DataAccessException {
				ExpertGroup group = null;
				if(rs.next()){
					group = new ExpertGroup();
					group.setName(rs.getString("name"));
					group.setBody(rs.getString("body"));
					group.setExpertId(rs.getInt("id"));
					group.setZhiCheng(rs.getString("zhicheng"));
					group.setCongShiFangXiang(rs.getString("congshizhuanye"));
					group.setLevel(rs.getInt("team_leader_type"));
					group.setGroup(rs.getString("group"));
				}
				return group;
			}
			
		});
	}
	/**
	 * 定义内部类实现RowMapper接口
	 */
	public class groupRowMapper implements ParameterizedRowMapper<Group>
	{
		// 实现mapRow方法
		@Override
		public Group mapRow( ResultSet rs, int num ) throws SQLException
		{
			// 对类进行封装
			Group group = new Group();
			group.setId(rs.getInt("id"));
			group.setName(rs.getString("name"));
			group.setpId(rs.getString("pId"));
			return group;
		}
	}
	/**
	 * 定义内部类实现RowMapper接口
	 */
	public class applyGroupRowMapper implements ParameterizedRowMapper<ApplyGroup>
	{
		// 实现mapRow方法
		@Override
		public ApplyGroup mapRow( ResultSet rs, int num ) throws SQLException
		{
			// 对类进行封装
			ApplyGroup group = new ApplyGroup();
			group.setUser_id(rs.getInt("user_id"));
			group.setName(rs.getString("name"));
			group.setGroup(rs.getString("group"));
			group.setApply_id(rs.getInt("id"));
			group.setBody(rs.getString("body"));
			group.setType(rs.getString("apply_type"));
			group.setDate(rs.getString("apply_date"));
			group.setRole(rs.getString("role"));
			if (rs.getString("apply_type").equals("杰出青年")) {
				group.setDirection(rs.getString("direction"));					
			}
			if (rs.getString("apply_type").equals("科技领军")) {
				group.setDirection(rs.getString("kjdirection"));					
			}
			if (rs.getString("apply_type").equals("创新团队")) {
				group.setDirection(rs.getString("research_direction"));					
			}
			return group;
		}
	}
	/**
	 * 定义内部类实现RowMapper接口
	 */
	public class expertGroupRowMapper implements ParameterizedRowMapper<ExpertGroup>
	{
		// 实现mapRow方法
		@Override
		public ExpertGroup mapRow( ResultSet rs, int num ) throws SQLException
		{
			// 对类进行封装
			ExpertGroup group = new ExpertGroup();
			group.setName(rs.getString("name"));
			group.setBody(rs.getString("body"));
			group.setExpertId(rs.getInt("id"));
			group.setZhiCheng(rs.getString("zhicheng"));
			group.setCongShiFangXiang(rs.getString("congshizhuanye"));
			group.setLevel(rs.getInt("team_leader_type"));
			return group;
		}
	}
	
	
	public Group getGroupTreebyId(Integer groupId )
	{
		return jdbcTemplate.query( SQL_Get_BY_GROUP, new Object[]{groupId},
				new ResultSetExtractor<Group>()
				{
			@Override
			public Group extractData( ResultSet rs )
					throws SQLException, DataAccessException
					{
				Group expertScore = new Group(); 
				if( rs.next() )
				{
					expertScore.setId(rs.getInt("id"));
					expertScore.setName(rs.getString("name"));
				 expertScore.setpId(rs.getString("PId"));
		
				}
				return expertScore;
					}
				} );
	}
	
}
