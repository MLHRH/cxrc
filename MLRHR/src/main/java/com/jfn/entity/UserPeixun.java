package com.jfn.entity;

/**
 * 用户.
 * 
 * @author chenzhu
 */
public class UserPeixun {

	private Integer id;
	private String user_id;
	private String start_date;

	private String end_date;
	private String major;
	private String country;
	private String academy;
	private String xueli;

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


	public String getXueli() {
		return xueli;
	}

	public void setXueli(String xueli) {
		this.xueli = xueli;
	}


	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAcademy() {
		return academy;
	}

	public void setAcademy(String academy) {
		this.academy = academy;
	}
	@Override
	public String toString() {
		return "UserPeixun [id=" + id + ", user_id=" + user_id + ", country="
				+ country + ", academy=" + academy + ", major=" + major
				+ ", xueli=" + xueli + ", start_date=" + start_date
				+ ", end_date=" + end_date +"]";
	}
}