package com.jfn.entity;

public class CxtdLeaderInfo {
	private Integer id;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	private int teamId;

    private int user_id;

    private String name;

    private String sex;

    private String country;

    private String minzu;

    private String position;

    private String birthday;

    private String documentType;

    private String documentNumber;

    private String direction;

    private String subordinateSubject1;

    private String subordinateSubject2;

    private String telephoneFax;

    private String mobilePhone;

    private String email;

    private String zipCode;

    private String addresses;

    public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getMinzu() {
		return minzu;
	}

	public void setMinzu(String minzu) {
		this.minzu = minzu;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getSubordinateSubject1() {
		return subordinateSubject1;
	}

	public void setSubordinateSubject1(String subordinateSubject1) {
		this.subordinateSubject1 = subordinateSubject1;
	}

	public String getSubordinateSubject2() {
		return subordinateSubject2;
	}

	public void setSubordinateSubject2(String subordinateSubject2) {
		this.subordinateSubject2 = subordinateSubject2;
	}

	public String getTelephoneFax() {
		return telephoneFax;
	}

	public void setTelephoneFax(String telephoneFax) {
		this.telephoneFax = telephoneFax;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getAddresses() {
		return addresses;
	}

	public void setAddresses(String addresses) {
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		return "CxtdLeaderInfo [id=" + id + ", teamId=" + teamId + ", user_id="
				+ user_id + ", name=" + name + ", sex=" + sex + ", country="
				+ country + ", minzu=" + minzu + ", position=" + position
				+ ", birthday=" + birthday + ", documentType=" + documentType
				+ ", documentNumber=" + documentNumber + ", direction="
				+ direction + ", subordinateSubject1=" + subordinateSubject1
				+ ", subordinateSubject2=" + subordinateSubject2
				+ ", telephoneFax=" + telephoneFax + ", mobilePhone="
				+ mobilePhone + ", email=" + email + ", zipCode=" + zipCode
				+ ", addresses=" + addresses + "]";
	}


}
