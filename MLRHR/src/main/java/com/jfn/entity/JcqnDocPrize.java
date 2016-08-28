package com.jfn.entity;

public class JcqnDocPrize {
    private Long id;

    private Long userId;

    private String awardItemName;

    private String prizeName;

    private String grade;

    private String sort;

    private String rewardTime;

    private String grantInstitution;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAwardItemName() {
        return awardItemName;
    }

    public void setAwardItemName(String awardItemName) {
        this.awardItemName = awardItemName == null ? null : awardItemName.trim();
    }

    public String getPrizeName() {
        return prizeName;
    }

    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName == null ? null : prizeName.trim();
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort == null ? null : sort.trim();
    }

    public String getRewardTime() {
        return rewardTime;
    }

    public void setRewardTime(String rewardTime) {
        this.rewardTime = rewardTime == null ? null : rewardTime.trim();
    }

    public String getGrantInstitution() {
        return grantInstitution;
    }

    public void setGrantInstitution(String grantInstitution) {
        this.grantInstitution = grantInstitution == null ? null : grantInstitution.trim();
    }
}