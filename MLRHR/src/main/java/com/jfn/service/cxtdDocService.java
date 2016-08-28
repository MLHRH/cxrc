package com.jfn.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONObject;
import com.jfn.dao.cxtdDoc01Dao;
import com.jfn.dao.cxtdDoc02Dao;
import com.jfn.entity.cxtdDoc01;

@Repository
public class cxtdDocService {
	@Autowired
	private cxtdDoc02Dao cxtddoc02Dao;
	@Autowired
	private cxtdDoc01Dao cxtddoc01Dao;
	
	public List<Object> queryCxtdDoc01(int userid){
		List<Object> list = new ArrayList<Object>();
		list.add(cxtddoc01Dao.queryCxtdDoc01(userid));
		list.add(cxtddoc02Dao.getByUserId(userid));
		list.add(cxtddoc02Dao.getCxtdDoc02_work(userid));
		list.add(cxtddoc02Dao.getCxtdDoc02_study(userid));
		return list;
		
	}
	public void updateDoc01(cxtdDoc01 cxtddoc01,int user_id,JSONObject result){
		
		try{
			 cxtddoc01Dao.updateCxtdDoc01(cxtddoc01,user_id);
			result.put("result", "更新成功");
		}catch(Exception e){
			result.put("result", "更新失败");
		}
	}
	
	
	public void insertDoc01(cxtdDoc01 cxtddoc01 ,int user_id,JSONObject result){
		try{
			 cxtddoc01Dao.insertCxtdDoc01(cxtddoc01,user_id);
			 result.put("result", "添加成功");
		}catch(Exception e){
			result.put("result", "添加失败");
			
		}
	}
	
	/**
	 * 查询status
	 * @param user_id
	 * @return
	 */
	public int queryStatus(int user_id){
		return cxtddoc01Dao.queryCxtdDoc01(user_id).getStatus();
		
	}

}
