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
import com.jfn.entity.UserSkill;
import com.jfn.entity.User;
import com.jfn.service.AccountManager;
import com.jfn.service.UserSkillService;
import com.jfn.service.UserService;


/**
 * @create-time 2014-8-24 下午5:56:02
 * @author 佟德慧
 * @remarks 无
 */
@Controller
@RequestMapping("/")
public class UserSkillController
{
	@Autowired
	private UserSkillService service;
	@Autowired
	private UserService userservice;
	@Autowired
	private AccountManager accountManager;
	

	@RequestMapping(value = "/userSkill", method = RequestMethod.GET)
	public String userSkill(HttpServletRequest request, Model model) {
		return "userBaseInfor/userSkill";
	}
	
	@RequestMapping(value = "/userSkillList", method = RequestMethod.GET)
	@ResponseBody
	public String userSkillList( HttpServletRequest request, Model model )
	{
		String userId = request.getParameter("userId");
		User user = userservice.getById(userId);
		List<UserSkill> list = service.getAllByUserId(user.getId().toString());
		 JSONArray jsonArray = JSONArray.fromObject(list);  
		return jsonArray.toString();
	}
	
	@RequestMapping(value = "/userSkillEdit", method = RequestMethod.GET)
	public String userSkillEdit(HttpServletRequest request, Model model) {
		String id = request.getParameter( "id" );
		if( ( id != null ) && ( id.length() >=1 ))
		{
			UserSkill user_skill = service.getById( id );
			model.addAttribute( "user_skill", user_skill );
		}
		return "userBaseInfor/userSkillEdit";
	}
	

	

	//专业技术工作业绩提交(增加、修改)
	@RequestMapping(value = "/userSkillUpdate", method = RequestMethod.POST)
	@ResponseBody
	public String userSkillUpdate( HttpServletRequest request, @ModelAttribute
			UserSkill entity )
	{
		JsonObject jsonResponse = new JsonObject();
		int result = 0;// 0:fail;1:success
		String msg = "Failed to %s this user_skill";
		String id = request.getParameter( "id" );
		try
		{
			if( ( id == null ) || ( id.length() < 1 ) )
			{
				result = service.user_skillInsert( entity ) ? 1 : 0;
			}
			else
			{
				result = service.user_skillUpdate( entity ) ? 1 : 0;
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
	
	//通过user_skill.id删除专业技术工作业绩单条信息
	@RequestMapping(value = "userSkillDelete", method = RequestMethod.POST)
	@ResponseBody
	public String userSkillDelete( HttpServletRequest request, Model model )
	{
		JsonObject jsonResponse = new JsonObject();
		String Id = request.getParameter( "id" );
		int result = 0;// 0:fail;1:success
		String msg = "Failed to delete this user_skill!";
		if( Id != null )
		{
		
			result =  service.deleteuser_skill(Id)? 1 : 0;
			msg = "You have successfully DELETED this user_skill.";
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
