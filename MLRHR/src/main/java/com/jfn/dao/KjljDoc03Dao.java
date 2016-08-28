package com.jfn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.jfn.entity.KjljDoc03;
@Repository
public class KjljDoc03Dao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private final String SQL_Get_BY_USERID = "select * from kjlj_doc03 where user_id=?";
	private final String SQL_INSERT = "insert into kjlj_doc03(user_id,selfAssessment) values(?,?)";
	private final String SQL_SET_UPDATE = "update kjlj_doc03 set selfAssessment=? where user_id=?";
	
	
	public boolean insert(KjljDoc03 kjljDoc03) {
		return jdbcTemplate.update(SQL_INSERT,
				new Object[] { kjljDoc03.getUser_id(),kjljDoc03.getSelfAssessment() }) == 1;
	}
	
	public KjljDoc03 getByUserId( int user_id )
	{
		return jdbcTemplate.query( SQL_Get_BY_USERID, new Object[]{user_id},
				new ResultSetExtractor<KjljDoc03>()
				{
			@Override
			public KjljDoc03 extractData( ResultSet rs )
					throws SQLException, DataAccessException
					{
				KjljDoc03 kjljDoc03 = new KjljDoc03(); 
				if( rs.next() )
				{
					kjljDoc03.setId(rs.getInt("id"));
					kjljDoc03.setUser_id(rs.getInt("user_id"));
					kjljDoc03.setSelfAssessment(rs.getString("selfAssessment"));
		
				}
				return kjljDoc03;
					}
				} );
	}
	
	public boolean update(KjljDoc03 kjljDoc03){
		Object[] params = new Object[] {
			
//				kjljDoc03.getUser_id(),
				kjljDoc03.getSelfAssessment(),
			     kjljDoc03.getUser_id()
				
		};
		return jdbcTemplate.update(SQL_SET_UPDATE,params) == 1;
		
		
	}
}
