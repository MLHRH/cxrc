package com.jfn.vo;

import java.util.List;

/**
 * Created by xubin on 2017/5/14
 */
public class PersonSecondGroup{
    private String groupName;
    private List<PersonSecondTrial> personSecondTrials;

    public String getGroupName(){
        return groupName;
    }

    public void setGroupName(String groupName){
        this.groupName = groupName;
    }

	public List<PersonSecondTrial> getPersonSecondTrials() {
		return personSecondTrials;
	}

	public void setPersonSecondTrials(List<PersonSecondTrial> personSecondTrials) {
		this.personSecondTrials = personSecondTrials;
	}

  
}
