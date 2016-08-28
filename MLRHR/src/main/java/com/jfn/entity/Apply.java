package com.jfn.entity;

public class Apply {
	//用户ID
	private Integer user_id;
	//申请时间
	private String apply_date;
	//申请的类型
   private String apply_type;
   //申请的name
   private String apply_name;
   //申请的状态
   private String status;
   //主管单位操作时间
   private String pre_approve_date;
   //主管单位操作者ID
   private String pre_approve_id;
   //主管单位操作者意见
   private String pre_approve_sug;
   //评审小组意见
   private String finial_approve_sug;
   //评审小组操作者id
   private String finial_approve_id;
   //评审小组操作时间
   private String finial_approve_date;
   
   
   //初审专家操作时间
   private String expert1_date;
   //初审专家ID
   private String expert1_id;
   //初审专家平均分
   private String expert1_scroe;
   //初审专家意见
   private String expert1_sug;
   //复审专家操作时间
   private String expert2_date;
   //复审专家操作者id
   private String expert2_id;
   //复审专家平均分
   private String expert2_score;
   //复审专家意见
   private String expert2_sug;

public String getExpert2_date() {
	return expert2_date;
}
public void setExpert2_date(String expert2_date) {
	this.expert2_date = expert2_date;
}
public String getApply_date() {
	return apply_date;
}
public Integer getUser_id() {
	return user_id;
}
public void setUser_id(Integer user_id) {
	this.user_id = user_id;
}
public String getFinial_approve_id() {
	return finial_approve_id;
}
public void setFinial_approve_id(String finial_approve_id) {
	this.finial_approve_id = finial_approve_id;
}
public String getFinial_approve_date() {
	return finial_approve_date;
}
public void setFinial_approve_date(String finial_approve_date) {
	this.finial_approve_date = finial_approve_date;
}
public void setApply_date(String apply_date) {
	this.apply_date = apply_date;
}
public String getApply_type() {
	return apply_type;
}
public void setApply_type(String apply_type) {
	this.apply_type = apply_type;
}
public String getApply_name() {
	return apply_name;
}
public void setApply_name(String apply_name) {
	this.apply_name = apply_name;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getPre_approve_date() {
	return pre_approve_date;
}
public void setPre_approve_date(String pre_approve_date) {
	this.pre_approve_date = pre_approve_date;
}
public String getPre_approve_id() {
	return pre_approve_id;
}
public void setPre_approve_id(String pre_approve_id) {
	this.pre_approve_id = pre_approve_id;
}
public String getPre_approve_sug() {
	return pre_approve_sug;
}
public void setPre_approve_sug(String pre_approve_sug) {
	this.pre_approve_sug = pre_approve_sug;
}
public String getFinial_approve_sug() {
	return finial_approve_sug;
}
public void setFinial_approve_sug(String finial_approve_sug) {
	this.finial_approve_sug = finial_approve_sug;
}
public String getExpert1_date() {
	return expert1_date;
}
public void setExpert1_date(String expert1_date) {
	this.expert1_date = expert1_date;
}
public String getExpert1_id() {
	return expert1_id;
}
public void setExpert1_id(String expert1_id) {
	this.expert1_id = expert1_id;
}
public String getExpert1_scroe() {
	return expert1_scroe;
}
public void setExpert1_scroe(String expert1_scroe) {
	this.expert1_scroe = expert1_scroe;
}
public String getExpert1_sug() {
	return expert1_sug;
}
public void setExpert1_sug(String expert1_sug) {
	this.expert1_sug = expert1_sug;
}
public String getExpert2_id() {
	return expert2_id;
}
public void setExpert2_id(String expert2_id) {
	this.expert2_id = expert2_id;
}
public String getExpert2_score() {
	return expert2_score;
}
public void setExpert2_score(String expert2_score) {
	this.expert2_score = expert2_score;
}
public String getExpert2_sug() {
	return expert2_sug;
}
public void setExpert2_sug(String expert2_sug) {
	this.expert2_sug = expert2_sug;
}
   
   
   
   
   
}
