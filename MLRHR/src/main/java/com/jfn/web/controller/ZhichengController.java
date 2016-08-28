package com.jfn.web.controller;

import java.io.UnsupportedEncodingException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

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
import org.springframework.web.servlet.ModelAndView;
import org.springside.modules.security.springsecurity.SpringSecurityUtils;

import com.google.gson.JsonObject;
import com.jfn.entity.ApplyMenu;
import com.jfn.entity.Role;
import com.jfn.entity.User;
import com.jfn.entity.ZhichengApply;
import com.jfn.service.AccountManager;
import com.jfn.service.ApplyMenuService;
import com.jfn.service.BodyService;
import com.jfn.service.CalendarService;
import com.jfn.service.UserChengguoService;
import com.jfn.service.UserExamService;
import com.jfn.service.UserPeixunService;
import com.jfn.service.UserProjectService;
import com.jfn.service.UserService;
import com.jfn.service.UserWorkService;
import com.jfn.service.ZhichengApplyService;

@Controller
@RequestMapping("/")
public class ZhichengController {
	@Autowired
	private ZhichengApplyService zervice;
	
	@Autowired
	private ApplyMenuService applyMenuService;

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
	private UserService userservice;
	@Autowired
	private BodyService bodyservice;
	@Autowired
	private ZhichengApplyService zhichengapplyservice;
	@Autowired
	private CalendarService calendarservice;

	@RequestMapping(value = "zhichengApply", method = RequestMethod.GET)
	public String jcqn_zhichengApply(HttpServletRequest request, Model model) {
		return "zhicheng/zhichengApply";
	}

	@RequestMapping(value = "zhichengApplylist", method = RequestMethod.GET)
	public String zhichengApplylist(HttpServletRequest request, Model model) {
		return "zhicheng/zhichengApplylist";
	}
	
	/**
	 * 得到申报材料的列表名称
	 * @param applytype
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "applyMenu", method = RequestMethod.GET)
	public ModelAndView ApplyMenu(String applytype){
		String type = null;
		try {
			type = new String(applytype.getBytes("ISO8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		List<ApplyMenu> menus = applyMenuService.getMenu(type);
		ModelAndView map = new ModelAndView("zhicheng/zhichengApply");
		map.addObject("menus", menus);
		map.addObject("type",menus.get(0).getMenutype());
		return map;
	}

	@RequestMapping(value = "zhichengApplylistInit", method = RequestMethod.GET)
	@ResponseBody
	public String zhichengApplylistInit(HttpServletRequest request, Model model) {
		String userId = request.getParameter("userId");
		List<ZhichengApply> list = zhichengapplyservice.getAllByUserId(Integer.parseInt(userId));

		String authority = "";
		SecurityContextImpl securityContextImpl = (SecurityContextImpl) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
		@SuppressWarnings("unchecked")
		List<GrantedAuthority> authorities = (List<GrantedAuthority>) securityContextImpl.getAuthentication().getAuthorities();
		for (GrantedAuthority grantedAuthority : authorities) {
			authority = authority + grantedAuthority.getAuthority() + "|";
		}
		JSONObject jo3 = new JSONObject();
		jo3.put("authority", authority);

		com.jfn.entity.Calendar calendar = calendarservice.getById("1");
		String starDate = calendar.getStart_date();
		String endDate = calendar.getEnd_date();
		if (list.size() > 0) {
			ZhichengApply zhichengapply = list.get(0);
			if (zhichengapply.getApply_date().compareTo(starDate) > 0 && zhichengapply.getApply_date().compareTo(endDate) > 0) {
				jo3.put("hasOne", "1");
			} else {
				jo3.put("hasOne", "0");
			}
		} else {
			jo3.put("hasOne", "0");
		}

		JSONArray jsonArray = new JSONArray();
		jsonArray.add(list);
		jsonArray.add(jo3);
		return jsonArray.toString();
	}

	@RequestMapping(value = "zhichengManage", method = RequestMethod.GET)
	public String zhichengManage(HttpServletRequest request, Model model) {
		User user = accountManager.findUserByLoginName(SpringSecurityUtils.getCurrentUserName());

		List<Role> myrole = accountManager.getUserRole(user.getId());
		Set<ZhichengApply> ZhichengApplySet = new LinkedHashSet<ZhichengApply>();
		for (Role roleobj : myrole) {
			if (roleobj.getName().equals("DepartHR")) {
				List<User> userlist = uservice.getAllByBodyId(user.getBody_id());
				for (User userobj : userlist) {
					List<ZhichengApply> UserZhichengApplylist = zervice.getAllByUserId(userobj.getId());
					for (ZhichengApply ZhichengApplyobj : UserZhichengApplylist) {
						ZhichengApplySet.add((ZhichengApplyobj));
					}
				}
				model.addAttribute("zhichengApplyList", ZhichengApplySet);
			} else if (roleobj.getName().equals("HR")) {
				ZhichengApplySet.clear();
				List<User> userlist = uservice.getAll();
				for (User userobj : userlist) {
					List<ZhichengApply> UserZhichengApplylist = zervice.getAllByUserId(userobj.getId());
					for (ZhichengApply ZhichengApplyobj : UserZhichengApplylist) {
						ZhichengApplySet.add((ZhichengApplyobj));
					}
				}
				model.addAttribute("zhichengApplyList", ZhichengApplySet);
			}
		}
		return "zhicheng/zhichengApplymanage";
	}

	// 职称提交(增加、修改)
	@RequestMapping(value = "/jcqn_zhichengApplyUpdate", method = RequestMethod.POST)
	@ResponseBody
	public String jcqn_zhichengApplyUpdate(HttpServletRequest request, @ModelAttribute ZhichengApply entity) {
		JsonObject jsonResponse = new JsonObject();
		int result = 0;// 0:fail;1:success
		String msg = "Failed to %s this zhicheng";
		String id = request.getParameter("id");
		try {
			if ((id == null) || (id.length() < 1)) {
				result = zhichengapplyservice.Insert(entity) ? 1 : 0;
			} else {
				result = zhichengapplyservice.Update(entity) ? 1 : 0;
			}
		} catch (Exception e) {
			result = 0;
			msg = msg + ": " + e.getMessage();
		}
		jsonResponse.addProperty("result", result);
		jsonResponse.addProperty("msg", String.format(msg, (id == null) ? "add" : "edit"));
		return jsonResponse.toString();
	}

	// 通过id删除职称单条信息
	@RequestMapping(value = "zhichengApplyDelete", method = RequestMethod.POST)
	@ResponseBody
	public String zhichengApplyDelete(HttpServletRequest request, Model model) {
		JsonObject jsonResponse = new JsonObject();
		String Id = request.getParameter("id");
		int result = 0;// 0:fail;1:success
		String msg = "Failed to delete this user_work!";
		if (Id != null) {

			result = zhichengapplyservice.delete(Id) ? 1 : 0;
			msg = "You have successfully DELETED this zhicheng.";
		} else {
			return "404";
		}

		jsonResponse.addProperty("result", result);
		jsonResponse.addProperty("msg", msg);
		return jsonResponse.toString();

	}

	@RequestMapping(value = "zhichengApplyGetById", method = RequestMethod.GET)
	@ResponseBody
	public String zhichengApplyGetById(HttpServletRequest request, Model model) {

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
		String id = request.getParameter("id");
		if ((id != null) && (id.length() >= 1)) {
			ZhichengApply zhichengapply = zhichengapplyservice.getById(id);
			jsonArray.add(zhichengapply);
			jsonArray.add(jo3);
			return jsonArray.toString();
		}
		return null;
	}
}
