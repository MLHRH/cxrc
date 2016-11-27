package com.jfn.entity;

import java.util.List;

public class ExpertGroup extends Group{
	private Integer expertId;
	private Integer level;
	private String zhiCheng;
	private String body;
	private String congShiFangXiang;
	private String group;
	private List<Body> bodys;
	private List<Group> groups;
	public Integer getExpertId() {
		return expertId;
	}
	public void setExpertId(Integer expertId) {
		this.expertId = expertId;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public String getZhiCheng() {
		return zhiCheng;
	}
	public void setZhiCheng(String zhiCheng) {
		this.zhiCheng = zhiCheng;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getCongShiFangXiang() {
		return congShiFangXiang;
	}
	public void setCongShiFangXiang(String congShiFangXiang) {
		this.congShiFangXiang = congShiFangXiang;
	}
	public List<Body> getBodys() {
		return bodys;
	}
	public void setBodys(List<Body> bodys) {
		this.bodys = bodys;
	}
	
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public List<Group> getGroups() {
		return groups;
	}
	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}
	@Override
	public String toString() {
		return "ExpertGroup [expertId=" + expertId + ", level=" + level + ", zhiCheng=" + zhiCheng + ", body=" + body
				+ ", congShiFangXiang=" + congShiFangXiang + "]";
	}

}
