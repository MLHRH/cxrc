package com.jfn.web.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springside.modules.security.springsecurity.SpringSecurityUtils;

import com.google.gson.JsonObject;
import com.jfn.entity.UserZhuanli;
import com.jfn.entity.User;
import com.jfn.entity.UserZhuanli;
import com.jfn.entity.UserStudy;
import com.jfn.service.AccountManager;
import com.jfn.service.UserZhuanliService;
import com.jfn.service.UserService;


/**
 * @create-time 2014-8-24 下午5:56:02
 * @author 佟德慧
 * @remarks 无
 */
@Controller
@RequestMapping("/")
public class UserZhuanliController
{
	@Autowired
	private UserZhuanliService service;
	@Autowired
	private UserService userservice;
	@Autowired
	private AccountManager accountManager;


	@RequestMapping(value = "/userZhuanli", method = RequestMethod.GET)
	public String userZhuanli(HttpServletRequest request, Model model) {
		return "userBaseInfor/userZhuanli";
	}
	
	@RequestMapping(value = "/userZhuanliList", method = RequestMethod.GET)
	@ResponseBody
	public String userZhuanliList( HttpServletRequest request, Model model )
	{
		String userId = request.getParameter("userId");
		User user = userservice.getById(userId);
		List<UserZhuanli> list = service.getAllByUserId(user.getId().toString());
		 JSONArray jsonArray = JSONArray.fromObject(list);  
		return jsonArray.toString();
	}
	
	@RequestMapping(value = "/userZhuanliEdit", method = RequestMethod.GET)
	public String userZhuanliEdit(HttpServletRequest request, Model model) {
		String id = request.getParameter( "id" );
		if( ( id != null ) && ( id.length() >=1 ))
		{
			UserZhuanli user_zhuanli = service.getById( id );
			model.addAttribute( "user_zhuanli", user_zhuanli );
		}
		return "userBaseInfor/userZhuanliEdit";
	}
	

	@RequestMapping(value = "/userZhuanliUpdate", method = RequestMethod.POST)
	@ResponseBody
	public String userZhuanliUpdate( HttpServletRequest request, @ModelAttribute
			UserZhuanli entity )
	{
		JsonObject jsonResponse = new JsonObject();
		int result = 0;// 0:fail;1:success
		String msg = "Failed to %s this user_zhuanli";
		String id = request.getParameter( "id" );
		try
		{
			if( ( id == null ) || ( id.length() < 1 ) )
			{
				result = service.user_zhuanliInsert( entity ) ? 1 : 0;
			}
			else
			{
				result = service.user_zhuanliUpdate( entity ) ? 1 : 0;
			}
		}
		catch( Exception e )
		{
			result = 0;
			msg = msg + ": " + e.getMessage();
		}
		jsonResponse.addProperty( "result", result );
		jsonResponse.addProperty( "msg",
				String.format( msg, ( id == null ) ? "add" : "edit" ) );
		return jsonResponse.toString();
	}
	

	@RequestMapping(value = "userZhuanliDelete", method = RequestMethod.POST)
	@ResponseBody
	public String userZhuanliDelete( HttpServletRequest request, Model model )
	{
		JsonObject jsonResponse = new JsonObject();
		String Id = request.getParameter( "id" );
		int result = 0;// 0:fail;1:success
		String msg = "Failed to delete this user_zhuanli!";
		if( Id != null )
		{
		
			result =  service.deleteuser_zhuanli(Id)? 1 : 0;
			msg = "You have successfully DELETED this user_zhuanli.";
		}
		else
		{
			return "404";
		}
		
		jsonResponse.addProperty( "result", result );
		jsonResponse.addProperty( "msg",msg );
		return jsonResponse.toString();
		
	}


}
