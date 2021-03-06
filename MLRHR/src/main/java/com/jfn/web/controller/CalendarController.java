package com.jfn.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonObject;
import com.jfn.entity.Calendar;
import com.jfn.service.AccountManager;
import com.jfn.service.CalendarService;
import com.jfn.service.UserService;

/**
 * @create-time 2014-8-24 下午5:56:02
 * @author 佟德慧
 * @remarks 无
 */
@Controller
@RequestMapping("/")
public class CalendarController {
	@Autowired
	private CalendarService service;
	@Autowired
	private UserService userservice;
	@Autowired
	private AccountManager accountManager;

	@RequestMapping(value = "/calendar", method = RequestMethod.GET)
	public String calendar(HttpServletRequest request, Model model) {
		return "system/calendar";
	}

	@RequestMapping(value = "/calendarEdit", method = RequestMethod.GET)
	public String calendarEdit(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		if ((id != null) && (id.length() >= 1)) {
			Calendar calendar = service.getById(id);
			model.addAttribute("calendar", calendar);
		}
		return "system/calendarEdit";
	}

	@RequestMapping(value = "/calendarGet", method = RequestMethod.GET)
	@ResponseBody
	public String calendarGet(HttpServletRequest request, Model model) {
		JSONArray jsonArray = new JSONArray();
		Calendar calendar = service.getById("1");
		jsonArray.add(calendar);
		return jsonArray.toString();
	}

	@RequestMapping(value = "/calendarUpdate", method = RequestMethod.POST)
	@ResponseBody
	public String calendarUpdate(HttpServletRequest request, @ModelAttribute Calendar entity) {
		JsonObject jsonResponse = new JsonObject();
		int result = 0;// 0:fail;1:success
		String msg = "Failed to %s this calendar";
		String id = request.getParameter("id");
		try {
			if ((id == null) || (id.length() < 1)) {
				result = service.calendarInsert(entity) ? 1 : 0;
			} else {
				result = service.calendarUpdate(entity) ? 1 : 0;
			}
		} catch (Exception e) {
			result = 0;
			msg = msg + ": " + e.getMessage();
		}
		jsonResponse.addProperty("result", result);
		jsonResponse.addProperty("msg", String.format(msg, (id == null) ? "add" : "edit"));
		return jsonResponse.toString();
	}

	// 通过calendar.id删除工作经历单条信息
	@RequestMapping(value = "calendarDelete", method = RequestMethod.POST)
	@ResponseBody
	public String calendarDelete(HttpServletRequest request, Model model) {
		JsonObject jsonResponse = new JsonObject();
		String Id = request.getParameter("id");
		int result = 0;// 0:fail;1:success
		String msg = "Failed to delete this calendar!";
		if (Id != null) {

			result = service.deletecalendar(Id) ? 1 : 0;
			msg = "You have successfully DELETED this calendar.";
		} else {
			return "404";
		}

		jsonResponse.addProperty("result", result);
		jsonResponse.addProperty("msg", msg);
		return jsonResponse.toString();

	}

	@RequestMapping(value = "calendarSelect", method = RequestMethod.GET)
	@ResponseBody
	public String calendarSelect(HttpServletRequest request, Model model) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
		String nowDateString = df.format(new Date());// new Date()为获取当前系统时间

		Calendar calendar = service.getById("1");
		String starDate = calendar.getStart_date();
		String endDate = calendar.getEnd_date();

		JsonObject jsonResponse = new JsonObject();
		int result = 0;// 0:fail;1:success
		if ((starDate.compareTo(nowDateString)) < 0 && (endDate.compareTo(nowDateString)) > 0) {
			result = 1;
		} else {
			result = 0;
			SecurityContextImpl securityContextImpl = (SecurityContextImpl) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
			@SuppressWarnings("unchecked")
			List<GrantedAuthority> authorities = (List<GrantedAuthority>) securityContextImpl.getAuthentication().getAuthorities();
			for (GrantedAuthority grantedAuthority : authorities) {
				if (grantedAuthority.getAuthority().equals("ROLE_PROFESSOR") || grantedAuthority.getAuthority().equals("ROLE_HR")) {
					result = 1;
				}
			}
		}

		jsonResponse.addProperty("result", result);
		return jsonResponse.toString();

	}

}
