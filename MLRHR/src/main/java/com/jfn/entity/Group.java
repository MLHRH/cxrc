package com.jfn.entity;

public class Group {
	//分组Id
	private Integer id;
	//分组name
	private String name;
	//分组ID
	private String Pid;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPid() {
		return Pid;
	}
	public void setPid(String pid) {
		Pid = pid;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "ApplyGroup [id=" + id + ", name=" + name + ", Pid=" + Pid +"]";
	}
	
}
