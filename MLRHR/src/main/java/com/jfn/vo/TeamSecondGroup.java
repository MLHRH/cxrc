package com.jfn.vo;

import java.util.List;

/**
 * Created by xubin on 2017/5/14
 */
public class TeamSecondGroup{
    private String groupName;
    private List<TeamSecondTrial> teamSecondTrials;

    public String getGroupName(){
        return groupName;
    }

    public void setGroupName(String groupName){
        this.groupName = groupName;
    }

	public List<TeamSecondTrial> getTeamSecondTrials() {
		return teamSecondTrials;
	}

	public void setTeamSecondTrials(List<TeamSecondTrial> teamSecondTrials) {
		this.teamSecondTrials = teamSecondTrials;
	}

}
