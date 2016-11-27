package com.jfn.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jfn.entity.Attachfile;

@Repository
@Transactional
public class FileDao
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private String filedir;

	private final static String SQL_GET_FILE_BY_UPLOADER = "select * from attachfile where uploader_id=?";
	private final static String SQL_GET_FILE_BY_UPLOADER_AND_TYPE = "select * from attachfile where uploader_id=? and  file_type=?";
	private final static String SQL_GET_FILE_BY_UPLOADER_AND_TYPE_AND_NUM = "select * from attachfile where uploader_id=? and  file_type=? and  file_type_num=?";
	private final static String SQL_GET_FILE_BY_ID = "select * from attachfile where id=?";
	private final static String SQL_GET_FILE_BY_NAME = "select * from attachfile where file_path=?";
	private final static String SQL_ADD = "insert into attachfile(file_path,file_name,file_size,uploader_id,upload_time,file_type,file_type_num) values(?,?,?,?,?,?,?)";
	private final static String SQL_DEL = "delete from attachfile where id = ?";
	
	
	public List<Attachfile> getFilesByUploaderAndTypeAndNum( int uploader_id, int fileType, int fileTypeNum)
	{
		return jdbcTemplate.query( SQL_GET_FILE_BY_UPLOADER_AND_TYPE_AND_NUM,
				new Object[]{ uploader_id,fileType,fileTypeNum },new ParameterizedRowMapper<Attachfile>(){
					@Override
					public Attachfile mapRow( ResultSet rs, int i )
							throws SQLException
					{
						Attachfile file = new Attachfile();
						file.setId( rs.getInt( "id" ) );
						file.setFile_name( rs.getString( "file_name" ) );
						file.setFile_path( rs.getString( "file_path" ) );
						file.setFile_size( rs.getLong( "file_size" ) );
						file.setUploader_id( rs.getInt( "uploader_id" ) );
						file.setUpload_time( rs.getString( "upload_time" ) );
						file.setFile_type( rs.getInt( "file_type" ) );
						file.setFile_type_num( rs.getInt( "file_type_num" ) );
						
						return file;
					}			
		});
	}
	
	public List<Attachfile> getFilesByUploader( int uploader_id)
	{
		return jdbcTemplate.query( SQL_GET_FILE_BY_UPLOADER,
				new Object[]{ uploader_id},new ParameterizedRowMapper<Attachfile>(){
					@Override
					public Attachfile mapRow( ResultSet rs, int i )
							throws SQLException
					{
						Attachfile file = new Attachfile();
						file.setId( rs.getInt( "id" ) );
						file.setFile_name( rs.getString( "file_name" ) );
						file.setFile_path( rs.getString( "file_path" ) );
						file.setFile_size( rs.getLong( "file_size" ) );
						file.setUploader_id( rs.getInt( "uploader_id" ) );
						file.setUpload_time( rs.getString( "upload_time" ) );
						file.setFile_type( rs.getInt( "file_type" ) );
						file.setFile_type_num( rs.getInt( "file_type_num" ) );
						
						return file;
					}			
		});
	}
	public List<Attachfile> getFilesByUploaderAndType( int uploader_id,int fileType)
	{
		return jdbcTemplate.query( SQL_GET_FILE_BY_UPLOADER_AND_TYPE,
				new Object[]{ uploader_id,fileType},new ParameterizedRowMapper<Attachfile>(){
			@Override
			public Attachfile mapRow( ResultSet rs, int i )
					throws SQLException
			{
				Attachfile file = new Attachfile();
				file.setId( rs.getInt( "id" ) );
				file.setFile_name( rs.getString( "file_name" ) );
				file.setFile_path( rs.getString( "file_path" ) );
				file.setFile_size( rs.getLong( "file_size" ) );
				file.setUploader_id( rs.getInt( "uploader_id" ) );
				file.setUpload_time( rs.getString( "upload_time" ) );
				file.setFile_type( rs.getInt( "file_type" ) );
				file.setFile_type_num( rs.getInt( "file_type_num" ) );
				
				return file;
			}			
		});
	}
	
	public boolean deleteFile( int id )
	{
		// Note: this would delete file from DB and we have to delete this file from server disk
		return jdbcTemplate.update( SQL_DEL, new Object[]{id} ) == 1;
	}

	public Attachfile getFileByID( int id )
	{
		return jdbcTemplate.queryForObject( SQL_GET_FILE_BY_ID, new Object[]{ id},new FileRowMapper() );
	}

	public Attachfile getFileByName( String path )
	{
		return jdbcTemplate.queryForObject( SQL_GET_FILE_BY_NAME, new Object[]{ path },new FileRowMapper() );
	}
	
	
	public int newFile( final Attachfile file )
	{
		KeyHolder keyHolder = new GeneratedKeyHolder();
        
        jdbcTemplate.update(
                new PreparedStatementCreator(){
                    @Override
					public java.sql.PreparedStatement createPreparedStatement(Connection conn) throws SQLException{
                        java.sql.PreparedStatement ps = conn.prepareStatement(SQL_ADD, new String[] {}); 
                         
                        ps = conn.prepareStatement(SQL_ADD, Statement.RETURN_GENERATED_KEYS);
                        ps.setString(1, file.getFile_path());
                        ps.setString(2, file.getFile_name());
                        ps.setLong(3, file.getFile_size());
                        ps.setInt(4, file.getUploader_id());
                        ps.setString(5, file.getUpload_time());
                        ps.setInt(6, file.getFile_type());
                        ps.setInt(7, file.getFile_type_num());
                        
                        return ps;
                    }
                },
                keyHolder);
        return keyHolder.getKey().intValue();
	}

	public JdbcTemplate getJdbcTemplate()
	{
		return jdbcTemplate;
	}

	public void setJdbcTemplate( JdbcTemplate jdbcTemplate )
	{
		this.jdbcTemplate = jdbcTemplate;
	}
	
	/**
	 * 定义内部类实现RowMapper接口
	 */
	public class FileRowMapper implements ParameterizedRowMapper<Attachfile>
	{
		// 实现mapRow方法
		@Override
		public Attachfile mapRow( ResultSet rs, int num ) throws SQLException
		{
			// 对类进行封装
			Attachfile file = new Attachfile();
			file.setId( rs.getInt( "id" ) );
			file.setFile_name( rs.getString( "file_name" ) );
			file.setFile_path( rs.getString( "file_path" ) );
			file.setFile_size( rs.getLong( "file_size" ) );
			file.setUploader_id( rs.getInt( "uploader_id" ) );
			file.setUpload_time( rs.getString( "upload_time" ) );
			file.setFile_type( rs.getInt( "file_type" ) );
			file.setFile_type_num( rs.getInt( "file_type_num" ) );
			
			return file;
		}
	}

	public String getFiledir()
	{
		return filedir;
	}

	public void setFiledir( String filedir )
	{
		this.filedir = filedir;
	}
}
