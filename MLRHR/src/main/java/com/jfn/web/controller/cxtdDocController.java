package com.jfn.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jfn.entity.CxtdBaseInfo;
import com.jfn.entity.CxtdDoc01;
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
	public Object cxtdDoc01Update(String cxtdDoc01,HttpServletRequest request){
		JSONObject result = new JSONObject();
		int user_id =(Integer)request.getSession().getAttribute("user_id");
		CxtdDoc01 doc01 = JSON.parseObject(cxtdDoc01, CxtdDoc01.class);
		if(doc01 != null){
			  if(((CxtdBaseInfo)cxtdDocService.queryCxtdDoc01(user_id).get("baseinfo")) !=null){
				  
		        	cxtdDocService.insertDoc01(doc01,user_id,result);
		        	System.err.println("插入记录");
		        }
		        else{
		        	cxtdDocService.updateDoc01(doc01,user_id, result);
		        	System.err.println("更新记录");
		        }
		}
		else{
			result.put("result", "信息为空");
		}

		return result.toString();
		
	}
}
