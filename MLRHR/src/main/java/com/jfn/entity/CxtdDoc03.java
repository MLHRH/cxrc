package com.jfn.entity;

public class CxtdDoc03 {
	private int user_id;

	private int id;

	private String selfAssessment;

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSelfAssessment() {
		return selfAssessment;
	}

	public void setSelfAssessment(String selfAssessment) {
		this.selfAssessment = selfAssessment == null ? null : selfAssessment.trim();
	}

}
