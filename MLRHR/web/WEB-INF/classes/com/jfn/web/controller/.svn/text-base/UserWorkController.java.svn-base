package com.jfn.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.modules.security.springsecurity.SpringSecurityUtils;

import com.google.gson.JsonObject;
import com.jfn.entity.UserWork;
import com.jfn.entity.User;
import com.jfn.service.AccountManager;
import com.jfn.service.UserService;
import com.jfn.service.UserWorkService;


/**
 * @create-time 2014-8-24 下午5:56:02
 * @author 佟德慧
 * @remarks 无
 */
@Controller
@RequestMapping("/")
public class UserWorkController
{
	@Autowired
	private UserWorkService service;
	@Autowired
	private UserService userservice;
	@Autowired
	private AccountManager accountManager;
	

	@RequestMapping(value = "/userWork", method = RequestMethod.GET)
	public String userWork(HttpServletRequest request, Model model) {
		return "userBaseInfor/userWork";
	}
	
	@RequestMapping(value = "/userWorkList", method = RequestMethod.GET)
	@ResponseBody
	public String userWorkList( HttpServletRequest request, Model model )
	{
		String userId = request.getParameter("userId");
		User user = userservice.getById(userId);
		List<UserWork> list = service.getAllByUserId(user.getId().toString());
		 JSONArray jsonArray = JSONArray.fromObject(list);  
		return jsonArray.toString();
	}
	
	@RequestMapping(value = "/userWorkEdit", method = RequestMethod.GET)
	public String userWorkEdit(HttpServletRequest request, Model model) {
		String id = request.getParameter( "id" );
		if( ( id != null ) && ( id.length() >=1 ))
		{
			UserWork user_work = service.getById( id );
			model.addAttribute( "user_work", user_work );
		}
		return "userBaseInfor/userWorkEdit";
	}
	

	//工作经历提交(增加、修改)
	@RequestMapping(value = "/userWorkUpdate", method = RequestMethod.POST)
	@ResponseBody
	public String userWorkUpdate( HttpServletRequest request, @ModelAttribute
			UserWork entity )
	{
		JsonObject jsonResponse = new JsonObject();
		int result = 0;// 0:fail;1:success
		String msg = "Failed to %s this user_work";
		String id = request.getParameter( "id" );
		try
		{
			if( ( id == null ) || ( id.length() < 1 ) )
			{
				result = service.user_workInsert( entity ) ? 1 : 0;
			}
			else
			{
				result = service.user_workUpdate( entity ) ? 1 : 0;
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
	
	//通过user_work.id删除工作经历单条信息
	@RequestMapping(value = "userWorkDelete", method = RequestMethod.POST)
	@ResponseBody
	public String userWorkDelete( HttpServletRequest request, Model model )
	{
		JsonObject jsonResponse = new JsonObject();
		String Id = request.getParameter( "id" );
		int result = 0;// 0:fail;1:success
		String msg = "Failed to delete this user_work!";
		if( Id != null )
		{
		
			result =  service.deleteuser_work(Id)? 1 : 0;
			msg = "You have successfully DELETED this user_work.";
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
