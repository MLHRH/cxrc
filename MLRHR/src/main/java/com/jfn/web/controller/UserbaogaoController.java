package com.jfn.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonObject;
import com.jfn.entity.JcqnDocReport;
import com.jfn.entity.User;
import com.jfn.service.AccountManager;
import com.jfn.service.UserBaogaoService;
import com.jfn.service.UserService;

import net.sf.json.JSONArray;


/**
 * @create-time 2014-8-24 下午5:56:02
 * @author 佟德慧
 * @remarks 无
 */
@Controller
@RequestMapping("/")
public class UserbaogaoController
{
	@Autowired
	private UserBaogaoService service;
	@Autowired
	private UserService userservice;
	@Autowired
	private AccountManager accountManager;
	
	@RequestMapping(value = "/userBaogao", method = RequestMethod.GET)
	public String userBaogao(HttpServletRequest request, Model model) {
		return "userBaseInfor/userBaogao";
	}
	
	@RequestMapping(value = "/userBaogaoList", method = RequestMethod.GET)
	@ResponseBody
	public String userBaogaoList( HttpServletRequest request, Model model )
	{
		String userId = request.getParameter("userId");
		User user = userservice.getById(userId);
		List<JcqnDocReport> list = service.getAllByUserId(user.getId().toString());
		 JSONArray jsonArray = JSONArray.fromObject(list);  
		return jsonArray.toString();
	}
	
	@RequestMapping(value = "/userBaogaoEdit", method = RequestMethod.GET)
	public String userBaogaoEdit(HttpServletRequest request, Model model) {
		String id = request.getParameter( "id" );
		if( ( id != null ) && ( id.length() >=1 ))
		{
			JcqnDocReport user_study = service.getById( id );
			model.addAttribute( "user_study", user_study );
		}
		return "userBaseInfor/userBaogaoEdit";
	}

	//教育经历提交(增加、修改)
	@RequestMapping(value = "/userBaogaoUpdate", method = RequestMethod.POST)
	@ResponseBody
	public String userBaogaoUpdate( HttpServletRequest request, @ModelAttribute
			JcqnDocReport entity )
	{
		JsonObject jsonResponse = new JsonObject();
		int result = 0;// 0:fail;1:success
		String msg = "Failed to %s this user_Baogao";
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
	@RequestMapping(value = "userBaogaoDelete", method = RequestMethod.POST)
	@ResponseBody
	public String JcqnDocReportDelete( HttpServletRequest request, Model model )
	{
		JsonObject jsonResponse = new JsonObject();
		String Id = request.getParameter( "id" );
		int result = 0;// 0:fail;1:success
		String msg = "Failed to delete this user_Baogao!";
		if( Id != null )
		{
		
			result =  service.deleteuser_study(Id)? 1 : 0;
			msg = "You have successfully DELETED this user_Baogao.";
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
