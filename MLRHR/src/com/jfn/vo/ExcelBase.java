package com.jfn.vo;

import java.util.List;

/**
 * Created by xubin on 2017/5/14
 */
public class ExcelBase{
    private Integer applyStep;
    //初审
    private List<PersonFirstGroup> jcqnList;
    private List<PersonFirstGroup> kjljList;
    private List<TeamFirstGroup> teamFirstGroups;

    public Integer getApplyStep(){
        return applyStep;
    }

    public void setApplyStep(Integer applyStep){
        this.applyStep = applyStep;
    }

    public List<PersonFirstGroup> getJcqnList(){
        return jcqnList;
    }

    public void setJcqnList(List<PersonFirstGroup> jcqnList){
        this.jcqnList = jcqnList;
    }

    public List<PersonFirstGroup> getKjljList(){
        return kjljList;
    }

    public void setKjljList(List<PersonFirstGroup> kjljList){
        this.kjljList = kjljList;
    }

    public List<TeamFirstGroup> getTeamFirstGroups(){
        return teamFirstGroups;
    }

    public void setTeamFirstGroups(List<TeamFirstGroup> teamFirstGroups){
        this.teamFirstGroups = teamFirstGroups;
    }
}
