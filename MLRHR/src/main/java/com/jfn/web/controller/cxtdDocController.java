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
import com.jfn.entity.CxtdBaseInfo;
import com.jfn.entity.CxtdDoc01;
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
}
