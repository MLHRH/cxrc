package com.jfn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONObject;
import com.jfn.common.util.Constant;
import com.jfn.dao.GroupDao;
import com.jfn.entity.ApplyGroup;
import com.jfn.entity.ExpertGroup;
import com.jfn.entity.ExpertScore;
import com.jfn.entity.Group;

@Repository
public class GroupService {
	@Autowired
	private GroupDao groupDao;
	
	/**
	 * 获取小组列表
	 * @return
	 */
	public List<Group> getAllGroupTree(){
		return groupDao.getGroupTree();
	}
	/**
	 * 获取apply分组信息
	 * @param id
	 * @return
	 */
	public List<ApplyGroup> getApplyGroupById(Integer id,Integer role){
		return groupDao.getApplyGroupById(id,role);
	}
	/**
	 * 获取专家分组信息
	 * @param id
	 * @param role
	 * @return
	 */
	public List<ExpertGroup> gExpertGroups(Integer id,Integer role){
		return groupDao.getExpertGroup(id, role);
	}
	/**
	 * 更新分组信息apply
	 * @param groupId
	 * @param applyId
	 */
	public void updateApplyGroup(Integer groupId,Integer applyId,JSONObject result){
		boolean flag = groupDao.updateApplyGroup(groupId, applyId);
		if(flag){
			result.put(Constant.STATUS, Constant.STATUS_SUCCESS);
			result.put(Constant.MSG, "更新成功");
		}else{
			result.put(Constant.STATUS, Constant.STAUS_FAIL);
			result.put(Constant.MSG, "更新失败");
		}
	}
	/**
	 * 更新专家分组信息
	 * @param groupId
	 * @param teamLeaderType
	 * @param expertId
	 */
	public void updateExpertGroup(Integer groupId,Integer teamLeaderType,Integer expertId,
			JSONObject result){
		boolean flag = groupDao.updateExpertGroup(groupId, teamLeaderType, expertId);
		if(flag){
			result.put(Constant.STATUS, Constant.STATUS_SUCCESS);
			result.put(Constant.MSG, "更新成功");
		}else{
			result.put(Constant.STATUS, Constant.STAUS_FAIL);
			result.put(Constant.MSG, "更新失败");
		}
	}
	/**
	 * 获取申请分组信息
	 * @param applyId
	 * @return
	 */
	public ApplyGroup getApplyGroup(Integer applyId){
		ApplyGroup applyGroup =  groupDao.getApplyGroupByApplyId(applyId);
		//获取分组列表
		if(applyGroup != null){
			List<Group> groups = groupDao.getGroupTree();
			applyGroup.setGroups(groups);
		}
		return applyGroup;
	}
	/**
	 * 获取专家分组信息
	 * @param expertId
	 * @return
	 */
	public ExpertGroup getExpertGroup(Integer expertId){
		ExpertGroup expertGroup = groupDao.getExpertGroupByExpertId(expertId);
		//获取分组列表
		if(expertGroup != null){
			List<Group> groups = groupDao.getGroupTree();
			expertGroup.setGroups(groups);
		}
		return expertGroup;
	}
	/**
	 * 添加分组
	 * @param group
	 * @return
	 */
	public JSONObject addGroup(Group group){
		boolean flag = groupDao.addGroup(group);
		JSONObject result = new JSONObject();
		if(flag){
			result.put(Constant.STATUS, Constant.STATUS_SUCCESS);
			result.put(Constant.MSG, "添加分组成功");
		}else{
			result.put(Constant.STATUS, Constant.STAUS_FAIL);
			result.put(Constant.MSG, "添加分组失败");
		}
		return result;
	}
	/**
	 * 更新分组名字
	 * @param group
	 * @return
	 */
	public JSONObject updateGruop(Group group) {
		boolean flag = groupDao.updateGroup(group);
		JSONObject result = new JSONObject();
		if(flag){
			result.put(Constant.STATUS, Constant.STATUS_SUCCESS);
			result.put(Constant.MSG, "更新分组成功");
		}else{
			result.put(Constant.STATUS, Constant.STAUS_FAIL);
			result.put(Constant.MSG, "更新分组失败");
		}
		return result;
	}
	/**
	 * 删除分组信息
	 * @param group
	 * @return
	 */
	public JSONObject delGroup(Group group){
		boolean flag = groupDao.delGroup(group);
		JSONObject result = new JSONObject();
		if(flag){
			result.put(Constant.STATUS, Constant.STATUS_SUCCESS);
			result.put(Constant.MSG, "删除分组成功");
		}else{
			result.put(Constant.STATUS, Constant.STAUS_FAIL);
			result.put(Constant.MSG, "删除分组失败,请确认次分组中还有有效信息");
		}
		return result;
	}
	
	
	public Group getGroupTreeById( int groupId){
		return groupDao.getGroupTreebyId(groupId);
	}
}
