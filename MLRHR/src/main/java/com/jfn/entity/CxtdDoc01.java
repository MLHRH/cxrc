package com.jfn.entity;

import java.util.List;

public class CxtdDoc01 {
	private CxtdBaseInfo baseInfo;
	private CxtdLeaderInfo leaderInfo;
	private List<CxtdLeaderZuzhi> zList;
	private CxtdMemberNum memNum;
	private List<CxtdMemberInfo> mList;
	public CxtdBaseInfo getBaseInfo() {
		return baseInfo;
	}
	public void setBaseInfo(CxtdBaseInfo baseInfo) {
		this.baseInfo = baseInfo;
	}
	public CxtdLeaderInfo getLeaderInfo() {
		return leaderInfo;
	}
	public void setLeaderInfo(CxtdLeaderInfo leaderInfo) {
		this.leaderInfo = leaderInfo;
	}
	public List<CxtdLeaderZuzhi> getzList() {
		return zList;
	}
	public void setzList(List<CxtdLeaderZuzhi> zList) {
		this.zList = zList;
	}
	public CxtdMemberNum getMemNum() {
		return memNum;
	}
	public void setMemNum(CxtdMemberNum memNum) {
		this.memNum = memNum;
	}
	public List<CxtdMemberInfo> getmList() {
		return mList;
	}
	public void setmList(List<CxtdMemberInfo> mList) {
		this.mList = mList;
	}

}
