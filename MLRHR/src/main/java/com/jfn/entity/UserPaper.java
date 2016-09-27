package com.jfn.entity;

public class UserPaper {
	private Integer user_id;
	private String name;//论文题目
	private String author;//作者排序
	private String qikan_name;//期刊名称
	private String code;//年份、卷期及页码
	private String factor;//影响因子
	private String reference;//SCI他引次数
	private String reference_total;//他引总次数
	private String is_team_leader;//是否是团队负责人主持
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getQikan_name() {
		return qikan_name;
	}
	public void setQikan_name(String qikan_name) {
		this.qikan_name = qikan_name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getFactor() {
		return factor;
	}
	public void setFactor(String factor) {
		this.factor = factor;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getReference_total() {
		return reference_total;
	}
	public void setReference_total(String reference_total) {
		this.reference_total = reference_total;
	}
	public String getIs_team_leader() {
		return is_team_leader;
	}
	public void setIs_team_leader(String is_team_leader) {
		this.is_team_leader = is_team_leader;
	}

}
