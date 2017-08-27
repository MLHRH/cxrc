package com.jfn.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.jfn.dao.CxtdDao05Dao;
import com.jfn.dao.CxtdDoc01Dao;
import com.jfn.dao.CxtdDoc03Dao;
import com.jfn.dao.CxtdDoc04Dao;
import com.jfn.dao.UserPeixunDao;
import com.jfn.dao.UserWorkDao;
import com.jfn.dao.UserZuzhiDao;
import com.jfn.entity.CxtdBaseInfo;
import com.jfn.entity.CxtdDao05;
import com.jfn.entity.CxtdDoc01;
import com.jfn.entity.CxtdDoc03;
import com.jfn.entity.CxtdDoc04;
import com.jfn.entity.CxtdLeaderInfo;
import com.jfn.entity.CxtdLeaderZuzhi;
import com.jfn.entity.CxtdMemberInfo;
import com.jfn.entity.CxtdMemberNum;
import com.jfn.entity.UesrZuzhi;
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
	@Autowired
	private CxtdDoc03Dao cxtdDoc03Dao;
	@Autowired
	private CxtdDoc04Dao cxtdDoc04Dao;
	@Autowired
	private CxtdDao05Dao cxtdDao05Dao;
	@Autowired
	private UserZuzhiDao zuzhiDao ;
	
	/**
	 * 初始化doc01
	 * @param user_id
	 * @return
	 */
	public Map<String, Object> queryCxtdDoc01(int user_id){
		Map<String, Object> doc01 = new HashMap<String, Object>();
		
		Integer team_id = cxtddoc01Dao.getTimeId(user_id);
		if(team_id != null){
			CxtdBaseInfo baseInfo = cxtddoc01Dao.queryCxtdBase(user_id);
			CxtdLeaderInfo leaderInfo = cxtddoc01Dao.queryCxtdLeaderInfo(user_id);
			List<UserPeixun> pList = userPeixunDao.getAllByUserId(String.valueOf(user_id));
			List<UserWork> wList = userWorkDao.getAllByUserId(String.valueOf(user_id));
			List<UesrZuzhi> zList = zuzhiDao.getAllByUserId(String.valueOf(user_id));
			CxtdMemberNum memNum = cxtddoc01Dao.queryCxtdMemberNum(team_id);
		    List<CxtdMemberInfo> mList = cxtddoc01Dao.queryCxtdMemberInfo(team_id);
		    System.err.print(mList);
			
			doc01.put("baseinfo", baseInfo);
			doc01.put("leaderinfo", leaderInfo);
			doc01.put("plist", pList);
			doc01.put("wlist", wList);
			doc01.put("zlist", zList);
			doc01.put("memnum", memNum);
			doc01.put("mlist", mList);
		}
		return doc01;
		
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void updateDoc01(CxtdDoc01 cxtddoc01,int user_id,JSONObject result){
		Integer team_id = cxtddoc01Dao.getTimeId(user_id);
		CxtdBaseInfo baseInfo = cxtddoc01.getBaseInfo();
		baseInfo.toString();
		CxtdLeaderInfo leaderInfo = cxtddoc01.getLeaderInfo();
		leaderInfo.toString();
		List<CxtdMemberInfo> mList = cxtddoc01.getmList();
		for(CxtdMemberInfo info : mList){
			info.toString();
		}
		CxtdMemberNum memNum = cxtddoc01.getMemNum();
		memNum.toString();
		try{
			if(team_id == null){
				cxtddoc01Dao.insertTeamId(user_id);
				team_id = cxtddoc01Dao.getTimeId(user_id);
			}
			CxtdBaseInfo baseIfo = cxtddoc01Dao.queryCxtdBase(user_id);
			//基本信息更新
			if (baseIfo.getId() == null) {
				cxtddoc01Dao.insertCxtdBase(baseInfo, user_id, team_id);

			}
			else{
				cxtddoc01Dao.updateCxtdBase(baseInfo, user_id);
				// cxtddoc01Dao.updateCxtdBase(baseInfo, user_id);
			}
			//更新团队负责人信息
			CxtdLeaderInfo leadeInfo = cxtddoc01Dao.queryCxtdLeaderInfo(user_id);
			if (leadeInfo.getId() != null) {
				cxtddoc01Dao.updateCxtdLeaderInfo(leaderInfo, user_id);
			}
			else{
				cxtddoc01Dao.insertCxtdLeaderInfo(leaderInfo, user_id,team_id);
			}
		
			//团队人数统计
			CxtdMemberNum mNum = cxtddoc01Dao.queryCxtdMemberNum(team_id);
			if (mNum.getId() != null) {
				cxtddoc01Dao.updateCxtdMemberNum(memNum, team_id);
			}
			else{
				cxtddoc01Dao.insertCxtdMemberNum(memNum, team_id);
			}
			//团队成yuan 	 	
			cxtddoc01Dao.deleteme(team_id);
			for(CxtdMemberInfo mem:mList){
				cxtddoc01Dao.insertCxtdMemberInfo(mem, team_id);
	
				
			}
			result.put("result", "更新成功");
		}catch(Exception e){
			System.err.println("=========================异常："+e);
			result.put("result", "更新失败");
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

	public boolean insertDoc03(CxtdDoc03 cxtdDoc03) {
		return cxtdDoc03Dao.insert(cxtdDoc03);

	}

	public CxtdDoc03 getDao03(int user_id) {
		return cxtdDoc03Dao.getByUserId(user_id);
	}

	public boolean updateDao03(CxtdDoc03 cxtdDoc03) {
		return cxtdDoc03Dao.update(cxtdDoc03);
	}

	public boolean insertDoc04(CxtdDoc04 cxtdDoc04) {
		return cxtdDoc04Dao.insert(cxtdDoc04);
	}

	public CxtdDoc04 getDoc4(int user_id) {
		return cxtdDoc04Dao.getByUserId(user_id);
	}

	public boolean updateDoc4(CxtdDoc04 cxtdDoc04) {
		return cxtdDoc04Dao.update(cxtdDoc04);
	}

	public boolean insertDoc05(CxtdDao05 cxtdDao05) {
		return cxtdDao05Dao.insert(cxtdDao05);
	}

	public CxtdDao05 getDoc05(int user_id) {
		return cxtdDao05Dao.getByUserId(user_id);
	}

	public boolean updateDoc05(CxtdDao05 cxtdDao05) {
		return cxtdDao05Dao.update(cxtdDao05);
	}
}
