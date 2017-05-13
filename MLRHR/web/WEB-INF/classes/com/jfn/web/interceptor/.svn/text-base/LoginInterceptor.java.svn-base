package com.jfn.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter
{
	private static final Logger log = LoggerFactory
			.getLogger( LoginInterceptor.class );

	@Override
	public boolean preHandle( HttpServletRequest request,
			HttpServletResponse response, Object handler ) throws Exception
	{
		if( request.getSession().getAttribute( "loginuser" ) != null )
		{
			return true;
		}
		//静态资源、登陆URL、登出URL都不需要检查，直接允许
		String[] allowedUrl = new String[]{ "/login", "/logout", "/cors",
				"/css", "/images", "/static", "/img", "/imgs", "/js"};
		if( isAllowed( request, allowedUrl ) )
		{
			return true;
		}
		if( request.getSession().getAttribute( "loginuser" ) == null )
		{
			//记住访问前的页面以及querystring
			String lastPage = request.getServletPath();
			String query = request.getQueryString();
			if( ( query != null ) && ( query.length() > 0 ) )
			{
				lastPage=lastPage.concat( "?" ).concat( query );
			}
			if( ( lastPage != null ) && ( !( lastPage.equals( "/" ) ) )
					&& ( lastPage.length() > 0 ) )
			{
				//如果用户登陆前就访问某页面，跳转到登陆页面，加上请求URL作为参数
				log.info( String.format( "a user requested url is '%s' before login", lastPage ) );
				response.sendRedirect( request.getContextPath() + "/login?p="
						+ lastPage );
			}
			else
			{
				//用户直接访问登陆页面
				response.sendRedirect( request.getContextPath() + "/login" );
			}
			return false;
		}
		return true;
	}

	private boolean isAllowed( HttpServletRequest request, String[] urls )
	{
		for( String url : urls )
		{
			if( request.getServletPath().contains( url ) )
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public void postHandle( HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView ) throws Exception
	{
	}

	@Override
	public void afterCompletion( HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex )
			throws Exception
	{
	}
}