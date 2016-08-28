package com.jfn.entity;

public class ExpertUser {
	//专家ID
	private Integer user_id;
	//所属分组id
	private Integer group_id;
	//1:组长；2：副组长；3:成员
	private Integer team_leader_type;
	//性别
	private String gender;
	//民族
	private String minzu;
	//出生年月
	private String birthday;
	//通讯地址
	private String address;
	//技术职称
	private String zhicheng;
	//从事专业/研究方向
	private String congshizhuanye;
	//1:京内 0:京外
	private Integer within_beijing;
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getGroup_id() {
		return group_id;
	}
	public void setGroup_id(Integer group_id) {
		this.group_id = group_id;
	}
	public Integer getTeam_leader_type() {
		return team_leader_type;
	}
	public void setTeam_leader_type(Integer team_leader_type) {
		this.team_leader_type = team_leader_type;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMinzu() {
		return minzu;
	}
	public void setMinzu(String minzu) {
		this.minzu = minzu;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public Integer getWithin_beijing() {
		return within_beijing;
	}
	public void setWithin_beijing(Integer within_beijing) {
		this.within_beijing = within_beijing;
	}
	

}
