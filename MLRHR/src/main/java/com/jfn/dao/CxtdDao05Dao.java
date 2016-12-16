package com.jfn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.jfn.entity.CxtdDao05;

@Repository
public class CxtdDao05Dao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private final String SQL_Get_BY_USERID = "select * from cxtd_doc05 where user_id=?";
	private final String SQL_INSERT = "insert into cxtd_doc05(user_id,needsRelevanceSupport) values(?,?)";
	private final String SQL_SET_UPDATE = "update cxtd_doc05 set needsRelevanceSupport=? where user_id=?";

	public boolean insert(CxtdDao05 cxtdDao05) {
		return jdbcTemplate.update(SQL_INSERT,
				new Object[] { cxtdDao05.getUser_id(), cxtdDao05.getNeedsRelevanceSupport() }) == 1;
	}

	public CxtdDao05 getByUserId(int user_id) {
		return jdbcTemplate.query(SQL_Get_BY_USERID, new Object[] { user_id }, new ResultSetExtractor<CxtdDao05>() {
			@Override
			public CxtdDao05 extractData(ResultSet rs) throws SQLException, DataAccessException {
				CxtdDao05 cxtdDao05 = new CxtdDao05();
				if (rs.next()) {
					cxtdDao05.setId(rs.getInt("id"));
					cxtdDao05.setUser_id(rs.getInt("user_id"));
					cxtdDao05.setNeedsRelevanceSupport(rs.getString("needsRelevanceSupport"));

				}
				return cxtdDao05;
			}
		});
	}

	public boolean update(CxtdDao05 cxtdDao05) {
		Object[] params = new Object[] {

				// jcqndoc03.getUser_id(),
				cxtdDao05.getNeedsRelevanceSupport(), cxtdDao05.getUser_id()

		};
		return jdbcTemplate.update(SQL_SET_UPDATE, params) == 1;

	}
}
