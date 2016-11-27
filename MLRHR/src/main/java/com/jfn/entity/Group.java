package com.jfn.entity;

public class Group {
	//分组Id
	private Integer id;
	//分组name
	private String name;
	//分组ID
	private String pId;
	public String getName() {
		return name;
	}
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "ApplyGroup [id=" + id + ", name=" + name + ", Pid=" + pId +"]";
	}
	
}
