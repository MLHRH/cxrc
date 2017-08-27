package com.jfn.web.controller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.modules.security.springsecurity.SpringSecurityUtils;

import com.google.gson.JsonObject;
import com.jfn.entity.News;
import com.jfn.entity.User;
import com.jfn.service.AccountManager;
import com.jfn.service.NewsService;

@Controller
@RequestMapping("/")
public class NewsController
{
	@Autowired
	private NewsService service;

	@Autowired
	private AccountManager accountManager;
	
	@RequestMapping(value = "addnews", method = RequestMethod.GET)
	public String newsAdd( HttpServletRequest request, Model model )
	{
		News new_news = new News();
		new_news.setTop("none");
		new_news.setFirst("1");
		model.addAttribute( "news", new_news);
		return "news/newsedit";
	}
 
	@RequestMapping(value = "newslist", method = RequestMethod.GET)
	public String list( HttpServletRequest request, Model model )
	{
		
		model.addAttribute( "newslist",
					service.getAll() );
		return "news/newslist";
	}
	
	@RequestMapping(value = "newsdetail", method = RequestMethod.GET)
	public String detail( HttpServletRequest request, Model model )
	{
		
		String newsId = request.getParameter( "id" );
		if( newsId != null )
		{
			News news = service.getById( newsId );
			model.addAttribute( "news", news );

			return "news/newsdetail";
		}
		else
		{
			return "404";
		}
	}

	@RequestMapping(value = "newsedit", method = RequestMethod.GET)
	public String edit( HttpServletRequest request, Model model )
	{
		String newsId = request.getParameter( "id" );
		if( newsId != null )
		{
			News news = service.getById( newsId );
			model.addAttribute( "news", news );

			return "news/newsedit";
		}
		else
		{
			return "404";
		}
	}
	
	
	
	@RequestMapping(value = "newsdel", method = RequestMethod.POST)
	@ResponseBody
	public String delete( HttpServletRequest request, Model model )
	{
		JsonObject jsonResponse = new JsonObject();
		String newsId = request.getParameter( "id" );
		int result = 0;// 0:fail;1:success
		String msg = "Failed to delete this news!";
		if( newsId != null )
		{
		
			result =  service.deletenews(newsId)? 1 : 0;
			msg = "You have successfully DELETED this news.";
		}
		else
		{
			return "404";
		}
		
		jsonResponse.addProperty( "result", result );
		jsonResponse.addProperty( "msg",msg );
		return jsonResponse.toString();
		
	}

	@RequestMapping(value = "newsupdate", method = RequestMethod.POST)
	@ResponseBody
	public String newsUpdate( HttpServletRequest request, @ModelAttribute
			News entity )
	{
		JsonObject jsonResponse = new JsonObject();
		int result = 0;// 0:fail;1:success
		String msg = "Failed to %s this news!";
		String id = request.getParameter( "id" );
		
		User user = accountManager.findUserByLoginName( SpringSecurityUtils
				.getCurrentUserName() );
		entity.setAuthor(user.getName());
		
		if(( id == null )||(id.length()<1))
		{
			
			result = service.newsInsert( entity ) ? 1 : 0;
		}
		else
		{
			result = service.newsUpdate( entity ) ? 1 : 0;
		}
		jsonResponse.addProperty( "result", result );
		jsonResponse.addProperty( "msg",
				String.format( msg, ( id == null ) ? "add" : "edit" ) );
		return jsonResponse.toString();
	}

	
}
