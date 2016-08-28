package com.jfn.entity;


/**
 * 用户.
 * 
 * @author chenzhu
 */
public class UserExam
{

	private Integer id;
	private String user_id;
	private String type;
	private String exam_date;
	private String kemu;
	private String chengji;
	private String zuzhizhe;

	
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
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getExam_date() {
		return exam_date;
	}
	public void setExam_date(String exam_date) {
		this.exam_date = exam_date;
	}
	public String getKemu() {
		return kemu;
	}
	public void setKemu(String kemu) {
		this.kemu = kemu;
	}
	public String getChengji() {
		return chengji;
	}
	public void setChengji(String chengji) {
		this.chengji = chengji;
	}
	public String getZuzhizhe() {
		return zuzhizhe;
	}
	public void setZuzhizhe(String zuzhizhe) {
		this.zuzhizhe = zuzhizhe;
	}


}