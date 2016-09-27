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
import com.jfn.entity.KjljDoc01;
import com.jfn.entity.KjljDoc03;
import com.jfn.entity.KjljDoc04;
import com.jfn.entity.KjljDoc05;
import com.jfn.entity.UserPeixun;
import com.jfn.entity.UserWork;
import com.jfn.service.KjljDocService;
import com.jfn.service.UserPeixunService;
import com.jfn.service.UserWorkService;
@Controller
@RequestMapping("/")
public class KjljDocController {
	@Autowired
	private KjljDocService kjljdoc01servive;
	
	
	@Autowired
	private UserPeixunService ups;
	@Autowired
	private UserWorkService uws;
	//更新操作记录
			@RequestMapping(value="/kjljDoc01Update", method =RequestMethod.POST)
			@ResponseBody
			public String kjljDoc01Update(KjljDoc01 kjlj,HttpServletRequest request){
				JsonObject jsonResponse = new JsonObject();
				int user_id =(Integer)request.getSession().getAttribute("user_id");
				kjlj.setUser_id(user_id);
				System.err.println(kjlj.getAddresses());
				int result = 0;
				try {
					if(kjljdoc01servive.getByUserId01(user_id).getName() != null){
					result = kjljdoc01servive.update01(kjlj)? 1:0;}
					else{
						result =kjljdoc01servive.insert01(kjlj)?1:0; 
					}
					
				} catch (Exception e) {
					System.err.println(e);
					result = 0;
				}
				jsonResponse.addProperty("result", result);
				return jsonResponse.toString();
				
				
			}
			@RequestMapping(value="/kjljDoc01Init",method=RequestMethod.GET)
			@ResponseBody
			public String kjljDoc01Init(HttpServletRequest request){
				String userId = request.getParameter("userId");

				List<Object> list =new ArrayList<Object>();
				KjljDoc01 kjlj = kjljdoc01servive.getByUserId01(Integer.parseInt(userId));

				ArrayList<UserPeixun> userPeixuns=new ArrayList<UserPeixun>();
			    for(UserPeixun study:ups.getAllByUserId(userId)) {
			    	userPeixuns.add(study);
			    }
			ArrayList<UserWork> work = new ArrayList<UserWork>();
			for (UserWork wor : uws.getAllByUserId(userId)) {
				work.add(wor);
			}

			list.add(userPeixuns);
			list.add(kjlj);
			list.add(work);
				Gson gson = new Gson();

			return gson.toJson(list);

			}
	
	
	
	
	//更新操作记录
		@RequestMapping(value="/kjljDoc02Update", method =RequestMethod.POST)
		@ResponseBody
		public String kjljDoc02Update(String project,HttpServletRequest request){
			List<Object> jsonResponse = new ArrayList<Object>();
			
			int user_id =(Integer)request.getSession().getAttribute("user_id");
			System.err.println("----------"+user_id);
//			List<kjljDocProject> list = JSONAr
			//kjljDocProject result = null;
			try {
				if((kjljdoc01servive.getByUserId02(user_id)).size() != 0){
			  //  result=kjljdoc02servive.update( kjljDocProject, kjljDocPrize,kjljDocThesis, kjljDocPatent, kjljDocReport, kjljDocTreatise);
			    		}
			    		
//				result = kjljdoc02servive.update(kjljDocProject)? 1:0;}
				else{
//					result =kjljdoc02servive.insert(kjljDocProject, kjljDocPrize, kjljDocThesis, kjljDocPatent, kjljDocReport, kjljDocTreatise)?1:0; 
				}
				
			} catch (Exception e) {
				//result = null;
			}
			//jsonResponse.add(result);
			return jsonResponse.toString();
			
			
		}
		@RequestMapping(value="/kjljDoc02Init",method=RequestMethod.GET)
		@ResponseBody
		public String kjljDoc02Init(HttpServletRequest request){
			String userId = request.getParameter("userId");
			System.err.println("-----------"+userId);
			List<Object> kjljDocProjects = kjljdoc01servive.getByUserId02(Integer.parseInt(userId));
			Gson gson = new Gson();
			for(int i=0;i<kjljDocProjects.size();i++){
				System.err.println(gson.toJson(kjljDocProjects.get(i)).toString());
			}
			System.err.println(gson.toJson(kjljDocProjects).toString());
			return gson.toJson(kjljDocProjects);		
		}

		
		//获取信息
				@RequestMapping(value="/kjljDoc03Init", method =RequestMethod.GET)
				@ResponseBody
				public KjljDoc03 kjljDoc03Init(HttpServletRequest request){
					String userId = request.getParameter("userId");
					System.err.println("-----------"+userId);
					KjljDoc03 kjlj = kjljdoc01servive.getByUserId03(Integer.parseInt(userId));
//					Gson gson = new Gson();
					System.err.println(kjlj);
//					return gson.toJson(kjlj);	
					return kjlj;
				}
				
				//添加、更新操作记录
				@RequestMapping(value="/kjljDoc03Update", method =RequestMethod.POST)
				@ResponseBody
				public String kjljDoc03Update(KjljDoc03 kjljDoc03,HttpServletRequest request){
					JsonObject jsonResponse = new JsonObject();
					int user_id =(Integer)request.getSession().getAttribute("user_id");
					kjljDoc03.setUser_id(user_id);
					
					int result = 0;
					try {
						if( kjljdoc01servive.getByUserId03(user_id).getSelfAssessment() != null){
						result = kjljdoc01servive.update03(kjljDoc03)? 1:0;
						System.err.println(result);
						}
						
						else{
							result =kjljdoc01servive.insert03(kjljDoc03)?1:0; 
						}
						
					} catch (Exception e) {
						result = 0;
					}
					jsonResponse.addProperty("result", result);
					return jsonResponse.toString();
					
				
				}
				
				
				//获取信息
				@RequestMapping(value="/kjljDoc04Init", method =RequestMethod.GET)
				@ResponseBody
				public KjljDoc04 kjljDoc04Init(HttpServletRequest request){
					String userId = request.getParameter("userId");
					System.err.println("-----------"+userId);
					KjljDoc04 kjlj = kjljdoc01servive.getByUserId04(Integer.parseInt(userId));
//					Gson gson = new Gson();
					System.err.println(kjlj);
//					return gson.toJson(kjlj);	
					return kjlj;
				}
				
				//添加、更新操作记录
				@RequestMapping(value="/kjljDoc04Update", method =RequestMethod.POST)
				@ResponseBody
				public String kjljDoc04Update(KjljDoc04 kjljDoc04,HttpServletRequest request){
					JsonObject jsonResponse = new JsonObject();
					int user_id =(Integer)request.getSession().getAttribute("user_id");
					kjljDoc04.setUser_id(user_id);
					
					int result = 0;
					try {
						if( kjljdoc01servive.getByUserId04(user_id).getFuturePlans() != null){
						result = kjljdoc01servive.update04(kjljDoc04)? 1:0;
						System.err.println(result);
						}
						
						else{
							result =kjljdoc01servive.insert04(kjljDoc04)?1:0; 
						}
						
					} catch (Exception e) {
						result = 0;
					}
					jsonResponse.addProperty("result", result);
					return jsonResponse.toString();
					
				
				}
				
				
				//获取信息
				@RequestMapping(value="/kjljDoc05Init", method =RequestMethod.GET)
				@ResponseBody
				public KjljDoc05 kjljDoc05Init(HttpServletRequest request){
					String userId = request.getParameter("userId");
					System.err.println("-----------"+userId);
					KjljDoc05 kjlj = kjljdoc01servive.getByUserId05(Integer.parseInt(userId));
//					Gson gson = new Gson();
					System.err.println(kjlj);
//					return gson.toJson(kjlj);	
					return kjlj;
				}
				
				//添加、更新操作记录
				@RequestMapping(value="/kjljDoc05Update", method =RequestMethod.POST)
				@ResponseBody
				public String kjljDoc05Update(KjljDoc05 kjljDoc05,HttpServletRequest request){
					JsonObject jsonResponse = new JsonObject();
					int user_id =(Integer)request.getSession().getAttribute("user_id");
					kjljDoc05.setUser_id(user_id);
					
					int result = 0;
					try {
						if( kjljdoc01servive.getByUserId05(user_id).getNeedsRelevanceSupport()!= null){
						result = kjljdoc01servive.update05(kjljDoc05)? 1:0;
						System.err.println(result);
						}
						
						else{
							result =kjljdoc01servive.insert05(kjljDoc05)?1:0; 
						}
						
					} catch (Exception e) {
						result = 0;
					}
					jsonResponse.addProperty("result", result);
					return jsonResponse.toString();
					
				
				}

}
