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

import com.jfn.dao.ZhichengApplyDao.ExpertVoteRowMapper;
import com.jfn.entity.ExpertScore;
import com.jfn.entity.ExpertVote;
import com.jfn.entity.JcqnDoc05;
@Repository
public class JcqnDoc08Dao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private final String SQL_Get_BY_APPLYID = "SELECT es.expert_score AS expert_score,es.expert_score AS expert_score,es.expert_pingyu AS expert_pingyu,au.`name` FROM expert_score es LEFT JOIN acct_user au ON au.id = es.expert_id WHERE es.apply_id =?";

	public List<ExpertScore> getExpertscore(Integer id){
//		Object [] params = new Object[]{id};
		return jdbcTemplate.query(SQL_Get_BY_APPLYID, 
				new Object[] { id }, 
				new ExpertVoteRowMapper());
	}
	
	public class ExpertVoteRowMapper implements ParameterizedRowMapper<ExpertScore>
	{
		// 实现mapRow方法
		@Override
		public ExpertScore mapRow( ResultSet rs, int num ) throws SQLException
		{
			// 对类进行封装
			ExpertScore group = new ExpertScore();
			group.setExpert_score(rs.getString("expert_score"));
			group.setExpert_pingyu(rs.getString("expert_pingyu"));
			group.setName(rs.getString("name"));
			return group;
		}
	}

	
	
}
