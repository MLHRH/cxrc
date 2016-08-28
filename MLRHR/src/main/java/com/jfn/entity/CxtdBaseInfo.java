package com.jfn.entity;

public class CxtdBaseInfo {
	 private Integer id;
	    
	    private int userid;

	    public int getUserid() {
			return userid;
		}

		public void setUserid(int userid) {
			this.userid = userid;
		}

		private Integer teamId;

	    private String teamName;

	    private String researchDirection;

	    private String subordinateSubject1;

	    private String subordinateSubject2;

	    private String projectType;
	    
	    private String orther;

		private String projectName;

	    private String projectSource;

	    private String unitName;

	    private String organizationCode;

	    private String legalRepresentative;

	    private String competentDepartment;

	    private String unitAddresses;

	    private int zipCode;

	    private String contacts;

	    private String mobilePhone;

	    private String email;

	    private String fax;

	    private String telephone;
	    
	    private int status;

	    public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

		public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public int getTeamId() {
	        return teamId;
	    }

	    public void setTeamId(int teamId) {
	        this.teamId = teamId;
	    }
	    
	    public String getOrther() {
	 		return orther;
	 	}

	 	public void setOrther(String orther) {
	 		this.orther = orther;
	 	}

	    public String getTeamName() {
	        return teamName;
	    }

	    public void setTeamName(String teamName) {
	        this.teamName = teamName == null ? null : teamName.trim();
	    }

	    public String getResearchDirection() {
	        return researchDirection;
	    }

	    public void setResearchDirection(String researchDirection) {
	        this.researchDirection = researchDirection == null ? null : researchDirection.trim();
	    }

	    public String getSubordinateSubject1() {
	        return subordinateSubject1;
	    }

	    public void setSubordinateSubject1(String subordinateSubject1) {
	        this.subordinateSubject1 = subordinateSubject1 == null ? null : subordinateSubject1.trim();
	    }

	    public String getSubordinateSubject2() {
	        return subordinateSubject2;
	    }

	    public void setSubordinateSubject2(String subordinateSubject2) {
	        this.subordinateSubject2 = subordinateSubject2 == null ? null : subordinateSubject2.trim();
	    }

	    public String getProjectType() {
	        return projectType;
	    }

	    public void setProjectType(String projectType) {
	        this.projectType = projectType == null ? null : projectType.trim();
	    }

	    public String getProjectName() {
	        return projectName;
	    }

	    public void setProjectName(String projectName) {
	        this.projectName = projectName == null ? null : projectName.trim();
	    }

	    public String getProjectSource() {
	        return projectSource;
	    }

	    public void setProjectSource(String projectSource) {
	        this.projectSource = projectSource == null ? null : projectSource.trim();
	    }

	    public String getUnitName() {
	        return unitName;
	    }

	    public void setUnitName(String unitName) {
	        this.unitName = unitName == null ? null : unitName.trim();
	    }

	    public String getOrganizationCode() {
	        return organizationCode;
	    }

	    public void setOrganizationCode(String organizationCode) {
	        this.organizationCode = organizationCode == null ? null : organizationCode.trim();
	    }

	    public String getLegalRepresentative() {
	        return legalRepresentative;
	    }

	    public void setLegalRepresentative(String legalRepresentative) {
	        this.legalRepresentative = legalRepresentative == null ? null : legalRepresentative.trim();
	    }

	    public String getCompetentDepartment() {
	        return competentDepartment;
	    }

	    public void setCompetentDepartment(String competentDepartment) {
	        this.competentDepartment = competentDepartment == null ? null : competentDepartment.trim();
	    }

	    public String getUnitAddresses() {
	        return unitAddresses;
	    }

	    public void setUnitAddresses(String unitAddresses) {
	        this.unitAddresses = unitAddresses == null ? null : unitAddresses.trim();
	    }

	    public int getZipCode() {
	        return zipCode;
	    }

	    public void setZipCode(int zipCode) {
	        this.zipCode = zipCode;
	    }

	    public String getContacts() {
	        return contacts;
	    }

	    public void setContacts(String contacts) {
	        this.contacts = contacts == null ? null : contacts.trim();
	    }

	    public String getMobilePhone() {
	        return mobilePhone;
	    }

	    public void setMobilePhone(String mobilePhone) {
	        this.mobilePhone = mobilePhone == null ? null : mobilePhone.trim();
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email == null ? null : email.trim();
	    }

	    public String getFax() {
	        return fax;
	    }

	    public void setFax(String fax) {
	        this.fax = fax == null ? null : fax.trim();
	    }

	    public String getTelephone() {
	        return telephone;
	    }

	    public void setTelephone(String telephone) {
	        this.telephone = telephone == null ? null : telephone.trim();
	    }
}
