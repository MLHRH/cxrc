package com.jfn.entity;

public class JcqnDocPatent {
	private int xuhao_id;
    private int  id;

    private int userId;

    private String patentName;

    private String grantNumber;

    private String inventorSort;

    private String type;

    private String authorizedTime;

    private String authorizedNational;
 
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

    public String getPatentName() {
        return patentName;
    }

    public void setPatentName(String patentName) {
        this.patentName = patentName == null ? null : patentName.trim();
    }

    public String getGrantNumber() {
        return grantNumber;
    }

    public void setGrantNumber(String grantNumber) {
        this.grantNumber = grantNumber == null ? null : grantNumber.trim();
    }

    public String getInventorSort() {
        return inventorSort;
    }

    public void setInventorSort(String inventorSort) {
        this.inventorSort = inventorSort == null ? null : inventorSort.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getAuthorizedTime() {
        return authorizedTime;
    }

    public void setAuthorizedTime(String authorizedTime) {
        this.authorizedTime = authorizedTime == null ? null : authorizedTime.trim();
    }

    public String getAuthorizedNational() {
        return authorizedNational;
    }

    public void setAuthorizedNational(String authorizedNational) {
        this.authorizedNational = authorizedNational == null ? null : authorizedNational.trim();
    }
}