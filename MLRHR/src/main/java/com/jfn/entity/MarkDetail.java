package com.jfn.entity;

public class MarkDetail {
	//1:初选 2：复选
	private Integer type;
	//个人/团队id
	private Integer user_id;
    //专家成员id
	private Integer expert_id;
	//具体分值
	private Integer score;
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getExpert_id() {
		return expert_id;
	}
	public void setExpert_id(Integer expert_id) {
		this.expert_id = expert_id;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}

}
