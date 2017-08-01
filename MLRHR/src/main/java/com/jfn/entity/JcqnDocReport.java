package com.jfn.entity;

public class JcqnDocReport {
	private int xuhao_id;
    private int id;

    private int userId;

    private String reportName;

    private String meetingName;

    private String organizers;

    private String meetingTime;

    private String meetingPlace;

    private String reportType;
    
    private String peopleName;

    public String getPeopleName() {
		return peopleName;
	}

	public void setPeopleName(String peopleName) {
		this.peopleName = peopleName;
	}

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

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName == null ? null : reportName.trim();
    }

    public String getMeetingName() {
        return meetingName;
    }

    public void setMeetingName(String meetingName) {
        this.meetingName = meetingName == null ? null : meetingName.trim();
    }

    public String getOrganizers() {
        return organizers;
    }

    public void setOrganizers(String organizers) {
        this.organizers = organizers == null ? null : organizers.trim();
    }

    public String getMeetingTime() {
        return meetingTime;
    }

    public void setMeetingTime(String meetingTime) {
        this.meetingTime = meetingTime == null ? null : meetingTime.trim();
    }

    public String getMeetingPlace() {
        return meetingPlace;
    }

    public void setMeetingPlace(String meetingPlace) {
        this.meetingPlace = meetingPlace == null ? null : meetingPlace.trim();
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType == null ? null : reportType.trim();
    }
}