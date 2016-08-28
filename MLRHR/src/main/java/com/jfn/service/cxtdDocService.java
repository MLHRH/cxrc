package com.jfn.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.jfn.dao.CxtdDoc01Dao;
import com.jfn.dao.UserPeixunDao;
import com.jfn.dao.UserWorkDao;
import com.jfn.entity.CxtdBaseInfo;
import com.jfn.entity.CxtdDoc01;
import com.jfn.entity.CxtdLeaderInfo;
import com.jfn.entity.CxtdLeaderZuzhi;
import com.jfn.entity.CxtdMemberInfo;
import com.jfn.entity.CxtdMemberNum;
import com.jfn.entity.UserPeixun;
import com.jfn.entity.UserWork;

@Repository
public class cxtdDocService {
	@Autowired
	private CxtdDoc01Dao cxtddoc01Dao;
	@Autowired
	private UserPeixunDao userPeixunDao;
	@Autowired
	private UserWorkDao userWorkDao;
	
	/**
	 * 初始化doc01
	 * @param user_id
	 * @return
	 */
	public Map<String, Object> queryCxtdDoc01(int user_id){
		Map<String, Object> doc01 = new HashMap<String, Object>();
		
		int team_id = cxtddoc01Dao.getTimeId(user_id);
		CxtdBaseInfo baseInfo = cxtddoc01Dao.queryCxtdBase(user_id);
		CxtdLeaderInfo leaderInfo = cxtddoc01Dao.queryCxtdLeaderInfo(user_id);
		List<UserPeixun> pList = userPeixunDao.getAllByUserId(String.valueOf(user_id));
		List<UserWork> wList = userWorkDao.getAllByUserId(String.valueOf(user_id));
		List<CxtdLeaderZuzhi> zList = cxtddoc01Dao.getAllByUserId(String.valueOf(user_id));
		CxtdMemberNum memNum = cxtddoc01Dao.queryCxtdMemberNum(team_id);
	    List<CxtdMemberInfo> mList = cxtddoc01Dao.queryCxtdMemberInfo(team_id);
		
		doc01.put("baseinfo", baseInfo);
		doc01.put("leaderinfo", leaderInfo);
		doc01.put("plist", pList);
		doc01.put("wlist", wList);
		doc01.put("zlist", zList);
		doc01.put("memnum", memNum);
		doc01.put("mlist", mList);
		return doc01;
		
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void updateDoc01(CxtdDoc01 cxtddoc01,int user_id,JSONObject result){
		int team_id = cxtddoc01Dao.getTimeId(user_id);
		CxtdBaseInfo baseInfo = cxtddoc01.getBaseInfo();
		CxtdLeaderInfo leaderInfo = cxtddoc01.getLeaderInfo();
		List<CxtdLeaderZuzhi> zList = cxtddoc01.getzList();
		List<CxtdMemberInfo> mList = cxtddoc01.getmList();
		CxtdMemberNum memNum = cxtddoc01.getMemNum();
		
		try{
			cxtddoc01Dao.updateCxtdBase(baseInfo,user_id);
			cxtddoc01Dao.updateCxtdLeaderInfo(leaderInfo, user_id);
			for(CxtdLeaderZuzhi zuzhi:zList){
				cxtddoc01Dao.updateCxtdLeaderZuzhi(zuzhi, user_id);
			}
			cxtddoc01Dao.updateCxtdMemberNum(memNum, team_id);
			for(CxtdMemberInfo memInfo:mList){
				cxtddoc01Dao.updateCxtdMemberInfo(memInfo, team_id);
			}
			result.put("result", "更新成功");
		}catch(Exception e){
			System.err.println("=========================异常："+e);
			result.put("result", "更新失败");
		}
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void insertDoc01(CxtdDoc01 cxtddoc01 ,int user_id,JSONObject result){
		CxtdBaseInfo baseInfo = cxtddoc01.getBaseInfo();
		CxtdLeaderInfo leaderInfo = cxtddoc01.getLeaderInfo();
		List<CxtdLeaderZuzhi> zList = cxtddoc01.getzList();
		List<CxtdMemberInfo> mList = cxtddoc01.getmList();
		CxtdMemberNum memNum = cxtddoc01.getMemNum();
		try{
			 cxtddoc01Dao.insertCxtdBase(baseInfo,user_id);
			 int team_id = cxtddoc01Dao.getTimeId(user_id);
			 cxtddoc01Dao.insertCxtdLeaderInfo(leaderInfo, user_id);
			 cxtddoc01Dao.insertCxtdMemberNum(memNum, team_id);
			 for(CxtdLeaderZuzhi zuzhi:zList){
				 cxtddoc01Dao.insertCxtdLeaderZuzhi(zuzhi, user_id);
			 }
			 for(CxtdMemberInfo memInfo:mList){
				 cxtddoc01Dao.insertCxtdMemberInfo(memInfo, team_id);
			 }
			 result.put("result", "添加成功");
		}catch(Exception e){
			System.err.println("==========================异常："+e);
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