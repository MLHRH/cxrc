package com.jfn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.jfn.entity.JcqnDoc03;
import com.jfn.entity.JcqnDoc04;
@Repository
public class JcqnDoc04Dao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private final String SQL_Get_BY_USERID = "select * from jcqn_doc04 where user_id=?";
	private final String SQL_INSERT = "insert into jcqn_doc04(user_id,futurePlans) values(?,?)";
	private final String SQL_SET_UPDATE = "update jcqn_doc04 set futurePlans=? where user_id=?";
	
	
	public boolean insert(JcqnDoc04 jcqndoc04) {
		return jdbcTemplate.update(SQL_INSERT,
				new Object[] { jcqndoc04.getUser_id(),jcqndoc04.getFuturePlans()}) == 1;
	}
	
	public JcqnDoc04 getByUserId( int user_id )
	{
		return jdbcTemplate.query( SQL_Get_BY_USERID, new Object[]{user_id},
				new ResultSetExtractor<JcqnDoc04>()
				{
			@Override
			public JcqnDoc04 extractData( ResultSet rs )
					throws SQLException, DataAccessException
					{
				JcqnDoc04 jcqndoc04 = new JcqnDoc04(); 
				if( rs.next() )
				{
					jcqndoc04.setId(rs.getInt("id"));
					jcqndoc04.setUser_id(rs.getInt("user_id"));
					jcqndoc04.setFuturePlans(rs.getString("futurePlans"));
		
				}
				return jcqndoc04;
					}
				} );
	}
	
	public boolean update(JcqnDoc04 jcqndoc04){
		Object[] params = new Object[] {
			
//				jcqndoc03.getUser_id(),
				jcqndoc04.getFuturePlans(),
			     jcqndoc04.getUser_id()
				
		};
		return jdbcTemplate.update(SQL_SET_UPDATE,params) == 1;
		
		
	}
}
