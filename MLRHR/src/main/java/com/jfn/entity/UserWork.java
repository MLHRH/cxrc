package com.jfn.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.jfn.dao.NewsDao.newsRowMapper;

/**
 * 用户.
 * 
 * @author chenzhu
 */
public class UserWork {
	
	
	private Integer id;
	private String user_id;
	private String start_date;

	private String zhiwu;

	private String work_content;


	private String end_date;
	private String job;
	private String toNow;
	
	public String getToNow() {
		return toNow;
	}
	public void setToNow(String toNow) {
		this.toNow = toNow;
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
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getZhiwu() {
		return zhiwu;
	}
	public void setZhiwu(String zhiwu) {
		this.zhiwu = zhiwu;
	}
	public String getWork_content() {
		return work_content;
	}
	public void setWork_content(String work_content) {
		this.work_content = work_content;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}


	
	
}
	