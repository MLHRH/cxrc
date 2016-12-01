package com.jfn.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.modules.security.springsecurity.SpringSecurityUtils;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.jfn.entity.ExpertUser;
import com.jfn.entity.User;
import com.jfn.service.AccountManager;
import com.jfn.service.BodyService;
import com.jfn.service.ExpertBaseInforService;
import com.jfn.service.ExpertUserService;
import com.jfn.service.UserService;
@Controller
public class ExpertBaseController {
	@Autowired
	private AccountManager accountManager;
	@Autowired
	private ExpertBaseInforService expertbaseinforservice ;
	@Autowired
	private UserService service;
	@Autowired
	private BodyService bodyservice;
	@Autowired
	private  ExpertUserService expertUserService;
//	@RequestMapping(value = "expertUserBase", method = RequestMethod.GET)
//	public String bodyManger(HttpServletRequest request, Model model) {
//		return "userBaseInfor/expertUserBase";
//	}
	@ResponseBody
	@RequestMapping(value = "/expertBase", method = RequestMethod.GET)
	public String userBase(HttpServletRequest request) {
		String userId = request.getParameter("userId");
		User user = accountManager.findUserByLoginName(SpringSecurityUtils.getCurrentUserName());
		// ExpertBaseInfor userbaseinfor =
		// expertbaseinforservice.getByUserId(user.getId().toString());
		ExpertUser expertUser = expertUserService.getByUserId(user.getId());
		List<Object> list =new ArrayList<Object>();
		list.add(user);
		list.add(expertUser);
	
		Gson gson = new Gson();
        
		return gson.toJson(list);
	}
	@RequestMapping(value = "/userEdit", method = RequestMethod.GET)
	public String edit(HttpServletRequest request, Model model) {
		String userId = request.getParameter("id");
		if (userId != null) {
			User user = service.getById(userId);
			model.addAttribute("user", user);
		}
		return "body/userEdit";
	}

	@RequestMapping(value = "/baseEdit", method = RequestMethod.POST)
	@ResponseBody
	public String ExperbaseUpdate(String data, HttpServletRequest request) {
		JsonObject jsonResponse = new JsonObject();
		int user_id = (Integer) request.getSession().getAttribute("user_id");
		ExpertUser expertUser = JSON.parseObject(data, ExpertUser.class);
		expertUser.setUser_id(user_id);
		int result = 0;
		try {
			if (expertUserService.getByUserId(user_id).getUser_id() != null) {
				result = expertUserService.updateExpert(expertUser) ? 1 : 0;
			} else {
				expertUser.setGroup_id(1);
				result = expertUserService.insertExpert(expertUser) ? 1 : 0;
			}

		} catch (Exception e) {
			System.err.println(e);
			result = 0;
		}
		jsonResponse.addProperty("result", result);
		return jsonResponse.toString();

	}

	@RequestMapping(value = "/expertBaseinfo", method = RequestMethod.GET)
	public String list(HttpServletRequest request, Model model) {

		User user = accountManager.findUserByLoginName(SpringSecurityUtils.getCurrentUserName());
		
		Integer user_id = user.getId();
	
		String infoType = request.getParameter("bt");
		
		if (infoType == null) {
			infoType = "base";
	}
		if (user == null || user.getId() == null) {
			model.addAttribute("infoType", infoType);
			return "userBaseInfor/expertBaseinfo";		}
	if (infoType.equals("base")) {

			model.addAttribute("bodyList", bodyservice.getAll());
	}
		model.addAttribute("user", user);

		model.addAttribute("infoType", infoType);
		return "userBaseInfor/expertBaseinfo";
	}

}
