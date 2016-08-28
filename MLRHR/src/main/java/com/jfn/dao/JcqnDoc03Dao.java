package com.jfn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.jfn.entity.JcqnDoc01;
import com.jfn.entity.JcqnDoc03;
import com.jfn.entity.UserPeixun;
@Repository
public class JcqnDoc03Dao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private final String SQL_Get_BY_USERID = "select * from jcqn_doc03 where user_id=?";
	private final String SQL_INSERT = "insert into jcqn_doc03(user_id,selfAssessment) values(?,?)";
	private final String SQL_SET_UPDATE = "update jcqn_doc03 set selfAssessment=? where user_id=?";
	
	
	public boolean insert(JcqnDoc03 jcqndoc03) {
		return jdbcTemplate.update(SQL_INSERT,
				new Object[] { jcqndoc03.getUser_id(),jcqndoc03.getSelfAssessment() }) == 1;
	}
	
	public JcqnDoc03 getByUserId( int user_id )
	{
		return jdbcTemplate.query( SQL_Get_BY_USERID, new Object[]{user_id},
				new ResultSetExtractor<JcqnDoc03>()
				{
			@Override
			public JcqnDoc03 extractData( ResultSet rs )
					throws SQLException, DataAccessException
					{
				JcqnDoc03 jcqndoc03 = new JcqnDoc03(); 
				if( rs.next() )
				{
					jcqndoc03.setId(rs.getInt("id"));
					jcqndoc03.setUser_id(rs.getInt("user_id"));
					jcqndoc03.setSelfAssessment(rs.getString("selfAssessment"));
		
				}
				return jcqndoc03;
					}
				} );
	}
	
	public boolean update(JcqnDoc03 jcqndoc03){
		Object[] params = new Object[] {
			
//				jcqndoc03.getUser_id(),
				jcqndoc03.getSelfAssessment(),
			     jcqndoc03.getUser_id()
				
		};
		return jdbcTemplate.update(SQL_SET_UPDATE,params) == 1;
		
		
	}
}
