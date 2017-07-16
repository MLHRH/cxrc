package com.jfn.vo;

/**
 * Created by xubin on 2017/5/14
 */
public class TeamBaseExcel{
	private String applyId;
	private String orther;
	private String teamId ;
    private String teamName;
    private String searchDirection;
    private String relateProjectName;
    private String relateProjectCategory;
    private String institution;
    private String recommandInstitution;
    private String teamLeader;

    public String getApplyId() {
		return applyId;
	}

	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}

	public String getOrther() {
		return orther;
	}

	public void setOrther(String orther) {
		this.orther = orther;
	}

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public String getTeamLeader() {
		return teamLeader;
	}

	public void setTeamLeader(String teamLeader) {
		this.teamLeader = teamLeader;
	}

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
