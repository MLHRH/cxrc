package com.jfn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.stereotype.Repository;

import com.jfn.entity.News;

@Repository
public class NewsDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String SQL_INSERT_news = "insert into news(title,author,pub_date,content,first,top,type) values(?,?,?,?,?,?,?)";

	private final String SQL_Get_BY_ID = "select * from news where Id=?";
	private final String SQL_GET_news_LIST = "select * from news order by first, pub_date desc ";
	private final String SQL_GET_news_LIST_Top = "select * from news where top='top' order by first, pub_date desc limit 5";
	private final String SQL_SET_news_UPDATE = "update news set title=?,author=?,pub_date=?,content=?,first=?,top=?,type=? where id=?";

	private final static String SQL_DEL_BY_ID = "delete from news where id = ?";

	public boolean insert(News news) {
		return jdbcTemplate.update(SQL_INSERT_news, new Object[] { news.getTitle(), news.getAuthor(), new Date(), news.getContent(), news.getFirst(), news.getTop(), news.getType() }) == 1;
	}

	public News get(int id) {
		return jdbcTemplate.query(SQL_Get_BY_ID, new Object[] { id }, new ResultSetExtractor<News>() {
			@Override
			public News extractData(ResultSet rs) throws SQLException, DataAccessException {
				News news = new News();
				if (rs.next()) {
					news.setId(rs.getInt("id"));
					news.setTitle(rs.getString("title"));
					news.setAuthor(rs.getString("author"));

					// 下面是截取时间，例：2014-09-15 18:55:50.275 最后.275去掉。
					String Pub_date = rs.getString("pub_date");
					String a[] = Pub_date.split("\\.");
					news.setPub_date(a[0]);

					news.setContent(rs.getString("content"));
					news.setFirst(rs.getString("first"));
					news.setTop(rs.getString("top"));
					news.setType(rs.getString("type"));

				}
				return news;
			}
		});
	}

	/**
	 * 修改保存
	 * 
	 * @param request
	 * @param model
	 * @return
	 */

	public boolean Update(News news) {
		Object[] params = new Object[] { news.getTitle(), news.getAuthor(), new Date(), news.getContent(), news.getFirst(), news.getTop(), news.getType(), news.getId() };
		return jdbcTemplate.update(SQL_SET_news_UPDATE, params) == 1;
	}

	public boolean delete(int id) {
		return jdbcTemplate.update(SQL_DEL_BY_ID, new Object[] { id }) == 1;
	}

	public boolean isPropertyUnique(String newLoginName, String oldLoginName) {
		return false;
	}

	public List<News> getAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(SQL_GET_news_LIST, new newsRowMapper());
	}

	public List<News> getAllforTop() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(SQL_GET_news_LIST_Top, new newsRowMapper());
	}

	/**
	 * 定义内部类实现RowMapper接口
	 */
	public class newsRowMapper implements ParameterizedRowMapper<News> {
		// 实现mapRow方法
		@Override
		public News mapRow(ResultSet rs, int num) throws SQLException {
			// 对类进行封装
			News news = new News();
			news.setId(rs.getInt("id"));
			news.setTitle(rs.getString("title"));
			news.setAuthor(rs.getString("author"));

			// 下面是截取时间，例：2014-09-15 18:55:50.275 最后.275去掉。
			String Pub_date = rs.getString("pub_date");
			String a[] = Pub_date.split("\\.");
			news.setPub_date(a[0]);

			news.setContent(rs.getString("content"));
			news.setFirst(rs.getString("first"));
			news.setTop(rs.getString("top"));
			news.setType(rs.getString("type"));
			return news;
		}
	}
}
