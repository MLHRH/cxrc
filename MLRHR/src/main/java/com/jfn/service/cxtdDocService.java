package com.jfn.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONObject;
import com.jfn.dao.CxtdDoc01Dao;
import com.jfn.entity.CxtdBaseInfo;

@Repository
public class cxtdDocService {
	@Autowired
	private CxtdDoc01Dao cxtddoc01Dao;
	
	public List<Object> queryCxtdDoc01(int userid){
		List<Object> list = new ArrayList<Object>();
		list.add(cxtddoc01Dao.queryCxtdBase(userid));

		return list;
		
	}
	public void updateDoc01(CxtdBaseInfo cxtddoc01,int user_id,JSONObject result){
		
		try{
			 cxtddoc01Dao.updateCxtdBase(cxtddoc01,user_id);
			result.put("result", "更新成功");
		}catch(Exception e){
			result.put("result", "更新失败");
		}
	}
	
	
	public void insertDoc01(CxtdBaseInfo cxtddoc01 ,int user_id,JSONObject result){
		try{
			 cxtddoc01Dao.insertCxtdBase(cxtddoc01,user_id);
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
		return cxtddoc01Dao.queryCxtdBase(user_id).getStatus();
		
	}

}
