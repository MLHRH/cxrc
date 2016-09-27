package com.jfn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.jfn.entity.KjljDoc04;
@Repository
public class KjljDoc04Dao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private final String SQL_Get_BY_USERID = "select * from kjlj_doc04 where user_id=?";
	private final String SQL_INSERT = "insert into kjlj_doc04(user_id,futurePlans) values(?,?)";
	private final String SQL_SET_UPDATE = "update kjlj_doc04 set futurePlans=? where user_id=?";
	
	
	public boolean insert(KjljDoc04 kjljDoc04) {
		return jdbcTemplate.update(SQL_INSERT,
				new Object[] { kjljDoc04.getUser_id(),kjljDoc04.getFuturePlans()}) == 1;
	}
	
	public KjljDoc04 getByUserId( int user_id )
	{
		return jdbcTemplate.query( SQL_Get_BY_USERID, new Object[]{user_id},
				new ResultSetExtractor<KjljDoc04>()
				{
			@Override
			public KjljDoc04 extractData( ResultSet rs )
					throws SQLException, DataAccessException
					{
				KjljDoc04 kjljDoc04 = new KjljDoc04(); 
				if( rs.next() )
				{
					kjljDoc04.setId(rs.getInt("id"));
					kjljDoc04.setUser_id(rs.getInt("user_id"));
					kjljDoc04.setFuturePlans(rs.getString("futurePlans"));
		
				}
				return kjljDoc04;
					}
				} );
	}
	
	public boolean update(KjljDoc04 kjljDoc04){
		Object[] params = new Object[] {
			
//				jcqndoc03.getUser_id(),
				kjljDoc04.getFuturePlans(),
			     kjljDoc04.getUser_id()
				
		};
		return jdbcTemplate.update(SQL_SET_UPDATE,params) == 1;
		
		
	}
}
