package com.jfn.entity;

public class UserZhuanZhu {
	
  private Integer user_id;
  //年份
  private String date;
  //专著名称
  private String name;
  
  //出版社
  private String publisher;
  //发行国家和地区
  
  private String area;
  //是否是团队负责人主持
  private Integer is_team_leader;
public Integer getUser_id() {
	return user_id;
}
public void setUser_id(Integer user_id) {
	this.user_id = user_id;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPublisher() {
	return publisher;
}
public void setPublisher(String publisher) {
	this.publisher = publisher;
}
public String getArea() {
	return area;
}
public void setArea(String area) {
	this.area = area;
}
public Integer getIs_team_leader() {
	return is_team_leader;
}
public void setIs_team_leader(Integer is_team_leader) {
	this.is_team_leader = is_team_leader;
}
  
}
