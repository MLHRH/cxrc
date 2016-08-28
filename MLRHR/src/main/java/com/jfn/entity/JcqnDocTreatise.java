package com.jfn.entity;

public class JcqnDocTreatise {
    private Long id;

    private Long userId;

    private String treatiseName;

    private String press;

    private String issuingCountry;

    private String year;

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

    public String getTreatiseName() {
        return treatiseName;
    }

    public void setTreatiseName(String treatiseName) {
        this.treatiseName = treatiseName == null ? null : treatiseName.trim();
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press == null ? null : press.trim();
    }

    public String getIssuingCountry() {
        return issuingCountry;
    }

    public void setIssuingCountry(String issuingCountry) {
        this.issuingCountry = issuingCountry == null ? null : issuingCountry.trim();
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }
}