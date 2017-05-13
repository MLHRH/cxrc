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
import com.jfn.entity.UserStudy;
import com.jfn.entity.User;
import com.jfn.service.AccountManager;
import com.jfn.service.UserService;
import com.jfn.service.UserStudyService;


/**
 * @create-time 2014-8-24 下午5:56:02
 * @author 佟德慧
 * @remarks 无
 */
@Controller
@RequestMapping("/")
public class UserStudyController
{
	@Autowired
	private UserStudyService service;
	@Autowired
	private UserService userservice;
	@Autowired
	private AccountManager accountManager;
	
	@RequestMapping(value = "/userStudy", method = RequestMethod.GET)
	public String userStudy(HttpServletRequest request, Model model) {
		return "userBaseInfor/userStudy";
	}
	
	@RequestMapping(value = "/userStudyList", method = RequestMethod.GET)
	@ResponseBody
	public String userStudyList( HttpServletRequest request, Model model )
	{
		String userId = request.getParameter("userId");
		User user = userservice.getById(userId);
		List<UserStudy> list = service.getAllByUserId(user.getId().toString());
		 JSONArray jsonArray = JSONArray.fromObject(list);  
		return jsonArray.toString();
	}
	
	@RequestMapping(value = "/userStudyEdit", method = RequestMethod.GET)
	public String userStudyEdit(HttpServletRequest request, Model model) {
		String id = request.getParameter( "id" );
		if( ( id != null ) && ( id.length() >=1 ))
		{
			UserStudy user_study = service.getById( id );
			model.addAttribute( "user_study", user_study );
		}
		return "userBaseInfor/userStudyEdit";
	}

	//教育经历提交(增加、修改)
	@RequestMapping(value = "/userStudyUpdate", method = RequestMethod.POST)
	@ResponseBody
	public String userStudyUpdate( HttpServletRequest request, @ModelAttribute
			UserStudy entity )
	{
		JsonObject jsonResponse = new JsonObject();
		int result = 0;// 0:fail;1:success
		String msg = "Failed to %s this user_study";
		String id = request.getParameter( "id" );
		try
		{
			if( ( id == null ) || ( id.length() < 1 ) )
			{
				result = service.user_studyInsert( entity ) ? 1 : 0;
			}
			else
			{
				result = service.user_studyUpdate( entity ) ? 1 : 0;
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
	
	//通过user_study.id删除教育经历单条信息
	@RequestMapping(value = "userStudyDelete", method = RequestMethod.POST)
	@ResponseBody
	public String userStudyDelete( HttpServletRequest request, Model model )
	{
		JsonObject jsonResponse = new JsonObject();
		String Id = request.getParameter( "id" );
		int result = 0;// 0:fail;1:success
		String msg = "Failed to delete this user_study!";
		if( Id != null )
		{
		
			result =  service.deleteuser_study(Id)? 1 : 0;
			msg = "You have successfully DELETED this user_study.";
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
