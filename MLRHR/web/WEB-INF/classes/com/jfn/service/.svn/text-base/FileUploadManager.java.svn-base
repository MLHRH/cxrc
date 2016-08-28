package com.jfn.service;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 上传，下载
 * 
 * @author plane,yangjsh
 */
@Component
@Transactional
public class FileUploadManager
{
	@Transactional
	public boolean upload( File[] uploadFile, String[] uploadFileName,
			String uploadPath , String[] uploadFileSaveName)
	{
		try
		{
			if( uploadFile != null )
			{
				File savedir = new File( uploadPath );
				if( !savedir.exists() )
				{
					savedir.mkdirs();
				}
				
				for( int i = 0; i < uploadFile.length; i++ )
				{
					File savefile = new File( savedir, uploadFileSaveName[i] );
					FileUtils.copyFile( uploadFile[i], savefile );
				}
			}
			return true;
		}
		catch( Exception e )
		{			
			e.printStackTrace();
			return false;
		}
	}

	public String download( String path, String fileName, HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			downloadFile( path, fileName, request, response );

		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		return null;
	}

	public void downloadSingleFile( Long id, HttpServletResponse response )
			throws IOException
	{
		try
		{
			// 清空response
			response.reset();
			OutputStream toClient = response.getOutputStream();

			String path = "";// att.getFileaddr();//得到地址
			InputStream fis = null;
			// path是指欲下载的文件的路径。
			File file = new File( path );
			// 取得文件名。
			String filename = file.getName();
			// 以流的形式下载文件。
			fis = new BufferedInputStream( new FileInputStream( path ) );
			byte[] buffer = new byte[fis.available()];
			fis.read( buffer );// 使文件里面的内容可以显示出来,防止得到空文件
			// 设置文件类型
			response.setContentType( "bin" );
			// this.response.setContentType("application/octet-stream");
			// 设置response的Header
			response.addHeader( "Content-Disposition", "attachment;filename="
					+ new String( filename.getBytes( "GB2312" ), "ISO8859-1" ) );
			response.addHeader( "Content-Length", "" + file.length() );
			toClient.write( buffer );
			toClient.flush();
			toClient.close();
		}
		catch( FileNotFoundException e )
		{
			e.printStackTrace();
			throw e;
		}
		catch( IOException e )
		{
			e.printStackTrace();
			throw e;
		}

	}

	public static String dateToString( Date date, String format )
	{
		String result = null;
		try
		{
			if( date != null )
			{
				DateFormat dateFormat = new SimpleDateFormat( format );
				result = dateFormat.format( date );
			}
		}
		catch( Exception e )
		{
		}
		return result;
	}

	public void downloadFile( String path, String fileName, HttpServletRequest request, HttpServletResponse response )
	{
		try
		{
			response.reset();

			response.setContentType(request.getContentType() + "; charset=GBK");
			response.setHeader("Content-disposition", "attachment;filename=" 
					+ new String( fileName.getBytes("GBK"),"ISO8859-1" ));
			FileInputStream in = new  FileInputStream(path); //读入文件
			
			ServletOutputStream outStream = response.getOutputStream();
			
			 outStream.flush();
			 int aRead = 0;
			 while((aRead = in.read()) != -1 && in != null)
			 {
				 outStream.write(aRead);
			 }
			 
			 outStream.flush();
			 outStream.close();
			 in.close();
			/*ZipOutputStream out = new ZipOutputStream( response
					.getOutputStream() );
			String str = dateToString( new Date(), "yyyyMMddHHmmss" );
			response.reset();
			response.addHeader( "Content-Disposition",
					"attachment;filename=download" + str + ".xls" );
			File file = new File( path );
			BufferedInputStream fis = new BufferedInputStream(
					new FileInputStream( path ) );
			byte[] buffer = new byte[fis.available()];
			out.putNextEntry( new ZipEntry( file.getName() ) );
			int len;
			// 读入需要下载的文件的内容，打包到zip文件
			while( ( len = fis.read( buffer ) ) > 0 )
			{
				out.write( buffer, 0, len );
			}
			out.closeEntry();
			fis.close();
			out.close();
			*/
		}
		catch( FileNotFoundException e )
		{
			e.printStackTrace();
		}
		catch( IOException e )
		{
			e.printStackTrace();
		}
		
	}

	/**
	 * 删除单个文件
	 * 
	 * @param fileName
	 *            被删除文件的文件名
	 * @return 单个文件删除成功返回true,否则返回false
	 */
	public boolean deleteFile( String fileName )
	{
		File file = new File( fileName );
		if( file.isFile() && file.exists() )
		{
			file.delete();
			return true;
		}
		else
		{
			return false;
		}
	}

}
