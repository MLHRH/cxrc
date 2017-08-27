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
import com.jfn.entity.UserPeixun;
import com.jfn.entity.User;
import com.jfn.entity.UserPeixun;
import com.jfn.entity.UserStudy;
import com.jfn.service.AccountManager;
import com.jfn.service.UserPeixunService;
import com.jfn.service.UserService;


/**
 * @create-time 2014-8-24 下午5:56:02
 * @author 佟德慧
 * @remarks 无
 */
@Controller
@RequestMapping("/")
public class UserPeixunController
{
	@Autowired
	private UserPeixunService service;
	@Autowired
	private UserService userservice;
	@Autowired
	private AccountManager accountManager;
	

	@RequestMapping(value = "/userPeixun", method = RequestMethod.GET)
	public String userPeixun(HttpServletRequest request, Model model) {
		return "userBaseInfor/userPeixun";
	}
	
	@RequestMapping(value = "/userPeixunList", method = RequestMethod.GET)
	@ResponseBody
	public String userPeixunList( HttpServletRequest request, Model model )
	{
		String userId = request.getParameter("userId");
		User user = userservice.getById(userId);
		List<UserPeixun> list = service.getAllByUserId(user.getId().toString());
		 JSONArray jsonArray = JSONArray.fromObject(list);  
		return jsonArray.toString();
	}
	
	@RequestMapping(value = "/userPeixunEdit", method = RequestMethod.GET)
	public String userPeixunEdit(HttpServletRequest request, Model model) {
		String id = request.getParameter( "id" );
		if( ( id != null ) && ( id.length() >=1 ))
		{
			UserPeixun user_peixun = service.getById( id );
			model.addAttribute( "user_peixun", user_peixun );
		}
		return "userBaseInfor/userPeixunEdit";
	}

	//学习培训经历提交(增加、修改)
	@RequestMapping(value = "/userPeixunUpdate", method = RequestMethod.POST)
	@ResponseBody
	public String userPeixunUpdate( HttpServletRequest request, @ModelAttribute
			UserPeixun entity )
	{
		JsonObject jsonResponse = new JsonObject();
		int result = 0;// 0:fail;1:success
		String msg = "Failed to %s this user_peixun";
		String id = request.getParameter( "id" );
		try
		{
			if( ( id == null ) || ( id.length() < 1 ) )
			{
				result = service.user_peixunInsert( entity ) ? 1 : 0;
			}
			else
			{
				result = service.user_peixunUpdate( entity ) ? 1 : 0;
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
	
	//通过user_peixun.id删除学习培训经历单条信息
	@RequestMapping(value = "userPeixunDelete", method = RequestMethod.POST)
	@ResponseBody
	public String userPeixunDelete( HttpServletRequest request, Model model )
	{
		JsonObject jsonResponse = new JsonObject();
		String Id = request.getParameter( "id" );
		int result = 0;// 0:fail;1:success
		String msg = "Failed to delete this user_peixun!";
		if( Id != null )
		{
		
			result =  service.deleteuser_peixun(Id)? 1 : 0;
			msg = "You have successfully DELETED this user_peixun.";
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
