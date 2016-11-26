package com.jfn.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.jfn.entity.ApplyGroup;
import com.jfn.entity.ExpertGroup;
import com.jfn.entity.Group;
import com.jfn.service.GroupService;

@Controller
public class GroupController {
	@Autowired 
	private GroupService groupService;
	@RequestMapping(value = "group", method = RequestMethod.GET)
	public String bodyManger(HttpServletRequest request, Model model) {
		return "body/group";
	}
	
	/**
	 * 获取分组列表
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "groupTree", method = RequestMethod.GET)
	public Object groupTree(HttpServletRequest request, Model model) {
		List<Group> groupList = groupService.getAllGroupTree();
		return groupList;
	}
	/**
	 * 获取申请的分组情况列表
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "initApplyByGroupId", method = RequestMethod.GET)
	public Object initApplyGroup(HttpServletRequest request){
		String group_id = request.getParameter("group_id");
		String role_type = request.getParameter("role_type");
		List<ApplyGroup> list = groupService.getApplyGroupById(Integer.valueOf(group_id),
				Integer.valueOf(role_type));
		return list;
	}
	/**
	 * 获取专家分组情况列表
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "initExpertByGroupId", method = RequestMethod.GET)
	public Object initExpertGroup(HttpServletRequest request){
		String group_id = request.getParameter("group_id");
		String role_type = request.getParameter("role_type");
		List<ExpertGroup> groups = groupService.gExpertGroups(Integer.valueOf(group_id),
				Integer.valueOf(role_type));
		return groups;
	}
	/**
	 * 获取申请分组信息
	 * @return
	 */
	@RequestMapping(value = "ApplyGroupInfo",method = RequestMethod.GET)
	public String getApplyGroupInfo(HttpServletRequest request,Model model){
		String applyId = request.getParameter("applyId");
		ApplyGroup applyGroup = groupService.getApplyGroup(Integer.valueOf(applyId));
		model.addAttribute("applyInfo", applyGroup);
		return "body/applyGroup";
	}
	/**
	 * 获取专家分组信息
	 * @return
	 */
	@RequestMapping(value = "expertGroupInfo",method = RequestMethod.GET)
	public String getExpertGroupInfo(HttpServletRequest request,Model model){
		String expertId = request.getParameter("expertId");
		ExpertGroup expertGroup = groupService.getExpertGroup(Integer.valueOf(expertId));
		model.addAttribute("expertInfo", expertGroup);
		return "body/expertGroup";
	}
	
	@ResponseBody
	@RequestMapping(value = "updateApplyGroup",method = RequestMethod.POST)
	public Object updateApplyGroup(HttpServletRequest request){
		String applyId = request.getParameter("applyId");
		String groupId = request.getParameter("groupId");
		JSONObject result = new JSONObject();
		groupService.updateApplyGroup(Integer.valueOf(groupId), Integer.valueOf(applyId),
				result);
		return result;
	}
	@ResponseBody
	@RequestMapping(value = "updateExpertGroup",method = RequestMethod.POST)
	public Object updateExpertGroup(HttpServletRequest request){
		String expertId = request.getParameter("expertId");
		String groupId = request.getParameter("groupId");
		String teamLeaderType = request.getParameter("teamLeaderType");
		JSONObject result = new JSONObject();
		groupService.updateExpertGroup(Integer.valueOf(groupId), teamLeaderType,
				Integer.valueOf(expertId) ,result);
		
		return result;
	}
}
