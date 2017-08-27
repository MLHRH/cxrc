package com.jfn.entity;

public class UesrZuzhi {
	private Integer id;
	private Integer user_id;

	private String zuzhi_name;
	/*
	 * 角色
	 */
	private String zuzhi_job;
	/*
	 * 类型
	 */
	private String zuzhi_renqi;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getZuzhi_name() {
		return zuzhi_name;
	}

	public void setZuzhi_name(String zuzhi_name) {
		this.zuzhi_name = zuzhi_name;
	}

	public String getZuzhi_job() {
		return zuzhi_job;
	}

	public void setZuzhi_job(String zuzhi_job) {
		this.zuzhi_job = zuzhi_job;
	}

	public String getZuzhi_renqi() {
		return zuzhi_renqi;
	}

	public void setZuzhi_renqi(String zuzhi_renqi) {
		this.zuzhi_renqi = zuzhi_renqi;
	}

	public UesrZuzhi() {
		super();
	}

	@Override
	public String toString() {
		return "UserWork [id=" + id + ", user_id=" + user_id + ", zuzhi_name=" + zuzhi_name + ", zuzhi_job=" + zuzhi_job
				+ ", zuzhi_renqi=" + zuzhi_renqi + "]";
	}

}
