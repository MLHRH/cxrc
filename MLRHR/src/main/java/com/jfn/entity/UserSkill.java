package com.jfn.entity;

import java.util.ArrayList;
import java.util.List;


import org.apache.commons.lang.builder.ToStringBuilder;
import org.springside.modules.utils.reflection.ConvertUtils;

/**
 * 用户.
 * 
 * @author chenzhu
 */
public class UserSkill
{

	private Integer id;
	private String user_id;
	private String start_date;

	private String project_name;
	private String jiaose;
	private String project_result;
	private String end_date;
	
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public String getJiaose() {
		return jiaose;
	}
	public void setJiaose(String jiaose) {
		this.jiaose = jiaose;
	}
	
	public String getProject_result() {
		return project_result;
	}
	public void setProject_result(String project_result) {
		this.project_result = project_result;
	}
	
	
	
	
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	

}