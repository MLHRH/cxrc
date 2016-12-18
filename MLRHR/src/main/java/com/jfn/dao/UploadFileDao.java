package com.jfn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.stereotype.Repository;

import com.jfn.entity.Attachfile;


@Repository
public class UploadFileDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private final String SQL_INSERT_FILE = "insert into uploadfile (userid,applyid,oldfilename,newfilename,uptime,location) values(?,?,?,?,?,?)";
	private final String SQL_QUERY_FILE = "select * from uploadfile where applyid = ? ";
	private final String SQL_QUERY_BY_ID = "select * from uploadfile where id = ?";
	private final String SQL_DEL_FILE = "delete from uploadfile where id = ?";
	
	/**
	 * 插入上传文件数据
	 * @param file
	 * @return
	 */
	public boolean insertUploadFile(Attachfile file){
		Object[] params  = new Object[]{file.getUserid(),file.getApplyid(),file.getOldfilename(),file.getNewfilename(),
				file.getUpload_time(),file.getFile_path()};
			 return jdbcTemplate.update(SQL_INSERT_FILE, params) == 1;
	}
	/**
	 * 查询file信息
	 * @param applyid
	 * @return
	 */
	public Attachfile queryFile(int applyid){
		Object[] params = new Object[]{applyid};
		return jdbcTemplate.query(SQL_QUERY_FILE, params, new ResultSetExtractor<Attachfile>() {

			@Override
			public Attachfile extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				Attachfile file = null;
				if(rs.next()){
					file = new Attachfile();
					file.setId(rs.getInt("id"));
					file.setApplyid(rs.getInt("applyid"));
					file.setUserid(rs.getInt("userid"));
					file.setOldfilename(rs.getString("oldfilename"));
					file.setNewfilename(rs.getString("newfilename"));
					file.setFile_path(rs.getString("location"));
					file.setUpload_time(rs.getString("uptime"));
				}
				return file;
			}
		});
	}
	
	/**
	 * 查询file信息
	 * @param applyid
	 * @return
	 */
	public Attachfile queryFileById(int id){
		Object[] params = new Object[]{id};
		return jdbcTemplate.query(SQL_QUERY_BY_ID, params, new ResultSetExtractor<Attachfile>() {

			@Override
			public Attachfile extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				Attachfile file = null;
				if(rs.next()){
					file = new Attachfile();
					file.setId(rs.getInt("id"));
					file.setApplyid(rs.getInt("applyid"));
					file.setUserid(rs.getInt("userid"));
					file.setOldfilename(rs.getString("oldfilename"));
					file.setNewfilename(rs.getString("newfilename"));
					file.setFile_path(rs.getString("location"));
					file.setUpload_time(rs.getString("uptime"));
				}
				return file;
			}
		});
	}
	/**
	 * 删除文件信息
	 * @param id
	 * @return
	 */
	public boolean delFile(int id){
		Object[] params = new Object[]{id};
		return jdbcTemplate.update(SQL_DEL_FILE, params) == 1 ;
	}
	/**
	 * 
	 * @author Administrator
	 *
	 */
	public class fileRowMapper implements ParameterizedRowMapper<Attachfile>{
		@Override
		public Attachfile mapRow(ResultSet rs, int num) throws SQLException {
			Attachfile file = new Attachfile();
			file.setId(rs.getInt("id"));
			file.setOldfilename(rs.getString("oldfilename"));
			file.setNewfilename(rs.getString("newfilename"));
			file.setFile_path(rs.getString("location"));
			file.setUpload_time(rs.getString("uptime"));
			return file;
		}
	}
}
