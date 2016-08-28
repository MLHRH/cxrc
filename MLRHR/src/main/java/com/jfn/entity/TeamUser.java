package com.jfn.entity;

import javax.xml.crypto.Data;

public class TeamUser {
//
private Integer user_id ;  
//真实姓名
private String name ; 
//性别
private String gender ; 
//出生年月
private String birthday ; 
//技术职称
private String zhicheng ; 
//从事专业/研究方向
private String congshizhuanye ; 
//身份证号
private String id_num ; 
//学位
private String xuewei ; 
//学历
private String xueli ; 
//所属组织ID
private String body_id ; 
//是否是团队负责人
private Integer is_team_leader ;
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
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getBirthday() {
	return birthday;
}
public void setBirthday(String birthday) {
	this.birthday = birthday;
}
public String getZhicheng() {
	return zhicheng;
}
public void setZhicheng(String zhicheng) {
	this.zhicheng = zhicheng;
}
public String getCongshizhuanye() {
	return congshizhuanye;
}
public void setCongshizhuanye(String congshizhuanye) {
	this.congshizhuanye = congshizhuanye;
}
public String getId_num() {
	return id_num;
}
public void setId_num(String id_num) {
	this.id_num = id_num;
}
public String getXuewei() {
	return xuewei;
}
public void setXuewei(String xuewei) {
	this.xuewei = xuewei;
}
public String getXueli() {
	return xueli;
}
public void setXueli(String xueli) {
	this.xueli = xueli;
}
public String getBody_id() {
	return body_id;
}
public void setBody_id(String body_id) {
	this.body_id = body_id;
}
public Integer getIs_team_leader() {
	return is_team_leader;
}
public void setIs_team_leader(Integer is_team_leader) {
	this.is_team_leader = is_team_leader;
} 


}
