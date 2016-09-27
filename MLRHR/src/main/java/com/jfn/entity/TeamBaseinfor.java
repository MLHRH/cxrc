package com.jfn.entity;

public class TeamBaseinfor {
	private Integer user_id;
	//申报领域
	private Integer group_id;
	//依托项目类别
	private String project_type;
	//依托项目名称
	private String project_name;
	//依托项目来源
	private String project_source;
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getGroup_id() {
		return group_id;
	}
	public void setGroup_id(Integer group_id) {
		this.group_id = group_id;
	}
	public String getProject_type() {
		return project_type;
	}
	public void setProject_type(String project_type) {
		this.project_type = project_type;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public String getProject_source() {
		return project_source;
	}
	public void setProject_source(String project_source) {
		this.project_source = project_source;
	}
	
}
