package com.jfn.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonObject;
import com.jfn.entity.ExpertScore;
import com.jfn.entity.JcqnDoc04;
import com.jfn.service.ExpertScoreService;
@Controller
@RequestMapping("/")
public class ExpertScoreController {
	@Autowired
	private ExpertScoreService expertScoreService ;
	//获取信息
	@RequestMapping(value="/jcqnDoc07Init", method =RequestMethod.GET)
	@ResponseBody
	public ExpertScore jcqnDoc07Init(HttpServletRequest request){
//		String userId = request.getParameter("user_id");
		String expertId = request.getParameter("user_id");
//		System.err.println("-----------"+userId);
		ExpertScore expertScore = expertScoreService.getByExpertId01(Integer.parseInt(expertId));
//		Gson gson = new Gson();
		System.err.println(expertScore);
//		return gson.toJson(jcqn);	
		return expertScore;
	}
	
	//添加、更新操作记录
	@RequestMapping(value="/jcqnDoc07Update", method =RequestMethod.POST)
	@ResponseBody
	public String jcqnDoc04Update(ExpertScore expertScore,HttpServletRequest request){
		JsonObject jsonResponse = new JsonObject();
		int expert_id =(Integer)request.getSession().getAttribute("user_id");
		expertScore.setExpert_id(expert_id);
		
		int result = 0;
		try {
			if( expertScoreService.getByExpertId01(expert_id).getExpert_score() != null){
			result = expertScoreService.update01(expertScore)? 1:0;
			System.err.println(result);
			}
			
			else{
				result =expertScoreService.insert01(expertScore)?1:0; 
			}
			
		} catch (Exception e) {
			result = 0;
		}
		jsonResponse.addProperty("result", result);
		return jsonResponse.toString();
		
	
	}
}
