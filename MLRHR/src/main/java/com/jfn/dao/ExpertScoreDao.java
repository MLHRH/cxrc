package com.jfn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.jfn.entity.ExpertScore;
import com.jfn.entity.JcqnDoc03;
import com.jfn.entity.JcqnDoc04;
@Repository
public class ExpertScoreDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private final String SQL_Get_BY_USERID = "select * from expert_score where expert_id=?";
	private final String SQL_INSERT = "insert into expert_score(expert_id,user_id,expert_score,expert_pingyu) values(?,?,?,?)";
	private final String SQL_SET_UPDATE = "update expert_score set user_id=?,expert_score=?,expert_pingyu=? where expert_id=?";
	
	
	public boolean insert(ExpertScore expertScore) {
		return jdbcTemplate.update(SQL_INSERT,
				new Object[] {expertScore.getExpert_id(),expertScore.getUser_id(),expertScore.getExpert_score(),expertScore.getExpert_pingyu()}) == 1;
	}
	
	public ExpertScore getByExpertId( int expert_id )
	{
		return jdbcTemplate.query( SQL_Get_BY_USERID, new Object[]{expert_id},
				new ResultSetExtractor<ExpertScore>()
				{
			@Override
			public ExpertScore extractData( ResultSet rs )
					throws SQLException, DataAccessException
					{
				ExpertScore expertScore = new ExpertScore(); 
				if( rs.next() )
				{
					expertScore.setId(rs.getInt("id"));
					expertScore.setExpert_id(rs.getInt("expert_id"));
					expertScore.setUser_id(rs.getInt("user_id"));
					expertScore.setExpert_score(rs.getString("expert_score"));
					expertScore.setExpert_pingyu(rs.getString("expert_pingyu"));
		
				}
				return expertScore;
					}
				} );
	}
	
	public boolean update(ExpertScore expertScore){
		Object[] params = new Object[] {
			
                 expertScore.getExpert_id(),
                 expertScore.getUser_id(),
			     expertScore.getExpert_score(),
			     expertScore.getExpert_pingyu()
				
		};
		return jdbcTemplate.update(SQL_SET_UPDATE,params) == 1;
		
		
	}
}
