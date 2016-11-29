package com.jfn.entity;

import java.util.List;

public class ApplyGroup extends Group{
	private Integer user_id ;
	private Integer apply_id;
	private String role;
	private String name;
	private String body;
	private String type;
	private String date;
	private String group;
	private List<Body> bodys;
	private List<Group> groups;
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getApply_id() {
		return apply_id;
	}
	public void setApply_id(Integer apply_id) {
		this.apply_id = apply_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public List<Body> getBodys() {
		return bodys;
	}
	public void setBodys(List<Body> bodys) {
		this.bodys = bodys;
	}
	public List<Group> getGroups() {
		return groups;
	}
	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}
	@Override
	public String toString() {
		return "ApplyGroup [name=" + name + ", body=" + body + ", type=" + type + ", date=" + date + ", group=" + group
				+ "]";
	}

}
