package com.jfn.entity;

public class cxtdRewardDoc06 {
    private Long id;

    private Integer starts;

    private String projectName;

    private String rewardName;

    private String level;

    private String grantInstitution;

    private String rewardNameLevel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStarts() {
        return starts;
    }

    public void setStarts(Integer starts) {
        this.starts = starts;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public String getRewardName() {
        return rewardName;
    }

    public void setRewardName(String rewardName) {
        this.rewardName = rewardName == null ? null : rewardName.trim();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public String getGrantInstitution() {
        return grantInstitution;
    }

    public void setGrantInstitution(String grantInstitution) {
        this.grantInstitution = grantInstitution == null ? null : grantInstitution.trim();
    }

    public String getRewardNameLevel() {
        return rewardNameLevel;
    }

    public void setRewardNameLevel(String rewardNameLevel) {
        this.rewardNameLevel = rewardNameLevel == null ? null : rewardNameLevel.trim();
    }
}