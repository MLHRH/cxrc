package com.jfn.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONObject;
import com.jfn.common.util.Constant;
import com.jfn.dao.UploadFileDao;
import com.jfn.entity.Attachfile;
import com.jfn.entity.User;

@Repository
public class FileService
{
	@Autowired
	private UploadFileDao uploadFileDao;
	@Autowired
	private ZhichengApplyService zhichengApplyService;
	
	/**
	 * 上传文件
	 * @param file
	 * @return
	 */
	public JSONObject insetFileLog(Attachfile file,User user){
		JSONObject result = new JSONObject();
		result.put(Constant.STATUS, Constant.STAUS_FAIL);
		result.put(Constant.MSG, "上传文件失败，请重新上传！");
		boolean flag = false;
		file.setUserid(user.getId());
		file.setUpload_time(dateFormat(new Date()));
		//判断之前上传的文件是否删除
		if(isNotExisted(file)){
			flag = uploadFileDao.insertUploadFile(file);
		}
		else{
			result.put(Constant.STATUS, Constant.STAUS_FAIL);
			result.put(Constant.MSG, "请先行删除之前上传的文件");
			return result;
		}
		if(flag){
			result.put(Constant.STATUS, Constant.STATUS_SUCCESS);
			result.put(Constant.MSG,"上传文件成功！");
		}
		return result;
	}
	/**
	 * 删除文件
	 * @param id
	 * @return
	 */
	public JSONObject delFile(int id){
		JSONObject result = new JSONObject();
		result.put(Constant.STATUS, Constant.STAUS_FAIL);
		result.put(Constant.MSG, "删除文件失败！");
		boolean flag = uploadFileDao.delFile(id);
		if(flag){
			result.put(Constant.STATUS, Constant.STATUS_SUCCESS);
			result.put(Constant.MSG,"删除文件成功！");
		}
		return result;
	}
	/**
	 * 查询文件信息
	 * @param applyid
	 * @return
	 */
	public Attachfile getFileByApplyId(int applyid){
		return uploadFileDao.queryFile(applyid);
	}
	public Attachfile getFileById(int id){
		return uploadFileDao.queryFileById(id);
	}
	/**
	 * 格式化日期
	 * @param date
	 * @return
	 */
	private String dateFormat(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = sdf.format(date);
		return dateStr;
	}
	
	/**
	 * 判断之前的文件是否存在
	 * @param file
	 * @return
	 */
	private boolean isNotExisted(Attachfile file){
		return uploadFileDao.queryFile(file.getApplyid()) == null ? true:false;
	}
	
	
	
}
