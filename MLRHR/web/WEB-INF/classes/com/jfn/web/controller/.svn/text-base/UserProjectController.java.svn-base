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
import com.jfn.entity.UserProject;
import com.jfn.entity.User;
import com.jfn.service.AccountManager;
import com.jfn.service.UserProjectService;
import com.jfn.service.UserService;


/**
 * @create-time 2014-8-24 下午5:56:02
 * @author 佟德慧
 * @remarks 无
 */
@Controller
@RequestMapping("/")
public class UserProjectController
{
	@Autowired
	private UserProjectService service;
	@Autowired
	private UserService userservice;
	@Autowired
	private AccountManager accountManager;
	

	@RequestMapping(value = "/userProject", method = RequestMethod.GET)
	public String userProject(HttpServletRequest request, Model model) {
		return "userBaseInfor/userProject";
	}
	
	@RequestMapping(value = "/userProjectList", method = RequestMethod.GET)
	@ResponseBody
	public String userProjectList( HttpServletRequest request, Model model )
	{
		String userId = request.getParameter("userId");
		User user = userservice.getById(userId);
		List<UserProject> list = service.getAllByUserId(user.getId().toString());
		 JSONArray jsonArray = JSONArray.fromObject(list);  
		return jsonArray.toString();
	}
	
	@RequestMapping(value = "/userProjectEdit", method = RequestMethod.GET)
	public String userProjectEdit(HttpServletRequest request, Model model) {
		String id = request.getParameter( "id" );
		if( ( id != null ) && ( id.length() >=1 ))
		{
			UserProject user_project = service.getById( id );
			model.addAttribute( "user_project", user_project );
		}
		return "userBaseInfor/userProjectEdit";
	}
	

	

	//专业技术工作业绩提交(增加、修改)
	@RequestMapping(value = "/userProjectUpdate", method = RequestMethod.POST)
	@ResponseBody
	public String userProjectUpdate( HttpServletRequest request, @ModelAttribute
			UserProject entity )
	{
		JsonObject jsonResponse = new JsonObject();
		int result = 0;// 0:fail;1:success
		String msg = "Failed to %s this user_project";
		String id = request.getParameter( "id" );
		try
		{
			if( ( id == null ) || ( id.length() < 1 ) )
			{
				result = service.user_projectInsert( entity ) ? 1 : 0;
			}
			else
			{
				result = service.user_projectUpdate( entity ) ? 1 : 0;
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
	
	//通过user_project.id删除专业技术工作业绩单条信息
	@RequestMapping(value = "userProjectDelete", method = RequestMethod.POST)
	@ResponseBody
	public String userProjectDelete( HttpServletRequest request, Model model )
	{
		JsonObject jsonResponse = new JsonObject();
		String Id = request.getParameter( "id" );
		int result = 0;// 0:fail;1:success
		String msg = "Failed to delete this user_project!";
		if( Id != null )
		{
		
			result =  service.deleteuser_project(Id)? 1 : 0;
			msg = "You have successfully DELETED this user_project.";
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
