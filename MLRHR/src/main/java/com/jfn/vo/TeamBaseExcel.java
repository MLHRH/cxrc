package com.jfn.vo;

/**
 * Created by xubin on 2017/5/14
 */
public class TeamBaseExcel{
    private String teamName;
    private String searchDirection;
    private String relateProjectName;
    private String relateProjectCategory;
    private String institution;
    private String recommandInstitution;

    public String getTeamName(){
        return teamName;
    }

    public void setTeamName(String teamName){
        this.teamName = teamName;
    }

    public String getSearchDirection(){
        return searchDirection;
    }

    public void setSearchDirection(String searchDirection){
        this.searchDirection = searchDirection;
    }

    public String getRelateProjectName(){
        return relateProjectName;
    }

    public void setRelateProjectName(String relateProjectName){
        this.relateProjectName = relateProjectName;
    }

    public String getRelateProjectCategory(){
        return relateProjectCategory;
    }

    public void setRelateProjectCategory(String relateProjectCategory){
        this.relateProjectCategory = relateProjectCategory;
    }

    public String getInstitution(){
        return institution;
    }

    public void setInstitution(String institution){
        this.institution = institution;
    }

    public String getRecommandInstitution(){
        return recommandInstitution;
    }

    public void setRecommandInstitution(String recommandInstitution){
        this.recommandInstitution = recommandInstitution;
    }

    @Override
    public String toString(){
        return "TeamBaseExcel{" + "teamName='" + teamName + '\'' + ", searchDirection='" + searchDirection + '\'' +
                ", relateProjectName='" + relateProjectName + '\'' + ", relateProjectCategory='" +
                relateProjectCategory + '\'' + ", institution='" + institution + '\'' + ", recommandInstitution='" +
                recommandInstitution + '\'' + '}';
    }
}
