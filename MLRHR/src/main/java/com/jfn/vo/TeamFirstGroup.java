package com.jfn.vo;

import java.util.List;

/**
 * Created by xubin on 2017/5/14
 */
public class TeamFirstGroup{
    private String groupName;
    private List<TeamFirstTrial> teamFirstTrials;

    public String getGroupName(){
        return groupName;
    }

    public void setGroupName(String groupName){
        this.groupName = groupName;
    }

    public List<TeamFirstTrial> getTeamFirstTrials(){
        return teamFirstTrials;
    }

    public void setTeamFirstTrials(List<TeamFirstTrial> teamFirstTrials){
        this.teamFirstTrials = teamFirstTrials;
    }
}
