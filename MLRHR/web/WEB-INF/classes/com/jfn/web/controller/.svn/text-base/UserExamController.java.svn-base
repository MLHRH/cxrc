package com.jfn.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.modules.security.springsecurity.SpringSecurityUtils;

import com.google.gson.JsonObject;
import com.jfn.entity.UserExam;
import com.jfn.entity.User;
import com.jfn.service.AccountManager;
import com.jfn.service.UserExamService;


/**
 * @create-time 2014-8-24 下午5:56:02
 * @author 佟德慧
 * @remarks 无
 */
@Controller
@RequestMapping("/")
public class UserExamController
{
	@Autowired
	private UserExamService service;

	
	@Autowired
	private AccountManager accountManager;
	

	@RequestMapping(value = "/userExam", method = RequestMethod.GET)
	public String userExam(HttpServletRequest request, Model model) {
		return "userBaseInfor/userExam";
	}
	
	@RequestMapping(value = "/userExamList", method = RequestMethod.GET)
	@ResponseBody
	public String userExamList(HttpServletRequest request, Model model )
	{
		String userId = request.getParameter("userId");
		List<UserExam> list = service.getAllByUserId(userId);
		 JSONArray jsonArray = JSONArray.fromObject(list);  
		return jsonArray.toString();
	}
	
	@RequestMapping(value = "/userExamEdit", method = RequestMethod.GET)
	public String userExamEdit(HttpServletRequest request, Model model) {
		String id = request.getParameter( "id" );
		if( ( id != null ) && ( id.length() >=1 ))
		{
			UserExam user_exam = service.getById( id );
			model.addAttribute( "user_exam", user_exam );
		}
		return "userBaseInfor/userExamEdit";
	}
	//考试经历提交(增加、修改)
	@RequestMapping(value = "/userExamUpdate", method = RequestMethod.POST)
	@ResponseBody
	public String userExamUpdate( HttpServletRequest request, @ModelAttribute
			UserExam entity )
	{
		JsonObject jsonResponse = new JsonObject();
		int result = 0;// 0:fail;1:success
		String msg = "Failed to %s this user_exam";
		String id = request.getParameter( "id" );
		try
		{
			if( ( id == null ) || ( id.length() < 1 ) )
			{
				result = service.user_examInsert( entity ) ? 1 : 0;
			}
			else
			{
				result = service.user_examUpdate( entity ) ? 1 : 0;
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
	
	//通过user_exam.id删除考试经历单条信息
	@RequestMapping(value = "userExamDelete", method = RequestMethod.POST)
	@ResponseBody
	public String userExamDelete( HttpServletRequest request, Model model )
	{
		JsonObject jsonResponse = new JsonObject();
		String Id = request.getParameter( "id" );
		int result = 0;// 0:fail;1:success
		String msg = "Failed to delete this user_exam!";
		if( Id != null )
		{
		
			result =  service.deleteuser_exam(Id)? 1 : 0;
			msg = "You have successfully DELETED this user_exam.";
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
