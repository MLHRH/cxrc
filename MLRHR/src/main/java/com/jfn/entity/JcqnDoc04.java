package com.jfn.entity;

public class JcqnDoc04 {
    private int user_id;

    private int id;

    private String futurePlans;

   

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

    public String getFuturePlans() {
        return futurePlans;
    }

    public void setFuturePlans(String futurePlans) {
        this.futurePlans = futurePlans == null ? null : futurePlans.trim();
    }
}