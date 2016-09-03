package com.jfn.entity;

public class CxtdMemberInfo {
	private Integer id;
	private Integer team_id;
	private String name;
	private String sex;
	private String birthday;
	private String id_type;
	private String id_num;
	private String study_education;
	private String work_position;
	private String direction;
	private String work_company;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTeam_id() {
		return team_id;
	}
	public void setTeam_id(Integer team_id) {
		this.team_id = team_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getId_type() {
		return id_type;
	}
	public void setId_type(String id_type) {
		this.id_type = id_type;
	}
	public String getId_num() {
		return id_num;
	}
	public void setId_num(String id_num) {
		this.id_num = id_num;
	}
	public String getStudy_education() {
		return study_education;
	}
	public void setStudy_education(String study_education) {
		this.study_education = study_education;
	}
	public String getWork_position() {
		return work_position;
	}
	public void setWork_position(String work_position) {
		this.work_position = work_position;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getWork_company() {
		return work_company;
	}
	public void setWork_company(String work_company) {
		this.work_company = work_company;
	}
	@Override
	public String toString() {
		return "CxtdMemberInfo [id=" + id + ", team_id=" + team_id + ", name="
				+ name + ", sex=" + sex + ", birthday=" + birthday
				+ ", id_type=" + id_type + ", id_num=" + id_num
				+ ", study_education=" + study_education + ", work_position="
				+ work_position + ", direction=" + direction
				+ ", work_company=" + work_company + "]";
	}

}
