package com.jfn.common.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

/**
 * url连接的工具函数
 * 
 */
public class UrlTool
{
	/**
	 * 发送json数据
	 * @param obj 发送的json对象
	 * @param uri 要发送的地址
	 * @return 响应的数据
	 * @throws IOException
	 * @throws IOException
	 */
	public static String postJson( JSONObject obj, String uri )
			throws IOException, IOException
	{
		DefaultHttpClient client = new DefaultHttpClient();
		
		StringEntity entity = new StringEntity( obj.toString(), "UTF-8" );
		
		HttpPost httpost = new HttpPost( uri );
		httpost.setHeader( "Content-type", "application/json" );
		httpost.setEntity( entity );
		httpost.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");

		HttpResponse response = client.execute( httpost );

		return getStringFromHttp(response.getEntity());
	}

	// 获取所有的网页信息以String 返回
	private static String getStringFromHttp( HttpEntity entity )
	{
		StringBuffer buffer = new StringBuffer();
		try
		{
			// 获取输入流
			BufferedReader reader = new BufferedReader( new InputStreamReader(
					entity.getContent() ) );

			// 将返回的数据读到buffer中
			String temp = null;

			while( ( temp = reader.readLine() ) != null )
			{
				buffer.append( temp );
			}
		}
		catch( IllegalStateException e )
		{
			 e.printStackTrace();
		}
		catch( IOException e )
		{
			 e.printStackTrace();
		}
		return buffer.toString();
	}

	/**
	 * 发送http请求，并返回字符串
	 * 
	 * @param urlStr
	 * @param param
	 *            要传输的参数
	 * @param postOrGet
	 *            post或get
	 * @return 服务端的返回
	 * @throws Exception
	 */
	public static String request( String urlStr, Map<String, Object> param,
			String postOrGet ) throws Exception
	{
		StringBuilder paramBuilder = new StringBuilder();
		if( param != null )
		{
			for( Map.Entry<String, Object> entry : param.entrySet() )
			{
				paramBuilder.append( entry.getKey() );
				paramBuilder.append( "=" );
				paramBuilder.append( entry.getValue() );
				paramBuilder.append( "&" );
			}
		}

		return request( urlStr, paramBuilder.toString(), postOrGet );
	}

	/**
	 * 发送http请求，并返回字符串
	 * 
	 * @param urlStr
	 * @param param
	 *            要传输的参数
	 * @param postOrGet
	 *            post或get
	 * @return 服务端的返回
	 * @throws Exception
	 */
	public static String request( String urlStr, String param, String postOrGet )
			throws IOException
	{
		if( urlStr == null )
		{
			return "";
		}

		postOrGet = postOrGet == null ? "POST" : postOrGet.toUpperCase();
		if( !( postOrGet.equals( "POST" ) || "".equals( "GET" ) ) )
		{
			postOrGet = "POST";
		}

		// 建立连接
		URL url = new URL( urlStr );
		HttpURLConnection url_con = ( HttpURLConnection ) url.openConnection();
		url_con.setRequestMethod( postOrGet );
		if( param == null || "".equals( param ) )
		{
			url_con.setDoOutput( false );
		}
		else
		{
			url_con.setDoOutput( true );

			// 发送数据
			url_con.getOutputStream().write( param.getBytes() );
			url_con.getOutputStream().flush();
			url_con.getOutputStream().close();
		}

		// 读取返回
		BufferedReader in = new BufferedReader( new InputStreamReader( url_con
				.getInputStream() ) );
		StringBuilder responseBuilder = new StringBuilder();
		String line;
		while( ( line = in.readLine() ) != null )
		{
			responseBuilder.append( line );
		}

		return responseBuilder.toString();
	}

}
