package com.jfn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.jfn.entity.CxtdDoc04;

@Repository
public class CxtdDoc04Dao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private final String SQL_Get_BY_USERID = "select * from cxtd_doc04 where user_id=?";
	private final String SQL_INSERT = "insert into cxtd_doc04(user_id,futurePlans) values(?,?)";
	private final String SQL_SET_UPDATE = "update cxtd_doc04 set futurePlans=? where user_id=?";

	public boolean insert(CxtdDoc04 cxtdDoc04) {
		return jdbcTemplate.update(SQL_INSERT,
				new Object[] { cxtdDoc04.getUser_id(), cxtdDoc04.getFuturePlans() }) == 1;
	}

	public CxtdDoc04 getByUserId(int user_id) {
		return jdbcTemplate.query(SQL_Get_BY_USERID, new Object[] { user_id }, new ResultSetExtractor<CxtdDoc04>() {
			@Override
			public CxtdDoc04 extractData(ResultSet rs) throws SQLException, DataAccessException {
				CxtdDoc04 cxtdDoc04 = new CxtdDoc04();
				if (rs.next()) {
					cxtdDoc04.setId(rs.getInt("id"));
					cxtdDoc04.setUser_id(rs.getInt("user_id"));
					cxtdDoc04.setFuturePlans(rs.getString("futurePlans"));

				}
				return cxtdDoc04;
			}
		});
	}

	public boolean update(CxtdDoc04 cxtdDoc04) {
		Object[] params = new Object[] {

				// jcqndoc03.getUser_id(),
				cxtdDoc04.getFuturePlans(), cxtdDoc04.getUser_id()

		};
		return jdbcTemplate.update(SQL_SET_UPDATE, params) == 1;

	}

}
