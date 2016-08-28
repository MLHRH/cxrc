package com.jfn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;


import com.jfn.entity.JcqnDoc05;
@Repository
public class JcqnDoc05Dao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private final String SQL_Get_BY_USERID = "select * from jcqn_doc05 where user_id=?";
	private final String SQL_INSERT = "insert into jcqn_doc05(user_id,needsRelevanceSupport) values(?,?)";
	private final String SQL_SET_UPDATE = "update jcqn_doc05 set needsRelevanceSupport=? where user_id=?";
	
	
	public boolean insert(JcqnDoc05 jcqndoc05) {
		return jdbcTemplate.update(SQL_INSERT,
				new Object[] { jcqndoc05.getUser_id(),jcqndoc05.getNeedsRelevanceSupport()}) == 1;
	}
	
	public JcqnDoc05 getByUserId( int user_id )
	{
		return jdbcTemplate.query( SQL_Get_BY_USERID, new Object[]{user_id},
				new ResultSetExtractor<JcqnDoc05>()
				{
			@Override
			public JcqnDoc05 extractData( ResultSet rs )
					throws SQLException, DataAccessException
					{
				JcqnDoc05 jcqndoc05 = new JcqnDoc05(); 
				if( rs.next() )
				{
					jcqndoc05.setId(rs.getInt("id"));
					jcqndoc05.setUser_id(rs.getInt("user_id"));
					jcqndoc05.setNeedsRelevanceSupport(rs.getString("needsRelevanceSupport"));
		
				}
				return jcqndoc05;
					}
				} );
	}
	
	public boolean update(JcqnDoc05 jcqndoc05){
		Object[] params = new Object[] {
			
//				jcqndoc03.getUser_id(),
				jcqndoc05.getNeedsRelevanceSupport(),
			     jcqndoc05.getUser_id()
				
		};
		return jdbcTemplate.update(SQL_SET_UPDATE,params) == 1;
		
		
	}
}
