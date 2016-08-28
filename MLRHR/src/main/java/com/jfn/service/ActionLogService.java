package com.jfn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jfn.dao.LogDao;
import com.jfn.entity.ActionLog;


@Repository
public class ActionLogService
{
	@Autowired
	private LogDao dao;
	
	public void log(int userid,String action)
	{
		dao.addLog( userid, action );
	}
	
	public List<ActionLog> getLog(String obj,int id)
	{
		return dao.GetLog(obj, id);
	}
}
