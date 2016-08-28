package com.jfn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.jfn.entity.KjljDoc05;
@Repository
public class KjljDoc05Dao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private final String SQL_Get_BY_USERID = "select * from kjlj_doc05 where user_id=?";
	private final String SQL_INSERT = "insert into kjlj_doc05(user_id,needsRelevanceSupport) values(?,?)";
	private final String SQL_SET_UPDATE = "update kjlj_doc05 set needsRelevanceSupport=? where user_id=?";
	
	
	public boolean insert(KjljDoc05 kjljDoc05) {
		return jdbcTemplate.update(SQL_INSERT,
				new Object[] { kjljDoc05.getUser_id(),kjljDoc05.getNeedsRelevanceSupport()}) == 1;
	}
	
	public KjljDoc05 getByUserId( int user_id )
	{
		return jdbcTemplate.query( SQL_Get_BY_USERID, new Object[]{user_id},
				new ResultSetExtractor<KjljDoc05>()
				{
			@Override
			public KjljDoc05 extractData( ResultSet rs )
					throws SQLException, DataAccessException
					{
				KjljDoc05 kjljDoc05 = new KjljDoc05(); 
				if( rs.next() )
				{
					kjljDoc05.setId(rs.getInt("id"));
					kjljDoc05.setUser_id(rs.getInt("user_id"));
					kjljDoc05.setNeedsRelevanceSupport(rs.getString("needsRelevanceSupport"));
		
				}
				return kjljDoc05;
					}
				} );
	}
	
	public boolean update(KjljDoc05 kjljDoc05){
		Object[] params = new Object[] {
			
//				jcqndoc03.getUser_id(),
				kjljDoc05.getNeedsRelevanceSupport(),
			     kjljDoc05.getUser_id()
				
		};
		return jdbcTemplate.update(SQL_SET_UPDATE,params) == 1;
		
		
	}
}
