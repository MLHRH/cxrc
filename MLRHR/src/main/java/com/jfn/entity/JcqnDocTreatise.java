package com.jfn.entity;

public class JcqnDocTreatise {
	private int xuhao_id;
    private int  id;

    private int userId;

    private String treatiseName;

    private String press;

    private String issuingCountry;

    private String year;

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