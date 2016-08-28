package com.jfn.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.modules.security.springsecurity.SpringSecurityUtils;

import com.google.gson.JsonObject;
import com.jfn.entity.Body;
import com.jfn.entity.Calendar;
import com.jfn.entity.User;
import com.jfn.entity.ZhichengApply;
import com.jfn.service.AccountManager;
import com.jfn.service.BodyService;
import com.jfn.service.CalendarService;
import com.jfn.service.UserService;
import com.jfn.service.ZhichengApplyService;

/**
 * @create-time 2014-8-8 下午8:25:28
 * @creator 佟德慧
 */
@Controller
@RequestMapping("/")
public class BodyController {
	@Autowired
	private BodyService service;

	@Autowired
	private UserService uservice;

	@Autowired
	private AccountManager accountManager;
	@Autowired
	private ZhichengApplyService zhichengapplyservice;
	@Autowired
	private CalendarService calendarservice;

	@RequestMapping(value = "addbody", method = RequestMethod.GET)
	public String bodyAdd(HttpServletRequest request, Model model) {
		Body new_body = new Body();
		model.addAttribute("body", new_body);
		return "body/bodyedit";
	}

	@RequestMapping(value = "bodylist", method = RequestMethod.GET)
	public String list(HttpServletRequest request, Model model) {
		return "body/bodylist";
	}

	@RequestMapping(value = "bodyManger", method = RequestMethod.GET)
	public String bodyManger(HttpServletRequest request, Model model) {
		return "body/bodyManger";
	}

	@RequestMapping(value = "bodydetail", method = RequestMethod.GET)
	public String detail(HttpServletRequest request, Model model) {

		String bodyId = request.getParameter("id");
		if (bodyId != null) {
			Body body = service.getById(bodyId);
			model.addAttribute("body", body);

			return "body/bodydetail";
		} else {
			return "404";
		}
	}

	@RequestMapping(value = "bodyedit", method = RequestMethod.GET)
	public String edit(HttpServletRequest request, Model model) {
		String bodyId = request.getParameter("id");
		if (bodyId != null) {
			Body body = service.getById(bodyId);
			model.addAttribute("body", body);

			return "bodyedit";
		} else {
			return "404";
		}
	}

	@RequestMapping(value = "bodydel", method = RequestMethod.POST)
	@ResponseBody
	public String delete(HttpServletRequest request, Model model) {
		JsonObject jsonResponse = new JsonObject();
		String bodyId = request.getParameter("id");
		int result = 0;// 0:fail;1:success
		String msg = "Failed to delete this body!";
		if (bodyId != null) {

			result = service.deletebody(bodyId) ? 1 : 0;
			msg = "You have successfully DELETED this body.";
		} else {
			return "404";
		}

		jsonResponse.addProperty("result", result);
		jsonResponse.addProperty("msg", msg);
		return jsonResponse.toString();

	}

	@RequestMapping(value = "bodyupdate", method = RequestMethod.POST)
	@ResponseBody
	public String bodyUpdate(HttpServletRequest request, @ModelAttribute Body entity) {
		JsonObject jsonResponse = new JsonObject();
		int result = 0;// 0:fail;1:success
		String msg = "Failed to %s this body!";
		String id = request.getParameter("id");

		if ((id == null) || (id.length() < 1)) {

			result = service.bodyInsert(entity) ? 1 : 0;
		} else {
			result = service.bodyUpdate(entity) ? 1 : 0;
		}
		jsonResponse.addProperty("result", result);
		jsonResponse.addProperty("msg", String.format(msg, (id == null) ? "add" : "edit"));
		return jsonResponse.toString();
	}

	// 获取body部门，行程树形结构，返回json
	@RequestMapping(value = "bodytree", method = RequestMethod.GET)
	@ResponseBody
	public String bodytree(HttpServletRequest request, Model model) throws Exception {
		List<Body> list = service.getAll();// 数据库中获取源数据

		String authority = "";
		SecurityContextImpl securityContextImpl = (SecurityContextImpl) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
		@SuppressWarnings("unchecked")
		List<GrantedAuthority> authorities = (List<GrantedAuthority>) securityContextImpl.getAuthentication().getAuthorities();
		for (GrantedAuthority grantedAuthority : authorities) {
			authority = authority + grantedAuthority.getAuthority() + "|";
		}
		JSONObject jo3 = new JSONObject();
		jo3.put("authority", authority);

		JSONArray jsonArray = new JSONArray();
		jsonArray.add(list);
		jsonArray.add(jo3);
		return jsonArray.toString();
	}

	// 点击树形节点，ajax更新右侧列表数据。
	@RequestMapping(value = "bodyTreeClick", method = RequestMethod.GET)
	@ResponseBody
	public String BodyTreeClick(HttpServletRequest request, Model model) {
		String body_id = request.getParameter("body_id");
		if (body_id != null) {
			List<User> list = uservice.getAllByBodyId(body_id);// 数据库中获取源数据
			JSONArray jsonArray = JSONArray.fromObject(list);
			return jsonArray.toString();
		} else {
			return "404";
		}
	}

	@RequestMapping(value = "bodyselectByDate", method = RequestMethod.POST)
	@ResponseBody
	public String selectByDate(HttpServletRequest request, Model model) {
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String body_id = request.getParameter("body_id");
		String status = request.getParameter("status");
		String apply_name = request.getParameter("apply_name");
		String apply_type = request.getParameter("apply_type");

		ArrayList<User> userListNew = new ArrayList<User>();
		ArrayList<ZhichengApply> zhichengApplylistNew = new ArrayList<ZhichengApply>();
		List<User> userList = null;
		if (body_id != null) {

			if (body_id.equals("1")) {
				userList = uservice.getAll();// 数据库中获取源数据
			} else {
				userList = uservice.getAllByBodyId(body_id);// 数据库中获取源数据
			}
			if (userList.size() != 0) {
				for (User user : userList) {
					List<ZhichengApply> zhichengApplylist = zhichengapplyservice.getUserByUserIdAndDate(user.getId(), startDate, endDate);
					if (zhichengApplylist.size() != 0) {
						if (apply_name.equals("-1") || zhichengApplylist.get(0).getApply_name().equals(apply_name)) {
							if (apply_type.equals("-1") || zhichengApplylist.get(0).getApply_type().equals(apply_type)) {
								if ((zhichengApplylist.get(0)).getStatus().equals(status)) {
									userListNew.add(user);
									zhichengApplylistNew.add(zhichengApplylist.get(0));
								}
							}
						}
					}
				}
			}

			ArrayList<Object> obj = new ArrayList<Object>();
			obj.add(userListNew);
			obj.add(zhichengApplylistNew);

			JSONArray jsonArray = JSONArray.fromObject(obj);
			System.err.println("返回值＝＝＝＝＝"+JSONArray.fromObject(obj));
			return jsonArray.toString();
		}
		return "";
	}

	@RequestMapping(value = "checkEdit", method = RequestMethod.GET)
	@ResponseBody
	public String checkEdit(HttpServletRequest request, Model model) {

		Calendar calendar = calendarservice.getById("1");
		String startDate = calendar.getStart_date();
		String endDate = calendar.getEnd_date();

		User user = accountManager.findUserByLoginName(SpringSecurityUtils.getCurrentUserName());
		int result = 1;// 0:fail;1:success

		List<ZhichengApply> zhichengApplylist = zhichengapplyservice.getUserByUserIdAndDate(user.getId(), startDate, endDate);
		if (zhichengApplylist.size() != 0) {
			if ((zhichengApplylist.get(0)).getStatus().equals("未通过") || (zhichengApplylist.get(0)).getStatus().equals("待审核")) {
				result = 1;
			} else {
				result = 0;
			}
		}

		JsonObject jsonResponse = new JsonObject();
		jsonResponse.addProperty("result", result);
		return jsonResponse.toString();
	}
}
