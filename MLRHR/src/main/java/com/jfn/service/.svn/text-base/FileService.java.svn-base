package com.jfn.service;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jfn.dao.FileDao;
import com.jfn.dao.UserDao;
import com.jfn.entity.AttachComment;
import com.jfn.entity.Attachfile;

@Repository
public class FileService
{
	private static final Logger log = LoggerFactory
			.getLogger( FileService.class );

	@Autowired
	private FileDao fileDao;
	
	@Autowired
	private UserDao userDao;
	
	
	public boolean deleteFile(int id)
	{
		boolean flag=false;
		Attachfile af = getFileByID( id );
		if(fileDao.deleteFile( id ))
		{
			File file = new File( af.getFile_path() );
			if( file.exists() )
			{
				file.delete();
			}
			flag=true;
		}
		return flag;
	}
	
	public List<Attachfile> getFilesByUploader( int uploader_id)
	{
		try
		{
			List<Attachfile> fileList = fileDao.getFilesByUploader( uploader_id);
			return fileList;
		}
		catch( Exception e )
		{
			log.error( "Get file exception:" + e.getMessage() );
			return null;
		}
	}

	public List<Attachfile> getFilesByUploaderAndType( int uploader_id,int fileType)
	{
		try
		{
			List<Attachfile> fileList = fileDao.getFilesByUploaderAndType( uploader_id ,fileType);
			return fileList;
		}
		catch( Exception e )
		{
			log.error( "Get file exception:" + e.getMessage() );
			return null;
		}
	}
	public List<Attachfile> getFilesByUploaderAndTypeAndNum( int uploader_id,int fileType,int fileTypeNum)
	{
		try
		{
			List<Attachfile> fileList = fileDao.getFilesByUploaderAndTypeAndNum( uploader_id ,fileType,fileTypeNum);
			return fileList;
		}
		catch( Exception e )
		{
			log.error( "Get file exception:" + e.getMessage() );
			return null;
		}
	}
	
	
	public Attachfile getFileByID(int id)
	{
		return fileDao.getFileByID( id );
	}
	
	
}
