package com.jfn.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.jfn.entity.CxtdBaseInfo;
import com.jfn.entity.CxtdDao05;
import com.jfn.entity.CxtdDoc01;
import com.jfn.entity.CxtdDoc03;
import com.jfn.entity.CxtdDoc04;
import com.jfn.entity.CxtdLeaderInfo;
import com.jfn.entity.CxtdLeaderZuzhi;
import com.jfn.entity.CxtdMemberInfo;
import com.jfn.entity.CxtdMemberNum;
import com.jfn.service.cxtdDocService;
@Controller
@RequestMapping("/")
public class cxtdDocController {
	@Autowired 
	private cxtdDocService cxtdDocService;
	/**
	 * 初始化doc01
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/cxtdDoc01Init", method = RequestMethod.GET)
	@ResponseBody
	public Object cxtdDoc01Init(HttpServletRequest request){
		
		int userid =(Integer)request.getSession().getAttribute("user_id");
		return  cxtdDocService.queryCxtdDoc01(userid);
		
		}
		
	/**
	 * 更新DOC01
	 * @param cxtddoc01
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/cxtdDoc01Update",method = RequestMethod.POST)
	@ResponseBody
	public Object cxtdDoc01Update(String baseinfo,String leaderinfo,String memnum,String meminfos,
			String zuzhis,HttpServletRequest request){
		JSONObject result = new JSONObject();
		int user_id =(Integer)request.getSession().getAttribute("user_id");
		//组织对象
		CxtdBaseInfo baseInfo = JSON.parseObject(baseinfo, CxtdBaseInfo.class);
		CxtdLeaderInfo leaderInfo = JSON.parseObject(leaderinfo, CxtdLeaderInfo.class);
		CxtdMemberNum memNum = JSON.parseObject(memnum, CxtdMemberNum.class);
		
		List<CxtdLeaderZuzhi> zuzhi = JSONArray.parseArray(zuzhis, CxtdLeaderZuzhi.class);
		List<CxtdMemberInfo> meminfo = JSONArray.parseArray(meminfos, CxtdMemberInfo.class);
		CxtdDoc01 doc01 = new CxtdDoc01();
		doc01.setBaseInfo(baseInfo);
		doc01.setLeaderInfo(leaderInfo);
		doc01.setMemNum(memNum);
		doc01.setmList(meminfo);
		doc01.setzList(zuzhi);
		System.err.println("基本信息"+baseInfo.toString());
		System.err.println("负责人信息："+leaderInfo.toString());
		System.err.println("团队成员人数统计"+memNum.toString());
		cxtdDocService.updateDoc01(doc01, user_id, result);
		return result;
		
	}

	// 获取信息
	@RequestMapping(value = "/cxtdDoc03Init", method = RequestMethod.GET)
	@ResponseBody
	public CxtdDoc03 kjljDoc03Init(HttpServletRequest request) {
		String userId = request.getParameter("userId");
		System.err.println("-----------" + userId);
		CxtdDoc03 cxtd = cxtdDocService.getDao03(Integer.parseInt(userId));
		// Gson gson = new Gson();
		System.err.println(cxtd);
		// return gson.toJson(kjlj);
		return cxtd;
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
	public CxtdDoc04 kjljDoc04Init(HttpServletRequest request) {
		String userId = request.getParameter("userId");
		System.err.println("-----------" + userId);
		CxtdDoc04 kjlj = cxtdDocService.getDoc4(Integer.parseInt(userId));
		// Gson gson = new Gson();
		System.err.println(kjlj);
		// return gson.toJson(kjlj);
		return kjlj;
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
	public CxtdDao05 kjljDoc05Init(HttpServletRequest request) {
		String userId = request.getParameter("userId");
		System.err.println("-----------" + userId);
		CxtdDao05 kjlj = cxtdDocService.getDoc05(Integer.parseInt(userId));
		// Gson gson = new Gson();
		System.err.println(kjlj);
		// return gson.toJson(kjlj);
		return kjlj;
	}

	// 添加、更新操作记录
	@RequestMapping(value = "/cxtdDoc05Update", method = RequestMethod.POST)
	@ResponseBody
	public String kjljDoc05Update(CxtdDao05 cxtdDao05, HttpServletRequest request) {
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
