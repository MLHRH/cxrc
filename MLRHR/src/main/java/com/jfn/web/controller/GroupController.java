package com.jfn.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.jfn.common.util.Constant;
import com.jfn.entity.AcctUserRole;
import com.jfn.entity.ApplyGroup;
import com.jfn.entity.ExpertGroup;
import com.jfn.entity.ExpertUser;
import com.jfn.entity.Group;
import com.jfn.service.ExpertUserService;
import com.jfn.service.GroupService;
import com.jfn.service.UserRoleService;

import net.sf.json.JSONArray;

@Controller
public class GroupController {
	@Autowired 
	private GroupService groupService;
	@Autowired
	private ExpertUserService expertUserService ;
	@Autowired
	private UserRoleService userRoleService;
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
	public String groupTree(HttpServletRequest request, Model model) {
		List<Group> groupList = groupService.getAllGroupTree();
		
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
		jsonArray.add(groupList);
		jsonArray.add(jo3);
		return jsonArray.toString();
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
		ExpertUser expertUser = expertUserService.getById(expertId);
		AcctUserRole userRole = userRoleService.getByUserId(expertUser.getUser_id());
		if (userRole.getRole_id() == 5) {
			model.addAttribute("roleId",1);
		}else {
			model.addAttribute("roleId",2);
		}
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
		String fushenexpert = request.getParameter("fushenexpert");
		Boolean fushen = false ;
		if (fushenexpert.equals("1")) {
			fushen =true;
		}
		JSONObject result = new JSONObject();
		ExpertUser expertUser = expertUserService.getById(expertId);
		AcctUserRole userRole = userRoleService.getByUserId(expertUser.getUser_id());
		    if (userRole.getRole_id() == 4 && fushen == true) {		
		    int role_id = 5 ;
		    userRoleService.update(role_id,expertUser.getUser_id());
			groupService.updateExpertGroup(Integer.valueOf(groupId), Integer.valueOf(teamLeaderType),
					Integer.valueOf(expertId) ,result);
		}else if (userRole.getRole_id() == 5 && fushen == false) {
			int role_id = 4 ;
			userRoleService.update(role_id,expertUser.getUser_id());
			groupService.updateExpertGroup(Integer.valueOf(groupId), Integer.valueOf(teamLeaderType),
					Integer.valueOf(expertId) ,result);
		}else {
			groupService.updateExpertGroup(Integer.valueOf(groupId), Integer.valueOf(teamLeaderType),
					Integer.valueOf(expertId) ,result);			
		}
		
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "updateGroup",method = RequestMethod.POST)
	public Object updateGroup(HttpServletRequest request, @ModelAttribute Group entity){
		JSONObject result = new JSONObject();
		String id = request.getParameter("id");
		if ((id == null) || (id.length() < 1)) {

			result = groupService.addGroup(entity);
		} else {
			result = groupService.updateGruop(entity);
		}
		return result;
	}
	@ResponseBody
	@RequestMapping(value = "delGroup",method=RequestMethod.GET)
	public Object delGroup(HttpServletRequest request){
		String id = request.getParameter("id");
		JSONObject result = new JSONObject();
		result.put(Constant.STATUS, Constant.STAUS_FAIL);
		result.put(Constant.MSG, "删除分组信息失败");
		Group group = new Group();
		if(id != null){
			group.setId(Integer.valueOf(id));
			result = groupService.delGroup(group);
		}
		return result;
	}
}
