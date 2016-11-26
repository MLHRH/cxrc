package com.jfn.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.modules.security.springsecurity.SpringSecurityUtils;

import com.google.gson.JsonObject;
import com.jfn.entity.ExpertBaseInfor;
import com.jfn.entity.User;
import com.jfn.entity.UserBaseInfor;
import com.jfn.service.AccountManager;
import com.jfn.service.BodyService;
import com.jfn.service.ExpertBaseInforService;
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
//	@RequestMapping(value = "expertUserBase", method = RequestMethod.GET)
//	public String bodyManger(HttpServletRequest request, Model model) {
//		return "userBaseInfor/expertUserBase";
//	}
	@RequestMapping(value = "/expertBase", method = RequestMethod.GET)
	public String userBase(HttpServletRequest request, Model model) {

		User user = accountManager.findUserByLoginName(SpringSecurityUtils.getCurrentUserName());
		ExpertBaseInfor userbaseinfor = expertbaseinforservice.getByUserId(user.getId().toString());
		model.addAttribute("bodyList", bodyservice.getAll());
		model.addAttribute("user", user);
		model.addAttribute("userbaseinfor", userbaseinfor);
		return "userBaseInfor/expertUserBase";
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
	@RequestMapping(value = "/updateExpertBaseDetail", method = RequestMethod.POST)
	@ResponseBody
	public String DetailUpdate_user_base(HttpServletRequest request, @ModelAttribute ExpertBaseInfor entity) {
		JsonObject jsonResponse = new JsonObject();
		int result = 0;// 0:fail;1:success
		String msg = "Failed to %s this user";
		String id = request.getParameter("id");
		try {
			if ((id == null) || (id.length() < 1)) {
				result = expertbaseinforservice.userBaseInforInsert(entity) ? 1 : 0;
			} else {
				result = expertbaseinforservice.userBaseInforUpdateDetail(entity) ? 1 : 0;
			}
		} catch (Exception e) {
			result = 0;
			msg = msg + ": " + e.getMessage();
		}
		jsonResponse.addProperty("result", result);
		jsonResponse.addProperty("msg", String.format(msg, (id == null) ? "add" : "edit"));
		return jsonResponse.toString();
	}
	@RequestMapping(value = "/updateExpert", method = RequestMethod.POST)
	@ResponseBody
	public String updateUser(HttpServletRequest request, @ModelAttribute User entity) {
		JsonObject jsonResponse = new JsonObject();
		int result = 0;// 0:fail;1:success
		String msg = "测试 测试 Failed to %s this user";
		String id = request.getParameter("id");
		try {
			if ((id == null) || (id.length() < 1)) {
				result = service.userInsert(entity) ? 1 : 0;
			} else {
				result = service.userUpdateDetail(entity) ? 1 : 0;
			}
		} catch (Exception e) {
			result = 0;
			msg = msg + ": " + e.getMessage();
		}
		jsonResponse.addProperty("result", result);
		jsonResponse.addProperty("msg", String.format(msg, (id == null) ? "add" : "edit"));
		return jsonResponse.toString();
	}
	

	@RequestMapping(value = "/expertBaseinfo", method = RequestMethod.GET)
	public String list(HttpServletRequest request, Model model) {

		User user = accountManager.findUserByLoginName(SpringSecurityUtils.getCurrentUserName());

		String infoType = request.getParameter("bt");
		if (infoType == null) {
			infoType = "base";
		}
		if (user == null || user.getId() == null) {
			model.addAttribute("infoType", infoType);
			return "userBaseInfor/expertBaseinfo";
		}
		if (infoType.equals("base")) {

			model.addAttribute("bodyList", bodyservice.getAll());
		}
		model.addAttribute("user", user);

		model.addAttribute("infoType", infoType);
		return "userBaseInfor/expertBaseinfo";
	}

}
