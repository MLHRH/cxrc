package com.jfn.entity;
/**
 * @create-time 2014-8-8 下午7:54:27
 * @creator     佟德慧
 */
public class Body {
	
	
	private Integer id;
	private String name;
	private String pId;
	private String code;
	private String legal_person;
	private String telephone;
	private String mobile;
	private String telefax;
	private String bodyType;
	private String zip_code;
	private String web;
	private String contact;
	private String address;
	private String email;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the pId
	 */
	public String getpId() {
		return pId;
	}
	/**
	 * @param pId the pId to set
	 */
	public void setpId(String pId) {
		this.pId = pId;
	}
	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}
	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	/**
	 * @return the telefax
	 */
	public String getTelefax() {
		return telefax;
	}
	/**
	 * @param telefax the telefax to set
	 */
	public void setTelefax(String telefax) {
		this.telefax = telefax;
	}
	/**
	 * @return the bodyType
	 */
	public String getBodyType() {
		return bodyType;
	}
	/**
	 * @param bodyType the bodyType to set
	 */
	public void setBodyType(String bodyType) {
		this.bodyType = bodyType;
	}
	/**
	 * @return the web
	 */
	public String getWeb() {
		return web;
	}
	/**
	 * @param web the web to set
	 */
	public void setWeb(String web) {
		this.web = web;
	}
	/**
	 * @return the contact
	 */
	public String getContact() {
		return contact;
	}
	/**
	 * @param contact the contact to set
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLegal_person() {
		return legal_person;
	}
	public void setLegal_person(String legal_person) {
		this.legal_person = legal_person;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getZip_code() {
		return zip_code;
	}
	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}
	public Body(Integer id, String name, String pId, String code, String legal_person, String telephone, String mobile,
			String telefax, String bodyType, String zip_code, String web, String contact, String address,
			String email) {
		super();
		this.id = id;
		this.name = name;
		this.pId = pId;
		this.code = code;
		this.legal_person = legal_person;
		this.telephone = telephone;
		this.mobile = mobile;
		this.telefax = telefax;
		this.bodyType = bodyType;
		this.zip_code = zip_code;
		this.web = web;
		this.contact = contact;
		this.address = address;
		this.email = email;
	}
	public Body() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
