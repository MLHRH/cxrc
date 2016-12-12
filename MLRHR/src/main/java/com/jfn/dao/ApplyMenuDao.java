package com.jfn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.jfn.entity.ApplyMenu;

@Repository
public class ApplyMenuDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private static final String SQL_SELECT="SELECT * FROM apply_menu WHERE menu_type = ? or menu_type='ALL' ORDER BY id";
	public List<ApplyMenu> getMenu(String applytype){
		return jdbcTemplate.query( SQL_SELECT, new Object[]{ applytype},
				new ResultSetExtractor<List<ApplyMenu>>()
				{
			@Override
			public List<ApplyMenu> extractData( ResultSet rs )
					throws SQLException, DataAccessException
					{
				List<ApplyMenu> list = new ArrayList<ApplyMenu>();
				while( rs.next() )
				{   
					ApplyMenu applyMenu = new ApplyMenu();
					applyMenu.setId(rs.getInt("id"));
					applyMenu.setMenuid(rs.getString("menu_id"));
					applyMenu.setMenudetails(rs.getString("menu_details"));
					applyMenu.setMenutype(rs.getString("menu_type"));
					list.add(applyMenu);
				}
				return list;
					}
				} );
	}

}
