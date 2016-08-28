package com.jfn.entity;

public class cxtdPaperDoc09 {
    private Long id;

    private Integer status;

    private String paperName;

    private String author;

    private String qikanName;

    private String yearVolumePagenumber;

    private String influenceFactor;

    private String sciTimes;

    private String numberTotal;

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

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName == null ? null : paperName.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getQikanName() {
        return qikanName;
    }

    public void setQikanName(String qikanName) {
        this.qikanName = qikanName == null ? null : qikanName.trim();
    }

    public String getYearVolumePagenumber() {
        return yearVolumePagenumber;
    }

    public void setYearVolumePagenumber(String yearVolumePagenumber) {
        this.yearVolumePagenumber = yearVolumePagenumber == null ? null : yearVolumePagenumber.trim();
    }

    public String getInfluenceFactor() {
        return influenceFactor;
    }

    public void setInfluenceFactor(String influenceFactor) {
        this.influenceFactor = influenceFactor == null ? null : influenceFactor.trim();
    }

    public String getSciTimes() {
        return sciTimes;
    }

    public void setSciTimes(String sciTimes) {
        this.sciTimes = sciTimes == null ? null : sciTimes.trim();
    }

    public String getNumberTotal() {
        return numberTotal;
    }

    public void setNumberTotal(String numberTotal) {
        this.numberTotal = numberTotal == null ? null : numberTotal.trim();
    }
}