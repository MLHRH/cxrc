package com.jfn.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.jfn.entity.CxtdBaseInfo;
import com.jfn.entity.CxtdDoc05;
import com.jfn.entity.CxtdDoc01;
import com.jfn.entity.CxtdDoc03;
import com.jfn.entity.CxtdDoc04;
import com.jfn.entity.CxtdLeaderInfo;
import com.jfn.entity.CxtdMemberInfo;
import com.jfn.entity.CxtdMemberNum;
import com.jfn.entity.UesrZuzhi;
import com.jfn.entity.UserPeixun;
import com.jfn.entity.UserWork;
import com.jfn.service.UserPeixunService;
import com.jfn.service.UserWorkService;
import com.jfn.service.UserZuzhiService;
import com.jfn.service.cxtdDocService;

@Controller
@RequestMapping("/")
public class cxtdDocController {
	@Autowired
	private cxtdDocService cxtdDocService;
	@Autowired
	private UserPeixunService userPeixunService;
	@Autowired
	private UserWorkService userWorkService;
	@Autowired
	private UserZuzhiService userZuzhiService;

	/**
	 * 初始化doc01
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/cxtdDoc01Init", method = RequestMethod.GET)
	@ResponseBody
	public String cxtdDoc01Init(HttpServletRequest request) {

		// int userid =(Integer)request.getSession().getAttribute("user_id");
		int userId = Integer.valueOf(request.getParameter("userId"));
		Map<String, Object> doc01 = new HashMap<String, Object>();
		doc01 = cxtdDocService.queryCxtdDoc01(userId);
		String authority = "";

		SecurityContextImpl securityContextImpl = (SecurityContextImpl) request.getSession()
				.getAttribute("SPRING_SECURITY_CONTEXT");
		@SuppressWarnings("unchecked")
		List<GrantedAuthority> authorities = (List<GrantedAuthority>) securityContextImpl.getAuthentication()
				.getAuthorities();
		for (GrantedAuthority grantedAuthority : authorities) {
			authority = authority + grantedAuthority.getAuthority() + "|";
		}

		JSONObject jo3 = new JSONObject();
		jo3.put("authority", authority);
		List<Object> list = new ArrayList<Object>();
		list.add(doc01);
		list.add(jo3);
		 Gson gson = new Gson();
         
			return gson.toJson(list);

	}

	/**
	 * 更新DOC01
	 * 
	 * @param cxtddoc01
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/cxtdDoc01Update", method = RequestMethod.POST)
	@ResponseBody
	public Object cxtdDoc01Update(String baseinfo, String leaderinfo, String memnum, String meminfos, String zuzhis,
			String works, String studys, HttpServletRequest request) {
		JSONObject result = new JSONObject();
		int user_id = (Integer) request.getSession().getAttribute("user_id");
		// 组织对象
		CxtdBaseInfo baseInfo = JSON.parseObject(baseinfo, CxtdBaseInfo.class);
		CxtdLeaderInfo leaderInfo = JSON.parseObject(leaderinfo, CxtdLeaderInfo.class);
		System.err.println(leaderInfo.getUser_id());
		CxtdMemberNum memNum = JSON.parseObject(memnum, CxtdMemberNum.class);

		List<UesrZuzhi> zuzhiList = JSONArray.parseArray(zuzhis, UesrZuzhi.class);
		List<UserWork> userWorks = JSONArray.parseArray(works, UserWork.class);
		List<UserPeixun> userPeixuns = JSONArray.parseArray(studys, UserPeixun.class);
		List<CxtdMemberInfo> meminfo = JSONArray.parseArray(meminfos, CxtdMemberInfo.class);
		for (UserPeixun userPeixun : userPeixuns) {	
			userPeixun.setUser_id(user_id + "");
			if (userPeixun.getId() == null || userPeixun.getId().equals("") || userPeixun.getId().equals("null")) {
				userPeixunService.user_peixunInsert(userPeixun);
			} else {
				userPeixunService.user_peixunUpdate(userPeixun);
			}
		}
		for (UserWork userWork : userWorks) {
			userWork.setUser_id(user_id + "");
			if (userWork.getId() == null || userWork.getId().equals("") || userWork.getId().equals("null")) {
				userWorkService.user_workInsert(userWork);
			} else {
				userWorkService.user_workUpdate(userWork);
			}
		}
		for (UesrZuzhi uesrZuzhi : zuzhiList) {
			uesrZuzhi.setUser_id(user_id);
			if (uesrZuzhi.getId() == null || uesrZuzhi.getId().equals("") || uesrZuzhi.getId().equals("null")) {
				userZuzhiService.zuzhiInsert(uesrZuzhi);
			} else {
				userZuzhiService.zuzhiUpdate(uesrZuzhi);
			}
		}
		CxtdDoc01 doc01 = new CxtdDoc01();
		doc01.setBaseInfo(baseInfo);
		doc01.setLeaderInfo(leaderInfo);
		doc01.setMemNum(memNum);
		doc01.setmList(meminfo);
		System.err.println("基本信息" + baseInfo.toString());
		System.err.println("负责人信息：" + leaderInfo.toString());
		System.err.println("团队成员人数统计" + memNum.toString());
		cxtdDocService.updateDoc01(doc01, user_id, result);
		return result;

	}

	// 获取信息
	@RequestMapping(value = "/cxtdDoc03Init", method = RequestMethod.GET)
	@ResponseBody
	public String kjljDoc03Init(HttpServletRequest request) {

		String authority = "";

		SecurityContextImpl securityContextImpl = (SecurityContextImpl) request.getSession()
				.getAttribute("SPRING_SECURITY_CONTEXT");
		@SuppressWarnings("unchecked")
		List<GrantedAuthority> authorities = (List<GrantedAuthority>) securityContextImpl.getAuthentication()
				.getAuthorities();
		for (GrantedAuthority grantedAuthority : authorities) {
			authority = authority + grantedAuthority.getAuthority() + "|";
		}

		JSONObject jo3 = new JSONObject();
		jo3.put("authority", authority);
		JSONArray jsonArray = new JSONArray();

		String userId = request.getParameter("userId");
		System.err.println("-----------" + userId);
		CxtdDoc03 cxtd = cxtdDocService.getDao03(Integer.parseInt(userId));
		// Gson gson = new Gson();
		System.err.println(cxtd);
		// return gson.toJson(kjlj);
		jsonArray.add(cxtd);
		jsonArray.add(jo3);
		return jsonArray.toString();
	}

	// 添加、更新操作记录
	@RequestMapping(value = "/cxtdDoc03Update", method = RequestMethod.POST)
	@ResponseBody
	public String kjljDoc03Update(CxtdDoc03 cxtdDoc03, HttpServletRequest request) {
		JsonObject jsonResponse = new JsonObject();
		int user_id = (Integer) request.getSession().getAttribute("user_id");
		cxtdDoc03.setUser_id(user_id);

		int result = 0;
		try {
			if (cxtdDocService.getDao03(user_id).getSelfAssessment() != null) {
				result = cxtdDocService.updateDao03(cxtdDoc03) ? 1 : 0;
				System.err.println(result);
			}

			else {
				result = cxtdDocService.insertDoc03(cxtdDoc03) ? 1 : 0;
			}

		} catch (Exception e) {
			result = 0;
		}
		jsonResponse.addProperty("result", result);
		return jsonResponse.toString();

	}

	// 获取信息
	@RequestMapping(value = "/cxtdDoc04Init", method = RequestMethod.GET)
	@ResponseBody
	public String cxtdDoc04Init(HttpServletRequest request) {

		String authority = "";

		SecurityContextImpl securityContextImpl = (SecurityContextImpl) request.getSession()
				.getAttribute("SPRING_SECURITY_CONTEXT");
		@SuppressWarnings("unchecked")
		List<GrantedAuthority> authorities = (List<GrantedAuthority>) securityContextImpl.getAuthentication()
				.getAuthorities();
		for (GrantedAuthority grantedAuthority : authorities) {
			authority = authority + grantedAuthority.getAuthority() + "|";
		}

		JSONObject jo3 = new JSONObject();
		jo3.put("authority", authority);
		JSONArray jsonArray = new JSONArray();

		String userId = request.getParameter("userId");
		System.err.println("-----------" + userId);
		CxtdDoc04 cxtd = cxtdDocService.getDoc4(Integer.parseInt(userId));
		jsonArray.add(cxtd);
		jsonArray.add(jo3);
		return jsonArray.toString();
	}

	// 添加、更新操作记录
	@RequestMapping(value = "/cxtdDoc04Update", method = RequestMethod.POST)
	@ResponseBody
	public String kjljDoc04Update(CxtdDoc04 cxtdDoc04, HttpServletRequest request) {
		JsonObject jsonResponse = new JsonObject();
		int user_id = (Integer) request.getSession().getAttribute("user_id");
		cxtdDoc04.setUser_id(user_id);

		int result = 0;
		try {
			if (cxtdDocService.getDoc4(user_id).getFuturePlans() != null) {

				result = cxtdDocService.updateDoc4(cxtdDoc04) ? 1 : 0;
				System.err.println(result);
			}

			else {
				result = cxtdDocService.insertDoc04(cxtdDoc04) ? 1 : 0;
			}

		} catch (Exception e) {
			result = 0;
		}
		jsonResponse.addProperty("result", result);
		return jsonResponse.toString();

	}

	// 获取信息
	@RequestMapping(value = "/cxtdDoc05Init", method = RequestMethod.GET)
	@ResponseBody
	public String kjljDoc05Init(HttpServletRequest request) {

		String authority = "";

		SecurityContextImpl securityContextImpl = (SecurityContextImpl) request.getSession()
				.getAttribute("SPRING_SECURITY_CONTEXT");
		@SuppressWarnings("unchecked")
		List<GrantedAuthority> authorities = (List<GrantedAuthority>) securityContextImpl.getAuthentication()
				.getAuthorities();
		for (GrantedAuthority grantedAuthority : authorities) {
			authority = authority + grantedAuthority.getAuthority() + "|";
		}

		JSONObject jo3 = new JSONObject();
		jo3.put("authority", authority);
		JSONArray jsonArray = new JSONArray();
		String userId = request.getParameter("userId");

		CxtdDoc05 kjlj = cxtdDocService.getDoc05(Integer.parseInt(userId));
		jsonArray.add(kjlj);
		jsonArray.add(jo3);
		// return gson.toJson(jcqn);
		return jsonArray.toString();
	}

	// 添加、更新操作记录
	@RequestMapping(value = "/cxtdDoc05Update", method = RequestMethod.POST)
	@ResponseBody
	public String kjljDoc05Update(CxtdDoc05 cxtdDao05, HttpServletRequest request) {
		JsonObject jsonResponse = new JsonObject();
		int user_id = (Integer) request.getSession().getAttribute("user_id");
		cxtdDao05.setUser_id(user_id);

		int result = 0;
		try {
			if (cxtdDocService.getDoc05(user_id).getNeedsRelevanceSupport() != null) {
				result = cxtdDocService.updateDoc05(cxtdDao05) ? 1 : 0;
				System.err.println(result);
			}

			else {
				result = cxtdDocService.insertDoc05(cxtdDao05) ? 1 : 0;
			}

		} catch (Exception e) {
			result = 0;
		}
		jsonResponse.addProperty("result", result);
		return jsonResponse.toString();

	}

}
