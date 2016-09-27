package com.jfn.entity;

public class ApplyMenu {
	private Integer id ;
	//菜单ID
	private String menuid;
	//菜单名称
	private String menudetails;
	//菜单类型
	private String menutype;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMenuid() {
		return menuid;
	}
	public void setMenuid(String menuid) {
		this.menuid = menuid;
	}
	public String getMenudetails() {
		return menudetails;
	}
	public void setMenudetails(String menudetails) {
		this.menudetails = menudetails;
	}
	public String getMenutype() {
		return menutype;
	}
	public void setMenutype(String menutype) {
		this.menutype = menutype;
	}

}
