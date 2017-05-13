package com.jfn.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.modules.security.springsecurity.SpringSecurityUtils;

import com.google.gson.JsonObject;
import com.jfn.entity.User;
import com.jfn.entity.UserBusiness;
import com.jfn.service.AccountManager;
import com.jfn.service.BodyService;
import com.jfn.service.UserBusinessService;
import com.jfn.service.UserService;

@Controller
@RequestMapping("/")
public class UserBusinessController {
	@Autowired
	private AccountManager accountManager;
	@Autowired
	private UserBusinessService userbusinessservice;
	@Autowired
	private UserService userservice;
	@Autowired
	private BodyService bodyservice;

	// 初始化加载
	@RequestMapping(value = "userBusinessInit", method = RequestMethod.GET)
	@ResponseBody
	public String userBusinessInit(HttpServletRequest request, Model model) {
		JsonObject jsonobject = new JsonObject();
		User user = accountManager.findUserByLoginName(SpringSecurityUtils.getCurrentUserName());
		UserBusiness userbusiness = userbusinessservice.getByUserId(user.getId());
		jsonobject.addProperty("autobiography", userbusiness.getAutobiography());
		return jsonobject.toString();
	}

	// 更新修改操作
	@RequestMapping(value = "/userBusinessUpdate", method = RequestMethod.POST)
	@ResponseBody
	public String userBusinessUpdate(HttpServletRequest request) {
		String autobiography = request.getParameter("autobiography");
		JsonObject jsonResponse = new JsonObject();
		int result = 0;// 0:fail;1:success
		User user = accountManager.findUserByLoginName(SpringSecurityUtils.getCurrentUserName());
		UserBusiness userbusiness = userbusinessservice.getByUserId(user.getId());
		userbusiness.setAutobiography(autobiography);
		result = userbusinessservice.update(userbusiness) ? 1 : 0;
		jsonResponse.addProperty("result", result);
		return jsonResponse.toString();
	}

}
