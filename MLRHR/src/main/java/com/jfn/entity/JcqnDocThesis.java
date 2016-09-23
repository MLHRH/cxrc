package com.jfn.entity;

public class JcqnDocThesis {
	private int xuhao_id;
    private int id;

    private int userId;

    private String thesisTopic;

    private String authorSort;

    private String journalTitle;

    private String yearVolumePagenumber;

    private String influenceFactor;

    private String sciTimes;

//    private String numberTotal;
    

    public int getId() {
        return id;
    }

    public int getXuhao_id() {
		return xuhao_id;
	}

	public void setXuhao_id(int xuhao_id) {
		this.xuhao_id = xuhao_id;
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

    public String getThesisTopic() {
        return thesisTopic;
    }

    public void setThesisTopic(String thesisTopic) {
        this.thesisTopic = thesisTopic == null ? null : thesisTopic.trim();
    }

    public String getAuthorSort() {
        return authorSort;
    }

    public void setAuthorSort(String authorSort) {
        this.authorSort = authorSort == null ? null : authorSort.trim();
    }

    public String getJournalTitle() {
        return journalTitle;
    }

    public void setJournalTitle(String journalTitle) {
        this.journalTitle = journalTitle == null ? null : journalTitle.trim();
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

//    public String getNumberTotal() {
//        return numberTotal;
//    }
//
//    public void setNumberTotal(String numberTotal) {
//        this.numberTotal = numberTotal == null ? null : numberTotal.trim();
//    }
}