package com.jfn.entity;

public class JcqnDocProject {
	private int xuhao_id;
    private int id;

    private int userId;

    private String entryName;

    private String projectNumber;

    private String funds;

    private String startStopTime;

    private String projectNature;

    private String role;

    public int getXuhao_id() {
		return xuhao_id;
	}

	public void setXuhao_id(int xuhao_id) {
		this.xuhao_id = xuhao_id;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEntryName() {
        return entryName;
    }

    public void setEntryName(String entryName) {
        this.entryName = entryName == null ? null : entryName.trim();
    }

    public String getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(String projectNumber) {
        this.projectNumber = projectNumber == null ? null : projectNumber.trim();
    }

    public String getFunds() {
        return funds;
    }

    public void setFunds(String funds) {
        this.funds = funds == null ? null : funds.trim();
    }

    public String getStartStopTime() {
        return startStopTime;
    }

    public void setStartStopTime(String startStopTime) {
        this.startStopTime = startStopTime == null ? null : startStopTime.trim();
    }

    public String getProjectNature() {
        return projectNature;
    }

    public void setProjectNature(String projectNature) {
        this.projectNature = projectNature == null ? null : projectNature.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }
}