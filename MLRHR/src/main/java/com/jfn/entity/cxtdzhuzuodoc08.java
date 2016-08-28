package com.jfn.entity;

public class cxtdzhuzuodoc08 {
    private Long id;

    private Integer status;

    private String zhuozuoName;

    private String press;

    private String author;

    private String country;

    private String year;

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

    public String getZhuozuoName() {
        return zhuozuoName;
    }

    public void setZhuozuoName(String zhuozuoName) {
        this.zhuozuoName = zhuozuoName == null ? null : zhuozuoName.trim();
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press == null ? null : press.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }
}