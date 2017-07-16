package com.jfn.vo;

/**
 * Created by xubin on 2017/5/14
 */
public class PersonBaseExcel{
	private String applyId;
    private String name;
    private String sex;
    private String birthday;
    private String technicalTitle;
    private String researchDirection;
    private String institution;
    private String recommandInstitution;
    
    public String getApplyId() {
		return applyId;
	}

	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}

	public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getSex(){
        return sex;
    }

    public void setSex(String sex){
        this.sex = sex;
    }

    public String getBirthday(){
        return birthday;
    }

    public void setBirthday(String birthday){
        this.birthday = birthday;
    }

    public String getTechnicalTitle(){
        return technicalTitle;
    }

    public void setTechnicalTitle(String technicalTitle){
        this.technicalTitle = technicalTitle;
    }

    public String getResearchDirection(){
        return researchDirection;
    }

    public void setResearchDirection(String researchDirection){
        this.researchDirection = researchDirection;
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
        return "PersonBaseExcel{" + "name='" + name + '\'' + ", sex='" + sex + '\'' + ", birthday='" + birthday +
                '\'' + ", technicalTitle='" + technicalTitle + '\'' + ", researchDirection='" + researchDirection +
                '\'' + ", institution='" + institution + '\'' + ", recommandInstitution='" + recommandInstitution + '\'' + '}';
    }
}
