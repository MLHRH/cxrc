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
import com.jfn.entity.UserChengguo;
import com.jfn.entity.User;
import com.jfn.entity.UserChengguo;
import com.jfn.entity.UserStudy;
import com.jfn.service.AccountManager;
import com.jfn.service.UserChengguoService;
import com.jfn.service.UserService;


/**
 * @create-time 2014-8-24 下午5:56:02
 * @author 佟德慧
 * @remarks 无
 */
@Controller
@RequestMapping("/")
public class UserChengguoController
{
	@Autowired
	private UserChengguoService service;
	@Autowired
	private UserService userservice;
	@Autowired
	private AccountManager accountManager;


	@RequestMapping(value = "/userChengguo", method = RequestMethod.GET)
	public String userChengguo(HttpServletRequest request, Model model) {
		return "userBaseInfor/userChengguo";
	}
	
	@RequestMapping(value = "/userChengguoList", method = RequestMethod.GET)
	@ResponseBody
	public String userChengguoList( HttpServletRequest request, Model model )
	{
		String userId = request.getParameter("userId");
		User user = userservice.getById(userId);
		List<UserChengguo> list = service.getAllByUserId(user.getId().toString());
		 JSONArray jsonArray = JSONArray.fromObject(list);  
		return jsonArray.toString();
	}
	
	@RequestMapping(value = "/userChengguoEdit", method = RequestMethod.GET)
	public String userChengguoEdit(HttpServletRequest request, Model model) {
		String id = request.getParameter( "id" );
		if( ( id != null ) && ( id.length() >=1 ))
		{
			UserChengguo user_chengguo = service.getById( id );
			model.addAttribute( "user_chengguo", user_chengguo );
		}
		return "userBaseInfor/userChengguoEdit";
	}
	

	@RequestMapping(value = "/userChengguoUpdate", method = RequestMethod.POST)
	@ResponseBody
	public String userChengguoUpdate( HttpServletRequest request, @ModelAttribute
			UserChengguo entity )
	{
		JsonObject jsonResponse = new JsonObject();
		int result = 0;// 0:fail;1:success
		String msg = "Failed to %s this user_chengguo";
		String id = request.getParameter( "id" );
		try
		{
			if( ( id == null ) || ( id.length() < 1 ) )
			{
				result = service.user_chengguoInsert( entity ) ? 1 : 0;
			}
			else
			{
				result = service.user_chengguoUpdate( entity ) ? 1 : 0;
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
	

	@RequestMapping(value = "userChengguoDelete", method = RequestMethod.POST)
	@ResponseBody
	public String userChengguoDelete( HttpServletRequest request, Model model )
	{
		JsonObject jsonResponse = new JsonObject();
		String Id = request.getParameter( "id" );
		int result = 0;// 0:fail;1:success
		String msg = "Failed to delete this user_chengguo!";
		if( Id != null )
		{
		
			result =  service.deleteuser_chengguo(Id)? 1 : 0;
			msg = "You have successfully DELETED this user_chengguo.";
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
