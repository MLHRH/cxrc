package com.jfn.entity;


public class Attachfile
{
	private int id;
	private int userid;
	private int applyid;
	private String file_name;
	private String newfilename;
	private String oldfilename;
	private String file_path;
	private long file_size; 
	private String applyType;
	private int applyStep;
	
	public String getApplyType() {
		return applyType;
	}
	public void setApplyType(String applyType) {
		this.applyType = applyType;
	}
	public int getApplyStep() {
		return applyStep;
	}
	public void setApplyStep(int applyStep) {
		this.applyStep = applyStep;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	private String upload_time; 
	private int uploader_id;
	private int file_type;
	/*
	 * 1图片类型（jpg、png、bmp）
	 * 2文档类型（doc、pdf）
	 */
	private int file_type_num;
	/*
	 * 1毕业证书、学位证书
	 * 2任职资格证书
	 * 3外语考试合格证或免试证明
	 * 4计算机考试合格证书或免试证明
	 * 5成果、业绩获奖证书证明
	 * 6项目合同书
	 * 7论文检索证明
	 * 8其他证明证书 
	 */
	
	public int getFile_type() {
		return file_type;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getNewfilename() {
		return newfilename;
	}
	public void setNewfilename(String newfilename) {
		this.newfilename = newfilename;
	}
	public String getOldfilename() {
		return oldfilename;
	}
	public void setOldfilename(String oldfilename) {
		this.oldfilename = oldfilename;
	}
	public int getApplyid() {
		return applyid;
	}
	public void setApplyid(int applyid) {
		this.applyid = applyid;
	}
	public void setFile_type(int file_type) {
		this.file_type = file_type;
	}
	public int getFile_type_num() {
		return file_type_num;
	}
	public void setFile_type_num(int file_type_num) {
		this.file_type_num = file_type_num;
	}
	public int getId()
	{
		return id;
	}
	public void setId( int id )
	{
		this.id = id;
	}
	public String getFile_path()
	{
		return file_path;
	}
	public void setFile_path( String file_path )
	{
		this.file_path = file_path;
	}
	public long getFile_size() {
		return file_size;
	}
	public void setFile_size(long file_size) {
		this.file_size = file_size;
	}
	public String getUpload_time() {
		return upload_time;
	}
	public void setUpload_time(String upload_time) {
		this.upload_time = upload_time;
	}
	public int getUploader_id()
	{
		return uploader_id;
	}
	public void setUploader_id( int uploader_id )
	{
		this.uploader_id = uploader_id;
	}
	
}
