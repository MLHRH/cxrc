package com.jfn.dao;

import com.jfn.vo.PersonFirstTrial;
import com.jfn.vo.PersonSecondTrial;
import com.jfn.vo.TeamFirstTrial;
import com.jfn.vo.TeamSecondTrial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Created by xubin on 2017/5/14
 */
@Repository
public class StatisticalResultDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static final String SELECT_JCQN_SCORE="SELECT a.Id,jd.`name`,jd.sex ,jd.birthday ,jd.title,jd.direction,b.`name` AS body," +
            "b.`name` AS recommand,SUM(es.expert_score)/COUNT(*) AS avg_score from apply a" +
            " LEFT JOIN jcqn_doc01 jd ON jd.user_id = a.user_id" +
            " LEFT JOIN acct_user ac ON ac.id = a.user_id" +
            " LEFT JOIN body b ON b.id =ac.body_id" +
            " LEFT JOIN expert_score es ON es.apply_id = a.id" +
            " WHERE a.apply_type =?" +
            " AND a.group_id = ? AND (a.apply_date BETWEEN ? and ? ) AND a.status < 4 GROUP BY a.Id ORDER BY avg_score DESC";
    private static final String SELECT_KJLJ_SCORE="SELECT a.Id,jd.`name`,jd.sex ,jd.birthday ,jd.title,jd.direction,b.`name` AS body," +
            "b.`name` AS recommand,SUM(es.expert_score)/COUNT(*) AS avg_score from apply a" +
            " LEFT JOIN kjlj_doc01 jd ON jd.user_id = a.user_id" +
            " LEFT JOIN acct_user ac ON ac.id = a.user_id" +
            " LEFT JOIN body b ON b.id =ac.body_id" +
            " LEFT JOIN expert_score es ON es.apply_id = a.id" +
            " WHERE a.apply_type =?" +
            " AND a.group_id = ? AND (a.apply_date BETWEEN ? and ? ) AND a.status < 4  GROUP BY a.Id ORDER BY avg_score DESC";
    private static final String SELECT_TEAM_SCORE="SELECT DISTINCT a.id,ebi.team_id,ebi.orther,ac.`name`AS leader_name,ebi.team_name,ebi.research_direction,ebi.project_name,ebi.project_type,b.`name` AS body_name ,"
    		+ "SUM(e.expert_score)/COUNT(e.id) AS avg_score FROM apply a LEFT JOIN acct_user ac ON ac.id = a.user_id "
    		+ "LEFT JOIN cxtd_base_info  ebi ON ebi.user_id = a.user_id LEFT JOIN body b ON b.id = ac.body_id "
    		+ "LEFT JOIN expert_score e ON e.apply_id = a.Id WHERE a.apply_type=?  AND a.group_id = ? AND (a.apply_date BETWEEN ? and ? ) AND a.status < 4  ORDER BY avg_score DESC";
    private static final String SELECT_JCQN_VOTE="SELECT a.Id,jd.`name`,jd.sex ,jd.birthday ,jd.title,jd.direction,b.`name` AS body," +
            "b.`name` AS recommand,SUM(es.expert_score)/COUNT(*) AS avg_score from apply a" +
            " LEFT JOIN jcqn_doc01 jd ON jd.user_id = a.user_id" +
            " LEFT JOIN acct_user ac ON ac.id = a.user_id" +
            " LEFT JOIN body b ON b.id =ac.body_id" +
            " LEFT JOIN expert_score es ON es.apply_id = a.id" +
            " WHERE a.apply_type =?" +
            " AND a.group_id = ? AND (a.apply_date BETWEEN ? and ? ) AND 3 < a.status < 8 GROUP BY a.Id ORDER BY avg_score DESC";
    private static final String SELECT_KJLJ_VOTE="SELECT a.Id,jd.`name`,jd.sex ,jd.birthday ,jd.title,jd.direction,b.`name` AS body," +
            "b.`name` AS recommand,SUM(es.expert_score)/COUNT(*) AS avg_score from apply a" +
            " LEFT JOIN kjlj_doc01 jd ON jd.user_id = a.user_id" +
            " LEFT JOIN acct_user ac ON ac.id = a.user_id" +
            " LEFT JOIN body b ON b.id =ac.body_id" +
            " LEFT JOIN expert_score es ON es.apply_id = a.id" +
            " WHERE a.apply_type =?" +
            " AND a.group_id = ? AND (a.apply_date BETWEEN ? and ? ) AND 3 < a.status < 8  GROUP BY a.Id ORDER BY avg_score DESC";
    private static final String SELECT_TEAM_VOTE="SELECT DISTINCT a.id,ebi.team_id,ebi.orther,ac.`name`AS leader_name,ebi.team_name,ebi.research_direction,ebi.project_name,ebi.project_type,b.`name` AS body_name ,"
    		+ "SUM(e.expert_score)/COUNT(e.id) AS avg_score FROM apply a LEFT JOIN acct_user ac ON ac.id = a.user_id "
    		+ "LEFT JOIN cxtd_base_info  ebi ON ebi.user_id = a.user_id LEFT JOIN body b ON b.id = ac.body_id "
    		+ "LEFT JOIN expert_score e ON e.apply_id = a.Id WHERE a.apply_type=?  AND a.group_id = ? AND (a.apply_date BETWEEN ? and ? ) AND 3 < a.status < 8  ORDER BY avg_score DESC";

    public List<PersonFirstTrial> getPersonFirstTrialScoreJcqn(String applyType, Integer groupId, Date starttime,Date endtime){
        Object [] params = new Object[]{applyType,groupId,starttime,endtime};
        return jdbcTemplate.query(SELECT_JCQN_SCORE,params,new psersonFirstTrialRowMapper());
    }
    public List<PersonFirstTrial> getPersonFirstTrialScoreKjlj(String applyType, Integer groupId, Date starttime,Date endtime){
        Object [] params = new Object[]{applyType,groupId,starttime,endtime};
        return jdbcTemplate.query(SELECT_KJLJ_SCORE,params,new psersonFirstTrialRowMapper());
    }
    public List<TeamFirstTrial> getPersonFirstTrialScoreCxtd(String applyType, Integer groupId, Date starttime,Date endtime){
        Object [] params = new Object[]{applyType,groupId,starttime,endtime};
        return jdbcTemplate.query(SELECT_TEAM_SCORE,params,new psersonFirstTeamRowMapper());
    }
    
    
    
    
    public List<PersonSecondTrial> getPersonSecondTrialVoteJcqn(String applyType, Integer groupId, Date starttime,Date endtime){
        Object [] params = new Object[]{applyType,groupId,starttime,endtime};
        return jdbcTemplate.query(SELECT_JCQN_VOTE,params,new psersonSecondrialRowMapper());
    }
    public List<PersonSecondTrial> getPersonSecondTrialVoteKjlj(String applyType, Integer groupId, Date starttime,Date endtime){
        Object [] params = new Object[]{applyType,groupId,starttime,endtime};
        return jdbcTemplate.query(SELECT_KJLJ_VOTE,params,new psersonSecondrialRowMapper());
    }
    public List<TeamSecondTrial> getPersonSecondTrialVoteCxtd(String applyType, Integer groupId, Date starttime,Date endtime){
        Object [] params = new Object[]{applyType,groupId,starttime,endtime};
        return jdbcTemplate.query(SELECT_TEAM_VOTE,params,new psersonSecondTeamRowMapper());
    }
    
    
    
    
    /**
     * 定义内部类实现RowMapper接口
     */
    public class psersonFirstTeamRowMapper implements ParameterizedRowMapper<TeamFirstTrial>
    {
        // 实现mapRow方法
        @Override
        public TeamFirstTrial mapRow(ResultSet rs, int num ) throws SQLException
        {
            // 对类进行封装
        	TeamFirstTrial teamFirstTrial = new TeamFirstTrial();
        	teamFirstTrial.setApplyId(rs.getString("id"));
        	teamFirstTrial.setOrther(rs.getString("orther"));
        	teamFirstTrial.setTeamId(rs.getString("team_id"));
        	teamFirstTrial.setTeamName(rs.getString("team_name"));
        	teamFirstTrial.setSearchDirection(rs.getString("research_direction"));
        	teamFirstTrial.setRelateProjectName(rs.getString("project_name"));
        	teamFirstTrial.setRelateProjectCategory(rs.getString("project_type"));
        	teamFirstTrial.setInstitution(rs.getString("body_name"));
        	teamFirstTrial.setTeamLeader(rs.getString("leader_name"));
        	teamFirstTrial.setScore(rs.getDouble("avg_score"));
 
            return teamFirstTrial;
        }
    }
    
    
    
    
    
    
    /**
     * 定义内部类实现RowMapper接口
     */
    public class psersonFirstTrialRowMapper implements ParameterizedRowMapper<PersonFirstTrial>
    {
        // 实现mapRow方法
        @Override
        public PersonFirstTrial mapRow(ResultSet rs, int num ) throws SQLException
        {
            // 对类进行封装
            PersonFirstTrial personFirstTrial = new PersonFirstTrial();
            personFirstTrial.setApplyId(rs.getString("Id"));
            personFirstTrial.setName(rs.getString("name"));
            personFirstTrial.setSex(rs.getString("sex"));
            personFirstTrial.setBirthday(rs.getString("birthday"));
            personFirstTrial.setTechnicalTitle(rs.getString("title"));
            personFirstTrial.setResearchDirection(rs.getString("direction"));
            personFirstTrial.setInstitution(rs.getString("body"));
            personFirstTrial.setRecommandInstitution(rs.getString("recommand"));
            personFirstTrial.setScore(rs.getDouble("avg_score"));

            return personFirstTrial;
        }
    }
    
    
    
    
    
    public class psersonSecondTeamRowMapper implements ParameterizedRowMapper<TeamSecondTrial>
    {
        // 实现mapRow方法
        @Override
        public TeamSecondTrial mapRow(ResultSet rs, int num ) throws SQLException
        {
            // 对类进行封装
        	TeamSecondTrial teamFirstTrial = new TeamSecondTrial();
        	teamFirstTrial.setApplyId(rs.getString("id"));
        	teamFirstTrial.setOrther(rs.getString("orther"));
        	teamFirstTrial.setTeamId(rs.getString("team_id"));
        	teamFirstTrial.setTeamName(rs.getString("team_name"));
        	teamFirstTrial.setSearchDirection(rs.getString("research_direction"));
        	teamFirstTrial.setRelateProjectName(rs.getString("project_name"));
        	teamFirstTrial.setRelateProjectCategory(rs.getString("project_type"));
        	teamFirstTrial.setInstitution(rs.getString("body_name"));
        	teamFirstTrial.setTeamLeader(rs.getString("leader_name")); 
            return teamFirstTrial;
        }
    }
    
    
    
    
    
    
    /**
     * 定义内部类实现RowMapper接口
     */
    public class psersonSecondrialRowMapper implements ParameterizedRowMapper<PersonSecondTrial>
    {
        // 实现mapRow方法
        @Override
        public PersonSecondTrial mapRow(ResultSet rs, int num ) throws SQLException
        {
            // 对类进行封装
        	PersonSecondTrial personFirstTrial = new PersonSecondTrial();
            personFirstTrial.setApplyId(rs.getString("Id"));
            personFirstTrial.setName(rs.getString("name"));
            personFirstTrial.setSex(rs.getString("sex"));
            personFirstTrial.setBirthday(rs.getString("birthday"));
            personFirstTrial.setTechnicalTitle(rs.getString("title"));
            personFirstTrial.setResearchDirection(rs.getString("direction"));
            personFirstTrial.setInstitution(rs.getString("body"));
            personFirstTrial.setRecommandInstitution(rs.getString("recommand"));

            return personFirstTrial;
        }
    }

}
