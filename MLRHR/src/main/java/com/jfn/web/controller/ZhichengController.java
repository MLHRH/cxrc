package com.jfn.web.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

import com.alibaba.fastjson.JSON;
import com.google.gson.JsonObject;
import com.jfn.entity.ZhichengApply;
import com.jfn.entity.AcctUserRole;
import com.jfn.entity.ApplyGroup;
import com.jfn.entity.ApplyMenu;
import com.jfn.entity.ExpertUser;
import com.jfn.entity.Group;
import com.jfn.entity.JcqnDoc04;
import com.jfn.entity.Role;
import com.jfn.entity.User;

import com.jfn.service.AccountManager;
import com.jfn.service.ApplyMenuService;
import com.jfn.service.BodyService;
import com.jfn.service.CalendarService;
import com.jfn.service.GroupService;
import com.jfn.service.UserChengguoService;
import com.jfn.service.UserExamService;
import com.jfn.service.UserPeixunService;
import com.jfn.service.UserProjectService;
import com.jfn.service.UserService;
import com.jfn.service.UserWorkService;
import com.jfn.service.ZhichengApplyService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

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
    @Autowired
    private GroupService groupService;
	@RequestMapping(value = "zhichengApply", method = RequestMethod.GET)
	public ModelAndView zhichengApply(HttpServletRequest request, Model model,String applyType) {
		String type = null;
		if(applyType != null && applyType !=""){
			try {
				type = new String(applyType.getBytes("ISO8859-1"), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			if(type !=null && type.length() > 4){
				type = type.substring(1, 5);
			}
			List<ApplyMenu> menus = applyMenuService.getMenu(type);
			
			ModelAndView map = new ModelAndView("zhicheng/zhichengApply");
			HttpSession session = request.getSession();
			User user =(User) session.getAttribute("loginuser");
			AcctUserRole acctUserRole =zhichengapplyservice.getRoleByUserId(user.getId());
			if(acctUserRole.getRole_id() != 4 && acctUserRole.getRole_id() != 5 ){			
				List<ApplyMenu> menus2 =new ArrayList<ApplyMenu>();
				        menus2.add(menus.get(0));
				        menus2.add(menus.get(1));
				        menus2.add(menus.get(2));
				        menus2.add(menus.get(3));
				        menus2.add(menus.get(4));
				        menus2.add(menus.get(5));
				         map.addObject("menus", menus2);
			}else {
			map.addObject("menus", menus);
			}
			map.addObject("type",menus.get(0).getMenutype());
			return map;
		}
		else{
			return new ModelAndView("zhicheng/zhichengApply");
		}
	}

	@RequestMapping(value = "zhichengApplylist", method = RequestMethod.GET)
	public String zhichengApplylist(HttpServletRequest request, Model model) {
		return "zhicheng/zhichengApplylist";
	}
	
	@RequestMapping(value = "expertzhichengApplylist", method = RequestMethod.GET)
	public String expertZhichengApplylist(HttpServletRequest request, Model model) {
		return "zhicheng/expertzhichengApplylist";
	}
	
	/**
	 * 得到申报材料的列表名称
	 * @param applytype
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "applyMenu", method = RequestMethod.GET)
	public ModelAndView ApplyMenu(HttpServletRequest request,String applytype){
		String type = null;
		try {
			type = new String(applytype.getBytes("ISO8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if(type !=null && type.length() > 4){
			type = type.substring(1, 5);
		}
		List<ApplyMenu> menus = applyMenuService.getMenu(type);
		ModelAndView map = new ModelAndView("zhicheng/zhichengApply");
		HttpSession session = request.getSession();
		User user =(User) session.getAttribute("loginuser");
		AcctUserRole acctUserRole =zhichengapplyservice.getRoleByUserId(user.getId());
		if(acctUserRole.getRole_id() != 4 && acctUserRole.getRole_id() != 5 ){			
			List<ApplyMenu> menus2 =new ArrayList<ApplyMenu>();
			        menus2.add(menus.get(0));
			        menus2.add(menus.get(1));
			        menus2.add(menus.get(2));
			        menus2.add(menus.get(3));
			        menus2.add(menus.get(4));
			        menus2.add(menus.get(5));
			         map.addObject("menus", menus2);
		}else {
		map.addObject("menus", menus);
		}
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
		List<Group> groups =new ArrayList<Group>();
		if (list.size() > 0) {
			for(int i =0 ;i < list.size(); i++){
				Group group =groupService.getGroupTreeById(Integer.valueOf(list.get(i).getGroup_id()));
				list.get(i).setGroup_id(group.getName());
			}
			
			
			
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
	@RequestMapping(value = "/zhichengApplyUpdate", method = RequestMethod.POST)
	@ResponseBody
	public String zhichengApplyUpdate(HttpServletRequest request, @ModelAttribute ZhichengApply entity) {
		JsonObject jsonResponse = new JsonObject();
		int result = 0;// 0:fail;1:success
		String msg = "Failed to %s this zhicheng";
		String id = request.getParameter("id");
		System.err.println(request.getParameter("status"));
		System.err.println(request.getParameter("expert2_score"));
		System.err.println(request.getParameter("expert2_sug"));
		try {
			if ((id == null) || (id.length() < 1)) {
				result = zhichengapplyservice.Insert(entity) ? 1 : 0;
			} else {
				System.err.println(JSON.toJSON(entity));
				result = zhichengapplyservice.Update(entity) ? 1 : 0;
			}
		} catch (Exception e) {
			result = 0;
			msg = msg + ": " + e.getMessage();
			System.err.println(e);
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
	
	
	
	@RequestMapping(value = "expertzhichengApplylistInit", method = RequestMethod.GET)
	@ResponseBody
	public Object initApplyGroup(HttpServletRequest request){
		HttpSession session = request.getSession();
		User user =(User) session.getAttribute("loginuser");
		ExpertUser  expertUser = zhichengapplyservice.getByUserId(user.getId());
		String group_id = request.getParameter("groupId");
		String role_type = request.getParameter("role_type");
		List<ApplyGroup> list = groupService.getApplyGroupById(Integer.valueOf(expertUser.getGroup_id()),
				Integer.valueOf(role_type));
		return list;
	}
	
	
	//获取信息
	@RequestMapping(value="/ExpertUserInit", method =RequestMethod.GET)
	@ResponseBody
	public ExpertUser jcqnDoc04Init(HttpServletRequest request){
		JSONArray jsonArray = new JSONArray();
		String userId = request.getParameter("userId");
		System.err.println("-----------"+userId);
		ExpertUser  expertUser = zhichengapplyservice.getByUserId(Integer.parseInt(userId));
		return expertUser;
	}
	
	
}
