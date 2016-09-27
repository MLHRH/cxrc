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
import com.jfn.entity.JcqnDocTreatise;
import com.jfn.entity.User;
import com.jfn.entity.UserReport;
import com.jfn.service.AccountManager;
import com.jfn.service.UserReportService;
import com.jfn.service.UserService;

import net.sf.json.JSONArray;


/**
 * @create-time 2014-8-24 下午5:56:02
 * @author 佟德慧
 * @remarks 无
 */
@Controller
@RequestMapping("/")
public class UserReportController
{
	@Autowired
	private UserReportService service;
	@Autowired
	private UserService userservice;
	@Autowired
	private AccountManager accountManager;


	@RequestMapping(value = "/userReport", method = RequestMethod.GET)
	public String userReport(HttpServletRequest request, Model model) {
		return "userBaseInfor/userReport";
	}
	
	@RequestMapping(value = "/userReportList", method = RequestMethod.GET)
	@ResponseBody
	public String userReportList( HttpServletRequest request, Model model )
	{
		String userId = request.getParameter("userId");
		User user = userservice.getById(userId);
		List<JcqnDocTreatise> list = service.getAllByUserId(user.getId().toString());
		 JSONArray jsonArray = JSONArray.fromObject(list);  
		return jsonArray.toString();
	}
	
	@RequestMapping(value = "/userReportEdit", method = RequestMethod.GET)
	public String userReportEdit(HttpServletRequest request, Model model) {
		String id = request.getParameter( "id" );
		if( ( id != null ) && ( id.length() >=1 ))
		{
			JcqnDocTreatise user_report = service.getById( id );
			model.addAttribute( "user_report", user_report );
		}
		return "userBaseInfor/userReportEdit";
	}
	

	//著作、论文及重要技术报告提交(增加、修改)
	@RequestMapping(value = "/userReportUpdate", method = RequestMethod.POST)
	@ResponseBody
	public String userReportUpdate( HttpServletRequest request, @ModelAttribute
			JcqnDocTreatise entity )
	{
		JsonObject jsonResponse = new JsonObject();
		int result = 0;// 0:fail;1:success
		String msg = "Failed to %s this user_report";
		String id = request.getParameter( "id" );
		try
		{
			if( ( id == null ) || ( id.length() < 1 ) )
			{
				result = service.user_reportInsert( entity ) ? 1 : 0;
			}
			else
			{
				result = service.user_reportUpdate( entity ) ? 1 : 0;
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
	

	@RequestMapping(value = "userReportDelete", method = RequestMethod.POST)
	@ResponseBody
	public String userReportDelete( HttpServletRequest request, Model model )
	{
		JsonObject jsonResponse = new JsonObject();
		String Id = request.getParameter( "id" );
		int result = 0;// 0:fail;1:success
		String msg = "Failed to delete this user_report!";
		if( Id != null )
		{
		
			result =  service.deleteuser_report(Id)? 1 : 0;
			msg = "You have successfully DELETED this user_report.";
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
