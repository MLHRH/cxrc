package com.jfn.entity;

public class ExpertScore {
private int id;
private int expert_id ;
private int user_id ;
private String expert_score ;
private String expert_pingyu ;
private int apply_id;

public int getApply_id() {
	return apply_id;
}
public void setApply_id(int apply_id) {
	this.apply_id = apply_id;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getExpert_id() {
	return expert_id;
}
public void setExpert_id(int expert_id) {
	this.expert_id = expert_id;
}
public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
public String getExpert_score() {
	return expert_score;
}
public void setExpert_score(String expert_score) {
	this.expert_score = expert_score;
}
public String getExpert_pingyu() {
	return expert_pingyu;
}
public void setExpert_pingyu(String expert_pingyu) {
	this.expert_pingyu = expert_pingyu;
}

}
