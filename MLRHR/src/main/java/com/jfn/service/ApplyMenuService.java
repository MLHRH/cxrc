package com.jfn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jfn.dao.ApplyMenuDao;
import com.jfn.entity.ApplyMenu;

@Repository
public class ApplyMenuService {
	@Autowired
	private ApplyMenuDao applyMenuDao;
	public List<ApplyMenu> getMenu(String applytype){
		return applyMenuDao.getMenu(applytype);
	}

}
