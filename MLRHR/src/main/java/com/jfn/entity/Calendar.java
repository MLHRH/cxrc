package com.jfn.entity;


/**
 * 用户.
 * 
 * @author chenzhu
 */
public class Calendar
{

	private Integer id;
	private String start_date;
	private String end_date;

	private String jieshao;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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

	public String getJieshao() {
		return jieshao;
	}
	public void setJieshao(String jieshao) {
		this.jieshao = jieshao;
	}

	
}