package com.jfn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.jfn.entity.CxtdDoc03;

@Repository
public class CxtdDoc03Dao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private final String SQL_Get_BY_USERID = "select * from cxtd_doc03 where user_id=?";
	private final String SQL_INSERT = "insert into cxtd_doc03(user_id,selfAssessment) values(?,?)";
	private final String SQL_SET_UPDATE = "update cxtd_doc03 set selfAssessment=? where user_id=?";

	public boolean insert(CxtdDoc03 cxtdDoc03) {
		return jdbcTemplate.update(SQL_INSERT,
				new Object[] { cxtdDoc03.getUser_id(), cxtdDoc03.getSelfAssessment() }) == 1;
	}

	public CxtdDoc03 getByUserId(int user_id) {
		return jdbcTemplate.query(SQL_Get_BY_USERID, new Object[] { user_id }, new ResultSetExtractor<CxtdDoc03>() {
			@Override
			public CxtdDoc03 extractData(ResultSet rs) throws SQLException, DataAccessException {
				CxtdDoc03 cxtdDoc03 = new CxtdDoc03();
				if (rs.next()) {
					cxtdDoc03.setId(rs.getInt("id"));
					cxtdDoc03.setUser_id(rs.getInt("user_id"));
					cxtdDoc03.setSelfAssessment(rs.getString("selfAssessment"));

				}
				return cxtdDoc03;
			}
		});
	}

	public boolean update(CxtdDoc03 cxtdDoc03) {
		Object[] params = new Object[] {

				// kjljDoc03.getUser_id(),
				cxtdDoc03.getSelfAssessment(), cxtdDoc03.getUser_id()

		};
		return jdbcTemplate.update(SQL_SET_UPDATE, params) == 1;

	}
}
