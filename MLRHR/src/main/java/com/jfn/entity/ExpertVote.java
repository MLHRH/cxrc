package com.jfn.entity;

public class ExpertVote {
private int id ;
private int expert_id;
private int apply_id;
private String expert_vote;
private String name ;

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
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
public int getApply_id() {
	return apply_id;
}
public void setApply_id(int apply_id) {
	this.apply_id = apply_id;
}
public String getExpert_vote() {
	return expert_vote;
}
public void setExpert_vote(String expert_vote) {
	this.expert_vote = expert_vote;
}

}
