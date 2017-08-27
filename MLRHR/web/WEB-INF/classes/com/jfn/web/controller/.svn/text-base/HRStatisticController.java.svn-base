package com.jfn.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springside.modules.security.springsecurity.SpringSecurityUtils;

import com.jfn.entity.Body;
import com.jfn.entity.User;
import com.jfn.service.AccountManager;
import com.jfn.service.BodyService;
import com.jfn.service.UserChengguoService;
import com.jfn.service.UserExamService;
import com.jfn.service.UserPeixunService;
import com.jfn.service.UserProjectService;
import com.jfn.service.UserService;
import com.jfn.service.UserWorkService;
import com.jfn.service.ZhichengApplyService;

@Controller
@RequestMapping("/")
public class HRStatisticController {
	@Autowired
	private ZhichengApplyService zervice;

	@Autowired
	private UserChengguoService cgservice;

	@Autowired
	private UserExamService eservice;

	@Autowired
	private UserPeixunService pxservice;

	@Autowired
	private UserProjectService pservice;

	@Autowired
	private UserWorkService wservice;

	@Autowired
	private AccountManager accountManager;

	@Autowired
	private UserService uservice;

	@Autowired
	private BodyService bodyservice;

	@RequestMapping(value = "hrstatistic", method = RequestMethod.GET)
	public String hrstatistic(HttpServletRequest request, Model model) {
		return "statistic/hrstatistic";
	}

	@RequestMapping(value = "userExportEdit", method = RequestMethod.GET)
	public String userExportEdit(HttpServletRequest request, Model model) {
		User user = accountManager.findUserByLoginName(SpringSecurityUtils.getCurrentUserName());
		Body body = bodyservice.getById(user.getBody_id());
		model.addAttribute("userName", user.getName());
		model.addAttribute("bodyName", body.getName());
		return "statistic/userExportEdit";
	}

	@RequestMapping(value = "hrstatisticOfBody", method = RequestMethod.GET)
	public String hrstatisticOfBody(HttpServletRequest request, Model model) {
		return "statistic/hrstatisticOfBody";
	}

}
