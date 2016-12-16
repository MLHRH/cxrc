package com.jfn.entity;

public class CxtdDao05 {
	private int user_id;

	private int id;

	private String needsRelevanceSupport;

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

	public String getNeedsRelevanceSupport() {
		return needsRelevanceSupport;
	}

	public void setNeedsRelevanceSupport(String needsRelevanceSupport) {
		this.needsRelevanceSupport = needsRelevanceSupport == null ? null : needsRelevanceSupport.trim();
	}

}
