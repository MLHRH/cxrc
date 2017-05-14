package com.jfn.vo;

import java.util.List;

/**
 * Created by xubin on 2017/5/14
 */
public class PersonFirstGroup{
    private String groupName;
    private List<PersonFirstTrial> personFirstTrials;

    public String getGroupName(){
        return groupName;
    }

    public void setGroupName(String groupName){
        this.groupName = groupName;
    }

    public List<PersonFirstTrial> getPersonFirstTrials(){
        return personFirstTrials;
    }

    public void setPersonFirstTrials(List<PersonFirstTrial> personFirstTrials){
        this.personFirstTrials = personFirstTrials;
    }
}
