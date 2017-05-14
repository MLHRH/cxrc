package com.jfn.vo;

/**
 * Created by xubin on 2017/5/14
 */
public class PersonSecondTrial extends PersonBaseExcel{
    private double voteRate;
    private Integer agreeNum;
    private Integer disagreeNum;
    private Integer waiverNum;

    public double getVoteRate(){
        return voteRate;
    }

    public void setVoteRate(double voteRate){
        this.voteRate = voteRate;
    }

    public Integer getAgreeNum(){
        return agreeNum;
    }

    public void setAgreeNum(Integer agreeNum){
        this.agreeNum = agreeNum;
    }

    public Integer getDisagreeNum(){
        return disagreeNum;
    }

    public void setDisagreeNum(Integer disagreeNum){
        this.disagreeNum = disagreeNum;
    }

    public Integer getWaiverNum(){
        return waiverNum;
    }

    public void setWaiverNum(Integer waiverNum){
        this.waiverNum = waiverNum;
    }

    @Override
    public String toString(){
        return "PersonSecondTrial{" + "voteRate=" + voteRate + ", agreeNum=" + agreeNum + ", disagreeNum=" +
                disagreeNum + ", waiverNum=" + waiverNum + '}';
    }
}
