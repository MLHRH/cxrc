package com.jfn.entity;

public class cxtdProjecDoc04 {
    private Long id;

    private Integer status;

    private String projectName;

    private String projectNumber;

    private String funding;

    private String startStopTime;

    private String source;

    private String otherMember;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public String getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(String projectNumber) {
        this.projectNumber = projectNumber == null ? null : projectNumber.trim();
    }

    public String getFunding() {
        return funding;
    }

    public void setFunding(String funding) {
        this.funding = funding == null ? null : funding.trim();
    }

    public String getStartStopTime() {
        return startStopTime;
    }

    public void setStartStopTime(String startStopTime) {
        this.startStopTime = startStopTime == null ? null : startStopTime.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getOtherMember() {
        return otherMember;
    }

    public void setOtherMember(String otherMember) {
        this.otherMember = otherMember == null ? null : otherMember.trim();
    }
}