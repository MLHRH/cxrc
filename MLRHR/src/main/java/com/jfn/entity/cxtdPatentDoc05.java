package com.jfn.entity;

public class cxtdPatentDoc05 {
    private Long id;

    private Integer status;

    private String patentName;

    private String grantNumber;

    private String type;

    private String inventorSort;

    private String authorizedTime;

    private String authorizedNational;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getInventorSort() {
        return inventorSort;
    }

    public void setInventorSort(String inventorSort) {
        this.inventorSort = inventorSort == null ? null : inventorSort.trim();
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