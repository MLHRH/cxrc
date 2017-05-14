package com.jfn.dao;

import com.jfn.vo.PersonFirstTrial;
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
            " AND a.group_id = ? AND (a.apply_date BETWEEN ? and ? ) GROUP BY a.Id ORDER BY avg_score DESC";
    private static final String SELECT_KJLJ_SCORE="";
    private static final String SELECT_TEAM_SCORE="";
    private static final String SELECT_JCQN_VOTE="";
    private static final String SELECT_KJLJ_VOTE="";
    private static final String SELECT_TEAM_VOTE="";

    public List<PersonFirstTrial> getPersonFirstTrialScore(String applyType, Integer groupId, Date starttime,Date endtime){
        Object [] params = new Object[]{applyType,groupId,starttime,endtime};
        return jdbcTemplate.query(SELECT_JCQN_SCORE,params,new psersonFirstTrialRowMapper());
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

}
