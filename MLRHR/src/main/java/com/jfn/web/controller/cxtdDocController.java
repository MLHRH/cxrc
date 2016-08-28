package com.jfn.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jfn.entity.CxtdBaseInfo;
import com.jfn.service.cxtdDocService;
@Controller
@RequestMapping("/")
public class cxtdDocController {
	@Autowired 
	private cxtdDocService cxtdDocService;
	
	@RequestMapping(value = "/cxtdDoc01Init", method = RequestMethod.GET)
	@ResponseBody
	public List<Object> cxtdDoc01Init(HttpServletRequest request){
		
		int userid =(Integer)request.getSession().getAttribute("user_id");
		return  cxtdDocService.queryCxtdDoc01(userid);
		
	}
	/**
	 * 修改和插入数据
	 * @param cxtddoc01
	 * @param request
	 * @return
	 */
	
	@RequestMapping(value = "/cxtdDoc01Update",method = RequestMethod.POST)
	@ResponseBody
	public Object cxtdDoc01Update(String cxtdBaseInfo,HttpServletRequest request){
		JSONObject result = new JSONObject();
		int user_id =(Integer)request.getSession().getAttribute("user_id");
		CxtdBaseInfo doc01 = JSON.parseObject(cxtdBaseInfo, CxtdBaseInfo.class);
		//更新记录
		cxtdDocService.updateDoc01(doc01,user_id,result);
		
		
		
		
		
		
		//cxtdDocService.insertDoc01(doc01,user_id,result);
/*	if(cxtddoc01 != null){
			  if(cxtdDocService.queryStatus(user_id) == 1){
				  
		        	cxtdDocService.insertDoc01(doc01,user_id,result);
		        }
		        else{
		        	cxtdDocService.updateDoc01(doc01, result);
		        }
		}
		else{
			result.put("result", "信息为空");
		}*/

		return result.toString();
		
	}
}
