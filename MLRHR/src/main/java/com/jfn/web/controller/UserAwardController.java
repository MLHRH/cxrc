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
import com.jfn.entity.JcqnDocPrize;
import com.jfn.entity.User;
import com.jfn.service.AccountManager;
import com.jfn.service.UserAwardService;
import com.jfn.service.UserService;

import net.sf.json.JSONArray;


/**
 * @create-time 2014-8-24 下午5:56:02
 * @author 佟德慧
 * @remarks 无
 */
@Controller
@RequestMapping("/")
public class UserAwardController
{
	@Autowired
	private UserAwardService service;
	@Autowired
	private UserService userservice;
	@Autowired
	private AccountManager accountManager;


	@RequestMapping(value = "/userAward", method = RequestMethod.GET)
	public String userAward(HttpServletRequest request, Model model) {
		return "userBaseInfor/userAward";
	}
	
	@RequestMapping(value = "/userAwardList", method = RequestMethod.GET)
	@ResponseBody
	public String userAwardList( HttpServletRequest request, Model model )
	{
		String userId = request.getParameter("userId");
		User user = userservice.getById(userId);
		List<JcqnDocPrize> list = service.getAllByUserId(user.getId().toString());
		 JSONArray jsonArray = JSONArray.fromObject(list);  
		return jsonArray.toString();
	}
	
	@RequestMapping(value = "/userAwardEdit", method = RequestMethod.GET)
	public String userAwardEdit(HttpServletRequest request, Model model) {
		String id = request.getParameter( "id" );
		if( ( id != null ) && ( id.length() >=1 ))
		{
			JcqnDocPrize user_award = service.getById( id );
			model.addAttribute( "user_award", user_award );
		}
		return "userBaseInfor/userAwardEdit";
	}
	

	@RequestMapping(value = "/userAwardUpdate", method = RequestMethod.POST)
	@ResponseBody
	public String userAwardUpdate( HttpServletRequest request, @ModelAttribute
			JcqnDocPrize entity )
	{
		JsonObject jsonResponse = new JsonObject();
		int result = 0;// 0:fail;1:success
		String msg = "Failed to %s this user_award";
		String id = request.getParameter( "id" );
		try
		{
			if( ( id == null ) || ( id.length() < 1 ) )
			{
				result = service.user_awardInsert( entity ) ? 1 : 0;
			}
			else
			{
				result = service.user_awardUpdate( entity ) ? 1 : 0;
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
	

	@RequestMapping(value = "userAwardDelete", method = RequestMethod.POST)
	@ResponseBody
	public String userAwardDelete( HttpServletRequest request, Model model )
	{
		JsonObject jsonResponse = new JsonObject();
		String Id = request.getParameter( "id" );
		int result = 0;// 0:fail;1:success
		String msg = "Failed to delete this user_award!";
		if( Id != null )
		{
		
			result =  service.deleteuser_award(Id)? 1 : 0;
			msg = "You have successfully DELETED this user_award.";
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
