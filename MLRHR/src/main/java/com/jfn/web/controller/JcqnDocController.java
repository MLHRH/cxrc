package com.jfn.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.jfn.entity.JcqnDoc01;
import com.jfn.entity.JcqnDoc03;
import com.jfn.entity.JcqnDoc04;
import com.jfn.entity.JcqnDoc05;
import com.jfn.service.JcqnDocService;
@Controller
@RequestMapping("/")
public class JcqnDocController {
	@Autowired
	private JcqnDocService jcqndoc01servive;
	//更新操作记录
	@RequestMapping(value="/jcqnDoc01Update", method =RequestMethod.POST)
	@ResponseBody
	public String jcqnDoc01Update(JcqnDoc01 jcqn,HttpServletRequest request){
		JsonObject jsonResponse = new JsonObject();
		int user_id =(Integer)request.getSession().getAttribute("user_id");
		jcqn.setUser_id(user_id);
		System.err.println(jcqn.getAddresses());
		int result = 0;
		try {
			if(jcqndoc01servive.getByUserId01(user_id).get(0).getName() != null){
			result = jcqndoc01servive.update01(jcqn)? 1:0;}
			else{
				result =jcqndoc01servive.insert01(jcqn)?1:0; 
			}
			
		} catch (Exception e) {
			result = 0;
		}
		jsonResponse.addProperty("result", result);
		return jsonResponse.toString();
		
		
	}
	@RequestMapping(value="/jcqnDoc01Init",method=RequestMethod.GET)
	@ResponseBody
	public String jcqnDoc01Init(HttpServletRequest request){
		String userId = request.getParameter("userId");
		System.err.println("-----------"+userId);
		List<JcqnDoc01> jcqn = jcqndoc01servive.getByUserId01(Integer.parseInt(userId));
		Gson gson = new Gson();
		System.err.println(gson.toJson(jcqn).toString());
		return gson.toJson(jcqn);		
	}
	
	
	
	//更新操作记录
		@RequestMapping(value="/jcqnDoc02Update", method =RequestMethod.POST)
		@ResponseBody
		public String jcqnDoc02Update(String project,HttpServletRequest request){
			List<Object> jsonResponse = new ArrayList<Object>();
			
			int user_id =(Integer)request.getSession().getAttribute("user_id");
			System.err.println("----------"+user_id);
//			List<JcqnDocProject> list = JSONAr
			//JcqnDocProject result = null;
			try {
				if((jcqndoc01servive.getByUserId01(user_id)).size() != 0){
			  //  result=jcqndoc02servive.update( jcqnDocProject, jcqnDocPrize,jcqnDocThesis, jcqnDocPatent, jcqnDocReport, jcqnDocTreatise);
			    		}
			    		
//				result = jcqndoc02servive.update(jcqnDocProject)? 1:0;}
				else{
//					result =jcqndoc02servive.insert(jcqnDocProject, jcqnDocPrize, jcqnDocThesis, jcqnDocPatent, jcqnDocReport, jcqnDocTreatise)?1:0; 
				}
				
			} catch (Exception e) {
				//result = null;
			}
			//jsonResponse.add(result);
			return jsonResponse.toString();
			
			
		}
		@RequestMapping(value="/jcqnDoc02Init",method=RequestMethod.GET)
		@ResponseBody
		public String jcqnDoc02Init(HttpServletRequest request){
			String userId = request.getParameter("userId");
			System.err.println("-----------"+userId);
			List<Object> jcqnDocProjects = jcqndoc01servive.getByUserId02(Integer.parseInt(userId));
			Gson gson = new Gson();
			for(int i=0;i<jcqnDocProjects.size();i++){
				System.err.println(gson.toJson(jcqnDocProjects.get(i)).toString());
			}
			System.err.println(gson.toJson(jcqnDocProjects).toString());
			return gson.toJson(jcqnDocProjects);		
		}

	

	//获取信息
		@RequestMapping(value="/jcqnDoc03Init", method =RequestMethod.GET)
		@ResponseBody
		public JcqnDoc03 jcqnDoc03Init(HttpServletRequest request){
			String userId = request.getParameter("userId");
			System.err.println("-----------"+userId);
			JcqnDoc03 jcqn = jcqndoc01servive.getByUserId03(Integer.parseInt(userId));
//			Gson gson = new Gson();
			System.err.println(jcqn);
//			return gson.toJson(jcqn);	
			return jcqn;
		}
		
		//添加、更新操作记录
		@RequestMapping(value="/jcqnDoc03Update", method =RequestMethod.POST)
		@ResponseBody
		public String jcqnDoc03Update(JcqnDoc03 jcqnDoc03,HttpServletRequest request){
			JsonObject jsonResponse = new JsonObject();
			int user_id =(Integer)request.getSession().getAttribute("user_id");
			jcqnDoc03.setUser_id(user_id);
			
			int result = 0;
			try {
				if( jcqndoc01servive.getByUserId03(user_id).getSelfAssessment() != null){
				result = jcqndoc01servive.update03(jcqnDoc03)? 1:0;
				System.err.println(result);
				}
				
				else{
					result =jcqndoc01servive.insert03(jcqnDoc03)?1:0; 
				}
				
			} catch (Exception e) {
				result = 0;
			}
			jsonResponse.addProperty("result", result);
			return jsonResponse.toString();
			
		
		}
		
		
		
		
		//获取信息
				@RequestMapping(value="/jcqnDoc04Init", method =RequestMethod.GET)
				@ResponseBody
				public JcqnDoc04 jcqnDoc04Init(HttpServletRequest request){
					String userId = request.getParameter("userId");
					System.err.println("-----------"+userId);
					JcqnDoc04 jcqn = jcqndoc01servive.getByUserId04(Integer.parseInt(userId));
//					Gson gson = new Gson();
					System.err.println(jcqn);
//					return gson.toJson(jcqn);	
					return jcqn;
				}
				
				//添加、更新操作记录
				@RequestMapping(value="/jcqnDoc04Update", method =RequestMethod.POST)
				@ResponseBody
				public String jcqnDoc04Update(JcqnDoc04 jcqnDoc04,HttpServletRequest request){
					JsonObject jsonResponse = new JsonObject();
					int user_id =(Integer)request.getSession().getAttribute("user_id");
					jcqnDoc04.setUser_id(user_id);
					
					int result = 0;
					try {
						if( jcqndoc01servive.getByUserId04(user_id).getFuturePlans() != null){
						result = jcqndoc01servive.update04(jcqnDoc04)? 1:0;
						System.err.println(result);
						}
						
						else{
							result =jcqndoc01servive.insert04(jcqnDoc04)?1:0; 
						}
						
					} catch (Exception e) {
						result = 0;
					}
					jsonResponse.addProperty("result", result);
					return jsonResponse.toString();
					
				
				}

				
				//获取信息
				@RequestMapping(value="/jcqnDoc05Init", method =RequestMethod.GET)
				@ResponseBody
				public JcqnDoc05 jcqnDoc05Init(HttpServletRequest request){
					String userId = request.getParameter("userId");
					System.err.println("-----------"+userId);
					JcqnDoc05 jcqn = jcqndoc01servive.getByUserId05(Integer.parseInt(userId));
//					Gson gson = new Gson();
					System.err.println(jcqn);
//					return gson.toJson(jcqn);	
					return jcqn;
				}
				
				//添加、更新操作记录
				@RequestMapping(value="/jcqnDoc05Update", method =RequestMethod.POST)
				@ResponseBody
				public String jcqnDoc05Update(JcqnDoc05 jcqnDoc05,HttpServletRequest request){
					JsonObject jsonResponse = new JsonObject();
					int user_id =(Integer)request.getSession().getAttribute("user_id");
					jcqnDoc05.setUser_id(user_id);
					
					int result = 0;
					try {
						if( jcqndoc01servive.getByUserId05(user_id).getNeedsRelevanceSupport()!= null){
						result = jcqndoc01servive.update05(jcqnDoc05)? 1:0;
						System.err.println(result);
						}
						
						else{
							result =jcqndoc01servive.insert05(jcqnDoc05)?1:0; 
						}
						
					} catch (Exception e) {
						result = 0;
					}
					jsonResponse.addProperty("result", result);
					return jsonResponse.toString();
					
				
				}	
}