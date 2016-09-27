package com.jfn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.stereotype.Repository;

import com.jfn.entity.ActionLog;
@Repository
public class LogDao
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final static String SQL_ADD_LOG = "insert into actionlog(userid,action,actiontime) values(?,?,?)";
	
	private final static String SQL_GET_LOG = "select * from actionlog where action like ? and action like ? order by actiontime desc";
	
	public void addLog(int userid, String action)
	{
		Object[] params=new Object[]{
	    		userid,action, new Date()
	    };
	    jdbcTemplate.update(SQL_ADD_LOG,params);
	}
	
	public List<ActionLog> GetLog(String obj,int objid)
	{
		Object[] params=new Object[]{"%"+obj+"%","% id = "+objid+"%"};
	
	   return  jdbcTemplate.query(SQL_GET_LOG,params,new LogRowMapper());
				
	}
	
	/**
	 * 定义内部类实现RowMapper接口
	 */
	public class LogRowMapper implements ParameterizedRowMapper<ActionLog>
	{
		// 实现mapRow方法
		@Override
		public ActionLog mapRow( ResultSet rs, int num ) throws SQLException
		{
			// 对类进行封装
			ActionLog m = new ActionLog();
			m.setId( rs.getInt( "id" ) );
			m.setAction(rs.getString("action"));
			m.setActiontime(rs.getString("actiontime"));
			m.setUserid(rs.getString("userid"));
			return m;
		}
	}
}
