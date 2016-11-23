package com.jfn.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonObject;
import com.jfn.entity.ExpertScore;
import com.jfn.service.ExpertScoreService;

@Controller
@RequestMapping("/")
public class ExpertScoreController {
	@Autowired
	private ExpertScoreService expertScoreService;

	// 获取信息
	@RequestMapping(value = "/jcqnDoc07Init", method = RequestMethod.GET)
	@ResponseBody
	public ExpertScore jcqnDoc07Init(HttpServletRequest request) {
		// String userId = request.getParameter("user_id");
		String expertId = request.getParameter("expert_id");
		String userId = request.getParameter("userid");
		System.err.println("-----------" + expertId);
		ExpertScore expertScore = expertScoreService.getByExpertId01(Integer.parseInt(expertId),Integer.parseInt(userId));
		// Gson gson = new Gson();
		System.err.println(expertScore);
		// return gson.toJson(jcqn);
		return expertScore;
	}

	// 添加、更新操作记录
	@RequestMapping(value = "/jcqnDoc07Update", method = RequestMethod.POST)
	@ResponseBody
	public String jcqnDoc07Update(ExpertScore expertScore, HttpServletRequest request) {
		JsonObject jsonResponse = new JsonObject();
		int expert_id = (Integer) request.getSession().getAttribute("user_id");
		int user_id = (Integer) request.getSession().getAttribute("userId");
		expertScore.setExpert_id(expert_id);

		System.err.println("score="+expertScoreService.getByExpertId01(expert_id ,user_id).getExpert_score());
		System.err.println("pingyu="+expertScoreService.getByExpertId01(expert_id,user_id).getExpert_pingyu());

		int result = 0;
		try {
			if (expertScoreService.getByExpertId01(expert_id,user_id).getExpert_score() != null && expertScoreService.getByExpertId01(expert_id,user_id).getExpert_pingyu() !=null) {
				result = expertScoreService.update01(expertScore) ? 1 : 0;
				System.err.println(result);
			}

			else {
				result = expertScoreService.insert01(expertScore) ? 1 : 0;
			}

		} catch (Exception e) {
			result = 0;
		}
		jsonResponse.addProperty("result", result);
		return jsonResponse.toString();

	}
}
