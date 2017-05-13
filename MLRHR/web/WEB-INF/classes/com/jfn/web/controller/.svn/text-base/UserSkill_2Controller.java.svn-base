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

import com.google.gson.JsonObject;
import com.jfn.entity.User;
import com.jfn.entity.UserSkill_2;
import com.jfn.service.AccountManager;
import com.jfn.service.UserService;
import com.jfn.service.UserSkill_2Service;

/**
 * @create-time 2014-8-24 下午5:56:02
 * @author 佟德慧
 * @remarks 无
 */
@Controller
@RequestMapping("/")
public class UserSkill_2Controller {
	@Autowired
	private UserSkill_2Service service;
	@Autowired
	private UserService userservice;
	@Autowired
	private AccountManager accountManager;

	@RequestMapping(value = "/userSkill_2", method = RequestMethod.GET)
	public String userSkill(HttpServletRequest request, Model model) {
		return "userBaseInfor/userSkill_2";
	}

	@RequestMapping(value = "/userSkill_2List", method = RequestMethod.GET)
	@ResponseBody
	public String userSkill_2List(HttpServletRequest request, Model model) {
		String userId = request.getParameter("userId");
		User user = userservice.getById(userId);
		List<UserSkill_2> list = service.getAllByUserId(user.getId().toString());
		JSONArray jsonArray = JSONArray.fromObject(list);
		return jsonArray.toString();
	}

	@RequestMapping(value = "/userSkill_2Edit", method = RequestMethod.GET)
	public String userSkill_2Edit(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		if ((id != null) && (id.length() >= 1)) {
			UserSkill_2 user_skill_2 = service.getById(id);
			model.addAttribute("user_skill_2", user_skill_2);
		}
		return "userBaseInfor/userSkill_2Edit";
	}

	// 专业技术工作业绩提交(增加、修改)
	@RequestMapping(value = "/userSkill_2Update", method = RequestMethod.POST)
	@ResponseBody
	public String userSkill_2Update(HttpServletRequest request, @ModelAttribute UserSkill_2 entity) {
		JsonObject jsonResponse = new JsonObject();
		int result = 0;// 0:fail;1:success
		String msg = "Failed to %s this user_skill_2";
		String id = request.getParameter("id");
		try {
			if ((id == null) || (id.length() < 1)) {
				result = service.user_skill_2Insert(entity) ? 1 : 0;
			} else {
				result = service.user_skill_2Update(entity) ? 1 : 0;
			}
		} catch (Exception e) {
			result = 0;
			msg = msg + ": " + e.getMessage();
		}
		jsonResponse.addProperty("result", result);
		jsonResponse.addProperty("msg", String.format(msg, (id == null) ? "add" : "edit"));
		return jsonResponse.toString();
	}

	// 通过user_skill_2.id删除专业技术工作业绩单条信息
	@RequestMapping(value = "userSkill_2Delete", method = RequestMethod.POST)
	@ResponseBody
	public String userSkill_2Delete(HttpServletRequest request, Model model) {
		JsonObject jsonResponse = new JsonObject();
		String Id = request.getParameter("id");
		int result = 0;// 0:fail;1:success
		String msg = "Failed to delete this user_skill_2!";
		if (Id != null) {

			result = service.deleteuser_skill_2(Id) ? 1 : 0;
			msg = "You have successfully DELETED this user_skill_2.";
		} else {
			return "404";
		}

		jsonResponse.addProperty("result", result);
		jsonResponse.addProperty("msg", msg);
		return jsonResponse.toString();

	}

}
